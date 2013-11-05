package com.baidu.tieba.flist;

import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1194a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForumListActivity forumListActivity) {
        this.f1194a = forumListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        q qVar;
        q qVar2;
        boolean z2;
        boolean z3;
        boolean z4;
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        t tVar;
        ForumListModel.RequestParams requestParams3;
        t tVar2;
        qVar = this.f1194a.C;
        if (!qVar.c()) {
            qVar2 = this.f1194a.D;
            if (!qVar2.c()) {
                z2 = this.f1194a.x;
                if (z2) {
                    requestParams = this.f1194a.z;
                    requestParams.recommend_type = 0;
                    requestParams2 = this.f1194a.z;
                    requestParams2.rn = 10;
                    tVar = this.f1194a.F;
                    requestParams3 = this.f1194a.z;
                    tVar.a(requestParams3);
                    tVar2 = this.f1194a.F;
                    tVar2.LoadData();
                    this.f1194a.x = false;
                } else if (this.f1194a.c.c.getCurrentItem() == 0) {
                    z4 = this.f1194a.A;
                    if (z4) {
                        this.f1194a.o = 50;
                    } else {
                        this.f1194a.o = 10;
                    }
                    be.e("ForumListActivity", "pull down", "left refresh");
                    new p(this.f1194a, null).execute(new Void[0]);
                } else if (this.f1194a.c.c.getCurrentItem() == 1) {
                    z3 = this.f1194a.B;
                    if (z3) {
                        this.f1194a.p = 50;
                    } else {
                        this.f1194a.p = 10;
                    }
                    be.e("ForumListActivity", "pull down", "right refresh");
                    new o(this.f1194a, null).execute(new Void[0]);
                }
            }
        }
    }
}
