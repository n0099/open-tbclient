package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements t.b {
    final /* synthetic */ k btA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.btA = kVar;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aE(boolean z) {
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        cVar = this.btA.bth;
        str = this.btA.btj;
        cVar.cP(!StringUtils.isNull(str));
    }
}
