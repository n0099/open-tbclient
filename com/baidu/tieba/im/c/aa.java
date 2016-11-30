package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a drH;
    private final /* synthetic */ String drT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.drH = aVar;
        this.drT = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: ayB */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.auP().a(this.drT, 2, null, 1000);
    }
}
