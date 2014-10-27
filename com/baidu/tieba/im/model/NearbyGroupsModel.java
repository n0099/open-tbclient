package com.baidu.tieba.im.model;

import android.content.Context;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.GroupsByLocationLocalMessage;
import com.baidu.tieba.im.message.RequestNearbyGroupsMessage;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
/* loaded from: classes.dex */
public class NearbyGroupsModel extends e {
    private static final int IMAGE_HEIGHT = 70;
    private static final int IMAGE_WIDTH = 70;
    public static final int rn = 30;
    private int geo;
    private boolean hasMore;
    private int height;
    private int index;
    private boolean isHaveReadCache;
    private boolean isLoading;
    private String lat;
    private String lng;
    private int offset;
    private GroupsByLocationLocalMessage sendLocationMsg;
    private RequestUserPermissionMessage sendUserMsg;
    private RequestNearbyGroupsMessage sentMsg;
    private int width;

    public NearbyGroupsModel(Context context) {
        super(context);
        this.index = 0;
        this.isHaveReadCache = false;
        this.isLoading = false;
        this.width = m.dip2px(TbadkApplication.m251getInst().getContext(), 70.0f);
        this.height = m.dip2px(TbadkApplication.m251getInst().getContext(), 70.0f);
    }

    public boolean getIsLoading() {
        return this.isLoading;
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public int getGeo() {
        return this.geo;
    }

    public void setGeo(int i) {
        this.geo = i;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public boolean getIsHaveReadCache() {
        return this.isHaveReadCache;
    }

    public void setIsHaveReadCache(boolean z) {
        this.isHaveReadCache = z;
    }

    private RequestNearbyGroupsMessage createMessage(int i) {
        RequestNearbyGroupsMessage requestNearbyGroupsMessage = new RequestNearbyGroupsMessage();
        requestNearbyGroupsMessage.setHeight(this.height);
        requestNearbyGroupsMessage.setWidth(this.width);
        requestNearbyGroupsMessage.setLat(this.lat);
        requestNearbyGroupsMessage.setLng(this.lng);
        requestNearbyGroupsMessage.setOffset(i * 30);
        requestNearbyGroupsMessage.setRn(30);
        requestNearbyGroupsMessage.setGeo(this.geo);
        return requestNearbyGroupsMessage;
    }

    private RequestUserPermissionMessage createUserPermissionMessage(long j) {
        RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
        requestUserPermissionMessage.setForumId(j);
        return requestUserPermissionMessage;
    }

    public int getIndex() {
        return this.index;
    }

    public void sendMessage() {
        this.index = 0;
        this.geo = 0;
        this.sentMsg = createMessage(this.index);
        super.sendMessage(this.sentMsg);
    }

    public void sendNextPageMessage() {
        setNextPage();
        this.sentMsg = createMessage(this.index);
        super.sendMessage(this.sentMsg);
    }

    public void sendUserPermissionMessage(long j) {
        this.sendUserMsg = createUserPermissionMessage(j);
        super.sendMessage(this.sendUserMsg);
    }

    public void sendCacheMsg() {
        this.isHaveReadCache = true;
        this.sendLocationMsg = new GroupsByLocationLocalMessage();
        super.sendMessage(this.sendLocationMsg);
    }

    public void setNextPage() {
        this.index++;
    }

    public boolean update() {
        if (this.isHaveReadCache) {
            if (j.fh()) {
                sendMessage();
                return true;
            }
            return false;
        }
        sendCacheMsg();
        return true;
    }

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
        super.cancelMessage();
        this.sentMsg = null;
        this.sendUserMsg = null;
        this.sendLocationMsg = null;
    }
}
