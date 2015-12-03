package com.baidu.tbadk.getUserInfo;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.util.i;
import tbclient.GetUserInfo.DataReq;
import tbclient.GetUserInfo.GetUserInfoReqIdl;
/* loaded from: classes.dex */
public class GetUserInfoRequstData extends NetMessage {
    private long mUid;

    public GetUserInfoRequstData(int i, int i2) {
        super(i, i2);
    }

    public void setUid(long j) {
        this.mUid = j;
    }

    public long getUid() {
        return this.mUid;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            i.a(builder, true);
        }
        GetUserInfoReqIdl.Builder builder2 = new GetUserInfoReqIdl.Builder();
        builder.uid = Long.valueOf(this.mUid);
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
