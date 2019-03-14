package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a extends d {
    private com.google.gson.d cTa;
    private com.baidu.tieba.easterEgg.d ezF;
    private HashMap<String, String> ezG;

    public a(int i) {
        super(i);
        this.cTa = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String tU = tU(httpMessageTask.getUrl());
        if (tU != null && this.ezF != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.cTa.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.cTa.toJson(httpMessage.getParams());
            }
            this.ezF.S(httpMessageTask.getUrl(), this.cTa.toJson(tU), this.cTa.toJson(json));
        }
        return httpMessage;
    }

    public String tU(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.ezG != null) {
            return this.ezG.get(replace);
        }
        return null;
    }

    public void r(HashMap<String, String> hashMap) {
        this.ezG = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.ezF = dVar;
    }
}
