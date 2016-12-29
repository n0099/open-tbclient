package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a cWB;
    private final /* synthetic */ String cWL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.cWB = aVar;
        this.cWL = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: ata */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.apa().a(this.cWL, 2, null, 1000);
    }
}
