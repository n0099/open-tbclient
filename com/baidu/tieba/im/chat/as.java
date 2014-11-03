package com.baidu.tieba.im.chat;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends com.baidu.tieba.im.b<LinkedHashMap<String, String>> {
    final /* synthetic */ w aOa;
    private final /* synthetic */ String aOl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(w wVar, String str) {
        this.aOa = wVar;
        this.aOl = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Jt */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.MA().a(this.aOl, 2, null, 1000);
    }
}
