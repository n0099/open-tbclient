package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.im.frsgroup.d;
import com.baidu.tieba.im.frsgroup.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements BdListView.e, NoNetworkView.a, f.c {
    private String evm;
    private av hjA;
    private b iBR;
    private String iBU;
    private ao iBV;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<o> hjv = new ArrayList();
    private boolean iBT = true;
    private View.OnClickListener iBW = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.iBT = true;
            c.this.bTw();
        }
    };
    private ao iBX = new ao() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<o> arrayList) {
            if (avVar == null) {
                c.this.iBR.completePullRefresh();
                c.this.iBR.hideLoadingView();
                return;
            }
            c.this.hjA = avVar;
            if ((c.this.hjA.pn == 0 || c.this.hjA.pn == 1) && c.this.hjA.hasMore && !c.this.hjA.isLocal) {
                c.this.bqv();
                return;
            }
            if (arrayList != null) {
                Iterator<o> it = arrayList.iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    if ((next instanceof k) || (next instanceof p)) {
                        it.remove();
                    }
                }
            }
            if (c.this.iBV != null) {
                c.this.iBV.a(i, i2, avVar, arrayList);
            }
            if (v.isEmpty(arrayList)) {
                if (c.this.iBT) {
                    c.this.iBR.hideLoadingView();
                    c.this.iBR.a(c.this.hjA.errMsg, c.this.iBW);
                } else {
                    c.this.iBR.completePullRefresh();
                    c.this.iBR.cdO();
                }
            } else {
                c.this.hjv = arrayList;
                c.this.iBR.cH(c.this.hjv);
                if (v.getCount(c.this.hjv) != 1 || !(v.getItem(c.this.hjv, 0) instanceof h)) {
                    if (c.this.hjA.hasMore) {
                        c.this.iBR.cdN();
                    } else {
                        c.this.iBR.cdP();
                    }
                } else {
                    c.this.iBR.cmN();
                }
                if (c.this.iBT) {
                    c.this.iBR.hideLoadingView();
                } else {
                    c.this.iBR.completePullRefresh();
                }
            }
            c.this.iBT = false;
        }
    };
    private d iBS = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.iBR = new b(tbPageContext, this);
        this.iBS.setTag(this.pageId);
        this.iBS.init();
        this.iBS.a(this.iBX);
    }

    public void dj(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.iBR != null) {
            this.iBR.di(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iBR != null) {
            this.iBR.pk(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cmP();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.iBR.cdO();
        }
        if (this.hjA != null) {
            if (!this.hjA.hasMore) {
                this.iBR.cdP();
            } else {
                bqv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqv() {
        if (this.hjA != null) {
            as asVar = new as();
            asVar.forumName = this.iBU;
            asVar.forumId = this.evm;
            this.hjA.pn++;
            asVar.pn = this.hjA.pn;
            this.iBS.a(4, this.mPageType, asVar);
        }
    }

    private void cmP() {
        as asVar = new as();
        asVar.forumName = this.iBU;
        asVar.forumId = this.evm;
        asVar.pn = -1;
        this.iBS.a(4, this.mPageType, asVar);
    }

    public void j(int i, String str, String str2) {
        this.mPageType = i;
        this.evm = str;
        this.iBU = str2;
    }

    public void bTw() {
        if (this.iBT) {
            this.iBR.bqO();
            this.iBR.showLoadingView();
            cmP();
        }
    }

    public View getView() {
        return this.iBR.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.iBR.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.iBS.bwi();
    }

    public void b(ao aoVar) {
        this.iBV = aoVar;
    }
}
