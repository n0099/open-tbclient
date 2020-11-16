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
    private String fyg;
    private bd iEi;
    private b khF;
    private String khI;
    private av khJ;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<q> iEd = new ArrayList();
    private boolean khH = true;
    private View.OnClickListener khK = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.khH = true;
            c.this.cwh();
        }
    };
    private av khL = new av() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
            if (bdVar == null) {
                c.this.khF.completePullRefresh();
                c.this.khF.hideLoadingView();
                return;
            }
            c.this.iEi = bdVar;
            if ((c.this.iEi.pn == 0 || c.this.iEi.pn == 1) && c.this.iEi.hasMore && !c.this.iEi.isLocal) {
                c.this.bOb();
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
            if (c.this.khJ != null) {
                c.this.khJ.a(i, i2, bdVar, arrayList);
            }
            if (y.isEmpty(arrayList)) {
                if (c.this.khH) {
                    c.this.khF.hideLoadingView();
                    c.this.khF.d(c.this.iEi.errMsg, c.this.khK);
                } else {
                    c.this.khF.completePullRefresh();
                    c.this.khF.cHB();
                }
            } else {
                c.this.iEd = arrayList;
                c.this.khF.dy(c.this.iEd);
                if (y.getCount(c.this.iEd) != 1 || !(y.getItem(c.this.iEd, 0) instanceof h)) {
                    if (c.this.iEi.hasMore) {
                        c.this.khF.cHA();
                    } else {
                        c.this.khF.cHC();
                    }
                } else {
                    c.this.khF.cSf();
                }
                if (c.this.khH) {
                    c.this.khF.hideLoadingView();
                } else {
                    c.this.khF.completePullRefresh();
                }
            }
            c.this.khH = false;
        }
    };
    private d khG = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.khF = new b(tbPageContext, this);
        this.khG.setTag(this.pageId);
        this.khG.init();
        this.khG.a(this.khL);
    }

    public void eo(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.khF != null) {
            this.khF.en(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.khF != null) {
            this.khF.sb(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cSh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.khF.cHB();
        }
        if (this.iEi != null) {
            if (!this.iEi.hasMore) {
                this.khF.cHC();
            } else {
                bOb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOb() {
        if (this.iEi != null) {
            ba baVar = new ba();
            baVar.forumName = this.khI;
            baVar.forumId = this.fyg;
            this.iEi.pn++;
            baVar.pn = this.iEi.pn;
            this.khG.a(4, this.mPageType, baVar);
        }
    }

    private void cSh() {
        ba baVar = new ba();
        baVar.forumName = this.khI;
        baVar.forumId = this.fyg;
        baVar.pn = -1;
        this.khG.a(4, this.mPageType, baVar);
    }

    public void k(int i, String str, String str2) {
        this.mPageType = i;
        this.fyg = str;
        this.khI = str2;
    }

    public void cwh() {
        if (this.khH) {
            this.khF.VB();
            this.khF.showLoadingView();
            cSh();
        }
    }

    public View getView() {
        return this.khF.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.khF.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.khG.bVo();
    }

    public void b(av avVar) {
        this.khJ = avVar;
    }
}
