package com.baidu.tieba.flist;

import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.util.aq;
/* loaded from: classes.dex */
class i implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1044a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForumListActivity forumListActivity) {
        this.f1044a = forumListActivity;
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
        pVar = this.f1044a.A;
        if (!pVar.c()) {
            pVar2 = this.f1044a.B;
            if (!pVar2.c()) {
                z2 = this.f1044a.w;
                if (z2) {
                    requestParams = this.f1044a.x;
                    requestParams.recommend_type = 0;
                    requestParams2 = this.f1044a.x;
                    requestParams2.rn = 10;
                    tVar = this.f1044a.D;
                    requestParams3 = this.f1044a.x;
                    tVar.a(requestParams3);
                    tVar2 = this.f1044a.D;
                    tVar2.LoadData();
                    this.f1044a.w = false;
                } else if (this.f1044a.c.c.getCurrentItem() == 0) {
                    z4 = this.f1044a.y;
                    if (z4) {
                        this.f1044a.n = 50;
                    } else {
                        this.f1044a.n = 10;
                    }
                    aq.e("ForumListActivity", "pull down", "left refresh");
                    new o(this.f1044a, null).execute(new Void[0]);
                } else if (this.f1044a.c.c.getCurrentItem() == 1) {
                    z3 = this.f1044a.z;
                    if (z3) {
                        this.f1044a.o = 50;
                    } else {
                        this.f1044a.o = 10;
                    }
                    aq.e("ForumListActivity", "pull down", "right refresh");
                    new n(this.f1044a, null).execute(new Void[0]);
                }
            }
        }
    }
}
