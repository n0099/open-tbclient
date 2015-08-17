package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.im.h<LinkedHashMap<String, String>> {
    final /* synthetic */ a bDl;
    private final /* synthetic */ String val$groupId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.bDl = aVar;
        this.val$groupId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Wt */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.SV().b(this.val$groupId, 2, (String) null, 1000);
    }
}
