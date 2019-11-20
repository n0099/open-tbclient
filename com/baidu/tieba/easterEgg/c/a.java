package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d eXC;
    private HashMap<String, String> eXD;
    private com.google.gson.d eXE;

    public a(int i) {
        super(i);
        this.eXE = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String uP = uP(httpMessageTask.getUrl());
        if (uP != null && this.eXC != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.eXE.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.eXE.toJson(httpMessage.getParams());
            }
            this.eXC.V(httpMessageTask.getUrl(), this.eXE.toJson(uP), this.eXE.toJson(json));
        }
        return httpMessage;
    }

    public String uP(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.eXD != null) {
            return this.eXD.get(replace);
        }
        return null;
    }

    public void r(HashMap<String, String> hashMap) {
        this.eXD = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.eXC = dVar;
    }
}
