package com.baidu.tieba.frs.b;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.frs.ex;
import com.baidu.tieba.frs.view.FrsHeaderView;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements eu {
    final /* synthetic */ a bmZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bmZ = aVar;
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(ev evVar) {
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(int i, int i2, ex exVar) {
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
        eu euVar;
        eu euVar2;
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
            if (exVar != null && (exVar.bji instanceof String)) {
                try {
                    uri = new URI((String) exVar.bji);
                } catch (URISyntaxException e) {
                    BdLog.e(e);
                    uri = null;
                }
                if (uri != null) {
                    String host = uri.getHost();
                    av avVar = new av("c10079");
                    avVar.aa("obj_type", host);
                    TiebaStatic.log(avVar);
                }
            }
        } else {
            av avVar2 = new av("c10074");
            avVar2.r("obj_type", i);
            frsActivity = this.bmZ.blE;
            avVar2.aa(ImageViewerConfig.FORUM_ID, frsActivity.getForumId());
            TiebaStatic.log(avVar2);
        }
        if (i != 1) {
            str3 = this.bmZ.bmO;
            if ("normal_page".equals(str3)) {
                frsHeaderView4 = this.bmZ.bmH;
                if (frsHeaderView4 != null) {
                    bdListView6 = this.bmZ.bmG;
                    frsHeaderView5 = this.bmZ.bmH;
                    bdListView6.removeHeaderView(frsHeaderView5.Qj());
                    this.bmZ.bmV = false;
                }
            }
            str4 = this.bmZ.bmO;
            if ("frs_page".equals(str4)) {
                qVar4 = this.bmZ.bmI;
                if (qVar4 != null) {
                    bdListView5 = this.bmZ.bmG;
                    qVar5 = this.bmZ.bmI;
                    bdListView5.removeHeaderView(qVar5.Qj());
                    this.bmZ.bmV = false;
                }
            }
        } else {
            str = this.bmZ.bmO;
            if ("normal_page".equals(str)) {
                frsHeaderView = this.bmZ.bmH;
                if (frsHeaderView != null) {
                    frsHeaderView2 = this.bmZ.bmH;
                    if (frsHeaderView2.Qj() != null) {
                        z2 = this.bmZ.bmV;
                        if (!z2) {
                            bdListView3 = this.bmZ.bmG;
                            frsHeaderView3 = this.bmZ.bmH;
                            View Qj = frsHeaderView3.Qj();
                            bdListView4 = this.bmZ.bmG;
                            bdListView3.d(Qj, bdListView4.getHeaderViewsCount());
                            this.bmZ.bmV = true;
                        }
                    }
                }
            }
            str2 = this.bmZ.bmO;
            if ("frs_page".equals(str2)) {
                qVar = this.bmZ.bmI;
                if (qVar != null) {
                    qVar2 = this.bmZ.bmI;
                    if (qVar2.Qj() != null) {
                        z = this.bmZ.bmV;
                        if (!z) {
                            bdListView = this.bmZ.bmG;
                            qVar3 = this.bmZ.bmI;
                            View Qj2 = qVar3.Qj();
                            bdListView2 = this.bmZ.bmG;
                            bdListView.d(Qj2, bdListView2.getHeaderViewsCount());
                            this.bmZ.bmV = true;
                        }
                    }
                }
            }
        }
        euVar = this.bmZ.bmX;
        if (euVar == null) {
            return;
        }
        euVar2 = this.bmZ.bmX;
        euVar2.a(i, i2, exVar);
    }

    @Override // com.baidu.tieba.frs.eu
    public void init() {
    }

    @Override // com.baidu.tieba.frs.eu
    public void My() {
    }
}
