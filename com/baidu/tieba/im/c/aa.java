package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.l<LinkedHashMap<String, String>> {
    final /* synthetic */ a bHA;
    private final /* synthetic */ String bHL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.bHA = aVar;
        this.bHL = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Xv */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.Uk().b(this.bHL, 2, null, 1000);
    }
}
