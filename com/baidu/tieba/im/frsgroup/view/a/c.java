package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.im.frsgroup.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements BdListView.e, NoNetworkView.a, e.b {
    private ap cUb;
    private String crJ;
    private b dZR;
    private String dZU;
    private aj dZV;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> cTW = new ArrayList();
    private boolean dZT = true;
    private View.OnClickListener dZW = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            c.this.dZT = true;
            c.this.aoh();
        }
    };
    private aj dZX = new aj() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<h> arrayList) {
            if (apVar == null) {
                c.this.dZR.completePullRefresh();
                c.this.dZR.Ou();
                return;
            }
            c.this.cUb = apVar;
            if ((c.this.cUb.pn == 0 || c.this.cUb.pn == 1) && c.this.cUb.hasMore && !c.this.cUb.isLocal) {
                c.this.Po();
                return;
            }
            if (arrayList != null) {
                Iterator<h> it = arrayList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if ((next instanceof g) || (next instanceof k)) {
                        it.remove();
                    }
                }
            }
            if (c.this.dZV != null) {
                c.this.dZV.a(i, i2, apVar, arrayList);
            }
            if (v.w(arrayList)) {
                if (c.this.dZT) {
                    c.this.dZR.Ou();
                    c.this.dZR.a(c.this.cUb.errMsg, c.this.dZW);
                } else {
                    c.this.dZR.completePullRefresh();
                    c.this.dZR.awH();
                }
            } else {
                c.this.cTW = arrayList;
                c.this.dZR.bC(c.this.cTW);
                if (v.v(c.this.cTW) != 1 || !(v.c(c.this.cTW, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.cUb.hasMore) {
                        c.this.dZR.awG();
                    } else {
                        c.this.dZR.awI();
                    }
                } else {
                    c.this.dZR.aEk();
                }
                if (c.this.dZT) {
                    c.this.dZR.Ou();
                } else {
                    c.this.dZR.completePullRefresh();
                }
            }
            c.this.dZT = false;
        }
    };
    private d dZS = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.dZR = new b(tbPageContext, this);
        this.dZS.setTag(this.pageId);
        this.dZS.init();
        this.dZS.a(this.dZX);
    }

    public void ce(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.dZR != null) {
            this.dZR.cd(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        if (this.dZR != null) {
            this.dZR.hj(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.e.b
    public void aO(boolean z) {
        aEm();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.gP()) {
            this.dZR.awH();
        }
        if (this.cUb != null) {
            if (!this.cUb.hasMore) {
                this.dZR.awI();
            } else {
                Po();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po() {
        if (this.cUb != null) {
            am amVar = new am();
            amVar.forumName = this.dZU;
            amVar.forumId = this.crJ;
            this.cUb.pn++;
            amVar.pn = this.cUb.pn;
            this.dZS.a(4, this.mPageType, amVar);
        }
    }

    private void aEm() {
        am amVar = new am();
        amVar.forumName = this.dZU;
        amVar.forumId = this.crJ;
        amVar.pn = -1;
        this.dZS.a(4, this.mPageType, amVar);
    }

    public void d(int i, String str, String str2) {
        this.mPageType = i;
        this.crJ = str;
        this.dZU = str2;
    }

    public void aoh() {
        if (this.dZT) {
            this.dZR.Qn();
            this.dZR.showLoadingView();
            aEm();
        }
    }

    public View getView() {
        return this.dZR.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.dZR.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.dZS.Ry();
    }

    public void b(aj ajVar) {
        this.dZV = ajVar;
    }
}
