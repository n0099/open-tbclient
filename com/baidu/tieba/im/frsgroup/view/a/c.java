package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.im.frsgroup.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements BdListView.e, NoNetworkView.a, f.b {
    private String cBu;
    private ap deq;
    private b emi;
    private String eml;
    private aj emm;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> del = new ArrayList();
    private boolean emk = true;
    private View.OnClickListener emn = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.emk = true;
            c.this.asl();
        }
    };
    private aj emo = new aj() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<h> arrayList) {
            if (apVar == null) {
                c.this.emi.completePullRefresh();
                c.this.emi.hideLoadingView();
                return;
            }
            c.this.deq = apVar;
            if ((c.this.deq.pn == 0 || c.this.deq.pn == 1) && c.this.deq.hasMore && !c.this.deq.isLocal) {
                c.this.SJ();
                return;
            }
            if (arrayList != null) {
                Iterator<h> it = arrayList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if ((next instanceof g) || (next instanceof k)) {
                        it.remove();
                    }
                }
            }
            if (c.this.emm != null) {
                c.this.emm.a(i, i2, apVar, arrayList);
            }
            if (w.z(arrayList)) {
                if (c.this.emk) {
                    c.this.emi.hideLoadingView();
                    c.this.emi.a(c.this.deq.errMsg, c.this.emn);
                } else {
                    c.this.emi.completePullRefresh();
                    c.this.emi.aBy();
                }
            } else {
                c.this.del = arrayList;
                c.this.emi.bK(c.this.del);
                if (w.y(c.this.del) != 1 || !(w.c(c.this.del, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.deq.hasMore) {
                        c.this.emi.aBx();
                    } else {
                        c.this.emi.aBz();
                    }
                } else {
                    c.this.emi.aJd();
                }
                if (c.this.emk) {
                    c.this.emi.hideLoadingView();
                } else {
                    c.this.emi.completePullRefresh();
                }
            }
            c.this.emk = false;
        }
    };
    private d emj = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.emi = new b(tbPageContext, this);
        this.emj.setTag(this.pageId);
        this.emj.init();
        this.emj.a(this.emo);
    }

    public void cm(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.emi != null) {
            this.emi.cl(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aQ(boolean z) {
        if (this.emi != null) {
            this.emi.hq(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.b
    public void aS(boolean z) {
        aJf();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.jD()) {
            this.emi.aBy();
        }
        if (this.deq != null) {
            if (!this.deq.hasMore) {
                this.emi.aBz();
            } else {
                SJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SJ() {
        if (this.deq != null) {
            am amVar = new am();
            amVar.forumName = this.eml;
            amVar.forumId = this.cBu;
            this.deq.pn++;
            amVar.pn = this.deq.pn;
            this.emj.a(4, this.mPageType, amVar);
        }
    }

    private void aJf() {
        am amVar = new am();
        amVar.forumName = this.eml;
        amVar.forumId = this.cBu;
        amVar.pn = -1;
        this.emj.a(4, this.mPageType, amVar);
    }

    public void d(int i, String str, String str2) {
        this.mPageType = i;
        this.cBu = str;
        this.eml = str2;
    }

    public void asl() {
        if (this.emk) {
            this.emi.TI();
            this.emi.showLoadingView();
            aJf();
        }
    }

    public View getView() {
        return this.emi.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.emi.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.emj.UT();
    }

    public void b(aj ajVar) {
        this.emm = ajVar;
    }
}
