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
    private ap eVg;
    private String ekN;
    private b gkE;
    private String gkH;
    private ai gkI;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> eVb = new ArrayList();
    private boolean gkG = true;
    private View.OnClickListener gkJ = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.gkG = true;
            c.this.bba();
        }
    };
    private ai gkK = new ai() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
            if (apVar == null) {
                c.this.gkE.completePullRefresh();
                c.this.gkE.hideLoadingView();
                return;
            }
            c.this.eVg = apVar;
            if ((c.this.eVg.pn == 0 || c.this.eVg.pn == 1) && c.this.eVg.hasMore && !c.this.eVg.isLocal) {
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
            if (c.this.gkI != null) {
                c.this.gkI.a(i, i2, apVar, arrayList);
            }
            if (v.T(arrayList)) {
                if (c.this.gkG) {
                    c.this.gkE.hideLoadingView();
                    c.this.gkE.a(c.this.eVg.errMsg, c.this.gkJ);
                } else {
                    c.this.gkE.completePullRefresh();
                    c.this.gkE.bkV();
                }
            } else {
                c.this.eVb = arrayList;
                c.this.gkE.cp(c.this.eVb);
                if (v.S(c.this.eVb) != 1 || !(v.c(c.this.eVb, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.eVg.hasMore) {
                        c.this.gkE.bkU();
                    } else {
                        c.this.gkE.bkW();
                    }
                } else {
                    c.this.gkE.btq();
                }
                if (c.this.gkG) {
                    c.this.gkE.hideLoadingView();
                } else {
                    c.this.gkE.completePullRefresh();
                }
            }
            c.this.gkG = false;
        }
    };
    private d gkF = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.gkE = new b(tbPageContext, this);
        this.gkF.setTag(this.pageId);
        this.gkF.init();
        this.gkF.a(this.gkK);
    }

    public void cT(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.gkE != null) {
            this.gkE.cS(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void dP(boolean z) {
        if (this.gkE != null) {
            this.gkE.li(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        bts();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.kY()) {
            this.gkE.bkV();
        }
        if (this.eVg != null) {
            if (!this.eVg.hasMore) {
                this.gkE.bkW();
            } else {
                aAZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAZ() {
        if (this.eVg != null) {
            am amVar = new am();
            amVar.forumName = this.gkH;
            amVar.forumId = this.ekN;
            this.eVg.pn++;
            amVar.pn = this.eVg.pn;
            this.gkF.a(4, this.mPageType, amVar);
        }
    }

    private void bts() {
        am amVar = new am();
        amVar.forumName = this.gkH;
        amVar.forumId = this.ekN;
        amVar.pn = -1;
        this.gkF.a(4, this.mPageType, amVar);
    }

    public void g(int i, String str, String str2) {
        this.mPageType = i;
        this.ekN = str;
        this.gkH = str2;
    }

    public void bba() {
        if (this.gkG) {
            this.gkE.aBq();
            this.gkE.showLoadingView();
            bts();
        }
    }

    public View getView() {
        return this.gkE.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.gkE.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.gkF.aDC();
    }

    public void b(ai aiVar) {
        this.gkI = aiVar;
    }
}
