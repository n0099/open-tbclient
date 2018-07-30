package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d cQo;
    private HashMap<String, String> cQp;
    private com.google.gson.d cQq;

    public a(int i) {
        super(i);
        this.cQq = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String lu = lu(httpMessageTask.getUrl());
        if (lu != null && this.cQo != null) {
            this.cQo.z(httpMessageTask.getUrl(), this.cQq.toJson(lu), this.cQq.toJson(this.cQq.toJson(httpMessage.getParams())));
        }
        return httpMessage;
    }

    public String lu(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.cQp != null) {
            return this.cQp.get(replace);
        }
        return null;
    }

    public void n(HashMap<String, String> hashMap) {
        this.cQp = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.cQo = dVar;
    }
}
