package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d eYt;
    private HashMap<String, String> eYu;
    private com.google.gson.d eYv;

    public a(int i) {
        super(i);
        this.eYv = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String uP = uP(httpMessageTask.getUrl());
        if (uP != null && this.eYt != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.eYv.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.eYv.toJson(httpMessage.getParams());
            }
            this.eYt.V(httpMessageTask.getUrl(), this.eYv.toJson(uP), this.eYv.toJson(json));
        }
        return httpMessage;
    }

    public String uP(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.eYu != null) {
            return this.eYu.get(replace);
        }
        return null;
    }

    public void r(HashMap<String, String> hashMap) {
        this.eYu = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.eYt = dVar;
    }
}
