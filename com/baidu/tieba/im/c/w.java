package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a drH;
    private final /* synthetic */ String drR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.drH = aVar;
        this.drR = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: ayB */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.auB().a(this.drR, 2, null, 1000);
    }
}
