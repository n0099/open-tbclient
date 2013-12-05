package com.baidu.tieba.flist;

import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.util.bd;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1304a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForumListActivity forumListActivity) {
        this.f1304a = forumListActivity;
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
        sVar = this.f1304a.D;
        if (!sVar.c()) {
            sVar2 = this.f1304a.E;
            if (!sVar2.c()) {
                z2 = this.f1304a.x;
                if (z2) {
                    requestParams = this.f1304a.A;
                    requestParams.recommend_type = 0;
                    requestParams2 = this.f1304a.A;
                    requestParams2.rn = 200;
                    uVar = this.f1304a.G;
                    requestParams3 = this.f1304a.A;
                    uVar.a(requestParams3);
                    uVar2 = this.f1304a.G;
                    uVar2.LoadData();
                    this.f1304a.x = false;
                } else if (this.f1304a.c.d.getCurrentItem() == 0) {
                    z4 = this.f1304a.B;
                    if (z4) {
                        this.f1304a.n = 50;
                    } else {
                        this.f1304a.n = 200;
                    }
                    bd.e("ForumListActivity", "pull down", "left refresh");
                    new r(this.f1304a, null).execute(new Void[0]);
                } else if (this.f1304a.c.d.getCurrentItem() == 1) {
                    z3 = this.f1304a.C;
                    if (z3) {
                        this.f1304a.o = 50;
                    } else {
                        this.f1304a.o = 200;
                    }
                    bd.e("ForumListActivity", "pull down", "right refresh");
                    new q(this.f1304a, null).execute(new Void[0]);
                }
            }
        }
    }
}
