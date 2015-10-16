package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.l<LinkedHashMap<String, String>> {
    final /* synthetic */ a bHf;
    private final /* synthetic */ String bHq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.bHf = aVar;
        this.bHq = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Xe */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.TU().b(this.bHq, 2, null, 1000);
    }
}
