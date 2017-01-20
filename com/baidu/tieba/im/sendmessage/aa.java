package com.baidu.tieba.im.sendmessage;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.s<LinkedHashMap<String, String>> {
    final /* synthetic */ a ddN;
    private final /* synthetic */ String ddZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(a aVar, String str) {
        this.ddN = aVar;
        this.ddZ = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: aug */
    public LinkedHashMap<String, String> doInBackground() {
        return com.baidu.tieba.im.db.k.aqv().a(this.ddZ, 2, null, 1000);
    }
}
