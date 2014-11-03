package com.baidu.tieba.im.chat;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.tieba.im.b<LinkedHashMap<String, String>> {
    final /* synthetic */ w aOa;
    private final /* synthetic */ String aOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(w wVar, String str) {
        this.aOa = wVar;
        this.aOn = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Jt */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.n.MT().a(this.aOn, 2, (String) null, 1000);
    }
}
