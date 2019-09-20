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
    private String eHo;
    private ap fsC;
    private b gKO;
    private String gKR;
    private ai gKS;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> fsx = new ArrayList();
    private boolean gKQ = true;
    private View.OnClickListener gKT = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.gKQ = true;
            c.this.blq();
        }
    };
    private ai gKU = new ai() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
            if (apVar == null) {
                c.this.gKO.completePullRefresh();
                c.this.gKO.hideLoadingView();
                return;
            }
            c.this.fsC = apVar;
            if ((c.this.fsC.pn == 0 || c.this.fsC.pn == 1) && c.this.fsC.hasMore && !c.this.fsC.isLocal) {
                c.this.aJw();
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
            if (c.this.gKS != null) {
                c.this.gKS.a(i, i2, apVar, arrayList);
            }
            if (v.aa(arrayList)) {
                if (c.this.gKQ) {
                    c.this.gKO.hideLoadingView();
                    c.this.gKO.a(c.this.fsC.errMsg, c.this.gKT);
                } else {
                    c.this.gKO.completePullRefresh();
                    c.this.gKO.bvu();
                }
            } else {
                c.this.fsx = arrayList;
                c.this.gKO.cx(c.this.fsx);
                if (v.Z(c.this.fsx) != 1 || !(v.c(c.this.fsx, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.fsC.hasMore) {
                        c.this.gKO.bvt();
                    } else {
                        c.this.gKO.bvv();
                    }
                } else {
                    c.this.gKO.bEP();
                }
                if (c.this.gKQ) {
                    c.this.gKO.hideLoadingView();
                } else {
                    c.this.gKO.completePullRefresh();
                }
            }
            c.this.gKQ = false;
        }
    };
    private d gKP = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.gKO = new b(tbPageContext, this);
        this.gKP.setTag(this.pageId);
        this.gKP.init();
        this.gKP.a(this.gKU);
    }

    public void dc(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.gKO != null) {
            this.gKO.db(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void es(boolean z) {
        if (this.gKO != null) {
            this.gKO.mp(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void eu(boolean z) {
        bER();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.kc()) {
            this.gKO.bvu();
        }
        if (this.fsC != null) {
            if (!this.fsC.hasMore) {
                this.gKO.bvv();
            } else {
                aJw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJw() {
        if (this.fsC != null) {
            am amVar = new am();
            amVar.forumName = this.gKR;
            amVar.forumId = this.eHo;
            this.fsC.pn++;
            amVar.pn = this.fsC.pn;
            this.gKP.a(4, this.mPageType, amVar);
        }
    }

    private void bER() {
        am amVar = new am();
        amVar.forumName = this.gKR;
        amVar.forumId = this.eHo;
        amVar.pn = -1;
        this.gKP.a(4, this.mPageType, amVar);
    }

    public void j(int i, String str, String str2) {
        this.mPageType = i;
        this.eHo = str;
        this.gKR = str2;
    }

    public void blq() {
        if (this.gKQ) {
            this.gKO.aJN();
            this.gKO.showLoadingView();
            bER();
        }
    }

    public View getView() {
        return this.gKO.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.gKO.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.gKP.aMd();
    }

    public void b(ai aiVar) {
        this.gKS = aiVar;
    }
}
