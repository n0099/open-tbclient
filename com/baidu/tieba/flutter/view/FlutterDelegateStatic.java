package com.baidu.tieba.flutter.view;

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
import com.baidu.tieba.flutter.util.OpenFlutter;
import com.idlefish.flutterboost.containers.FlutterFragment;
import d.b.b.a.h;
import d.b.b.e.p.l;
import d.b.h0.e0.a;
import d.b.h0.e0.b;
import d.b.h0.e0.c;
import d.b.h0.e0.d;
/* loaded from: classes4.dex */
public class FlutterDelegateStatic extends b {
    public static final int PERSON_INFO_TAB_MIDDLE_REDDOT_DISTANCE = 10;
    public static boolean isInited = true;
    public Boolean isNew = Boolean.FALSE;
    public CustomMessageListener maintabEmotionListener;
    public MessageRedDotView tipView;

    public static void registerFlutterFragment() {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.flutter.view.FlutterDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null || !FlutterMyTabEnableSwitch.isOn()) {
                    return;
                }
                FlutterDelegateStatic flutterDelegateStatic = new FlutterDelegateStatic();
                ((d) customResponsedMessage.getData()).a(flutterDelegateStatic);
                if (((d) customResponsedMessage.getData()).b() == null || flutterDelegateStatic.getFragmentTabStructure() == null) {
                }
            }
        };
        customMessageListener.setPriority(8);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // d.b.h0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        FlutterFragment.NewEngineFragmentBuilder newEngineFragmentBuilder = new FlutterFragment.NewEngineFragmentBuilder(TbFlutterFragment.class);
        newEngineFragmentBuilder.url(OpenFlutter.FRAGMENT_MYTAB);
        newEngineFragmentBuilder.isTabHost(true);
        cVar.f50154a = newEngineFragmentBuilder.build();
        isInited = false;
        cVar.f50158e = 8;
        Resources b2 = h.a().b();
        cVar.f50155b = b2.getIdentifier("mine", "string", BdBaseApplication.getInst().getPackageName());
        cVar.f50159f = b2.getIdentifier("lottie_tab_my", "raw", BdBaseApplication.getInst().getPackageName());
        cVar.f50161h = c.l;
        return cVar;
    }

    @Override // d.b.h0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(h.a().b().getIdentifier("maintab_bottom_indicator", "layout", BdBaseApplication.getInst().getPackageName()), (ViewGroup) null);
        this.tipView = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.f13960f = this.mIndicator;
        aVar.f13957c = l.e(context, 10.0f);
        aVar.f13955a = this.tipView;
        this.mIndicator.b(FileHelper.FILE_CACHE_EMOTION_PACKAGE, aVar);
        boolean g2 = d.b.h0.r.d0.b.i().g("key_feedback_tip_tab_show", false);
        if (!this.isNew.booleanValue() && !g2) {
            this.tipView.setVisibility(8);
        } else {
            this.tipView.f(0);
            this.tipView.setVisibility(0);
        }
        return this.mIndicator;
    }

    @Override // d.b.h0.e0.b
    public boolean isAvailable() {
        return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
    }

    @Override // d.b.h0.e0.b
    public void onAdd() {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007014) { // from class: com.baidu.tieba.flutter.view.FlutterDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007014 || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof a)) {
                    return;
                }
                FlutterDelegateStatic.this.isNew = Boolean.valueOf(((a) customResponsedMessage.getData()).f50153a);
                if (FlutterDelegateStatic.this.isNew.booleanValue()) {
                    FlutterDelegateStatic.this.tipView.f(0);
                    FlutterDelegateStatic.this.tipView.setVisibility(0);
                    return;
                }
                FlutterDelegateStatic.this.tipView.setVisibility(8);
            }
        };
        this.maintabEmotionListener = customMessageListener;
        customMessageListener.setPriority(8);
        MessageManager.getInstance().registerListener(this.maintabEmotionListener);
    }

    @Override // d.b.h0.e0.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.maintabEmotionListener);
    }
}
