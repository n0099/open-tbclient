package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.l69;
import com.baidu.tieba.m69;
import com.baidu.tieba.n69;
import com.baidu.tieba.p69;
import com.baidu.tieba.uv4;
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
/* loaded from: classes4.dex */
public class RouterJsBridgePlugin_Proxy extends l69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uv4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(uv4 uv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uv4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = uv4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_HIDE);
        this.mNotificationNameList.add("goToSelectPrivateMsgPage");
        this.mNotificationNameList.add("goToReportThreadPage");
        this.mNotificationNameList.add(CommonTbJsBridge.REFRESH_TAIL);
    }

    @Override // com.baidu.tieba.l69
    public n69 dispatch(WebView webView, p69 p69Var, n69 n69Var) {
        InterceptResult invokeLLL;
        n69 n69Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, p69Var, n69Var)) == null) {
            if (n69Var == null) {
                n69Var2 = new n69();
            } else {
                n69Var2 = n69Var;
            }
            String b = p69Var.b();
            JSONObject e = p69Var.e();
            if (b.equals("router/finishThisPage")) {
                n69Var2.r(true);
                n69 c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    n69Var2.x(c.f());
                    n69Var2.t(c.b());
                    n69Var2.o(c.a());
                    n69Var2.w(c.e());
                }
                n69Var2.y(0);
            } else if (b.equals("router/portal")) {
                n69Var2.r(true);
                n69 i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (i != null) {
                    n69Var2.x(i.f());
                    n69Var2.t(i.b());
                    n69Var2.o(i.a());
                    n69Var2.w(i.e());
                }
                n69Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                n69Var2.r(true);
                n69 n69Var3 = n69Var2;
                n69 g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    n69Var3.x(g.f());
                    n69Var3.t(g.b());
                    n69Var3.o(g.a());
                    n69Var3.w(g.e());
                }
                n69Var3.y(0);
                return n69Var3;
            } else {
                n69 n69Var4 = n69Var2;
                if (b.equals("router/forumRulesEditPage")) {
                    n69Var4.r(true);
                    n69 j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        n69Var4.x(j.f());
                        n69Var4.t(j.b());
                        n69Var4.o(j.a());
                        n69Var4.w(j.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("router/goToBarDetail")) {
                    n69Var4.r(true);
                    n69 h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        n69Var4.x(h.f());
                        n69Var4.t(h.b());
                        n69Var4.o(h.a());
                        n69Var4.w(h.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    n69Var4.r(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    n69 s = this.mJsBridge.s(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (s != null) {
                        n69Var4.x(s.f());
                        n69Var4.t(s.b());
                        n69Var4.o(s.a());
                        n69Var4.w(s.e());
                        if (!n69Var4.h()) {
                            n69Var4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", n69Var4, false);
                        }
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    n69Var4.r(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    n69 r = this.mJsBridge.r(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (r != null) {
                        n69Var4.x(r.f());
                        n69Var4.t(r.b());
                        n69Var4.o(r.a());
                        n69Var4.w(r.e());
                        if (!n69Var4.h()) {
                            n69Var4.n(false);
                            addObserver(webView, "goToReportThreadPage", n69Var4, false);
                        }
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("router/goToEditPost")) {
                    n69Var4.r(true);
                    n69 f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        n69Var4.x(f.f());
                        n69Var4.t(f.b());
                        n69Var4.o(f.a());
                        n69Var4.w(f.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("router/jumpToVideo")) {
                    n69Var4.r(true);
                    n69 l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        n69Var4.x(l.f());
                        n69Var4.t(l.b());
                        n69Var4.o(l.a());
                        n69Var4.w(l.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    n69Var4.r(true);
                    n69 n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        n69Var4.x(n.f());
                        n69Var4.t(n.b());
                        n69Var4.o(n.a());
                        n69Var4.w(n.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (!b.equals("router/jumpToHTMLPage")) {
                    return n69Var4;
                } else {
                    n69Var4.r(true);
                    n69 k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        n69Var4.x(k.f());
                        n69Var4.t(k.b());
                        n69Var4.o(k.a());
                        n69Var4.w(k.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                }
            }
            return n69Var2;
        }
        return (n69) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.l69
    public List<n69> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            n69 n69Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                n69Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                n69Var = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                n69Var = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                n69Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                n69Var = this.mJsBridge.q(webView, hashMap);
            }
            if (n69Var != null) {
                n69Var.y(0);
            }
            List<m69> list = this.mAsyncCallBackMethodList.get(str);
            if (n69Var != null && list != null) {
                Iterator<m69> it = list.iterator();
                if (!TextUtils.isEmpty(n69Var.e())) {
                    while (it.hasNext()) {
                        m69 next = it.next();
                        if (next.b().equals(n69Var.e())) {
                            n69 n69Var2 = new n69();
                            n69Var2.v(next.a());
                            n69Var2.x(n69Var.f());
                            n69Var2.t(n69Var.b());
                            n69Var2.o(n69Var.a());
                            n69Var2.z(n69Var.l());
                            arrayList.add(n69Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        m69 next2 = it.next();
                        n69 n69Var3 = new n69();
                        n69Var3.v(next2.a());
                        n69Var3.x(n69Var.f());
                        n69Var3.t(n69Var.b());
                        n69Var3.o(n69Var.a());
                        n69Var3.z(n69Var.l());
                        arrayList.add(n69Var3);
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
