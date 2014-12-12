package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.im.h<LinkedHashMap<String, String>> {
    final /* synthetic */ a bni;
    private final /* synthetic */ String bns;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.bni = aVar;
        this.bns = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ST */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.o.MO().a(this.bns, 2, (String) null, 1000);
    }
}
