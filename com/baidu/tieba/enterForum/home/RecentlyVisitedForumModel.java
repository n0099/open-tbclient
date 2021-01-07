package com.baidu.tieba.enterForum.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.enterForum.b.a;
/* loaded from: classes2.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    public void a(a.InterfaceC0721a interfaceC0721a) {
        com.baidu.tieba.enterForum.b.a.cyi().a(interfaceC0721a);
    }

    public void onPrimary() {
        com.baidu.tieba.enterForum.b.a.cyi().onNotify();
        LoadData();
    }

    public void onPause() {
        com.baidu.tieba.enterForum.b.a.cyi().cyl();
    }

    public void onDestroy() {
        com.baidu.tieba.enterForum.b.a.cyi().a((a.InterfaceC0721a) null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        com.baidu.tieba.enterForum.b.a.cyi().cyj();
        return true;
    }

    public void e(VisitedForumData visitedForumData) {
        com.baidu.tieba.enterForum.b.a.cyi().c(visitedForumData);
    }

    public void refresh() {
        com.baidu.tieba.enterForum.b.a.cyi().cym();
    }
}
