package com.baidu.tieba.flutter.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.switchs.FlutterMyTabEnableSwitch;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.idlefish.flutterboost.containers.FlutterFragment;
import d.a.c.a.h;
import d.a.c.e.p.l;
import d.a.n0.e0.b;
import d.a.n0.e0.c;
import d.a.n0.e0.d;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class FlutterEnterForumDelegateStatic extends b {
    public static final int PERSON_INFO_TAB_MIDDLE_REDDOT_DISTANCE = 10;
    public Boolean isNew = Boolean.FALSE;
    public MessageRedDotView tipView;

    public static void registerFlutterFragment() {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.flutter.base.view.FlutterEnterForumDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null || !FlutterMyTabEnableSwitch.isOn()) {
                    return;
                }
                FlutterEnterForumDelegateStatic flutterEnterForumDelegateStatic = new FlutterEnterForumDelegateStatic();
                ((d) customResponsedMessage.getData()).a(flutterEnterForumDelegateStatic);
                if (((d) customResponsedMessage.getData()).b() == null || flutterEnterForumDelegateStatic.getFragmentTabStructure() == null) {
                }
            }
        };
        customMessageListener.setPriority(2);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // d.a.n0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        HashMap hashMap = new HashMap();
        hashMap.put("tabIndex", Integer.valueOf(d.a.n0.r.a0.b.f53419c));
        FlutterFragment.NewEngineFragmentBuilder newEngineFragmentBuilder = new FlutterFragment.NewEngineFragmentBuilder(TbFlutterFragment.class);
        newEngineFragmentBuilder.params(hashMap);
        newEngineFragmentBuilder.url(OpenFlutter.FRAGMENT_ENTER_FORUM);
        newEngineFragmentBuilder.isTabHost(d.a.n0.r.a0.b.f53418b != 1);
        TbFlutterFragment tbFlutterFragment = (TbFlutterFragment) newEngineFragmentBuilder.build();
        cVar.f53115a = tbFlutterFragment;
        if (d.a.n0.r.a0.b.f53419c == d.a.n0.r.a0.b.f53421e) {
            d.a.n0.r.a0.b.f53419c = d.a.n0.r.a0.b.f53420d;
            tbFlutterFragment.removeSplashDelay(1000L);
            tbFlutterFragment.setAutoPlayWhenInit(true);
        }
        cVar.f53119e = 1;
        Resources b2 = h.a().b();
        cVar.f53116b = b2.getIdentifier("enter_forum", "string", BdBaseApplication.getInst().getPackageName());
        cVar.f53120f = b2.getIdentifier("lottie_tab_forum", "raw", BdBaseApplication.getInst().getPackageName());
        cVar.f53123i = c.m;
        cVar.f53122h = d.a.n0.e0.e.c.d().c("enterForum");
        return cVar;
    }

    @Override // d.a.n0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(h.a().b().getIdentifier("maintab_bottom_indicator", "layout", BdBaseApplication.getInst().getPackageName()), (ViewGroup) null);
        this.tipView = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.f13019f = this.mIndicator;
        aVar.f13016c = l.e(context, 10.0f);
        aVar.f13014a = this.tipView;
        this.mIndicator.b(FileHelper.FILE_CACHE_EMOTION_PACKAGE, aVar);
        boolean g2 = d.a.n0.r.d0.b.j().g("key_feedback_tip_tab_show", false);
        if (!this.isNew.booleanValue() && !g2) {
            this.tipView.setVisibility(8);
        } else {
            this.tipView.f(0);
            this.tipView.setVisibility(0);
        }
        return this.mIndicator;
    }

    @Override // d.a.n0.e0.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_TAB_AVAIBLE;
    }
}
