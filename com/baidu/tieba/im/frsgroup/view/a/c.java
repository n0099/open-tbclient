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
    private b eIW;
    private String eIZ;
    private al eJa;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> dwM = new ArrayList();
    private boolean eIY = true;
    private View.OnClickListener eJb = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.eIY = true;
            c.this.ayj();
        }
    };
    private al eJc = new al() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<h> arrayList) {
            if (arVar == null) {
                c.this.eIW.completePullRefresh();
                c.this.eIW.hideLoadingView();
                return;
            }
            c.this.dwR = arVar;
            if ((c.this.dwR.pn == 0 || c.this.dwR.pn == 1) && c.this.dwR.hasMore && !c.this.dwR.isLocal) {
                c.this.YK();
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
            if (c.this.eJa != null) {
                c.this.eJa.a(i, i2, arVar, arrayList);
            }
            if (v.J(arrayList)) {
                if (c.this.eIY) {
                    c.this.eIW.hideLoadingView();
                    c.this.eIW.a(c.this.dwR.errMsg, c.this.eJb);
                } else {
                    c.this.eIW.completePullRefresh();
                    c.this.eIW.aIp();
                }
            } else {
                c.this.dwM = arrayList;
                c.this.eIW.ce(c.this.dwM);
                if (v.I(c.this.dwM) != 1 || !(v.d(c.this.dwM, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.dwR.hasMore) {
                        c.this.eIW.aIo();
                    } else {
                        c.this.eIW.aIq();
                    }
                } else {
                    c.this.eIW.aQm();
                }
                if (c.this.eIY) {
                    c.this.eIW.hideLoadingView();
                } else {
                    c.this.eIW.completePullRefresh();
                }
            }
            c.this.eIY = false;
        }
    };
    private d eIX = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.eIW = new b(tbPageContext, this);
        this.eIX.setTag(this.pageId);
        this.eIX.init();
        this.eIX.a(this.eJc);
    }

    public void cG(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.eIW != null) {
            this.eIW.cF(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bn(boolean z) {
        if (this.eIW != null) {
            this.eIW.it(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bp(boolean z) {
        aQo();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.kX()) {
            this.eIW.aIp();
        }
        if (this.dwR != null) {
            if (!this.dwR.hasMore) {
                this.eIW.aIq();
            } else {
                YK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YK() {
        if (this.dwR != null) {
            ao aoVar = new ao();
            aoVar.forumName = this.eIZ;
            aoVar.forumId = this.cQb;
            this.dwR.pn++;
            aoVar.pn = this.dwR.pn;
            this.eIX.a(4, this.mPageType, aoVar);
        }
    }

    private void aQo() {
        ao aoVar = new ao();
        aoVar.forumName = this.eIZ;
        aoVar.forumId = this.cQb;
        aoVar.pn = -1;
        this.eIX.a(4, this.mPageType, aoVar);
    }

    public void f(int i, String str, String str2) {
        this.mPageType = i;
        this.cQb = str;
        this.eIZ = str2;
    }

    public void ayj() {
        if (this.eIY) {
            this.eIW.ZH();
            this.eIW.showLoadingView();
            aQo();
        }
    }

    public View getView() {
        return this.eIW.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.eIW.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.eIX.aaU();
    }

    public void b(al alVar) {
        this.eJa = alVar;
    }
}
