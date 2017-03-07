package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends s<Void> {
    final /* synthetic */ c dgC;
    private final /* synthetic */ String uq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, String str) {
        this.dgC = cVar;
        this.uq = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: LT */
    public Void doInBackground() {
        this.dgC.atC().remove(this.uq);
        return null;
    }
}
