package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import java.util.HashMap;
import org.json.JSONObject;
import protobuf.LogStat.LogStatReq;
/* loaded from: classes.dex */
public final class az extends com.baidu.tbadk.message.websockt.d {
    private String a;
    private String b;

    public az() {
        super(104001);
    }

    private az(String str, String str2) {
        super(104001);
        this.a = str;
        this.b = str2;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return LogStatReq.LogStatReqIdl.newBuilder().a(LogStatReq.DataReq.newBuilder().a(this.a).b(this.b).build()).build();
    }

    public static void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("st_param", str2);
        hashMap.put("jobid", "0");
        com.baidu.adp.framework.c.a().a(new az(str, new JSONObject(hashMap).toString()));
    }
}
