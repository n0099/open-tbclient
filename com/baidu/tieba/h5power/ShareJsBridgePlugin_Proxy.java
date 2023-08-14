package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.ica;
import com.baidu.tieba.jca;
import com.baidu.tieba.kca;
import com.baidu.tieba.mca;
import com.baidu.tieba.qk6;
import com.baidu.tieba.qx4;
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
public class ShareJsBridgePlugin_Proxy extends ica {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qx4 mJsBridge;

    public ShareJsBridgePlugin_Proxy(qx4 qx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = qx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
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
            if (b.equals("share/registerShareDataNew")) {
                kcaVar2.s(true);
                kca d = this.mJsBridge.d(webView, e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (d != null) {
                    kcaVar2.y(d.f());
                    kcaVar2.u(d.b());
                    kcaVar2.o(d.a());
                    kcaVar2.x(d.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("share/share")) {
                kcaVar2.s(true);
                kca f = this.mJsBridge.f(webView, e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (f != null) {
                    kcaVar2.y(f.f());
                    kcaVar2.u(f.b());
                    kcaVar2.o(f.a());
                    kcaVar2.x(f.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver(webView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, kcaVar2, false);
                    }
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
            kca kcaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                kcaVar = this.mJsBridge.h(webView, hashMap);
            }
            if (kcaVar != null) {
                kcaVar.z(0);
            }
            List<jca> list = this.mAsyncCallBackMethodList.get(str);
            if (kcaVar != null && list != null) {
                Iterator<jca> it = list.iterator();
                if (!TextUtils.isEmpty(kcaVar.e())) {
                    while (it.hasNext()) {
                        jca next = it.next();
                        if (next.b().equals(kcaVar.e())) {
                            kca kcaVar2 = new kca();
                            kcaVar2.w(next.a());
                            kcaVar2.y(kcaVar.f());
                            kcaVar2.u(kcaVar.b());
                            kcaVar2.o(kcaVar.a());
                            kcaVar2.A(kcaVar.l());
                            arrayList.add(kcaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        jca next2 = it.next();
                        kca kcaVar3 = new kca();
                        kcaVar3.w(next2.a());
                        kcaVar3.y(kcaVar.f());
                        kcaVar3.u(kcaVar.b());
                        kcaVar3.o(kcaVar.a());
                        kcaVar3.A(kcaVar.l());
                        arrayList.add(kcaVar3);
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
