package com.baidu.tieba.flist;

import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.util.av;
/* loaded from: classes.dex */
class i implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1061a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForumListActivity forumListActivity) {
        this.f1061a = forumListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        p pVar;
        p pVar2;
        boolean z2;
        boolean z3;
        boolean z4;
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        t tVar;
        ForumListModel.RequestParams requestParams3;
        t tVar2;
        pVar = this.f1061a.C;
        if (!pVar.c()) {
            pVar2 = this.f1061a.D;
            if (!pVar2.c()) {
                z2 = this.f1061a.x;
                if (z2) {
                    requestParams = this.f1061a.z;
                    requestParams.recommend_type = 0;
                    requestParams2 = this.f1061a.z;
                    requestParams2.rn = 10;
                    tVar = this.f1061a.F;
                    requestParams3 = this.f1061a.z;
                    tVar.a(requestParams3);
                    tVar2 = this.f1061a.F;
                    tVar2.LoadData();
                    this.f1061a.x = false;
                } else if (this.f1061a.c.c.getCurrentItem() == 0) {
                    z4 = this.f1061a.A;
                    if (z4) {
                        this.f1061a.o = 50;
                    } else {
                        this.f1061a.o = 10;
                    }
                    av.e("ForumListActivity", "pull down", "left refresh");
                    new o(this.f1061a, null).execute(new Void[0]);
                } else if (this.f1061a.c.c.getCurrentItem() == 1) {
                    z3 = this.f1061a.B;
                    if (z3) {
                        this.f1061a.p = 50;
                    } else {
                        this.f1061a.p = 10;
                    }
                    av.e("ForumListActivity", "pull down", "right refresh");
                    new n(this.f1061a, null).execute(new Void[0]);
                }
            }
        }
    }
}
