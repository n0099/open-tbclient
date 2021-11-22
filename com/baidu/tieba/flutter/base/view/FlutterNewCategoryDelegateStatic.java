package com.baidu.tieba.flutter.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.h;
import b.a.e.f.m.e;
import b.a.e.f.p.l;
import b.a.q0.h0.b;
import b.a.q0.h0.c;
import b.a.q0.h0.d;
import b.a.q0.t.c.o;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.containers.FlutterFragment;
/* loaded from: classes9.dex */
public class FlutterNewCategoryDelegateStatic extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean isNew;
    public CustomMessageListener mChannelDataGetListener;
    public o mFinalData;
    public CustomMessageListener maintabEmotionListener;
    public MessageRedDotView tipView;

    public FlutterNewCategoryDelegateStatic() {
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
        this.mChannelDataGetListener = new CustomMessageListener(this, 2921493) { // from class: com.baidu.tieba.flutter.base.view.FlutterNewCategoryDelegateStatic.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterNewCategoryDelegateStatic this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.this$0.loadStatus();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mChannelDataGetListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            o c2 = TbSingleton.getInstance().getChannelConfigModel().c();
            this.mFinalData = c2;
            if (c2 == null) {
                return;
            }
            if (c2.a() == o.f14599h) {
                if (!TextUtils.isEmpty(this.mFinalData.b())) {
                    c cVar = new c();
                    cVar.f13365g = this.mFinalData.b();
                    cVar.f13363e = 21;
                    if (!TextUtils.isEmpty(this.mFinalData.c())) {
                        cVar.f13361c = this.mFinalData.c();
                    }
                    e.a().postDelayed(new Runnable(this, cVar) { // from class: com.baidu.tieba.flutter.base.view.FlutterNewCategoryDelegateStatic.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ FlutterNewCategoryDelegateStatic this$0;
                        public final /* synthetic */ c val$tabStructure;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, cVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$tabStructure = cVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, this.val$tabStructure));
                            }
                        }
                    }, 2000L);
                }
                TbSingleton.getInstance().getChannelConfigModel().d(o.f14599h);
            } else if (this.mFinalData.a() == o.f14598g) {
                MessageRedDotView messageRedDotView = this.tipView;
                if (messageRedDotView != null) {
                    messageRedDotView.setVisibility(0);
                }
                TbSingleton.getInstance().getChannelConfigModel().d(o.f14598g);
            } else {
                MessageRedDotView messageRedDotView2 = this.tipView;
                if (messageRedDotView2 != null) {
                    messageRedDotView2.setVisibility(8);
                }
            }
        }
    }

    public static void registerChannelNetwork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG, TbConfig.SERVER_ADDRESS + TbConfig.GET_CHANNEL_ADDRESS);
            tbHttpMessageTask.setResponsedClass(ChannelConfigResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void registerFlutterFragment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            registerChannelNetwork();
            new CustomMessageListener(2007002) { // from class: com.baidu.tieba.flutter.base.view.FlutterNewCategoryDelegateStatic.2
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
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                        return;
                    }
                    FlutterNewCategoryDelegateStatic flutterNewCategoryDelegateStatic = new FlutterNewCategoryDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(flutterNewCategoryDelegateStatic);
                    flutterNewCategoryDelegateStatic.loadStatus();
                }
            }.setPriority(6);
        }
    }

    @Override // b.a.q0.h0.b
    public c createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c cVar = new c();
            FlutterFragment.NewEngineFragmentBuilder newEngineFragmentBuilder = new FlutterFragment.NewEngineFragmentBuilder(TbFlutterFragment.class);
            newEngineFragmentBuilder.url(OpenFlutter.FRAGMENT_NEWCATEGORY);
            newEngineFragmentBuilder.isTabHost(true);
            FlutterFragment build = newEngineFragmentBuilder.build();
            cVar.f13359a = build;
            cVar.f13363e = 21;
            ((TbFlutterFragment) build).setOnPrimaryListener(new TbFlutterFragmentLifeCircleInterface(this) { // from class: com.baidu.tieba.flutter.base.view.FlutterNewCategoryDelegateStatic.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterNewCategoryDelegateStatic this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.tieba.flutter.base.view.TbFlutterFragmentLifeCircleInterface
                public void onPrimary() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.tipView.setVisibility(8);
                    }
                }
            });
            Resources resources = h.a().getResources();
            cVar.f13360b = resources.getIdentifier("new_category", "string", BdBaseApplication.getInst().getPackageName());
            cVar.f13364f = resources.getIdentifier("lottie_tab_category", "raw", BdBaseApplication.getInst().getPackageName());
            cVar.f13367i = c.l;
            cVar.f13366h = b.a.q0.h0.e.c.d().c("channel");
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    @Override // b.a.q0.h0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(h.a().getResources().getIdentifier("maintab_bottom_indicator", "layout", BdBaseApplication.getInst().getPackageName()), (ViewGroup) null);
            this.tipView = new MessageRedDotView(context);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            aVar.f46828f = this.mIndicator;
            aVar.f46825c = l.e(context, 10.0f);
            aVar.f46823a = this.tipView;
            this.mIndicator.addTipWrapContent(FileHelper.FILE_CACHE_EMOTION_PACKAGE, aVar);
            this.tipView.refresh(0);
            o oVar = this.mFinalData;
            if (oVar != null) {
                if (oVar.a() == o.f14598g) {
                    this.tipView.setVisibility(0);
                } else {
                    this.tipView.setVisibility(8);
                }
            } else {
                this.tipView.setVisibility(8);
            }
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // b.a.q0.h0.b
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? MainTabActivityConfig.NEW_CATEGORY_TAB_AVAIBLE : invokeV.booleanValue;
    }

    @Override // b.a.q0.h0.b
    public void onAdd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAdd();
            MessageManager.getInstance().registerListener(this.mChannelDataGetListener);
        }
    }

    @Override // b.a.q0.h0.b
    public void onRemove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onRemove();
            MessageManager.getInstance().unRegisterListener(this.mChannelDataGetListener);
        }
    }
}
