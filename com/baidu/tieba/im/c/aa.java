package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.t<LinkedHashMap<String, String>> {
    final /* synthetic */ a cYR;
    private final /* synthetic */ String cZd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.cYR = aVar;
        this.cZd = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: arr */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.anE().a(this.cZd, 2, null, 1000);
    }
}
