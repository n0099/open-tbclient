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
    private b gBU;
    private String gBX;
    private ai gBY;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> flm = new ArrayList();
    private boolean gBW = true;
    private View.OnClickListener gBZ = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.gBW = true;
            c.this.biw();
        }
    };
    private ai gCa = new ai() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
            if (apVar == null) {
                c.this.gBU.completePullRefresh();
                c.this.gBU.hideLoadingView();
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
            if (c.this.gBY != null) {
                c.this.gBY.a(i, i2, apVar, arrayList);
            }
            if (v.aa(arrayList)) {
                if (c.this.gBW) {
                    c.this.gBU.hideLoadingView();
                    c.this.gBU.a(c.this.flr.errMsg, c.this.gBZ);
                } else {
                    c.this.gBU.completePullRefresh();
                    c.this.gBU.bss();
                }
            } else {
                c.this.flm = arrayList;
                c.this.gBU.cx(c.this.flm);
                if (v.Z(c.this.flm) != 1 || !(v.c(c.this.flm, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.flr.hasMore) {
                        c.this.gBU.bsr();
                    } else {
                        c.this.gBU.bst();
                    }
                } else {
                    c.this.gBU.bBg();
                }
                if (c.this.gBW) {
                    c.this.gBU.hideLoadingView();
                } else {
                    c.this.gBU.completePullRefresh();
                }
            }
            c.this.gBW = false;
        }
    };
    private d gBV = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.gBU = new b(tbPageContext, this);
        this.gBV.setTag(this.pageId);
        this.gBV.init();
        this.gBV.a(this.gCa);
    }

    public void db(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.gBU != null) {
            this.gBU.da(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void el(boolean z) {
        if (this.gBU != null) {
            this.gBU.lY(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        bBi();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.jS()) {
            this.gBU.bss();
        }
        if (this.flr != null) {
            if (!this.flr.hasMore) {
                this.gBU.bst();
            } else {
                aHt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHt() {
        if (this.flr != null) {
            am amVar = new am();
            amVar.forumName = this.gBX;
            amVar.forumId = this.eAC;
            this.flr.pn++;
            amVar.pn = this.flr.pn;
            this.gBV.a(4, this.mPageType, amVar);
        }
    }

    private void bBi() {
        am amVar = new am();
        amVar.forumName = this.gBX;
        amVar.forumId = this.eAC;
        amVar.pn = -1;
        this.gBV.a(4, this.mPageType, amVar);
    }

    public void i(int i, String str, String str2) {
        this.mPageType = i;
        this.eAC = str;
        this.gBX = str2;
    }

    public void biw() {
        if (this.gBW) {
            this.gBU.aHK();
            this.gBU.showLoadingView();
            bBi();
        }
    }

    public View getView() {
        return this.gBU.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.gBU.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.gBV.aJS();
    }

    public void b(ai aiVar) {
        this.gBY = aiVar;
    }
}
