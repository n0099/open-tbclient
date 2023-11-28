package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.gxa;
import com.baidu.tieba.ixa;
import com.baidu.tieba.mj6;
import com.baidu.tieba.os4;
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
public class HostJsBridgePlugin_Proxy extends exa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public os4 mJsBridge;

    public HostJsBridgePlugin_Proxy(os4 os4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {os4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = os4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("handleAudioMsgByTTS");
        this.mNotificationNameList.add("sendMsg");
        this.mNotificationNameList.add("fetchHistoryMsgs");
        this.mNotificationNameList.add("receiveNewMsgs");
    }

    @Override // com.baidu.tieba.exa
    public gxa dispatch(WebView webView, ixa ixaVar, gxa gxaVar) {
        InterceptResult invokeLLL;
        gxa gxaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ixaVar, gxaVar)) == null) {
            if (gxaVar == null) {
                gxaVar2 = new gxa();
            } else {
                gxaVar2 = gxaVar;
            }
            String b = ixaVar.b();
            JSONObject e = ixaVar.e();
            if (b.equals("host/callNativeSMS")) {
                gxaVar2.s(true);
                gxa c = this.mJsBridge.c(webView, e.optString("phoneNumber"), e.optString("content"));
                if (c != null) {
                    gxaVar2.y(c.f());
                    gxaVar2.u(c.b());
                    gxaVar2.o(c.a());
                    gxaVar2.x(c.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                gxaVar2.s(true);
                gxa p = this.mJsBridge.p(webView, e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (p != null) {
                    gxaVar2.y(p.f());
                    gxaVar2.u(p.b());
                    gxaVar2.o(p.a());
                    gxaVar2.x(p.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                gxaVar2.s(true);
                gxa i = this.mJsBridge.i(webView, e.optBoolean("isPaySuccess"));
                if (i != null) {
                    gxaVar2.y(i.f());
                    gxaVar2.u(i.b());
                    gxaVar2.o(i.a());
                    gxaVar2.x(i.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                gxaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                gxa n = this.mJsBridge.n(webView, arrayList);
                if (n != null) {
                    gxaVar2.y(n.f());
                    gxaVar2.u(n.b());
                    gxaVar2.o(n.a());
                    gxaVar2.x(n.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("host/sendMsg")) {
                gxaVar2.s(true);
                gxa q = this.mJsBridge.q(webView, e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (q != null) {
                    gxaVar2.y(q.f());
                    gxaVar2.u(q.b());
                    gxaVar2.o(q.a());
                    gxaVar2.x(q.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, "sendMsg", gxaVar2, true);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("host/handleAudioMsgByTTS")) {
                gxaVar2.s(true);
                JSONObject optJSONObject = e.optJSONObject("ext");
                String optString = e.optString("chatType");
                String optString2 = e.optString("chatId");
                String optString3 = e.optString("speakId");
                ArrayList<String> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("speechTexts"));
                gxa g = this.mJsBridge.g(webView, optJSONObject, optString, optString2, optString3, arrayList2, e.optString("actionType"));
                this.mNotificationNameList.add("handleAudioMsgByTTS");
                if (g != null) {
                    gxaVar2.y(g.f());
                    gxaVar2.u(g.b());
                    gxaVar2.o(g.a());
                    gxaVar2.x(g.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, "handleAudioMsgByTTS", gxaVar2, true);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                gxaVar2.s(true);
                gxa d = this.mJsBridge.d(webView, e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (d != null) {
                    gxaVar2.y(d.f());
                    gxaVar2.u(d.b());
                    gxaVar2.o(d.a());
                    gxaVar2.x(d.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, "fetchHistoryMsgs", gxaVar2, true);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("host/receiveNewMsgs")) {
                gxaVar2.s(true);
                gxa o = this.mJsBridge.o(webView);
                this.mNotificationNameList.add("receiveNewMsgs");
                if (o != null) {
                    gxaVar2.y(o.f());
                    gxaVar2.u(o.b());
                    gxaVar2.o(o.a());
                    gxaVar2.x(o.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, "receiveNewMsgs", gxaVar2, true);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("host/preloadPic")) {
                gxaVar2.s(true);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("url"));
                gxa m = this.mJsBridge.m(webView, arrayList3);
                this.mNotificationNameList.add("preloadPic");
                if (m != null) {
                    gxaVar2.y(m.f());
                    gxaVar2.u(m.b());
                    gxaVar2.o(m.a());
                    gxaVar2.x(m.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, "preloadPic", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            }
            return gxaVar2;
        }
        return (gxa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.exa
    public mj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (mj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.exa
    public List<gxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            gxa gxaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("handleAudioMsgByTTS")) {
                gxaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals("sendMsg")) {
                gxaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                gxaVar = this.mJsBridge.j(webView, hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                gxaVar = this.mJsBridge.k(webView, hashMap);
            }
            if (gxaVar != null) {
                gxaVar.z(0);
            }
            List<fxa> list = this.mAsyncCallBackMethodList.get(str);
            if (gxaVar != null && list != null) {
                Iterator<fxa> it = list.iterator();
                if (!TextUtils.isEmpty(gxaVar.e())) {
                    while (it.hasNext()) {
                        fxa next = it.next();
                        if (next.b().equals(gxaVar.e())) {
                            gxa gxaVar2 = new gxa();
                            gxaVar2.w(next.a());
                            gxaVar2.y(gxaVar.f());
                            gxaVar2.u(gxaVar.b());
                            gxaVar2.o(gxaVar.a());
                            gxaVar2.j = gxaVar.j;
                            gxaVar2.A(gxaVar.l());
                            arrayList.add(gxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        fxa next2 = it.next();
                        gxa gxaVar3 = new gxa();
                        gxaVar3.w(next2.a());
                        gxaVar3.y(gxaVar.f());
                        gxaVar3.u(gxaVar.b());
                        gxaVar3.o(gxaVar.a());
                        gxaVar3.j = gxaVar.j;
                        gxaVar3.A(gxaVar.l());
                        arrayList.add(gxaVar3);
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
