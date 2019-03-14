package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.im.frsgroup.MembersActivity;
import com.baidu.tieba.im.message.RequestMembersMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import java.util.List;
/* loaded from: classes5.dex */
public class MembersModel extends BdBaseModel<MembersActivity> {
    public static final String GROUP_ID = "group_id";
    public static final int LEN_FIRST = 50;
    public static final int LEN_MORE = 20;
    private static final String LEN_POSITION = "len_position";
    public static final int ORDER_JOIN = 2;
    public static final int ORDER_LOGIN = 0;
    public static final int ORDER_SPEAK = 1;
    private static final String START_POSITIONL = "start_position";
    private boolean mController;
    private long mGroupId;
    private int mLen;
    private int mOrderType;
    private RequestMembersMessage mRequestM;
    private int mStart;
    private boolean mUseCache;
    private List<Long> userIds;

    public MembersModel(MembersActivity membersActivity) {
        super(membersActivity.getPageContext());
    }

    public RequestMembersMessage getRequestM() {
        return this.mRequestM;
    }

    public void setRequestM(RequestMembersMessage requestMembersMessage) {
        this.mRequestM = requestMembersMessage;
    }

    public int getOrderType() {
        return this.mOrderType;
    }

    public void setOrderType(int i) {
        this.mOrderType = i;
    }

    public boolean isController() {
        return this.mController;
    }

    public void setController(boolean z) {
        this.mController = z;
    }

    public List<Long> getUserIds() {
        return this.userIds;
    }

    public void setUserIds(List<Long> list) {
        this.userIds = list;
    }

    public boolean isUseCache() {
        return this.mUseCache;
    }

    public void setUseCache(boolean z) {
        this.mUseCache = z;
    }

    public int getStart() {
        return this.mStart;
    }

    public void setStart(int i) {
        this.mStart = i;
    }

    public void addStart(int i) {
        this.mStart += i;
    }

    public int getLen() {
        return this.mLen;
    }

    public void setLen(int i) {
        this.mLen = i;
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        this.mGroupId = intent.getLongExtra("group_id", 0L);
    }

    public void initWithBundle(Bundle bundle) {
        this.mGroupId = bundle.getLong("group_id", 0L);
        this.mStart = bundle.getInt(START_POSITIONL, 0);
        this.mLen = bundle.getInt(LEN_POSITION, 0);
    }

    private RequestMembersMessage createMessage(long j, int i, int i2, int i3) {
        RequestMembersMessage requestMembersMessage = new RequestMembersMessage();
        requestMembersMessage.setGroupId(j);
        requestMembersMessage.setOffset(i);
        requestMembersMessage.setRn(i2);
        requestMembersMessage.setOrderType(i3);
        return requestMembersMessage;
    }

    private RequestRemoveMembersMessage createRemoveMessage(long j, String str) {
        RequestRemoveMembersMessage requestRemoveMembersMessage = new RequestRemoveMembersMessage();
        requestRemoveMembersMessage.setGroupId(j);
        requestRemoveMembersMessage.setUserIds(str);
        return requestRemoveMembersMessage;
    }

    public void sendMessage(long j, int i, int i2, int i3) {
        super.sendMessage(createMessage(j, i, i2, i3));
    }

    public void sendRemoveMessage(long j, String str) {
        super.sendMessage(createRemoveMessage(j, str));
    }

    public void saveInstance(Bundle bundle) {
        bundle.putLong("group_id", this.mGroupId);
        bundle.putInt(START_POSITIONL, this.mStart);
        bundle.putInt(LEN_POSITION, this.mLen);
    }
}
