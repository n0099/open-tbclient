package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.h<LinkedHashMap<String, String>> {
    private final /* synthetic */ String bpH;
    final /* synthetic */ a bpx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.bpx = aVar;
        this.bpH = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: UL */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.m.RA().a(this.bpH, 2, (String) null, 1000);
    }
}
