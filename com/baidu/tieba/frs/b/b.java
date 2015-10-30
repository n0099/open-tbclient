package com.baidu.tieba.frs.b;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.view.FrsHeaderView;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ea {
    final /* synthetic */ a bbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bbY = aVar;
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(eb ebVar) {
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(int i, int i2, ec ecVar) {
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
        ea eaVar;
        ea eaVar2;
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
            if (ecVar != null && (ecVar.aYY instanceof String)) {
                try {
                    uri = new URI((String) ecVar.aYY);
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
            str3 = this.bbY.bbO;
            if ("normal_page".equals(str3)) {
                frsHeaderView4 = this.bbY.bbH;
                if (frsHeaderView4 != null) {
                    bdListView6 = this.bbY.bbG;
                    frsHeaderView5 = this.bbY.bbH;
                    bdListView6.removeHeaderView(frsHeaderView5.NP());
                    this.bbY.bbV = false;
                }
            }
            str4 = this.bbY.bbO;
            if ("frs_page".equals(str4)) {
                qVar4 = this.bbY.bbI;
                if (qVar4 != null) {
                    bdListView5 = this.bbY.bbG;
                    qVar5 = this.bbY.bbI;
                    bdListView5.removeHeaderView(qVar5.NP());
                    this.bbY.bbV = false;
                }
            }
        } else {
            str = this.bbY.bbO;
            if ("normal_page".equals(str)) {
                frsHeaderView = this.bbY.bbH;
                if (frsHeaderView != null) {
                    frsHeaderView2 = this.bbY.bbH;
                    if (frsHeaderView2.NP() != null) {
                        z2 = this.bbY.bbV;
                        if (!z2) {
                            bdListView3 = this.bbY.bbG;
                            frsHeaderView3 = this.bbY.bbH;
                            View NP = frsHeaderView3.NP();
                            bdListView4 = this.bbY.bbG;
                            bdListView3.d(NP, bdListView4.getHeaderViewsCount());
                            this.bbY.bbV = true;
                        }
                    }
                }
            }
            str2 = this.bbY.bbO;
            if ("frs_page".equals(str2)) {
                qVar = this.bbY.bbI;
                if (qVar != null) {
                    qVar2 = this.bbY.bbI;
                    if (qVar2.NP() != null) {
                        z = this.bbY.bbV;
                        if (!z) {
                            bdListView = this.bbY.bbG;
                            qVar3 = this.bbY.bbI;
                            View NP2 = qVar3.NP();
                            bdListView2 = this.bbY.bbG;
                            bdListView.d(NP2, bdListView2.getHeaderViewsCount());
                            this.bbY.bbV = true;
                        }
                    }
                }
            }
        }
        eaVar = this.bbY.bbX;
        if (eaVar == null) {
            return;
        }
        eaVar2 = this.bbY.bbX;
        eaVar2.a(i, i2, ecVar);
    }

    @Override // com.baidu.tieba.frs.ea
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ea
    public void Kq() {
    }
}
