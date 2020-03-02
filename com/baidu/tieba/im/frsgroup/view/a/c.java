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
    private String emb;
    private aq gkH;
    private b hBD;
    private String hBG;
    private aj hBH;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> gkC = new ArrayList();
    private boolean hBF = true;
    private View.OnClickListener hBI = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.hBF = true;
            c.this.bCv();
        }
    };
    private aj hBJ = new aj() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<m> arrayList) {
            if (aqVar == null) {
                c.this.hBD.completePullRefresh();
                c.this.hBD.hideLoadingView();
                return;
            }
            c.this.gkH = aqVar;
            if ((c.this.gkH.pn == 0 || c.this.gkH.pn == 1) && c.this.gkH.hasMore && !c.this.gkH.isLocal) {
                c.this.bcf();
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
            if (c.this.hBH != null) {
                c.this.hBH.a(i, i2, aqVar, arrayList);
            }
            if (v.isEmpty(arrayList)) {
                if (c.this.hBF) {
                    c.this.hBD.hideLoadingView();
                    c.this.hBD.a(c.this.gkH.errMsg, c.this.hBI);
                } else {
                    c.this.hBD.completePullRefresh();
                    c.this.hBD.bMB();
                }
            } else {
                c.this.gkC = arrayList;
                c.this.hBD.cz(c.this.gkC);
                if (v.getCount(c.this.gkC) != 1 || !(v.getItem(c.this.gkC, 0) instanceof h)) {
                    if (c.this.gkH.hasMore) {
                        c.this.hBD.bMA();
                    } else {
                        c.this.hBD.bMC();
                    }
                } else {
                    c.this.hBD.bVx();
                }
                if (c.this.hBF) {
                    c.this.hBD.hideLoadingView();
                } else {
                    c.this.hBD.completePullRefresh();
                }
            }
            c.this.hBF = false;
        }
    };
    private d hBE = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.hBD = new b(tbPageContext, this);
        this.hBE.setTag(this.pageId);
        this.hBE.init();
        this.hBE.a(this.hBJ);
    }

    public void da(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.hBD != null) {
            this.hBD.cZ(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hBD != null) {
            this.hBD.nE(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        bVz();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.hBD.bMB();
        }
        if (this.gkH != null) {
            if (!this.gkH.hasMore) {
                this.hBD.bMC();
            } else {
                bcf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcf() {
        if (this.gkH != null) {
            an anVar = new an();
            anVar.forumName = this.hBG;
            anVar.forumId = this.emb;
            this.gkH.pn++;
            anVar.pn = this.gkH.pn;
            this.hBE.a(4, this.mPageType, anVar);
        }
    }

    private void bVz() {
        an anVar = new an();
        anVar.forumName = this.hBG;
        anVar.forumId = this.emb;
        anVar.pn = -1;
        this.hBE.a(4, this.mPageType, anVar);
    }

    public void i(int i, String str, String str2) {
        this.mPageType = i;
        this.emb = str;
        this.hBG = str2;
    }

    public void bCv() {
        if (this.hBF) {
            this.hBD.bcx();
            this.hBD.showLoadingView();
            bVz();
        }
    }

    public View getView() {
        return this.hBD.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.hBD.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.hBE.bgW();
    }

    public void b(aj ajVar) {
        this.hBH = ajVar;
    }
}
