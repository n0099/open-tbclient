package com.baidu.tieba.frs.c;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.dj;
import com.baidu.tieba.frs.view.FrsHeaderView;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements dh {
    final /* synthetic */ a bbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bbT = aVar;
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(di diVar) {
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(int i, int i2, dj djVar) {
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
        dh dhVar;
        dh dhVar2;
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
            if (djVar != null && (djVar.aYY instanceof String)) {
                try {
                    uri = new URI((String) djVar.aYY);
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
            str3 = this.bbT.bbJ;
            if ("normal_page".equals(str3)) {
                frsHeaderView4 = this.bbT.bbC;
                if (frsHeaderView4 != null) {
                    bdListView6 = this.bbT.bbB;
                    frsHeaderView5 = this.bbT.bbC;
                    bdListView6.removeHeaderView(frsHeaderView5.NT());
                    this.bbT.bbQ = false;
                }
            }
            str4 = this.bbT.bbJ;
            if ("frs_page".equals(str4)) {
                pVar4 = this.bbT.bbD;
                if (pVar4 != null) {
                    bdListView5 = this.bbT.bbB;
                    pVar5 = this.bbT.bbD;
                    bdListView5.removeHeaderView(pVar5.NT());
                    this.bbT.bbQ = false;
                }
            }
        } else {
            str = this.bbT.bbJ;
            if ("normal_page".equals(str)) {
                frsHeaderView = this.bbT.bbC;
                if (frsHeaderView != null) {
                    frsHeaderView2 = this.bbT.bbC;
                    if (frsHeaderView2.NT() != null) {
                        z2 = this.bbT.bbQ;
                        if (!z2) {
                            bdListView3 = this.bbT.bbB;
                            frsHeaderView3 = this.bbT.bbC;
                            View NT = frsHeaderView3.NT();
                            bdListView4 = this.bbT.bbB;
                            bdListView3.d(NT, bdListView4.getHeaderViewsCount());
                            this.bbT.bbQ = true;
                        }
                    }
                }
            }
            str2 = this.bbT.bbJ;
            if ("frs_page".equals(str2)) {
                pVar = this.bbT.bbD;
                if (pVar != null) {
                    pVar2 = this.bbT.bbD;
                    if (pVar2.NT() != null) {
                        z = this.bbT.bbQ;
                        if (!z) {
                            bdListView = this.bbT.bbB;
                            pVar3 = this.bbT.bbD;
                            View NT2 = pVar3.NT();
                            bdListView2 = this.bbT.bbB;
                            bdListView.d(NT2, bdListView2.getHeaderViewsCount());
                            this.bbT.bbQ = true;
                        }
                    }
                }
            }
        }
        dhVar = this.bbT.bbS;
        if (dhVar == null) {
            return;
        }
        dhVar2 = this.bbT.bbS;
        dhVar2.a(i, i2, djVar);
    }

    @Override // com.baidu.tieba.frs.dh
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dh
    public void Kz() {
    }
}
