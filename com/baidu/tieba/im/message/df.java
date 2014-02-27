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
public class df extends s implements com.baidu.tieba.im.coder.g, IDuplicateProcess {
    private double a;
    private double b;
    private String c;
    private int d;
    private int e;
    private Map<String, String> f = new HashMap();
    private byte[] g;

    public df() {
        e(1001);
        try {
            if (TiebaApplication.g().aV()) {
                this.a = com.baidu.adp.lib.f.b.a(TiebaApplication.g().aU(), 0.0d);
                this.b = com.baidu.adp.lib.f.b.a(TiebaApplication.g().aW(), 0.0d);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(df.class.getName(), "ctor()", e.getMessage());
        }
    }

    public final void a(byte[] bArr) {
        this.g = bArr;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void a(String str, String str2) {
        this.f.put(str, str2);
    }

    private String b() {
        try {
            return new Gson().toJson(this.f);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(df.class.getName(), "getDevice", e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public final IDuplicateProcess.RemoveState c() {
        return IDuplicateProcess.RemoveState.REMOVE_ME;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void b(int i) {
        this.e = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return UpdateClientInfoReq.UpdateClientInfoReqIdl.newBuilder().a(com.baidu.tieba.im.e.b()).a(UpdateClientInfoReq.DataReq.newBuilder().a(this.c).b(b()).a(ByteString.copyFrom(this.g)).b(this.e).a(this.d).a(this.a).b(this.b).build()).build();
    }
}
