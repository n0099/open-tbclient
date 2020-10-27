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
    private String fsZ;
    private bd ixx;
    private b kaY;
    private String kbb;
    private av kbc;
    private int mPageType;
    private final BdUniqueId pageId = BdUniqueId.gen();
    private List<q> ixs = new ArrayList();
    private boolean kba = true;
    private View.OnClickListener kbd = new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.kba = true;
            c.this.cud();
        }
    };
    private av kbe = new av() { // from class: com.baidu.tieba.im.frsgroup.view.a.c.2
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
            if (bdVar == null) {
                c.this.kaY.completePullRefresh();
                c.this.kaY.hideLoadingView();
                return;
            }
            c.this.ixx = bdVar;
            if ((c.this.ixx.pn == 0 || c.this.ixx.pn == 1) && c.this.ixx.hasMore && !c.this.ixx.isLocal) {
                c.this.bMi();
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
            if (c.this.kbc != null) {
                c.this.kbc.a(i, i2, bdVar, arrayList);
            }
            if (y.isEmpty(arrayList)) {
                if (c.this.kba) {
                    c.this.kaY.hideLoadingView();
                    c.this.kaY.d(c.this.ixx.errMsg, c.this.kbd);
                } else {
                    c.this.kaY.completePullRefresh();
                    c.this.kaY.cFv();
                }
            } else {
                c.this.ixs = arrayList;
                c.this.kaY.dq(c.this.ixs);
                if (y.getCount(c.this.ixs) != 1 || !(y.getItem(c.this.ixs, 0) instanceof h)) {
                    if (c.this.ixx.hasMore) {
                        c.this.kaY.cFu();
                    } else {
                        c.this.kaY.cFw();
                    }
                } else {
                    c.this.kaY.cPY();
                }
                if (c.this.kba) {
                    c.this.kaY.hideLoadingView();
                } else {
                    c.this.kaY.completePullRefresh();
                }
            }
            c.this.kba = false;
        }
    };
    private d kaZ = new d();

    public c(TbPageContext<?> tbPageContext) {
        this.kaY = new b(tbPageContext, this);
        this.kaZ.setTag(this.pageId);
        this.kaZ.init();
        this.kaZ.a(this.kbe);
    }

    public void eg(List<com.baidu.adp.widget.ListView.a> list) {
        if (this.kaY != null) {
            this.kaY.ef(list);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.kaY != null) {
            this.kaY.rP(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        cQa();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!j.isNetWorkAvailable()) {
            this.kaY.cFv();
        }
        if (this.ixx != null) {
            if (!this.ixx.hasMore) {
                this.kaY.cFw();
            } else {
                bMi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMi() {
        if (this.ixx != null) {
            ba baVar = new ba();
            baVar.forumName = this.kbb;
            baVar.forumId = this.fsZ;
            this.ixx.pn++;
            baVar.pn = this.ixx.pn;
            this.kaZ.a(4, this.mPageType, baVar);
        }
    }

    private void cQa() {
        ba baVar = new ba();
        baVar.forumName = this.kbb;
        baVar.forumId = this.fsZ;
        baVar.pn = -1;
        this.kaZ.a(4, this.mPageType, baVar);
    }

    public void k(int i, String str, String str2) {
        this.mPageType = i;
        this.fsZ = str;
        this.kbb = str2;
    }

    public void cud() {
        if (this.kba) {
            this.kaY.TK();
            this.kaY.showLoadingView();
            cQa();
        }
    }

    public View getView() {
        return this.kaY.getRootView();
    }

    public void onChangeSkinType(int i) {
        this.kaY.onChangeSkinType(i);
    }

    public void onDestroy() {
        this.kaZ.bTn();
    }

    public void b(av avVar) {
        this.kbc = avVar;
    }
}
