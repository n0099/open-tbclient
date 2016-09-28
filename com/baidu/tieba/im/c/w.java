package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.t<LinkedHashMap<String, String>> {
    final /* synthetic */ a dlX;
    private final /* synthetic */ String dmh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.dlX = aVar;
        this.dmh = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: awE */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.asE().a(this.dmh, 2, null, 1000);
    }
}
