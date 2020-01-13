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
/* loaded from: classes8.dex */
public class c implements BdListView.e, NoNetworkView.a, g.c {
    private String fKa;
    private aq giE;
    private b hzC;
    private String hzF;
    private aj hzG;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> giz = new ArrayList();
    private boolean hzE = true;
    private View.OnClickListener hzH = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.hzE = true;
            c.this.bAR();
        }
    };
    private aj hzI = new aj() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<m> arrayList) {
            if (aqVar == null) {
                c.this.hzC.completePullRefresh();
                c.this.hzC.hideLoadingView();
                return;
            }
            c.this.giE = aqVar;
            if ((c.this.giE.pn == 0 || c.this.giE.pn == 1) && c.this.giE.hasMore && !c.this.giE.isLocal) {
                c.this.aZN();
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
            if (c.this.hzG != null) {
                c.this.hzG.a(i, i2, aqVar, arrayList);
            }
            if (v.isEmpty(arrayList)) {
                if (c.this.hzE) {
                    c.this.hzC.hideLoadingView();
                    c.this.hzC.a(c.this.giE.errMsg, c.this.hzH);
                } else {
                    c.this.hzC.completePullRefresh();
                    c.this.hzC.bKX();
                }
            } else {
                c.this.giz = arrayList;
                c.this.hzC.cD(c.this.giz);
                if (v.getCount(c.this.giz) != 1 || !(v.getItem(c.this.giz, 0) instanceof h)) {
                    if (c.this.giE.hasMore) {
                        c.this.hzC.bKW();
                    } else {
                        c.this.hzC.bKY();
                    }
                } else {
                    c.this.hzC.bTU();
                }
                if (c.this.hzE) {
                    c.this.hzC.hideLoadingView();
                } else {
                    c.this.hzC.completePullRefresh();
                }
            }
            c.this.hzE = false;
        }
    };
    private d hzD = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.hzC = new b(tbPageContext, this);
        this.hzD.setTag(this.pageId);
        this.hzD.init();
        this.hzD.a(this.hzI);
    }

    public void de(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.hzC != null) {
            this.hzC.dd(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hzC != null) {
            this.hzC.nC(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        bTW();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.hzC.bKX();
        }
        if (this.giE != null) {
            if (!this.giE.hasMore) {
                this.hzC.bKY();
            } else {
                aZN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZN() {
        if (this.giE != null) {
            an anVar = new an();
            anVar.forumName = this.hzF;
            anVar.forumId = this.fKa;
            this.giE.pn++;
            anVar.pn = this.giE.pn;
            this.hzD.a(4, this.mPageType, anVar);
        }
    }

    private void bTW() {
        an anVar = new an();
        anVar.forumName = this.hzF;
        anVar.forumId = this.fKa;
        anVar.pn = -1;
        this.hzD.a(4, this.mPageType, anVar);
    }

    public void i(int i, String str, String str2) {
        this.mPageType = i;
        this.fKa = str;
        this.hzF = str2;
    }

    public void bAR() {
        if (this.hzE) {
            this.hzC.baf();
            this.hzC.showLoadingView();
            bTW();
        }
    }

    public View getView() {
        return this.hzC.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.hzC.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.hzD.beK();
    }

    public void b(aj ajVar) {
        this.hzG = ajVar;
    }
}
