package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.im.h<LinkedHashMap<String, String>> {
    private final /* synthetic */ String bpI;
    final /* synthetic */ a bpy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.bpy = aVar;
        this.bpI = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: UM */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.n.RC().a(this.bpI, 2, (String) null, 1000);
    }
}
