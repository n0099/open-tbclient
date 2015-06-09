package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.h<LinkedHashMap<String, String>> {
    private final /* synthetic */ String bpI;
    final /* synthetic */ a bpy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.bpy = aVar;
        this.bpI = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: UM */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.m.RB().a(this.bpI, 2, (String) null, 1000);
    }
}
