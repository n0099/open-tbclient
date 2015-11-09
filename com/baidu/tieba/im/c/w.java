package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.l<LinkedHashMap<String, String>> {
    final /* synthetic */ a bHA;
    private final /* synthetic */ String val$groupId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.bHA = aVar;
        this.val$groupId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Xv */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.TW().b(this.val$groupId, 2, (String) null, 1000);
    }
}
