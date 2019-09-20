package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d eVH;
    private HashMap<String, String> eVI;
    private com.google.gson.d eVJ;

    public a(int i) {
        super(i);
        this.eVJ = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String wr = wr(httpMessageTask.getUrl());
        if (wr != null && this.eVH != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.eVJ.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.eVJ.toJson(httpMessage.getParams());
            }
            this.eVH.U(httpMessageTask.getUrl(), this.eVJ.toJson(wr), this.eVJ.toJson(json));
        }
        return httpMessage;
    }

    public String wr(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.eVI != null) {
            return this.eVI.get(replace);
        }
        return null;
    }

    public void r(HashMap<String, String> hashMap) {
        this.eVI = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.eVH = dVar;
    }
}
