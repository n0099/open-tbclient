package com.baidu.tieba.flutter.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import c.a.d.a.h;
import c.a.d.f.p.n;
import c.a.q0.h0.b;
import c.a.q0.h0.c;
import c.a.q0.h0.d;
import c.a.q0.h0.e;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.switchs.FlutterMyTabEnableSwitch;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.flutter.base.view.FlutterBaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class FlutterEnterForumDelegateStatic extends b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PERSON_INFO_TAB_MIDDLE_REDDOT_DISTANCE = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean isNew;
    public MessageRedDotView tipView;

    public FlutterEnterForumDelegateStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isNew = Boolean.FALSE;
    }

    public static void registerFlutterFragment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.flutter.base.view.FlutterEnterForumDelegateStatic.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && FlutterMyTabEnableSwitch.isOn()) {
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
    }

    @Override // c.a.q0.h0.b
    public c createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CREATE_FLUTTER_FRAGMENT_START_KEY);
            c cVar = new c();
            HashMap hashMap = new HashMap();
            hashMap.put("tabIndex", Integer.valueOf(c.a.q0.r.f0.b.f12896c));
            TbFlutterFragment tbFlutterFragment = (TbFlutterFragment) new FlutterBaseFragment.NewEngineFragmentBuilder(TbFlutterFragment.class).params(hashMap).url(OpenFlutter.FRAGMENT_ENTER_FORUM).isTabHost(c.a.q0.r.f0.b.f12895b != 1).build();
            cVar.a = tbFlutterFragment;
            if (c.a.q0.r.f0.b.f12896c == c.a.q0.r.f0.b.f12898e) {
                c.a.q0.r.f0.b.f12896c = c.a.q0.r.f0.b.f12897d;
                tbFlutterFragment.removeSplashDelay(1000L);
                tbFlutterFragment.setAutoPlayWhenInit(true);
            }
            cVar.f12602e = 1;
            Resources resources = h.a().getResources();
            cVar.f12599b = resources.getIdentifier("enter_forum", "string", BdBaseApplication.getInst().getPackageName());
            cVar.f12603f = resources.getIdentifier("lottie_tab_forum", "raw", BdBaseApplication.getInst().getPackageName());
            cVar.f12606i = c.m;
            cVar.f12605h = c.a.q0.h0.f.c.d().c("enterForum");
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CREATE_FLUTTER_FRAGMENT_END_KEY);
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    @Override // c.a.q0.h0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) e.e().d(1);
            this.mIndicator = maintabBottomIndicator;
            if (maintabBottomIndicator == null) {
                this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(h.a().getResources().getIdentifier("maintab_bottom_indicator", "layout", BdBaseApplication.getInst().getPackageName()), (ViewGroup) null);
            }
            this.tipView = new MessageRedDotView(context);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            aVar.f39707f = this.mIndicator;
            aVar.f39704c = n.d(context, 10.0f);
            aVar.a = this.tipView;
            this.mIndicator.addTipWrapContent(FileHelper.FILE_CACHE_EMOTION_PACKAGE, aVar);
            boolean h2 = c.a.q0.r.j0.b.k().h("key_feedback_tip_tab_show", false);
            if (!this.isNew.booleanValue() && !h2) {
                this.tipView.setVisibility(8);
            } else {
                this.tipView.refresh(0);
                this.tipView.setVisibility(0);
            }
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // c.a.q0.h0.b
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? MainTabActivityConfig.ENTER_FORUM_TAB_AVAIBLE : invokeV.booleanValue;
    }
}
