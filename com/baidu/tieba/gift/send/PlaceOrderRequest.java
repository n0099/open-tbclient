package com.baidu.tieba.gift.send;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.PlaceOrder.DataReq;
import tbclient.PlaceOrder.PlaceOrderReqIdl;
/* loaded from: classes4.dex */
public class PlaceOrderRequest extends NetMessage {
    public long accountId;
    public int accountType;
    public int giftId;
    public long postId;
    public String sceneFrom;
    public int sendCount;
    public long threadId;
    public long toUserId;
    public String toUserName;

    public PlaceOrderRequest() {
        super(CmdConfigHttp.CMD_GIFT_PALCE_ORDER, 309051);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.gift_id = Integer.valueOf(this.giftId);
        builder.benefit_userid = Long.valueOf(this.toUserId);
        builder.benefit_username = this.toUserName;
        builder.scene_from = this.sceneFrom;
        builder.thread_id = Long.valueOf(this.threadId);
        builder.post_id = Long.valueOf(this.postId);
        builder.num = Integer.valueOf(this.sendCount);
        builder.account_id = Long.valueOf(this.accountId);
        builder.account_type = Integer.valueOf(this.accountType);
        if (z) {
            w.a(builder, true);
        }
        PlaceOrderReqIdl.Builder builder2 = new PlaceOrderReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getGiftId() {
        return this.giftId;
    }

    public long getPostId() {
        return this.postId;
    }

    public String getSceneFrom() {
        return this.sceneFrom;
    }

    public int getSendCount() {
        return this.sendCount;
    }

    public long getThreadId() {
        return this.threadId;
    }

    public long getToUserId() {
        return this.toUserId;
    }

    public String getToUserName() {
        return this.toUserName;
    }

    public void setGiftId(int i) {
        this.giftId = i;
    }

    public void setPostId(long j) {
        this.postId = j;
    }

    public void setSceneFrom(String str) {
        this.sceneFrom = str;
    }

    public void setSendCount(int i) {
        this.sendCount = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public void setToUserId(long j) {
        this.toUserId = j;
    }

    public void setToUserName(String str) {
        this.toUserName = str;
    }
}
