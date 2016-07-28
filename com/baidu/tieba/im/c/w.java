package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.t<LinkedHashMap<String, String>> {
    final /* synthetic */ a cYR;
    private final /* synthetic */ String cZb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.cYR = aVar;
        this.cZb = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: arr */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.anq().a(this.cZb, 2, null, 1000);
    }
}
