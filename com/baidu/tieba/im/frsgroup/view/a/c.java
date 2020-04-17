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
    private String eQf;
    private av gUI;
    private b ine;
    private String inh;
    private ao ini;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> gUD = new ArrayList();
    private boolean ing = true;
    private View.OnClickListener inj = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.ing = true;
            c.this.bNc();
        }
    };
    private ao ink = new ao() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<m> arrayList) {
            if (avVar == null) {
                c.this.ine.completePullRefresh();
                c.this.ine.hideLoadingView();
                return;
            }
            c.this.gUI = avVar;
            if ((c.this.gUI.pn == 0 || c.this.gUI.pn == 1) && c.this.gUI.hasMore && !c.this.gUI.isLocal) {
                c.this.blb();
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
            if (c.this.ini != null) {
                c.this.ini.a(i, i2, avVar, arrayList);
            }
            if (v.isEmpty(arrayList)) {
                if (c.this.ing) {
                    c.this.ine.hideLoadingView();
                    c.this.ine.a(c.this.gUI.errMsg, c.this.inj);
                } else {
                    c.this.ine.completePullRefresh();
                    c.this.ine.bXr();
                }
            } else {
                c.this.gUD = arrayList;
                c.this.ine.cK(c.this.gUD);
                if (v.getCount(c.this.gUD) != 1 || !(v.getItem(c.this.gUD, 0) instanceof h)) {
                    if (c.this.gUI.hasMore) {
                        c.this.ine.bXq();
                    } else {
                        c.this.ine.bXs();
                    }
                } else {
                    c.this.ine.cgr();
                }
                if (c.this.ing) {
                    c.this.ine.hideLoadingView();
                } else {
                    c.this.ine.completePullRefresh();
                }
            }
            c.this.ing = false;
        }
    };
    private d inf = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.ine = new b(tbPageContext, this);
        this.inf.setTag(this.pageId);
        this.inf.init();
        this.inf.a(this.ink);
    }

    public void dl(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.ine != null) {
            this.ine.dk(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.ine != null) {
            this.ine.oO(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        cgt();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.ine.bXr();
        }
        if (this.gUI != null) {
            if (!this.gUI.hasMore) {
                this.ine.bXs();
            } else {
                blb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blb() {
        if (this.gUI != null) {
            as asVar = new as();
            asVar.forumName = this.inh;
            asVar.forumId = this.eQf;
            this.gUI.pn++;
            asVar.pn = this.gUI.pn;
            this.inf.a(4, this.mPageType, asVar);
        }
    }

    private void cgt() {
        as asVar = new as();
        asVar.forumName = this.inh;
        asVar.forumId = this.eQf;
        asVar.pn = -1;
        this.inf.a(4, this.mPageType, asVar);
    }

    public void j(int i, String str, String str2) {
        this.mPageType = i;
        this.eQf = str;
        this.inh = str2;
    }

    public void bNc() {
        if (this.ing) {
            this.ine.blt();
            this.ine.showLoadingView();
            cgt();
        }
    }

    public View getView() {
        return this.ine.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.ine.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.inf.bqt();
    }

    public void b(ao aoVar) {
        this.ini = aoVar;
    }
}
