package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.r0a;
import com.baidu.tieba.s0a;
import com.baidu.tieba.sy4;
import com.baidu.tieba.t0a;
import com.baidu.tieba.v0a;
import com.baidu.tieba.zl6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class RouterJsBridgePlugin_Proxy extends r0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sy4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(sy4 sy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = sy4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_HIDE);
        this.mNotificationNameList.add("goToSelectPrivateMsgPage");
        this.mNotificationNameList.add("goToReportThreadPage");
        this.mNotificationNameList.add(CommonTbJsBridge.REFRESH_TAIL);
        this.mNotificationNameList.add("replyPostResult");
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
            if (b.equals("router/finishThisPage")) {
                t0aVar2.s(true);
                t0a c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    t0aVar2.y(c.f());
                    t0aVar2.u(c.b());
                    t0aVar2.o(c.a());
                    t0aVar2.x(c.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("router/portal")) {
                t0aVar2.s(true);
                t0a i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (i != null) {
                    t0aVar2.y(i.f());
                    t0aVar2.u(i.b());
                    t0aVar2.o(i.a());
                    t0aVar2.x(i.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                t0aVar2.s(true);
                t0a t0aVar3 = t0aVar2;
                t0a g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    t0aVar3.y(g.f());
                    t0aVar3.u(g.b());
                    t0aVar3.o(g.a());
                    t0aVar3.x(g.e());
                }
                t0aVar3.z(0);
                return t0aVar3;
            } else {
                t0a t0aVar4 = t0aVar2;
                if (b.equals("router/forumRulesEditPage")) {
                    t0aVar4.s(true);
                    t0a j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        t0aVar4.y(j.f());
                        t0aVar4.u(j.b());
                        t0aVar4.o(j.a());
                        t0aVar4.x(j.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("router/goToBarDetail")) {
                    t0aVar4.s(true);
                    t0a h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        t0aVar4.y(h.f());
                        t0aVar4.u(h.b());
                        t0aVar4.o(h.a());
                        t0aVar4.x(h.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    t0aVar4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    t0a u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        t0aVar4.y(u.f());
                        t0aVar4.u(u.b());
                        t0aVar4.o(u.a());
                        t0aVar4.x(u.e());
                        if (!t0aVar4.h()) {
                            t0aVar4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", t0aVar4, false);
                        }
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    t0aVar4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    t0a t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        t0aVar4.y(t.f());
                        t0aVar4.u(t.b());
                        t0aVar4.o(t.a());
                        t0aVar4.x(t.e());
                        if (!t0aVar4.h()) {
                            t0aVar4.n(false);
                            addObserver(webView, "goToReportThreadPage", t0aVar4, false);
                        }
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("router/goToEditPost")) {
                    t0aVar4.s(true);
                    t0a f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        t0aVar4.y(f.f());
                        t0aVar4.u(f.b());
                        t0aVar4.o(f.a());
                        t0aVar4.x(f.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("router/jumpToVideo")) {
                    t0aVar4.s(true);
                    t0a l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        t0aVar4.y(l.f());
                        t0aVar4.u(l.b());
                        t0aVar4.o(l.a());
                        t0aVar4.x(l.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    t0aVar4.s(true);
                    t0a n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        t0aVar4.y(n.f());
                        t0aVar4.u(n.b());
                        t0aVar4.o(n.a());
                        t0aVar4.x(n.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    t0aVar4.s(true);
                    t0a k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        t0aVar4.y(k.f());
                        t0aVar4.u(k.b());
                        t0aVar4.o(k.a());
                        t0aVar4.x(k.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (!b.equals("router/replyPost")) {
                    return t0aVar4;
                } else {
                    t0aVar4.s(true);
                    t0a r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        t0aVar4.y(r.f());
                        t0aVar4.u(r.b());
                        t0aVar4.o(r.a());
                        t0aVar4.x(r.e());
                        if (!t0aVar4.h()) {
                            t0aVar4.n(false);
                            addObserver(webView, "replyPostResult", t0aVar4, false);
                        }
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                }
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
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                t0aVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                t0aVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                t0aVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                t0aVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                t0aVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                t0aVar = this.mJsBridge.s(webView, hashMap);
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
