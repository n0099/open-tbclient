package com.baidu.tieba.frs.b;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.et;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ew;
import com.baidu.tieba.frs.view.FrsHeaderView;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements et {
    final /* synthetic */ a bji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bji = aVar;
    }

    @Override // com.baidu.tieba.frs.et
    public void a(eu euVar) {
    }

    @Override // com.baidu.tieba.frs.et
    public void a(int i, int i2, ew ewVar) {
        FrsActivity frsActivity;
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
        et etVar;
        et etVar2;
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
            if (ewVar != null && (ewVar.bfp instanceof String)) {
                try {
                    uri = new URI((String) ewVar.bfp);
                } catch (URISyntaxException e) {
                    BdLog.e(e);
                    uri = null;
                }
                if (uri != null) {
                    String host = uri.getHost();
                    av avVar = new av("c10079");
                    avVar.ab("obj_type", host);
                    TiebaStatic.log(avVar);
                }
            }
        } else {
            av avVar2 = new av("c10074");
            avVar2.r("obj_type", i);
            frsActivity = this.bji.bhN;
            avVar2.ab(ImageViewerConfig.FORUM_ID, frsActivity.getForumId());
            TiebaStatic.log(avVar2);
        }
        if (i != 1) {
            str3 = this.bji.biX;
            if ("normal_page".equals(str3)) {
                frsHeaderView4 = this.bji.biQ;
                if (frsHeaderView4 != null) {
                    bdListView6 = this.bji.biP;
                    frsHeaderView5 = this.bji.biQ;
                    bdListView6.removeHeaderView(frsHeaderView5.PR());
                    this.bji.bje = false;
                }
            }
            str4 = this.bji.biX;
            if ("frs_page".equals(str4)) {
                qVar4 = this.bji.biR;
                if (qVar4 != null) {
                    bdListView5 = this.bji.biP;
                    qVar5 = this.bji.biR;
                    bdListView5.removeHeaderView(qVar5.PR());
                    this.bji.bje = false;
                }
            }
        } else {
            str = this.bji.biX;
            if ("normal_page".equals(str)) {
                frsHeaderView = this.bji.biQ;
                if (frsHeaderView != null) {
                    frsHeaderView2 = this.bji.biQ;
                    if (frsHeaderView2.PR() != null) {
                        z2 = this.bji.bje;
                        if (!z2) {
                            bdListView3 = this.bji.biP;
                            frsHeaderView3 = this.bji.biQ;
                            View PR = frsHeaderView3.PR();
                            bdListView4 = this.bji.biP;
                            bdListView3.d(PR, bdListView4.getHeaderViewsCount());
                            this.bji.bje = true;
                        }
                    }
                }
            }
            str2 = this.bji.biX;
            if ("frs_page".equals(str2)) {
                qVar = this.bji.biR;
                if (qVar != null) {
                    qVar2 = this.bji.biR;
                    if (qVar2.PR() != null) {
                        z = this.bji.bje;
                        if (!z) {
                            bdListView = this.bji.biP;
                            qVar3 = this.bji.biR;
                            View PR2 = qVar3.PR();
                            bdListView2 = this.bji.biP;
                            bdListView.d(PR2, bdListView2.getHeaderViewsCount());
                            this.bji.bje = true;
                        }
                    }
                }
            }
        }
        etVar = this.bji.bjg;
        if (etVar == null) {
            return;
        }
        etVar2 = this.bji.bjg;
        etVar2.a(i, i2, ewVar);
    }

    @Override // com.baidu.tieba.frs.et
    public void init() {
    }

    @Override // com.baidu.tieba.frs.et
    public void Mf() {
    }
}
