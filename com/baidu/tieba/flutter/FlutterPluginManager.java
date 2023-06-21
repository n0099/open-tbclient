package com.baidu.tieba.flutter;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.dt5;
import com.baidu.tieba.n75;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.tr8;
import com.baidu.tieba.wk;
import com.baidu.tieba.xg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FlutterPluginManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NPS_MODE = "Flutter";
    public static final String PLUGIN_IMPL_CLASS = "com.baidu.tieba.flutter.FlutterPluginImpl";
    public static final String PLUGIN_PKG_NAME = "com.baidu.tieba.plugin.flutter";
    public static final String TAG = "FlutterPlugin";
    public transient /* synthetic */ FieldHolder $fh;
    public IFlutterPlugin mIFlutterPlugin;

    /* loaded from: classes5.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final FlutterPluginManager INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-880041879, "Lcom/baidu/tieba/flutter/FlutterPluginManager$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-880041879, "Lcom/baidu/tieba/flutter/FlutterPluginManager$SingletonHolder;");
                    return;
                }
            }
            INSTANCE = new FlutterPluginManager();
        }

        public SingletonHolder() {
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

    public FlutterPluginManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static FlutterPluginManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return SingletonHolder.INSTANCE;
        }
        return (FlutterPluginManager) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.mIFlutterPlugin == null) {
            wk.a().c(TAG, "Flutter init() 触发插件安装");
            invokePlugin(new IInvokeCallback(this) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterPluginManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                        tr8 a = wk.a();
                        a.c(FlutterPluginManager.TAG, "Flutter init() 插件安装完成" + i + " " + str + " " + obj);
                        if (i != 14) {
                            return;
                        }
                        try {
                            if (this.this$0.mIFlutterPlugin == null) {
                                this.this$0.mIFlutterPlugin = (IFlutterPlugin) ((Class) obj).newInstance();
                                this.this$0.mIFlutterPlugin.init();
                            }
                            n75.a();
                        } catch (Throwable th) {
                            tr8 a2 = wk.a();
                            a2.b(FlutterPluginManager.TAG, "Flutter init() 插件安装异常" + th);
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void init(dt5 dt5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dt5Var) == null) {
            if (this.mIFlutterPlugin == null) {
                wk.a().c(TAG, "Flutter init(INpsPluginInitCallback) 触发插件安装");
                invokePlugin(new IInvokeCallback(this, dt5Var) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FlutterPluginManager this$0;
                    public final /* synthetic */ dt5 val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, dt5Var};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = dt5Var;
                    }

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                            tr8 a = wk.a();
                            a.c(FlutterPluginManager.TAG, "Flutter init(INpsPluginInitCallback) 插件安装完成" + i + " " + str + " " + obj);
                            if (i != 14) {
                                this.val$callback.onFail();
                                return;
                            }
                            try {
                                if (this.this$0.mIFlutterPlugin == null) {
                                    this.this$0.mIFlutterPlugin = (IFlutterPlugin) ((Class) obj).newInstance();
                                    this.this$0.mIFlutterPlugin.init();
                                }
                                this.val$callback.onSuccess();
                            } catch (Throwable th) {
                                tr8 a2 = wk.a();
                                a2.b(FlutterPluginManager.TAG, "Flutter init(INpsPluginInitCallback) 插件安装异常" + th);
                                th.printStackTrace();
                                this.val$callback.onFail();
                            }
                        }
                    }
                });
                return;
            }
            dt5Var.onSuccess();
        }
    }

    private void invokePlugin(IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, iInvokeCallback) == null) {
            if (NPSPackageManager.getInstance().getBundleStatus(PLUGIN_PKG_NAME) == 43) {
                wk.a().c(TAG, "Flutter invokePlugin：插件可用，直接加载");
                NPSManager.getInstance().loadClazz(PLUGIN_PKG_NAME, PLUGIN_IMPL_CLASS, IFlutterPlugin.class, iInvokeCallback);
                return;
            }
            wk.a().c(TAG, "Flutter invokePlugin：开始下载");
            NPSPackageManager.getInstance().installBundle(PLUGIN_PKG_NAME, new IInstallCallback(this, iInvokeCallback) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterPluginManager this$0;
                public final /* synthetic */ IInvokeCallback val$invokeCallback;

                @Override // com.baidu.nps.main.install.IInstallCallback
                public void onProgress(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iInvokeCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$invokeCallback = iInvokeCallback;
                }

                @Override // com.baidu.nps.main.install.IInstallCallback
                public void onResult(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                        tr8 a = wk.a();
                        a.c(FlutterPluginManager.TAG, "Flutter invokePlugin 下载完成 " + i + " " + str);
                        if (i == 13) {
                            NPSManager.getInstance().loadClazz(FlutterPluginManager.PLUGIN_PKG_NAME, FlutterPluginManager.PLUGIN_IMPL_CLASS, IFlutterPlugin.class, this.val$invokeCallback);
                        }
                    }
                }
            });
        }
    }

    public void init(IntentConfig intentConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intentConfig) == null) && this.mIFlutterPlugin == null) {
            UtilHelper.showToast(TbadkCoreApplication.getInst().getCurrentActivity(), "加载插件中...");
            wk.a().c(TAG, "Flutter init(IntentConfig) 触发插件安装");
            invokePlugin(new IInvokeCallback(this, intentConfig) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterPluginManager this$0;
                public final /* synthetic */ IntentConfig val$intentConfig;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, intentConfig};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$intentConfig = intentConfig;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                        tr8 a = wk.a();
                        a.c(FlutterPluginManager.TAG, "Flutter init(IntentConfig) 插件安装完成" + i + " " + str + " " + obj);
                        if (i != 14) {
                            return;
                        }
                        try {
                            if (this.this$0.mIFlutterPlugin == null) {
                                this.this$0.mIFlutterPlugin = (IFlutterPlugin) ((Class) obj).newInstance();
                                this.this$0.mIFlutterPlugin.init();
                            }
                            xg.a().post(new Runnable(this) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass3 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.this$1.val$intentConfig));
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            tr8 a2 = wk.a();
                            a2.b(FlutterPluginManager.TAG, "Flutter init(IntentConfig) 插件安装异常" + th);
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void initFromPersonInfo(PersonInfoActivityConfig personInfoActivityConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, personInfoActivityConfig) == null) && this.mIFlutterPlugin == null) {
            UtilHelper.showToast(TbadkCoreApplication.getInst().getCurrentActivity(), "加载插件中...");
            wk.a().c(TAG, "Flutter initFromPersonInfo 触发插件安装");
            invokePlugin(new IInvokeCallback(this, personInfoActivityConfig) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterPluginManager this$0;
                public final /* synthetic */ PersonInfoActivityConfig val$intentConfig;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, personInfoActivityConfig};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$intentConfig = personInfoActivityConfig;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                        tr8 a = wk.a();
                        a.c(FlutterPluginManager.TAG, "Flutter initFromPersonInfo 插件安装完成" + i + " " + str + " " + obj);
                        if (i != 14) {
                            return;
                        }
                        try {
                            if (this.this$0.mIFlutterPlugin == null) {
                                this.this$0.mIFlutterPlugin = (IFlutterPlugin) ((Class) obj).newInstance();
                                this.this$0.mIFlutterPlugin.init();
                            }
                            xg.a().post(new Runnable(this) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.5.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass5 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, this.this$1.val$intentConfig));
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            tr8 a2 = wk.a();
                            a2.b(FlutterPluginManager.TAG, "Flutter initFromPersonInfo 插件安装异常" + th);
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void init(FlutterOpenData flutterOpenData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, flutterOpenData) == null) && this.mIFlutterPlugin == null) {
            UtilHelper.showToast(TbadkCoreApplication.getInst().getCurrentActivity(), "加载插件中...");
            wk.a().c(TAG, "Flutter init(FlutterOpenData) 触发插件安装");
            invokePlugin(new IInvokeCallback(this, flutterOpenData) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FlutterPluginManager this$0;
                public final /* synthetic */ FlutterOpenData val$intentConfig;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, flutterOpenData};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$intentConfig = flutterOpenData;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                        tr8 a = wk.a();
                        a.c(FlutterPluginManager.TAG, "Flutter init(FlutterOpenData) 插件安装完成" + i + " " + str + " " + obj);
                        if (i != 14) {
                            return;
                        }
                        try {
                            if (this.this$0.mIFlutterPlugin == null) {
                                this.this$0.mIFlutterPlugin = (IFlutterPlugin) ((Class) obj).newInstance();
                                this.this$0.mIFlutterPlugin.init();
                            }
                            xg.a().post(new Runnable(this) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, this.this$1.val$intentConfig));
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            tr8 a2 = wk.a();
                            a2.b(FlutterPluginManager.TAG, "Flutter init(FlutterOpenData) 插件安装异常" + th);
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
