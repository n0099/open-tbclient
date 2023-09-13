package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.kia;
import com.baidu.tieba.lia;
import com.baidu.tieba.mia;
import com.baidu.tieba.oia;
import com.baidu.tieba.px4;
import com.baidu.tieba.tm6;
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
public class HostJsBridgePlugin_Proxy extends kia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public px4 mJsBridge;

    public HostJsBridgePlugin_Proxy(px4 px4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {px4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = px4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("handleAudioMsgByTTS");
        this.mNotificationNameList.add("sendMsg");
        this.mNotificationNameList.add("fetchHistoryMsgs");
        this.mNotificationNameList.add("receiveNewMsgs");
    }

    @Override // com.baidu.tieba.kia
    public mia dispatch(WebView webView, oia oiaVar, mia miaVar) {
        InterceptResult invokeLLL;
        mia miaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, oiaVar, miaVar)) == null) {
            if (miaVar == null) {
                miaVar2 = new mia();
            } else {
                miaVar2 = miaVar;
            }
            String b = oiaVar.b();
            JSONObject e = oiaVar.e();
            if (b.equals("host/callNativeSMS")) {
                miaVar2.s(true);
                mia c = this.mJsBridge.c(webView, e.optString("phoneNumber"), e.optString("content"));
                if (c != null) {
                    miaVar2.y(c.f());
                    miaVar2.u(c.b());
                    miaVar2.o(c.a());
                    miaVar2.x(c.e());
                }
                miaVar2.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                miaVar2.s(true);
                mia p = this.mJsBridge.p(webView, e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (p != null) {
                    miaVar2.y(p.f());
                    miaVar2.u(p.b());
                    miaVar2.o(p.a());
                    miaVar2.x(p.e());
                }
                miaVar2.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                miaVar2.s(true);
                mia i = this.mJsBridge.i(webView, e.optBoolean("isPaySuccess"));
                if (i != null) {
                    miaVar2.y(i.f());
                    miaVar2.u(i.b());
                    miaVar2.o(i.a());
                    miaVar2.x(i.e());
                }
                miaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                miaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                mia n = this.mJsBridge.n(webView, arrayList);
                if (n != null) {
                    miaVar2.y(n.f());
                    miaVar2.u(n.b());
                    miaVar2.o(n.a());
                    miaVar2.x(n.e());
                }
                miaVar2.z(0);
            } else if (b.equals("host/sendMsg")) {
                miaVar2.s(true);
                mia q = this.mJsBridge.q(webView, e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (q != null) {
                    miaVar2.y(q.f());
                    miaVar2.u(q.b());
                    miaVar2.o(q.a());
                    miaVar2.x(q.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver(webView, "sendMsg", miaVar2, true);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("host/handleAudioMsgByTTS")) {
                miaVar2.s(true);
                JSONObject optJSONObject = e.optJSONObject("ext");
                String optString = e.optString("chatType");
                String optString2 = e.optString("chatId");
                String optString3 = e.optString("speakId");
                ArrayList<String> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("speechTexts"));
                mia g = this.mJsBridge.g(webView, optJSONObject, optString, optString2, optString3, arrayList2, e.optString("actionType"));
                this.mNotificationNameList.add("handleAudioMsgByTTS");
                if (g != null) {
                    miaVar2.y(g.f());
                    miaVar2.u(g.b());
                    miaVar2.o(g.a());
                    miaVar2.x(g.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver(webView, "handleAudioMsgByTTS", miaVar2, true);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                miaVar2.s(true);
                mia d = this.mJsBridge.d(webView, e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (d != null) {
                    miaVar2.y(d.f());
                    miaVar2.u(d.b());
                    miaVar2.o(d.a());
                    miaVar2.x(d.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver(webView, "fetchHistoryMsgs", miaVar2, true);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("host/receiveNewMsgs")) {
                miaVar2.s(true);
                mia o = this.mJsBridge.o(webView);
                this.mNotificationNameList.add("receiveNewMsgs");
                if (o != null) {
                    miaVar2.y(o.f());
                    miaVar2.u(o.b());
                    miaVar2.o(o.a());
                    miaVar2.x(o.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver(webView, "receiveNewMsgs", miaVar2, true);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("host/preloadPic")) {
                miaVar2.s(true);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("url"));
                mia m = this.mJsBridge.m(webView, arrayList3);
                this.mNotificationNameList.add("preloadPic");
                if (m != null) {
                    miaVar2.y(m.f());
                    miaVar2.u(m.b());
                    miaVar2.o(m.a());
                    miaVar2.x(m.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver(webView, "preloadPic", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            }
            return miaVar2;
        }
        return (mia) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.kia
    public tm6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (tm6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kia
    public List<mia> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            mia miaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("handleAudioMsgByTTS")) {
                miaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals("sendMsg")) {
                miaVar = this.mJsBridge.l(webView, hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                miaVar = this.mJsBridge.j(webView, hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                miaVar = this.mJsBridge.k(webView, hashMap);
            }
            if (miaVar != null) {
                miaVar.z(0);
            }
            List<lia> list = this.mAsyncCallBackMethodList.get(str);
            if (miaVar != null && list != null) {
                Iterator<lia> it = list.iterator();
                if (!TextUtils.isEmpty(miaVar.e())) {
                    while (it.hasNext()) {
                        lia next = it.next();
                        if (next.b().equals(miaVar.e())) {
                            mia miaVar2 = new mia();
                            miaVar2.w(next.a());
                            miaVar2.y(miaVar.f());
                            miaVar2.u(miaVar.b());
                            miaVar2.o(miaVar.a());
                            miaVar2.j = miaVar.j;
                            miaVar2.A(miaVar.l());
                            arrayList.add(miaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        lia next2 = it.next();
                        mia miaVar3 = new mia();
                        miaVar3.w(next2.a());
                        miaVar3.y(miaVar.f());
                        miaVar3.u(miaVar.b());
                        miaVar3.o(miaVar.a());
                        miaVar3.j = miaVar.j;
                        miaVar3.A(miaVar.l());
                        arrayList.add(miaVar3);
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
