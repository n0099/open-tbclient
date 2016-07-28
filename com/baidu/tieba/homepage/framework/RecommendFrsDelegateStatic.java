package com.baidu.tieba.homepage.framework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView cqX;
    private CustomMessageListener cqY;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Dk() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.awB = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.awC = u.j.home_recommend;
        cVar.awD = u.f.s_tabbar_icon_one_bg;
        return cVar;
    }

    static {
        u uVar = new u(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        uVar.setPriority(3);
        MessageManager.getInstance().registerListener(uVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Dj() {
        this.cqY = new v(this, CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW);
        MessageManager.getInstance().registerListener(this.cqY);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ah(Context context) {
        this.awo = (FragmentTabIndicator) LayoutInflater.from(context).inflate(u.h.fragmenttabindicator, (ViewGroup) null);
        this.cqX = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.awA = this.awo;
        aVar.lg = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.cqX;
        aVar.awy = u.f.icon_news_down_bar_one;
        this.cqX.setVisibility(8);
        this.awo.a("godFeed", aVar);
        return this.awo;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ay() {
        super.ay();
        MessageManager.getInstance().unRegisterListener(this.cqY);
    }
}
