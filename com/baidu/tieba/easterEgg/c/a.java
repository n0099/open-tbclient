package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends d {
    private com.google.gson.d bDn;
    private com.baidu.tieba.easterEgg.d dfA;
    private HashMap<String, String> dfB;

    public a(int i) {
        super(i);
        this.bDn = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String mB = mB(httpMessageTask.getUrl());
        if (mB != null && this.dfA != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.bDn.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.bDn.toJson(httpMessage.getParams());
            }
            this.dfA.G(httpMessageTask.getUrl(), this.bDn.toJson(mB), this.bDn.toJson(json));
        }
        return httpMessage;
    }

    public String mB(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.dfB != null) {
            return this.dfB.get(replace);
        }
        return null;
    }

    public void p(HashMap<String, String> hashMap) {
        this.dfB = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.dfA = dVar;
    }
}
