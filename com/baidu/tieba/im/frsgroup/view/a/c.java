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
    private String eAC;
    private ap flr;
    private b gBS;
    private String gBV;
    private ai gBW;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> flm = new ArrayList();
    private boolean gBU = true;
    private View.OnClickListener gBX = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.gBU = true;
            c.this.biw();
        }
    };
    private ai gBY = new ai() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
            if (apVar == null) {
                c.this.gBS.completePullRefresh();
                c.this.gBS.hideLoadingView();
                return;
            }
            c.this.flr = apVar;
            if ((c.this.flr.pn == 0 || c.this.flr.pn == 1) && c.this.flr.hasMore && !c.this.flr.isLocal) {
                c.this.aHt();
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
            if (c.this.gBW != null) {
                c.this.gBW.a(i, i2, apVar, arrayList);
            }
            if (v.aa(arrayList)) {
                if (c.this.gBU) {
                    c.this.gBS.hideLoadingView();
                    c.this.gBS.a(c.this.flr.errMsg, c.this.gBX);
                } else {
                    c.this.gBS.completePullRefresh();
                    c.this.gBS.bsq();
                }
            } else {
                c.this.flm = arrayList;
                c.this.gBS.cx(c.this.flm);
                if (v.Z(c.this.flm) != 1 || !(v.c(c.this.flm, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.flr.hasMore) {
                        c.this.gBS.bsp();
                    } else {
                        c.this.gBS.bsr();
                    }
                } else {
                    c.this.gBS.bBf();
                }
                if (c.this.gBU) {
                    c.this.gBS.hideLoadingView();
                } else {
                    c.this.gBS.completePullRefresh();
                }
            }
            c.this.gBU = false;
        }
    };
    private d gBT = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.gBS = new b(tbPageContext, this);
        this.gBT.setTag(this.pageId);
        this.gBT.init();
        this.gBT.a(this.gBY);
    }

    public void db(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.gBS != null) {
            this.gBS.da(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void el(boolean z) {
        if (this.gBS != null) {
            this.gBS.lX(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        bBh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.jS()) {
            this.gBS.bsq();
        }
        if (this.flr != null) {
            if (!this.flr.hasMore) {
                this.gBS.bsr();
            } else {
                aHt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHt() {
        if (this.flr != null) {
            am amVar = new am();
            amVar.forumName = this.gBV;
            amVar.forumId = this.eAC;
            this.flr.pn++;
            amVar.pn = this.flr.pn;
            this.gBT.a(4, this.mPageType, amVar);
        }
    }

    private void bBh() {
        am amVar = new am();
        amVar.forumName = this.gBV;
        amVar.forumId = this.eAC;
        amVar.pn = -1;
        this.gBT.a(4, this.mPageType, amVar);
    }

    public void i(int i, String str, String str2) {
        this.mPageType = i;
        this.eAC = str;
        this.gBV = str2;
    }

    public void biw() {
        if (this.gBU) {
            this.gBS.aHK();
            this.gBS.showLoadingView();
            bBh();
        }
    }

    public View getView() {
        return this.gBS.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.gBS.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.gBT.aJS();
    }

    public void b(ai aiVar) {
        this.gBW = aiVar;
    }
}
