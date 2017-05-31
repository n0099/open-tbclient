package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.v<LinkedHashMap<String, String>> {
    private final /* synthetic */ String dgD;
    final /* synthetic */ a dgr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.dgr = aVar;
        this.dgD = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: asn */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.aoC().a(this.dgD, 2, null, 1000);
    }
}
