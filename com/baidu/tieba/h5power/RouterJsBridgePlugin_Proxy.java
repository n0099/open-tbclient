package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.eu4;
import com.baidu.tieba.qm9;
import com.baidu.tieba.rm9;
import com.baidu.tieba.sm9;
import com.baidu.tieba.um9;
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
public class RouterJsBridgePlugin_Proxy extends qm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eu4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(eu4 eu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = eu4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_HIDE);
        this.mNotificationNameList.add("goToSelectPrivateMsgPage");
        this.mNotificationNameList.add("goToReportThreadPage");
        this.mNotificationNameList.add(CommonTbJsBridge.REFRESH_TAIL);
    }

    @Override // com.baidu.tieba.qm9
    public sm9 dispatch(WebView webView, um9 um9Var, sm9 sm9Var) {
        InterceptResult invokeLLL;
        sm9 sm9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, um9Var, sm9Var)) == null) {
            if (sm9Var == null) {
                sm9Var2 = new sm9();
            } else {
                sm9Var2 = sm9Var;
            }
            String b = um9Var.b();
            JSONObject e = um9Var.e();
            if (b.equals("router/finishThisPage")) {
                sm9Var2.r(true);
                sm9 c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    sm9Var2.x(c.f());
                    sm9Var2.t(c.b());
                    sm9Var2.o(c.a());
                    sm9Var2.w(c.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("router/portal")) {
                sm9Var2.r(true);
                sm9 i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (i != null) {
                    sm9Var2.x(i.f());
                    sm9Var2.t(i.b());
                    sm9Var2.o(i.a());
                    sm9Var2.w(i.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                sm9Var2.r(true);
                sm9 sm9Var3 = sm9Var2;
                sm9 g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    sm9Var3.x(g.f());
                    sm9Var3.t(g.b());
                    sm9Var3.o(g.a());
                    sm9Var3.w(g.e());
                }
                sm9Var3.y(0);
                return sm9Var3;
            } else {
                sm9 sm9Var4 = sm9Var2;
                if (b.equals("router/forumRulesEditPage")) {
                    sm9Var4.r(true);
                    sm9 j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        sm9Var4.x(j.f());
                        sm9Var4.t(j.b());
                        sm9Var4.o(j.a());
                        sm9Var4.w(j.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("router/goToBarDetail")) {
                    sm9Var4.r(true);
                    sm9 h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        sm9Var4.x(h.f());
                        sm9Var4.t(h.b());
                        sm9Var4.o(h.a());
                        sm9Var4.w(h.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    sm9Var4.r(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    sm9 s = this.mJsBridge.s(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (s != null) {
                        sm9Var4.x(s.f());
                        sm9Var4.t(s.b());
                        sm9Var4.o(s.a());
                        sm9Var4.w(s.e());
                        if (!sm9Var4.h()) {
                            sm9Var4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", sm9Var4, false);
                        }
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    sm9Var4.r(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    sm9 r = this.mJsBridge.r(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (r != null) {
                        sm9Var4.x(r.f());
                        sm9Var4.t(r.b());
                        sm9Var4.o(r.a());
                        sm9Var4.w(r.e());
                        if (!sm9Var4.h()) {
                            sm9Var4.n(false);
                            addObserver(webView, "goToReportThreadPage", sm9Var4, false);
                        }
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("router/goToEditPost")) {
                    sm9Var4.r(true);
                    sm9 f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        sm9Var4.x(f.f());
                        sm9Var4.t(f.b());
                        sm9Var4.o(f.a());
                        sm9Var4.w(f.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("router/jumpToVideo")) {
                    sm9Var4.r(true);
                    sm9 l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        sm9Var4.x(l.f());
                        sm9Var4.t(l.b());
                        sm9Var4.o(l.a());
                        sm9Var4.w(l.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    sm9Var4.r(true);
                    sm9 n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        sm9Var4.x(n.f());
                        sm9Var4.t(n.b());
                        sm9Var4.o(n.a());
                        sm9Var4.w(n.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (!b.equals("router/jumpToHTMLPage")) {
                    return sm9Var4;
                } else {
                    sm9Var4.r(true);
                    sm9 k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        sm9Var4.x(k.f());
                        sm9Var4.t(k.b());
                        sm9Var4.o(k.a());
                        sm9Var4.w(k.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                }
            }
            return sm9Var2;
        }
        return (sm9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qm9
    public List<sm9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            sm9 sm9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                sm9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                sm9Var = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                sm9Var = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                sm9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                sm9Var = this.mJsBridge.q(webView, hashMap);
            }
            if (sm9Var != null) {
                sm9Var.y(0);
            }
            List<rm9> list = this.mAsyncCallBackMethodList.get(str);
            if (sm9Var != null && list != null) {
                Iterator<rm9> it = list.iterator();
                if (!TextUtils.isEmpty(sm9Var.e())) {
                    while (it.hasNext()) {
                        rm9 next = it.next();
                        if (next.b().equals(sm9Var.e())) {
                            sm9 sm9Var2 = new sm9();
                            sm9Var2.v(next.a());
                            sm9Var2.x(sm9Var.f());
                            sm9Var2.t(sm9Var.b());
                            sm9Var2.o(sm9Var.a());
                            sm9Var2.z(sm9Var.l());
                            arrayList.add(sm9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rm9 next2 = it.next();
                        sm9 sm9Var3 = new sm9();
                        sm9Var3.v(next2.a());
                        sm9Var3.x(sm9Var.f());
                        sm9Var3.t(sm9Var.b());
                        sm9Var3.o(sm9Var.a());
                        sm9Var3.z(sm9Var.l());
                        arrayList.add(sm9Var3);
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
