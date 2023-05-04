package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.fq9;
import com.baidu.tieba.gq9;
import com.baidu.tieba.hq9;
import com.baidu.tieba.jq9;
import com.baidu.tieba.qu4;
import com.baidu.tieba.xf6;
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
public class RouterJsBridgePlugin_Proxy extends fq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qu4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(qu4 qu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = qu4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_HIDE);
        this.mNotificationNameList.add("goToSelectPrivateMsgPage");
        this.mNotificationNameList.add("goToReportThreadPage");
        this.mNotificationNameList.add(CommonTbJsBridge.REFRESH_TAIL);
    }

    @Override // com.baidu.tieba.fq9
    public hq9 dispatch(WebView webView, jq9 jq9Var, hq9 hq9Var) {
        InterceptResult invokeLLL;
        hq9 hq9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, jq9Var, hq9Var)) == null) {
            if (hq9Var == null) {
                hq9Var2 = new hq9();
            } else {
                hq9Var2 = hq9Var;
            }
            String b = jq9Var.b();
            JSONObject e = jq9Var.e();
            if (b.equals("router/finishThisPage")) {
                hq9Var2.s(true);
                hq9 c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    hq9Var2.y(c.f());
                    hq9Var2.u(c.b());
                    hq9Var2.o(c.a());
                    hq9Var2.x(c.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("router/portal")) {
                hq9Var2.s(true);
                hq9 i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (i != null) {
                    hq9Var2.y(i.f());
                    hq9Var2.u(i.b());
                    hq9Var2.o(i.a());
                    hq9Var2.x(i.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                hq9Var2.s(true);
                hq9 hq9Var3 = hq9Var2;
                hq9 g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    hq9Var3.y(g.f());
                    hq9Var3.u(g.b());
                    hq9Var3.o(g.a());
                    hq9Var3.x(g.e());
                }
                hq9Var3.z(0);
                return hq9Var3;
            } else {
                hq9 hq9Var4 = hq9Var2;
                if (b.equals("router/forumRulesEditPage")) {
                    hq9Var4.s(true);
                    hq9 j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        hq9Var4.y(j.f());
                        hq9Var4.u(j.b());
                        hq9Var4.o(j.a());
                        hq9Var4.x(j.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("router/goToBarDetail")) {
                    hq9Var4.s(true);
                    hq9 h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        hq9Var4.y(h.f());
                        hq9Var4.u(h.b());
                        hq9Var4.o(h.a());
                        hq9Var4.x(h.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    hq9Var4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    hq9 s = this.mJsBridge.s(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (s != null) {
                        hq9Var4.y(s.f());
                        hq9Var4.u(s.b());
                        hq9Var4.o(s.a());
                        hq9Var4.x(s.e());
                        if (!hq9Var4.h()) {
                            hq9Var4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", hq9Var4, false);
                        }
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    hq9Var4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    hq9 r = this.mJsBridge.r(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (r != null) {
                        hq9Var4.y(r.f());
                        hq9Var4.u(r.b());
                        hq9Var4.o(r.a());
                        hq9Var4.x(r.e());
                        if (!hq9Var4.h()) {
                            hq9Var4.n(false);
                            addObserver(webView, "goToReportThreadPage", hq9Var4, false);
                        }
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("router/goToEditPost")) {
                    hq9Var4.s(true);
                    hq9 f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        hq9Var4.y(f.f());
                        hq9Var4.u(f.b());
                        hq9Var4.o(f.a());
                        hq9Var4.x(f.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("router/jumpToVideo")) {
                    hq9Var4.s(true);
                    hq9 l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        hq9Var4.y(l.f());
                        hq9Var4.u(l.b());
                        hq9Var4.o(l.a());
                        hq9Var4.x(l.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    hq9Var4.s(true);
                    hq9 n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        hq9Var4.y(n.f());
                        hq9Var4.u(n.b());
                        hq9Var4.o(n.a());
                        hq9Var4.x(n.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (!b.equals("router/jumpToHTMLPage")) {
                    return hq9Var4;
                } else {
                    hq9Var4.s(true);
                    hq9 k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        hq9Var4.y(k.f());
                        hq9Var4.u(k.b());
                        hq9Var4.o(k.a());
                        hq9Var4.x(k.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                }
            }
            return hq9Var2;
        }
        return (hq9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public xf6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (xf6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public List<hq9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            hq9 hq9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                hq9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                hq9Var = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                hq9Var = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                hq9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                hq9Var = this.mJsBridge.q(webView, hashMap);
            }
            if (hq9Var != null) {
                hq9Var.z(0);
            }
            List<gq9> list = this.mAsyncCallBackMethodList.get(str);
            if (hq9Var != null && list != null) {
                Iterator<gq9> it = list.iterator();
                if (!TextUtils.isEmpty(hq9Var.e())) {
                    while (it.hasNext()) {
                        gq9 next = it.next();
                        if (next.b().equals(hq9Var.e())) {
                            hq9 hq9Var2 = new hq9();
                            hq9Var2.w(next.a());
                            hq9Var2.y(hq9Var.f());
                            hq9Var2.u(hq9Var.b());
                            hq9Var2.o(hq9Var.a());
                            hq9Var2.A(hq9Var.l());
                            arrayList.add(hq9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        gq9 next2 = it.next();
                        hq9 hq9Var3 = new hq9();
                        hq9Var3.w(next2.a());
                        hq9Var3.y(hq9Var.f());
                        hq9Var3.u(hq9Var.b());
                        hq9Var3.o(hq9Var.a());
                        hq9Var3.A(hq9Var.l());
                        arrayList.add(hq9Var3);
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
