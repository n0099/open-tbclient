package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.gfa;
import com.baidu.tieba.gh6;
import com.baidu.tieba.hfa;
import com.baidu.tieba.ifa;
import com.baidu.tieba.kfa;
import com.baidu.tieba.wr4;
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
public class HostJsBridgePlugin_Proxy extends gfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wr4 mJsBridge;

    public HostJsBridgePlugin_Proxy(wr4 wr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wr4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = wr4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("handleAudioMsgByTTS");
        this.mNotificationNameList.add("sendMsg");
        this.mNotificationNameList.add("fetchHistoryMsgs");
        this.mNotificationNameList.add("receiveNewMsgs");
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
            if (b.equals("host/callNativeSMS")) {
                ifaVar2.s(true);
                ifa c = this.mJsBridge.c(webView, e.optString("phoneNumber"), e.optString("content"));
                if (c != null) {
                    ifaVar2.y(c.f());
                    ifaVar2.u(c.b());
                    ifaVar2.o(c.a());
                    ifaVar2.x(c.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                ifaVar2.s(true);
                ifa p = this.mJsBridge.p(webView, e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (p != null) {
                    ifaVar2.y(p.f());
                    ifaVar2.u(p.b());
                    ifaVar2.o(p.a());
                    ifaVar2.x(p.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                ifaVar2.s(true);
                ifa i = this.mJsBridge.i(webView, e.optBoolean("isPaySuccess"));
                if (i != null) {
                    ifaVar2.y(i.f());
                    ifaVar2.u(i.b());
                    ifaVar2.o(i.a());
                    ifaVar2.x(i.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                ifaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                ifa n = this.mJsBridge.n(webView, arrayList);
                if (n != null) {
                    ifaVar2.y(n.f());
                    ifaVar2.u(n.b());
                    ifaVar2.o(n.a());
                    ifaVar2.x(n.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("host/sendMsg")) {
                ifaVar2.s(true);
                ifa q = this.mJsBridge.q(webView, e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (q != null) {
                    ifaVar2.y(q.f());
                    ifaVar2.u(q.b());
                    ifaVar2.o(q.a());
                    ifaVar2.x(q.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver(webView, "sendMsg", ifaVar2, true);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("host/handleAudioMsgByTTS")) {
                ifaVar2.s(true);
                JSONObject optJSONObject = e.optJSONObject("ext");
                String optString = e.optString("chatType");
                String optString2 = e.optString("chatId");
                String optString3 = e.optString("speakId");
                ArrayList<String> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("speechTexts"));
                ifa g = this.mJsBridge.g(webView, optJSONObject, optString, optString2, optString3, arrayList2, e.optString("actionType"));
                this.mNotificationNameList.add("handleAudioMsgByTTS");
                if (g != null) {
                    ifaVar2.y(g.f());
                    ifaVar2.u(g.b());
                    ifaVar2.o(g.a());
                    ifaVar2.x(g.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver(webView, "handleAudioMsgByTTS", ifaVar2, true);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                ifaVar2.s(true);
                ifa d = this.mJsBridge.d(webView, e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (d != null) {
                    ifaVar2.y(d.f());
                    ifaVar2.u(d.b());
                    ifaVar2.o(d.a());
                    ifaVar2.x(d.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver(webView, "fetchHistoryMsgs", ifaVar2, true);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("host/receiveNewMsgs")) {
                ifaVar2.s(true);
                ifa o = this.mJsBridge.o(webView);
                this.mNotificationNameList.add("receiveNewMsgs");
                if (o != null) {
                    ifaVar2.y(o.f());
                    ifaVar2.u(o.b());
                    ifaVar2.o(o.a());
                    ifaVar2.x(o.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver(webView, "receiveNewMsgs", ifaVar2, true);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("host/preloadPic")) {
                ifaVar2.s(true);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("url"));
                ifa m = this.mJsBridge.m(webView, arrayList3);
                this.mNotificationNameList.add("preloadPic");
                if (m != null) {
                    ifaVar2.y(m.f());
                    ifaVar2.u(m.b());
                    ifaVar2.o(m.a());
                    ifaVar2.x(m.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver(webView, "preloadPic", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            }
            return ifaVar2;
        }
        return (ifa) invokeLLL.objValue;
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
            if (str.equals("handleAudioMsgByTTS")) {
                ifaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals("sendMsg")) {
                ifaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                ifaVar = this.mJsBridge.j(webView, hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                ifaVar = this.mJsBridge.k(webView, hashMap);
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
}
