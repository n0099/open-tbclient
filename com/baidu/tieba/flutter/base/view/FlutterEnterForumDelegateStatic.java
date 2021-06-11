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
import d.a.m0.e0.b;
import d.a.m0.e0.c;
import d.a.m0.e0.d;
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

    @Override // d.a.m0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        HashMap hashMap = new HashMap();
        hashMap.put("tabIndex", Integer.valueOf(d.a.m0.r.a0.b.f53312c));
        FlutterFragment.NewEngineFragmentBuilder newEngineFragmentBuilder = new FlutterFragment.NewEngineFragmentBuilder(TbFlutterFragment.class);
        newEngineFragmentBuilder.params(hashMap);
        newEngineFragmentBuilder.url(OpenFlutter.FRAGMENT_ENTER_FORUM);
        newEngineFragmentBuilder.isTabHost(d.a.m0.r.a0.b.f53311b != 1);
        TbFlutterFragment tbFlutterFragment = (TbFlutterFragment) newEngineFragmentBuilder.build();
        cVar.f53008a = tbFlutterFragment;
        if (d.a.m0.r.a0.b.f53312c == d.a.m0.r.a0.b.f53314e) {
            d.a.m0.r.a0.b.f53312c = d.a.m0.r.a0.b.f53313d;
            tbFlutterFragment.removeSplashDelay(1000L);
            tbFlutterFragment.setAutoPlayWhenInit(true);
        }
        cVar.f53012e = 1;
        Resources b2 = h.a().b();
        cVar.f53009b = b2.getIdentifier("enter_forum", "string", BdBaseApplication.getInst().getPackageName());
        cVar.f53013f = b2.getIdentifier("lottie_tab_forum", "raw", BdBaseApplication.getInst().getPackageName());
        cVar.f53016i = c.m;
        cVar.f53015h = d.a.m0.e0.e.c.d().c("enterForum");
        return cVar;
    }

    @Override // d.a.m0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(h.a().b().getIdentifier("maintab_bottom_indicator", "layout", BdBaseApplication.getInst().getPackageName()), (ViewGroup) null);
        this.tipView = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.f12937f = this.mIndicator;
        aVar.f12934c = l.e(context, 10.0f);
        aVar.f12932a = this.tipView;
        this.mIndicator.b(FileHelper.FILE_CACHE_EMOTION_PACKAGE, aVar);
        boolean g2 = d.a.m0.r.d0.b.j().g("key_feedback_tip_tab_show", false);
        if (!this.isNew.booleanValue() && !g2) {
            this.tipView.setVisibility(8);
        } else {
            this.tipView.f(0);
            this.tipView.setVisibility(0);
        }
        return this.mIndicator;
    }

    @Override // d.a.m0.e0.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_TAB_AVAIBLE;
    }
}
