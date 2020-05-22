package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d gMk;
    private HashMap<String, String> gMl;
    private Gson gMm;

    public a(int i) {
        super(i);
        this.gMm = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String DC = DC(httpMessageTask.getUrl());
        if (DC != null && this.gMk != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.gMm.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.gMm.toJson(httpMessage.getParams());
            }
            this.gMk.an(httpMessageTask.getUrl(), this.gMm.toJson(DC), this.gMm.toJson(json));
        }
        return httpMessage;
    }

    public String DC(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.gMl != null) {
            return this.gMl.get(replace);
        }
        return null;
    }

    public void H(HashMap<String, String> hashMap) {
        this.gMl = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.gMk = dVar;
    }
}
