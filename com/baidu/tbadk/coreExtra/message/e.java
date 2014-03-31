package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.lib.util.f;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import java.util.HashMap;
import java.util.Map;
import protobuf.UpdateClientInfo.UpdateClientInfoReq;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.message.websockt.d {
    private double a;
    private double b;
    private String c;
    private int d;
    private int e;
    private final Map<String, String> f;
    private byte[] g;
    private int h;

    public e() {
        super(1001);
        this.f = new HashMap();
        try {
            TbadkApplication.j();
            if (TbadkApplication.X()) {
                TbadkApplication.j();
                this.a = com.baidu.adp.lib.f.b.a(TbadkApplication.W(), 0.0d);
                TbadkApplication.j();
                this.b = com.baidu.adp.lib.f.b.a(TbadkApplication.Y(), 0.0d);
            }
        } catch (Exception e) {
            f.b(e.class.getName(), "ctor()", e.getMessage());
        }
    }

    public final void d(int i) {
        this.h = 3;
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

    private String i() {
        try {
            return new Gson().toJson(this.f);
        } catch (Exception e) {
            f.b(e.class.getName(), "getDevice", e.getMessage());
            return null;
        }
    }

    public final void e(int i) {
        this.d = i;
    }

    public final void f(int i) {
        this.e = i;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return UpdateClientInfoReq.UpdateClientInfoReqIdl.newBuilder().a(TbadkApplication.y()).a(UpdateClientInfoReq.DataReq.newBuilder().a(this.c).b(i()).a(ByteString.copyFrom(this.g)).b(this.e).a(this.d).a(this.a).b(this.b).build()).build();
    }
}
