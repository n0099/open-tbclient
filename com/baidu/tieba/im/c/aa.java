package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.p<LinkedHashMap<String, String>> {
    final /* synthetic */ a cpJ;
    private final /* synthetic */ String cpV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.cpJ = aVar;
        this.cpV = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: aii */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.aeD().a(this.cpV, 2, (String) null, 1000);
    }
}
