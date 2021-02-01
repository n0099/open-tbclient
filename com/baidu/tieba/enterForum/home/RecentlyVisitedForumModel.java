package com.baidu.tieba.enterForum.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.enterForum.b.a;
/* loaded from: classes2.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    public void a(a.InterfaceC0704a interfaceC0704a) {
        com.baidu.tieba.enterForum.b.a.cvC().a(interfaceC0704a);
    }

    public void onPrimary() {
        com.baidu.tieba.enterForum.b.a.cvC().onNotify();
        LoadData();
    }

    public void onPause() {
        com.baidu.tieba.enterForum.b.a.cvC().cvF();
    }

    public void onDestroy() {
        com.baidu.tieba.enterForum.b.a.cvC().a((a.InterfaceC0704a) null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        com.baidu.tieba.enterForum.b.a.cvC().cvD();
        return true;
    }

    public void e(VisitedForumData visitedForumData) {
        com.baidu.tieba.enterForum.b.a.cvC().c(visitedForumData);
    }

    public void refresh() {
        com.baidu.tieba.enterForum.b.a.cvC().cvG();
    }
}
