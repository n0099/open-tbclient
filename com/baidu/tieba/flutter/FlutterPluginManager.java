package com.baidu.tieba.flutter;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.PluginCheck;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pb5;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.un5;
import com.baidu.tieba.x15;
import com.baidu.tieba.ze;
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

    private void tryShowLoadingToast() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && PluginCheck.c(PLUGIN_PKG_NAME, null, TAG, false)) {
            UtilHelper.showToast(TbadkCoreApplication.getInst().getCurrentActivity(), "加载插件中...");
        }
    }

    public boolean hasInstall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mIFlutterPlugin != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.mIFlutterPlugin == null) {
            ze.a().i(TAG, "Flutter init() 触发插件安装");
            invokePlugin(new pb5(this) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.1
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

                @Override // com.baidu.tieba.pb5, com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                        super.onResult(i, str, obj);
                        TbLog a = ze.a();
                        a.i(FlutterPluginManager.TAG, "Flutter init() 插件安装完成" + i + " " + str + " " + obj);
                        if (i != 14) {
                            return;
                        }
                        try {
                            if (this.this$0.mIFlutterPlugin == null) {
                                this.this$0.mIFlutterPlugin = (IFlutterPlugin) ((Class) obj).newInstance();
                                this.this$0.mIFlutterPlugin.init();
                            }
                            x15.a();
                        } catch (Throwable th) {
                            TbLog a2 = ze.a();
                            a2.e(FlutterPluginManager.TAG, "Flutter init() 插件安装异常" + th);
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void init(IntentConfig intentConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intentConfig) == null) && this.mIFlutterPlugin == null) {
            tryShowLoadingToast();
            ze.a().i(TAG, "Flutter init(IntentConfig) 触发插件安装");
            invokePlugin(new pb5(this, intentConfig) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.3
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

                @Override // com.baidu.tieba.pb5, com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                        super.onResult(i, str, obj);
                        TbLog a = ze.a();
                        a.i(FlutterPluginManager.TAG, "Flutter init(IntentConfig) 插件安装完成" + i + " " + str + " " + obj);
                        if (i != 14) {
                            return;
                        }
                        try {
                            if (this.this$0.mIFlutterPlugin == null) {
                                this.this$0.mIFlutterPlugin = (IFlutterPlugin) ((Class) obj).newInstance();
                                this.this$0.mIFlutterPlugin.init();
                            }
                            SafeHandler.getInst().post(new Runnable(this) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.3.1
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
                            TbLog a2 = ze.a();
                            a2.e(FlutterPluginManager.TAG, "Flutter init(IntentConfig) 插件安装异常" + th);
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void initFromPersonInfo(IntentConfig intentConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, intentConfig) == null) && this.mIFlutterPlugin == null) {
            tryShowLoadingToast();
            ze.a().i(TAG, "Flutter initFromPersonInfo 触发插件安装");
            invokePlugin(new pb5(this, intentConfig) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.5
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

                @Override // com.baidu.tieba.pb5, com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                        super.onResult(i, str, obj);
                        TbLog a = ze.a();
                        a.i(FlutterPluginManager.TAG, "Flutter initFromPersonInfo 插件安装完成" + i + " " + str + " " + obj);
                        if (i != 14) {
                            return;
                        }
                        try {
                            if (this.this$0.mIFlutterPlugin == null) {
                                this.this$0.mIFlutterPlugin = (IFlutterPlugin) ((Class) obj).newInstance();
                                this.this$0.mIFlutterPlugin.init();
                            }
                            SafeHandler.getInst().post(new Runnable(this) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.5.1
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
                                        IntentConfig intentConfig2 = this.this$1.val$intentConfig;
                                        if (intentConfig2 instanceof PersonPolymericActivityConfig) {
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.this$1.val$intentConfig));
                                        } else if (intentConfig2 instanceof PersonInfoActivityConfig) {
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, this.this$1.val$intentConfig));
                                        }
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            TbLog a2 = ze.a();
                            a2.e(FlutterPluginManager.TAG, "Flutter initFromPersonInfo 插件安装异常" + th);
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    private void invokePlugin(IInvokeCallback iInvokeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, iInvokeCallback) == null) {
            if (NPSPackageManager.getInstance().getBundleStatus(PLUGIN_PKG_NAME) == 43) {
                if (PluginCheck.c(PLUGIN_PKG_NAME, iInvokeCallback, TAG, false)) {
                    ze.a().i(TAG, "Flutter invokePlugin：插件可用，直接加载");
                    NPSManager.getInstance().loadClazz(PLUGIN_PKG_NAME, PLUGIN_IMPL_CLASS, IFlutterPlugin.class, iInvokeCallback);
                    return;
                }
                return;
            }
            ze.a().i(TAG, "Flutter invokePlugin：开始下载");
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
                        TbLog a = ze.a();
                        a.i(FlutterPluginManager.TAG, "Flutter invokePlugin 下载完成 " + i + " " + str);
                        if (i == 13 && PluginCheck.c(FlutterPluginManager.PLUGIN_PKG_NAME, this.val$invokeCallback, FlutterPluginManager.TAG, true)) {
                            NPSManager.getInstance().loadClazz(FlutterPluginManager.PLUGIN_PKG_NAME, FlutterPluginManager.PLUGIN_IMPL_CLASS, IFlutterPlugin.class, this.val$invokeCallback);
                        }
                    }
                }
            });
        }
    }

    public void init(FlutterOpenData flutterOpenData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, flutterOpenData) == null) && this.mIFlutterPlugin == null) {
            tryShowLoadingToast();
            ze.a().i(TAG, "Flutter init(FlutterOpenData) 触发插件安装");
            invokePlugin(new pb5(this, flutterOpenData) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.2
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

                @Override // com.baidu.tieba.pb5, com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                        super.onResult(i, str, obj);
                        TbLog a = ze.a();
                        a.i(FlutterPluginManager.TAG, "Flutter init(FlutterOpenData) 插件安装完成" + i + " " + str + " " + obj);
                        if (i != 14) {
                            return;
                        }
                        try {
                            if (this.this$0.mIFlutterPlugin == null) {
                                this.this$0.mIFlutterPlugin = (IFlutterPlugin) ((Class) obj).newInstance();
                                this.this$0.mIFlutterPlugin.init();
                            }
                            SafeHandler.getInst().post(new Runnable(this) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.2.1
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
                            TbLog a2 = ze.a();
                            a2.e(FlutterPluginManager.TAG, "Flutter init(FlutterOpenData) 插件安装异常" + th);
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void init(un5 un5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, un5Var) == null) {
            if (this.mIFlutterPlugin == null) {
                ze.a().i(TAG, "Flutter init(INpsPluginInitCallback) 触发插件安装");
                invokePlugin(new IInvokeCallback(this, un5Var) { // from class: com.baidu.tieba.flutter.FlutterPluginManager.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FlutterPluginManager this$0;
                    public final /* synthetic */ un5 val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, un5Var};
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
                        this.val$callback = un5Var;
                    }

                    @Override // com.baidu.nps.main.invoke.IInvokeCallback
                    public void onResult(int i, String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                            TbLog a = ze.a();
                            a.i(FlutterPluginManager.TAG, "Flutter init(INpsPluginInitCallback) 插件安装完成" + i + " " + str + " " + obj);
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
                                TbLog a2 = ze.a();
                                a2.e(FlutterPluginManager.TAG, "Flutter init(INpsPluginInitCallback) 插件安装异常" + th);
                                th.printStackTrace();
                                this.val$callback.onFail();
                            }
                        }
                    }
                });
                return;
            }
            un5Var.onSuccess();
        }
    }
}
