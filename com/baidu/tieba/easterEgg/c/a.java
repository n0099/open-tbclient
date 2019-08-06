package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d eUb;
    private HashMap<String, String> eUc;
    private com.google.gson.d eUd;

    public a(int i) {
        super(i);
        this.eUd = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String vS = vS(httpMessageTask.getUrl());
        if (vS != null && this.eUb != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.eUd.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.eUd.toJson(httpMessage.getParams());
            }
            this.eUb.S(httpMessageTask.getUrl(), this.eUd.toJson(vS), this.eUd.toJson(json));
        }
        return httpMessage;
    }

    public String vS(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.eUc != null) {
            return this.eUc.get(replace);
        }
        return null;
    }

    public void r(HashMap<String, String> hashMap) {
        this.eUc = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.eUb = dVar;
    }
}
