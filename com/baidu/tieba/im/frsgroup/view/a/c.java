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
    private ap cTY;
    private String crG;
    private b dZO;
    private String dZR;
    private aj dZS;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<h> cTT = new ArrayList();
    private boolean dZQ = true;
    private View.OnClickListener dZT = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            c.this.dZQ = true;
            c.this.aoh();
        }
    };
    private aj dZU = new aj() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<h> arrayList) {
            if (apVar == null) {
                c.this.dZO.completePullRefresh();
                c.this.dZO.Ou();
                return;
            }
            c.this.cTY = apVar;
            if ((c.this.cTY.pn == 0 || c.this.cTY.pn == 1) && c.this.cTY.hasMore && !c.this.cTY.isLocal) {
                c.this.Po();
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
            if (c.this.dZS != null) {
                c.this.dZS.a(i, i2, apVar, arrayList);
            }
            if (v.w(arrayList)) {
                if (c.this.dZQ) {
                    c.this.dZO.Ou();
                    c.this.dZO.a(c.this.cTY.errMsg, c.this.dZT);
                } else {
                    c.this.dZO.completePullRefresh();
                    c.this.dZO.awH();
                }
            } else {
                c.this.cTT = arrayList;
                c.this.dZO.bC(c.this.cTT);
                if (v.v(c.this.cTT) != 1 || !(v.c(c.this.cTT, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.cTY.hasMore) {
                        c.this.dZO.awG();
                    } else {
                        c.this.dZO.awI();
                    }
                } else {
                    c.this.dZO.aEk();
                }
                if (c.this.dZQ) {
                    c.this.dZO.Ou();
                } else {
                    c.this.dZO.completePullRefresh();
                }
            }
            c.this.dZQ = false;
        }
    };
    private d dZP = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.dZO = new b(tbPageContext, this);
        this.dZP.setTag(this.pageId);
        this.dZP.init();
        this.dZP.a(this.dZU);
    }

    public void ce(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.dZO != null) {
            this.dZO.cd(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        if (this.dZO != null) {
            this.dZO.hj(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.e.b
    public void aO(boolean z) {
        aEm();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.gP()) {
            this.dZO.awH();
        }
        if (this.cTY != null) {
            if (!this.cTY.hasMore) {
                this.dZO.awI();
            } else {
                Po();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po() {
        if (this.cTY != null) {
            am amVar = new am();
            amVar.forumName = this.dZR;
            amVar.forumId = this.crG;
            this.cTY.pn++;
            amVar.pn = this.cTY.pn;
            this.dZP.a(4, this.mPageType, amVar);
        }
    }

    private void aEm() {
        am amVar = new am();
        amVar.forumName = this.dZR;
        amVar.forumId = this.crG;
        amVar.pn = -1;
        this.dZP.a(4, this.mPageType, amVar);
    }

    public void d(int i, String str, String str2) {
        this.mPageType = i;
        this.crG = str;
        this.dZR = str2;
    }

    public void aoh() {
        if (this.dZQ) {
            this.dZO.Qn();
            this.dZO.showLoadingView();
            aEm();
        }
    }

    public View getView() {
        return this.dZO.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.dZO.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.dZP.Ry();
    }

    public void b(aj ajVar) {
        this.dZS = ajVar;
    }
}
