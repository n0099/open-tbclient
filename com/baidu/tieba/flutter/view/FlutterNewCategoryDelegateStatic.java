package com.baidu.tieba.flutter.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.flutter.util.OpenFlutter;
import com.idlefish.flutterboost.containers.FlutterFragment;
import d.b.b.a.h;
import d.b.b.e.m.e;
import d.b.h0.e0.b;
import d.b.h0.e0.c;
import d.b.h0.e0.d;
import d.b.h0.s.c.l;
/* loaded from: classes4.dex */
public class FlutterNewCategoryDelegateStatic extends b {
    public Boolean isNew = Boolean.FALSE;
    public CustomMessageListener mChannelDataGetListener = new CustomMessageListener(2921493) { // from class: com.baidu.tieba.flutter.view.FlutterNewCategoryDelegateStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FlutterNewCategoryDelegateStatic.this.loadStatus();
        }
    };
    public l mFinalData;
    public CustomMessageListener maintabEmotionListener;
    public MessageRedDotView tipView;

    public FlutterNewCategoryDelegateStatic() {
        MessageManager.getInstance().registerListener(this.mChannelDataGetListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadStatus() {
        l c2 = TbSingleton.getInstance().getChannelConfigModel().c();
        this.mFinalData = c2;
        if (c2 == null) {
            return;
        }
        if (c2.a() == l.f51192h) {
            if (!TextUtils.isEmpty(this.mFinalData.b())) {
                final c cVar = new c();
                cVar.f50160g = this.mFinalData.b();
                cVar.f50158e = 21;
                if (!TextUtils.isEmpty(this.mFinalData.c())) {
                    cVar.f50156c = this.mFinalData.c();
                }
                e.a().postDelayed(new Runnable() { // from class: com.baidu.tieba.flutter.view.FlutterNewCategoryDelegateStatic.4
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, cVar));
                    }
                }, 2000L);
            }
            TbSingleton.getInstance().getChannelConfigModel().d(l.f51192h);
        } else if (this.mFinalData.a() == l.f51191g) {
            MessageRedDotView messageRedDotView = this.tipView;
            if (messageRedDotView != null) {
                messageRedDotView.setVisibility(0);
            }
            TbSingleton.getInstance().getChannelConfigModel().d(l.f51191g);
        } else {
            MessageRedDotView messageRedDotView2 = this.tipView;
            if (messageRedDotView2 != null) {
                messageRedDotView2.setVisibility(8);
            }
        }
    }

    public static void registerChannelNetwork() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG, TbConfig.SERVER_ADDRESS + TbConfig.GET_CHANNEL_ADDRESS);
        tbHttpMessageTask.setResponsedClass(ChannelConfigResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void registerFlutterFragment() {
        registerChannelNetwork();
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.flutter.view.FlutterNewCategoryDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                    return;
                }
                FlutterNewCategoryDelegateStatic flutterNewCategoryDelegateStatic = new FlutterNewCategoryDelegateStatic();
                ((d) customResponsedMessage.getData()).a(flutterNewCategoryDelegateStatic);
                flutterNewCategoryDelegateStatic.loadStatus();
            }
        };
        customMessageListener.setPriority(6);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // d.b.h0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        FlutterFragment.NewEngineFragmentBuilder newEngineFragmentBuilder = new FlutterFragment.NewEngineFragmentBuilder(TbFlutterFragment.class);
        newEngineFragmentBuilder.url(OpenFlutter.FRAGMENT_NEWCATEGORY);
        newEngineFragmentBuilder.isTabHost(true);
        FlutterFragment build = newEngineFragmentBuilder.build();
        cVar.f50154a = build;
        cVar.f50158e = 21;
        ((TbFlutterFragment) build).setOnPrimaryListener(new TbFlutterFragmentLifeCircleInterface() { // from class: com.baidu.tieba.flutter.view.FlutterNewCategoryDelegateStatic.3
            @Override // com.baidu.tieba.flutter.view.TbFlutterFragmentLifeCircleInterface
            public void onPrimary() {
                FlutterNewCategoryDelegateStatic.this.tipView.setVisibility(8);
            }
        });
        Resources b2 = h.a().b();
        cVar.f50155b = b2.getIdentifier("new_category", "string", BdBaseApplication.getInst().getPackageName());
        cVar.f50159f = b2.getIdentifier("lottie_tab_category", "raw", BdBaseApplication.getInst().getPackageName());
        cVar.f50161h = c.k;
        return cVar;
    }

    @Override // d.b.h0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(h.a().b().getIdentifier("maintab_bottom_indicator", "layout", BdBaseApplication.getInst().getPackageName()), (ViewGroup) null);
        this.tipView = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.f13960f = this.mIndicator;
        aVar.f13957c = d.b.b.e.p.l.e(context, 10.0f);
        aVar.f13955a = this.tipView;
        this.mIndicator.b(FileHelper.FILE_CACHE_EMOTION_PACKAGE, aVar);
        this.tipView.f(0);
        l lVar = this.mFinalData;
        if (lVar != null) {
            if (lVar.a() == l.f51191g) {
                this.tipView.setVisibility(0);
            } else {
                this.tipView.setVisibility(8);
            }
        } else {
            this.tipView.setVisibility(8);
        }
        return this.mIndicator;
    }

    @Override // d.b.h0.e0.b
    public boolean isAvailable() {
        return MainTabActivityConfig.NEW_CATEGORY_TAB_AVAIBLE;
    }
}
