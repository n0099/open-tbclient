package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d fMk;
    private HashMap<String, String> fMl;
    private Gson fMm;

    public a(int i) {
        super(i);
        this.fMm = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String zH = zH(httpMessageTask.getUrl());
        if (zH != null && this.fMk != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.fMm.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.fMm.toJson(httpMessage.getParams());
            }
            this.fMk.aj(httpMessageTask.getUrl(), this.fMm.toJson(zH), this.fMm.toJson(json));
        }
        return httpMessage;
    }

    public String zH(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.fMl != null) {
            return this.fMl.get(replace);
        }
        return null;
    }

    public void q(HashMap<String, String> hashMap) {
        this.fMl = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.fMk = dVar;
    }
}
