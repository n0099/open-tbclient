package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.im.h<LinkedHashMap<String, String>> {
    final /* synthetic */ a boF;
    private final /* synthetic */ String boP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.boF = aVar;
        this.boP = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Tp */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.o.Nk().a(this.boP, 2, (String) null, 1000);
    }
}
