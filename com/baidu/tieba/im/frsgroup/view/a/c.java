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
    private String eAB;
    private ap flq;
    private b gBR;
    private String gBU;
    private ai gBV;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> fll = new ArrayList();
    private boolean gBT = true;
    private View.OnClickListener gBW = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.gBT = true;
            c.this.bit();
        }
    };
    private ai gBX = new ai() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
            if (apVar == null) {
                c.this.gBR.completePullRefresh();
                c.this.gBR.hideLoadingView();
                return;
            }
            c.this.flq = apVar;
            if ((c.this.flq.pn == 0 || c.this.flq.pn == 1) && c.this.flq.hasMore && !c.this.flq.isLocal) {
                c.this.aHq();
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
            if (c.this.gBV != null) {
                c.this.gBV.a(i, i2, apVar, arrayList);
            }
            if (v.aa(arrayList)) {
                if (c.this.gBT) {
                    c.this.gBR.hideLoadingView();
                    c.this.gBR.a(c.this.flq.errMsg, c.this.gBW);
                } else {
                    c.this.gBR.completePullRefresh();
                    c.this.gBR.bsn();
                }
            } else {
                c.this.fll = arrayList;
                c.this.gBR.cx(c.this.fll);
                if (v.Z(c.this.fll) != 1 || !(v.c(c.this.fll, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.flq.hasMore) {
                        c.this.gBR.bsm();
                    } else {
                        c.this.gBR.bso();
                    }
                } else {
                    c.this.gBR.bBc();
                }
                if (c.this.gBT) {
                    c.this.gBR.hideLoadingView();
                } else {
                    c.this.gBR.completePullRefresh();
                }
            }
            c.this.gBT = false;
        }
    };
    private d gBS = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.gBR = new b(tbPageContext, this);
        this.gBS.setTag(this.pageId);
        this.gBS.init();
        this.gBS.a(this.gBX);
    }

    public void db(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.gBR != null) {
            this.gBR.da(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void el(boolean z) {
        if (this.gBR != null) {
            this.gBR.lX(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        bBe();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.jS()) {
            this.gBR.bsn();
        }
        if (this.flq != null) {
            if (!this.flq.hasMore) {
                this.gBR.bso();
            } else {
                aHq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHq() {
        if (this.flq != null) {
            am amVar = new am();
            amVar.forumName = this.gBU;
            amVar.forumId = this.eAB;
            this.flq.pn++;
            amVar.pn = this.flq.pn;
            this.gBS.a(4, this.mPageType, amVar);
        }
    }

    private void bBe() {
        am amVar = new am();
        amVar.forumName = this.gBU;
        amVar.forumId = this.eAB;
        amVar.pn = -1;
        this.gBS.a(4, this.mPageType, amVar);
    }

    public void i(int i, String str, String str2) {
        this.mPageType = i;
        this.eAB = str;
        this.gBU = str2;
    }

    public void bit() {
        if (this.gBT) {
            this.gBR.aHH();
            this.gBR.showLoadingView();
            bBe();
        }
    }

    public View getView() {
        return this.gBR.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.gBR.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.gBS.aJP();
    }

    public void b(ai aiVar) {
        this.gBV = aiVar;
    }
}
