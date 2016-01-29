package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.m<LinkedHashMap<String, String>> {
    final /* synthetic */ a cfe;
    private final /* synthetic */ String cfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.cfe = aVar;
        this.cfo = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: aeP */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.aaT().b(this.cfo, 2, (String) null, 1000);
    }
}
