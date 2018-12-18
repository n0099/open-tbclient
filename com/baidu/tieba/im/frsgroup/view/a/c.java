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
    private String cXO;
    private ar dEI;
    private b eRe;
    private String eRh;
    private al eRi;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> dED = new ArrayList();
    private boolean eRg = true;
    private View.OnClickListener eRj = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.eRg = true;
            c.this.azr();
        }
    };
    private al eRk = new al() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            if (arVar == null) {
                c.this.eRe.completePullRefresh();
                c.this.eRe.hideLoadingView();
                return;
            }
            c.this.dEI = arVar;
            if ((c.this.dEI.pn == 0 || c.this.dEI.pn == 1) && c.this.dEI.hasMore && !c.this.dEI.isLocal) {
                c.this.aab();
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
            if (c.this.eRi != null) {
                c.this.eRi.a(i, i2, arVar, arrayList);
            }
            if (v.I(arrayList)) {
                if (c.this.eRg) {
                    c.this.eRe.hideLoadingView();
                    c.this.eRe.a(c.this.dEI.errMsg, c.this.eRj);
                } else {
                    c.this.eRe.completePullRefresh();
                    c.this.eRe.aJE();
                }
            } else {
                c.this.dED = arrayList;
                c.this.eRe.cg(c.this.dED);
                if (v.H(c.this.dED) != 1 || !(v.d(c.this.dED, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.dEI.hasMore) {
                        c.this.eRe.aJD();
                    } else {
                        c.this.eRe.aJF();
                    }
                } else {
                    c.this.eRe.aRA();
                }
                if (c.this.eRg) {
                    c.this.eRe.hideLoadingView();
                } else {
                    c.this.eRe.completePullRefresh();
                }
            }
            c.this.eRg = false;
        }
    };
    private d eRf = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.eRe = new b(tbPageContext, this);
        this.eRf.setTag(this.pageId);
        this.eRf.init();
        this.eRf.a(this.eRk);
    }

    public void cI(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.eRe != null) {
            this.eRe.cH(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bF(boolean z) {
        if (this.eRe != null) {
            this.eRe.iF(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
        aRC();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.kV()) {
            this.eRe.aJE();
        }
        if (this.dEI != null) {
            if (!this.dEI.hasMore) {
                this.eRe.aJF();
            } else {
                aab();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        if (this.dEI != null) {
            ao aoVar = new ao();
            aoVar.forumName = this.eRh;
            aoVar.forumId = this.cXO;
            this.dEI.pn++;
            aoVar.pn = this.dEI.pn;
            this.eRf.a(4, this.mPageType, aoVar);
        }
    }

    private void aRC() {
        ao aoVar = new ao();
        aoVar.forumName = this.eRh;
        aoVar.forumId = this.cXO;
        aoVar.pn = -1;
        this.eRf.a(4, this.mPageType, aoVar);
    }

    public void g(int i, String str, String str2) {
        this.mPageType = i;
        this.cXO = str;
        this.eRh = str2;
    }

    public void azr() {
        if (this.eRg) {
            this.eRe.aaY();
            this.eRe.showLoadingView();
            aRC();
        }
    }

    public View getView() {
        return this.eRe.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.eRe.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.eRf.acl();
    }

    public void b(al alVar) {
        this.eRi = alVar;
    }
}
