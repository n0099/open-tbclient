package com.baidu.tieba.easterEgg.c;

import com.baidu.adp.framework.a.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends d {
    private com.baidu.tieba.easterEgg.d cPK;
    private HashMap<String, String> cPL;
    private com.google.gson.d cPM;

    public a(int i) {
        super(i);
        this.cPM = new com.google.gson.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        String lz = lz(httpMessageTask.getUrl());
        if (lz != null && this.cPK != null) {
            this.cPK.A(httpMessageTask.getUrl(), this.cPM.toJson(lz), this.cPM.toJson(this.cPM.toJson(httpMessage.getParams())));
        }
        return httpMessage;
    }

    public String lz(String str) {
        if (str.contains("?")) {
            str = str.split("[?]")[0];
        }
        String replace = str.replace(TbConfig.SERVER_ADDRESS, "");
        if (this.cPL != null) {
            return this.cPL.get(replace);
        }
        return null;
    }

    public void l(HashMap<String, String> hashMap) {
        this.cPL = hashMap;
    }

    public void a(com.baidu.tieba.easterEgg.d dVar) {
        this.cPK = dVar;
    }
}
