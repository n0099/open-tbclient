package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a drH;
    private final /* synthetic */ String drT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.drH = aVar;
        this.drT = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: ayB */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.auQ().a(this.drT, 2, null, 1000);
    }
}
