package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.im.frsgroup.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements BdListView.e, NoNetworkView.a, j.b {
    private ar dIg;
    private String dbs;
    private b eUJ;
    private String eUM;
    private al eUN;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> dIb = new ArrayList();
    private boolean eUL = true;
    private View.OnClickListener eUO = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.eUL = true;
            c.this.aAD();
        }
    };
    private al eUP = new al() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            if (arVar == null) {
                c.this.eUJ.completePullRefresh();
                c.this.eUJ.hideLoadingView();
                return;
            }
            c.this.dIg = arVar;
            if ((c.this.dIg.pn == 0 || c.this.dIg.pn == 1) && c.this.dIg.hasMore && !c.this.dIg.isLocal) {
                c.this.aaA();
                return;
            }
            if (arrayList != null) {
                Iterator<h> it = arrayList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if ((next instanceof i) || (next instanceof m)) {
                        it.remove();
                    }
                }
            }
            if (c.this.eUN != null) {
                c.this.eUN.a(i, i2, arVar, arrayList);
            }
            if (v.I(arrayList)) {
                if (c.this.eUL) {
                    c.this.eUJ.hideLoadingView();
                    c.this.eUJ.a(c.this.dIg.errMsg, c.this.eUO);
                } else {
                    c.this.eUJ.completePullRefresh();
                    c.this.eUJ.aKR();
                }
            } else {
                c.this.dIb = arrayList;
                c.this.eUJ.ci(c.this.dIb);
                if (v.H(c.this.dIb) != 1 || !(v.d(c.this.dIb, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.dIg.hasMore) {
                        c.this.eUJ.aKQ();
                    } else {
                        c.this.eUJ.aKS();
                    }
                } else {
                    c.this.eUJ.aSO();
                }
                if (c.this.eUL) {
                    c.this.eUJ.hideLoadingView();
                } else {
                    c.this.eUJ.completePullRefresh();
                }
            }
            c.this.eUL = false;
        }
    };
    private d eUK = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.eUJ = new b(tbPageContext, this);
        this.eUK.setTag(this.pageId);
        this.eUK.init();
        this.eUK.a(this.eUP);
    }

    public void cK(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.eUJ != null) {
            this.eUJ.cJ(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bG(boolean z) {
        if (this.eUJ != null) {
            this.eUJ.iI(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bI(boolean z) {
        aSQ();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.kV()) {
            this.eUJ.aKR();
        }
        if (this.dIg != null) {
            if (!this.dIg.hasMore) {
                this.eUJ.aKS();
            } else {
                aaA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaA() {
        if (this.dIg != null) {
            ao aoVar = new ao();
            aoVar.forumName = this.eUM;
            aoVar.forumId = this.dbs;
            this.dIg.pn++;
            aoVar.pn = this.dIg.pn;
            this.eUK.a(4, this.mPageType, aoVar);
        }
    }

    private void aSQ() {
        ao aoVar = new ao();
        aoVar.forumName = this.eUM;
        aoVar.forumId = this.dbs;
        aoVar.pn = -1;
        this.eUK.a(4, this.mPageType, aoVar);
    }

    public void g(int i, String str, String str2) {
        this.mPageType = i;
        this.dbs = str;
        this.eUM = str2;
    }

    public void aAD() {
        if (this.eUL) {
            this.eUJ.abx();
            this.eUJ.showLoadingView();
            aSQ();
        }
    }

    public View getView() {
        return this.eUJ.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.eUJ.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.eUK.acK();
    }

    public void b(al alVar) {
        this.eUN = alVar;
    }
}
