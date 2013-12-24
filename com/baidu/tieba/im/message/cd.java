package com.baidu.tieba.im.message;

import com.baidu.gson.Gson;
import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import java.util.HashMap;
import java.util.Map;
import protobuf.UpdateClientInfo.UpdateClientInfoReq;
/* loaded from: classes.dex */
public class cd extends n implements com.baidu.tieba.im.coder.g, IDuplicateProcess {
    private String a;
    private int b;
    private int c;
    private Map<String, String> d = new HashMap();
    private byte[] e;

    public cd() {
        e(1001);
    }

    public byte[] b() {
        return this.e;
    }

    public void a(byte[] bArr) {
        this.e = bArr;
    }

    public String c() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(String str, String str2) {
        this.d.put(str, str2);
    }

    public String d() {
        try {
            return new Gson().toJson(this.d);
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(cd.class.getName(), "getDevice", e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public IDuplicateProcess.RemoveState h() {
        return IDuplicateProcess.RemoveState.REMOVE_ME;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public boolean a(n nVar) {
        return true;
    }

    public int e() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int f() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return UpdateClientInfoReq.UpdateClientInfoReqIdl.newBuilder().a(com.baidu.tieba.im.i.a()).a(UpdateClientInfoReq.DataReq.newBuilder().a(c()).b(d()).a(ByteString.copyFrom(b())).b(f()).a(e()).build()).build();
    }
}
