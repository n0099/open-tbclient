package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tieba.cj6;
import com.baidu.tieba.lsa;
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.psa;
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
public class ShareJsBridgePlugin_Proxy extends lsa {
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
            if (b.equals("share/registerShareDataNew")) {
                nsaVar2.s(true);
                nsa d = this.mJsBridge.d(webView, e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (d != null) {
                    nsaVar2.y(d.f());
                    nsaVar2.u(d.b());
                    nsaVar2.o(d.a());
                    nsaVar2.x(d.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("share/share")) {
                nsaVar2.s(true);
                nsa f = this.mJsBridge.f(webView, e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (f != null) {
                    nsaVar2.y(f.f());
                    nsaVar2.u(f.b());
                    nsaVar2.o(f.a());
                    nsaVar2.x(f.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            }
            return nsaVar2;
        }
        return (nsa) invokeLLL.objValue;
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
            if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                nsaVar = this.mJsBridge.h(webView, hashMap);
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
}
