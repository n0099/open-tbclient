package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes24.dex */
public class a extends d {
    private Gson ewq;
    private com.baidu.tieba.easterEgg.d igu;
    private HashMap<String, String> igv;

    public a(int i) {
        super(i);
        this.ewq = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String Jo = Jo(httpMessageTask.getUrl());
        if (Jo != null && this.igu != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.ewq.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.ewq.toJson(httpMessage.getParams());
            }
            this.igu.az(httpMessageTask.getUrl(), this.ewq.toJson(Jo), this.ewq.toJson(json));
        }
        return httpMessage;
    }

    public String Jo(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.igv != null) {
            return this.igv.get(replace);
        }
        return null;
    }

    public void G(HashMap<String, String> hashMap) {
        this.igv = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.igu = dVar;
    }
}
