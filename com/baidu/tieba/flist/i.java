package com.baidu.tieba.flist;

import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tieba.flist.ForumListModel;
/* loaded from: classes.dex */
class i implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        p pVar;
        p pVar2;
        boolean z2;
        boolean z3;
        boolean z4;
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        r rVar;
        ForumListModel.RequestParams requestParams3;
        r rVar2;
        pVar = this.a.A;
        if (!pVar.c()) {
            pVar2 = this.a.B;
            if (!pVar2.c()) {
                z2 = this.a.v;
                if (z2) {
                    requestParams = this.a.x;
                    requestParams.recommend_type = 0;
                    requestParams2 = this.a.x;
                    requestParams2.rn = Constants.MEDIA_INFO;
                    rVar = this.a.D;
                    requestParams3 = this.a.x;
                    rVar.a(requestParams3);
                    rVar2 = this.a.D;
                    rVar2.LoadData();
                    this.a.v = false;
                } else if (this.a.c.d.getCurrentItem() == 0) {
                    z4 = this.a.y;
                    if (z4) {
                        this.a.m = 50;
                    } else {
                        this.a.m = Constants.MEDIA_INFO;
                    }
                    new o(this.a, null).execute(new Void[0]);
                } else if (this.a.c.d.getCurrentItem() == 1) {
                    z3 = this.a.z;
                    if (z3) {
                        this.a.n = 50;
                    } else {
                        this.a.n = Constants.MEDIA_INFO;
                    }
                    new n(this.a, null).execute(new Void[0]);
                }
            }
        }
    }
}
