package com.baidu.tieba.frs.b;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.ee;
import com.baidu.tieba.frs.view.FrsHeaderView;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ec {
    final /* synthetic */ a bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bcD = aVar;
    }

    @Override // com.baidu.tieba.frs.ec
    public void a(ed edVar) {
    }

    @Override // com.baidu.tieba.frs.ec
    public void a(int i, int i2, ee eeVar) {
        String str;
        String str2;
        com.baidu.tieba.frs.view.q qVar;
        com.baidu.tieba.frs.view.q qVar2;
        boolean z;
        BdListView bdListView;
        com.baidu.tieba.frs.view.q qVar3;
        BdListView bdListView2;
        FrsHeaderView frsHeaderView;
        FrsHeaderView frsHeaderView2;
        boolean z2;
        BdListView bdListView3;
        FrsHeaderView frsHeaderView3;
        BdListView bdListView4;
        ec ecVar;
        ec ecVar2;
        String str3;
        String str4;
        com.baidu.tieba.frs.view.q qVar4;
        BdListView bdListView5;
        com.baidu.tieba.frs.view.q qVar5;
        FrsHeaderView frsHeaderView4;
        BdListView bdListView6;
        FrsHeaderView frsHeaderView5;
        URI uri;
        if (i > 100) {
            if (eeVar != null && (eeVar.aZk instanceof String)) {
                try {
                    uri = new URI((String) eeVar.aZk);
                } catch (URISyntaxException e) {
                    BdLog.e(e);
                    uri = null;
                }
                if (uri != null) {
                    String host = uri.getHost();
                    aq aqVar = new aq("c10079");
                    aqVar.ae("obj_type", host);
                    TiebaStatic.log(aqVar);
                }
            }
        } else {
            aq aqVar2 = new aq("c10074");
            aqVar2.r("obj_type", i);
            TiebaStatic.log(aqVar2);
        }
        if (i != 1) {
            str3 = this.bcD.bcs;
            if ("normal_page".equals(str3)) {
                frsHeaderView4 = this.bcD.bcl;
                if (frsHeaderView4 != null) {
                    bdListView6 = this.bcD.bck;
                    frsHeaderView5 = this.bcD.bcl;
                    bdListView6.removeHeaderView(frsHeaderView5.Ol());
                    this.bcD.bcz = false;
                }
            }
            str4 = this.bcD.bcs;
            if ("frs_page".equals(str4)) {
                qVar4 = this.bcD.bcm;
                if (qVar4 != null) {
                    bdListView5 = this.bcD.bck;
                    qVar5 = this.bcD.bcm;
                    bdListView5.removeHeaderView(qVar5.Ol());
                    this.bcD.bcz = false;
                }
            }
        } else {
            str = this.bcD.bcs;
            if ("normal_page".equals(str)) {
                frsHeaderView = this.bcD.bcl;
                if (frsHeaderView != null) {
                    frsHeaderView2 = this.bcD.bcl;
                    if (frsHeaderView2.Ol() != null) {
                        z2 = this.bcD.bcz;
                        if (!z2) {
                            bdListView3 = this.bcD.bck;
                            frsHeaderView3 = this.bcD.bcl;
                            View Ol = frsHeaderView3.Ol();
                            bdListView4 = this.bcD.bck;
                            bdListView3.d(Ol, bdListView4.getHeaderViewsCount());
                            this.bcD.bcz = true;
                        }
                    }
                }
            }
            str2 = this.bcD.bcs;
            if ("frs_page".equals(str2)) {
                qVar = this.bcD.bcm;
                if (qVar != null) {
                    qVar2 = this.bcD.bcm;
                    if (qVar2.Ol() != null) {
                        z = this.bcD.bcz;
                        if (!z) {
                            bdListView = this.bcD.bck;
                            qVar3 = this.bcD.bcm;
                            View Ol2 = qVar3.Ol();
                            bdListView2 = this.bcD.bck;
                            bdListView.d(Ol2, bdListView2.getHeaderViewsCount());
                            this.bcD.bcz = true;
                        }
                    }
                }
            }
        }
        ecVar = this.bcD.bcB;
        if (ecVar == null) {
            return;
        }
        ecVar2 = this.bcD.bcB;
        ecVar2.a(i, i2, eeVar);
    }

    @Override // com.baidu.tieba.frs.ec
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ec
    public void KG() {
    }
}
