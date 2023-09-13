package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes5.dex */
public final class ee7 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947731538, "Lcom/baidu/tieba/ee7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947731538, "Lcom/baidu/tieba/ee7;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        public final l97 a(String iconUrl) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iconUrl)) == null) {
                Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
                if (TextUtils.isEmpty(iconUrl)) {
                    return null;
                }
                int i = 0;
                if (StringsKt__StringsJVMKt.startsWith$default(iconUrl, "local://icon/", false, 2, null)) {
                    Uri parse = Uri.parse(iconUrl);
                    List<String> pathSegments = parse.getPathSegments();
                    if (pathSegments.size() > 0) {
                        boolean z = true;
                        int identifier = a67.a.getResources().getIdentifier(pathSegments.get(pathSegments.size() - 1), ResourceManager.DRAWABLE, a67.a.getPackageName());
                        String queryParameter = parse.getQueryParameter("type");
                        if (queryParameter == null) {
                            queryParameter = "";
                        }
                        int identifier2 = a67.a.getResources().getIdentifier(parse.getQueryParameter("color"), "color", a67.a.getPackageName());
                        String queryParameter2 = parse.getQueryParameter(CriusAttrConstants.PADDING);
                        if (queryParameter2 != null && queryParameter2.length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            i = BdUtilHelper.getDimens(a67.a, a67.a.getResources().getIdentifier(queryParameter2, EMABTest.TYPE_DIMEN, a67.a.getPackageName()));
                        }
                        if (identifier > 0) {
                            return new l97(identifier, queryParameter, identifier2, i);
                        }
                    }
                }
                return null;
            }
            return (l97) invokeL.objValue;
        }

        public final String b(h97 iconData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iconData)) == null) {
                Intrinsics.checkNotNullParameter(iconData, "iconData");
                String b = iconData.b();
                int currentSkinType = SkinManager.getCurrentSkinType();
                if (currentSkinType != 0) {
                    if (currentSkinType == 4) {
                        return iconData.a();
                    }
                    return b;
                }
                return iconData.b();
            }
            return (String) invokeL.objValue;
        }
    }
}
