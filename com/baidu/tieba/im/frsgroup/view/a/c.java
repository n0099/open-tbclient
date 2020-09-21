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
/* loaded from: classes22.dex */
public class c implements BdListView.e, NoNetworkView.a, f.c {
    private String eYo;
    private bd hWa;
    private b jzC;
    private String jzF;
    private av jzG;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<q> hVV = new ArrayList();
    private boolean jzE = true;
    private View.OnClickListener jzH = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.jzE = true;
            c.this.cny();
        }
    };
    private av jzI = new av() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
            if (bdVar == null) {
                c.this.jzC.completePullRefresh();
                c.this.jzC.hideLoadingView();
                return;
            }
            c.this.hWa = bdVar;
            if ((c.this.hWa.pn == 0 || c.this.hWa.pn == 1) && c.this.hWa.hasMore && !c.this.hWa.isLocal) {
                c.this.bGU();
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
            if (c.this.jzG != null) {
                c.this.jzG.a(i, i2, bdVar, arrayList);
            }
            if (y.isEmpty(arrayList)) {
                if (c.this.jzE) {
                    c.this.jzC.hideLoadingView();
                    c.this.jzC.d(c.this.hWa.errMsg, c.this.jzH);
                } else {
                    c.this.jzC.completePullRefresh();
                    c.this.jzC.cyR();
                }
            } else {
                c.this.hVV = arrayList;
                c.this.jzC.de(c.this.hVV);
                if (y.getCount(c.this.hVV) != 1 || !(y.getItem(c.this.hVV, 0) instanceof h)) {
                    if (c.this.hWa.hasMore) {
                        c.this.jzC.cyQ();
                    } else {
                        c.this.jzC.cyS();
                    }
                } else {
                    c.this.jzC.cJi();
                }
                if (c.this.jzE) {
                    c.this.jzC.hideLoadingView();
                } else {
                    c.this.jzC.completePullRefresh();
                }
            }
            c.this.jzE = false;
        }
    };
    private d jzD = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.jzC = new b(tbPageContext, this);
        this.jzD.setTag(this.pageId);
        this.jzD.init();
        this.jzD.a(this.jzI);
    }

    public void dU(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.jzC != null) {
            this.jzC.dT(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.jzC != null) {
            this.jzC.qR(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cJk();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.jzC.cyR();
        }
        if (this.hWa != null) {
            if (!this.hWa.hasMore) {
                this.jzC.cyS();
            } else {
                bGU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGU() {
        if (this.hWa != null) {
            ba baVar = new ba();
            baVar.forumName = this.jzF;
            baVar.forumId = this.eYo;
            this.hWa.pn++;
            baVar.pn = this.hWa.pn;
            this.jzD.a(4, this.mPageType, baVar);
        }
    }

    private void cJk() {
        ba baVar = new ba();
        baVar.forumName = this.jzF;
        baVar.forumId = this.eYo;
        baVar.pn = -1;
        this.jzD.a(4, this.mPageType, baVar);
    }

    public void k(int i, String str, String str2) {
        this.mPageType = i;
        this.eYo = str;
        this.jzF = str2;
    }

    public void cny() {
        if (this.jzE) {
            this.jzC.bHn();
            this.jzC.showLoadingView();
            cJk();
        }
    }

    public View getView() {
        return this.jzC.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.jzC.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.jzD.bMZ();
    }

    public void b(av avVar) {
        this.jzG = avVar;
    }
}
