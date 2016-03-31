package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.p<LinkedHashMap<String, String>> {
    final /* synthetic */ a cpJ;
    private final /* synthetic */ String cpT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.cpJ = aVar;
        this.cpT = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: aii */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.aep().a(this.cpT, 2, null, 1000);
    }
}
