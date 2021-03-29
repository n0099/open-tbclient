package com.baidu.tieba.homepage.framework;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.e0.c;
import d.b.h0.e0.d;
/* loaded from: classes3.dex */
public class RecommendFrsDelegateStatic extends d.b.h0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public MessageRedDotView f17081a;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c fragmentTabStructure;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
            ((d) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
            if (((d) customResponsedMessage.getData()).b() == null || (fragmentTabStructure = recommendFrsDelegateStatic.getFragmentTabStructure()) == null || fragmentTabStructure.f50155a.isAdded()) {
                return;
            }
            fragmentTabStructure.f50155a.setArguments(new Bundle());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016325 || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            TbFragmentTabIndicator.a d2 = RecommendFrsDelegateStatic.this.mIndicator.d("godFeed");
            if (d2 == null) {
                return;
            }
            if (intValue <= 0) {
                RecommendFrsDelegateStatic.this.f17081a.setVisibility(8);
                return;
            }
            RecommendFrsDelegateStatic.this.f17081a.f(0);
            RecommendFrsDelegateStatic.this.f17081a.setVisibility(0);
            d2.b(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    static {
        a aVar = new a(2007002);
        aVar.setPriority(1);
        MessageManager.getInstance().registerListener(aVar);
    }

    @Override // d.b.h0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f50155a = new RecommendFrsControlFragment();
        cVar.f50159e = 2;
        cVar.f50156b = R.string.home_recommend;
        cVar.f50160f = R.raw.lottie_tab_home;
        cVar.f50162h = c.k;
        return cVar;
    }

    @Override // d.b.h0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.f17081a = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.f13961f = this.mIndicator;
        aVar.f13958c = l.e(context, 12.0f);
        MessageRedDotView messageRedDotView = this.f17081a;
        aVar.f13956a = messageRedDotView;
        messageRedDotView.setVisibility(8);
        this.mIndicator.b("godFeed", aVar);
        return this.mIndicator;
    }

    @Override // d.b.h0.e0.b
    public boolean isAvailable() {
        return true;
    }

    @Override // d.b.h0.e0.b
    public void onAdd() {
        new b(2016325);
    }

    @Override // d.b.h0.e0.b
    public void onRemove() {
        super.onRemove();
    }
}
