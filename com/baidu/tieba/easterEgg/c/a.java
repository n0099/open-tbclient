package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.easterEgg.c;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a extends d {
    private Gson eGB;
    private c izK;
    private HashMap<String, String> izL;

    public a(int i) {
        super(i);
        this.eGB = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String Ir = Ir(httpMessageTask.getUrl());
        if (Ir != null && this.izK != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.eGB.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.eGB.toJson(httpMessage.getParams());
            }
            this.izK.aD(httpMessageTask.getUrl(), this.eGB.toJson(Ir), this.eGB.toJson(json));
        }
        return httpMessage;
    }

    public String Ir(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.izL != null) {
            return this.izL.get(replace);
        }
        return null;
    }

    public void E(HashMap<String, String> hashMap) {
        this.izL = hashMap;
    }

    public void a(c cVar) {
        this.izK = cVar;
    }
}
