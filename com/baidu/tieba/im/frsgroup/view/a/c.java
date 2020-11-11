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
/* loaded from: classes23.dex */
public class c implements BdListView.e, NoNetworkView.a, f.c {
    private String fyR;
    private bd iDu;
    private b kgV;
    private String kgY;
    private av kgZ;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<q> iDp = new ArrayList();
    private boolean kgX = true;
    private View.OnClickListener kha = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.kgX = true;
            c.this.cwE();
        }
    };
    private av khb = new av() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
            if (bdVar == null) {
                c.this.kgV.completePullRefresh();
                c.this.kgV.hideLoadingView();
                return;
            }
            c.this.iDu = bdVar;
            if ((c.this.iDu.pn == 0 || c.this.iDu.pn == 1) && c.this.iDu.hasMore && !c.this.iDu.isLocal) {
                c.this.bOI();
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
            if (c.this.kgZ != null) {
                c.this.kgZ.a(i, i2, bdVar, arrayList);
            }
            if (y.isEmpty(arrayList)) {
                if (c.this.kgX) {
                    c.this.kgV.hideLoadingView();
                    c.this.kgV.d(c.this.iDu.errMsg, c.this.kha);
                } else {
                    c.this.kgV.completePullRefresh();
                    c.this.kgV.cHW();
                }
            } else {
                c.this.iDp = arrayList;
                c.this.kgV.dy(c.this.iDp);
                if (y.getCount(c.this.iDp) != 1 || !(y.getItem(c.this.iDp, 0) instanceof h)) {
                    if (c.this.iDu.hasMore) {
                        c.this.kgV.cHV();
                    } else {
                        c.this.kgV.cHX();
                    }
                } else {
                    c.this.kgV.cSz();
                }
                if (c.this.kgX) {
                    c.this.kgV.hideLoadingView();
                } else {
                    c.this.kgV.completePullRefresh();
                }
            }
            c.this.kgX = false;
        }
    };
    private d kgW = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.kgV = new b(tbPageContext, this);
        this.kgW.setTag(this.pageId);
        this.kgW.init();
        this.kgW.a(this.khb);
    }

    public void eo(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.kgV != null) {
            this.kgV.en(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.kgV != null) {
            this.kgV.rY(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cSB();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.kgV.cHW();
        }
        if (this.iDu != null) {
            if (!this.iDu.hasMore) {
                this.kgV.cHX();
            } else {
                bOI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOI() {
        if (this.iDu != null) {
            ba baVar = new ba();
            baVar.forumName = this.kgY;
            baVar.forumId = this.fyR;
            this.iDu.pn++;
            baVar.pn = this.iDu.pn;
            this.kgW.a(4, this.mPageType, baVar);
        }
    }

    private void cSB() {
        ba baVar = new ba();
        baVar.forumName = this.kgY;
        baVar.forumId = this.fyR;
        baVar.pn = -1;
        this.kgW.a(4, this.mPageType, baVar);
    }

    public void k(int i, String str, String str2) {
        this.mPageType = i;
        this.fyR = str;
        this.kgY = str2;
    }

    public void cwE() {
        if (this.kgX) {
            this.kgV.Wk();
            this.kgV.showLoadingView();
            cSB();
        }
    }

    public View getView() {
        return this.kgV.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.kgV.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.kgW.bVV();
    }

    public void b(av avVar) {
        this.kgZ = avVar;
    }
}
