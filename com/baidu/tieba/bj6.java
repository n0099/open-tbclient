package com.baidu.tieba;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.controller.CustomRule;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebContainerActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.browser.exception.TbWebViewException;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pk6;
import com.baidu.tieba.write.WriteWebViewCacheManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class bj6 {
    public static /* synthetic */ Interceptable $ic;
    public static i8c<String, Pair<Boolean, String>> a;
    public static final List<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ok6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tieba.ok6
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return !TextUtils.isEmpty(str);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends CustomRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.controller.MessageRule
        public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                if (!yj6.isOn()) {
                    return customMessage;
                }
                if (customMessage == null) {
                    return null;
                }
                Object data = customMessage.getData();
                if (!(data instanceof TbWebContainerActivityConfig)) {
                    return customMessage;
                }
                Intent intent = ((TbWebContainerActivityConfig) data).getIntent();
                if (intent == null) {
                    return customMessage;
                }
                String stringExtra = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
                if (TextUtils.isEmpty(stringExtra)) {
                    return customMessage;
                }
                if (tj6.a.b(stringExtra)) {
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.e("UrlCountMapHelper", "1s内连续检查到3次相同的url, 发生循环，放弃拦截 url = " + stringExtra);
                    return customMessage;
                }
                TbPageContext<?> currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst().getCurrentActivity());
                if (currentPageContext == null) {
                    return customMessage;
                }
                if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(currentPageContext, new String[]{stringExtra}) == 0) {
                    return null;
                }
                tj6.a.c();
                return customMessage;
            }
            return (CustomMessage) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947646939, "Lcom/baidu/tieba/bj6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947646939, "Lcom/baidu/tieba/bj6;");
                return;
            }
        }
        b = new ArrayList();
    }

    public bj6() {
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

    public static List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (List) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            pk6.a aVar = new pk6.a();
            aVar.c(new a());
            sk6.b().c(aVar);
        }
    }

    public static /* synthetic */ void f() {
        c();
        ml6.a().execute(new Runnable() { // from class: com.baidu.tieba.aj6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    rl6.a();
                }
            }
        });
        cj6.f().i();
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            MessageManager.getInstance().addMessageRule(new b(2002001));
        }
    }

    public static void b(final Application application, bj6 bj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, application, bj6Var) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (kl6.getContext() == null) {
                kl6.b(application);
            }
            if (ll6.a()) {
                nl6.a().f(new Runnable() { // from class: com.baidu.tieba.wi6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            WebView.setWebContentsDebuggingEnabled(true);
                        }
                    }
                });
            }
            nl6.a().c(new Runnable() { // from class: com.baidu.tieba.xi6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        bj6.f();
                    }
                }
            });
            nl6.a().f(new Runnable() { // from class: com.baidu.tieba.yi6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        cj6.f().h(application);
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                uk6.n().r();
                nl6.a().f(new Runnable() { // from class: com.baidu.tieba.zi6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            WriteWebViewCacheManager.f().i();
                        }
                    }
                });
            }
            i();
            im6.b("newHybrid", "init WebView Env 耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public static void d(i8c<String, Pair<Boolean, String>> i8cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, i8cVar) == null) {
            a = i8cVar;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            ll6.b(z);
        }
    }

    public static Pair<Boolean, String> k(String str) throws TbWebViewException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            i8c<String, Pair<Boolean, String>> i8cVar = a;
            if (i8cVar == null) {
                if (!ll6.a()) {
                    return new Pair<>(Boolean.FALSE, null);
                }
                throw new TbWebViewException("TBWebKit need call initUserAgent first !");
            }
            return i8cVar.call(str);
        }
        return (Pair) invokeL.objValue;
    }
}
