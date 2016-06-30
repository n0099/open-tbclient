package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a cVW;
    private final /* synthetic */ String cWg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.cVW = aVar;
        this.cWg = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: aqF */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.amG().a(this.cWg, 2, null, 1000);
    }
}
