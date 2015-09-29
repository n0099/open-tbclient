package com.baidu.tieba.frs.b;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.view.FrsHeaderView;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ea {
    final /* synthetic */ a bbN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bbN = aVar;
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
            if (ecVar != null && (ecVar.aYN instanceof String)) {
                try {
                    uri = new URI((String) ecVar.aYN);
                } catch (URISyntaxException e) {
                    BdLog.e(e);
                    uri = null;
                }
                if (uri != null) {
                    String host = uri.getHost();
                    ap apVar = new ap("c10079");
                    apVar.ae("obj_type", host);
                    TiebaStatic.log(apVar);
                }
            }
        } else {
            ap apVar2 = new ap("c10074");
            apVar2.r("obj_type", i);
            TiebaStatic.log(apVar2);
        }
        if (i != 1) {
            str3 = this.bbN.bbD;
            if ("normal_page".equals(str3)) {
                frsHeaderView4 = this.bbN.bbw;
                if (frsHeaderView4 != null) {
                    bdListView6 = this.bbN.bbv;
                    frsHeaderView5 = this.bbN.bbw;
                    bdListView6.removeHeaderView(frsHeaderView5.NT());
                    this.bbN.bbK = false;
                }
            }
            str4 = this.bbN.bbD;
            if ("frs_page".equals(str4)) {
                qVar4 = this.bbN.bbx;
                if (qVar4 != null) {
                    bdListView5 = this.bbN.bbv;
                    qVar5 = this.bbN.bbx;
                    bdListView5.removeHeaderView(qVar5.NT());
                    this.bbN.bbK = false;
                }
            }
        } else {
            str = this.bbN.bbD;
            if ("normal_page".equals(str)) {
                frsHeaderView = this.bbN.bbw;
                if (frsHeaderView != null) {
                    frsHeaderView2 = this.bbN.bbw;
                    if (frsHeaderView2.NT() != null) {
                        z2 = this.bbN.bbK;
                        if (!z2) {
                            bdListView3 = this.bbN.bbv;
                            frsHeaderView3 = this.bbN.bbw;
                            View NT = frsHeaderView3.NT();
                            bdListView4 = this.bbN.bbv;
                            bdListView3.d(NT, bdListView4.getHeaderViewsCount());
                            this.bbN.bbK = true;
                        }
                    }
                }
            }
            str2 = this.bbN.bbD;
            if ("frs_page".equals(str2)) {
                qVar = this.bbN.bbx;
                if (qVar != null) {
                    qVar2 = this.bbN.bbx;
                    if (qVar2.NT() != null) {
                        z = this.bbN.bbK;
                        if (!z) {
                            bdListView = this.bbN.bbv;
                            qVar3 = this.bbN.bbx;
                            View NT2 = qVar3.NT();
                            bdListView2 = this.bbN.bbv;
                            bdListView.d(NT2, bdListView2.getHeaderViewsCount());
                            this.bbN.bbK = true;
                        }
                    }
                }
            }
        }
        eaVar = this.bbN.bbM;
        if (eaVar == null) {
            return;
        }
        eaVar2 = this.bbN.bbM;
        eaVar2.a(i, i2, ecVar);
    }

    @Override // com.baidu.tieba.frs.ea
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ea
    public void Ku() {
    }
}
