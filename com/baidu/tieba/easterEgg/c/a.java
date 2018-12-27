package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends d {
    private com.google.gson.d bGT;
    private com.baidu.tieba.easterEgg.d doZ;
    private HashMap<String, String> dpa;

    public a(int i) {
        super(i);
        this.bGT = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String nd = nd(httpMessageTask.getUrl());
        if (nd != null && this.doZ != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.bGT.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.bGT.toJson(httpMessage.getParams());
            }
            this.doZ.H(httpMessageTask.getUrl(), this.bGT.toJson(nd), this.bGT.toJson(json));
        }
        return httpMessage;
    }

    public String nd(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.dpa != null) {
            return this.dpa.get(replace);
        }
        return null;
    }

    public void q(HashMap<String, String> hashMap) {
        this.dpa = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.doZ = dVar;
    }
}
