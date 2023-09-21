package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.qka;
import com.baidu.tieba.rka;
import com.baidu.tieba.ska;
import com.baidu.tieba.uka;
import com.baidu.tieba.xm6;
import com.baidu.tieba.zx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ToastJsBridgePlugin_Proxy extends qka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zx4 mJsBridge;

    public ToastJsBridgePlugin_Proxy(zx4 zx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = zx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("showDialog");
    }

    @Override // com.baidu.tieba.qka
    public ska dispatch(WebView webView, uka ukaVar, ska skaVar) {
        InterceptResult invokeLLL;
        ska skaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ukaVar, skaVar)) == null) {
            if (skaVar == null) {
                skaVar2 = new ska();
            } else {
                skaVar2 = skaVar;
            }
            String b = ukaVar.b();
            JSONObject e = ukaVar.e();
            if (b.equals("toast/toastPopupView")) {
                skaVar2.s(true);
                ska skaVar3 = skaVar2;
                ska h = this.mJsBridge.h(webView, e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (h != null) {
                    skaVar3.y(h.f());
                    skaVar3.u(h.b());
                    skaVar3.o(h.a());
                    skaVar3.x(h.e());
                }
                skaVar3.z(0);
                return skaVar3;
            }
            ska skaVar4 = skaVar2;
            if (b.equals("toast/showTipToast")) {
                skaVar4.s(true);
                ska i = this.mJsBridge.i(webView, e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (i != null) {
                    skaVar4.y(i.f());
                    skaVar4.u(i.b());
                    skaVar4.o(i.a());
                    skaVar4.x(i.e());
                }
                skaVar4.z(0);
                return skaVar4;
            } else if (b.equals("toast/getModalData")) {
                skaVar4.s(true);
                ska e2 = this.mJsBridge.e(webView, e.optString("url"));
                if (e2 != null) {
                    skaVar4.y(e2.f());
                    skaVar4.u(e2.b());
                    skaVar4.o(e2.a());
                    skaVar4.x(e2.e());
                }
                skaVar4.z(0);
                return skaVar4;
            } else if (!b.equals("toast/showDialog")) {
                return skaVar4;
            } else {
                skaVar4.s(true);
                ska f = this.mJsBridge.f(webView, e.optInt("type"), e.optString("content"), e.optString("dialogId"));
                this.mNotificationNameList.add("showDialog");
                if (f != null) {
                    skaVar4.y(f.f());
                    skaVar4.u(f.b());
                    skaVar4.o(f.a());
                    skaVar4.x(f.e());
                    if (!skaVar4.h()) {
                        skaVar4.n(false);
                        addObserver(webView, "showDialog", skaVar4, false);
                    }
                }
                skaVar4.z(0);
                return skaVar4;
            }
        }
        return (ska) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qka
    public xm6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (xm6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qka
    public List<ska> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ska skaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("showDialog")) {
                skaVar = this.mJsBridge.g(webView, hashMap);
            }
            if (skaVar != null) {
                skaVar.z(0);
            }
            List<rka> list = this.mAsyncCallBackMethodList.get(str);
            if (skaVar != null && list != null) {
                Iterator<rka> it = list.iterator();
                if (!TextUtils.isEmpty(skaVar.e())) {
                    while (it.hasNext()) {
                        rka next = it.next();
                        if (next.b().equals(skaVar.e())) {
                            ska skaVar2 = new ska();
                            skaVar2.w(next.a());
                            skaVar2.y(skaVar.f());
                            skaVar2.u(skaVar.b());
                            skaVar2.o(skaVar.a());
                            skaVar2.j = skaVar.j;
                            skaVar2.A(skaVar.l());
                            arrayList.add(skaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rka next2 = it.next();
                        ska skaVar3 = new ska();
                        skaVar3.w(next2.a());
                        skaVar3.y(skaVar.f());
                        skaVar3.u(skaVar.b());
                        skaVar3.o(skaVar.a());
                        skaVar3.j = skaVar.j;
                        skaVar3.A(skaVar.l());
                        arrayList.add(skaVar3);
                        if (!next2.c()) {
                            it.remove();
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
