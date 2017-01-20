package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a ddN;
    private final /* synthetic */ String ddZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(a aVar, String str) {
        this.ddN = aVar;
        this.ddZ = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: aug */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.l.aqw().a(this.ddZ, 2, null, 1000);
    }
}
