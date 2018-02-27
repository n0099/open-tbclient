package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.im.frsgroup.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements BdListView.e, NoNetworkView.a, j.b {
    private String cZI;
    private at dBm;
    private b eEW;
    private String eEZ;
    private an eFa;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<i> dBh = new ArrayList();
    private boolean eEY = true;
    private View.OnClickListener eFb = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.eEY = true;
            c.this.atR();
        }
    };
    private an eFc = new an() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<i> arrayList) {
            if (atVar == null) {
                c.this.eEW.completePullRefresh();
                c.this.eEW.VU();
                return;
            }
            c.this.dBm = atVar;
            if ((c.this.dBm.pn == 0 || c.this.dBm.pn == 1) && c.this.dBm.hasMore && !c.this.dBm.isLocal) {
                c.this.WN();
                return;
            }
            if (arrayList != null) {
                Iterator<i> it = arrayList.iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    if ((next instanceof h) || (next instanceof m)) {
                        it.remove();
                    }
                }
            }
            if (c.this.eFa != null) {
                c.this.eFa.a(i, i2, atVar, arrayList);
            }
            if (v.E(arrayList)) {
                if (c.this.eEY) {
                    c.this.eEW.VU();
                    c.this.eEW.a(c.this.dBm.errMsg, c.this.eFb);
                } else {
                    c.this.eEW.completePullRefresh();
                    c.this.eEW.aBK();
                }
            } else {
                c.this.dBh = arrayList;
                c.this.eEW.bI(c.this.dBh);
                if (v.D(c.this.dBh) != 1 || !(v.f(c.this.dBh, 0) instanceof com.baidu.tieba.im.frsgroup.h)) {
                    if (c.this.dBm.hasMore) {
                        c.this.eEW.aBJ();
                    } else {
                        c.this.eEW.aBL();
                    }
                } else {
                    c.this.eEW.aJm();
                }
                if (c.this.eEY) {
                    c.this.eEW.VU();
                } else {
                    c.this.eEW.completePullRefresh();
                }
            }
            c.this.eEY = false;
        }
    };
    private d eEX = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.eEW = new b(tbPageContext, this);
        this.eEX.setTag(this.pageId);
        this.eEX.init();
        this.eEX.a(this.eFc);
    }

    public void cl(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.eEW != null) {
            this.eEW.ck(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bu(boolean z) {
        if (this.eEW != null) {
            this.eEW.hE(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
        aJo();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.j.oJ()) {
            this.eEW.aBK();
        }
        if (this.dBm != null) {
            if (!this.dBm.hasMore) {
                this.eEW.aBL();
            } else {
                WN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WN() {
        if (this.dBm != null) {
            aq aqVar = new aq();
            aqVar.forumName = this.eEZ;
            aqVar.forumId = this.cZI;
            this.dBm.pn++;
            aqVar.pn = this.dBm.pn;
            this.eEX.a(4, this.mPageType, aqVar);
        }
    }

    private void aJo() {
        aq aqVar = new aq();
        aqVar.forumName = this.eEZ;
        aqVar.forumId = this.cZI;
        aqVar.pn = -1;
        this.eEX.a(4, this.mPageType, aqVar);
    }

    public void e(int i, String str, String str2) {
        this.mPageType = i;
        this.cZI = str;
        this.eEZ = str2;
    }

    public void atR() {
        if (this.eEY) {
            this.eEW.XM();
            this.eEW.VT();
            aJo();
        }
    }

    public View getView() {
        return this.eEW.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.eEW.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.eEX.YZ();
    }

    public void b(an anVar) {
        this.eFa = anVar;
    }
}
