package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.tbadkCore.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements HorizontalTabView.a {
    final /* synthetic */ a chn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.chn = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void a(j jVar) {
        n nVar;
        n nVar2;
        n nVar3;
        nVar = this.chn.chk;
        if (nVar != null) {
            nVar2 = this.chn.chk;
            if (nVar2.aMt() != null) {
                au auVar = new au("c12047");
                nVar3 = this.chn.chk;
                TiebaStatic.log(auVar.Z("fid", nVar3.aMt().getId()));
            }
        }
    }
}
