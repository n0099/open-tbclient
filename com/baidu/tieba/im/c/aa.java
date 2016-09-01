package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.t<LinkedHashMap<String, String>> {
    final /* synthetic */ a dkA;
    private final /* synthetic */ String dkM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.dkA = aVar;
        this.dkM = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: awf */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.ast().a(this.dkM, 2, null, 1000);
    }
}
