package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.im.frsgroup.d;
import com.baidu.tieba.im.frsgroup.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes17.dex */
public class c implements BdListView.e, NoNetworkView.a, f.c {
    private String eKO;
    private bb hBF;
    private b jbS;
    private String jbV;
    private at jbW;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<q> hBA = new ArrayList();
    private boolean jbU = true;
    private View.OnClickListener jbX = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.jbU = true;
            c.this.bZO();
        }
    };
    private at jbY = new at() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.at
        public void a(int i, int i2, bb bbVar, ArrayList<q> arrayList) {
            if (bbVar == null) {
                c.this.jbS.completePullRefresh();
                c.this.jbS.hideLoadingView();
                return;
            }
            c.this.hBF = bbVar;
            if ((c.this.hBF.pn == 0 || c.this.hBF.pn == 1) && c.this.hBF.hasMore && !c.this.hBF.isLocal) {
                c.this.bwE();
                return;
            }
            if (arrayList != null) {
                Iterator<q> it = arrayList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if ((next instanceof m) || (next instanceof r)) {
                        it.remove();
                    }
                }
            }
            if (c.this.jbW != null) {
                c.this.jbW.a(i, i2, bbVar, arrayList);
            }
            if (x.isEmpty(arrayList)) {
                if (c.this.jbU) {
                    c.this.jbS.hideLoadingView();
                    c.this.jbS.a(c.this.hBF.errMsg, c.this.jbX);
                } else {
                    c.this.jbS.completePullRefresh();
                    c.this.jbS.ckT();
                }
            } else {
                c.this.hBA = arrayList;
                c.this.jbS.cX(c.this.hBA);
                if (x.getCount(c.this.hBA) != 1 || !(x.getItem(c.this.hBA, 0) instanceof h)) {
                    if (c.this.hBF.hasMore) {
                        c.this.jbS.ckS();
                    } else {
                        c.this.jbS.ckU();
                    }
                } else {
                    c.this.jbS.cuK();
                }
                if (c.this.jbU) {
                    c.this.jbS.hideLoadingView();
                } else {
                    c.this.jbS.completePullRefresh();
                }
            }
            c.this.jbU = false;
        }
    };
    private d jbT = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.jbS = new b(tbPageContext, this);
        this.jbT.setTag(this.pageId);
        this.jbT.init();
        this.jbT.a(this.jbY);
    }

    public void dF(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.jbS != null) {
            this.jbS.dE(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.jbS != null) {
            this.jbS.qb(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cuM();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.jbS.ckT();
        }
        if (this.hBF != null) {
            if (!this.hBF.hasMore) {
                this.jbS.ckU();
            } else {
                bwE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwE() {
        if (this.hBF != null) {
            ay ayVar = new ay();
            ayVar.forumName = this.jbV;
            ayVar.forumId = this.eKO;
            this.hBF.pn++;
            ayVar.pn = this.hBF.pn;
            this.jbT.a(4, this.mPageType, ayVar);
        }
    }

    private void cuM() {
        ay ayVar = new ay();
        ayVar.forumName = this.jbV;
        ayVar.forumId = this.eKO;
        ayVar.pn = -1;
        this.jbT.a(4, this.mPageType, ayVar);
    }

    public void j(int i, String str, String str2) {
        this.mPageType = i;
        this.eKO = str;
        this.jbV = str2;
    }

    public void bZO() {
        if (this.jbU) {
            this.jbS.bwX();
            this.jbS.showLoadingView();
            cuM();
        }
    }

    public View getView() {
        return this.jbS.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.jbS.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.jbT.bCu();
    }

    public void b(at atVar) {
        this.jbW = atVar;
    }
}
