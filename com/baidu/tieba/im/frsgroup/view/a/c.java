package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.im.frsgroup.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements BdListView.e, NoNetworkView.a, j.b {
    private String cZL;
    private at dBp;
    private b eFm;
    private String eFp;
    private an eFq;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<i> dBk = new ArrayList();
    private boolean eFo = true;
    private View.OnClickListener eFr = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.eFo = true;
            c.this.atS();
        }
    };
    private an eFs = new an() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<i> arrayList) {
            if (atVar == null) {
                c.this.eFm.completePullRefresh();
                c.this.eFm.VV();
                return;
            }
            c.this.dBp = atVar;
            if ((c.this.dBp.pn == 0 || c.this.dBp.pn == 1) && c.this.dBp.hasMore && !c.this.dBp.isLocal) {
                c.this.WO();
                return;
            }
            if (arrayList != null) {
                Iterator<i> it = arrayList.iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    if ((next instanceof h) || (next instanceof m)) {
                        it.remove();
                    }
                }
            }
            if (c.this.eFq != null) {
                c.this.eFq.a(i, i2, atVar, arrayList);
            }
            if (v.E(arrayList)) {
                if (c.this.eFo) {
                    c.this.eFm.VV();
                    c.this.eFm.a(c.this.dBp.errMsg, c.this.eFr);
                } else {
                    c.this.eFm.completePullRefresh();
                    c.this.eFm.aBL();
                }
            } else {
                c.this.dBk = arrayList;
                c.this.eFm.bI(c.this.dBk);
                if (v.D(c.this.dBk) != 1 || !(v.f(c.this.dBk, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.dBp.hasMore) {
                        c.this.eFm.aBK();
                    } else {
                        c.this.eFm.aBM();
                    }
                } else {
                    c.this.eFm.aJn();
                }
                if (c.this.eFo) {
                    c.this.eFm.VV();
                } else {
                    c.this.eFm.completePullRefresh();
                }
            }
            c.this.eFo = false;
        }
    };
    private d eFn = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.eFm = new b(tbPageContext, this);
        this.eFn.setTag(this.pageId);
        this.eFn.init();
        this.eFn.a(this.eFs);
    }

    public void cl(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.eFm != null) {
            this.eFm.ck(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bu(boolean z) {
        if (this.eFm != null) {
            this.eFm.hJ(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
        aJp();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.oJ()) {
            this.eFm.aBL();
        }
        if (this.dBp != null) {
            if (!this.dBp.hasMore) {
                this.eFm.aBM();
            } else {
                WO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WO() {
        if (this.dBp != null) {
            aq aqVar = new aq();
            aqVar.forumName = this.eFp;
            aqVar.forumId = this.cZL;
            this.dBp.pn++;
            aqVar.pn = this.dBp.pn;
            this.eFn.a(4, this.mPageType, aqVar);
        }
    }

    private void aJp() {
        aq aqVar = new aq();
        aqVar.forumName = this.eFp;
        aqVar.forumId = this.cZL;
        aqVar.pn = -1;
        this.eFn.a(4, this.mPageType, aqVar);
    }

    public void e(int i, String str, String str2) {
        this.mPageType = i;
        this.cZL = str;
        this.eFp = str2;
    }

    public void atS() {
        if (this.eFo) {
            this.eFm.XN();
            this.eFm.VU();
            aJp();
        }
    }

    public View getView() {
        return this.eFm.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.eFm.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.eFn.Za();
    }

    public void b(an anVar) {
        this.eFq = anVar;
    }
}
