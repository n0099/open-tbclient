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
import d.a.i0.e0.b;
import d.a.i0.e0.c;
import d.a.i0.e0.d;
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

    @Override // d.a.i0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        HashMap hashMap = new HashMap();
        hashMap.put("tabIndex", Integer.valueOf(d.a.i0.r.a0.b.f48764c));
        FlutterFragment.NewEngineFragmentBuilder newEngineFragmentBuilder = new FlutterFragment.NewEngineFragmentBuilder(TbFlutterFragment.class);
        newEngineFragmentBuilder.params(hashMap);
        newEngineFragmentBuilder.url(OpenFlutter.FRAGMENT_ENTER_FORUM);
        newEngineFragmentBuilder.isTabHost(d.a.i0.r.a0.b.f48763b != 1);
        TbFlutterFragment tbFlutterFragment = (TbFlutterFragment) newEngineFragmentBuilder.build();
        cVar.f48462a = tbFlutterFragment;
        if (d.a.i0.r.a0.b.f48764c == d.a.i0.r.a0.b.f48766e) {
            d.a.i0.r.a0.b.f48764c = d.a.i0.r.a0.b.f48765d;
            tbFlutterFragment.removeSplashDelay(1000L);
            tbFlutterFragment.setAutoPlayWhenInit(true);
        }
        cVar.f48466e = 1;
        Resources b2 = h.a().b();
        cVar.f48463b = b2.getIdentifier("enter_forum", "string", BdBaseApplication.getInst().getPackageName());
        cVar.f48467f = b2.getIdentifier("lottie_tab_forum", "raw", BdBaseApplication.getInst().getPackageName());
        cVar.f48470i = c.m;
        cVar.f48469h = d.a.i0.e0.e.c.d().c("enterForum");
        return cVar;
    }

    @Override // d.a.i0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(h.a().b().getIdentifier("maintab_bottom_indicator", "layout", BdBaseApplication.getInst().getPackageName()), (ViewGroup) null);
        this.tipView = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.f13628f = this.mIndicator;
        aVar.f13625c = l.e(context, 10.0f);
        aVar.f13623a = this.tipView;
        this.mIndicator.b(FileHelper.FILE_CACHE_EMOTION_PACKAGE, aVar);
        boolean g2 = d.a.i0.r.d0.b.j().g("key_feedback_tip_tab_show", false);
        if (!this.isNew.booleanValue() && !g2) {
            this.tipView.setVisibility(8);
        } else {
            this.tipView.f(0);
            this.tipView.setVisibility(0);
        }
        return this.mIndicator;
    }

    @Override // d.a.i0.e0.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_TAB_AVAIBLE;
    }
}
