package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.m<LinkedHashMap<String, String>> {
    final /* synthetic */ a caF;
    private final /* synthetic */ String caQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.caF = aVar;
        this.caQ = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: abJ */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.Yw().b(this.caQ, 2, null, 1000);
    }
}
