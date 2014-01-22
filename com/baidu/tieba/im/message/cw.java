package com.baidu.tieba.im.message;

import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import java.util.HashMap;
import java.util.Map;
import protobuf.UpdateClientInfo.UpdateClientInfoReq;
/* loaded from: classes.dex */
public class cw extends q implements com.baidu.tieba.im.coder.g, IDuplicateProcess {
    private double a;
    private double b;
    private String c;
    private int d;
    private int e;
    private Map<String, String> f = new HashMap();
    private byte[] g;

    public cw() {
        e(1001);
        try {
            if (TiebaApplication.h().bg()) {
                this.a = com.baidu.adp.lib.f.b.a(TiebaApplication.h().bf(), 0.0d);
                this.b = com.baidu.adp.lib.f.b.a(TiebaApplication.h().bh(), 0.0d);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(cw.class.getName(), "ctor()", e.getMessage());
        }
    }

    public double b() {
        return this.a;
    }

    public double c() {
        return this.b;
    }

    public byte[] d() {
        return this.g;
    }

    public void a(byte[] bArr) {
        this.g = bArr;
    }

    public String e() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(String str, String str2) {
        this.f.put(str, str2);
    }

    public String f() {
        try {
            return new Gson().toJson(this.f);
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(cw.class.getName(), "getDevice", e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public IDuplicateProcess.RemoveState h() {
        return IDuplicateProcess.RemoveState.REMOVE_ME;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public boolean a(q qVar) {
        return true;
    }

    public int g() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int i() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return UpdateClientInfoReq.UpdateClientInfoReqIdl.newBuilder().a(com.baidu.tieba.im.i.a()).a(UpdateClientInfoReq.DataReq.newBuilder().a(e()).b(f()).a(ByteString.copyFrom(d())).b(i()).a(g()).a(b()).b(c()).build()).build();
    }
}
