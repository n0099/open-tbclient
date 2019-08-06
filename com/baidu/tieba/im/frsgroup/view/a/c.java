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
    private String eFF;
    private ap fqO;
    private b gIW;
    private String gIZ;
    private ai gJa;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<m> fqJ = new ArrayList();
    private boolean gIY = true;
    private View.OnClickListener gJb = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.gIY = true;
            c.this.bkF();
        }
    };
    private ai gJc = new ai() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
            if (apVar == null) {
                c.this.gIW.completePullRefresh();
                c.this.gIW.hideLoadingView();
                return;
            }
            c.this.fqO = apVar;
            if ((c.this.fqO.pn == 0 || c.this.fqO.pn == 1) && c.this.fqO.hasMore && !c.this.fqO.isLocal) {
                c.this.aIS();
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
            if (c.this.gJa != null) {
                c.this.gJa.a(i, i2, apVar, arrayList);
            }
            if (v.aa(arrayList)) {
                if (c.this.gIY) {
                    c.this.gIW.hideLoadingView();
                    c.this.gIW.a(c.this.fqO.errMsg, c.this.gJb);
                } else {
                    c.this.gIW.completePullRefresh();
                    c.this.gIW.buG();
                }
            } else {
                c.this.fqJ = arrayList;
                c.this.gIW.cx(c.this.fqJ);
                if (v.Z(c.this.fqJ) != 1 || !(v.c(c.this.fqJ, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.fqO.hasMore) {
                        c.this.gIW.buF();
                    } else {
                        c.this.gIW.buH();
                    }
                } else {
                    c.this.gIW.bEb();
                }
                if (c.this.gIY) {
                    c.this.gIW.hideLoadingView();
                } else {
                    c.this.gIW.completePullRefresh();
                }
            }
            c.this.gIY = false;
        }
    };
    private d gIX = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.gIW = new b(tbPageContext, this);
        this.gIX.setTag(this.pageId);
        this.gIX.init();
        this.gIX.a(this.gJc);
    }

    public void dc(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.gIW != null) {
            this.gIW.db(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ep(boolean z) {
        if (this.gIW != null) {
            this.gIW.mm(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        bEd();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.kc()) {
            this.gIW.buG();
        }
        if (this.fqO != null) {
            if (!this.fqO.hasMore) {
                this.gIW.buH();
            } else {
                aIS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIS() {
        if (this.fqO != null) {
            am amVar = new am();
            amVar.forumName = this.gIZ;
            amVar.forumId = this.eFF;
            this.fqO.pn++;
            amVar.pn = this.fqO.pn;
            this.gIX.a(4, this.mPageType, amVar);
        }
    }

    private void bEd() {
        am amVar = new am();
        amVar.forumName = this.gIZ;
        amVar.forumId = this.eFF;
        amVar.pn = -1;
        this.gIX.a(4, this.mPageType, amVar);
    }

    public void i(int i, String str, String str2) {
        this.mPageType = i;
        this.eFF = str;
        this.gIZ = str2;
    }

    public void bkF() {
        if (this.gIY) {
            this.gIW.aJj();
            this.gIW.showLoadingView();
            bEd();
        }
    }

    public View getView() {
        return this.gIW.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.gIW.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.gIX.aLz();
    }

    public void b(ai aiVar) {
        this.gJa = aiVar;
    }
}
