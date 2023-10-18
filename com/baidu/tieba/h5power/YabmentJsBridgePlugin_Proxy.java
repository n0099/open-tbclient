package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gfa;
import com.baidu.tieba.gh6;
import com.baidu.tieba.hfa;
import com.baidu.tieba.ifa;
import com.baidu.tieba.is4;
import com.baidu.tieba.kfa;
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
public class YabmentJsBridgePlugin_Proxy extends gfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public is4 mJsBridge;

    public YabmentJsBridgePlugin_Proxy(is4 is4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {is4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = is4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("tbPayResult");
    }

    @Override // com.baidu.tieba.gfa
    public ifa dispatch(WebView webView, kfa kfaVar, ifa ifaVar) {
        InterceptResult invokeLLL;
        ifa ifaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, kfaVar, ifaVar)) == null) {
            if (ifaVar == null) {
                ifaVar2 = new ifa();
            } else {
                ifaVar2 = ifaVar;
            }
            String b = kfaVar.b();
            JSONObject e = kfaVar.e();
            if (b.equals("yabment/tbYab")) {
                ifaVar2.s(true);
                ifa c = this.mJsBridge.c(webView, e.optString("pId"), e.optInt("money"), e.optInt(TypeAdapters.AnonymousClass27.MONTH), e.optInt("isAutoYab"), e.optString("yabChannel"), e.optString("vipType"), e.optString("propsId"), e.optString("sceneId"), e.optString("referPage"), e.optString("clickZone"), e.optString("fromScene"), e.optInt("isRetry"), e.optString("posKey"), e.optBoolean("isTouristMode"), e.optBoolean("isRestoreMode"), e.optString("ext"), e.optString("yabmentType"), e.optString("goodId"), e.optString("from"));
                this.mNotificationNameList.add("tbPayResult");
                if (c != null) {
                    ifaVar2.y(c.f());
                    ifaVar2.u(c.b());
                    ifaVar2.o(c.a());
                    ifaVar2.x(c.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver(webView, "tbPayResult", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            }
            return ifaVar2;
        }
        return (ifa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.gfa
    public List<ifa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ifa ifaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("tbPayResult")) {
                ifaVar = this.mJsBridge.d(webView, hashMap);
            }
            if (ifaVar != null) {
                ifaVar.z(0);
            }
            List<hfa> list = this.mAsyncCallBackMethodList.get(str);
            if (ifaVar != null && list != null) {
                Iterator<hfa> it = list.iterator();
                if (!TextUtils.isEmpty(ifaVar.e())) {
                    while (it.hasNext()) {
                        hfa next = it.next();
                        if (next.b().equals(ifaVar.e())) {
                            ifa ifaVar2 = new ifa();
                            ifaVar2.w(next.a());
                            ifaVar2.y(ifaVar.f());
                            ifaVar2.u(ifaVar.b());
                            ifaVar2.o(ifaVar.a());
                            ifaVar2.j = ifaVar.j;
                            ifaVar2.A(ifaVar.l());
                            arrayList.add(ifaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        hfa next2 = it.next();
                        ifa ifaVar3 = new ifa();
                        ifaVar3.w(next2.a());
                        ifaVar3.y(ifaVar.f());
                        ifaVar3.u(ifaVar.b());
                        ifaVar3.o(ifaVar.a());
                        ifaVar3.j = ifaVar.j;
                        ifaVar3.A(ifaVar.l());
                        arrayList.add(ifaVar3);
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

    @Override // com.baidu.tieba.gfa
    public gh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (gh6) invokeV.objValue;
    }
}
