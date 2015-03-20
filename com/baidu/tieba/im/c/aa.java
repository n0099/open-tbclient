package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.tieba.im.h<LinkedHashMap<String, String>> {
    final /* synthetic */ a bmC;
    private final /* synthetic */ String bmM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.bmC = aVar;
        this.bmM = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Tl */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.m.PY().a(this.bmM, 2, (String) null, 1000);
    }
}
