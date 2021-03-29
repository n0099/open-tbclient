package com.baidu.tieba.homepage;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetMyPost.DataReq;
import tbclient.GetMyPost.GetMyPostReqIdl;
/* loaded from: classes3.dex */
public class RequestGetMyPostNetMessage extends NetMessage {
    public String bFrom;
    public int callFrom;
    public boolean hideErrorToast;
    public long mForumId;
    public long mPostId;
    public int mQType;
    public double mScrDip;
    public int mScrH;
    public int mScrW;
    public long mThreadId;
    public int proZone;

    public RequestGetMyPostNetMessage() {
        super(CmdConfigHttp.CMD_GET_MY_POST, 303111);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mForumId);
        builder.thread_id = Long.valueOf(this.mThreadId);
        builder.post_id = Long.valueOf(this.mPostId);
        builder.scr_w = Integer.valueOf(this.mScrW);
        builder.scr_h = Integer.valueOf(this.mScrH);
        builder.scr_dip = Double.valueOf(this.mScrDip);
        builder.q_type = Integer.valueOf(this.mQType);
        builder.bfrom = this.bFrom;
        builder.call_from = Integer.valueOf(this.callFrom);
        GetMyPostReqIdl.Builder builder2 = new GetMyPostReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getProZone() {
        return this.proZone;
    }

    public void setBFrom(String str) {
        this.bFrom = str;
    }

    public void setCallFrom(int i) {
        this.callFrom = i;
    }

    public void setHideErrorToast(boolean z) {
        this.hideErrorToast = z;
    }

    public void setParams(long j, long j2, long j3, int i, int i2, double d2, int i3) {
        this.mPostId = j2;
        this.mThreadId = j;
        this.mForumId = j3;
        this.mScrW = i;
        this.mScrH = i2;
        this.mScrDip = d2;
        this.mQType = i3;
    }

    public void setProZone(int i) {
        this.proZone = i;
    }

    public boolean showErrorToast() {
        return !this.hideErrorToast;
    }
}
