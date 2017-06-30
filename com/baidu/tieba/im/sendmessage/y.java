package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.w<LinkedHashMap<String, String>> {
    final /* synthetic */ a don;
    private final /* synthetic */ String doz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.don = aVar;
        this.doz = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.w
    /* renamed from: avY */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.m.aso().a(this.doz, 2, null, 1000);
    }
}
