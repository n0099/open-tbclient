package com.baidu.tieba.frs.c;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.fp;
import com.baidu.tieba.frs.fq;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.u;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements fo {
    final /* synthetic */ a buP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.buP = aVar;
    }

    @Override // com.baidu.tieba.frs.fo
    public void a(fp fpVar) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.fo
    public void a(int i, int i2, fq fqVar) {
        FrsActivity frsActivity;
        String str;
        String str2;
        u uVar;
        u uVar2;
        boolean z;
        BdListView bdListView;
        u uVar3;
        BdListView bdListView2;
        FrsHeaderView frsHeaderView;
        FrsHeaderView frsHeaderView2;
        boolean z2;
        BdListView bdListView3;
        FrsHeaderView frsHeaderView3;
        BdListView bdListView4;
        fo foVar;
        fo foVar2;
        String str3;
        String str4;
        u uVar4;
        BdListView bdListView5;
        u uVar5;
        FrsHeaderView frsHeaderView4;
        BdListView bdListView6;
        FrsHeaderView frsHeaderView5;
        FrsActivity frsActivity2;
        URI uri;
        if (i > 100) {
            if (fqVar != null && (fqVar.brs instanceof String)) {
                try {
                    uri = new URI((String) fqVar.brs);
                } catch (URISyntaxException e) {
                    BdLog.e(e);
                    uri = null;
                }
                if (uri != null) {
                    String host = uri.getHost();
                    aw awVar = new aw("c10079");
                    awVar.ac("obj_type", host);
                    TiebaStatic.log(awVar);
                }
            }
        } else {
            aw awVar2 = new aw("c10074");
            awVar2.r("obj_type", i);
            frsActivity = this.buP.bts;
            awVar2.ac("fid", frsActivity.getForumId());
            TiebaStatic.log(awVar2);
        }
        if (HorizontalTabView.hd(i)) {
            String str5 = (String) fqVar.brs;
            if (!StringUtils.isNull(str5)) {
                bg wM = bg.wM();
                frsActivity2 = this.buP.bts;
                wM.c(frsActivity2.getPageContext(), new String[]{str5});
                return;
            }
            return;
        }
        if (i != 1) {
            str3 = this.buP.buE;
            if ("normal_page".equals(str3)) {
                frsHeaderView4 = this.buP.bux;
                if (frsHeaderView4 != null) {
                    bdListView6 = this.buP.buw;
                    frsHeaderView5 = this.buP.bux;
                    bdListView6.removeHeaderView(frsHeaderView5.Uc());
                    this.buP.buL = false;
                }
            }
            str4 = this.buP.buE;
            if ("frs_page".equals(str4)) {
                uVar4 = this.buP.buy;
                if (uVar4 != null) {
                    bdListView5 = this.buP.buw;
                    uVar5 = this.buP.buy;
                    bdListView5.removeHeaderView(uVar5.Uc());
                    this.buP.buL = false;
                }
            }
        } else {
            str = this.buP.buE;
            if ("normal_page".equals(str)) {
                frsHeaderView = this.buP.bux;
                if (frsHeaderView != null) {
                    frsHeaderView2 = this.buP.bux;
                    if (frsHeaderView2.Uc() != null) {
                        z2 = this.buP.buL;
                        if (!z2) {
                            bdListView3 = this.buP.buw;
                            frsHeaderView3 = this.buP.bux;
                            View Uc = frsHeaderView3.Uc();
                            bdListView4 = this.buP.buw;
                            bdListView3.f(Uc, bdListView4.getHeaderViewsCount());
                            this.buP.buL = true;
                        }
                    }
                }
            }
            str2 = this.buP.buE;
            if ("frs_page".equals(str2)) {
                uVar = this.buP.buy;
                if (uVar != null) {
                    uVar2 = this.buP.buy;
                    if (uVar2.Uc() != null) {
                        z = this.buP.buL;
                        if (!z) {
                            bdListView = this.buP.buw;
                            uVar3 = this.buP.buy;
                            View Uc2 = uVar3.Uc();
                            bdListView2 = this.buP.buw;
                            bdListView.f(Uc2, bdListView2.getHeaderViewsCount());
                            this.buP.buL = true;
                        }
                    }
                }
            }
        }
        foVar = this.buP.buN;
        if (foVar == null) {
            return;
        }
        foVar2 = this.buP.buN;
        foVar2.a(i, i2, fqVar);
    }

    @Override // com.baidu.tieba.frs.fo
    public void init() {
    }

    @Override // com.baidu.tieba.frs.fo
    public void Qe() {
    }
}
