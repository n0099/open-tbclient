package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tieba.dj6;
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.osa;
import com.baidu.tieba.qsa;
import com.baidu.tieba.vs4;
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
public class ShareJsBridgePlugin_Proxy extends msa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vs4 mJsBridge;

    public ShareJsBridgePlugin_Proxy(vs4 vs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vs4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = vs4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
    }

    @Override // com.baidu.tieba.msa
    public osa dispatch(WebView webView, qsa qsaVar, osa osaVar) {
        InterceptResult invokeLLL;
        osa osaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, qsaVar, osaVar)) == null) {
            if (osaVar == null) {
                osaVar2 = new osa();
            } else {
                osaVar2 = osaVar;
            }
            String b = qsaVar.b();
            JSONObject e = qsaVar.e();
            if (b.equals("share/registerShareDataNew")) {
                osaVar2.s(true);
                osa d = this.mJsBridge.d(webView, e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (d != null) {
                    osaVar2.y(d.f());
                    osaVar2.u(d.b());
                    osaVar2.o(d.a());
                    osaVar2.x(d.e());
                }
                osaVar2.z(0);
            } else if (b.equals("share/share")) {
                osaVar2.s(true);
                osa f = this.mJsBridge.f(webView, e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (f != null) {
                    osaVar2.y(f.f());
                    osaVar2.u(f.b());
                    osaVar2.o(f.a());
                    osaVar2.x(f.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, osaVar2, false);
                    }
                }
                osaVar2.z(0);
            }
            return osaVar2;
        }
        return (osa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.msa
    public dj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (dj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.msa
    public List<osa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            osa osaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                osaVar = this.mJsBridge.h(webView, hashMap);
            }
            if (osaVar != null) {
                osaVar.z(0);
            }
            List<nsa> list = this.mAsyncCallBackMethodList.get(str);
            if (osaVar != null && list != null) {
                Iterator<nsa> it = list.iterator();
                if (!TextUtils.isEmpty(osaVar.e())) {
                    while (it.hasNext()) {
                        nsa next = it.next();
                        if (next.b().equals(osaVar.e())) {
                            osa osaVar2 = new osa();
                            osaVar2.w(next.a());
                            osaVar2.y(osaVar.f());
                            osaVar2.u(osaVar.b());
                            osaVar2.o(osaVar.a());
                            osaVar2.j = osaVar.j;
                            osaVar2.A(osaVar.l());
                            arrayList.add(osaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        nsa next2 = it.next();
                        osa osaVar3 = new osa();
                        osaVar3.w(next2.a());
                        osaVar3.y(osaVar.f());
                        osaVar3.u(osaVar.b());
                        osaVar3.o(osaVar.a());
                        osaVar3.j = osaVar.j;
                        osaVar3.A(osaVar.l());
                        arrayList.add(osaVar3);
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
