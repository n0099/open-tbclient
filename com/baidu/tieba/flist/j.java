package com.baidu.tieba.flist;

import com.baidu.browser.webpool.BdWebPoolView;
import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.util.bo;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        s sVar;
        s sVar2;
        boolean z2;
        boolean z3;
        boolean z4;
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        u uVar;
        ForumListModel.RequestParams requestParams3;
        u uVar2;
        sVar = this.a.D;
        if (!sVar.c()) {
            sVar2 = this.a.E;
            if (!sVar2.c()) {
                z2 = this.a.x;
                if (z2) {
                    requestParams = this.a.A;
                    requestParams.recommend_type = 0;
                    requestParams2 = this.a.A;
                    requestParams2.rn = BdWebPoolView.DELAYED_TIME;
                    uVar = this.a.G;
                    requestParams3 = this.a.A;
                    uVar.a(requestParams3);
                    uVar2 = this.a.G;
                    uVar2.LoadData();
                    this.a.x = false;
                } else if (this.a.c.d.getCurrentItem() == 0) {
                    z4 = this.a.B;
                    if (z4) {
                        this.a.n = 50;
                    } else {
                        this.a.n = BdWebPoolView.DELAYED_TIME;
                    }
                    bo.e("ForumListActivity", "pull down", "left refresh");
                    new r(this.a, null).execute(new Void[0]);
                } else if (this.a.c.d.getCurrentItem() == 1) {
                    z3 = this.a.C;
                    if (z3) {
                        this.a.o = 50;
                    } else {
                        this.a.o = BdWebPoolView.DELAYED_TIME;
                    }
                    bo.e("ForumListActivity", "pull down", "right refresh");
                    new q(this.a, null).execute(new Void[0]);
                }
            }
        }
    }
}
