package com.baidu.tieba.flist;

import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.util.bg;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForumListActivity forumListActivity) {
        this.f1257a = forumListActivity;
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
        sVar = this.f1257a.D;
        if (!sVar.c()) {
            sVar2 = this.f1257a.E;
            if (!sVar2.c()) {
                z2 = this.f1257a.x;
                if (z2) {
                    requestParams = this.f1257a.A;
                    requestParams.recommend_type = 0;
                    requestParams2 = this.f1257a.A;
                    requestParams2.rn = 200;
                    uVar = this.f1257a.G;
                    requestParams3 = this.f1257a.A;
                    uVar.a(requestParams3);
                    uVar2 = this.f1257a.G;
                    uVar2.LoadData();
                    this.f1257a.x = false;
                } else if (this.f1257a.c.c.getCurrentItem() == 0) {
                    z4 = this.f1257a.B;
                    if (z4) {
                        this.f1257a.n = 50;
                    } else {
                        this.f1257a.n = 200;
                    }
                    bg.e("ForumListActivity", "pull down", "left refresh");
                    new r(this.f1257a, null).execute(new Void[0]);
                } else if (this.f1257a.c.c.getCurrentItem() == 1) {
                    z3 = this.f1257a.C;
                    if (z3) {
                        this.f1257a.o = 50;
                    } else {
                        this.f1257a.o = 200;
                    }
                    bg.e("ForumListActivity", "pull down", "right refresh");
                    new q(this.f1257a, null).execute(new Void[0]);
                }
            }
        }
    }
}
