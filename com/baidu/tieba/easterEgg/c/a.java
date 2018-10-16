package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends d {
    private com.google.gson.d bCB;
    private com.baidu.tieba.easterEgg.d dev;
    private HashMap<String, String> dew;

    public a(int i) {
        super(i);
        this.bCB = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String mA = mA(httpMessageTask.getUrl());
        if (mA != null && this.dev != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.bCB.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.bCB.toJson(httpMessage.getParams());
            }
            this.dev.G(httpMessageTask.getUrl(), this.bCB.toJson(mA), this.bCB.toJson(json));
        }
        return httpMessage;
    }

    public String mA(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.dew != null) {
            return this.dew.get(replace);
        }
        return null;
    }

    public void r(HashMap<String, String> hashMap) {
        this.dew = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.dev = dVar;
    }
}
