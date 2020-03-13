package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d fSd;
    private HashMap<String, String> fSe;
    private Gson fSf;

    public a(int i) {
        super(i);
        this.fSf = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String Ai = Ai(httpMessageTask.getUrl());
        if (Ai != null && this.fSd != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.fSf.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.fSf.toJson(httpMessage.getParams());
            }
            this.fSd.ak(httpMessageTask.getUrl(), this.fSf.toJson(Ai), this.fSf.toJson(json));
        }
        return httpMessage;
    }

    public String Ai(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.fSe != null) {
            return this.fSe.get(replace);
        }
        return null;
    }

    public void q(HashMap<String, String> hashMap) {
        this.fSe = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.fSd = dVar;
    }
}
