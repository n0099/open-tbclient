package com.baidu.tieba.flutter.base;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.flutter.base.view.FlutterDelegateStatic;
import com.baidu.tieba.flutter.base.view.FlutterEnterForumDelegateStatic;
import com.baidu.tieba.flutter.base.view.FlutterNewCategoryDelegateStatic;
import com.baidu.tieba.flutter.base.view.PageRouter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.Utils;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import d.a.c.c.f.b;
import d.a.p0.h3.h0.m;
import io.flutter.embedding.android.FlutterView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class FlutterStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(540114414, "Lcom/baidu/tieba/flutter/base/FlutterStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(540114414, "Lcom/baidu/tieba/flutter/base/FlutterStatic;");
                return;
            }
        }
        initFlutter();
    }

    public FlutterStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void initFlutter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            if ("MuMu".equals(Build.MODEL) && "Netease".equals(Build.MANUFACTURER)) {
                return;
            }
            registerFlutterRule();
            FlutterDelegateStatic.registerFlutterFragment();
            FlutterNewCategoryDelegateStatic.registerFlutterFragment();
            FlutterEnterForumDelegateStatic.registerFlutterFragment();
            INativeRouter iNativeRouter = new INativeRouter() { // from class: com.baidu.tieba.flutter.base.FlutterStatic.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.idlefish.flutterboost.interfaces.INativeRouter
                public void openContainer(Context context, String str, Map<String, Object> map, int i2, Map<String, Object> map2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{context, str, map, Integer.valueOf(i2), map2}) == null) {
                        PageRouter.openPageByUrl(context, Utils.assembleUrl(str, map), map);
                    }
                }
            };
            FlutterBoost.BoostLifecycleListener boostLifecycleListener = new FlutterBoost.BoostLifecycleListener() { // from class: com.baidu.tieba.flutter.base.FlutterStatic.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.idlefish.flutterboost.FlutterBoost.BoostLifecycleListener
                public void beforeCreateEngine() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.idlefish.flutterboost.FlutterBoost.BoostLifecycleListener
                public void onEngineCreated() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }

                public void onEngineDestroy() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }

                public void onPluginsRegistered() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921485));
                    }
                }
            };
            FlutterBoost.ConfigBuilder configBuilder = new FlutterBoost.ConfigBuilder(TbadkCoreApplication.getInst(), iNativeRouter);
            configBuilder.isDebug(isDebugMode());
            configBuilder.whenEngineStart(FlutterBoost.ConfigBuilder.FLUTTER_ACTIVITY_CREATED);
            configBuilder.renderMode(FlutterView.RenderMode.texture);
            configBuilder.lifecycleListener(boostLifecycleListener);
            FlutterBoost.instance().init(configBuilder.build());
        }
    }

    public static boolean isDebugMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (BdBaseApplication.getInst() == null) {
                return false;
            }
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public static void registerFlutterRule() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            MessageManager.getInstance().addMessageRule(new b(0) { // from class: com.baidu.tieba.flutter.base.FlutterStatic.3
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
                @Override // d.a.c.c.f.f
                public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, customMessage, customMessageTask)) == null) ? (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof IntentConfig)) ? customMessage : OpenFlutter.goToFlutter(customMessage) : (CustomMessage) invokeLL.objValue;
                }
            });
            MessageManager.getInstance().registerTask(new CustomMessageTask(2002015, new CustomMessageTask.CustomRunnable<m>() { // from class: com.baidu.tieba.flutter.base.FlutterStatic.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<m> run(CustomMessage<m> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        if (customMessage != null && customMessage.getData() != null) {
                            Context a2 = customMessage.getData().a();
                            String b2 = customMessage.getData().b();
                            HashMap c2 = customMessage.getData().c();
                            if (c2 == null || c2.isEmpty()) {
                                c2 = new HashMap();
                            }
                            if (a2 != null && !TextUtils.isEmpty(b2)) {
                                OpenFlutter.openFlutterPage(a2, b2, c2);
                            }
                        }
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            }));
            UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.flutter.base.FlutterStatic.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
                public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                        if (strArr != null && strArr[0] != null) {
                            String str = strArr[0];
                            if (str.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER)) {
                                try {
                                    Uri parse = Uri.parse(str);
                                    HashMap hashMap = new HashMap();
                                    String host = parse.getHost();
                                    for (String str2 : parse.getQueryParameterNames()) {
                                        hashMap.put(str2, parse.getQueryParameter(str2));
                                    }
                                    OpenFlutter.openFlutterPage(tbPageContext.getPageActivity().getBaseContext(), host, hashMap);
                                    return 0;
                                } catch (Exception e2) {
                                    BdLog.e(e2);
                                }
                            }
                        }
                        return 3;
                    }
                    return invokeLL.intValue;
                }
            });
        }
    }
}
