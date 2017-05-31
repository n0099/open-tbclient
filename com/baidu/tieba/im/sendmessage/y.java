package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.v<LinkedHashMap<String, String>> {
    private final /* synthetic */ String dgD;
    final /* synthetic */ a dgr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.dgr = aVar;
        this.dgD = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: asn */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.m.aoD().a(this.dgD, 2, null, 1000);
    }
}
