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
    private Gson ehZ;
    private com.baidu.tieba.easterEgg.d hNW;
    private HashMap<String, String> hNX;

    public a(int i) {
        super(i);
        this.ehZ = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String Iy = Iy(httpMessageTask.getUrl());
        if (Iy != null && this.hNW != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.ehZ.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.ehZ.toJson(httpMessage.getParams());
            }
            this.hNW.ar(httpMessageTask.getUrl(), this.ehZ.toJson(Iy), this.ehZ.toJson(json));
        }
        return httpMessage;
    }

    public String Iy(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.hNX != null) {
            return this.hNX.get(replace);
        }
        return null;
    }

    public void G(HashMap<String, String> hashMap) {
        this.hNX = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.hNW = dVar;
    }
}
