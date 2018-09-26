package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d cWc;
    private HashMap<String, String> cWd;
    private com.google.gson.d cWe;

    public a(int i) {
        super(i);
        this.cWe = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String lY = lY(httpMessageTask.getUrl());
        if (lY != null && this.cWc != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.cWe.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.cWe.toJson(httpMessage.getParams());
            }
            this.cWc.z(httpMessageTask.getUrl(), this.cWe.toJson(lY), this.cWe.toJson(json));
        }
        return httpMessage;
    }

    public String lY(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.cWd != null) {
            return this.cWd.get(replace);
        }
        return null;
    }

    public void r(HashMap<String, String> hashMap) {
        this.cWd = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.cWc = dVar;
    }
}
