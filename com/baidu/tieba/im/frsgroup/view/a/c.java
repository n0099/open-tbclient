package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.im.frsgroup.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements BdListView.e, NoNetworkView.a, j.b {
    private String cHI;
    private ar doP;
    private b eBm;
    private String eBp;
    private al eBq;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> doK = new ArrayList();
    private boolean eBo = true;
    private View.OnClickListener eBr = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.eBo = true;
            c.this.auN();
        }
    };
    private al eBs = new al() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            if (arVar == null) {
                c.this.eBm.completePullRefresh();
                c.this.eBm.hideLoadingView();
                return;
            }
            c.this.doP = arVar;
            if ((c.this.doP.pn == 0 || c.this.doP.pn == 1) && c.this.doP.hasMore && !c.this.doP.isLocal) {
                c.this.Vd();
                return;
            }
            if (arrayList != null) {
                Iterator<h> it = arrayList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if ((next instanceof i) || (next instanceof m)) {
                        it.remove();
                    }
                }
            }
            if (c.this.eBq != null) {
                c.this.eBq.a(i, i2, arVar, arrayList);
            }
            if (v.z(arrayList)) {
                if (c.this.eBo) {
                    c.this.eBm.hideLoadingView();
                    c.this.eBm.a(c.this.doP.errMsg, c.this.eBr);
                } else {
                    c.this.eBm.completePullRefresh();
                    c.this.eBm.aEX();
                }
            } else {
                c.this.doK = arrayList;
                c.this.eBm.bO(c.this.doK);
                if (v.y(c.this.doK) != 1 || !(v.d(c.this.doK, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.doP.hasMore) {
                        c.this.eBm.aEW();
                    } else {
                        c.this.eBm.aEY();
                    }
                } else {
                    c.this.eBm.aMX();
                }
                if (c.this.eBo) {
                    c.this.eBm.hideLoadingView();
                } else {
                    c.this.eBm.completePullRefresh();
                }
            }
            c.this.eBo = false;
        }
    };
    private d eBn = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.eBm = new b(tbPageContext, this);
        this.eBn.setTag(this.pageId);
        this.eBn.init();
        this.eBn.a(this.eBs);
    }

    public void cr(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.eBm != null) {
            this.eBm.cq(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bd(boolean z) {
        if (this.eBm != null) {
            this.eBm.ib(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bf(boolean z) {
        aMZ();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.kK()) {
            this.eBm.aEX();
        }
        if (this.doP != null) {
            if (!this.doP.hasMore) {
                this.eBm.aEY();
            } else {
                Vd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vd() {
        if (this.doP != null) {
            ao aoVar = new ao();
            aoVar.forumName = this.eBp;
            aoVar.forumId = this.cHI;
            this.doP.pn++;
            aoVar.pn = this.doP.pn;
            this.eBn.a(4, this.mPageType, aoVar);
        }
    }

    private void aMZ() {
        ao aoVar = new ao();
        aoVar.forumName = this.eBp;
        aoVar.forumId = this.cHI;
        aoVar.pn = -1;
        this.eBn.a(4, this.mPageType, aoVar);
    }

    public void d(int i, String str, String str2) {
        this.mPageType = i;
        this.cHI = str;
        this.eBp = str2;
    }

    public void auN() {
        if (this.eBo) {
            this.eBm.Wa();
            this.eBm.showLoadingView();
            aMZ();
        }
    }

    public View getView() {
        return this.eBm.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.eBm.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.eBn.Xn();
    }

    public void b(al alVar) {
        this.eBq = alVar;
    }
}
