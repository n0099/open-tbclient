package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a extends d {
    private com.google.gson.d cTd;
    private com.baidu.tieba.easterEgg.d ezr;
    private HashMap<String, String> ezs;

    public a(int i) {
        super(i);
        this.cTd = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String tT = tT(httpMessageTask.getUrl());
        if (tT != null && this.ezr != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.cTd.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.cTd.toJson(httpMessage.getParams());
            }
            this.ezr.S(httpMessageTask.getUrl(), this.cTd.toJson(tT), this.cTd.toJson(json));
        }
        return httpMessage;
    }

    public String tT(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.ezs != null) {
            return this.ezs.get(replace);
        }
        return null;
    }

    public void r(HashMap<String, String> hashMap) {
        this.ezs = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.ezr = dVar;
    }
}
