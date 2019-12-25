package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.im.frsgroup.d;
import com.baidu.tieba.im.frsgroup.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class c implements BdListView.e, NoNetworkView.a, g.c {
    private String fGQ;
    private aq gfu;
    private b hvZ;
    private String hwc;
    private aj hwd;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> gfp = new ArrayList();
    private boolean hwb = true;
    private View.OnClickListener hwe = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.hwb = true;
            c.this.bzP();
        }
    };
    private aj hwf = new aj() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<m> arrayList) {
            if (aqVar == null) {
                c.this.hvZ.completePullRefresh();
                c.this.hvZ.hideLoadingView();
                return;
            }
            c.this.gfu = aqVar;
            if ((c.this.gfu.pn == 0 || c.this.gfu.pn == 1) && c.this.gfu.hasMore && !c.this.gfu.isLocal) {
                c.this.aZs();
                return;
            }
            if (arrayList != null) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    m next = it.next();
                    if ((next instanceof j) || (next instanceof n)) {
                        it.remove();
                    }
                }
            }
            if (c.this.hwd != null) {
                c.this.hwd.a(i, i2, aqVar, arrayList);
            }
            if (v.isEmpty(arrayList)) {
                if (c.this.hwb) {
                    c.this.hvZ.hideLoadingView();
                    c.this.hvZ.a(c.this.gfu.errMsg, c.this.hwe);
                } else {
                    c.this.hvZ.completePullRefresh();
                    c.this.hvZ.bJS();
                }
            } else {
                c.this.gfp = arrayList;
                c.this.hvZ.cD(c.this.gfp);
                if (v.getCount(c.this.gfp) != 1 || !(v.getItem(c.this.gfp, 0) instanceof h)) {
                    if (c.this.gfu.hasMore) {
                        c.this.hvZ.bJR();
                    } else {
                        c.this.hvZ.bJT();
                    }
                } else {
                    c.this.hvZ.bSL();
                }
                if (c.this.hwb) {
                    c.this.hvZ.hideLoadingView();
                } else {
                    c.this.hvZ.completePullRefresh();
                }
            }
            c.this.hwb = false;
        }
    };
    private d hwa = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.hvZ = new b(tbPageContext, this);
        this.hwa.setTag(this.pageId);
        this.hwa.init();
        this.hwa.a(this.hwf);
    }

    public void de(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.hvZ != null) {
            this.hvZ.dd(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hvZ != null) {
            this.hvZ.nq(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        bSN();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.hvZ.bJS();
        }
        if (this.gfu != null) {
            if (!this.gfu.hasMore) {
                this.hvZ.bJT();
            } else {
                aZs();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZs() {
        if (this.gfu != null) {
            an anVar = new an();
            anVar.forumName = this.hwc;
            anVar.forumId = this.fGQ;
            this.gfu.pn++;
            anVar.pn = this.gfu.pn;
            this.hwa.a(4, this.mPageType, anVar);
        }
    }

    private void bSN() {
        an anVar = new an();
        anVar.forumName = this.hwc;
        anVar.forumId = this.fGQ;
        anVar.pn = -1;
        this.hwa.a(4, this.mPageType, anVar);
    }

    public void i(int i, String str, String str2) {
        this.mPageType = i;
        this.fGQ = str;
        this.hwc = str2;
    }

    public void bzP() {
        if (this.hwb) {
            this.hvZ.aZK();
            this.hvZ.showLoadingView();
            bSN();
        }
    }

    public View getView() {
        return this.hvZ.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.hvZ.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.hwa.bep();
    }

    public void b(aj ajVar) {
        this.hwd = ajVar;
    }
}
