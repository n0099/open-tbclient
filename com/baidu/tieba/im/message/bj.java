package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.UpdateMaskInfo.UpdateMaskInfoReq;
/* loaded from: classes.dex */
public class bj extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private int b;
    private String c;

    public bj() {
        e(104102);
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return UpdateMaskInfoReq.UpdateMaskInfoReqIdl.newBuilder().a(UpdateMaskInfoReq.DataReq.newBuilder().a(b()).b(c()).a(d()).build()).build();
    }

    public int b() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public int c() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public void a(boolean z) {
        this.b = z ? 1 : 0;
    }

    public String d() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }
}
