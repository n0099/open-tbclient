package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends m<Void> {
    final /* synthetic */ c cfB;
    private final /* synthetic */ String tL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, String str) {
        this.cfB = cVar;
        this.tL = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: IB */
    public Void doInBackground() {
        this.cfB.aeQ().remove(this.tL);
        return null;
    }
}
