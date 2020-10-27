package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes24.dex */
public class a extends d {
    private Gson eqx;
    private com.baidu.tieba.easterEgg.d iat;
    private HashMap<String, String> iau;

    public a(int i) {
        super(i);
        this.eqx = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String IX = IX(httpMessageTask.getUrl());
        if (IX != null && this.iat != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.eqx.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.eqx.toJson(httpMessage.getParams());
            }
            this.iat.ay(httpMessageTask.getUrl(), this.eqx.toJson(IX), this.eqx.toJson(json));
        }
        return httpMessage;
    }

    public String IX(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.iau != null) {
            return this.iau.get(replace);
        }
        return null;
    }

    public void G(HashMap<String, String> hashMap) {
        this.iau = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.iat = dVar;
    }
}
