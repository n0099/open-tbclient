package com.baidu.tieba;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.webwrite.ability.LocalFileInterceptorKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes5.dex */
public final class eza implements wm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> a;
    public final WriteData b;
    public fza c;

    public eza(HashMap<String, String> pathInfo, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pathInfo, writeData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pathInfo, "pathInfo");
        Intrinsics.checkNotNullParameter(writeData, "writeData");
        this.a = pathInfo;
        this.b = writeData;
    }

    @Override // com.baidu.tieba.wm6
    public WebResourceResponse a(WebView view2, WebResourceRequest request) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, request)) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            Uri u = request.getUrl();
            String scheme = u.getScheme();
            if (scheme != null) {
                int hashCode = scheme.hashCode();
                if (hashCode != -787290468) {
                    if (hashCode != 1366925564) {
                        if (hashCode == 1378998483 && scheme.equals("com.baidu.tieba.voice")) {
                            Intrinsics.checkNotNullExpressionValue(u, "u");
                            return LocalFileInterceptorKt.c(u, request);
                        }
                        return null;
                    } else if (scheme.equals("com.baidu.tieba.image")) {
                        HashMap<String, String> hashMap = this.a;
                        WriteData writeData = this.b;
                        fza fzaVar = this.c;
                        Intrinsics.checkNotNullExpressionValue(u, "u");
                        return LocalFileInterceptorKt.b(hashMap, writeData, fzaVar, u, request);
                    } else {
                        return null;
                    }
                } else if (scheme.equals("com.baidu.tieba.face")) {
                    Intrinsics.checkNotNullExpressionValue(u, "u");
                    return LocalFileInterceptorKt.a(u, request);
                } else {
                    return null;
                }
            }
            return null;
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public final void b(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo) == null) && imageFileInfo != null) {
            String b = exa.b(imageFileInfo);
            if (StringsKt__StringsKt.contains$default((CharSequence) b, (CharSequence) "?t=", false, 2, (Object) null)) {
                b = b.substring(0, StringsKt__StringsKt.lastIndexOf$default((CharSequence) b, "?t=", 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(b, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            this.a.put(b, exa.a(imageFileInfo));
        }
    }

    public final void c(fza fzaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fzaVar) == null) {
            this.c = fzaVar;
        }
    }
}
