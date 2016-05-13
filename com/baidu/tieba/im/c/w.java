package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a cqG;
    private final /* synthetic */ String cqQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.cqG = aVar;
        this.cqQ = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: air */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.aer().a(this.cqQ, 2, (String) null, 1000);
    }
}
