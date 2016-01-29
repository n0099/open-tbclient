package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.m<LinkedHashMap<String, String>> {
    final /* synthetic */ a cfe;
    private final /* synthetic */ String cfq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.cfe = aVar;
        this.cfq = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: aeP */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.abi().b(this.cfq, 2, null, 1000);
    }
}
