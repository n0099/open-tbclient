package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a extends d {
    private Gson dEE;
    private com.baidu.tieba.easterEgg.d gZs;
    private HashMap<String, String> gZt;

    public a(int i) {
        super(i);
        this.dEE = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String Ed = Ed(httpMessageTask.getUrl());
        if (Ed != null && this.gZs != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.dEE.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.dEE.toJson(httpMessage.getParams());
            }
            this.gZs.ao(httpMessageTask.getUrl(), this.dEE.toJson(Ed), this.dEE.toJson(json));
        }
        return httpMessage;
    }

    public String Ed(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.gZt != null) {
            return this.gZt.get(replace);
        }
        return null;
    }

    public void H(HashMap<String, String> hashMap) {
        this.gZt = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.gZs = dVar;
    }
}
