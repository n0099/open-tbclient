package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.im.frsgroup.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class c implements BdListView.e, NoNetworkView.a, h.c {
    private String eFy;
    private ap fqp;
    private b gIe;
    private String gIh;
    private ai gIi;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> fqk = new ArrayList();
    private boolean gIg = true;
    private View.OnClickListener gIj = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.gIg = true;
            c.this.bky();
        }
    };
    private ai gIk = new ai() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
            if (apVar == null) {
                c.this.gIe.completePullRefresh();
                c.this.gIe.hideLoadingView();
                return;
            }
            c.this.fqp = apVar;
            if ((c.this.fqp.pn == 0 || c.this.fqp.pn == 1) && c.this.fqp.hasMore && !c.this.fqp.isLocal) {
                c.this.aIQ();
                return;
            }
            if (arrayList != null) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    m next = it.next();
                    if ((next instanceof i) || (next instanceof com.baidu.tieba.frs.m)) {
                        it.remove();
                    }
                }
            }
            if (c.this.gIi != null) {
                c.this.gIi.a(i, i2, apVar, arrayList);
            }
            if (v.aa(arrayList)) {
                if (c.this.gIg) {
                    c.this.gIe.hideLoadingView();
                    c.this.gIe.a(c.this.fqp.errMsg, c.this.gIj);
                } else {
                    c.this.gIe.completePullRefresh();
                    c.this.gIe.but();
                }
            } else {
                c.this.fqk = arrayList;
                c.this.gIe.cy(c.this.fqk);
                if (v.Z(c.this.fqk) != 1 || !(v.c(c.this.fqk, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.fqp.hasMore) {
                        c.this.gIe.bus();
                    } else {
                        c.this.gIe.buu();
                    }
                } else {
                    c.this.gIe.bDN();
                }
                if (c.this.gIg) {
                    c.this.gIe.hideLoadingView();
                } else {
                    c.this.gIe.completePullRefresh();
                }
            }
            c.this.gIg = false;
        }
    };
    private d gIf = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.gIe = new b(tbPageContext, this);
        this.gIf.setTag(this.pageId);
        this.gIf.init();
        this.gIf.a(this.gIk);
    }

    public void dd(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.gIe != null) {
            this.gIe.dc(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ep(boolean z) {
        if (this.gIe != null) {
            this.gIe.mm(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        bDP();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.kc()) {
            this.gIe.but();
        }
        if (this.fqp != null) {
            if (!this.fqp.hasMore) {
                this.gIe.buu();
            } else {
                aIQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIQ() {
        if (this.fqp != null) {
            am amVar = new am();
            amVar.forumName = this.gIh;
            amVar.forumId = this.eFy;
            this.fqp.pn++;
            amVar.pn = this.fqp.pn;
            this.gIf.a(4, this.mPageType, amVar);
        }
    }

    private void bDP() {
        am amVar = new am();
        amVar.forumName = this.gIh;
        amVar.forumId = this.eFy;
        amVar.pn = -1;
        this.gIf.a(4, this.mPageType, amVar);
    }

    public void i(int i, String str, String str2) {
        this.mPageType = i;
        this.eFy = str;
        this.gIh = str2;
    }

    public void bky() {
        if (this.gIg) {
            this.gIe.aJh();
            this.gIe.showLoadingView();
            bDP();
        }
    }

    public View getView() {
        return this.gIe.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.gIe.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.gIf.aLx();
    }

    public void b(ai aiVar) {
        this.gIi = aiVar;
    }
}
