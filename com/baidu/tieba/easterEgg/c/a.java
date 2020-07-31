package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes18.dex */
public class a extends d {
    private Gson dKB;
    private com.baidu.tieba.easterEgg.d heX;
    private HashMap<String, String> heY;

    public a(int i) {
        super(i);
        this.dKB = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String EO = EO(httpMessageTask.getUrl());
        if (EO != null && this.heX != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.dKB.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.dKB.toJson(httpMessage.getParams());
            }
            this.heX.ap(httpMessageTask.getUrl(), this.dKB.toJson(EO), this.dKB.toJson(json));
        }
        return httpMessage;
    }

    public String EO(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.heY != null) {
            return this.heY.get(replace);
        }
        return null;
    }

    public void G(HashMap<String, String> hashMap) {
        this.heY = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.heX = dVar;
    }
}
