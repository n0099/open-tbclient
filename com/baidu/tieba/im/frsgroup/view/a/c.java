package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.im.frsgroup.d;
import com.baidu.tieba.im.frsgroup.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements BdListView.e, NoNetworkView.a, f.c {
    private String evm;
    private av hjL;
    private b iCE;
    private String iCH;
    private ao iCI;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<o> hjG = new ArrayList();
    private boolean iCG = true;
    private View.OnClickListener iCJ = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.iCG = true;
            c.this.bTy();
        }
    };
    private ao iCK = new ao() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<o> arrayList) {
            if (avVar == null) {
                c.this.iCE.completePullRefresh();
                c.this.iCE.hideLoadingView();
                return;
            }
            c.this.hjL = avVar;
            if ((c.this.hjL.pn == 0 || c.this.hjL.pn == 1) && c.this.hjL.hasMore && !c.this.hjL.isLocal) {
                c.this.bqx();
                return;
            }
            if (arrayList != null) {
                Iterator<o> it = arrayList.iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    if ((next instanceof k) || (next instanceof p)) {
                        it.remove();
                    }
                }
            }
            if (c.this.iCI != null) {
                c.this.iCI.a(i, i2, avVar, arrayList);
            }
            if (v.isEmpty(arrayList)) {
                if (c.this.iCG) {
                    c.this.iCE.hideLoadingView();
                    c.this.iCE.a(c.this.hjL.errMsg, c.this.iCJ);
                } else {
                    c.this.iCE.completePullRefresh();
                    c.this.iCE.cdW();
                }
            } else {
                c.this.hjG = arrayList;
                c.this.iCE.cI(c.this.hjG);
                if (v.getCount(c.this.hjG) != 1 || !(v.getItem(c.this.hjG, 0) instanceof h)) {
                    if (c.this.hjL.hasMore) {
                        c.this.iCE.cdV();
                    } else {
                        c.this.iCE.cdX();
                    }
                } else {
                    c.this.iCE.cmW();
                }
                if (c.this.iCG) {
                    c.this.iCE.hideLoadingView();
                } else {
                    c.this.iCE.completePullRefresh();
                }
            }
            c.this.iCG = false;
        }
    };
    private d iCF = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.iCE = new b(tbPageContext, this);
        this.iCF.setTag(this.pageId);
        this.iCF.init();
        this.iCF.a(this.iCK);
    }

    public void dk(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.iCE != null) {
            this.iCE.dj(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iCE != null) {
            this.iCE.pk(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cmY();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.iCE.cdW();
        }
        if (this.hjL != null) {
            if (!this.hjL.hasMore) {
                this.iCE.cdX();
            } else {
                bqx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqx() {
        if (this.hjL != null) {
            as asVar = new as();
            asVar.forumName = this.iCH;
            asVar.forumId = this.evm;
            this.hjL.pn++;
            asVar.pn = this.hjL.pn;
            this.iCF.a(4, this.mPageType, asVar);
        }
    }

    private void cmY() {
        as asVar = new as();
        asVar.forumName = this.iCH;
        asVar.forumId = this.evm;
        asVar.pn = -1;
        this.iCF.a(4, this.mPageType, asVar);
    }

    public void j(int i, String str, String str2) {
        this.mPageType = i;
        this.evm = str;
        this.iCH = str2;
    }

    public void bTy() {
        if (this.iCG) {
            this.iCE.bqQ();
            this.iCE.showLoadingView();
            cmY();
        }
    }

    public View getView() {
        return this.iCE.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.iCE.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.iCF.bwk();
    }

    public void b(ao aoVar) {
        this.iCI = aoVar;
    }
}
