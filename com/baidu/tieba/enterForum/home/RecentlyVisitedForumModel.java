package com.baidu.tieba.enterForum.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.data.VisitedForumData;
import d.a.o0.j0.g.a;
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

    public void refresh() {
        a.l().o();
    }

    public void w(VisitedForumData visitedForumData) {
        a.l().i(visitedForumData);
    }

    public void x() {
        a.l().r();
        LoadData();
    }

    public void y(a.f fVar) {
        a.l().w(fVar);
    }
}
