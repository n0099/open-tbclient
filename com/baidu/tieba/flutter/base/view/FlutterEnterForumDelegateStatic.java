package com.baidu.tieba.flutter.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import c.a.e.a.h;
import c.a.e.e.p.l;
import c.a.p0.g0.b;
import c.a.p0.g0.c;
import c.a.p0.g0.d;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.switchs.FlutterMyTabEnableSwitch;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.containers.FlutterFragment;
import java.util.HashMap;
/* loaded from: classes7.dex */
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
                        if (((d) customResponsedMessage.getData()).b() == null || flutterEnterForumDelegateStatic.getFragmentTabStructure() == null) {
                        }
                    }
                }
            };
            customMessageListener.setPriority(2);
            MessageManager.getInstance().registerListener(customMessageListener);
        }
    }

    @Override // c.a.p0.g0.b
    public c createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c cVar = new c();
            HashMap hashMap = new HashMap();
            hashMap.put("tabIndex", Integer.valueOf(c.a.p0.s.a0.b.f13787c));
            FlutterFragment.NewEngineFragmentBuilder newEngineFragmentBuilder = new FlutterFragment.NewEngineFragmentBuilder(TbFlutterFragment.class);
            newEngineFragmentBuilder.params(hashMap);
            newEngineFragmentBuilder.url(OpenFlutter.FRAGMENT_ENTER_FORUM);
            newEngineFragmentBuilder.isTabHost(c.a.p0.s.a0.b.f13786b != 1);
            TbFlutterFragment tbFlutterFragment = (TbFlutterFragment) newEngineFragmentBuilder.build();
            cVar.f13476a = tbFlutterFragment;
            if (c.a.p0.s.a0.b.f13787c == c.a.p0.s.a0.b.f13789e) {
                c.a.p0.s.a0.b.f13787c = c.a.p0.s.a0.b.f13788d;
                tbFlutterFragment.removeSplashDelay(1000L);
                tbFlutterFragment.setAutoPlayWhenInit(true);
            }
            cVar.f13480e = 1;
            Resources b2 = h.a().b();
            cVar.f13477b = b2.getIdentifier("enter_forum", "string", BdBaseApplication.getInst().getPackageName());
            cVar.f13481f = b2.getIdentifier("lottie_tab_forum", "raw", BdBaseApplication.getInst().getPackageName());
            cVar.f13484i = c.m;
            cVar.f13483h = c.a.p0.g0.e.c.d().c("enterForum");
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    @Override // c.a.p0.g0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(h.a().b().getIdentifier("maintab_bottom_indicator", "layout", BdBaseApplication.getInst().getPackageName()), (ViewGroup) null);
            this.tipView = new MessageRedDotView(context);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            aVar.f48288f = this.mIndicator;
            aVar.f48285c = l.e(context, 10.0f);
            aVar.f48283a = this.tipView;
            this.mIndicator.addTipWrapContent(FileHelper.FILE_CACHE_EMOTION_PACKAGE, aVar);
            boolean g2 = c.a.p0.s.d0.b.j().g("key_feedback_tip_tab_show", false);
            if (!this.isNew.booleanValue() && !g2) {
                this.tipView.setVisibility(8);
            } else {
                this.tipView.refresh(0);
                this.tipView.setVisibility(0);
            }
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // c.a.p0.g0.b
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? MainTabActivityConfig.ENTER_FORUM_TAB_AVAIBLE : invokeV.booleanValue;
    }
}
