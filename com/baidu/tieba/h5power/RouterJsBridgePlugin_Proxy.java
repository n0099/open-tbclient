package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.hs9;
import com.baidu.tieba.is9;
import com.baidu.tieba.jh6;
import com.baidu.tieba.js9;
import com.baidu.tieba.ls9;
import com.baidu.tieba.zv4;
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
/* loaded from: classes5.dex */
public class RouterJsBridgePlugin_Proxy extends hs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zv4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(zv4 zv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zv4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = zv4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_HIDE);
        this.mNotificationNameList.add("goToSelectPrivateMsgPage");
        this.mNotificationNameList.add("goToReportThreadPage");
        this.mNotificationNameList.add(CommonTbJsBridge.REFRESH_TAIL);
    }

    @Override // com.baidu.tieba.hs9
    public js9 dispatch(WebView webView, ls9 ls9Var, js9 js9Var) {
        InterceptResult invokeLLL;
        js9 js9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ls9Var, js9Var)) == null) {
            if (js9Var == null) {
                js9Var2 = new js9();
            } else {
                js9Var2 = js9Var;
            }
            String b = ls9Var.b();
            JSONObject e = ls9Var.e();
            if (b.equals("router/finishThisPage")) {
                js9Var2.s(true);
                js9 c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    js9Var2.y(c.f());
                    js9Var2.u(c.b());
                    js9Var2.o(c.a());
                    js9Var2.x(c.e());
                }
                js9Var2.z(0);
            } else if (b.equals("router/portal")) {
                js9Var2.s(true);
                js9 i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (i != null) {
                    js9Var2.y(i.f());
                    js9Var2.u(i.b());
                    js9Var2.o(i.a());
                    js9Var2.x(i.e());
                }
                js9Var2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                js9Var2.s(true);
                js9 js9Var3 = js9Var2;
                js9 g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    js9Var3.y(g.f());
                    js9Var3.u(g.b());
                    js9Var3.o(g.a());
                    js9Var3.x(g.e());
                }
                js9Var3.z(0);
                return js9Var3;
            } else {
                js9 js9Var4 = js9Var2;
                if (b.equals("router/forumRulesEditPage")) {
                    js9Var4.s(true);
                    js9 j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        js9Var4.y(j.f());
                        js9Var4.u(j.b());
                        js9Var4.o(j.a());
                        js9Var4.x(j.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("router/goToBarDetail")) {
                    js9Var4.s(true);
                    js9 h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        js9Var4.y(h.f());
                        js9Var4.u(h.b());
                        js9Var4.o(h.a());
                        js9Var4.x(h.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    js9Var4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    js9 s = this.mJsBridge.s(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (s != null) {
                        js9Var4.y(s.f());
                        js9Var4.u(s.b());
                        js9Var4.o(s.a());
                        js9Var4.x(s.e());
                        if (!js9Var4.h()) {
                            js9Var4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", js9Var4, false);
                        }
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    js9Var4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    js9 r = this.mJsBridge.r(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (r != null) {
                        js9Var4.y(r.f());
                        js9Var4.u(r.b());
                        js9Var4.o(r.a());
                        js9Var4.x(r.e());
                        if (!js9Var4.h()) {
                            js9Var4.n(false);
                            addObserver(webView, "goToReportThreadPage", js9Var4, false);
                        }
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("router/goToEditPost")) {
                    js9Var4.s(true);
                    js9 f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        js9Var4.y(f.f());
                        js9Var4.u(f.b());
                        js9Var4.o(f.a());
                        js9Var4.x(f.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("router/jumpToVideo")) {
                    js9Var4.s(true);
                    js9 l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        js9Var4.y(l.f());
                        js9Var4.u(l.b());
                        js9Var4.o(l.a());
                        js9Var4.x(l.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    js9Var4.s(true);
                    js9 n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        js9Var4.y(n.f());
                        js9Var4.u(n.b());
                        js9Var4.o(n.a());
                        js9Var4.x(n.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (!b.equals("router/jumpToHTMLPage")) {
                    return js9Var4;
                } else {
                    js9Var4.s(true);
                    js9 k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        js9Var4.y(k.f());
                        js9Var4.u(k.b());
                        js9Var4.o(k.a());
                        js9Var4.x(k.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                }
            }
            return js9Var2;
        }
        return (js9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public jh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (jh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public List<js9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            js9 js9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                js9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                js9Var = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                js9Var = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                js9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                js9Var = this.mJsBridge.q(webView, hashMap);
            }
            if (js9Var != null) {
                js9Var.z(0);
            }
            List<is9> list = this.mAsyncCallBackMethodList.get(str);
            if (js9Var != null && list != null) {
                Iterator<is9> it = list.iterator();
                if (!TextUtils.isEmpty(js9Var.e())) {
                    while (it.hasNext()) {
                        is9 next = it.next();
                        if (next.b().equals(js9Var.e())) {
                            js9 js9Var2 = new js9();
                            js9Var2.w(next.a());
                            js9Var2.y(js9Var.f());
                            js9Var2.u(js9Var.b());
                            js9Var2.o(js9Var.a());
                            js9Var2.A(js9Var.l());
                            arrayList.add(js9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        is9 next2 = it.next();
                        js9 js9Var3 = new js9();
                        js9Var3.w(next2.a());
                        js9Var3.y(js9Var.f());
                        js9Var3.u(js9Var.b());
                        js9Var3.o(js9Var.a());
                        js9Var3.A(js9Var.l());
                        arrayList.add(js9Var3);
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
