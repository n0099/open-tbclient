package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.im.frsgroup.d;
import com.baidu.tieba.im.frsgroup.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes17.dex */
public class c implements BdListView.e, NoNetworkView.a, f.c {
    private String eVx;
    private bd hPa;
    private b jra;
    private String jrd;
    private av jre;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<q> hOV = new ArrayList();
    private boolean jrc = true;
    private View.OnClickListener jrf = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.jrc = true;
            c.this.ckl();
        }
    };
    private av jrg = new av() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
            if (bdVar == null) {
                c.this.jra.completePullRefresh();
                c.this.jra.hideLoadingView();
                return;
            }
            c.this.hPa = bdVar;
            if ((c.this.hPa.pn == 0 || c.this.hPa.pn == 1) && c.this.hPa.hasMore && !c.this.hPa.isLocal) {
                c.this.bFE();
                return;
            }
            if (arrayList != null) {
                Iterator<q> it = arrayList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if ((next instanceof n) || (next instanceof s)) {
                        it.remove();
                    }
                }
            }
            if (c.this.jre != null) {
                c.this.jre.a(i, i2, bdVar, arrayList);
            }
            if (y.isEmpty(arrayList)) {
                if (c.this.jrc) {
                    c.this.jra.hideLoadingView();
                    c.this.jra.d(c.this.hPa.errMsg, c.this.jrf);
                } else {
                    c.this.jra.completePullRefresh();
                    c.this.jra.cvy();
                }
            } else {
                c.this.hOV = arrayList;
                c.this.jra.cY(c.this.hOV);
                if (y.getCount(c.this.hOV) != 1 || !(y.getItem(c.this.hOV, 0) instanceof h)) {
                    if (c.this.hPa.hasMore) {
                        c.this.jra.cvx();
                    } else {
                        c.this.jra.cvz();
                    }
                } else {
                    c.this.jra.cFC();
                }
                if (c.this.jrc) {
                    c.this.jra.hideLoadingView();
                } else {
                    c.this.jra.completePullRefresh();
                }
            }
            c.this.jrc = false;
        }
    };
    private d jrb = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.jra = new b(tbPageContext, this);
        this.jrb.setTag(this.pageId);
        this.jrb.init();
        this.jrb.a(this.jrg);
    }

    public void dM(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.jra != null) {
            this.jra.dL(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.jra != null) {
            this.jra.qJ(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cFE();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.jra.cvy();
        }
        if (this.hPa != null) {
            if (!this.hPa.hasMore) {
                this.jra.cvz();
            } else {
                bFE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFE() {
        if (this.hPa != null) {
            ba baVar = new ba();
            baVar.forumName = this.jrd;
            baVar.forumId = this.eVx;
            this.hPa.pn++;
            baVar.pn = this.hPa.pn;
            this.jrb.a(4, this.mPageType, baVar);
        }
    }

    private void cFE() {
        ba baVar = new ba();
        baVar.forumName = this.jrd;
        baVar.forumId = this.eVx;
        baVar.pn = -1;
        this.jrb.a(4, this.mPageType, baVar);
    }

    public void k(int i, String str, String str2) {
        this.mPageType = i;
        this.eVx = str;
        this.jrd = str2;
    }

    public void ckl() {
        if (this.jrc) {
            this.jra.bFX();
            this.jra.showLoadingView();
            cFE();
        }
    }

    public View getView() {
        return this.jra.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.jra.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.jrb.bLP();
    }

    public void b(av avVar) {
        this.jre = avVar;
    }
}
