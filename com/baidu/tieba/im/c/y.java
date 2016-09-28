package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.t<LinkedHashMap<String, String>> {
    final /* synthetic */ a dlX;
    private final /* synthetic */ String dmj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.dlX = aVar;
        this.dmj = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: awE */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.asT().a(this.dmj, 2, null, 1000);
    }
}
