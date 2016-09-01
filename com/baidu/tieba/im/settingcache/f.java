package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends t<Void> {
    final /* synthetic */ c dkX;
    private final /* synthetic */ String mB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, String str) {
        this.dkX = cVar;
        this.mB = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: LP */
    public Void doInBackground() {
        this.dkX.awg().remove(this.mB);
        return null;
    }
}
