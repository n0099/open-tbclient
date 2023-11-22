package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.dj6;
import com.baidu.tieba.msa;
import com.baidu.tieba.ns4;
import com.baidu.tieba.nsa;
import com.baidu.tieba.osa;
import com.baidu.tieba.qsa;
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
public class HostJsBridgePlugin_Proxy extends msa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ns4 mJsBridge;

    public HostJsBridgePlugin_Proxy(ns4 ns4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ns4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ns4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("handleAudioMsgByTTS");
        this.mNotificationNameList.add("sendMsg");
        this.mNotificationNameList.add("fetchHistoryMsgs");
        this.mNotificationNameList.add("receiveNewMsgs");
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
            if (b.equals("host/callNativeSMS")) {
                osaVar2.s(true);
                osa c = this.mJsBridge.c(webView, e.optString("phoneNumber"), e.optString("content"));
                if (c != null) {
                    osaVar2.y(c.f());
                    osaVar2.u(c.b());
                    osaVar2.o(c.a());
                    osaVar2.x(c.e());
                }
                osaVar2.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                osaVar2.s(true);
                osa p = this.mJsBridge.p(webView, e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (p != null) {
                    osaVar2.y(p.f());
                    osaVar2.u(p.b());
                    osaVar2.o(p.a());
                    osaVar2.x(p.e());
                }
                osaVar2.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                osaVar2.s(true);
                osa i = this.mJsBridge.i(webView, e.optBoolean("isPaySuccess"));
                if (i != null) {
                    osaVar2.y(i.f());
                    osaVar2.u(i.b());
                    osaVar2.o(i.a());
                    osaVar2.x(i.e());
                }
                osaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                osaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                osa n = this.mJsBridge.n(webView, arrayList);
                if (n != null) {
                    osaVar2.y(n.f());
                    osaVar2.u(n.b());
                    osaVar2.o(n.a());
                    osaVar2.x(n.e());
                }
                osaVar2.z(0);
            } else if (b.equals("host/sendMsg")) {
                osaVar2.s(true);
                osa q = this.mJsBridge.q(webView, e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (q != null) {
                    osaVar2.y(q.f());
                    osaVar2.u(q.b());
                    osaVar2.o(q.a());
                    osaVar2.x(q.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, "sendMsg", osaVar2, true);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("host/handleAudioMsgByTTS")) {
                osaVar2.s(true);
                JSONObject optJSONObject = e.optJSONObject("ext");
                String optString = e.optString("chatType");
                String optString2 = e.optString("chatId");
                String optString3 = e.optString("speakId");
                ArrayList<String> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("speechTexts"));
                osa g = this.mJsBridge.g(webView, optJSONObject, optString, optString2, optString3, arrayList2, e.optString("actionType"));
                this.mNotificationNameList.add("handleAudioMsgByTTS");
                if (g != null) {
                    osaVar2.y(g.f());
                    osaVar2.u(g.b());
                    osaVar2.o(g.a());
                    osaVar2.x(g.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, "handleAudioMsgByTTS", osaVar2, true);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                osaVar2.s(true);
                osa d = this.mJsBridge.d(webView, e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (d != null) {
                    osaVar2.y(d.f());
                    osaVar2.u(d.b());
                    osaVar2.o(d.a());
                    osaVar2.x(d.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, "fetchHistoryMsgs", osaVar2, true);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("host/receiveNewMsgs")) {
                osaVar2.s(true);
                osa o = this.mJsBridge.o(webView);
                this.mNotificationNameList.add("receiveNewMsgs");
                if (o != null) {
                    osaVar2.y(o.f());
                    osaVar2.u(o.b());
                    osaVar2.o(o.a());
                    osaVar2.x(o.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, "receiveNewMsgs", osaVar2, true);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("host/preloadPic")) {
                osaVar2.s(true);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("url"));
                osa m = this.mJsBridge.m(webView, arrayList3);
                this.mNotificationNameList.add("preloadPic");
                if (m != null) {
                    osaVar2.y(m.f());
                    osaVar2.u(m.b());
                    osaVar2.o(m.a());
                    osaVar2.x(m.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, "preloadPic", osaVar2, false);
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
            if (str.equals("handleAudioMsgByTTS")) {
                osaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals("sendMsg")) {
                osaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                osaVar = this.mJsBridge.j(webView, hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                osaVar = this.mJsBridge.k(webView, hashMap);
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
