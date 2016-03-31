package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements s.a {
    final /* synthetic */ i bbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bbw = iVar;
    }

    @Override // com.baidu.tbadk.core.view.s.a
    public void aB(boolean z) {
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        cVar = this.bbw.bbc;
        str = this.bbw.bbe;
        cVar.cn(!StringUtils.isNull(str));
    }
}
