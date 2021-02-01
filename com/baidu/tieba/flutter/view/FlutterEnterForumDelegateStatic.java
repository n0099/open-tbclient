package com.baidu.tieba.flutter.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tbadk.switchs.FlutterMyTabEnableSwitch;
import com.baidu.tieba.flutter.util.OpenFlutter;
import com.idlefish.flutterboost.containers.FlutterFragment;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class FlutterEnterForumDelegateStatic extends b {
    private static final int PERSON_INFO_TAB_MIDDLE_REDDOT_DISTANCE = 10;
    private Boolean isNew = false;
    private MessageRedDotView tipView;

    public static void registerFlutterFragment() {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.flutter.view.FlutterEnterForumDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && FlutterMyTabEnableSwitch.isOn()) {
                    FlutterEnterForumDelegateStatic flutterEnterForumDelegateStatic = new FlutterEnterForumDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(flutterEnterForumDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() == null || flutterEnterForumDelegateStatic.getFragmentTabStructure() == null) {
                    }
                }
            }
        };
        customMessageListener.setPriority(2);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ENTER_FORUM_TAB_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        HashMap hashMap = new HashMap();
        hashMap.put("tabIndex", Integer.valueOf(com.baidu.tbadk.core.e.b.eYr));
        TbFlutterFragment tbFlutterFragment = (TbFlutterFragment) new FlutterFragment.NewEngineFragmentBuilder(TbFlutterFragment.class).params(hashMap).url(OpenFlutter.FRAGMENT_ENTER_FORUM).isTabHost(com.baidu.tbadk.core.e.b.eYq != 1).build();
        cVar.frag = tbFlutterFragment;
        if (com.baidu.tbadk.core.e.b.eYr == com.baidu.tbadk.core.e.b.eYt) {
            com.baidu.tbadk.core.e.b.eYr = com.baidu.tbadk.core.e.b.eYs;
            tbFlutterFragment.removeSplashDelay(1000L);
            tbFlutterFragment.setAutoPlayWhenInit(true);
        }
        cVar.type = 1;
        Resources resources = h.kD().getResources();
        cVar.textResId = resources.getIdentifier("enter_forum", "string", BdBaseApplication.getInst().getPackageName());
        cVar.animationResId = resources.getIdentifier("lottie_tab_forum", "raw", BdBaseApplication.getInst().getPackageName());
        cVar.showIconType = c.fHd;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(h.kD().getResources().getIdentifier("maintab_bottom_indicator", "layout", BdBaseApplication.getInst().getPackageName()), (ViewGroup) null);
        this.tipView = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.fHv = this.mIndicator;
        aVar.offsetX = l.dip2px(context, 10.0f);
        aVar.view = this.tipView;
        this.mIndicator.b("emotion", aVar);
        boolean z = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, false);
        if (this.isNew.booleanValue() || z) {
            this.tipView.refresh(0);
            this.tipView.setVisibility(0);
        } else {
            this.tipView.setVisibility(8);
        }
        return this.mIndicator;
    }
}
