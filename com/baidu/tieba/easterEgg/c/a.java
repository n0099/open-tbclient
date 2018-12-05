package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends d {
    private com.google.gson.d bGQ;
    private com.baidu.tieba.easterEgg.d dmh;
    private HashMap<String, String> dmi;

    public a(int i) {
        super(i);
        this.bGQ = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String na = na(httpMessageTask.getUrl());
        if (na != null && this.dmh != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.bGQ.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.bGQ.toJson(httpMessage.getParams());
            }
            this.dmh.H(httpMessageTask.getUrl(), this.bGQ.toJson(na), this.bGQ.toJson(json));
        }
        return httpMessage;
    }

    public String na(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.dmi != null) {
            return this.dmi.get(replace);
        }
        return null;
    }

    public void q(HashMap<String, String> hashMap) {
        this.dmi = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.dmh = dVar;
    }
}
