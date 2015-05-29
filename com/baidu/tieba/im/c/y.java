package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.im.h<LinkedHashMap<String, String>> {
    private final /* synthetic */ String bpH;
    final /* synthetic */ a bpx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.bpx = aVar;
        this.bpH = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: UL */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.n.RB().a(this.bpH, 2, (String) null, 1000);
    }
}
