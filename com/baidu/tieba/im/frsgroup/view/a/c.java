package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.im.frsgroup.d;
import com.baidu.tieba.im.frsgroup.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements BdListView.e, NoNetworkView.a, g.c {
    private String ema;
    private aq gkF;
    private b hBB;
    private String hBE;
    private aj hBF;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> gkA = new ArrayList();
    private boolean hBD = true;
    private View.OnClickListener hBG = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.hBD = true;
            c.this.bCt();
        }
    };
    private aj hBH = new aj() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<m> arrayList) {
            if (aqVar == null) {
                c.this.hBB.completePullRefresh();
                c.this.hBB.hideLoadingView();
                return;
            }
            c.this.gkF = aqVar;
            if ((c.this.gkF.pn == 0 || c.this.gkF.pn == 1) && c.this.gkF.hasMore && !c.this.gkF.isLocal) {
                c.this.bcd();
                return;
            }
            if (arrayList != null) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    m next = it.next();
                    if ((next instanceof j) || (next instanceof n)) {
                        it.remove();
                    }
                }
            }
            if (c.this.hBF != null) {
                c.this.hBF.a(i, i2, aqVar, arrayList);
            }
            if (v.isEmpty(arrayList)) {
                if (c.this.hBD) {
                    c.this.hBB.hideLoadingView();
                    c.this.hBB.a(c.this.gkF.errMsg, c.this.hBG);
                } else {
                    c.this.hBB.completePullRefresh();
                    c.this.hBB.bMz();
                }
            } else {
                c.this.gkA = arrayList;
                c.this.hBB.cz(c.this.gkA);
                if (v.getCount(c.this.gkA) != 1 || !(v.getItem(c.this.gkA, 0) instanceof h)) {
                    if (c.this.gkF.hasMore) {
                        c.this.hBB.bMy();
                    } else {
                        c.this.hBB.bMA();
                    }
                } else {
                    c.this.hBB.bVv();
                }
                if (c.this.hBD) {
                    c.this.hBB.hideLoadingView();
                } else {
                    c.this.hBB.completePullRefresh();
                }
            }
            c.this.hBD = false;
        }
    };
    private d hBC = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.hBB = new b(tbPageContext, this);
        this.hBC.setTag(this.pageId);
        this.hBC.init();
        this.hBC.a(this.hBH);
    }

    public void da(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.hBB != null) {
            this.hBB.cZ(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hBB != null) {
            this.hBB.nE(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        bVx();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.hBB.bMz();
        }
        if (this.gkF != null) {
            if (!this.gkF.hasMore) {
                this.hBB.bMA();
            } else {
                bcd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcd() {
        if (this.gkF != null) {
            an anVar = new an();
            anVar.forumName = this.hBE;
            anVar.forumId = this.ema;
            this.gkF.pn++;
            anVar.pn = this.gkF.pn;
            this.hBC.a(4, this.mPageType, anVar);
        }
    }

    private void bVx() {
        an anVar = new an();
        anVar.forumName = this.hBE;
        anVar.forumId = this.ema;
        anVar.pn = -1;
        this.hBC.a(4, this.mPageType, anVar);
    }

    public void i(int i, String str, String str2) {
        this.mPageType = i;
        this.ema = str;
        this.hBE = str2;
    }

    public void bCt() {
        if (this.hBD) {
            this.hBB.bcv();
            this.hBB.showLoadingView();
            bVx();
        }
    }

    public View getView() {
        return this.hBB.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.hBB.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.hBC.bgU();
    }

    public void b(aj ajVar) {
        this.hBF = ajVar;
    }
}
