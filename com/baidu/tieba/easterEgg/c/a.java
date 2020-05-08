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
    private com.baidu.tieba.easterEgg.d gxA;
    private HashMap<String, String> gxB;
    private Gson gxC;

    public a(int i) {
        super(i);
        this.gxC = new Gson();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String json;
        String BT = BT(httpMessageTask.getUrl());
        if (BT != null && this.gxA != null) {
            if (httpMessage.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) httpMessage.getExtra();
                if (netMessage.getSocketMessage() == null) {
                    json = "";
                } else {
                    json = this.gxC.toJson(netMessage.getSocketMessage().getData());
                }
            } else {
                json = this.gxC.toJson(httpMessage.getParams());
            }
            this.gxA.aj(httpMessageTask.getUrl(), this.gxC.toJson(BT), this.gxC.toJson(json));
        }
        return httpMessage;
    }

    public String BT(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.gxB != null) {
            return this.gxB.get(replace);
        }
        return null;
    }

    public void F(HashMap<String, String> hashMap) {
        this.gxB = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.gxA = dVar;
    }
}
