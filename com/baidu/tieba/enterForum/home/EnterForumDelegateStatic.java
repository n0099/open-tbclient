package com.baidu.tieba.enterForum.home;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d zK() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.alV = new a();
        dVar.type = 1;
        dVar.alW = y.home;
        dVar.alM = u.icon_tabbar_enterforum;
        return dVar;
    }

    static {
        t tVar = new t(2007002);
        tVar.setPriority(2);
        MessageManager.getInstance().registerListener(tVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator af(Context context) {
        this.alJ = (FragmentTabIndicator) com.baidu.adp.lib.g.b.hH().inflate(context, w.fragmenttabindicator, null);
        return this.alJ;
    }
}
