package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.is9;
import com.baidu.tieba.js9;
import com.baidu.tieba.kh6;
import com.baidu.tieba.ks9;
import com.baidu.tieba.ms9;
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
public class RouterJsBridgePlugin_Proxy extends is9 {
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

    @Override // com.baidu.tieba.is9
    public ks9 dispatch(WebView webView, ms9 ms9Var, ks9 ks9Var) {
        InterceptResult invokeLLL;
        ks9 ks9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ms9Var, ks9Var)) == null) {
            if (ks9Var == null) {
                ks9Var2 = new ks9();
            } else {
                ks9Var2 = ks9Var;
            }
            String b = ms9Var.b();
            JSONObject e = ms9Var.e();
            if (b.equals("router/finishThisPage")) {
                ks9Var2.s(true);
                ks9 c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    ks9Var2.y(c.f());
                    ks9Var2.u(c.b());
                    ks9Var2.o(c.a());
                    ks9Var2.x(c.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("router/portal")) {
                ks9Var2.s(true);
                ks9 i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (i != null) {
                    ks9Var2.y(i.f());
                    ks9Var2.u(i.b());
                    ks9Var2.o(i.a());
                    ks9Var2.x(i.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                ks9Var2.s(true);
                ks9 ks9Var3 = ks9Var2;
                ks9 g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    ks9Var3.y(g.f());
                    ks9Var3.u(g.b());
                    ks9Var3.o(g.a());
                    ks9Var3.x(g.e());
                }
                ks9Var3.z(0);
                return ks9Var3;
            } else {
                ks9 ks9Var4 = ks9Var2;
                if (b.equals("router/forumRulesEditPage")) {
                    ks9Var4.s(true);
                    ks9 j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        ks9Var4.y(j.f());
                        ks9Var4.u(j.b());
                        ks9Var4.o(j.a());
                        ks9Var4.x(j.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("router/goToBarDetail")) {
                    ks9Var4.s(true);
                    ks9 h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        ks9Var4.y(h.f());
                        ks9Var4.u(h.b());
                        ks9Var4.o(h.a());
                        ks9Var4.x(h.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    ks9Var4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    ks9 s = this.mJsBridge.s(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (s != null) {
                        ks9Var4.y(s.f());
                        ks9Var4.u(s.b());
                        ks9Var4.o(s.a());
                        ks9Var4.x(s.e());
                        if (!ks9Var4.h()) {
                            ks9Var4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", ks9Var4, false);
                        }
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    ks9Var4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    ks9 r = this.mJsBridge.r(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (r != null) {
                        ks9Var4.y(r.f());
                        ks9Var4.u(r.b());
                        ks9Var4.o(r.a());
                        ks9Var4.x(r.e());
                        if (!ks9Var4.h()) {
                            ks9Var4.n(false);
                            addObserver(webView, "goToReportThreadPage", ks9Var4, false);
                        }
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("router/goToEditPost")) {
                    ks9Var4.s(true);
                    ks9 f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        ks9Var4.y(f.f());
                        ks9Var4.u(f.b());
                        ks9Var4.o(f.a());
                        ks9Var4.x(f.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("router/jumpToVideo")) {
                    ks9Var4.s(true);
                    ks9 l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        ks9Var4.y(l.f());
                        ks9Var4.u(l.b());
                        ks9Var4.o(l.a());
                        ks9Var4.x(l.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    ks9Var4.s(true);
                    ks9 n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        ks9Var4.y(n.f());
                        ks9Var4.u(n.b());
                        ks9Var4.o(n.a());
                        ks9Var4.x(n.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (!b.equals("router/jumpToHTMLPage")) {
                    return ks9Var4;
                } else {
                    ks9Var4.s(true);
                    ks9 k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        ks9Var4.y(k.f());
                        ks9Var4.u(k.b());
                        ks9Var4.o(k.a());
                        ks9Var4.x(k.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                }
            }
            return ks9Var2;
        }
        return (ks9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.is9
    public kh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (kh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.is9
    public List<ks9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ks9 ks9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                ks9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                ks9Var = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                ks9Var = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                ks9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                ks9Var = this.mJsBridge.q(webView, hashMap);
            }
            if (ks9Var != null) {
                ks9Var.z(0);
            }
            List<js9> list = this.mAsyncCallBackMethodList.get(str);
            if (ks9Var != null && list != null) {
                Iterator<js9> it = list.iterator();
                if (!TextUtils.isEmpty(ks9Var.e())) {
                    while (it.hasNext()) {
                        js9 next = it.next();
                        if (next.b().equals(ks9Var.e())) {
                            ks9 ks9Var2 = new ks9();
                            ks9Var2.w(next.a());
                            ks9Var2.y(ks9Var.f());
                            ks9Var2.u(ks9Var.b());
                            ks9Var2.o(ks9Var.a());
                            ks9Var2.A(ks9Var.l());
                            arrayList.add(ks9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        js9 next2 = it.next();
                        ks9 ks9Var3 = new ks9();
                        ks9Var3.w(next2.a());
                        ks9Var3.y(ks9Var.f());
                        ks9Var3.u(ks9Var.b());
                        ks9Var3.o(ks9Var.a());
                        ks9Var3.A(ks9Var.l());
                        arrayList.add(ks9Var3);
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
