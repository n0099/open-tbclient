package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.easterEgg.c;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a extends d {
    private Gson eLm;
    private c iEr;
    private HashMap<String, String> iEs;

    public a(int i) {
        super(i);
        this.eLm = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String JD = JD(httpMessageTask.getUrl());
        if (JD != null && this.iEr != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.eLm.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.eLm.toJson(httpMessage.getParams());
            }
            this.iEr.aE(httpMessageTask.getUrl(), this.eLm.toJson(JD), this.eLm.toJson(json));
        }
        return httpMessage;
    }

    public String JD(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.iEs != null) {
            return this.iEs.get(replace);
        }
        return null;
    }

    public void E(HashMap<String, String> hashMap) {
        this.iEs = hashMap;
    }

    public void a(c cVar) {
        this.iEr = cVar;
    }
}
