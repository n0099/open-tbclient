package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.im.frsgroup.d;
import com.baidu.tieba.im.frsgroup.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements BdListView.e, NoNetworkView.a, g.c {
    private String emF;
    private ar glC;
    private b hDp;
    private String hDs;
    private ak hDt;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> glx = new ArrayList();
    private boolean hDr = true;
    private View.OnClickListener hDu = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.hDr = true;
            c.this.bCC();
        }
    };
    private ak hDv = new ak() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, ar arVar, ArrayList<m> arrayList) {
            if (arVar == null) {
                c.this.hDp.completePullRefresh();
                c.this.hDp.hideLoadingView();
                return;
            }
            c.this.glC = arVar;
            if ((c.this.glC.pn == 0 || c.this.glC.pn == 1) && c.this.glC.hasMore && !c.this.glC.isLocal) {
                c.this.bck();
                return;
            }
            if (arrayList != null) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    m next = it.next();
                    if ((next instanceof k) || (next instanceof o)) {
                        it.remove();
                    }
                }
            }
            if (c.this.hDt != null) {
                c.this.hDt.a(i, i2, arVar, arrayList);
            }
            if (v.isEmpty(arrayList)) {
                if (c.this.hDr) {
                    c.this.hDp.hideLoadingView();
                    c.this.hDp.a(c.this.glC.errMsg, c.this.hDu);
                } else {
                    c.this.hDp.completePullRefresh();
                    c.this.hDp.bMQ();
                }
            } else {
                c.this.glx = arrayList;
                c.this.hDp.cz(c.this.glx);
                if (v.getCount(c.this.glx) != 1 || !(v.getItem(c.this.glx, 0) instanceof h)) {
                    if (c.this.glC.hasMore) {
                        c.this.hDp.bMP();
                    } else {
                        c.this.hDp.bMR();
                    }
                } else {
                    c.this.hDp.bVQ();
                }
                if (c.this.hDr) {
                    c.this.hDp.hideLoadingView();
                } else {
                    c.this.hDp.completePullRefresh();
                }
            }
            c.this.hDr = false;
        }
    };
    private d hDq = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.hDp = new b(tbPageContext, this);
        this.hDq.setTag(this.pageId);
        this.hDq.init();
        this.hDq.a(this.hDv);
    }

    public void da(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.hDp != null) {
            this.hDp.cZ(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hDp != null) {
            this.hDp.nK(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        bVS();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.hDp.bMQ();
        }
        if (this.glC != null) {
            if (!this.glC.hasMore) {
                this.hDp.bMR();
            } else {
                bck();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bck() {
        if (this.glC != null) {
            ao aoVar = new ao();
            aoVar.forumName = this.hDs;
            aoVar.forumId = this.emF;
            this.glC.pn++;
            aoVar.pn = this.glC.pn;
            this.hDq.a(4, this.mPageType, aoVar);
        }
    }

    private void bVS() {
        ao aoVar = new ao();
        aoVar.forumName = this.hDs;
        aoVar.forumId = this.emF;
        aoVar.pn = -1;
        this.hDq.a(4, this.mPageType, aoVar);
    }

    public void i(int i, String str, String str2) {
        this.mPageType = i;
        this.emF = str;
        this.hDs = str2;
    }

    public void bCC() {
        if (this.hDr) {
            this.hDp.bcC();
            this.hDp.showLoadingView();
            bVS();
        }
    }

    public View getView() {
        return this.hDp.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.hDp.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.hDq.bhc();
    }

    public void b(ak akVar) {
        this.hDt = akVar;
    }
}
