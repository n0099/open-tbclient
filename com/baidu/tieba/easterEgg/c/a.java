package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d cNF;
    private HashMap<String, String> cNG;
    private com.google.gson.d cNH;

    public a(int i) {
        super(i);
        this.cNH = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String lv = lv(httpMessageTask.getUrl());
        if (lv != null && this.cNF != null) {
            this.cNF.y(httpMessageTask.getUrl(), this.cNH.toJson(lv), this.cNH.toJson(this.cNH.toJson(httpMessage.getParams())));
        }
        return httpMessage;
    }

    public String lv(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.cNG != null) {
            return this.cNG.get(replace);
        }
        return null;
    }

    public void l(HashMap<String, String> hashMap) {
        this.cNG = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.cNF = dVar;
    }
}
