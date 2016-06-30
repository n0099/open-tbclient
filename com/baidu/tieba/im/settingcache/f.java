package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends s<Void> {
    final /* synthetic */ c cWt;
    private final /* synthetic */ String jG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, String str) {
        this.cWt = cVar;
        this.jG = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Jo */
    public Void doInBackground() {
        this.cWt.aqG().remove(this.jG);
        return null;
    }
}
