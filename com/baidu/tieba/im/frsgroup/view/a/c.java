package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.e;
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
public class c implements BdListView.e, NoNetworkView.a, e.b {
    private ap cVf;
    private String csP;
    private b eaV;
    private String eaY;
    private aj eaZ;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> cVa = new ArrayList();
    private boolean eaX = true;
    private View.OnClickListener eba = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            c.this.eaX = true;
            c.this.aog();
        }
    };
    private aj ebb = new aj() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<h> arrayList) {
            if (apVar == null) {
                c.this.eaV.completePullRefresh();
                c.this.eaV.Os();
                return;
            }
            c.this.cVf = apVar;
            if ((c.this.cVf.pn == 0 || c.this.cVf.pn == 1) && c.this.cVf.hasMore && !c.this.cVf.isLocal) {
                c.this.Pl();
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
            if (c.this.eaZ != null) {
                c.this.eaZ.a(i, i2, apVar, arrayList);
            }
            if (v.w(arrayList)) {
                if (c.this.eaX) {
                    c.this.eaV.Os();
                    c.this.eaV.a(c.this.cVf.errMsg, c.this.eba);
                } else {
                    c.this.eaV.completePullRefresh();
                    c.this.eaV.awG();
                }
            } else {
                c.this.cVa = arrayList;
                c.this.eaV.bF(c.this.cVa);
                if (v.v(c.this.cVa) != 1 || !(v.c(c.this.cVa, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.cVf.hasMore) {
                        c.this.eaV.awF();
                    } else {
                        c.this.eaV.awH();
                    }
                } else {
                    c.this.eaV.aEi();
                }
                if (c.this.eaX) {
                    c.this.eaV.Os();
                } else {
                    c.this.eaV.completePullRefresh();
                }
            }
            c.this.eaX = false;
        }
    };
    private d eaW = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.eaV = new b(tbPageContext, this);
        this.eaW.setTag(this.pageId);
        this.eaW.init();
        this.eaW.a(this.ebb);
    }

    public void ch(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.eaV != null) {
            this.eaV.cg(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        if (this.eaV != null) {
            this.eaV.hk(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.e.b
    public void aO(boolean z) {
        aEk();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.gP()) {
            this.eaV.awG();
        }
        if (this.cVf != null) {
            if (!this.cVf.hasMore) {
                this.eaV.awH();
            } else {
                Pl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pl() {
        if (this.cVf != null) {
            am amVar = new am();
            amVar.forumName = this.eaY;
            amVar.forumId = this.csP;
            this.cVf.pn++;
            amVar.pn = this.cVf.pn;
            this.eaW.a(4, this.mPageType, amVar);
        }
    }

    private void aEk() {
        am amVar = new am();
        amVar.forumName = this.eaY;
        amVar.forumId = this.csP;
        amVar.pn = -1;
        this.eaW.a(4, this.mPageType, amVar);
    }

    public void d(int i, String str, String str2) {
        this.mPageType = i;
        this.csP = str;
        this.eaY = str2;
    }

    public void aog() {
        if (this.eaX) {
            this.eaV.Qk();
            this.eaV.showLoadingView();
            aEk();
        }
    }

    public View getView() {
        return this.eaV.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.eaV.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.eaW.Rv();
    }

    public void b(aj ajVar) {
        this.eaZ = ajVar;
    }
}
