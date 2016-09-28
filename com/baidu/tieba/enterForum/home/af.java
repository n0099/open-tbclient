package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements y.b {
    final /* synthetic */ l bHk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(l lVar) {
        this.bHk = lVar;
    }

    @Override // com.baidu.tbadk.core.view.y.b
    public void aI(boolean z) {
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        cVar = this.bHk.bGT;
        str = this.bHk.bGV;
        cVar.dn(!StringUtils.isNull(str));
    }
}
