package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d eOU;
    private HashMap<String, String> eOV;
    private com.google.gson.d eOW;

    public a(int i) {
        super(i);
        this.eOW = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String vm = vm(httpMessageTask.getUrl());
        if (vm != null && this.eOU != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.eOW.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.eOW.toJson(httpMessage.getParams());
            }
            this.eOU.S(httpMessageTask.getUrl(), this.eOW.toJson(vm), this.eOW.toJson(json));
        }
        return httpMessage;
    }

    public String vm(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.eOV != null) {
            return this.eOV.get(replace);
        }
        return null;
    }

    public void r(HashMap<String, String> hashMap) {
        this.eOV = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.eOU = dVar;
    }
}
