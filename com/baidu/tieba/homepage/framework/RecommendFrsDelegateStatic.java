package com.baidu.tieba.homepage.framework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private CustomMessageListener cHA;
    private ImageView cHz;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Ey() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aFj = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.aFk = w.l.home_recommend;
        cVar.aFl = w.g.s_tabbar_icon_one_bg;
        cVar.aFp = com.baidu.tbadk.mainTab.c.aFm;
        return cVar;
    }

    static {
        s sVar = new s(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        sVar.setPriority(1);
        MessageManager.getInstance().registerListener(sVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Ex() {
        this.cHA = new t(this, CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW);
        MessageManager.getInstance().registerListener(this.cHA);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aS(Context context) {
        this.aEW = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.cHz = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aFi = this.aEW;
        aVar.uS = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.cHz;
        aVar.aFg = w.g.icon_news_down_bar_one;
        this.cHz.setVisibility(8);
        this.aEW.a("godFeed", aVar);
        return this.aEW;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.cHA);
    }
}
