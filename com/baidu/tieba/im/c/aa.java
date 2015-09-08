package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.h<LinkedHashMap<String, String>> {
    final /* synthetic */ a bDS;
    private final /* synthetic */ String bEc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.bDS = aVar;
        this.bEc = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Wv */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.Tl().b(this.bEc, 2, null, 1000);
    }
}
