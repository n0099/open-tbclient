package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.im.frsgroup.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class c implements BdListView.e, NoNetworkView.a, h.c {
    private ap eVf;
    private String ekM;
    private b gkD;
    private String gkG;
    private ai gkH;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> eVa = new ArrayList();
    private boolean gkF = true;
    private View.OnClickListener gkI = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.gkF = true;
            c.this.bba();
        }
    };
    private ai gkJ = new ai() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
            if (apVar == null) {
                c.this.gkD.completePullRefresh();
                c.this.gkD.hideLoadingView();
                return;
            }
            c.this.eVf = apVar;
            if ((c.this.eVf.pn == 0 || c.this.eVf.pn == 1) && c.this.eVf.hasMore && !c.this.eVf.isLocal) {
                c.this.aAZ();
                return;
            }
            if (arrayList != null) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    m next = it.next();
                    if ((next instanceof i) || (next instanceof com.baidu.tieba.frs.m)) {
                        it.remove();
                    }
                }
            }
            if (c.this.gkH != null) {
                c.this.gkH.a(i, i2, apVar, arrayList);
            }
            if (v.T(arrayList)) {
                if (c.this.gkF) {
                    c.this.gkD.hideLoadingView();
                    c.this.gkD.a(c.this.eVf.errMsg, c.this.gkI);
                } else {
                    c.this.gkD.completePullRefresh();
                    c.this.gkD.bkV();
                }
            } else {
                c.this.eVa = arrayList;
                c.this.gkD.cp(c.this.eVa);
                if (v.S(c.this.eVa) != 1 || !(v.c(c.this.eVa, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.eVf.hasMore) {
                        c.this.gkD.bkU();
                    } else {
                        c.this.gkD.bkW();
                    }
                } else {
                    c.this.gkD.btq();
                }
                if (c.this.gkF) {
                    c.this.gkD.hideLoadingView();
                } else {
                    c.this.gkD.completePullRefresh();
                }
            }
            c.this.gkF = false;
        }
    };
    private d gkE = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.gkD = new b(tbPageContext, this);
        this.gkE.setTag(this.pageId);
        this.gkE.init();
        this.gkE.a(this.gkJ);
    }

    public void cT(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.gkD != null) {
            this.gkD.cS(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void dP(boolean z) {
        if (this.gkD != null) {
            this.gkD.li(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        bts();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.kY()) {
            this.gkD.bkV();
        }
        if (this.eVf != null) {
            if (!this.eVf.hasMore) {
                this.gkD.bkW();
            } else {
                aAZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAZ() {
        if (this.eVf != null) {
            am amVar = new am();
            amVar.forumName = this.gkG;
            amVar.forumId = this.ekM;
            this.eVf.pn++;
            amVar.pn = this.eVf.pn;
            this.gkE.a(4, this.mPageType, amVar);
        }
    }

    private void bts() {
        am amVar = new am();
        amVar.forumName = this.gkG;
        amVar.forumId = this.ekM;
        amVar.pn = -1;
        this.gkE.a(4, this.mPageType, amVar);
    }

    public void g(int i, String str, String str2) {
        this.mPageType = i;
        this.ekM = str;
        this.gkG = str2;
    }

    public void bba() {
        if (this.gkF) {
            this.gkD.aBq();
            this.gkD.showLoadingView();
            bts();
        }
    }

    public View getView() {
        return this.gkD.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.gkD.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.gkE.aDC();
    }

    public void b(ai aiVar) {
        this.gkH = aiVar;
    }
}
