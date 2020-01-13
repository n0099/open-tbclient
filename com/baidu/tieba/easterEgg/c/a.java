package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d fPt;
    private HashMap<String, String> fPu;
    private Gson fPv;

    public a(int i) {
        super(i);
        this.fPv = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String zR = zR(httpMessageTask.getUrl());
        if (zR != null && this.fPt != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.fPv.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.fPv.toJson(httpMessage.getParams());
            }
            this.fPt.ak(httpMessageTask.getUrl(), this.fPv.toJson(zR), this.fPv.toJson(json));
        }
        return httpMessage;
    }

    public String zR(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.fPu != null) {
            return this.fPu.get(replace);
        }
        return null;
    }

    public void q(HashMap<String, String> hashMap) {
        this.fPu = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.fPt = dVar;
    }
}
