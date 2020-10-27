package com.baidu.tieba.enterForum.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.enterForum.c.a;
/* loaded from: classes22.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    public void a(a.InterfaceC0699a interfaceC0699a) {
        com.baidu.tieba.enterForum.c.a.coV().a(interfaceC0699a);
    }

    public void onPrimary() {
        com.baidu.tieba.enterForum.c.a.coV().onNotify();
        LoadData();
    }

    public void onPause() {
        com.baidu.tieba.enterForum.c.a.coV().coY();
    }

    public void onDestroy() {
        com.baidu.tieba.enterForum.c.a.coV().a((a.InterfaceC0699a) null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        com.baidu.tieba.enterForum.c.a.coV().coW();
        return true;
    }

    public void e(VisitedForumData visitedForumData) {
        com.baidu.tieba.enterForum.c.a.coV().c(visitedForumData);
    }

    public void refresh() {
        com.baidu.tieba.enterForum.c.a.coV().coZ();
    }
}
