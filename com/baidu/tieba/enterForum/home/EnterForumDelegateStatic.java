package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class EnterForumDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static EnterForumModel bEo;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Fd() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aEf = new f();
        cVar.type = 1;
        cVar.aEg = w.l.home;
        cVar.aEh = w.g.s_tabbar_icon_two_bg;
        return cVar;
    }

    static {
        a aVar = new a(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        aVar.setPriority(2);
        MessageManager.getInstance().registerListener(aVar);
        VM();
        VN();
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aP(Context context) {
        this.aDS = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        return this.aDS;
    }

    private static void VM() {
        bb.wn().a(new b());
    }

    private static void VN() {
        com.baidu.tieba.tbadkCore.d.c.biG();
        if (bEo == null) {
            bEo = new EnterForumModel(null);
            bEo.a(new c());
        }
        MessageManager.getInstance().registerListener(new d(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011));
        MessageManager.getInstance().registerListener(new e(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE));
    }
}
