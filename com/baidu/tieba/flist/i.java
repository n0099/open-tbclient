package com.baidu.tieba.flist;

import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tieba.flist.ForumListModel;
/* loaded from: classes.dex */
class i implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ ForumListActivity avY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForumListActivity forumListActivity) {
        this.avY = forumListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
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
        pVar = this.avY.avL;
        if (!pVar.DT()) {
            pVar2 = this.avY.avM;
            if (!pVar2.DT()) {
                z2 = this.avY.avF;
                if (z2) {
                    requestParams = this.avY.avI;
                    requestParams.recommend_type = 0;
                    requestParams2 = this.avY.avI;
                    requestParams2.rn = Constants.MEDIA_INFO;
                    rVar = this.avY.avO;
                    requestParams3 = this.avY.avI;
                    rVar.a(requestParams3);
                    rVar2 = this.avY.avO;
                    rVar2.LoadData();
                    this.avY.avF = false;
                } else if (this.avY.avH.Cu.getCurrentItem() == 0) {
                    z4 = this.avY.avJ;
                    if (z4) {
                        this.avY.avx = 50;
                    } else {
                        this.avY.avx = Constants.MEDIA_INFO;
                    }
                    new o(this.avY, null).execute(new Void[0]);
                } else if (this.avY.avH.Cu.getCurrentItem() == 1) {
                    z3 = this.avY.avK;
                    if (z3) {
                        this.avY.avy = 50;
                    } else {
                        this.avY.avy = Constants.MEDIA_INFO;
                    }
                    new n(this.avY, null).execute(new Void[0]);
                }
            }
        }
    }
}
