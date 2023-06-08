package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.bz9;
import com.baidu.tieba.dz9;
import com.baidu.tieba.ul6;
import com.baidu.tieba.vy4;
import com.baidu.tieba.zy9;
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
public class ToastJsBridgePlugin_Proxy extends zy9 {
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

    @Override // com.baidu.tieba.zy9
    public bz9 dispatch(WebView webView, dz9 dz9Var, bz9 bz9Var) {
        InterceptResult invokeLLL;
        bz9 bz9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, dz9Var, bz9Var)) == null) {
            if (bz9Var == null) {
                bz9Var2 = new bz9();
            } else {
                bz9Var2 = bz9Var;
            }
            String b = dz9Var.b();
            JSONObject e = dz9Var.e();
            if (b.equals("toast/toastPopupView")) {
                bz9Var2.s(true);
                bz9 f = this.mJsBridge.f(webView, e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (f != null) {
                    bz9Var2.y(f.f());
                    bz9Var2.u(f.b());
                    bz9Var2.o(f.a());
                    bz9Var2.x(f.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                bz9Var2.s(true);
                bz9 g = this.mJsBridge.g(webView, e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (g != null) {
                    bz9Var2.y(g.f());
                    bz9Var2.u(g.b());
                    bz9Var2.o(g.a());
                    bz9Var2.x(g.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("toast/getModalData")) {
                bz9Var2.s(true);
                bz9 e2 = this.mJsBridge.e(webView, e.optString("url"));
                if (e2 != null) {
                    bz9Var2.y(e2.f());
                    bz9Var2.u(e2.b());
                    bz9Var2.o(e2.a());
                    bz9Var2.x(e2.e());
                }
                bz9Var2.z(0);
            }
            return bz9Var2;
        }
        return (bz9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public ul6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (ul6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public List<bz9> processNotification(WebView webView, String str, HashMap hashMap) {
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
