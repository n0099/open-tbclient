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
    private String czo;
    private ar dgi;
    private b eqe;
    private String eqh;
    private al eqi;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> dgd = new ArrayList();
    private boolean eqg = true;
    private View.OnClickListener eqj = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.eqg = true;
            c.this.asw();
        }
    };
    private al eqk = new al() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            if (arVar == null) {
                c.this.eqe.completePullRefresh();
                c.this.eqe.hideLoadingView();
                return;
            }
            c.this.dgi = arVar;
            if ((c.this.dgi.pn == 0 || c.this.dgi.pn == 1) && c.this.dgi.hasMore && !c.this.dgi.isLocal) {
                c.this.Tf();
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
            if (c.this.eqi != null) {
                c.this.eqi.a(i, i2, arVar, arrayList);
            }
            if (w.A(arrayList)) {
                if (c.this.eqg) {
                    c.this.eqe.hideLoadingView();
                    c.this.eqe.a(c.this.dgi.errMsg, c.this.eqj);
                } else {
                    c.this.eqe.completePullRefresh();
                    c.this.eqe.aCe();
                }
            } else {
                c.this.dgd = arrayList;
                c.this.eqe.bO(c.this.dgd);
                if (w.z(c.this.dgd) != 1 || !(w.d(c.this.dgd, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.dgi.hasMore) {
                        c.this.eqe.aCd();
                    } else {
                        c.this.eqe.aCf();
                    }
                } else {
                    c.this.eqe.aJK();
                }
                if (c.this.eqg) {
                    c.this.eqe.hideLoadingView();
                } else {
                    c.this.eqe.completePullRefresh();
                }
            }
            c.this.eqg = false;
        }
    };
    private d eqf = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.eqe = new b(tbPageContext, this);
        this.eqf.setTag(this.pageId);
        this.eqf.init();
        this.eqf.a(this.eqk);
    }

    public void cq(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.eqe != null) {
            this.eqe.cp(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aS(boolean z) {
        if (this.eqe != null) {
            this.eqe.hA(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aU(boolean z) {
        aJM();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.jD()) {
            this.eqe.aCe();
        }
        if (this.dgi != null) {
            if (!this.dgi.hasMore) {
                this.eqe.aCf();
            } else {
                Tf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        if (this.dgi != null) {
            ao aoVar = new ao();
            aoVar.forumName = this.eqh;
            aoVar.forumId = this.czo;
            this.dgi.pn++;
            aoVar.pn = this.dgi.pn;
            this.eqf.a(4, this.mPageType, aoVar);
        }
    }

    private void aJM() {
        ao aoVar = new ao();
        aoVar.forumName = this.eqh;
        aoVar.forumId = this.czo;
        aoVar.pn = -1;
        this.eqf.a(4, this.mPageType, aoVar);
    }

    public void d(int i, String str, String str2) {
        this.mPageType = i;
        this.czo = str;
        this.eqh = str2;
    }

    public void asw() {
        if (this.eqg) {
            this.eqe.Uc();
            this.eqe.showLoadingView();
            aJM();
        }
    }

    public View getView() {
        return this.eqe.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.eqe.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.eqf.Vo();
    }

    public void b(al alVar) {
        this.eqi = alVar;
    }
}
