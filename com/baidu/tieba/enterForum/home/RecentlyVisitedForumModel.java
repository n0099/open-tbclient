package com.baidu.tieba.enterForum.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.enterForum.c.a;
/* loaded from: classes16.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    public void a(a.InterfaceC0668a interfaceC0668a) {
        com.baidu.tieba.enterForum.c.a.cfd().a(interfaceC0668a);
    }

    public void onPrimary() {
        com.baidu.tieba.enterForum.c.a.cfd().onNotify();
        LoadData();
    }

    public void onPause() {
        com.baidu.tieba.enterForum.c.a.cfd().cfg();
    }

    public void onDestroy() {
        com.baidu.tieba.enterForum.c.a.cfd().a((a.InterfaceC0668a) null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        com.baidu.tieba.enterForum.c.a.cfd().cfe();
        return true;
    }

    public void e(VisitedForumData visitedForumData) {
        com.baidu.tieba.enterForum.c.a.cfd().c(visitedForumData);
    }

    public void refresh() {
        com.baidu.tieba.enterForum.c.a.cfd().cfh();
    }
}
