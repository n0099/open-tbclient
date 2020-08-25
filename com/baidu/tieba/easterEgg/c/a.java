package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes18.dex */
public class a extends d {
    private Gson dTJ;
    private com.baidu.tieba.easterEgg.d hrQ;
    private HashMap<String, String> hrR;

    public a(int i) {
        super(i);
        this.dTJ = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String Hn = Hn(httpMessageTask.getUrl());
        if (Hn != null && this.hrQ != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.dTJ.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.dTJ.toJson(httpMessage.getParams());
            }
            this.hrQ.ap(httpMessageTask.getUrl(), this.dTJ.toJson(Hn), this.dTJ.toJson(json));
        }
        return httpMessage;
    }

    public String Hn(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.hrR != null) {
            return this.hrR.get(replace);
        }
        return null;
    }

    public void E(HashMap<String, String> hashMap) {
        this.hrR = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.hrQ = dVar;
    }
}
