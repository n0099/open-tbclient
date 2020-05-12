package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
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
public class c implements BdListView.e, NoNetworkView.a, g.c {
    private String eQk;
    private av gUO;
    private b ink;
    private String inn;
    private ao ino;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> gUJ = new ArrayList();
    private boolean inm = true;
    private View.OnClickListener inp = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.inm = true;
            c.this.bNb();
        }
    };
    private ao inq = new ao() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<m> arrayList) {
            if (avVar == null) {
                c.this.ink.completePullRefresh();
                c.this.ink.hideLoadingView();
                return;
            }
            c.this.gUO = avVar;
            if ((c.this.gUO.pn == 0 || c.this.gUO.pn == 1) && c.this.gUO.hasMore && !c.this.gUO.isLocal) {
                c.this.bkZ();
                return;
            }
            if (arrayList != null) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    m next = it.next();
                    if ((next instanceof k) || (next instanceof p)) {
                        it.remove();
                    }
                }
            }
            if (c.this.ino != null) {
                c.this.ino.a(i, i2, avVar, arrayList);
            }
            if (v.isEmpty(arrayList)) {
                if (c.this.inm) {
                    c.this.ink.hideLoadingView();
                    c.this.ink.a(c.this.gUO.errMsg, c.this.inp);
                } else {
                    c.this.ink.completePullRefresh();
                    c.this.ink.bXq();
                }
            } else {
                c.this.gUJ = arrayList;
                c.this.ink.cK(c.this.gUJ);
                if (v.getCount(c.this.gUJ) != 1 || !(v.getItem(c.this.gUJ, 0) instanceof h)) {
                    if (c.this.gUO.hasMore) {
                        c.this.ink.bXp();
                    } else {
                        c.this.ink.bXr();
                    }
                } else {
                    c.this.ink.cgq();
                }
                if (c.this.inm) {
                    c.this.ink.hideLoadingView();
                } else {
                    c.this.ink.completePullRefresh();
                }
            }
            c.this.inm = false;
        }
    };
    private d inl = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.ink = new b(tbPageContext, this);
        this.inl.setTag(this.pageId);
        this.inl.init();
        this.inl.a(this.inq);
    }

    public void dl(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.ink != null) {
            this.ink.dk(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.ink != null) {
            this.ink.oO(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        cgs();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.ink.bXq();
        }
        if (this.gUO != null) {
            if (!this.gUO.hasMore) {
                this.ink.bXr();
            } else {
                bkZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkZ() {
        if (this.gUO != null) {
            as asVar = new as();
            asVar.forumName = this.inn;
            asVar.forumId = this.eQk;
            this.gUO.pn++;
            asVar.pn = this.gUO.pn;
            this.inl.a(4, this.mPageType, asVar);
        }
    }

    private void cgs() {
        as asVar = new as();
        asVar.forumName = this.inn;
        asVar.forumId = this.eQk;
        asVar.pn = -1;
        this.inl.a(4, this.mPageType, asVar);
    }

    public void j(int i, String str, String str2) {
        this.mPageType = i;
        this.eQk = str;
        this.inn = str2;
    }

    public void bNb() {
        if (this.inm) {
            this.ink.blr();
            this.ink.showLoadingView();
            cgs();
        }
    }

    public View getView() {
        return this.ink.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.ink.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.inl.bqr();
    }

    public void b(ao aoVar) {
        this.ino = aoVar;
    }
}
