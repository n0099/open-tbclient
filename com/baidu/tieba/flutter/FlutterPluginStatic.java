package com.baidu.tieba.flutter;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.controller.CustomRule;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.dk;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.nt5;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.tk;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FlutterPluginStatic {
    public static /* synthetic */ Interceptable $ic;
    public static int mFlutterPersonCenterRequestCount;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1976846111, "Lcom/baidu/tieba/flutter/FlutterPluginStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1976846111, "Lcom/baidu/tieba/flutter/FlutterPluginStatic;");
                return;
            }
        }
        if (GlobalBuildConfig.getTiebaNpsPluginMode().contains("-Flutter")) {
            MessageManager.getInstance().registerListener(new CustomMessageListener(2921674) { // from class: com.baidu.tieba.flutter.FlutterPluginStatic.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if ((interceptable2 != null && interceptable2.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                        return;
                    }
                    String e = tk.f().e();
                    String versionName = TbadkCoreApplication.getInst().getVersionName();
                    TbLog a = dk.a();
                    a.i(FlutterPluginManager.TAG, "开始安装Flutter插件 配置的Flutter版本：" + e + " 客户端当前版本" + versionName + " data" + customResponsedMessage.getData());
                    if (TextUtils.isEmpty(versionName)) {
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof IntentConfig) {
                        FlutterPluginManager.getInstance().init((IntentConfig) customResponsedMessage.getData());
                    } else if (customResponsedMessage.getData() instanceof nt5) {
                        FlutterPluginManager.getInstance().init((nt5) customResponsedMessage.getData());
                    } else if (customResponsedMessage.getData() instanceof FlutterOpenData) {
                        FlutterPluginManager.getInstance().init((FlutterOpenData) customResponsedMessage.getData());
                    } else {
                        FlutterPluginManager.getInstance().init();
                    }
                }
            });
            MessageManager.getInstance().addMessageRule(new CustomRule(0) { // from class: com.baidu.tieba.flutter.FlutterPluginStatic.2
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.controller.MessageRule
                public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                        if (!FlutterPluginManager.getInstance().hasInstall() && customMessage != null) {
                            Object data = customMessage.getData();
                            if ((data instanceof PersonPolymericActivityConfig) || (data instanceof PersonInfoActivityConfig)) {
                                int i = FlutterPluginStatic.mFlutterPersonCenterRequestCount;
                                if (i >= 2) {
                                    return customMessage;
                                }
                                FlutterPluginStatic.mFlutterPersonCenterRequestCount = i + 1;
                                FlutterPluginManager.getInstance().initFromPersonInfo((IntentConfig) data);
                                return null;
                            }
                            return customMessage;
                        }
                        return customMessage;
                    }
                    return (CustomMessage) invokeLL.objValue;
                }
            });
        }
    }

    public FlutterPluginStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
