package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.google.gson.Gson;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d gxu;
    private HashMap<String, String> gxv;
    private Gson gxw;

    public a(int i) {
        super(i);
        this.gxw = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String BQ = BQ(httpMessageTask.getUrl());
        if (BQ != null && this.gxu != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.gxw.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.gxw.toJson(httpMessage.getParams());
            }
            this.gxu.aj(httpMessageTask.getUrl(), this.gxw.toJson(BQ), this.gxw.toJson(json));
        }
        return httpMessage;
    }

    public String BQ(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.gxv != null) {
            return this.gxv.get(replace);
        }
        return null;
    }

    public void F(HashMap<String, String> hashMap) {
        this.gxv = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.gxu = dVar;
    }
}
