package com.baidu.tieba.enterForum.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.enterForum.b.a;
/* loaded from: classes2.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    public void a(a.InterfaceC0711a interfaceC0711a) {
        com.baidu.tieba.enterForum.b.a.cvP().a(interfaceC0711a);
    }

    public void onPrimary() {
        com.baidu.tieba.enterForum.b.a.cvP().onNotify();
        LoadData();
    }

    public void onPause() {
        com.baidu.tieba.enterForum.b.a.cvP().cvS();
    }

    public void onDestroy() {
        com.baidu.tieba.enterForum.b.a.cvP().a((a.InterfaceC0711a) null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        com.baidu.tieba.enterForum.b.a.cvP().cvQ();
        return true;
    }

    public void e(VisitedForumData visitedForumData) {
        com.baidu.tieba.enterForum.b.a.cvP().c(visitedForumData);
    }

    public void refresh() {
        com.baidu.tieba.enterForum.b.a.cvP().cvT();
    }
}
