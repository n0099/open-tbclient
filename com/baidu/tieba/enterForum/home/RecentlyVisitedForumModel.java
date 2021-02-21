package com.baidu.tieba.enterForum.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.enterForum.b.a;
/* loaded from: classes2.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    public void a(a.InterfaceC0705a interfaceC0705a) {
        com.baidu.tieba.enterForum.b.a.cvJ().a(interfaceC0705a);
    }

    public void onPrimary() {
        com.baidu.tieba.enterForum.b.a.cvJ().onNotify();
        LoadData();
    }

    public void onPause() {
        com.baidu.tieba.enterForum.b.a.cvJ().cvM();
    }

    public void onDestroy() {
        com.baidu.tieba.enterForum.b.a.cvJ().a((a.InterfaceC0705a) null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        com.baidu.tieba.enterForum.b.a.cvJ().cvK();
        return true;
    }

    public void e(VisitedForumData visitedForumData) {
        com.baidu.tieba.enterForum.b.a.cvJ().c(visitedForumData);
    }

    public void refresh() {
        com.baidu.tieba.enterForum.b.a.cvJ().cvN();
    }
}
