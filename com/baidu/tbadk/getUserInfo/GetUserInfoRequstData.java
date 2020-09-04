package com.baidu.tbadk.getUserInfo;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.util.t;
import tbclient.GetUserInfo.DataReq;
import tbclient.GetUserInfo.GetUserInfoReqIdl;
/* loaded from: classes.dex */
public class GetUserInfoRequstData extends NetMessage {
    private long mUid;
    private int screenWidth;

    public GetUserInfoRequstData(int i, int i2) {
        super(i, i2);
    }

    public void setUid(long j) {
        this.mUid = j;
    }

    public long getUid() {
        return this.mUid;
    }

    public void setScreenWidth(int i) {
        this.screenWidth = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            t.a(builder, true);
        }
        GetUserInfoReqIdl.Builder builder2 = new GetUserInfoReqIdl.Builder();
        builder.uid = Long.valueOf(this.mUid);
        builder.scr_w = Integer.valueOf(this.screenWidth);
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
