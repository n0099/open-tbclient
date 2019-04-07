package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a extends d {
    private com.google.gson.d cTc;
    private com.baidu.tieba.easterEgg.d ezq;
    private HashMap<String, String> ezr;

    public a(int i) {
        super(i);
        this.cTc = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String tT = tT(httpMessageTask.getUrl());
        if (tT != null && this.ezq != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.cTc.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.cTc.toJson(httpMessage.getParams());
            }
            this.ezq.S(httpMessageTask.getUrl(), this.cTc.toJson(tT), this.cTc.toJson(json));
        }
        return httpMessage;
    }

    public String tT(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.ezr != null) {
            return this.ezr.get(replace);
        }
        return null;
    }

    public void r(HashMap<String, String> hashMap) {
        this.ezr = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.ezq = dVar;
    }
}
