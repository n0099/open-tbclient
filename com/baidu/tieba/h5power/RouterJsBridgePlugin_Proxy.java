package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.bu4;
import com.baidu.tieba.rc9;
import com.baidu.tieba.sc9;
import com.baidu.tieba.tc9;
import com.baidu.tieba.vc9;
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
public class RouterJsBridgePlugin_Proxy extends rc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bu4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(bu4 bu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = bu4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_HIDE);
        this.mNotificationNameList.add("goToSelectPrivateMsgPage");
        this.mNotificationNameList.add("goToReportThreadPage");
        this.mNotificationNameList.add(CommonTbJsBridge.REFRESH_TAIL);
    }

    @Override // com.baidu.tieba.rc9
    public tc9 dispatch(WebView webView, vc9 vc9Var, tc9 tc9Var) {
        InterceptResult invokeLLL;
        tc9 tc9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, vc9Var, tc9Var)) == null) {
            if (tc9Var == null) {
                tc9Var2 = new tc9();
            } else {
                tc9Var2 = tc9Var;
            }
            String b = vc9Var.b();
            JSONObject e = vc9Var.e();
            if (b.equals("router/finishThisPage")) {
                tc9Var2.r(true);
                tc9 c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    tc9Var2.x(c.f());
                    tc9Var2.t(c.b());
                    tc9Var2.o(c.a());
                    tc9Var2.w(c.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("router/portal")) {
                tc9Var2.r(true);
                tc9 i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (i != null) {
                    tc9Var2.x(i.f());
                    tc9Var2.t(i.b());
                    tc9Var2.o(i.a());
                    tc9Var2.w(i.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                tc9Var2.r(true);
                tc9 tc9Var3 = tc9Var2;
                tc9 g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    tc9Var3.x(g.f());
                    tc9Var3.t(g.b());
                    tc9Var3.o(g.a());
                    tc9Var3.w(g.e());
                }
                tc9Var3.y(0);
                return tc9Var3;
            } else {
                tc9 tc9Var4 = tc9Var2;
                if (b.equals("router/forumRulesEditPage")) {
                    tc9Var4.r(true);
                    tc9 j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        tc9Var4.x(j.f());
                        tc9Var4.t(j.b());
                        tc9Var4.o(j.a());
                        tc9Var4.w(j.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("router/goToBarDetail")) {
                    tc9Var4.r(true);
                    tc9 h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        tc9Var4.x(h.f());
                        tc9Var4.t(h.b());
                        tc9Var4.o(h.a());
                        tc9Var4.w(h.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    tc9Var4.r(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    tc9 s = this.mJsBridge.s(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (s != null) {
                        tc9Var4.x(s.f());
                        tc9Var4.t(s.b());
                        tc9Var4.o(s.a());
                        tc9Var4.w(s.e());
                        if (!tc9Var4.h()) {
                            tc9Var4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", tc9Var4, false);
                        }
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    tc9Var4.r(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    tc9 r = this.mJsBridge.r(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (r != null) {
                        tc9Var4.x(r.f());
                        tc9Var4.t(r.b());
                        tc9Var4.o(r.a());
                        tc9Var4.w(r.e());
                        if (!tc9Var4.h()) {
                            tc9Var4.n(false);
                            addObserver(webView, "goToReportThreadPage", tc9Var4, false);
                        }
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("router/goToEditPost")) {
                    tc9Var4.r(true);
                    tc9 f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        tc9Var4.x(f.f());
                        tc9Var4.t(f.b());
                        tc9Var4.o(f.a());
                        tc9Var4.w(f.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("router/jumpToVideo")) {
                    tc9Var4.r(true);
                    tc9 l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        tc9Var4.x(l.f());
                        tc9Var4.t(l.b());
                        tc9Var4.o(l.a());
                        tc9Var4.w(l.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    tc9Var4.r(true);
                    tc9 n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        tc9Var4.x(n.f());
                        tc9Var4.t(n.b());
                        tc9Var4.o(n.a());
                        tc9Var4.w(n.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (!b.equals("router/jumpToHTMLPage")) {
                    return tc9Var4;
                } else {
                    tc9Var4.r(true);
                    tc9 k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        tc9Var4.x(k.f());
                        tc9Var4.t(k.b());
                        tc9Var4.o(k.a());
                        tc9Var4.w(k.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                }
            }
            return tc9Var2;
        }
        return (tc9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.rc9
    public List<tc9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            tc9 tc9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                tc9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                tc9Var = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                tc9Var = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                tc9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                tc9Var = this.mJsBridge.q(webView, hashMap);
            }
            if (tc9Var != null) {
                tc9Var.y(0);
            }
            List<sc9> list = this.mAsyncCallBackMethodList.get(str);
            if (tc9Var != null && list != null) {
                Iterator<sc9> it = list.iterator();
                if (!TextUtils.isEmpty(tc9Var.e())) {
                    while (it.hasNext()) {
                        sc9 next = it.next();
                        if (next.b().equals(tc9Var.e())) {
                            tc9 tc9Var2 = new tc9();
                            tc9Var2.v(next.a());
                            tc9Var2.x(tc9Var.f());
                            tc9Var2.t(tc9Var.b());
                            tc9Var2.o(tc9Var.a());
                            tc9Var2.z(tc9Var.l());
                            arrayList.add(tc9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        sc9 next2 = it.next();
                        tc9 tc9Var3 = new tc9();
                        tc9Var3.v(next2.a());
                        tc9Var3.x(tc9Var.f());
                        tc9Var3.t(tc9Var.b());
                        tc9Var3.o(tc9Var.a());
                        tc9Var3.z(tc9Var.l());
                        arrayList.add(tc9Var3);
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
