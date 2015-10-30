package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.l<LinkedHashMap<String, String>> {
    final /* synthetic */ a bHf;
    private final /* synthetic */ String bHq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.bHf = aVar;
        this.bHq = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Xa */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.TP().b(this.bHq, 2, null, 1000);
    }
}
