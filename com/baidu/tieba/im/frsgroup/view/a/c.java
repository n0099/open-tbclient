package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.im.frsgroup.d;
import com.baidu.tieba.im.frsgroup.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements BdListView.e, NoNetworkView.a, f.c {
    private String eEs;
    private bb hvT;
    private b iTI;
    private String iTL;
    private at iTM;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<q> hvO = new ArrayList();
    private boolean iTK = true;
    private View.OnClickListener iTN = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.iTK = true;
            c.this.bWu();
        }
    };
    private at iTO = new at() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.at
        public void a(int i, int i2, bb bbVar, ArrayList<q> arrayList) {
            if (bbVar == null) {
                c.this.iTI.completePullRefresh();
                c.this.iTI.hideLoadingView();
                return;
            }
            c.this.hvT = bbVar;
            if ((c.this.hvT.pn == 0 || c.this.hvT.pn == 1) && c.this.hvT.hasMore && !c.this.hvT.isLocal) {
                c.this.btu();
                return;
            }
            if (arrayList != null) {
                Iterator<q> it = arrayList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if ((next instanceof m) || (next instanceof r)) {
                        it.remove();
                    }
                }
            }
            if (c.this.iTM != null) {
                c.this.iTM.a(i, i2, bbVar, arrayList);
            }
            if (w.isEmpty(arrayList)) {
                if (c.this.iTK) {
                    c.this.iTI.hideLoadingView();
                    c.this.iTI.a(c.this.hvT.errMsg, c.this.iTN);
                } else {
                    c.this.iTI.completePullRefresh();
                    c.this.iTI.cht();
                }
            } else {
                c.this.hvO = arrayList;
                c.this.iTI.cS(c.this.hvO);
                if (w.getCount(c.this.hvO) != 1 || !(w.getItem(c.this.hvO, 0) instanceof h)) {
                    if (c.this.hvT.hasMore) {
                        c.this.iTI.chs();
                    } else {
                        c.this.iTI.chu();
                    }
                } else {
                    c.this.iTI.cqL();
                }
                if (c.this.iTK) {
                    c.this.iTI.hideLoadingView();
                } else {
                    c.this.iTI.completePullRefresh();
                }
            }
            c.this.iTK = false;
        }
    };
    private d iTJ = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.iTI = new b(tbPageContext, this);
        this.iTJ.setTag(this.pageId);
        this.iTJ.init();
        this.iTJ.a(this.iTO);
    }

    public void dy(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.iTI != null) {
            this.iTI.dx(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iTI != null) {
            this.iTI.pu(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cqN();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.iTI.cht();
        }
        if (this.hvT != null) {
            if (!this.hvT.hasMore) {
                this.iTI.chu();
            } else {
                btu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btu() {
        if (this.hvT != null) {
            ay ayVar = new ay();
            ayVar.forumName = this.iTL;
            ayVar.forumId = this.eEs;
            this.hvT.pn++;
            ayVar.pn = this.hvT.pn;
            this.iTJ.a(4, this.mPageType, ayVar);
        }
    }

    private void cqN() {
        ay ayVar = new ay();
        ayVar.forumName = this.iTL;
        ayVar.forumId = this.eEs;
        ayVar.pn = -1;
        this.iTJ.a(4, this.mPageType, ayVar);
    }

    public void j(int i, String str, String str2) {
        this.mPageType = i;
        this.eEs = str;
        this.iTL = str2;
    }

    public void bWu() {
        if (this.iTK) {
            this.iTI.btN();
            this.iTI.showLoadingView();
            cqN();
        }
    }

    public View getView() {
        return this.iTI.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.iTI.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.iTJ.bzf();
    }

    public void b(at atVar) {
        this.iTM = atVar;
    }
}
