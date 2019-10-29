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
    private String ePT;
    private ap frP;
    private b gIM;
    private String gIP;
    private ai gIQ;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> frK = new ArrayList();
    private boolean gIO = true;
    private View.OnClickListener gIR = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.gIO = true;
            c.this.biw();
        }
    };
    private ai gIS = new ai() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
            if (apVar == null) {
                c.this.gIM.completePullRefresh();
                c.this.gIM.hideLoadingView();
                return;
            }
            c.this.frP = apVar;
            if ((c.this.frP.pn == 0 || c.this.frP.pn == 1) && c.this.frP.hasMore && !c.this.frP.isLocal) {
                c.this.aIW();
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
            if (c.this.gIQ != null) {
                c.this.gIQ.a(i, i2, apVar, arrayList);
            }
            if (v.isEmpty(arrayList)) {
                if (c.this.gIO) {
                    c.this.gIM.hideLoadingView();
                    c.this.gIM.a(c.this.frP.errMsg, c.this.gIR);
                } else {
                    c.this.gIM.completePullRefresh();
                    c.this.gIM.bsz();
                }
            } else {
                c.this.frK = arrayList;
                c.this.gIM.cK(c.this.frK);
                if (v.getCount(c.this.frK) != 1 || !(v.getItem(c.this.frK, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.frP.hasMore) {
                        c.this.gIM.bsy();
                    } else {
                        c.this.gIM.bsA();
                    }
                } else {
                    c.this.gIM.bBA();
                }
                if (c.this.gIO) {
                    c.this.gIM.hideLoadingView();
                } else {
                    c.this.gIM.completePullRefresh();
                }
            }
            c.this.gIO = false;
        }
    };
    private d gIN = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.gIM = new b(tbPageContext, this);
        this.gIN.setTag(this.pageId);
        this.gIN.init();
        this.gIN.a(this.gIS);
    }

    public void dp(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.gIM != null) {
            this.gIM.m25do(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.gIM != null) {
            this.gIM.md(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        bBC();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.gIM.bsz();
        }
        if (this.frP != null) {
            if (!this.frP.hasMore) {
                this.gIM.bsA();
            } else {
                aIW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIW() {
        if (this.frP != null) {
            am amVar = new am();
            amVar.forumName = this.gIP;
            amVar.forumId = this.ePT;
            this.frP.pn++;
            amVar.pn = this.frP.pn;
            this.gIN.a(4, this.mPageType, amVar);
        }
    }

    private void bBC() {
        am amVar = new am();
        amVar.forumName = this.gIP;
        amVar.forumId = this.ePT;
        amVar.pn = -1;
        this.gIN.a(4, this.mPageType, amVar);
    }

    public void k(int i, String str, String str2) {
        this.mPageType = i;
        this.ePT = str;
        this.gIP = str2;
    }

    public void biw() {
        if (this.gIO) {
            this.gIM.aJo();
            this.gIM.showLoadingView();
            bBC();
        }
    }

    public View getView() {
        return this.gIM.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.gIM.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.gIN.aMM();
    }

    public void b(ai aiVar) {
        this.gIQ = aiVar;
    }
}
