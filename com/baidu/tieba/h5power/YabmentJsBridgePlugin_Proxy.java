package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qga;
import com.baidu.tieba.rga;
import com.baidu.tieba.sga;
import com.baidu.tieba.uga;
import com.baidu.tieba.vl6;
import com.baidu.tieba.wx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.bind.TypeAdapters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class YabmentJsBridgePlugin_Proxy extends qga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wx4 mJsBridge;

    public YabmentJsBridgePlugin_Proxy(wx4 wx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = wx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("tbPayResult");
    }

    @Override // com.baidu.tieba.qga
    public sga dispatch(WebView webView, uga ugaVar, sga sgaVar) {
        InterceptResult invokeLLL;
        sga sgaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ugaVar, sgaVar)) == null) {
            if (sgaVar == null) {
                sgaVar2 = new sga();
            } else {
                sgaVar2 = sgaVar;
            }
            String b = ugaVar.b();
            JSONObject e = ugaVar.e();
            if (b.equals("yabment/tbYab")) {
                sgaVar2.s(true);
                sga c = this.mJsBridge.c(webView, e.optString("pId"), e.optInt("money"), e.optInt(TypeAdapters.AnonymousClass27.MONTH), e.optInt("isAutoYab"), e.optString("yabChannel"), e.optString("vipType"), e.optString("propsId"), e.optString("sceneId"), e.optString("referPage"), e.optString("clickZone"), e.optString("fromScene"), e.optInt("isRetry"), e.optString("posKey"), e.optBoolean("isTouristMode"), e.optBoolean("isRestoreMode"), e.optString("ext"), e.optString("yabmentType"), e.optString("goodId"), e.optString("from"));
                this.mNotificationNameList.add("tbPayResult");
                if (c != null) {
                    sgaVar2.y(c.f());
                    sgaVar2.u(c.b());
                    sgaVar2.o(c.a());
                    sgaVar2.x(c.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver(webView, "tbPayResult", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            }
            return sgaVar2;
        }
        return (sga) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qga
    public List<sga> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            sga sgaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("tbPayResult")) {
                sgaVar = this.mJsBridge.d(webView, hashMap);
            }
            if (sgaVar != null) {
                sgaVar.z(0);
            }
            List<rga> list = this.mAsyncCallBackMethodList.get(str);
            if (sgaVar != null && list != null) {
                Iterator<rga> it = list.iterator();
                if (!TextUtils.isEmpty(sgaVar.e())) {
                    while (it.hasNext()) {
                        rga next = it.next();
                        if (next.b().equals(sgaVar.e())) {
                            sga sgaVar2 = new sga();
                            sgaVar2.w(next.a());
                            sgaVar2.y(sgaVar.f());
                            sgaVar2.u(sgaVar.b());
                            sgaVar2.o(sgaVar.a());
                            sgaVar2.A(sgaVar.l());
                            arrayList.add(sgaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rga next2 = it.next();
                        sga sgaVar3 = new sga();
                        sgaVar3.w(next2.a());
                        sgaVar3.y(sgaVar.f());
                        sgaVar3.u(sgaVar.b());
                        sgaVar3.o(sgaVar.a());
                        sgaVar3.A(sgaVar.l());
                        arrayList.add(sgaVar3);
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

    @Override // com.baidu.tieba.qga
    public vl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (vl6) invokeV.objValue;
    }
}
