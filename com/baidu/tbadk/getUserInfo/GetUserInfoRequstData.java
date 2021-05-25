package com.baidu.tbadk.getUserInfo;

import com.baidu.adp.framework.message.NetMessage;
import d.a.m0.z0.w;
import tbclient.GetUserInfo.DataReq;
import tbclient.GetUserInfo.GetUserInfoReqIdl;
/* loaded from: classes3.dex */
public class GetUserInfoRequstData extends NetMessage {
    public long mUid;
    public int screenWidth;

    public GetUserInfoRequstData(int i2, int i3) {
        super(i2, i3);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        GetUserInfoReqIdl.Builder builder2 = new GetUserInfoReqIdl.Builder();
        builder.uid = Long.valueOf(this.mUid);
        builder.scr_w = Integer.valueOf(this.screenWidth);
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getUid() {
        return this.mUid;
    }

    public void setScreenWidth(int i2) {
        this.screenWidth = i2;
    }

    public void setUid(long j) {
        this.mUid = j;
    }
}
