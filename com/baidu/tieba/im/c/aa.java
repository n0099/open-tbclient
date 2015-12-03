package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.m<LinkedHashMap<String, String>> {
    final /* synthetic */ a bWG;
    private final /* synthetic */ String bWR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.bWG = aVar;
        this.bWR = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: aaB */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.Xq().b(this.bWR, 2, null, 1000);
    }
}
