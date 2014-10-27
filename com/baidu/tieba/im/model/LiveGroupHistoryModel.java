package com.baidu.tieba.im.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.g.c;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.live.message.RequestLiveGroupHistoryMessage;
/* loaded from: classes.dex */
public class LiveGroupHistoryModel extends e {
    public static final String GROUP_ID = "group_id";
    public static final int PAGE_LEN = 20;
    private String groupId;
    private boolean hasMore;
    private LiveCardData liveCardData;
    private int pageNum;
    private int start;

    public LiveGroupHistoryModel(Context context) {
        super(context);
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int i) {
        this.start = i;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int i) {
        this.pageNum = i;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public LiveCardData getLiveCardData() {
        return this.liveCardData;
    }

    public void setLiveCardData(LiveCardData liveCardData) {
        this.liveCardData = liveCardData;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void saveInstance(Bundle bundle) {
    }

    public void sendMessage(String str, int i, int i2) {
        RequestLiveGroupHistoryMessage requestLiveGroupHistoryMessage = new RequestLiveGroupHistoryMessage();
        requestLiveGroupHistoryMessage.setGroupId(c.a(str, 0L));
        requestLiveGroupHistoryMessage.setOffset(i);
        requestLiveGroupHistoryMessage.setRn(i2);
        super.sendMessage(requestLiveGroupHistoryMessage);
    }

    public void initWithIntent(Intent intent) {
        this.groupId = intent.getStringExtra("group_id");
    }

    public void initWithBundle(Bundle bundle) {
        this.groupId = bundle.getString("group_id");
    }
}
