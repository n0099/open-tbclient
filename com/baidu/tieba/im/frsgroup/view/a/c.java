package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
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
public class c implements BdListView.e, NoNetworkView.a, g.b {
    private String cBU;
    private ar diY;
    private b etX;
    private String eua;
    private al eub;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> diT = new ArrayList();
    private boolean etZ = true;
    private View.OnClickListener euc = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.etZ = true;
            c.this.ata();
        }
    };
    private al eud = new al() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            if (arVar == null) {
                c.this.etX.completePullRefresh();
                c.this.etX.hideLoadingView();
                return;
            }
            c.this.diY = arVar;
            if ((c.this.diY.pn == 0 || c.this.diY.pn == 1) && c.this.diY.hasMore && !c.this.diY.isLocal) {
                c.this.Tn();
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
            if (c.this.eub != null) {
                c.this.eub.a(i, i2, arVar, arrayList);
            }
            if (w.z(arrayList)) {
                if (c.this.etZ) {
                    c.this.etX.hideLoadingView();
                    c.this.etX.a(c.this.diY.errMsg, c.this.euc);
                } else {
                    c.this.etX.completePullRefresh();
                    c.this.etX.aCN();
                }
            } else {
                c.this.diT = arrayList;
                c.this.etX.bN(c.this.diT);
                if (w.y(c.this.diT) != 1 || !(w.d(c.this.diT, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.diY.hasMore) {
                        c.this.etX.aCM();
                    } else {
                        c.this.etX.aCO();
                    }
                } else {
                    c.this.etX.aKL();
                }
                if (c.this.etZ) {
                    c.this.etX.hideLoadingView();
                } else {
                    c.this.etX.completePullRefresh();
                }
            }
            c.this.etZ = false;
        }
    };
    private d etY = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.etX = new b(tbPageContext, this);
        this.etY.setTag(this.pageId);
        this.etY.init();
        this.etY.a(this.eud);
    }

    public void cq(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.etX != null) {
            this.etX.cp(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aQ(boolean z) {
        if (this.etX != null) {
            this.etX.hD(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aS(boolean z) {
        aKN();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.jE()) {
            this.etX.aCN();
        }
        if (this.diY != null) {
            if (!this.diY.hasMore) {
                this.etX.aCO();
            } else {
                Tn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tn() {
        if (this.diY != null) {
            ao aoVar = new ao();
            aoVar.forumName = this.eua;
            aoVar.forumId = this.cBU;
            this.diY.pn++;
            aoVar.pn = this.diY.pn;
            this.etY.a(4, this.mPageType, aoVar);
        }
    }

    private void aKN() {
        ao aoVar = new ao();
        aoVar.forumName = this.eua;
        aoVar.forumId = this.cBU;
        aoVar.pn = -1;
        this.etY.a(4, this.mPageType, aoVar);
    }

    public void d(int i, String str, String str2) {
        this.mPageType = i;
        this.cBU = str;
        this.eua = str2;
    }

    public void ata() {
        if (this.etZ) {
            this.etX.Uk();
            this.etX.showLoadingView();
            aKN();
        }
    }

    public View getView() {
        return this.etX.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.etX.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.etY.Vx();
    }

    public void b(al alVar) {
        this.eub = alVar;
    }
}
