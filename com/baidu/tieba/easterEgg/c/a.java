package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d eOT;
    private HashMap<String, String> eOU;
    private com.google.gson.d eOV;

    public a(int i) {
        super(i);
        this.eOV = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String vn = vn(httpMessageTask.getUrl());
        if (vn != null && this.eOT != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.eOV.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.eOV.toJson(httpMessage.getParams());
            }
            this.eOT.S(httpMessageTask.getUrl(), this.eOV.toJson(vn), this.eOV.toJson(json));
        }
        return httpMessage;
    }

    public String vn(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.eOU != null) {
            return this.eOU.get(replace);
        }
        return null;
    }

    public void r(HashMap<String, String> hashMap) {
        this.eOU = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.eOT = dVar;
    }
}
