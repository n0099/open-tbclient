package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements z.b {
    final /* synthetic */ l bKe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(l lVar) {
        this.bKe = lVar;
    }

    @Override // com.baidu.tbadk.core.view.z.b
    public void aL(boolean z) {
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        cVar = this.bKe.bJN;
        str = this.bKe.bJP;
        cVar.ds(!StringUtils.isNull(str));
    }
}
