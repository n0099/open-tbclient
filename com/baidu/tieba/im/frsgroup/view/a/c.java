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
    private String cZU;
    private at dBy;
    private b eFi;
    private String eFl;
    private an eFm;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<i> dBt = new ArrayList();
    private boolean eFk = true;
    private View.OnClickListener eFn = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.eFk = true;
            c.this.atS();
        }
    };
    private an eFo = new an() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<i> arrayList) {
            if (atVar == null) {
                c.this.eFi.completePullRefresh();
                c.this.eFi.VV();
                return;
            }
            c.this.dBy = atVar;
            if ((c.this.dBy.pn == 0 || c.this.dBy.pn == 1) && c.this.dBy.hasMore && !c.this.dBy.isLocal) {
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
            if (c.this.eFm != null) {
                c.this.eFm.a(i, i2, atVar, arrayList);
            }
            if (v.E(arrayList)) {
                if (c.this.eFk) {
                    c.this.eFi.VV();
                    c.this.eFi.a(c.this.dBy.errMsg, c.this.eFn);
                } else {
                    c.this.eFi.completePullRefresh();
                    c.this.eFi.aBL();
                }
            } else {
                c.this.dBt = arrayList;
                c.this.eFi.bI(c.this.dBt);
                if (v.D(c.this.dBt) != 1 || !(v.f(c.this.dBt, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.dBy.hasMore) {
                        c.this.eFi.aBK();
                    } else {
                        c.this.eFi.aBM();
                    }
                } else {
                    c.this.eFi.aJn();
                }
                if (c.this.eFk) {
                    c.this.eFi.VV();
                } else {
                    c.this.eFi.completePullRefresh();
                }
            }
            c.this.eFk = false;
        }
    };
    private d eFj = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.eFi = new b(tbPageContext, this);
        this.eFj.setTag(this.pageId);
        this.eFj.init();
        this.eFj.a(this.eFo);
    }

    public void cl(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.eFi != null) {
            this.eFi.ck(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bu(boolean z) {
        if (this.eFi != null) {
            this.eFi.hE(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
        aJp();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.oJ()) {
            this.eFi.aBL();
        }
        if (this.dBy != null) {
            if (!this.dBy.hasMore) {
                this.eFi.aBM();
            } else {
                WO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WO() {
        if (this.dBy != null) {
            aq aqVar = new aq();
            aqVar.forumName = this.eFl;
            aqVar.forumId = this.cZU;
            this.dBy.pn++;
            aqVar.pn = this.dBy.pn;
            this.eFj.a(4, this.mPageType, aqVar);
        }
    }

    private void aJp() {
        aq aqVar = new aq();
        aqVar.forumName = this.eFl;
        aqVar.forumId = this.cZU;
        aqVar.pn = -1;
        this.eFj.a(4, this.mPageType, aqVar);
    }

    public void e(int i, String str, String str2) {
        this.mPageType = i;
        this.cZU = str;
        this.eFl = str2;
    }

    public void atS() {
        if (this.eFk) {
            this.eFi.XN();
            this.eFi.VU();
            aJp();
        }
    }

    public View getView() {
        return this.eFi.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.eFi.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.eFj.Za();
    }

    public void b(an anVar) {
        this.eFm = anVar;
    }
}
