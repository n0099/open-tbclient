package com.baidu.tieba.enterForum.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.enterForum.c.a;
/* loaded from: classes22.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    public void a(a.InterfaceC0713a interfaceC0713a) {
        com.baidu.tieba.enterForum.c.a.crw().a(interfaceC0713a);
    }

    public void onPrimary() {
        com.baidu.tieba.enterForum.c.a.crw().onNotify();
        LoadData();
    }

    public void onPause() {
        com.baidu.tieba.enterForum.c.a.crw().crz();
    }

    public void onDestroy() {
        com.baidu.tieba.enterForum.c.a.crw().a((a.InterfaceC0713a) null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        com.baidu.tieba.enterForum.c.a.crw().crx();
        return true;
    }

    public void e(VisitedForumData visitedForumData) {
        com.baidu.tieba.enterForum.c.a.crw().c(visitedForumData);
    }

    public void refresh() {
        com.baidu.tieba.enterForum.c.a.crw().crA();
    }
}
