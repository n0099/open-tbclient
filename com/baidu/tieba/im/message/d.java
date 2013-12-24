package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.CommitGroupMsg.CommitGroupMsgReq;
/* loaded from: classes.dex */
public class d extends b {
    private String a;

    public d() {
        e(202001);
    }

    public String s() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        try {
            return CommitGroupMsgReq.CommitGroupMsgReqIdl.newBuilder().a(CommitGroupMsgReq.DataReq.newBuilder().a(j()).a(Integer.valueOf(s()).intValue()).b(h()).a(i()).build()).build();
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.d("data convert error");
            return null;
        }
    }
}
