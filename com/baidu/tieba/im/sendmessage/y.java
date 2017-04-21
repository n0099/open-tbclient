package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a dgT;
    private final /* synthetic */ String dhf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.dgT = aVar;
        this.dhf = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: auv */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.m.aqK().a(this.dhf, 2, null, 1000);
    }
}
