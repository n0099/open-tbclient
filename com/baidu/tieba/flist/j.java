package com.baidu.tieba.flist;

import com.baidu.tieba.flist.ForumListModel;
import com.baidu.tieba.util.bg;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1252a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForumListActivity forumListActivity) {
        this.f1252a = forumListActivity;
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
        sVar = this.f1252a.D;
        if (!sVar.c()) {
            sVar2 = this.f1252a.E;
            if (!sVar2.c()) {
                z2 = this.f1252a.x;
                if (z2) {
                    requestParams = this.f1252a.A;
                    requestParams.recommend_type = 0;
                    requestParams2 = this.f1252a.A;
                    requestParams2.rn = 200;
                    uVar = this.f1252a.G;
                    requestParams3 = this.f1252a.A;
                    uVar.a(requestParams3);
                    uVar2 = this.f1252a.G;
                    uVar2.LoadData();
                    this.f1252a.x = false;
                } else if (this.f1252a.c.c.getCurrentItem() == 0) {
                    z4 = this.f1252a.B;
                    if (z4) {
                        this.f1252a.n = 50;
                    } else {
                        this.f1252a.n = 200;
                    }
                    bg.e("ForumListActivity", "pull down", "left refresh");
                    new r(this.f1252a, null).execute(new Void[0]);
                } else if (this.f1252a.c.c.getCurrentItem() == 1) {
                    z3 = this.f1252a.C;
                    if (z3) {
                        this.f1252a.o = 50;
                    } else {
                        this.f1252a.o = 200;
                    }
                    bg.e("ForumListActivity", "pull down", "right refresh");
                    new q(this.f1252a, null).execute(new Void[0]);
                }
            }
        }
    }
}
