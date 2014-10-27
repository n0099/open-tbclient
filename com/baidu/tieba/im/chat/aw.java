package com.baidu.tieba.im.chat;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.tieba.im.b<LinkedHashMap<String, String>> {
    final /* synthetic */ w aNM;
    private final /* synthetic */ String aNZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(w wVar, String str) {
        this.aNM = wVar;
        this.aNZ = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Jp */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.n.MP().a(this.aNZ, 2, (String) null, 1000);
    }
}
