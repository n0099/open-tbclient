package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.v<LinkedHashMap<String, String>> {
    final /* synthetic */ a daU;
    private final /* synthetic */ String dbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.daU = aVar;
        this.dbg = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: arp */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.anC().a(this.dbg, 2, null, 1000);
    }
}
