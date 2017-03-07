package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a dgf;
    private final /* synthetic */ String dgp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.dgf = aVar;
        this.dgp = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: atB */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.apB().a(this.dgp, 2, (String) null, 1000);
    }
}
