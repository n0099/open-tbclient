package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a dgT;
    private final /* synthetic */ String dhf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.dgT = aVar;
        this.dhf = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: auv */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.aqJ().a(this.dhf, 2, null, 1000);
    }
}
