package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.easterEgg.c;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a extends d {
    private Gson eKi;
    private c iHr;
    private HashMap<String, String> iHs;

    public a(int i) {
        super(i);
        this.eKi = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String Jm = Jm(httpMessageTask.getUrl());
        if (Jm != null && this.iHr != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.eKi.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.eKi.toJson(httpMessage.getParams());
            }
            this.iHr.aE(httpMessageTask.getUrl(), this.eKi.toJson(Jm), this.eKi.toJson(json));
        }
        return httpMessage;
    }

    public String Jm(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.iHs != null) {
            return this.iHs.get(replace);
        }
        return null;
    }

    public void G(HashMap<String, String> hashMap) {
        this.iHs = hashMap;
    }

    public void a(c cVar) {
        this.iHr = cVar;
    }
}
