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
    private String ePc;
    private ap fqX;
    private b gHV;
    private String gHY;
    private ai gHZ;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> fqS = new ArrayList();
    private boolean gHX = true;
    private View.OnClickListener gIa = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.gHX = true;
            c.this.biu();
        }
    };
    private ai gIb = new ai() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
            if (apVar == null) {
                c.this.gHV.completePullRefresh();
                c.this.gHV.hideLoadingView();
                return;
            }
            c.this.fqX = apVar;
            if ((c.this.fqX.pn == 0 || c.this.fqX.pn == 1) && c.this.fqX.hasMore && !c.this.fqX.isLocal) {
                c.this.aIU();
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
            if (c.this.gHZ != null) {
                c.this.gHZ.a(i, i2, apVar, arrayList);
            }
            if (v.isEmpty(arrayList)) {
                if (c.this.gHX) {
                    c.this.gHV.hideLoadingView();
                    c.this.gHV.a(c.this.fqX.errMsg, c.this.gIa);
                } else {
                    c.this.gHV.completePullRefresh();
                    c.this.gHV.bsx();
                }
            } else {
                c.this.fqS = arrayList;
                c.this.gHV.cK(c.this.fqS);
                if (v.getCount(c.this.fqS) != 1 || !(v.getItem(c.this.fqS, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.fqX.hasMore) {
                        c.this.gHV.bsw();
                    } else {
                        c.this.gHV.bsy();
                    }
                } else {
                    c.this.gHV.bBy();
                }
                if (c.this.gHX) {
                    c.this.gHV.hideLoadingView();
                } else {
                    c.this.gHV.completePullRefresh();
                }
            }
            c.this.gHX = false;
        }
    };
    private d gHW = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.gHV = new b(tbPageContext, this);
        this.gHW.setTag(this.pageId);
        this.gHW.init();
        this.gHW.a(this.gIb);
    }

    public void dp(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.gHV != null) {
            this.gHV.m25do(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.gHV != null) {
            this.gHV.md(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        bBA();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.gHV.bsx();
        }
        if (this.fqX != null) {
            if (!this.fqX.hasMore) {
                this.gHV.bsy();
            } else {
                aIU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIU() {
        if (this.fqX != null) {
            am amVar = new am();
            amVar.forumName = this.gHY;
            amVar.forumId = this.ePc;
            this.fqX.pn++;
            amVar.pn = this.fqX.pn;
            this.gHW.a(4, this.mPageType, amVar);
        }
    }

    private void bBA() {
        am amVar = new am();
        amVar.forumName = this.gHY;
        amVar.forumId = this.ePc;
        amVar.pn = -1;
        this.gHW.a(4, this.mPageType, amVar);
    }

    public void k(int i, String str, String str2) {
        this.mPageType = i;
        this.ePc = str;
        this.gHY = str2;
    }

    public void biu() {
        if (this.gHX) {
            this.gHV.aJm();
            this.gHV.showLoadingView();
            bBA();
        }
    }

    public View getView() {
        return this.gHV.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.gHV.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.gHW.aMK();
    }

    public void b(ai aiVar) {
        this.gHZ = aiVar;
    }
}
