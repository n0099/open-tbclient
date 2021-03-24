package com.baidu.tieba.enterForum.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.data.VisitedForumData;
import d.b.i0.i0.g.a;
/* loaded from: classes4.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        a.l().n();
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        a.l().w(null);
    }

    public void onPause() {
        a.l().y();
    }

    public void s(VisitedForumData visitedForumData) {
        a.l().i(visitedForumData);
    }

    public void t() {
        a.l().r();
        LoadData();
    }

    public void u() {
        a.l().o();
    }

    public void v(a.f fVar) {
        a.l().w(fVar);
    }
}
