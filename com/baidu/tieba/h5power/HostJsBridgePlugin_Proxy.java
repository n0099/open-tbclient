package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.lx4;
import com.baidu.tieba.qga;
import com.baidu.tieba.rga;
import com.baidu.tieba.sga;
import com.baidu.tieba.uga;
import com.baidu.tieba.vl6;
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
public class HostJsBridgePlugin_Proxy extends qga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lx4 mJsBridge;

    public HostJsBridgePlugin_Proxy(lx4 lx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = lx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("sendMsg");
        this.mNotificationNameList.add("fetchHistoryMsgs");
        this.mNotificationNameList.add("receiveNewMsgs");
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
            if (b.equals("host/callNativeSMS")) {
                sgaVar2.s(true);
                sga c = this.mJsBridge.c(webView, e.optString("phoneNumber"), e.optString("content"));
                if (c != null) {
                    sgaVar2.y(c.f());
                    sgaVar2.u(c.b());
                    sgaVar2.o(c.a());
                    sgaVar2.x(c.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                sgaVar2.s(true);
                sga n = this.mJsBridge.n(webView, e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (n != null) {
                    sgaVar2.y(n.f());
                    sgaVar2.u(n.b());
                    sgaVar2.o(n.a());
                    sgaVar2.x(n.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                sgaVar2.s(true);
                sga g = this.mJsBridge.g(webView, e.optBoolean("isPaySuccess"));
                if (g != null) {
                    sgaVar2.y(g.f());
                    sgaVar2.u(g.b());
                    sgaVar2.o(g.a());
                    sgaVar2.x(g.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                sgaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                sga l = this.mJsBridge.l(webView, arrayList);
                if (l != null) {
                    sgaVar2.y(l.f());
                    sgaVar2.u(l.b());
                    sgaVar2.o(l.a());
                    sgaVar2.x(l.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("host/sendMsg")) {
                sgaVar2.s(true);
                sga o = this.mJsBridge.o(webView, e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (o != null) {
                    sgaVar2.y(o.f());
                    sgaVar2.u(o.b());
                    sgaVar2.o(o.a());
                    sgaVar2.x(o.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver(webView, "sendMsg", sgaVar2, true);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                sgaVar2.s(true);
                sga d = this.mJsBridge.d(webView, e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (d != null) {
                    sgaVar2.y(d.f());
                    sgaVar2.u(d.b());
                    sgaVar2.o(d.a());
                    sgaVar2.x(d.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver(webView, "fetchHistoryMsgs", sgaVar2, true);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("host/receiveNewMsgs")) {
                sgaVar2.s(true);
                sga m = this.mJsBridge.m(webView);
                this.mNotificationNameList.add("receiveNewMsgs");
                if (m != null) {
                    sgaVar2.y(m.f());
                    sgaVar2.u(m.b());
                    sgaVar2.o(m.a());
                    sgaVar2.x(m.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver(webView, "receiveNewMsgs", sgaVar2, true);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("host/preloadPic")) {
                sgaVar2.s(true);
                ArrayList<String> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("url"));
                sga k = this.mJsBridge.k(webView, arrayList2);
                this.mNotificationNameList.add("preloadPic");
                if (k != null) {
                    sgaVar2.y(k.f());
                    sgaVar2.u(k.b());
                    sgaVar2.o(k.a());
                    sgaVar2.x(k.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver(webView, "preloadPic", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            }
            return sgaVar2;
        }
        return (sga) invokeLLL.objValue;
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
            if (str.equals("sendMsg")) {
                sgaVar = this.mJsBridge.j(webView, hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                sgaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                sgaVar = this.mJsBridge.i(webView, hashMap);
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
}
