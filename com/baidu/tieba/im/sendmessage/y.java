package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a dgf;
    private final /* synthetic */ String dgr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.dgf = aVar;
        this.dgr = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: atB */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.apQ().a(this.dgr, 2, null, 1000);
    }
}
