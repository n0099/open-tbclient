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
    private String emo;
    private aq gkU;
    private b hBP;
    private String hBS;
    private aj hBT;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> gkP = new ArrayList();
    private boolean hBR = true;
    private View.OnClickListener hBU = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.hBR = true;
            c.this.bCw();
        }
    };
    private aj hBV = new aj() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<m> arrayList) {
            if (aqVar == null) {
                c.this.hBP.completePullRefresh();
                c.this.hBP.hideLoadingView();
                return;
            }
            c.this.gkU = aqVar;
            if ((c.this.gkU.pn == 0 || c.this.gkU.pn == 1) && c.this.gkU.hasMore && !c.this.gkU.isLocal) {
                c.this.bcg();
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
            if (c.this.hBT != null) {
                c.this.hBT.a(i, i2, aqVar, arrayList);
            }
            if (v.isEmpty(arrayList)) {
                if (c.this.hBR) {
                    c.this.hBP.hideLoadingView();
                    c.this.hBP.a(c.this.gkU.errMsg, c.this.hBU);
                } else {
                    c.this.hBP.completePullRefresh();
                    c.this.hBP.bMC();
                }
            } else {
                c.this.gkP = arrayList;
                c.this.hBP.cz(c.this.gkP);
                if (v.getCount(c.this.gkP) != 1 || !(v.getItem(c.this.gkP, 0) instanceof h)) {
                    if (c.this.gkU.hasMore) {
                        c.this.hBP.bMB();
                    } else {
                        c.this.hBP.bMD();
                    }
                } else {
                    c.this.hBP.bVy();
                }
                if (c.this.hBR) {
                    c.this.hBP.hideLoadingView();
                } else {
                    c.this.hBP.completePullRefresh();
                }
            }
            c.this.hBR = false;
        }
    };
    private d hBQ = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.hBP = new b(tbPageContext, this);
        this.hBQ.setTag(this.pageId);
        this.hBQ.init();
        this.hBQ.a(this.hBV);
    }

    public void da(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.hBP != null) {
            this.hBP.cZ(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hBP != null) {
            this.hBP.nE(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        bVA();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.hBP.bMC();
        }
        if (this.gkU != null) {
            if (!this.gkU.hasMore) {
                this.hBP.bMD();
            } else {
                bcg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcg() {
        if (this.gkU != null) {
            an anVar = new an();
            anVar.forumName = this.hBS;
            anVar.forumId = this.emo;
            this.gkU.pn++;
            anVar.pn = this.gkU.pn;
            this.hBQ.a(4, this.mPageType, anVar);
        }
    }

    private void bVA() {
        an anVar = new an();
        anVar.forumName = this.hBS;
        anVar.forumId = this.emo;
        anVar.pn = -1;
        this.hBQ.a(4, this.mPageType, anVar);
    }

    public void i(int i, String str, String str2) {
        this.mPageType = i;
        this.emo = str;
        this.hBS = str2;
    }

    public void bCw() {
        if (this.hBR) {
            this.hBP.bcy();
            this.hBP.showLoadingView();
            bVA();
        }
    }

    public View getView() {
        return this.hBP.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.hBP.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.hBQ.bgX();
    }

    public void b(aj ajVar) {
        this.hBT = ajVar;
    }
}
