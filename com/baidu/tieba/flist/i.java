package com.baidu.tieba.flist;

import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tieba.flist.ForumListModel;
/* loaded from: classes.dex */
class i implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ ForumListActivity avP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForumListActivity forumListActivity) {
        this.avP = forumListActivity;
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
        pVar = this.avP.avC;
        if (!pVar.DR()) {
            pVar2 = this.avP.avD;
            if (!pVar2.DR()) {
                z2 = this.avP.avw;
                if (z2) {
                    requestParams = this.avP.avz;
                    requestParams.recommend_type = 0;
                    requestParams2 = this.avP.avz;
                    requestParams2.rn = Constants.MEDIA_INFO;
                    rVar = this.avP.avF;
                    requestParams3 = this.avP.avz;
                    rVar.a(requestParams3);
                    rVar2 = this.avP.avF;
                    rVar2.LoadData();
                    this.avP.avw = false;
                } else if (this.avP.avy.Ct.getCurrentItem() == 0) {
                    z4 = this.avP.avA;
                    if (z4) {
                        this.avP.avo = 50;
                    } else {
                        this.avP.avo = Constants.MEDIA_INFO;
                    }
                    new o(this.avP, null).execute(new Void[0]);
                } else if (this.avP.avy.Ct.getCurrentItem() == 1) {
                    z3 = this.avP.avB;
                    if (z3) {
                        this.avP.avp = 50;
                    } else {
                        this.avP.avp = Constants.MEDIA_INFO;
                    }
                    new n(this.avP, null).execute(new Void[0]);
                }
            }
        }
    }
}
