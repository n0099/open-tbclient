package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.im.frsgroup.d;
import com.baidu.tieba.im.frsgroup.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes23.dex */
public class c implements BdListView.e, NoNetworkView.a, f.c {
    private String fkA;
    private bd ikZ;
    private String jOC;
    private av jOD;
    private b jOz;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<q> ikU = new ArrayList();
    private boolean jOB = true;
    private View.OnClickListener jOE = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.jOB = true;
            c.this.cqW();
        }
    };
    private av jOF = new av() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
            if (bdVar == null) {
                c.this.jOz.completePullRefresh();
                c.this.jOz.hideLoadingView();
                return;
            }
            c.this.ikZ = bdVar;
            if ((c.this.ikZ.pn == 0 || c.this.ikZ.pn == 1) && c.this.ikZ.hasMore && !c.this.ikZ.isLocal) {
                c.this.bJG();
                return;
            }
            if (arrayList != null) {
                Iterator<q> it = arrayList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if ((next instanceof n) || (next instanceof s)) {
                        it.remove();
                    }
                }
            }
            if (c.this.jOD != null) {
                c.this.jOD.a(i, i2, bdVar, arrayList);
            }
            if (y.isEmpty(arrayList)) {
                if (c.this.jOB) {
                    c.this.jOz.hideLoadingView();
                    c.this.jOz.d(c.this.ikZ.errMsg, c.this.jOE);
                } else {
                    c.this.jOz.completePullRefresh();
                    c.this.jOz.cCo();
                }
            } else {
                c.this.ikU = arrayList;
                c.this.jOz.dh(c.this.ikU);
                if (y.getCount(c.this.ikU) != 1 || !(y.getItem(c.this.ikU, 0) instanceof h)) {
                    if (c.this.ikZ.hasMore) {
                        c.this.jOz.cCn();
                    } else {
                        c.this.jOz.cCp();
                    }
                } else {
                    c.this.jOz.cMR();
                }
                if (c.this.jOB) {
                    c.this.jOz.hideLoadingView();
                } else {
                    c.this.jOz.completePullRefresh();
                }
            }
            c.this.jOB = false;
        }
    };
    private d jOA = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.jOz = new b(tbPageContext, this);
        this.jOA.setTag(this.pageId);
        this.jOA.init();
        this.jOA.a(this.jOF);
    }

    public void dX(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.jOz != null) {
            this.jOz.dW(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.jOz != null) {
            this.jOz.rx(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cMT();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.jOz.cCo();
        }
        if (this.ikZ != null) {
            if (!this.ikZ.hasMore) {
                this.jOz.cCp();
            } else {
                bJG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJG() {
        if (this.ikZ != null) {
            ba baVar = new ba();
            baVar.forumName = this.jOC;
            baVar.forumId = this.fkA;
            this.ikZ.pn++;
            baVar.pn = this.ikZ.pn;
            this.jOA.a(4, this.mPageType, baVar);
        }
    }

    private void cMT() {
        ba baVar = new ba();
        baVar.forumName = this.jOC;
        baVar.forumId = this.fkA;
        baVar.pn = -1;
        this.jOA.a(4, this.mPageType, baVar);
    }

    public void k(int i, String str, String str2) {
        this.mPageType = i;
        this.fkA = str;
        this.jOC = str2;
    }

    public void cqW() {
        if (this.jOB) {
            this.jOz.SK();
            this.jOz.showLoadingView();
            cMT();
        }
    }

    public View getView() {
        return this.jOz.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.jOz.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.jOA.bQq();
    }

    public void b(av avVar) {
        this.jOD = avVar;
    }
}
