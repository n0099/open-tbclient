package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.t<LinkedHashMap<String, String>> {
    final /* synthetic */ a dkA;
    private final /* synthetic */ String dkK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.dkA = aVar;
        this.dkK = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: awf */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.asf().a(this.dkK, 2, null, 1000);
    }
}
