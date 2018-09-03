package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d cQl;
    private HashMap<String, String> cQm;
    private com.google.gson.d cQn;

    public a(int i) {
        super(i);
        this.cQn = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String lw = lw(httpMessageTask.getUrl());
        if (lw != null && this.cQl != null) {
            this.cQl.z(httpMessageTask.getUrl(), this.cQn.toJson(lw), this.cQn.toJson(this.cQn.toJson(httpMessage.getParams())));
        }
        return httpMessage;
    }

    public String lw(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.cQm != null) {
            return this.cQm.get(replace);
        }
        return null;
    }

    public void n(HashMap<String, String> hashMap) {
        this.cQm = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.cQl = dVar;
    }
}
