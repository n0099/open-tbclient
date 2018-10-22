package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
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
public class c implements BdListView.e, NoNetworkView.a, j.b {
    private String cQb;
    private ar dwR;
    private b eIX;
    private String eJa;
    private al eJb;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> dwM = new ArrayList();
    private boolean eIZ = true;
    private View.OnClickListener eJc = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.eIZ = true;
            c.this.ayk();
        }
    };
    private al eJd = new al() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            if (arVar == null) {
                c.this.eIX.completePullRefresh();
                c.this.eIX.hideLoadingView();
                return;
            }
            c.this.dwR = arVar;
            if ((c.this.dwR.pn == 0 || c.this.dwR.pn == 1) && c.this.dwR.hasMore && !c.this.dwR.isLocal) {
                c.this.YL();
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
            if (c.this.eJb != null) {
                c.this.eJb.a(i, i2, arVar, arrayList);
            }
            if (v.J(arrayList)) {
                if (c.this.eIZ) {
                    c.this.eIX.hideLoadingView();
                    c.this.eIX.a(c.this.dwR.errMsg, c.this.eJc);
                } else {
                    c.this.eIX.completePullRefresh();
                    c.this.eIX.aIp();
                }
            } else {
                c.this.dwM = arrayList;
                c.this.eIX.ce(c.this.dwM);
                if (v.I(c.this.dwM) != 1 || !(v.d(c.this.dwM, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.dwR.hasMore) {
                        c.this.eIX.aIo();
                    } else {
                        c.this.eIX.aIq();
                    }
                } else {
                    c.this.eIX.aQm();
                }
                if (c.this.eIZ) {
                    c.this.eIX.hideLoadingView();
                } else {
                    c.this.eIX.completePullRefresh();
                }
            }
            c.this.eIZ = false;
        }
    };
    private d eIY = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.eIX = new b(tbPageContext, this);
        this.eIY.setTag(this.pageId);
        this.eIY.init();
        this.eIY.a(this.eJd);
    }

    public void cG(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.eIX != null) {
            this.eIX.cF(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bn(boolean z) {
        if (this.eIX != null) {
            this.eIX.it(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bp(boolean z) {
        aQo();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.kX()) {
            this.eIX.aIp();
        }
        if (this.dwR != null) {
            if (!this.dwR.hasMore) {
                this.eIX.aIq();
            } else {
                YL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YL() {
        if (this.dwR != null) {
            ao aoVar = new ao();
            aoVar.forumName = this.eJa;
            aoVar.forumId = this.cQb;
            this.dwR.pn++;
            aoVar.pn = this.dwR.pn;
            this.eIY.a(4, this.mPageType, aoVar);
        }
    }

    private void aQo() {
        ao aoVar = new ao();
        aoVar.forumName = this.eJa;
        aoVar.forumId = this.cQb;
        aoVar.pn = -1;
        this.eIY.a(4, this.mPageType, aoVar);
    }

    public void f(int i, String str, String str2) {
        this.mPageType = i;
        this.cQb = str;
        this.eJa = str2;
    }

    public void ayk() {
        if (this.eIZ) {
            this.eIX.ZI();
            this.eIX.showLoadingView();
            aQo();
        }
    }

    public View getView() {
        return this.eIX.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.eIX.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.eIY.aaV();
    }

    public void b(al alVar) {
        this.eJb = alVar;
    }
}
