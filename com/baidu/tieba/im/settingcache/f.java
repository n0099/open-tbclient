package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends s<Void> {
    final /* synthetic */ c crd;
    private final /* synthetic */ String jI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, String str) {
        this.crd = cVar;
        this.jI = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Io */
    public Void doInBackground() {
        this.crd.aiq().remove(this.jI);
        return null;
    }
}
