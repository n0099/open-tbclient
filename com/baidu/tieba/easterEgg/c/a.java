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
    private com.baidu.tieba.easterEgg.d fSM;
    private HashMap<String, String> fSN;
    private Gson fSO;

    public a(int i) {
        super(i);
        this.fSO = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String Aj = Aj(httpMessageTask.getUrl());
        if (Aj != null && this.fSM != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.fSO.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.fSO.toJson(httpMessage.getParams());
            }
            this.fSM.ak(httpMessageTask.getUrl(), this.fSO.toJson(Aj), this.fSO.toJson(json));
        }
        return httpMessage;
    }

    public String Aj(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.fSN != null) {
            return this.fSN.get(replace);
        }
        return null;
    }

    public void q(HashMap<String, String> hashMap) {
        this.fSN = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.fSM = dVar;
    }
}
