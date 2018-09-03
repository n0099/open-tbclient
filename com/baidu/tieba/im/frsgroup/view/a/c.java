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
    private String cBR;
    private ar diW;
    private b etT;
    private String etW;
    private al etX;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> diR = new ArrayList();
    private boolean etV = true;
    private View.OnClickListener etY = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.etV = true;
            c.this.asZ();
        }
    };
    private al etZ = new al() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            if (arVar == null) {
                c.this.etT.completePullRefresh();
                c.this.etT.hideLoadingView();
                return;
            }
            c.this.diW = arVar;
            if ((c.this.diW.pn == 0 || c.this.diW.pn == 1) && c.this.diW.hasMore && !c.this.diW.isLocal) {
                c.this.Tq();
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
            if (c.this.etX != null) {
                c.this.etX.a(i, i2, arVar, arrayList);
            }
            if (w.z(arrayList)) {
                if (c.this.etV) {
                    c.this.etT.hideLoadingView();
                    c.this.etT.a(c.this.diW.errMsg, c.this.etY);
                } else {
                    c.this.etT.completePullRefresh();
                    c.this.etT.aCK();
                }
            } else {
                c.this.diR = arrayList;
                c.this.etT.bN(c.this.diR);
                if (w.y(c.this.diR) != 1 || !(w.d(c.this.diR, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.diW.hasMore) {
                        c.this.etT.aCJ();
                    } else {
                        c.this.etT.aCL();
                    }
                } else {
                    c.this.etT.aKI();
                }
                if (c.this.etV) {
                    c.this.etT.hideLoadingView();
                } else {
                    c.this.etT.completePullRefresh();
                }
            }
            c.this.etV = false;
        }
    };
    private d etU = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.etT = new b(tbPageContext, this);
        this.etU.setTag(this.pageId);
        this.etU.init();
        this.etU.a(this.etZ);
    }

    public void cq(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.etT != null) {
            this.etT.cp(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aR(boolean z) {
        if (this.etT != null) {
            this.etT.hD(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aT(boolean z) {
        aKK();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.jE()) {
            this.etT.aCK();
        }
        if (this.diW != null) {
            if (!this.diW.hasMore) {
                this.etT.aCL();
            } else {
                Tq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tq() {
        if (this.diW != null) {
            ao aoVar = new ao();
            aoVar.forumName = this.etW;
            aoVar.forumId = this.cBR;
            this.diW.pn++;
            aoVar.pn = this.diW.pn;
            this.etU.a(4, this.mPageType, aoVar);
        }
    }

    private void aKK() {
        ao aoVar = new ao();
        aoVar.forumName = this.etW;
        aoVar.forumId = this.cBR;
        aoVar.pn = -1;
        this.etU.a(4, this.mPageType, aoVar);
    }

    public void d(int i, String str, String str2) {
        this.mPageType = i;
        this.cBR = str;
        this.etW = str2;
    }

    public void asZ() {
        if (this.etV) {
            this.etT.Un();
            this.etT.showLoadingView();
            aKK();
        }
    }

    public View getView() {
        return this.etT.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.etT.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.etU.VA();
    }

    public void b(al alVar) {
        this.etX = alVar;
    }
}
