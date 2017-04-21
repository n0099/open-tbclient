package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a dgT;
    private final /* synthetic */ String dhd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.dgT = aVar;
        this.dhd = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: auv */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.aqv().a(this.dhd, 2, (String) null, 1000);
    }
}
