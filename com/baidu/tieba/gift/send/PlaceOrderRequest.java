package com.baidu.tieba.gift.send;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.i;
import tbclient.PlaceOrder.DataReq;
import tbclient.PlaceOrder.PlaceOrderReqIdl;
/* loaded from: classes.dex */
public class PlaceOrderRequest extends NetMessage {
    private int giftId;
    private long postId;
    private String sceneFrom;
    private int sendCount;
    private long threadId;
    private long toUserId;
    private String toUserName;

    public PlaceOrderRequest() {
        super(CmdConfigHttp.CMD_GIFT_PALCE_ORDER, 309051);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.gift_id = Integer.valueOf(this.giftId);
        builder.benefit_userid = Long.valueOf(this.toUserId);
        builder.benefit_username = this.toUserName;
        builder.scene_from = this.sceneFrom;
        builder.thread_id = Long.valueOf(this.threadId);
        builder.post_id = Long.valueOf(this.postId);
        builder.num = Integer.valueOf(this.sendCount);
        if (z) {
            i.a(builder, true);
        }
        PlaceOrderReqIdl.Builder builder2 = new PlaceOrderReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getGiftId() {
        return this.giftId;
    }

    public void setGiftId(int i) {
        this.giftId = i;
    }

    public long getToUserId() {
        return this.toUserId;
    }

    public void setToUserId(long j) {
        this.toUserId = j;
    }

    public String getToUserName() {
        return this.toUserName;
    }

    public void setToUserName(String str) {
        this.toUserName = str;
    }

    public String getSceneFrom() {
        return this.sceneFrom;
    }

    public void setSceneFrom(String str) {
        this.sceneFrom = str;
    }

    public long getThreadId() {
        return this.threadId;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public long getPostId() {
        return this.postId;
    }

    public void setPostId(long j) {
        this.postId = j;
    }

    public int getSendCount() {
        return this.sendCount;
    }

    public void setSendCount(int i) {
        this.sendCount = i;
    }
}
