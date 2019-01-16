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
    private ar dIf;
    private String dbr;
    private b eUI;
    private String eUL;
    private al eUM;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> dIa = new ArrayList();
    private boolean eUK = true;
    private View.OnClickListener eUN = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.eUK = true;
            c.this.aAD();
        }
    };
    private al eUO = new al() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            if (arVar == null) {
                c.this.eUI.completePullRefresh();
                c.this.eUI.hideLoadingView();
                return;
            }
            c.this.dIf = arVar;
            if ((c.this.dIf.pn == 0 || c.this.dIf.pn == 1) && c.this.dIf.hasMore && !c.this.dIf.isLocal) {
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
            if (c.this.eUM != null) {
                c.this.eUM.a(i, i2, arVar, arrayList);
            }
            if (v.I(arrayList)) {
                if (c.this.eUK) {
                    c.this.eUI.hideLoadingView();
                    c.this.eUI.a(c.this.dIf.errMsg, c.this.eUN);
                } else {
                    c.this.eUI.completePullRefresh();
                    c.this.eUI.aKR();
                }
            } else {
                c.this.dIa = arrayList;
                c.this.eUI.ci(c.this.dIa);
                if (v.H(c.this.dIa) != 1 || !(v.d(c.this.dIa, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.dIf.hasMore) {
                        c.this.eUI.aKQ();
                    } else {
                        c.this.eUI.aKS();
                    }
                } else {
                    c.this.eUI.aSO();
                }
                if (c.this.eUK) {
                    c.this.eUI.hideLoadingView();
                } else {
                    c.this.eUI.completePullRefresh();
                }
            }
            c.this.eUK = false;
        }
    };
    private d eUJ = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.eUI = new b(tbPageContext, this);
        this.eUJ.setTag(this.pageId);
        this.eUJ.init();
        this.eUJ.a(this.eUO);
    }

    public void cK(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.eUI != null) {
            this.eUI.cJ(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bG(boolean z) {
        if (this.eUI != null) {
            this.eUI.iI(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bI(boolean z) {
        aSQ();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.kV()) {
            this.eUI.aKR();
        }
        if (this.dIf != null) {
            if (!this.dIf.hasMore) {
                this.eUI.aKS();
            } else {
                aaA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaA() {
        if (this.dIf != null) {
            ao aoVar = new ao();
            aoVar.forumName = this.eUL;
            aoVar.forumId = this.dbr;
            this.dIf.pn++;
            aoVar.pn = this.dIf.pn;
            this.eUJ.a(4, this.mPageType, aoVar);
        }
    }

    private void aSQ() {
        ao aoVar = new ao();
        aoVar.forumName = this.eUL;
        aoVar.forumId = this.dbr;
        aoVar.pn = -1;
        this.eUJ.a(4, this.mPageType, aoVar);
    }

    public void g(int i, String str, String str2) {
        this.mPageType = i;
        this.dbr = str;
        this.eUL = str2;
    }

    public void aAD() {
        if (this.eUK) {
            this.eUI.abx();
            this.eUI.showLoadingView();
            aSQ();
        }
    }

    public View getView() {
        return this.eUI.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.eUI.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.eUJ.acK();
    }

    public void b(al alVar) {
        this.eUM = alVar;
    }
}
