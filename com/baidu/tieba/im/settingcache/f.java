package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends v<Void> {
    final /* synthetic */ c dgO;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, String str) {
        this.dgO = cVar;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: KF */
    public Void doInBackground() {
        this.dgO.aso().remove(this.val$key);
        return null;
    }
}
