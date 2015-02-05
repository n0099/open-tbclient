package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.im.h<LinkedHashMap<String, String>> {
    final /* synthetic */ a boE;
    private final /* synthetic */ String boO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.boE = aVar;
        this.boO = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Tk */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.o.Nf().a(this.boO, 2, (String) null, 1000);
    }
}
