package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.GetMaskInfo.GetMaskInfoReq;
/* loaded from: classes.dex */
public class ah extends q implements com.baidu.tieba.im.coder.g {
    private int a;

    public ah() {
        e(104103);
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return GetMaskInfoReq.GetMaskInfoReqIdl.newBuilder().a(GetMaskInfoReq.DataReq.newBuilder().a(b()).build()).build();
    }

    public int b() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }
}
