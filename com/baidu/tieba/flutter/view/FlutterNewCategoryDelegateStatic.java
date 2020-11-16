package com.baidu.tieba.flutter.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.flutter.util.OpenFlutter;
import com.idlefish.flutterboost.containers.FlutterFragment;
/* loaded from: classes24.dex */
public class FlutterNewCategoryDelegateStatic extends b {
    private Boolean isNew = false;
    private CustomMessageListener mChannelDataGetListener = new CustomMessageListener(2921493) { // from class: com.baidu.tieba.flutter.view.FlutterNewCategoryDelegateStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FlutterNewCategoryDelegateStatic.this.loadStatus();
        }
    };
    l mFinalData;
    private CustomMessageListener maintabEmotionListener;
    private MessageRedDotView tipView;

    public FlutterNewCategoryDelegateStatic() {
        MessageManager.getInstance().registerListener(this.mChannelDataGetListener);
    }

    private static void registerChannelNetwork() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG, TbConfig.SERVER_ADDRESS + TbConfig.GET_CHANNEL_ADDRESS);
        tbHttpMessageTask.setResponsedClass(ChannelConfigResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void registerFlutterFragment() {
        registerChannelNetwork();
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.flutter.view.FlutterNewCategoryDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    FlutterNewCategoryDelegateStatic flutterNewCategoryDelegateStatic = new FlutterNewCategoryDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(flutterNewCategoryDelegateStatic);
                    flutterNewCategoryDelegateStatic.loadStatus();
                }
            }
        };
        customMessageListener.setPriority(6);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.NEW_CATEGORY_TAB_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.frag = new FlutterFragment.NewEngineFragmentBuilder(TbFlutterFragment.class).url(OpenFlutter.FRAGMENT_NEWCATEGORY).isTabHost(true).build();
        cVar.type = 21;
        ((TbFlutterFragment) cVar.frag).setOnPrimaryListener(new TbFlutterFragmentLifeCircleInterface() { // from class: com.baidu.tieba.flutter.view.FlutterNewCategoryDelegateStatic.3
            @Override // com.baidu.tieba.flutter.view.TbFlutterFragmentLifeCircleInterface
            public void onPrimary() {
                FlutterNewCategoryDelegateStatic.this.tipView.setVisibility(8);
            }
        });
        Resources resources = g.li().getResources();
        cVar.textResId = resources.getIdentifier("new_category", "string", BdBaseApplication.getInst().getPackageName());
        cVar.animationResId = resources.getIdentifier("lottie_tab_category", "raw", BdBaseApplication.getInst().getPackageName());
        cVar.showIconType = c.SHOWBOTH;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(g.li().getResources().getIdentifier("maintab_bottom_indicator", "layout", BdBaseApplication.getInst().getPackageName()), (ViewGroup) null);
        this.tipView = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.fsw = this.mIndicator;
        aVar.offsetX = com.baidu.adp.lib.util.l.dip2px(context, 10.0f);
        aVar.view = this.tipView;
        this.mIndicator.b("emotion", aVar);
        this.tipView.refresh(0);
        if (this.mFinalData != null) {
            if (this.mFinalData.btT() == l.fbN) {
                this.tipView.setVisibility(0);
            } else {
                this.tipView.setVisibility(8);
            }
        } else {
            this.tipView.setVisibility(8);
        }
        return this.mIndicator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadStatus() {
        this.mFinalData = TbSingleton.getInstance().getChannelConfigModel().bwk();
        if (this.mFinalData != null) {
            if (this.mFinalData.btT() == l.fbO) {
                if (!TextUtils.isEmpty(this.mFinalData.getIcon())) {
                    final c cVar = new c();
                    cVar.fsd = this.mFinalData.getIcon();
                    cVar.type = 21;
                    if (!TextUtils.isEmpty(this.mFinalData.getPopText())) {
                        cVar.text = this.mFinalData.getPopText();
                    }
                    e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.flutter.view.FlutterNewCategoryDelegateStatic.4
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, cVar));
                        }
                    }, 2000L);
                }
                TbSingleton.getInstance().getChannelConfigModel().rk(l.fbO);
            } else if (this.mFinalData.btT() == l.fbN) {
                if (this.tipView != null) {
                    this.tipView.setVisibility(0);
                }
                TbSingleton.getInstance().getChannelConfigModel().rk(l.fbN);
            } else if (this.tipView != null) {
                this.tipView.setVisibility(8);
            }
        }
    }
}
