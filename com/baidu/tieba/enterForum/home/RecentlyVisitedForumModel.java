package com.baidu.tieba.enterForum.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.enterForum.c.a;
/* loaded from: classes21.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    public void a(a.InterfaceC0716a interfaceC0716a) {
        com.baidu.tieba.enterForum.c.a.cqZ().a(interfaceC0716a);
    }

    public void onPrimary() {
        com.baidu.tieba.enterForum.c.a.cqZ().onNotify();
        LoadData();
    }

    public void onPause() {
        com.baidu.tieba.enterForum.c.a.cqZ().crc();
    }

    public void onDestroy() {
        com.baidu.tieba.enterForum.c.a.cqZ().a((a.InterfaceC0716a) null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        com.baidu.tieba.enterForum.c.a.cqZ().cra();
        return true;
    }

    public void e(VisitedForumData visitedForumData) {
        com.baidu.tieba.enterForum.c.a.cqZ().c(visitedForumData);
    }

    public void refresh() {
        com.baidu.tieba.enterForum.c.a.cqZ().crd();
    }
}
