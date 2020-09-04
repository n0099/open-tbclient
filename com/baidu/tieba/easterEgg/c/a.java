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
    private Gson dTN;
    private com.baidu.tieba.easterEgg.d hrW;
    private HashMap<String, String> hrX;

    public a(int i) {
        super(i);
        this.dTN = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String Ho = Ho(httpMessageTask.getUrl());
        if (Ho != null && this.hrW != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.dTN.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.dTN.toJson(httpMessage.getParams());
            }
            this.hrW.ap(httpMessageTask.getUrl(), this.dTN.toJson(Ho), this.dTN.toJson(json));
        }
        return httpMessage;
    }

    public String Ho(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.hrX != null) {
            return this.hrX.get(replace);
        }
        return null;
    }

    public void E(HashMap<String, String> hashMap) {
        this.hrX = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.hrW = dVar;
    }
}
