package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.NadNativeBrowserView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class d71 extends WebChromeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y61 a;
    public NadNativeBrowserView b;

    @RequiresApi(21)
    /* loaded from: classes5.dex */
    public static final class a implements a41 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WebChromeClient.FileChooserParams a;

        public a(WebChromeClient.FileChooserParams fileChooserParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fileChooserParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fileChooserParams;
        }

        @Override // com.baidu.tieba.a41
        public Intent a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                WebChromeClient.FileChooserParams fileChooserParams = this.a;
                if (fileChooserParams != null) {
                    return fileChooserParams.createIntent();
                }
                return null;
            }
            return (Intent) invokeV.objValue;
        }

        @Override // com.baidu.tieba.a41
        public String[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                WebChromeClient.FileChooserParams fileChooserParams = this.a;
                if (fileChooserParams != null) {
                    return fileChooserParams.getAcceptTypes();
                }
                return null;
            }
            return (String[]) invokeV.objValue;
        }

        @Override // com.baidu.tieba.a41
        public int getMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                WebChromeClient.FileChooserParams fileChooserParams = this.a;
                if (fileChooserParams != null) {
                    return fileChooserParams.getMode();
                }
                return -1;
            }
            return invokeV.intValue;
        }
    }

    public d71(NadNativeBrowserView webView, y61 y61Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, y61Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.a = y61Var;
        this.b = webView;
    }

    public final Activity a(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, webView)) == null) {
            if (webView == null) {
                return null;
            }
            if (webView.getContext() instanceof Activity) {
                Context context = webView.getContext();
                if (context != null) {
                    return (Activity) context;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            } else if (!(webView.getContext() instanceof MutableContextWrapper)) {
                return null;
            } else {
                Context context2 = webView.getContext();
                if (context2 != null) {
                    if (!(((MutableContextWrapper) context2).getBaseContext() instanceof Activity)) {
                        return null;
                    }
                    Context context3 = webView.getContext();
                    if (context3 != null) {
                        Context baseContext = ((MutableContextWrapper) context3).getBaseContext();
                        if (baseContext != null) {
                            return (Activity) baseContext;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.content.MutableContextWrapper");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.content.MutableContextWrapper");
            }
        }
        return (Activity) invokeL.objValue;
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
                createBitmap.eraseColor(0);
                return createBitmap;
            } catch (Exception unused) {
                return super.getDefaultVideoPoster();
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, webView, i) == null) {
            super.onProgressChanged(webView, i);
            y61 y61Var = this.a;
            if (y61Var != null) {
                y61Var.a(this.b, i);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) {
            super.onReceivedTitle(webView, str);
            y61 y61Var = this.a;
            if (y61Var != null) {
                y61Var.b(this.b, str);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, webView) == null) {
            super.onRequestFocus(webView);
            y61 y61Var = this.a;
            if (y61Var != null) {
                y61Var.c(this.b);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, valueCallback, fileChooserParams)) == null) {
            this.b.W();
            Activity a2 = a(webView);
            if (a2 != null && Build.VERSION.SDK_INT >= 21) {
                return d41.h(a2, valueCallback, new a(fileChooserParams));
            }
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
