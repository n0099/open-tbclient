package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.r0a;
import com.baidu.tieba.s0a;
import com.baidu.tieba.t0a;
import com.baidu.tieba.ty4;
import com.baidu.tieba.v0a;
import com.baidu.tieba.zl6;
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
public class ShareJsBridgePlugin_Proxy extends r0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ty4 mJsBridge;

    public ShareJsBridgePlugin_Proxy(ty4 ty4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ty4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ty4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
    }

    @Override // com.baidu.tieba.r0a
    public t0a dispatch(WebView webView, v0a v0aVar, t0a t0aVar) {
        InterceptResult invokeLLL;
        t0a t0aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, v0aVar, t0aVar)) == null) {
            if (t0aVar == null) {
                t0aVar2 = new t0a();
            } else {
                t0aVar2 = t0aVar;
            }
            String b = v0aVar.b();
            JSONObject e = v0aVar.e();
            if (b.equals("share/registerShareDataNew")) {
                t0aVar2.s(true);
                t0a d = this.mJsBridge.d(webView, e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (d != null) {
                    t0aVar2.y(d.f());
                    t0aVar2.u(d.b());
                    t0aVar2.o(d.a());
                    t0aVar2.x(d.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("share/share")) {
                t0aVar2.s(true);
                t0a f = this.mJsBridge.f(webView, e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (f != null) {
                    t0aVar2.y(f.f());
                    t0aVar2.u(f.b());
                    t0aVar2.o(f.a());
                    t0aVar2.x(f.e());
                    if (!t0aVar2.h()) {
                        t0aVar2.n(false);
                        addObserver(webView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, t0aVar2, false);
                    }
                }
                t0aVar2.z(0);
            }
            return t0aVar2;
        }
        return (t0a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public zl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (zl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public List<t0a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            t0a t0aVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                t0aVar = this.mJsBridge.h(webView, hashMap);
            }
            if (t0aVar != null) {
                t0aVar.z(0);
            }
            List<s0a> list = this.mAsyncCallBackMethodList.get(str);
            if (t0aVar != null && list != null) {
                Iterator<s0a> it = list.iterator();
                if (!TextUtils.isEmpty(t0aVar.e())) {
                    while (it.hasNext()) {
                        s0a next = it.next();
                        if (next.b().equals(t0aVar.e())) {
                            t0a t0aVar2 = new t0a();
                            t0aVar2.w(next.a());
                            t0aVar2.y(t0aVar.f());
                            t0aVar2.u(t0aVar.b());
                            t0aVar2.o(t0aVar.a());
                            t0aVar2.A(t0aVar.l());
                            arrayList.add(t0aVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        s0a next2 = it.next();
                        t0a t0aVar3 = new t0a();
                        t0aVar3.w(next2.a());
                        t0aVar3.y(t0aVar.f());
                        t0aVar3.u(t0aVar.b());
                        t0aVar3.o(t0aVar.a());
                        t0aVar3.A(t0aVar.l());
                        arrayList.add(t0aVar3);
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
