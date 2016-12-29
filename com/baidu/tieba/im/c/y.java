package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a cWB;
    private final /* synthetic */ String cWN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.cWB = aVar;
        this.cWN = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: ata */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.app().a(this.cWN, 2, null, 1000);
    }
}
