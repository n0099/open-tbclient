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
    private String cRh;
    private ar dyj;
    private b eKp;
    private String eKs;
    private al eKt;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> dye = new ArrayList();
    private boolean eKr = true;
    private View.OnClickListener eKu = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.eKr = true;
            c.this.axH();
        }
    };
    private al eKv = new al() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            if (arVar == null) {
                c.this.eKp.completePullRefresh();
                c.this.eKp.hideLoadingView();
                return;
            }
            c.this.dyj = arVar;
            if ((c.this.dyj.pn == 0 || c.this.dyj.pn == 1) && c.this.dyj.hasMore && !c.this.dyj.isLocal) {
                c.this.YV();
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
            if (c.this.eKt != null) {
                c.this.eKt.a(i, i2, arVar, arrayList);
            }
            if (v.I(arrayList)) {
                if (c.this.eKr) {
                    c.this.eKp.hideLoadingView();
                    c.this.eKp.a(c.this.dyj.errMsg, c.this.eKu);
                } else {
                    c.this.eKp.completePullRefresh();
                    c.this.eKp.aHN();
                }
            } else {
                c.this.dye = arrayList;
                c.this.eKp.cc(c.this.dye);
                if (v.H(c.this.dye) != 1 || !(v.d(c.this.dye, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.dyj.hasMore) {
                        c.this.eKp.aHM();
                    } else {
                        c.this.eKp.aHO();
                    }
                } else {
                    c.this.eKp.aPJ();
                }
                if (c.this.eKr) {
                    c.this.eKp.hideLoadingView();
                } else {
                    c.this.eKp.completePullRefresh();
                }
            }
            c.this.eKr = false;
        }
    };
    private d eKq = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.eKp = new b(tbPageContext, this);
        this.eKq.setTag(this.pageId);
        this.eKq.init();
        this.eKq.a(this.eKv);
    }

    public void cE(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.eKp != null) {
            this.eKp.cD(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bE(boolean z) {
        if (this.eKp != null) {
            this.eKp.iC(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bG(boolean z) {
        aPL();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.kV()) {
            this.eKp.aHN();
        }
        if (this.dyj != null) {
            if (!this.dyj.hasMore) {
                this.eKp.aHO();
            } else {
                YV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YV() {
        if (this.dyj != null) {
            ao aoVar = new ao();
            aoVar.forumName = this.eKs;
            aoVar.forumId = this.cRh;
            this.dyj.pn++;
            aoVar.pn = this.dyj.pn;
            this.eKq.a(4, this.mPageType, aoVar);
        }
    }

    private void aPL() {
        ao aoVar = new ao();
        aoVar.forumName = this.eKs;
        aoVar.forumId = this.cRh;
        aoVar.pn = -1;
        this.eKq.a(4, this.mPageType, aoVar);
    }

    public void f(int i, String str, String str2) {
        this.mPageType = i;
        this.cRh = str;
        this.eKs = str2;
    }

    public void axH() {
        if (this.eKr) {
            this.eKp.ZS();
            this.eKp.showLoadingView();
            aPL();
        }
    }

    public View getView() {
        return this.eKp.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.eKp.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.eKq.abf();
    }

    public void b(al alVar) {
        this.eKt = alVar;
    }
}
