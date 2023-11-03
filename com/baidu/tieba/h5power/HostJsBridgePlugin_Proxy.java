package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.cj6;
import com.baidu.tieba.lsa;
import com.baidu.tieba.msa;
import com.baidu.tieba.ns4;
import com.baidu.tieba.nsa;
import com.baidu.tieba.psa;
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
public class HostJsBridgePlugin_Proxy extends lsa {
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
            if (b.equals("host/callNativeSMS")) {
                nsaVar2.s(true);
                nsa c = this.mJsBridge.c(webView, e.optString("phoneNumber"), e.optString("content"));
                if (c != null) {
                    nsaVar2.y(c.f());
                    nsaVar2.u(c.b());
                    nsaVar2.o(c.a());
                    nsaVar2.x(c.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                nsaVar2.s(true);
                nsa p = this.mJsBridge.p(webView, e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (p != null) {
                    nsaVar2.y(p.f());
                    nsaVar2.u(p.b());
                    nsaVar2.o(p.a());
                    nsaVar2.x(p.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                nsaVar2.s(true);
                nsa i = this.mJsBridge.i(webView, e.optBoolean("isPaySuccess"));
                if (i != null) {
                    nsaVar2.y(i.f());
                    nsaVar2.u(i.b());
                    nsaVar2.o(i.a());
                    nsaVar2.x(i.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                nsaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                nsa n = this.mJsBridge.n(webView, arrayList);
                if (n != null) {
                    nsaVar2.y(n.f());
                    nsaVar2.u(n.b());
                    nsaVar2.o(n.a());
                    nsaVar2.x(n.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("host/sendMsg")) {
                nsaVar2.s(true);
                nsa q = this.mJsBridge.q(webView, e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (q != null) {
                    nsaVar2.y(q.f());
                    nsaVar2.u(q.b());
                    nsaVar2.o(q.a());
                    nsaVar2.x(q.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, "sendMsg", nsaVar2, true);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("host/handleAudioMsgByTTS")) {
                nsaVar2.s(true);
                JSONObject optJSONObject = e.optJSONObject("ext");
                String optString = e.optString("chatType");
                String optString2 = e.optString("chatId");
                String optString3 = e.optString("speakId");
                ArrayList<String> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("speechTexts"));
                nsa g = this.mJsBridge.g(webView, optJSONObject, optString, optString2, optString3, arrayList2, e.optString("actionType"));
                this.mNotificationNameList.add("handleAudioMsgByTTS");
                if (g != null) {
                    nsaVar2.y(g.f());
                    nsaVar2.u(g.b());
                    nsaVar2.o(g.a());
                    nsaVar2.x(g.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, "handleAudioMsgByTTS", nsaVar2, true);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                nsaVar2.s(true);
                nsa d = this.mJsBridge.d(webView, e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (d != null) {
                    nsaVar2.y(d.f());
                    nsaVar2.u(d.b());
                    nsaVar2.o(d.a());
                    nsaVar2.x(d.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, "fetchHistoryMsgs", nsaVar2, true);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("host/receiveNewMsgs")) {
                nsaVar2.s(true);
                nsa o = this.mJsBridge.o(webView);
                this.mNotificationNameList.add("receiveNewMsgs");
                if (o != null) {
                    nsaVar2.y(o.f());
                    nsaVar2.u(o.b());
                    nsaVar2.o(o.a());
                    nsaVar2.x(o.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, "receiveNewMsgs", nsaVar2, true);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("host/preloadPic")) {
                nsaVar2.s(true);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("url"));
                nsa m = this.mJsBridge.m(webView, arrayList3);
                this.mNotificationNameList.add("preloadPic");
                if (m != null) {
                    nsaVar2.y(m.f());
                    nsaVar2.u(m.b());
                    nsaVar2.o(m.a());
                    nsaVar2.x(m.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, "preloadPic", nsaVar2, false);
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
            if (str.equals("handleAudioMsgByTTS")) {
                nsaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals("sendMsg")) {
                nsaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                nsaVar = this.mJsBridge.j(webView, hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                nsaVar = this.mJsBridge.k(webView, hashMap);
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
