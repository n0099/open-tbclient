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
    private String eVt;
    private bd hOU;
    private b jqU;
    private String jqX;
    private av jqY;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<q> hOP = new ArrayList();
    private boolean jqW = true;
    private View.OnClickListener jqZ = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.jqW = true;
            c.this.ckk();
        }
    };
    private av jra = new av() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
            if (bdVar == null) {
                c.this.jqU.completePullRefresh();
                c.this.jqU.hideLoadingView();
                return;
            }
            c.this.hOU = bdVar;
            if ((c.this.hOU.pn == 0 || c.this.hOU.pn == 1) && c.this.hOU.hasMore && !c.this.hOU.isLocal) {
                c.this.bFD();
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
            if (c.this.jqY != null) {
                c.this.jqY.a(i, i2, bdVar, arrayList);
            }
            if (y.isEmpty(arrayList)) {
                if (c.this.jqW) {
                    c.this.jqU.hideLoadingView();
                    c.this.jqU.d(c.this.hOU.errMsg, c.this.jqZ);
                } else {
                    c.this.jqU.completePullRefresh();
                    c.this.jqU.cvx();
                }
            } else {
                c.this.hOP = arrayList;
                c.this.jqU.cY(c.this.hOP);
                if (y.getCount(c.this.hOP) != 1 || !(y.getItem(c.this.hOP, 0) instanceof h)) {
                    if (c.this.hOU.hasMore) {
                        c.this.jqU.cvw();
                    } else {
                        c.this.jqU.cvy();
                    }
                } else {
                    c.this.jqU.cFB();
                }
                if (c.this.jqW) {
                    c.this.jqU.hideLoadingView();
                } else {
                    c.this.jqU.completePullRefresh();
                }
            }
            c.this.jqW = false;
        }
    };
    private d jqV = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.jqU = new b(tbPageContext, this);
        this.jqV.setTag(this.pageId);
        this.jqV.init();
        this.jqV.a(this.jra);
    }

    public void dM(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.jqU != null) {
            this.jqU.dL(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.jqU != null) {
            this.jqU.qH(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cFD();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.jqU.cvx();
        }
        if (this.hOU != null) {
            if (!this.hOU.hasMore) {
                this.jqU.cvy();
            } else {
                bFD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFD() {
        if (this.hOU != null) {
            ba baVar = new ba();
            baVar.forumName = this.jqX;
            baVar.forumId = this.eVt;
            this.hOU.pn++;
            baVar.pn = this.hOU.pn;
            this.jqV.a(4, this.mPageType, baVar);
        }
    }

    private void cFD() {
        ba baVar = new ba();
        baVar.forumName = this.jqX;
        baVar.forumId = this.eVt;
        baVar.pn = -1;
        this.jqV.a(4, this.mPageType, baVar);
    }

    public void j(int i, String str, String str2) {
        this.mPageType = i;
        this.eVt = str;
        this.jqX = str2;
    }

    public void ckk() {
        if (this.jqW) {
            this.jqU.bFW();
            this.jqU.showLoadingView();
            cFD();
        }
    }

    public View getView() {
        return this.jqU.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.jqU.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.jqV.bLO();
    }

    public void b(av avVar) {
        this.jqY = avVar;
    }
}
