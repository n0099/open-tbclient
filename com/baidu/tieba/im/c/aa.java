package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.h<LinkedHashMap<String, String>> {
    final /* synthetic */ a bDl;
    private final /* synthetic */ String bDv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.bDl = aVar;
        this.bDv = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Wt */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.Tj().b(this.bDv, 2, null, 1000);
    }
}
