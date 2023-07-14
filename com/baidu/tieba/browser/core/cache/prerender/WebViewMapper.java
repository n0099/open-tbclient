package com.baidu.tieba.browser.core.cache.prerender;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fo6;
import com.baidu.tieba.sk6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class WebViewMapper extends LinkedHashMap<String, WebView> implements Map<String, WebView> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SIZE = 8;
    public static volatile WebViewMapper instance;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, WebView> mWebViews;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewMapper() {
        super(8, 0.75f, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue(), ((Boolean) objArr[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWebViews = new HashMap<>();
    }

    public static WebViewMapper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (instance == null) {
                synchronized (WebViewMapper.class) {
                    if (instance == null) {
                        instance = new WebViewMapper();
                    }
                }
            }
            return instance;
        }
        return (WebViewMapper) invokeV.objValue;
    }

    public boolean contain(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!containsKey(str) && !this.mWebViews.containsKey(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, WebView> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, entry)) == null) {
            if (size() > 8) {
                if (entry != null && entry.getValue() != null) {
                    sk6.g().k(entry.getValue());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public synchronized WebView getAndRemove(String str) {
        InterceptResult invokeL;
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                webView = null;
                if (this.mWebViews.containsKey(str)) {
                    webView = this.mWebViews.remove(str);
                }
                if (webView == null) {
                    webView = remove(str);
                }
                if (webView != null) {
                    fo6.d(webView);
                }
            }
            return webView;
        }
        return (WebView) invokeL.objValue;
    }

    public synchronized boolean save(@NonNull String str, @NonNull WebView webView, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, str, webView, z)) == null) {
            synchronized (this) {
                if (z) {
                    if (!containsKey(str)) {
                        put(str, webView);
                    }
                } else if (!this.mWebViews.containsKey(str)) {
                    this.mWebViews.put(str, webView);
                    return true;
                }
                return false;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
