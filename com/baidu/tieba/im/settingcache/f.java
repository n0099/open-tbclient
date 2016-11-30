package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends s<Void> {
    final /* synthetic */ c dsd;
    private final /* synthetic */ String mD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, String str) {
        this.dsd = cVar;
        this.mD = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Nb */
    public Void doInBackground() {
        this.dsd.ayC().remove(this.mD);
        return null;
    }
}
