package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements t.b {
    final /* synthetic */ l bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bHc = lVar;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aI(boolean z) {
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        cVar = this.bHc.bGK;
        str = this.bHc.bGM;
        cVar.dm(!StringUtils.isNull(str));
    }
}
