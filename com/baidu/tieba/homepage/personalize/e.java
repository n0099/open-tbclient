package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.personalize.o;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements o.a {
    final /* synthetic */ b cAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.cAU = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.o.a
    public void ar(int i, int i2) {
        com.baidu.tieba.homepage.framework.b bVar;
        boolean aiJ;
        com.baidu.tieba.homepage.framework.b bVar2;
        bVar = this.cAU.cAL;
        if (bVar == null) {
            this.cAU.showNetRefreshView(this.cAU, TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            this.cAU.Mu();
            return;
        }
        aiJ = this.cAU.aiJ();
        this.cAU.Mx();
        if (aiJ) {
            this.cAU.h(true, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds520));
        }
        bVar2 = this.cAU.cAL;
        bVar2.aq(i, i2);
    }

    @Override // com.baidu.tieba.homepage.personalize.o.a
    public void v(int i, int i2, int i3) {
        com.baidu.tieba.homepage.framework.b bVar;
        com.baidu.tieba.homepage.framework.b bVar2;
        bVar = this.cAU.cAL;
        if (bVar != null) {
            bVar2 = this.cAU.cAL;
            bVar2.u(i, i2, i3);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.o.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.cAU.Mu();
        if (i != 1) {
            bdTypeListView = this.cAU.aQa;
            bdTypeListView.setVisibility(8);
            this.cAU.showNetRefreshView(this.cAU, str, true);
        } else if (com.baidu.adp.lib.util.i.hk()) {
            tbPageContext = this.cAU.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.o.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.cAU.aQa;
        bdTypeListView.setVisibility(0);
        this.cAU.Mu();
        this.cAU.Mx();
    }

    @Override // com.baidu.tieba.homepage.personalize.o.a
    public void j(List<com.baidu.tieba.homepage.b.a.a> list, boolean z) {
        com.baidu.tieba.homepage.framework.b bVar;
        boolean z2;
        com.baidu.tieba.homepage.framework.b bVar2;
        bVar = this.cAU.cAL;
        if (bVar != null) {
            z2 = this.cAU.cAP;
            if (!z2) {
                bVar2 = this.cAU.cAL;
                bVar2.i(list, z);
            }
        }
        this.cAU.cAn = list;
        this.cAU.cAQ = z;
    }
}
