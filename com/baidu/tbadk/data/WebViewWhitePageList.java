package com.baidu.tbadk.data;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.JsNativeDomainWhiteListListener;
import com.baidu.tbadk.data.WebViewWhitePageList;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.kl6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.x45;
import com.baidu.tieba.za5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/tbadk/data/WebViewWhitePageList;", "", "()V", "CONFIG_KEY", "", "SP_KEY", JsNativeDomainWhiteListListener.WHITELIST, "", "isHit", "", "url", "Parser", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebViewWhitePageList {
    public static /* synthetic */ Interceptable $ic;
    public static final WebViewWhitePageList a;
    public static List<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    @Singleton
    @Service
    /* loaded from: classes5.dex */
    public static final class a implements za5 {
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
                    return;
                }
            }
            kl6.h(new kl6.b() { // from class: com.baidu.tieba.qc5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.kl6.b
                public final boolean a(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) ? WebViewWhitePageList.a.a(str) : invokeL.booleanValue;
                }
            });
        }

        public static final boolean a(String url) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, url)) == null) {
                Intrinsics.checkNotNullParameter(url, "url");
                return WebViewWhitePageList.c(url);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.za5
        public void parseJson(JSONObject json) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, json) == null) {
                Intrinsics.checkNotNullParameter(json, "json");
                try {
                    String arrayJson = json.optString("webviewWhiteMonitorWhiteList");
                    Intrinsics.checkNotNullExpressionValue(arrayJson, "arrayJson");
                    if (arrayJson.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        x45.g("WebViewWhitePageCheck-webviewWhiteMonitorWhiteList", null);
                        return;
                    }
                    WebViewWhitePageList webViewWhitePageList = WebViewWhitePageList.a;
                    WebViewWhitePageList.b = DataExt.toEntityList(arrayJson, String.class);
                    x45.g("WebViewWhitePageCheck-webviewWhiteMonitorWhiteList", arrayJson);
                } catch (Exception e) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("WebViewWhitePageCheck", "插件配置数据解析失败" + e.getMessage());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(811892316, "Lcom/baidu/tbadk/data/WebViewWhitePageList;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(811892316, "Lcom/baidu/tbadk/data/WebViewWhitePageList;");
                return;
            }
        }
        a = new WebViewWhitePageList();
        x45.e("WebViewWhitePageCheck-webviewWhiteMonitorWhiteList", null, AnonymousClass1.INSTANCE, 2, null);
    }

    public WebViewWhitePageList() {
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

    @JvmStatic
    public static final boolean c(String url) {
        InterceptResult invokeL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, url)) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            String path = Uri.parse(url).getPath();
            if (path == null || (list = b) == null) {
                return false;
            }
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            for (String str : list) {
                if (StringsKt__StringsJVMKt.startsWith$default(path, str, false, 2, null)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
