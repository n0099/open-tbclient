package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes23.dex */
public class a extends d {
    private Gson dVX;
    private com.baidu.tieba.easterEgg.d hzb;
    private HashMap<String, String> hzc;

    public a(int i) {
        super(i);
        this.dVX = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String HL = HL(httpMessageTask.getUrl());
        if (HL != null && this.hzb != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.dVX.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.dVX.toJson(httpMessage.getParams());
            }
            this.hzb.ap(httpMessageTask.getUrl(), this.dVX.toJson(HL), this.dVX.toJson(json));
        }
        return httpMessage;
    }

    public String HL(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.hzc != null) {
            return this.hzc.get(replace);
        }
        return null;
    }

    public void E(HashMap<String, String> hashMap) {
        this.hzc = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.hzb = dVar;
    }
}
