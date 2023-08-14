package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.ica;
import com.baidu.tieba.kca;
import com.baidu.tieba.mca;
import com.baidu.tieba.qk6;
import com.baidu.tieba.tx4;
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
public class ToastJsBridgePlugin_Proxy extends ica {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tx4 mJsBridge;

    public ToastJsBridgePlugin_Proxy(tx4 tx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = tx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.ica
    public kca dispatch(WebView webView, mca mcaVar, kca kcaVar) {
        InterceptResult invokeLLL;
        kca kcaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, mcaVar, kcaVar)) == null) {
            if (kcaVar == null) {
                kcaVar2 = new kca();
            } else {
                kcaVar2 = kcaVar;
            }
            String b = mcaVar.b();
            JSONObject e = mcaVar.e();
            if (b.equals("toast/toastPopupView")) {
                kcaVar2.s(true);
                kca f = this.mJsBridge.f(webView, e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (f != null) {
                    kcaVar2.y(f.f());
                    kcaVar2.u(f.b());
                    kcaVar2.o(f.a());
                    kcaVar2.x(f.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                kcaVar2.s(true);
                kca g = this.mJsBridge.g(webView, e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (g != null) {
                    kcaVar2.y(g.f());
                    kcaVar2.u(g.b());
                    kcaVar2.o(g.a());
                    kcaVar2.x(g.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                kcaVar2.s(true);
                kca e2 = this.mJsBridge.e(webView, e.optString("url"));
                if (e2 != null) {
                    kcaVar2.y(e2.f());
                    kcaVar2.u(e2.b());
                    kcaVar2.o(e2.a());
                    kcaVar2.x(e2.e());
                }
                kcaVar2.z(0);
            }
            return kcaVar2;
        }
        return (kca) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ica
    public qk6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qk6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ica
    public List<kca> processNotification(WebView webView, String str, HashMap hashMap) {
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
