package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.im.frsgroup.d;
import com.baidu.tieba.im.frsgroup.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes23.dex */
public class c implements BdListView.e, NoNetworkView.a, f.c {
    private String fFV;
    private bd iPc;
    private b kve;
    private String kvh;
    private au kvi;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<q> iOX = new ArrayList();
    private boolean kvg = true;
    private View.OnClickListener kvj = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.kvg = true;
            c.this.cAx();
        }
    };
    private au kvk = new au() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.au
        public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
            if (bdVar == null) {
                c.this.kve.completePullRefresh();
                c.this.kve.hideLoadingView();
                return;
            }
            c.this.iPc = bdVar;
            if ((c.this.iPc.pn == 0 || c.this.iPc.pn == 1) && c.this.iPc.hasMore && !c.this.iPc.isLocal) {
                c.this.bRN();
                return;
            }
            if (arrayList != null) {
                Iterator<q> it = arrayList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if ((next instanceof n) || (next instanceof s)) {
                        it.remove();
                    }
                }
            }
            if (c.this.kvi != null) {
                c.this.kvi.a(i, i2, bdVar, arrayList);
            }
            if (y.isEmpty(arrayList)) {
                if (c.this.kvg) {
                    c.this.kve.hideLoadingView();
                    c.this.kve.d(c.this.iPc.errMsg, c.this.kvj);
                } else {
                    c.this.kve.completePullRefresh();
                    c.this.kve.cMQ();
                }
            } else {
                c.this.iOX = arrayList;
                c.this.kve.dH(c.this.iOX);
                if (y.getCount(c.this.iOX) != 1 || !(y.getItem(c.this.iOX, 0) instanceof h)) {
                    if (c.this.iPc.hasMore) {
                        c.this.kve.cMP();
                    } else {
                        c.this.kve.cMR();
                    }
                } else {
                    c.this.kve.cXs();
                }
                if (c.this.kvg) {
                    c.this.kve.hideLoadingView();
                } else {
                    c.this.kve.completePullRefresh();
                }
            }
            c.this.kvg = false;
        }
    };
    private d kvf = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.kve = new b(tbPageContext, this);
        this.kvf.setTag(this.pageId);
        this.kvf.init();
        this.kvf.a(this.kvk);
    }

    public void ez(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.kve != null) {
            this.kve.ey(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.kve != null) {
            this.kve.sD(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cXu();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.kve.cMQ();
        }
        if (this.iPc != null) {
            if (!this.iPc.hasMore) {
                this.kve.cMR();
            } else {
                bRN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRN() {
        if (this.iPc != null) {
            ba baVar = new ba();
            baVar.forumName = this.kvh;
            baVar.forumId = this.fFV;
            this.iPc.pn++;
            baVar.pn = this.iPc.pn;
            this.kvf.a(4, this.mPageType, baVar);
        }
    }

    private void cXu() {
        ba baVar = new ba();
        baVar.forumName = this.kvh;
        baVar.forumId = this.fFV;
        baVar.pn = -1;
        this.kvf.a(4, this.mPageType, baVar);
    }

    public void m(int i, String str, String str2) {
        this.mPageType = i;
        this.fFV = str;
        this.kvh = str2;
    }

    public void cAx() {
        if (this.kvg) {
            this.kve.Yb();
            this.kve.showLoadingView();
            cXu();
        }
    }

    public View getView() {
        return this.kve.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.kve.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.kvf.bYZ();
    }

    public void b(au auVar) {
        this.kvi = auVar;
    }
}
