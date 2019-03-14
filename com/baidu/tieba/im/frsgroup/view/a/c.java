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
    private ap eVt;
    private String ela;
    private b gkQ;
    private String gkT;
    private ai gkU;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> eVo = new ArrayList();
    private boolean gkS = true;
    private View.OnClickListener gkV = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.gkS = true;
            c.this.bbc();
        }
    };
    private ai gkW = new ai() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
            if (apVar == null) {
                c.this.gkQ.completePullRefresh();
                c.this.gkQ.hideLoadingView();
                return;
            }
            c.this.eVt = apVar;
            if ((c.this.eVt.pn == 0 || c.this.eVt.pn == 1) && c.this.eVt.hasMore && !c.this.eVt.isLocal) {
                c.this.aBc();
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
            if (c.this.gkU != null) {
                c.this.gkU.a(i, i2, apVar, arrayList);
            }
            if (v.T(arrayList)) {
                if (c.this.gkS) {
                    c.this.gkQ.hideLoadingView();
                    c.this.gkQ.a(c.this.eVt.errMsg, c.this.gkV);
                } else {
                    c.this.gkQ.completePullRefresh();
                    c.this.gkQ.bkY();
                }
            } else {
                c.this.eVo = arrayList;
                c.this.gkQ.cs(c.this.eVo);
                if (v.S(c.this.eVo) != 1 || !(v.c(c.this.eVo, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.eVt.hasMore) {
                        c.this.gkQ.bkX();
                    } else {
                        c.this.gkQ.bkZ();
                    }
                } else {
                    c.this.gkQ.btt();
                }
                if (c.this.gkS) {
                    c.this.gkQ.hideLoadingView();
                } else {
                    c.this.gkQ.completePullRefresh();
                }
            }
            c.this.gkS = false;
        }
    };
    private d gkR = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.gkQ = new b(tbPageContext, this);
        this.gkR.setTag(this.pageId);
        this.gkR.init();
        this.gkR.a(this.gkW);
    }

    public void cW(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.gkQ != null) {
            this.gkQ.cV(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void dP(boolean z) {
        if (this.gkQ != null) {
            this.gkQ.li(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        btv();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.kY()) {
            this.gkQ.bkY();
        }
        if (this.eVt != null) {
            if (!this.eVt.hasMore) {
                this.gkQ.bkZ();
            } else {
                aBc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBc() {
        if (this.eVt != null) {
            am amVar = new am();
            amVar.forumName = this.gkT;
            amVar.forumId = this.ela;
            this.eVt.pn++;
            amVar.pn = this.eVt.pn;
            this.gkR.a(4, this.mPageType, amVar);
        }
    }

    private void btv() {
        am amVar = new am();
        amVar.forumName = this.gkT;
        amVar.forumId = this.ela;
        amVar.pn = -1;
        this.gkR.a(4, this.mPageType, amVar);
    }

    public void g(int i, String str, String str2) {
        this.mPageType = i;
        this.ela = str;
        this.gkT = str2;
    }

    public void bbc() {
        if (this.gkS) {
            this.gkQ.aBt();
            this.gkQ.showLoadingView();
            btv();
        }
    }

    public View getView() {
        return this.gkQ.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.gkQ.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.gkR.aDF();
    }

    public void b(ai aiVar) {
        this.gkU = aiVar;
    }
}
