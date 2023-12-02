package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.dxa;
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.hxa;
import com.baidu.tieba.qj6;
import com.baidu.tieba.rs4;
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
public class HostJsBridgePlugin_Proxy extends dxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rs4 mJsBridge;

    public HostJsBridgePlugin_Proxy(rs4 rs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rs4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = rs4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("handleAudioMsgByTTS");
        this.mNotificationNameList.add("sendMsg");
        this.mNotificationNameList.add("fetchHistoryMsgs");
        this.mNotificationNameList.add("receiveNewMsgs");
    }

    @Override // com.baidu.tieba.dxa
    public fxa dispatch(WebView webView, hxa hxaVar, fxa fxaVar) {
        InterceptResult invokeLLL;
        fxa fxaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, hxaVar, fxaVar)) == null) {
            if (fxaVar == null) {
                fxaVar2 = new fxa();
            } else {
                fxaVar2 = fxaVar;
            }
            String b = hxaVar.b();
            JSONObject e = hxaVar.e();
            if (b.equals("host/callNativeSMS")) {
                fxaVar2.s(true);
                fxa c = this.mJsBridge.c(webView, e.optString("phoneNumber"), e.optString("content"));
                if (c != null) {
                    fxaVar2.y(c.f());
                    fxaVar2.u(c.b());
                    fxaVar2.o(c.a());
                    fxaVar2.x(c.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                fxaVar2.s(true);
                fxa p = this.mJsBridge.p(webView, e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (p != null) {
                    fxaVar2.y(p.f());
                    fxaVar2.u(p.b());
                    fxaVar2.o(p.a());
                    fxaVar2.x(p.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                fxaVar2.s(true);
                fxa i = this.mJsBridge.i(webView, e.optBoolean("isPaySuccess"));
                if (i != null) {
                    fxaVar2.y(i.f());
                    fxaVar2.u(i.b());
                    fxaVar2.o(i.a());
                    fxaVar2.x(i.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                fxaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                fxa n = this.mJsBridge.n(webView, arrayList);
                if (n != null) {
                    fxaVar2.y(n.f());
                    fxaVar2.u(n.b());
                    fxaVar2.o(n.a());
                    fxaVar2.x(n.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("host/sendMsg")) {
                fxaVar2.s(true);
                fxa q = this.mJsBridge.q(webView, e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (q != null) {
                    fxaVar2.y(q.f());
                    fxaVar2.u(q.b());
                    fxaVar2.o(q.a());
                    fxaVar2.x(q.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, "sendMsg", fxaVar2, true);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("host/handleAudioMsgByTTS")) {
                fxaVar2.s(true);
                JSONObject optJSONObject = e.optJSONObject("ext");
                String optString = e.optString("chatType");
                String optString2 = e.optString("chatId");
                String optString3 = e.optString("speakId");
                ArrayList<String> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("speechTexts"));
                fxa g = this.mJsBridge.g(webView, optJSONObject, optString, optString2, optString3, arrayList2, e.optString("actionType"));
                this.mNotificationNameList.add("handleAudioMsgByTTS");
                if (g != null) {
                    fxaVar2.y(g.f());
                    fxaVar2.u(g.b());
                    fxaVar2.o(g.a());
                    fxaVar2.x(g.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, "handleAudioMsgByTTS", fxaVar2, true);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                fxaVar2.s(true);
                fxa d = this.mJsBridge.d(webView, e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (d != null) {
                    fxaVar2.y(d.f());
                    fxaVar2.u(d.b());
                    fxaVar2.o(d.a());
                    fxaVar2.x(d.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, "fetchHistoryMsgs", fxaVar2, true);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("host/receiveNewMsgs")) {
                fxaVar2.s(true);
                fxa o = this.mJsBridge.o(webView);
                this.mNotificationNameList.add("receiveNewMsgs");
                if (o != null) {
                    fxaVar2.y(o.f());
                    fxaVar2.u(o.b());
                    fxaVar2.o(o.a());
                    fxaVar2.x(o.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, "receiveNewMsgs", fxaVar2, true);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("host/preloadPic")) {
                fxaVar2.s(true);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("url"));
                fxa m = this.mJsBridge.m(webView, arrayList3);
                this.mNotificationNameList.add("preloadPic");
                if (m != null) {
                    fxaVar2.y(m.f());
                    fxaVar2.u(m.b());
                    fxaVar2.o(m.a());
                    fxaVar2.x(m.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, "preloadPic", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            }
            return fxaVar2;
        }
        return (fxa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public qj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public List<fxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            fxa fxaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("handleAudioMsgByTTS")) {
                fxaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals("sendMsg")) {
                fxaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                fxaVar = this.mJsBridge.j(webView, hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                fxaVar = this.mJsBridge.k(webView, hashMap);
            }
            if (fxaVar != null) {
                fxaVar.z(0);
            }
            List<exa> list = this.mAsyncCallBackMethodList.get(str);
            if (fxaVar != null && list != null) {
                Iterator<exa> it = list.iterator();
                if (!TextUtils.isEmpty(fxaVar.e())) {
                    while (it.hasNext()) {
                        exa next = it.next();
                        if (next.b().equals(fxaVar.e())) {
                            fxa fxaVar2 = new fxa();
                            fxaVar2.w(next.a());
                            fxaVar2.y(fxaVar.f());
                            fxaVar2.u(fxaVar.b());
                            fxaVar2.o(fxaVar.a());
                            fxaVar2.j = fxaVar.j;
                            fxaVar2.A(fxaVar.l());
                            arrayList.add(fxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        exa next2 = it.next();
                        fxa fxaVar3 = new fxa();
                        fxaVar3.w(next2.a());
                        fxaVar3.y(fxaVar.f());
                        fxaVar3.u(fxaVar.b());
                        fxaVar3.o(fxaVar.a());
                        fxaVar3.j = fxaVar.j;
                        fxaVar3.A(fxaVar.l());
                        arrayList.add(fxaVar3);
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
