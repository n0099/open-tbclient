package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class hz4 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public Bundle l;
    public HashMap<String, Serializable> m;

    public hz4 i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) ? this : (hz4) invokeZ.objValue;
    }

    public hz4(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = "";
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = false;
        this.i = false;
        this.j = false;
        this.l = null;
        this.m = null;
        this.a = context;
        this.b = str;
    }

    public static hz4 j(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            return new hz4(context, str);
        }
        return (hz4) invokeLL.objValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65538, null) != null) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        new PvThread("open_webview", true).start();
    }

    public TbWebViewActivityConfig b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return e(this.a);
        }
        return (TbWebViewActivityConfig) invokeV.objValue;
    }

    public void p() {
        TbWebViewActivityConfig e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (e = e(this.a)) != null) {
            e.start();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!TbadkCoreApplication.getInst().isDebugMode() && !GlobalBuildConfig.isTiebaDebugTool()) {
                throw new RuntimeException("can't open debug page in release");
            }
            this.b = "http://bjhw-bac-orp-tieba-core-137287.bjhw.baidu.com:8899/na-h5-tool";
            p();
        }
    }

    public hz4 a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            this.l = bundle;
            if (bundle != null) {
                String string = bundle.getString(BdUniDispatchSchemeController.PARAM_INIT_DATA, "");
                if (!TextUtils.isEmpty(string)) {
                    if (this.m == null) {
                        this.m = new HashMap<>();
                    }
                    this.m.put(BdUniDispatchSchemeController.PARAM_INIT_DATA, string);
                }
            }
            return this;
        }
        return (hz4) invokeL.objValue;
    }

    public hz4 c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.f = z;
            return this;
        }
        return (hz4) invokeZ.objValue;
    }

    public hz4 d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.i = z;
            return this;
        }
        return (hz4) invokeZ.objValue;
    }

    public hz4 f(HashMap<String, Serializable> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hashMap)) == null) {
            this.m = hashMap;
            return this;
        }
        return (hz4) invokeL.objValue;
    }

    public hz4 g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.g = z;
            return this;
        }
        return (hz4) invokeZ.objValue;
    }

    public hz4 h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.j = z;
            return this;
        }
        return (hz4) invokeZ.objValue;
    }

    public hz4 k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.e = z;
            return this;
        }
        return (hz4) invokeZ.objValue;
    }

    public hz4 l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.h = z;
            return this;
        }
        return (hz4) invokeZ.objValue;
    }

    public hz4 m(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.d = z;
            return this;
        }
        return (hz4) invokeZ.objValue;
    }

    public hz4 o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            this.k = i;
            return this;
        }
        return (hz4) invokeI.objValue;
    }

    public hz4 r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (hz4) invokeL.objValue;
    }

    public final TbWebViewActivityConfig e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            n();
            try {
                if (StringUtils.isNull(this.b)) {
                    return null;
                }
                boolean z = this.g;
                if (!UrlUtils.isBaiduDomain(this.b)) {
                    z = false;
                }
                if (this.l != null && !this.l.getBoolean(BaseWebViewActivity.BUNDLE_NEED_EXTRA_PARAM, true)) {
                    z = false;
                }
                if (z) {
                    String appendCuidParam = BrowserHelper.appendCuidParam(this.b);
                    this.b = appendCuidParam;
                    String appendVersionCode = BrowserHelper.appendVersionCode(appendCuidParam);
                    this.b = appendVersionCode;
                    this.b = BrowserHelper.appendClientType(appendVersionCode);
                }
                TbWebViewActivityConfig activityConfig = BrowserHelper.getActivityConfig(context, this.c, this.b, this.d, this.e, this.f, !km6.b(this.m));
                activityConfig.setNeedImmerSiveSticky(this.h);
                activityConfig.setFixTitle(this.i);
                activityConfig.setAutoPlay(this.j);
                if (this.k > 0) {
                    activityConfig.setRequestCode(this.k);
                    activityConfig.setIntentAction(IntentAction.ActivityForResult);
                }
                activityConfig.setBundle(this.l);
                if (!km6.b(this.m)) {
                    activityConfig.setPageData(this.m);
                }
                if (this.l != null) {
                    if (this.l.getBoolean(WebViewActivityConfig.TAG_TEXT_AUTO_SIZE, false)) {
                        activityConfig.setTextAutoSize(true);
                    }
                    String string = this.l.getString(WebViewActivityConfig.TAG_PAGE_TRANSLUCENT, "");
                    if (!TextUtils.isEmpty(string)) {
                        activityConfig.setPageTranslucent(string);
                    }
                    if (this.l.getBoolean(WebViewActivityConfig.TAG_TRANSLUCENT_AUTO_CLOSE, false)) {
                        activityConfig.setTranslucentAutoClose(true);
                    }
                    String string2 = this.l.getString(WebViewActivityConfig.TAG_WEB_DIALOG_NAME, "");
                    if (!TextUtils.isEmpty(string2)) {
                        activityConfig.setWebDialogName(string2);
                    }
                    if ("1".equals(this.l.getString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE))) {
                        activityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                        activityConfig.setLoadingSwitch(1);
                        activityConfig.setLoadingStyle(1);
                    } else if ("2".equals(this.l.getString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE))) {
                        activityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                    }
                }
                if (n) {
                    activityConfig.setUseCustomHistoryStack(true);
                    n = false;
                }
                if (this.l != null && this.l.getBoolean(WebViewActivityConfig.FROM_SCHEMA)) {
                    activityConfig.setIsFromSchema(true);
                }
                return activityConfig;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (TbWebViewActivityConfig) invokeL.objValue;
    }
}
