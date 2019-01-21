package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends d {
    private com.google.gson.d bHH;
    private com.baidu.tieba.easterEgg.d dpM;
    private HashMap<String, String> dpN;

    public a(int i) {
        super(i);
        this.bHH = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String nt = nt(httpMessageTask.getUrl());
        if (nt != null && this.dpM != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.bHH.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.bHH.toJson(httpMessage.getParams());
            }
            this.dpM.H(httpMessageTask.getUrl(), this.bHH.toJson(nt), this.bHH.toJson(json));
        }
        return httpMessage;
    }

    public String nt(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.dpN != null) {
            return this.dpN.get(replace);
        }
        return null;
    }

    public void q(HashMap<String, String> hashMap) {
        this.dpN = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.dpM = dVar;
    }
}
