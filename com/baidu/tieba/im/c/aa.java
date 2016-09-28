package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.t<LinkedHashMap<String, String>> {
    final /* synthetic */ a dlX;
    private final /* synthetic */ String dmj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.dlX = aVar;
        this.dmj = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: awE */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.asS().a(this.dmj, 2, null, 1000);
    }
}
