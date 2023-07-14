package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.in6;
import com.baidu.tieba.oda;
import com.baidu.tieba.qda;
import com.baidu.tieba.sda;
import com.baidu.tieba.sy4;
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
public class ToastJsBridgePlugin_Proxy extends oda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sy4 mJsBridge;

    public ToastJsBridgePlugin_Proxy(sy4 sy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = sy4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.oda
    public qda dispatch(WebView webView, sda sdaVar, qda qdaVar) {
        InterceptResult invokeLLL;
        qda qdaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, sdaVar, qdaVar)) == null) {
            if (qdaVar == null) {
                qdaVar2 = new qda();
            } else {
                qdaVar2 = qdaVar;
            }
            String b = sdaVar.b();
            JSONObject e = sdaVar.e();
            if (b.equals("toast/toastPopupView")) {
                qdaVar2.s(true);
                qda f = this.mJsBridge.f(webView, e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (f != null) {
                    qdaVar2.y(f.f());
                    qdaVar2.u(f.b());
                    qdaVar2.o(f.a());
                    qdaVar2.x(f.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                qdaVar2.s(true);
                qda g = this.mJsBridge.g(webView, e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (g != null) {
                    qdaVar2.y(g.f());
                    qdaVar2.u(g.b());
                    qdaVar2.o(g.a());
                    qdaVar2.x(g.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                qdaVar2.s(true);
                qda e2 = this.mJsBridge.e(webView, e.optString("url"));
                if (e2 != null) {
                    qdaVar2.y(e2.f());
                    qdaVar2.u(e2.b());
                    qdaVar2.o(e2.a());
                    qdaVar2.x(e2.e());
                }
                qdaVar2.z(0);
            }
            return qdaVar2;
        }
        return (qda) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.oda
    public in6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (in6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oda
    public List<qda> processNotification(WebView webView, String str, HashMap hashMap) {
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
