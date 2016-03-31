package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends p<Void> {
    final /* synthetic */ c cqg;
    private final /* synthetic */ String tU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, String str) {
        this.cqg = cVar;
        this.tU = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: JX */
    public Void doInBackground() {
        this.cqg.aij().remove(this.tU);
        return null;
    }
}
