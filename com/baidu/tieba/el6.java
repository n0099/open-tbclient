package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.schemedispatch.forbid.InvokeStatisticKt;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.dl6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class el6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements il6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl6.a a;

        public a(dl6.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tieba.il6
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.a(2, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements il6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl6.a a;

        public b(dl6.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tieba.il6
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.a(2, i);
            }
        }
    }

    public static boolean a(Context context, Uri uri, Bundle bundle, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, uri, bundle, Boolean.valueOf(z)})) == null) {
            return b(context, uri, null, bundle, z);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(Context context, Uri uri, dl6 dl6Var, Bundle bundle, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, uri, dl6Var, bundle, Boolean.valueOf(z)})) == null) {
            dl6.a aVar = new dl6.a();
            if (uri == null) {
                if (dl6Var != null) {
                    dl6Var.b(1, "Uri is empty.", aVar);
                }
                return false;
            } else if (!InvokeStatisticKt.SCHEME_INVOKE_PAGE_DEEPLINK.equals(uri.getHost())) {
                if (dl6Var != null) {
                    dl6Var.b(2, "Uri host is not deeplink.", aVar);
                }
                return false;
            } else {
                String queryParameter = uri.getQueryParameter(DeepLinkItem.DEEPLINK_APPURL_KEY);
                String queryParameter2 = uri.getQueryParameter(DeepLinkItem.DEEPLINK_MARKETURL_KEY);
                String queryParameter3 = uri.getQueryParameter(DeepLinkItem.DEEPLINK_WEBURL_KEY);
                String queryParameter4 = uri.getQueryParameter("pkgName");
                String queryParameter5 = uri.getQueryParameter(DeepLinkItem.DEEPLINK_MARKET_PKGNAME_KEY);
                boolean booleanQueryParameter = uri.getBooleanQueryParameter(DeepLinkItem.DEEPLINK_IS_DESIGNATE_PKG, true);
                if (e(context, queryParameter, queryParameter4, dl6Var, booleanQueryParameter, aVar) || f(context, queryParameter2, queryParameter5, dl6Var, booleanQueryParameter, aVar)) {
                    return true;
                }
                return g(context, queryParameter3, bundle, dl6Var, aVar, z);
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean c(Context context, String str, String str2, boolean z, il6 il6Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Boolean.valueOf(z), il6Var})) == null) {
            try {
                Intent b2 = jl6.b(context, str, str2, z, il6Var);
                if (b2 == null) {
                    return false;
                }
                context.startActivity(b2);
                return true;
            } catch (Exception unused) {
                if (il6Var != null) {
                    il6Var.onFailed(-101);
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean d(Context context, String str, Bundle bundle, boolean z) {
        InterceptResult invokeCommon;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, bundle, Boolean.valueOf(z)})) == null) {
            String[] strArr = {str};
            UrlManager urlManager = UrlManager.getInstance();
            if (urlManager == null || (tbPageContext = (TbPageContext) k4.a(context)) == null) {
                return false;
            }
            if (urlManager.UrlValidated(str)) {
                urlManager.dealOneLink(tbPageContext, strArr, true);
                return true;
            }
            return urlManager.dealOneLink(tbPageContext, strArr);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean e(Context context, String str, String str2, dl6 dl6Var, boolean z, dl6.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, dl6Var, Boolean.valueOf(z), aVar})) == null) {
            if (TextUtils.isEmpty(str)) {
                aVar.a(1, -4);
                return false;
            } else if (!c(context, str, str2, z, new a(aVar))) {
                return false;
            } else {
                aVar.b(1);
                if (dl6Var != null) {
                    dl6Var.a(1, aVar);
                }
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean f(Context context, String str, String str2, dl6 dl6Var, boolean z, dl6.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, str, str2, dl6Var, Boolean.valueOf(z), aVar})) == null) {
            if (TextUtils.isEmpty(str)) {
                aVar.a(2, -5);
                return false;
            } else if (!c(context, str, str2, z, new b(aVar))) {
                return false;
            } else {
                aVar.b(2);
                if (dl6Var != null) {
                    dl6Var.a(2, aVar);
                    return true;
                }
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean g(Context context, String str, Bundle bundle, dl6 dl6Var, dl6.a aVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, str, bundle, dl6Var, aVar, Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                aVar.a(3, -6);
                if (dl6Var != null) {
                    dl6Var.b(-6, "Uri web url is empty", aVar);
                }
                return false;
            } else if (d(context, str, bundle, z)) {
                aVar.b(3);
                if (dl6Var != null) {
                    dl6Var.a(3, aVar);
                    return true;
                }
                return true;
            } else {
                aVar.a(3, -7);
                if (dl6Var != null) {
                    dl6Var.b(-7, "Uri web url open failed", aVar);
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
