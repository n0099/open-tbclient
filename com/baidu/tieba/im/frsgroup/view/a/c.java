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
    private ar dHw;
    private String daG;
    private b eTV;
    private String eTY;
    private al eTZ;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> dHr = new ArrayList();
    private boolean eTX = true;
    private View.OnClickListener eUa = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.eTX = true;
            c.this.aAg();
        }
    };
    private al eUb = new al() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            if (arVar == null) {
                c.this.eTV.completePullRefresh();
                c.this.eTV.hideLoadingView();
                return;
            }
            c.this.dHw = arVar;
            if ((c.this.dHw.pn == 0 || c.this.dHw.pn == 1) && c.this.dHw.hasMore && !c.this.dHw.isLocal) {
                c.this.aad();
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
            if (c.this.eTZ != null) {
                c.this.eTZ.a(i, i2, arVar, arrayList);
            }
            if (v.I(arrayList)) {
                if (c.this.eTX) {
                    c.this.eTV.hideLoadingView();
                    c.this.eTV.a(c.this.dHw.errMsg, c.this.eUa);
                } else {
                    c.this.eTV.completePullRefresh();
                    c.this.eTV.aKt();
                }
            } else {
                c.this.dHr = arrayList;
                c.this.eTV.ch(c.this.dHr);
                if (v.H(c.this.dHr) != 1 || !(v.d(c.this.dHr, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.dHw.hasMore) {
                        c.this.eTV.aKs();
                    } else {
                        c.this.eTV.aKu();
                    }
                } else {
                    c.this.eTV.aSo();
                }
                if (c.this.eTX) {
                    c.this.eTV.hideLoadingView();
                } else {
                    c.this.eTV.completePullRefresh();
                }
            }
            c.this.eTX = false;
        }
    };
    private d eTW = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.eTV = new b(tbPageContext, this);
        this.eTW.setTag(this.pageId);
        this.eTW.init();
        this.eTW.a(this.eUb);
    }

    public void cJ(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.eTV != null) {
            this.eTV.cI(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bF(boolean z) {
        if (this.eTV != null) {
            this.eTV.iI(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
        aSq();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.kV()) {
            this.eTV.aKt();
        }
        if (this.dHw != null) {
            if (!this.dHw.hasMore) {
                this.eTV.aKu();
            } else {
                aad();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aad() {
        if (this.dHw != null) {
            ao aoVar = new ao();
            aoVar.forumName = this.eTY;
            aoVar.forumId = this.daG;
            this.dHw.pn++;
            aoVar.pn = this.dHw.pn;
            this.eTW.a(4, this.mPageType, aoVar);
        }
    }

    private void aSq() {
        ao aoVar = new ao();
        aoVar.forumName = this.eTY;
        aoVar.forumId = this.daG;
        aoVar.pn = -1;
        this.eTW.a(4, this.mPageType, aoVar);
    }

    public void g(int i, String str, String str2) {
        this.mPageType = i;
        this.daG = str;
        this.eTY = str2;
    }

    public void aAg() {
        if (this.eTX) {
            this.eTV.aba();
            this.eTV.showLoadingView();
            aSq();
        }
    }

    public View getView() {
        return this.eTV.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.eTV.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.eTW.acn();
    }

    public void b(al alVar) {
        this.eTZ = alVar;
    }
}
