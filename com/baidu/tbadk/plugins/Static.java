package com.baidu.tbadk.plugins;

import b.a.e.h.j.g.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class Static {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f46025a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                PluginCenter.getInstance().startRetryLaunchPlugins();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Throwable th;
            StackTraceElement[] stackTrace;
            Plugin plugin2;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ExceptionData)) {
                return;
            }
            ExceptionData exceptionData = (ExceptionData) customResponsedMessage.getData();
            String[] strArr = Static.f46025a;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = true;
                    break;
                }
                String str2 = strArr[i2];
                if (exceptionData != null && (str = exceptionData.info) != null && str.contains(str2) && !exceptionData.info.contains("java.lang.OutOfMemoryError")) {
                    b.a.e.h.h.a.b().g("plugin_crash_inflate");
                    z = false;
                    break;
                }
                i2++;
            }
            if (exceptionData == null || (th = exceptionData.mExcep) == null || th.getCause() == null || exceptionData.mExcep.getCause().getStackTrace() == null || !z || exceptionData.info == null) {
                return;
            }
            try {
                List<PluginSetting> pluginSettingsSortLoadPriorty = d.k().l().getPluginSettingsSortLoadPriorty();
                if (pluginSettingsSortLoadPriorty != null && !pluginSettingsSortLoadPriorty.isEmpty() && (stackTrace = exceptionData.mExcep.getCause().getStackTrace()) != null && stackTrace.length != 0) {
                    for (PluginSetting pluginSetting : pluginSettingsSortLoadPriorty) {
                        if (pluginSetting.isPatch && pluginSetting.enable && (plugin2 = PluginCenter.getInstance().getPlugin(pluginSetting.packageName)) != null && plugin2.getDexClassLoader() != null) {
                            for (StackTraceElement stackTraceElement : stackTrace) {
                                try {
                                    plugin2.getDexClassLoader().loadClass(stackTraceElement.getClassName());
                                    b.a.q0.s.e0.b.j().v("plugin_patch_hook_failed_count", b.a.q0.s.e0.b.j().k("plugin_patch_hook_failed_count", 0) + 1);
                                    break;
                                } catch (ClassNotFoundException unused) {
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                BdLog.e(th2.getMessage());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends b.a.e.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
        /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
        @Override // b.a.e.c.f.f
        public /* bridge */ /* synthetic */ CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            CustomMessage<?> customMessage2 = customMessage;
            process2(customMessage2, customMessageTask);
            return customMessage2;
        }

        /* renamed from: process  reason: avoid collision after fix types in other method */
        public CustomMessage<?> process2(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                if (customMessage == null || !(customMessage.getData() instanceof IntentConfig)) {
                }
                return customMessage;
            }
            return (CustomMessage) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431419675, "Lcom/baidu/tbadk/plugins/Static;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431419675, "Lcom/baidu/tbadk/plugins/Static;");
                return;
            }
        }
        f46025a = new String[]{"android.content.res.Resources$NotFoundException", "android.view.InflateException"};
        MessageManager.getInstance().registerListener(new a(2001011));
        a();
        MessageManager.getInstance().registerListener(new b(2016301));
    }

    public Static() {
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

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            MessageManager.getInstance().addMessageRule(new c(0));
        }
    }
}
