package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a ddN;
    private final /* synthetic */ String ddX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a aVar, String str) {
        this.ddN = aVar;
        this.ddX = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: aug */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.c.aqh().a(this.ddX, 2, (String) null, 1000);
    }
}
