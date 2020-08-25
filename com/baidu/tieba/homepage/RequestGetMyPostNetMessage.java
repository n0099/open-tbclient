package com.baidu.tieba.homepage;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import tbclient.GetMyPost.DataReq;
import tbclient.GetMyPost.GetMyPostReqIdl;
/* loaded from: classes2.dex */
public class RequestGetMyPostNetMessage extends NetMessage {
    private String bFrom;
    private long mForumId;
    private long mPostId;
    private int mQType;
    private double mScrDip;
    private int mScrH;
    private int mScrW;
    private long mThreadId;
    private int proZone;

    public RequestGetMyPostNetMessage() {
        super(1003010, CmdConfigSocket.CMD_GET_MY_POST);
    }

    public void setParams(long j, long j2, long j3, int i, int i2, double d, int i3) {
        this.mPostId = j2;
        this.mThreadId = j;
        this.mForumId = j3;
        this.mScrW = i;
        this.mScrH = i2;
        this.mScrDip = d;
        this.mQType = i3;
    }

    public void setProZone(int i) {
        this.proZone = i;
    }

    public int getProZone() {
        return this.proZone;
    }

    public void setBFrom(String str) {
        this.bFrom = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mForumId);
        builder.thread_id = Long.valueOf(this.mThreadId);
        builder.post_id = Long.valueOf(this.mPostId);
        builder.scr_w = Integer.valueOf(this.mScrW);
        builder.scr_h = Integer.valueOf(this.mScrH);
        builder.scr_dip = Double.valueOf(this.mScrDip);
        builder.q_type = Integer.valueOf(this.mQType);
        builder.bfrom = this.bFrom;
        GetMyPostReqIdl.Builder builder2 = new GetMyPostReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
