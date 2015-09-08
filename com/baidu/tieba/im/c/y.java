package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.im.h<LinkedHashMap<String, String>> {
    final /* synthetic */ a bDS;
    private final /* synthetic */ String bEc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.bDS = aVar;
        this.bEc = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Wv */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.Tm().b(this.bEc, 2, null, 1000);
    }
}
