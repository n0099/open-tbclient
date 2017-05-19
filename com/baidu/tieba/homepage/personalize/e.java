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
    final /* synthetic */ b cuC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.cuC = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.o.a
    public void ar(int i, int i2) {
        com.baidu.tieba.homepage.framework.b bVar;
        boolean ahu;
        com.baidu.tieba.homepage.framework.b bVar2;
        bVar = this.cuC.cut;
        if (bVar == null) {
            this.cuC.showNetRefreshView(this.cuC, TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            this.cuC.JQ();
            return;
        }
        ahu = this.cuC.ahu();
        this.cuC.JR();
        if (ahu) {
            this.cuC.h(true, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds520));
        }
        bVar2 = this.cuC.cut;
        bVar2.aq(i, i2);
    }

    @Override // com.baidu.tieba.homepage.personalize.o.a
    public void v(int i, int i2, int i3) {
        com.baidu.tieba.homepage.framework.b bVar;
        com.baidu.tieba.homepage.framework.b bVar2;
        bVar = this.cuC.cut;
        if (bVar != null) {
            bVar2 = this.cuC.cut;
            bVar2.u(i, i2, i3);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.o.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.cuC.JQ();
        if (i != 1) {
            bdTypeListView = this.cuC.aPZ;
            bdTypeListView.setVisibility(8);
            this.cuC.showNetRefreshView(this.cuC, str, true);
        } else if (com.baidu.adp.lib.util.i.hk()) {
            tbPageContext = this.cuC.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.o.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.cuC.aPZ;
        bdTypeListView.setVisibility(0);
        this.cuC.JQ();
        this.cuC.JR();
    }

    @Override // com.baidu.tieba.homepage.personalize.o.a
    public void j(List<com.baidu.tieba.homepage.b.a.a> list, boolean z) {
        com.baidu.tieba.homepage.framework.b bVar;
        boolean z2;
        com.baidu.tieba.homepage.framework.b bVar2;
        bVar = this.cuC.cut;
        if (bVar != null) {
            z2 = this.cuC.cux;
            if (!z2) {
                bVar2 = this.cuC.cut;
                bVar2.i(list, z);
            }
        }
        this.cuC.ctV = list;
        this.cuC.cuy = z;
    }
}
