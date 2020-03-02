package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d fRQ;
    private HashMap<String, String> fRR;
    private Gson fRS;

    public a(int i) {
        super(i);
        this.fRS = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String Ah = Ah(httpMessageTask.getUrl());
        if (Ah != null && this.fRQ != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.fRS.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.fRS.toJson(httpMessage.getParams());
            }
            this.fRQ.ak(httpMessageTask.getUrl(), this.fRS.toJson(Ah), this.fRS.toJson(json));
        }
        return httpMessage;
    }

    public String Ah(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.fRR != null) {
            return this.fRR.get(replace);
        }
        return null;
    }

    public void q(HashMap<String, String> hashMap) {
        this.fRR = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.fRQ = dVar;
    }
}
