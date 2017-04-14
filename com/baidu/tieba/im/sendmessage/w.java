package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a deC;
    private final /* synthetic */ String deM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.deC = aVar;
        this.deM = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: atu */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.apu().a(this.deM, 2, (String) null, 1000);
    }
}
