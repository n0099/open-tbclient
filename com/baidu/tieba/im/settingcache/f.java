package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends v<Void> {
    final /* synthetic */ c dbr;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, String str) {
        this.dbr = cVar;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: LK */
    public Void doInBackground() {
        this.dbr.arq().remove(this.val$key);
        return null;
    }
}
