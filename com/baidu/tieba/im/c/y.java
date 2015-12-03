package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.m<LinkedHashMap<String, String>> {
    final /* synthetic */ a bWG;
    private final /* synthetic */ String bWR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.bWG = aVar;
        this.bWR = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: aaB */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.Xr().b(this.bWR, 2, null, 1000);
    }
}
