package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a cqG;
    private final /* synthetic */ String cqS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.cqG = aVar;
        this.cqS = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: aip */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.aeD().a(this.cqS, 2, (String) null, 1000);
    }
}
