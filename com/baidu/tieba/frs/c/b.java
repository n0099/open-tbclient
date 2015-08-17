package com.baidu.tieba.frs.c;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.de;
import com.baidu.tieba.frs.view.FrsHeaderView;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements db {
    final /* synthetic */ a bbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bbz = aVar;
    }

    @Override // com.baidu.tieba.frs.db
    public void a(dc dcVar) {
    }

    @Override // com.baidu.tieba.frs.db
    public void a(int i, int i2, de deVar) {
        String str;
        String str2;
        com.baidu.tieba.frs.view.p pVar;
        com.baidu.tieba.frs.view.p pVar2;
        boolean z;
        BdListView bdListView;
        com.baidu.tieba.frs.view.p pVar3;
        BdListView bdListView2;
        FrsHeaderView frsHeaderView;
        FrsHeaderView frsHeaderView2;
        boolean z2;
        BdListView bdListView3;
        FrsHeaderView frsHeaderView3;
        BdListView bdListView4;
        db dbVar;
        db dbVar2;
        String str3;
        String str4;
        com.baidu.tieba.frs.view.p pVar4;
        BdListView bdListView5;
        com.baidu.tieba.frs.view.p pVar5;
        FrsHeaderView frsHeaderView4;
        BdListView bdListView6;
        FrsHeaderView frsHeaderView5;
        URI uri;
        if (i > 100) {
            if (deVar != null && (deVar.aYH instanceof String)) {
                try {
                    uri = new URI((String) deVar.aYH);
                } catch (URISyntaxException e) {
                    BdLog.e(e);
                    uri = null;
                }
                if (uri != null) {
                    String host = uri.getHost();
                    ao aoVar = new ao("c10079");
                    aoVar.af("obj_type", host);
                    TiebaStatic.log(aoVar);
                }
            }
        } else {
            ao aoVar2 = new ao("c10074");
            aoVar2.r("obj_type", i);
            TiebaStatic.log(aoVar2);
        }
        if (i != 1) {
            str3 = this.bbz.bbp;
            if ("normal_page".equals(str3)) {
                frsHeaderView4 = this.bbz.bbi;
                if (frsHeaderView4 != null) {
                    bdListView6 = this.bbz.bbh;
                    frsHeaderView5 = this.bbz.bbi;
                    bdListView6.removeHeaderView(frsHeaderView5.NS());
                    this.bbz.bbw = false;
                }
            }
            str4 = this.bbz.bbp;
            if ("frs_page".equals(str4)) {
                pVar4 = this.bbz.bbj;
                if (pVar4 != null) {
                    bdListView5 = this.bbz.bbh;
                    pVar5 = this.bbz.bbj;
                    bdListView5.removeHeaderView(pVar5.NS());
                    this.bbz.bbw = false;
                }
            }
        } else {
            str = this.bbz.bbp;
            if ("normal_page".equals(str)) {
                frsHeaderView = this.bbz.bbi;
                if (frsHeaderView != null) {
                    frsHeaderView2 = this.bbz.bbi;
                    if (frsHeaderView2.NS() != null) {
                        z2 = this.bbz.bbw;
                        if (!z2) {
                            bdListView3 = this.bbz.bbh;
                            frsHeaderView3 = this.bbz.bbi;
                            View NS = frsHeaderView3.NS();
                            bdListView4 = this.bbz.bbh;
                            bdListView3.d(NS, bdListView4.getHeaderViewsCount());
                            this.bbz.bbw = true;
                        }
                    }
                }
            }
            str2 = this.bbz.bbp;
            if ("frs_page".equals(str2)) {
                pVar = this.bbz.bbj;
                if (pVar != null) {
                    pVar2 = this.bbz.bbj;
                    if (pVar2.NS() != null) {
                        z = this.bbz.bbw;
                        if (!z) {
                            bdListView = this.bbz.bbh;
                            pVar3 = this.bbz.bbj;
                            View NS2 = pVar3.NS();
                            bdListView2 = this.bbz.bbh;
                            bdListView.d(NS2, bdListView2.getHeaderViewsCount());
                            this.bbz.bbw = true;
                        }
                    }
                }
            }
        }
        dbVar = this.bbz.bby;
        if (dbVar == null) {
            return;
        }
        dbVar2 = this.bbz.bby;
        dbVar2.a(i, i2, deVar);
    }

    @Override // com.baidu.tieba.frs.db
    public void init() {
    }

    @Override // com.baidu.tieba.frs.db
    public void KL() {
    }
}
