package com.baidu.tieba.gift.send;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.SendFreeGift.DataReq;
import tbclient.SendFreeGift.SendFreeGiftReqIdl;
/* loaded from: classes9.dex */
public class SendFreeGiftRequest extends NetMessage {
    private int giftId;
    private long postId;
    private String sceneFrom;
    private int sendCount;
    private long threadId;
    private long toUserId;
    private String toUserName;

    public SendFreeGiftRequest() {
        super(1003052, CmdConfigSocket.CMD_SEND_FREE_GIFT);
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
            v.b(builder, true);
        }
        SendFreeGiftReqIdl.Builder builder2 = new SendFreeGiftReqIdl.Builder();
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
