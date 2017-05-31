package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.v<LinkedHashMap<String, String>> {
    private final /* synthetic */ String dgB;
    final /* synthetic */ a dgr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.dgr = aVar;
        this.dgB = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: asn */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.aoo().a(this.dgB, 2, (String) null, 1000);
    }
}
