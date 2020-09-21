package com.baidu.tieba.enterForum.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.enterForum.c.a;
/* loaded from: classes21.dex */
public class RecentlyVisitedForumModel extends BdBaseModel {
    public void a(a.InterfaceC0665a interfaceC0665a) {
        com.baidu.tieba.enterForum.c.a.cis().a(interfaceC0665a);
    }

    public void onPrimary() {
        com.baidu.tieba.enterForum.c.a.cis().onNotify();
        LoadData();
    }

    public void onPause() {
        com.baidu.tieba.enterForum.c.a.cis().civ();
    }

    public void onDestroy() {
        com.baidu.tieba.enterForum.c.a.cis().a((a.InterfaceC0665a) null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        com.baidu.tieba.enterForum.c.a.cis().cit();
        return true;
    }

    public void e(VisitedForumData visitedForumData) {
        com.baidu.tieba.enterForum.c.a.cis().c(visitedForumData);
    }

    public void refresh() {
        com.baidu.tieba.enterForum.c.a.cis().ciw();
    }
}
