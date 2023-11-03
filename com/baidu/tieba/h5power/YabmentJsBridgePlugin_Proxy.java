package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cj6;
import com.baidu.tieba.lsa;
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.psa;
import com.baidu.tieba.zs4;
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
public class YabmentJsBridgePlugin_Proxy extends lsa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zs4 mJsBridge;

    public YabmentJsBridgePlugin_Proxy(zs4 zs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zs4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = zs4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("tbPayResult");
    }

    @Override // com.baidu.tieba.lsa
    public nsa dispatch(WebView webView, psa psaVar, nsa nsaVar) {
        InterceptResult invokeLLL;
        nsa nsaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, psaVar, nsaVar)) == null) {
            if (nsaVar == null) {
                nsaVar2 = new nsa();
            } else {
                nsaVar2 = nsaVar;
            }
            String b = psaVar.b();
            JSONObject e = psaVar.e();
            if (b.equals("yabment/tbYab")) {
                nsaVar2.s(true);
                nsa c = this.mJsBridge.c(webView, e.optString("pId"), e.optInt("money"), e.optInt(TypeAdapters.AnonymousClass27.MONTH), e.optInt("isAutoYab"), e.optString("yabChannel"), e.optString("vipType"), e.optString("propsId"), e.optString("sceneId"), e.optString("referPage"), e.optString("clickZone"), e.optString("fromScene"), e.optInt("isRetry"), e.optString("posKey"), e.optBoolean("isTouristMode"), e.optBoolean("isRestoreMode"), e.optString("ext"), e.optString("yabmentType"), e.optString("goodId"), e.optString("from"));
                this.mNotificationNameList.add("tbPayResult");
                if (c != null) {
                    nsaVar2.y(c.f());
                    nsaVar2.u(c.b());
                    nsaVar2.o(c.a());
                    nsaVar2.x(c.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, "tbPayResult", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            }
            return nsaVar2;
        }
        return (nsa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public List<nsa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            nsa nsaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("tbPayResult")) {
                nsaVar = this.mJsBridge.d(webView, hashMap);
            }
            if (nsaVar != null) {
                nsaVar.z(0);
            }
            List<msa> list = this.mAsyncCallBackMethodList.get(str);
            if (nsaVar != null && list != null) {
                Iterator<msa> it = list.iterator();
                if (!TextUtils.isEmpty(nsaVar.e())) {
                    while (it.hasNext()) {
                        msa next = it.next();
                        if (next.b().equals(nsaVar.e())) {
                            nsa nsaVar2 = new nsa();
                            nsaVar2.w(next.a());
                            nsaVar2.y(nsaVar.f());
                            nsaVar2.u(nsaVar.b());
                            nsaVar2.o(nsaVar.a());
                            nsaVar2.j = nsaVar.j;
                            nsaVar2.A(nsaVar.l());
                            arrayList.add(nsaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        msa next2 = it.next();
                        nsa nsaVar3 = new nsa();
                        nsaVar3.w(next2.a());
                        nsaVar3.y(nsaVar.f());
                        nsaVar3.u(nsaVar.b());
                        nsaVar3.o(nsaVar.a());
                        nsaVar3.j = nsaVar.j;
                        nsaVar3.A(nsaVar.l());
                        arrayList.add(nsaVar3);
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

    @Override // com.baidu.tieba.lsa
    public cj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (cj6) invokeV.objValue;
    }
}
