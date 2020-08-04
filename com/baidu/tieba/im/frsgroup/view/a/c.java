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
    private b jbU;
    private String jbX;
    private at jbY;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<q> hBA = new ArrayList();
    private boolean jbW = true;
    private View.OnClickListener jbZ = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.jbW = true;
            c.this.bZO();
        }
    };
    private at jca = new at() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.at
        public void a(int i, int i2, bb bbVar, ArrayList<q> arrayList) {
            if (bbVar == null) {
                c.this.jbU.completePullRefresh();
                c.this.jbU.hideLoadingView();
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
            if (c.this.jbY != null) {
                c.this.jbY.a(i, i2, bbVar, arrayList);
            }
            if (x.isEmpty(arrayList)) {
                if (c.this.jbW) {
                    c.this.jbU.hideLoadingView();
                    c.this.jbU.a(c.this.hBF.errMsg, c.this.jbZ);
                } else {
                    c.this.jbU.completePullRefresh();
                    c.this.jbU.ckT();
                }
            } else {
                c.this.hBA = arrayList;
                c.this.jbU.cX(c.this.hBA);
                if (x.getCount(c.this.hBA) != 1 || !(x.getItem(c.this.hBA, 0) instanceof h)) {
                    if (c.this.hBF.hasMore) {
                        c.this.jbU.ckS();
                    } else {
                        c.this.jbU.ckU();
                    }
                } else {
                    c.this.jbU.cuK();
                }
                if (c.this.jbW) {
                    c.this.jbU.hideLoadingView();
                } else {
                    c.this.jbU.completePullRefresh();
                }
            }
            c.this.jbW = false;
        }
    };
    private d jbV = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.jbU = new b(tbPageContext, this);
        this.jbV.setTag(this.pageId);
        this.jbV.init();
        this.jbV.a(this.jca);
    }

    public void dF(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.jbU != null) {
            this.jbU.dE(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.jbU != null) {
            this.jbU.qb(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cuM();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.jbU.ckT();
        }
        if (this.hBF != null) {
            if (!this.hBF.hasMore) {
                this.jbU.ckU();
            } else {
                bwE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwE() {
        if (this.hBF != null) {
            ay ayVar = new ay();
            ayVar.forumName = this.jbX;
            ayVar.forumId = this.eKO;
            this.hBF.pn++;
            ayVar.pn = this.hBF.pn;
            this.jbV.a(4, this.mPageType, ayVar);
        }
    }

    private void cuM() {
        ay ayVar = new ay();
        ayVar.forumName = this.jbX;
        ayVar.forumId = this.eKO;
        ayVar.pn = -1;
        this.jbV.a(4, this.mPageType, ayVar);
    }

    public void j(int i, String str, String str2) {
        this.mPageType = i;
        this.eKO = str;
        this.jbX = str2;
    }

    public void bZO() {
        if (this.jbW) {
            this.jbU.bwX();
            this.jbU.showLoadingView();
            cuM();
        }
    }

    public View getView() {
        return this.jbU.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.jbU.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.jbV.bCu();
    }

    public void b(at atVar) {
        this.jbY = atVar;
    }
}
