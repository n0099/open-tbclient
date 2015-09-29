package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.l<LinkedHashMap<String, String>> {
    final /* synthetic */ a bGU;
    private final /* synthetic */ String bHf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.bGU = aVar;
        this.bHf = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Xe */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.TT().b(this.bHf, 2, null, 1000);
    }
}
