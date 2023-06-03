package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.sl6;
import com.baidu.tieba.uy9;
import com.baidu.tieba.vy4;
import com.baidu.tieba.wy9;
import com.baidu.tieba.yy9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ToastJsBridgePlugin_Proxy extends uy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vy4 mJsBridge;

    public ToastJsBridgePlugin_Proxy(vy4 vy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = vy4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.uy9
    public wy9 dispatch(WebView webView, yy9 yy9Var, wy9 wy9Var) {
        InterceptResult invokeLLL;
        wy9 wy9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, yy9Var, wy9Var)) == null) {
            if (wy9Var == null) {
                wy9Var2 = new wy9();
            } else {
                wy9Var2 = wy9Var;
            }
            String b = yy9Var.b();
            JSONObject e = yy9Var.e();
            if (b.equals("toast/toastPopupView")) {
                wy9Var2.s(true);
                wy9 f = this.mJsBridge.f(webView, e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (f != null) {
                    wy9Var2.y(f.f());
                    wy9Var2.u(f.b());
                    wy9Var2.o(f.a());
                    wy9Var2.x(f.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                wy9Var2.s(true);
                wy9 g = this.mJsBridge.g(webView, e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (g != null) {
                    wy9Var2.y(g.f());
                    wy9Var2.u(g.b());
                    wy9Var2.o(g.a());
                    wy9Var2.x(g.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("toast/getModalData")) {
                wy9Var2.s(true);
                wy9 e2 = this.mJsBridge.e(webView, e.optString("url"));
                if (e2 != null) {
                    wy9Var2.y(e2.f());
                    wy9Var2.u(e2.b());
                    wy9Var2.o(e2.a());
                    wy9Var2.x(e2.e());
                }
                wy9Var2.z(0);
            }
            return wy9Var2;
        }
        return (wy9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.uy9
    public sl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (sl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uy9
    public List<wy9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            if (!TextUtils.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
