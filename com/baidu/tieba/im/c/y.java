package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.im.h<LinkedHashMap<String, String>> {
    final /* synthetic */ a bmS;
    private final /* synthetic */ String bnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.bmS = aVar;
        this.bnc = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Ty */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.n.Qm().a(this.bnc, 2, (String) null, 1000);
    }
}
