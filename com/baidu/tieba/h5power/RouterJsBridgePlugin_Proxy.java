package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.du4;
import com.baidu.tieba.im9;
import com.baidu.tieba.jm9;
import com.baidu.tieba.km9;
import com.baidu.tieba.mm9;
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
public class RouterJsBridgePlugin_Proxy extends im9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public du4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(du4 du4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {du4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = du4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_HIDE);
        this.mNotificationNameList.add("goToSelectPrivateMsgPage");
        this.mNotificationNameList.add("goToReportThreadPage");
        this.mNotificationNameList.add(CommonTbJsBridge.REFRESH_TAIL);
    }

    @Override // com.baidu.tieba.im9
    public km9 dispatch(WebView webView, mm9 mm9Var, km9 km9Var) {
        InterceptResult invokeLLL;
        km9 km9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, mm9Var, km9Var)) == null) {
            if (km9Var == null) {
                km9Var2 = new km9();
            } else {
                km9Var2 = km9Var;
            }
            String b = mm9Var.b();
            JSONObject e = mm9Var.e();
            if (b.equals("router/finishThisPage")) {
                km9Var2.r(true);
                km9 c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    km9Var2.x(c.f());
                    km9Var2.t(c.b());
                    km9Var2.o(c.a());
                    km9Var2.w(c.e());
                }
                km9Var2.y(0);
            } else if (b.equals("router/portal")) {
                km9Var2.r(true);
                km9 i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (i != null) {
                    km9Var2.x(i.f());
                    km9Var2.t(i.b());
                    km9Var2.o(i.a());
                    km9Var2.w(i.e());
                }
                km9Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                km9Var2.r(true);
                km9 km9Var3 = km9Var2;
                km9 g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    km9Var3.x(g.f());
                    km9Var3.t(g.b());
                    km9Var3.o(g.a());
                    km9Var3.w(g.e());
                }
                km9Var3.y(0);
                return km9Var3;
            } else {
                km9 km9Var4 = km9Var2;
                if (b.equals("router/forumRulesEditPage")) {
                    km9Var4.r(true);
                    km9 j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        km9Var4.x(j.f());
                        km9Var4.t(j.b());
                        km9Var4.o(j.a());
                        km9Var4.w(j.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("router/goToBarDetail")) {
                    km9Var4.r(true);
                    km9 h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        km9Var4.x(h.f());
                        km9Var4.t(h.b());
                        km9Var4.o(h.a());
                        km9Var4.w(h.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    km9Var4.r(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    km9 s = this.mJsBridge.s(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (s != null) {
                        km9Var4.x(s.f());
                        km9Var4.t(s.b());
                        km9Var4.o(s.a());
                        km9Var4.w(s.e());
                        if (!km9Var4.h()) {
                            km9Var4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", km9Var4, false);
                        }
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    km9Var4.r(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    km9 r = this.mJsBridge.r(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (r != null) {
                        km9Var4.x(r.f());
                        km9Var4.t(r.b());
                        km9Var4.o(r.a());
                        km9Var4.w(r.e());
                        if (!km9Var4.h()) {
                            km9Var4.n(false);
                            addObserver(webView, "goToReportThreadPage", km9Var4, false);
                        }
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("router/goToEditPost")) {
                    km9Var4.r(true);
                    km9 f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        km9Var4.x(f.f());
                        km9Var4.t(f.b());
                        km9Var4.o(f.a());
                        km9Var4.w(f.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("router/jumpToVideo")) {
                    km9Var4.r(true);
                    km9 l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        km9Var4.x(l.f());
                        km9Var4.t(l.b());
                        km9Var4.o(l.a());
                        km9Var4.w(l.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    km9Var4.r(true);
                    km9 n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        km9Var4.x(n.f());
                        km9Var4.t(n.b());
                        km9Var4.o(n.a());
                        km9Var4.w(n.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (!b.equals("router/jumpToHTMLPage")) {
                    return km9Var4;
                } else {
                    km9Var4.r(true);
                    km9 k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        km9Var4.x(k.f());
                        km9Var4.t(k.b());
                        km9Var4.o(k.a());
                        km9Var4.w(k.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                }
            }
            return km9Var2;
        }
        return (km9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.im9
    public List<km9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            km9 km9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                km9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                km9Var = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                km9Var = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                km9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                km9Var = this.mJsBridge.q(webView, hashMap);
            }
            if (km9Var != null) {
                km9Var.y(0);
            }
            List<jm9> list = this.mAsyncCallBackMethodList.get(str);
            if (km9Var != null && list != null) {
                Iterator<jm9> it = list.iterator();
                if (!TextUtils.isEmpty(km9Var.e())) {
                    while (it.hasNext()) {
                        jm9 next = it.next();
                        if (next.b().equals(km9Var.e())) {
                            km9 km9Var2 = new km9();
                            km9Var2.v(next.a());
                            km9Var2.x(km9Var.f());
                            km9Var2.t(km9Var.b());
                            km9Var2.o(km9Var.a());
                            km9Var2.z(km9Var.l());
                            arrayList.add(km9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        jm9 next2 = it.next();
                        km9 km9Var3 = new km9();
                        km9Var3.v(next2.a());
                        km9Var3.x(km9Var.f());
                        km9Var3.t(km9Var.b());
                        km9Var3.o(km9Var.a());
                        km9Var3.z(km9Var.l());
                        arrayList.add(km9Var3);
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
