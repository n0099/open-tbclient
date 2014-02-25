package com.baidu.tieba.flist;

import com.baidu.tieba.flist.ForumListModel;
/* loaded from: classes.dex */
class i implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        r rVar;
        r rVar2;
        boolean z2;
        boolean z3;
        boolean z4;
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        t tVar;
        ForumListModel.RequestParams requestParams3;
        t tVar2;
        rVar = this.a.D;
        if (!rVar.c()) {
            rVar2 = this.a.E;
            if (!rVar2.c()) {
                z2 = this.a.x;
                if (z2) {
                    requestParams = this.a.A;
                    requestParams.recommend_type = 0;
                    requestParams2 = this.a.A;
                    requestParams2.rn = 200;
                    tVar = this.a.G;
                    requestParams3 = this.a.A;
                    tVar.a(requestParams3);
                    tVar2 = this.a.G;
                    tVar2.LoadData();
                    this.a.x = false;
                } else if (this.a.c.d.getCurrentItem() == 0) {
                    z4 = this.a.B;
                    if (z4) {
                        this.a.n = 50;
                    } else {
                        this.a.n = 200;
                    }
                    com.baidu.adp.lib.util.f.e("ForumListActivity", "pull down", "left refresh");
                    new q(this.a, null).execute(new Void[0]);
                } else if (this.a.c.d.getCurrentItem() == 1) {
                    z3 = this.a.C;
                    if (z3) {
                        this.a.o = 50;
                    } else {
                        this.a.o = 200;
                    }
                    com.baidu.adp.lib.util.f.e("ForumListActivity", "pull down", "right refresh");
                    new p(this.a, null).execute(new Void[0]);
                }
            }
        }
    }
}
