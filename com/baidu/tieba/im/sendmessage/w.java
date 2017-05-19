package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.v<LinkedHashMap<String, String>> {
    final /* synthetic */ a daU;
    private final /* synthetic */ String dbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.daU = aVar;
        this.dbe = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: arp */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.ano().a(this.dbe, 2, (String) null, 1000);
    }
}
