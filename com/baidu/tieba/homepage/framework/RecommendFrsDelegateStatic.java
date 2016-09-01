package com.baidu.tieba.homepage.framework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView cCf;
    private CustomMessageListener cCg;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EE() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.azI = new RecommendFrsControlFragment();
        cVar.type = 2;
        cVar.azJ = t.j.home_recommend;
        cVar.azK = t.f.s_tabbar_icon_one_bg;
        return cVar;
    }

    static {
        u uVar = new u(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        uVar.setPriority(3);
        MessageManager.getInstance().registerListener(uVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ED() {
        this.cCg = new v(this, CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW);
        MessageManager.getInstance().registerListener(this.cCg);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ar(Context context) {
        this.azv = (FragmentTabIndicator) LayoutInflater.from(context).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        this.cCf = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.azH = this.azv;
        aVar.nB = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.cCf;
        aVar.azF = t.f.icon_news_down_bar_one;
        this.cCf.setVisibility(8);
        this.azv.a("godFeed", aVar);
        return this.azv;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void bt() {
        super.bt();
        MessageManager.getInstance().unRegisterListener(this.cCg);
    }
}
