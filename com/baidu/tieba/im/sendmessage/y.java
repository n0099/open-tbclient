package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.v<LinkedHashMap<String, String>> {
    final /* synthetic */ a daU;
    private final /* synthetic */ String dbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.daU = aVar;
        this.dbg = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: arp */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.m.anD().a(this.dbg, 2, null, 1000);
    }
}
