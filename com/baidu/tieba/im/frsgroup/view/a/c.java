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
    private bd iPa;
    private b kvc;
    private String kvf;
    private au kvg;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<q> iOV = new ArrayList();
    private boolean kve = true;
    private View.OnClickListener kvh = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.kve = true;
            c.this.cAw();
        }
    };
    private au kvi = new au() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.au
        public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
            if (bdVar == null) {
                c.this.kvc.completePullRefresh();
                c.this.kvc.hideLoadingView();
                return;
            }
            c.this.iPa = bdVar;
            if ((c.this.iPa.pn == 0 || c.this.iPa.pn == 1) && c.this.iPa.hasMore && !c.this.iPa.isLocal) {
                c.this.bRM();
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
            if (c.this.kvg != null) {
                c.this.kvg.a(i, i2, bdVar, arrayList);
            }
            if (y.isEmpty(arrayList)) {
                if (c.this.kve) {
                    c.this.kvc.hideLoadingView();
                    c.this.kvc.d(c.this.iPa.errMsg, c.this.kvh);
                } else {
                    c.this.kvc.completePullRefresh();
                    c.this.kvc.cMP();
                }
            } else {
                c.this.iOV = arrayList;
                c.this.kvc.dH(c.this.iOV);
                if (y.getCount(c.this.iOV) != 1 || !(y.getItem(c.this.iOV, 0) instanceof h)) {
                    if (c.this.iPa.hasMore) {
                        c.this.kvc.cMO();
                    } else {
                        c.this.kvc.cMQ();
                    }
                } else {
                    c.this.kvc.cXr();
                }
                if (c.this.kve) {
                    c.this.kvc.hideLoadingView();
                } else {
                    c.this.kvc.completePullRefresh();
                }
            }
            c.this.kve = false;
        }
    };
    private d kvd = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.kvc = new b(tbPageContext, this);
        this.kvd.setTag(this.pageId);
        this.kvd.init();
        this.kvd.a(this.kvi);
    }

    public void ez(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.kvc != null) {
            this.kvc.ey(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.kvc != null) {
            this.kvc.sD(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cXt();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.kvc.cMP();
        }
        if (this.iPa != null) {
            if (!this.iPa.hasMore) {
                this.kvc.cMQ();
            } else {
                bRM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRM() {
        if (this.iPa != null) {
            ba baVar = new ba();
            baVar.forumName = this.kvf;
            baVar.forumId = this.fFV;
            this.iPa.pn++;
            baVar.pn = this.iPa.pn;
            this.kvd.a(4, this.mPageType, baVar);
        }
    }

    private void cXt() {
        ba baVar = new ba();
        baVar.forumName = this.kvf;
        baVar.forumId = this.fFV;
        baVar.pn = -1;
        this.kvd.a(4, this.mPageType, baVar);
    }

    public void m(int i, String str, String str2) {
        this.mPageType = i;
        this.fFV = str;
        this.kvf = str2;
    }

    public void cAw() {
        if (this.kve) {
            this.kvc.Yb();
            this.kvc.showLoadingView();
            cXt();
        }
    }

    public View getView() {
        return this.kvc.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.kvc.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.kvd.bYY();
    }

    public void b(au auVar) {
        this.kvg = auVar;
    }
}
