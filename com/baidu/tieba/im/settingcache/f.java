package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends t<Void> {
    final /* synthetic */ c cZo;
    private final /* synthetic */ String kj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, String str) {
        this.cZo = cVar;
        this.kj = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Jn */
    public Void doInBackground() {
        this.cZo.ars().remove(this.kj);
        return null;
    }
}
