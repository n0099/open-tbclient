package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.personalize.x;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements x.a {
    final /* synthetic */ i cIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.cIQ = iVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.x.a
    public void ax(int i, int i2) {
        com.baidu.tieba.homepage.framework.b bVar;
        boolean amv;
        com.baidu.tieba.homepage.framework.b bVar2;
        bVar = this.cIQ.cIG;
        if (bVar == null) {
            this.cIQ.showNetRefreshView(this.cIQ, TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            this.cIQ.Nm();
            return;
        }
        amv = this.cIQ.amv();
        this.cIQ.Np();
        if (amv) {
            this.cIQ.h(true, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds520));
        }
        bVar2 = this.cIQ.cIG;
        bVar2.aw(i, i2);
    }

    @Override // com.baidu.tieba.homepage.personalize.x.a
    public void w(int i, int i2, int i3) {
        com.baidu.tieba.homepage.framework.b bVar;
        com.baidu.tieba.homepage.framework.b bVar2;
        bVar = this.cIQ.cIG;
        if (bVar != null) {
            bVar2 = this.cIQ.cIG;
            bVar2.v(i, i2, i3);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.x.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.cIQ.Nm();
        if (i != 1) {
            bdTypeListView = this.cIQ.aRs;
            bdTypeListView.setVisibility(8);
            this.cIQ.showNetRefreshView(this.cIQ, str, true);
        } else if (com.baidu.adp.lib.util.i.hj()) {
            tbPageContext = this.cIQ.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.x.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.cIQ.aRs;
        bdTypeListView.setVisibility(0);
        this.cIQ.Nm();
        this.cIQ.Np();
    }

    @Override // com.baidu.tieba.homepage.personalize.x.a
    public void k(List<com.baidu.tieba.homepage.b.a.a> list, boolean z) {
        com.baidu.tieba.homepage.framework.b bVar;
        boolean z2;
        com.baidu.tieba.homepage.framework.b bVar2;
        bVar = this.cIQ.cIG;
        if (bVar != null) {
            z2 = this.cIQ.cIK;
            if (!z2) {
                bVar2 = this.cIQ.cIG;
                bVar2.j(list, z);
            }
        }
        this.cIQ.cHZ = list;
        this.cIQ.cIL = z;
    }
}
