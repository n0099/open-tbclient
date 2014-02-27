package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.CommitGroupMsg.CommitGroupMsgReq;
/* loaded from: classes.dex */
public class g extends b {
    private String b;

    public g() {
        e(202001);
    }

    public final String u() {
        return this.b;
    }

    public final void b(String str) {
        this.b = str;
    }

    public MessageLite a() {
        try {
            return CommitGroupMsgReq.CommitGroupMsgReqIdl.newBuilder().a(CommitGroupMsgReq.DataReq.newBuilder().a(k()).a(Integer.valueOf(this.b).intValue()).b(i()).a(j()).build()).build();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.e("data convert error");
            return null;
        }
    }
}
