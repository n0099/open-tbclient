package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d eTU;
    private HashMap<String, String> eTV;
    private com.google.gson.d eTW;

    public a(int i) {
        super(i);
        this.eTW = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String vR = vR(httpMessageTask.getUrl());
        if (vR != null && this.eTU != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.eTW.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.eTW.toJson(httpMessage.getParams());
            }
            this.eTU.S(httpMessageTask.getUrl(), this.eTW.toJson(vR), this.eTW.toJson(json));
        }
        return httpMessage;
    }

    public String vR(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.eTV != null) {
            return this.eTV.get(replace);
        }
        return null;
    }

    public void r(HashMap<String, String> hashMap) {
        this.eTV = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.eTU = dVar;
    }
}
