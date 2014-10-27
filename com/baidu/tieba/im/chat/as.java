package com.baidu.tieba.im.chat;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends com.baidu.tieba.im.b<LinkedHashMap<String, String>> {
    final /* synthetic */ w aNM;
    private final /* synthetic */ String aNX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(w wVar, String str) {
        this.aNM = wVar;
        this.aNX = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Jp */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.Mw().a(this.aNX, 2, null, 1000);
    }
}
