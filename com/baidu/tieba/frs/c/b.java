package com.baidu.tieba.frs.c;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.fe;
import com.baidu.tieba.frs.ff;
import com.baidu.tieba.frs.fh;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.t;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements fe {
    final /* synthetic */ a bpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bpO = aVar;
    }

    @Override // com.baidu.tieba.frs.fe
    public void a(ff ffVar) {
    }

    @Override // com.baidu.tieba.frs.fe
    public void a(int i, int i2, fh fhVar) {
        FrsActivity frsActivity;
        String str;
        String str2;
        t tVar;
        t tVar2;
        boolean z;
        BdListView bdListView;
        t tVar3;
        BdListView bdListView2;
        FrsHeaderView frsHeaderView;
        FrsHeaderView frsHeaderView2;
        boolean z2;
        BdListView bdListView3;
        FrsHeaderView frsHeaderView3;
        BdListView bdListView4;
        fe feVar;
        fe feVar2;
        String str3;
        String str4;
        t tVar4;
        BdListView bdListView5;
        t tVar5;
        FrsHeaderView frsHeaderView4;
        BdListView bdListView6;
        FrsHeaderView frsHeaderView5;
        URI uri;
        if (i > 100) {
            if (fhVar != null && (fhVar.bmd instanceof String)) {
                try {
                    uri = new URI((String) fhVar.bmd);
                } catch (URISyntaxException e) {
                    BdLog.e(e);
                    uri = null;
                }
                if (uri != null) {
                    String host = uri.getHost();
                    au auVar = new au("c10079");
                    auVar.aa("obj_type", host);
                    TiebaStatic.log(auVar);
                }
            }
        } else {
            au auVar2 = new au("c10074");
            auVar2.r("obj_type", i);
            frsActivity = this.bpO.bot;
            auVar2.aa(ImageViewerConfig.FORUM_ID, frsActivity.getForumId());
            TiebaStatic.log(auVar2);
        }
        if (i != 1) {
            str3 = this.bpO.bpD;
            if ("normal_page".equals(str3)) {
                frsHeaderView4 = this.bpO.bpw;
                if (frsHeaderView4 != null) {
                    bdListView6 = this.bpO.bpv;
                    frsHeaderView5 = this.bpO.bpw;
                    bdListView6.removeHeaderView(frsHeaderView5.Sn());
                    this.bpO.bpK = false;
                }
            }
            str4 = this.bpO.bpD;
            if ("frs_page".equals(str4)) {
                tVar4 = this.bpO.bpx;
                if (tVar4 != null) {
                    bdListView5 = this.bpO.bpv;
                    tVar5 = this.bpO.bpx;
                    bdListView5.removeHeaderView(tVar5.Sn());
                    this.bpO.bpK = false;
                }
            }
        } else {
            str = this.bpO.bpD;
            if ("normal_page".equals(str)) {
                frsHeaderView = this.bpO.bpw;
                if (frsHeaderView != null) {
                    frsHeaderView2 = this.bpO.bpw;
                    if (frsHeaderView2.Sn() != null) {
                        z2 = this.bpO.bpK;
                        if (!z2) {
                            bdListView3 = this.bpO.bpv;
                            frsHeaderView3 = this.bpO.bpw;
                            View Sn = frsHeaderView3.Sn();
                            bdListView4 = this.bpO.bpv;
                            bdListView3.f(Sn, bdListView4.getHeaderViewsCount());
                            this.bpO.bpK = true;
                        }
                    }
                }
            }
            str2 = this.bpO.bpD;
            if ("frs_page".equals(str2)) {
                tVar = this.bpO.bpx;
                if (tVar != null) {
                    tVar2 = this.bpO.bpx;
                    if (tVar2.Sn() != null) {
                        z = this.bpO.bpK;
                        if (!z) {
                            bdListView = this.bpO.bpv;
                            tVar3 = this.bpO.bpx;
                            View Sn2 = tVar3.Sn();
                            bdListView2 = this.bpO.bpv;
                            bdListView.f(Sn2, bdListView2.getHeaderViewsCount());
                            this.bpO.bpK = true;
                        }
                    }
                }
            }
        }
        feVar = this.bpO.bpM;
        if (feVar == null) {
            return;
        }
        feVar2 = this.bpO.bpM;
        feVar2.a(i, i2, fhVar);
    }

    @Override // com.baidu.tieba.frs.fe
    public void init() {
    }

    @Override // com.baidu.tieba.frs.fe
    public void Op() {
    }
}
