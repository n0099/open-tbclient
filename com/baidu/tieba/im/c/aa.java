package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a cVW;
    private final /* synthetic */ String cWi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.cVW = aVar;
        this.cWi = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: aqF */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.amT().a(this.cWi, 2, null, 1000);
    }
}
