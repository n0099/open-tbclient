package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a deC;
    private final /* synthetic */ String deO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.deC = aVar;
        this.deO = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: atu */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.m.apJ().a(this.deO, 2, null, 1000);
    }
}
