package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.easterEgg.c;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes23.dex */
public class a extends d {
    private Gson euH;
    private c ihi;
    private HashMap<String, String> ihj;

    public a(int i) {
        super(i);
        this.euH = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String IP = IP(httpMessageTask.getUrl());
        if (IP != null && this.ihi != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.euH.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.euH.toJson(httpMessage.getParams());
            }
            this.ihi.az(httpMessageTask.getUrl(), this.euH.toJson(IP), this.euH.toJson(json));
        }
        return httpMessage;
    }

    public String IP(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.ihj != null) {
            return this.ihj.get(replace);
        }
        return null;
    }

    public void F(HashMap<String, String> hashMap) {
        this.ihj = hashMap;
    }

    public void a(c cVar) {
        this.ihi = cVar;
    }
}
