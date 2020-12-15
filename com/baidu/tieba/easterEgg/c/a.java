package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.easterEgg.c;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes24.dex */
public class a extends d {
    private Gson eBJ;
    private c ise;
    private HashMap<String, String> isf;

    public a(int i) {
        super(i);
        this.eBJ = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String JF = JF(httpMessageTask.getUrl());
        if (JF != null && this.ise != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.eBJ.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.eBJ.toJson(httpMessage.getParams());
            }
            this.ise.aB(httpMessageTask.getUrl(), this.eBJ.toJson(JF), this.eBJ.toJson(json));
        }
        return httpMessage;
    }

    public String JF(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.isf != null) {
            return this.isf.get(replace);
        }
        return null;
    }

    public void F(HashMap<String, String> hashMap) {
        this.isf = hashMap;
    }

    public void a(c cVar) {
        this.ise = cVar;
    }
}
