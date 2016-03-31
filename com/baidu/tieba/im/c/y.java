package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.p<LinkedHashMap<String, String>> {
    final /* synthetic */ a cpJ;
    private final /* synthetic */ String cpV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.cpJ = aVar;
        this.cpV = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: aii */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.aeE().a(this.cpV, 2, (String) null, 1000);
    }
}
