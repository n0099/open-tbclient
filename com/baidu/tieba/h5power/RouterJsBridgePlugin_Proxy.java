package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.ry4;
import com.baidu.tieba.sl6;
import com.baidu.tieba.uy9;
import com.baidu.tieba.vy9;
import com.baidu.tieba.wy9;
import com.baidu.tieba.yy9;
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
public class RouterJsBridgePlugin_Proxy extends uy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ry4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(ry4 ry4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ry4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ry4Var;
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

    @Override // com.baidu.tieba.uy9
    public wy9 dispatch(WebView webView, yy9 yy9Var, wy9 wy9Var) {
        InterceptResult invokeLLL;
        wy9 wy9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, yy9Var, wy9Var)) == null) {
            if (wy9Var == null) {
                wy9Var2 = new wy9();
            } else {
                wy9Var2 = wy9Var;
            }
            String b = yy9Var.b();
            JSONObject e = yy9Var.e();
            if (b.equals("router/finishThisPage")) {
                wy9Var2.s(true);
                wy9 c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    wy9Var2.y(c.f());
                    wy9Var2.u(c.b());
                    wy9Var2.o(c.a());
                    wy9Var2.x(c.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("router/portal")) {
                wy9Var2.s(true);
                wy9 i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (i != null) {
                    wy9Var2.y(i.f());
                    wy9Var2.u(i.b());
                    wy9Var2.o(i.a());
                    wy9Var2.x(i.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                wy9Var2.s(true);
                wy9 wy9Var3 = wy9Var2;
                wy9 g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    wy9Var3.y(g.f());
                    wy9Var3.u(g.b());
                    wy9Var3.o(g.a());
                    wy9Var3.x(g.e());
                }
                wy9Var3.z(0);
                return wy9Var3;
            } else {
                wy9 wy9Var4 = wy9Var2;
                if (b.equals("router/forumRulesEditPage")) {
                    wy9Var4.s(true);
                    wy9 j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        wy9Var4.y(j.f());
                        wy9Var4.u(j.b());
                        wy9Var4.o(j.a());
                        wy9Var4.x(j.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("router/goToBarDetail")) {
                    wy9Var4.s(true);
                    wy9 h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        wy9Var4.y(h.f());
                        wy9Var4.u(h.b());
                        wy9Var4.o(h.a());
                        wy9Var4.x(h.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    wy9Var4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    wy9 u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        wy9Var4.y(u.f());
                        wy9Var4.u(u.b());
                        wy9Var4.o(u.a());
                        wy9Var4.x(u.e());
                        if (!wy9Var4.h()) {
                            wy9Var4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", wy9Var4, false);
                        }
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    wy9Var4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    wy9 t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        wy9Var4.y(t.f());
                        wy9Var4.u(t.b());
                        wy9Var4.o(t.a());
                        wy9Var4.x(t.e());
                        if (!wy9Var4.h()) {
                            wy9Var4.n(false);
                            addObserver(webView, "goToReportThreadPage", wy9Var4, false);
                        }
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("router/goToEditPost")) {
                    wy9Var4.s(true);
                    wy9 f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        wy9Var4.y(f.f());
                        wy9Var4.u(f.b());
                        wy9Var4.o(f.a());
                        wy9Var4.x(f.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("router/jumpToVideo")) {
                    wy9Var4.s(true);
                    wy9 l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        wy9Var4.y(l.f());
                        wy9Var4.u(l.b());
                        wy9Var4.o(l.a());
                        wy9Var4.x(l.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    wy9Var4.s(true);
                    wy9 n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        wy9Var4.y(n.f());
                        wy9Var4.u(n.b());
                        wy9Var4.o(n.a());
                        wy9Var4.x(n.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    wy9Var4.s(true);
                    wy9 k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        wy9Var4.y(k.f());
                        wy9Var4.u(k.b());
                        wy9Var4.o(k.a());
                        wy9Var4.x(k.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (!b.equals("router/replyPost")) {
                    return wy9Var4;
                } else {
                    wy9Var4.s(true);
                    wy9 r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        wy9Var4.y(r.f());
                        wy9Var4.u(r.b());
                        wy9Var4.o(r.a());
                        wy9Var4.x(r.e());
                        if (!wy9Var4.h()) {
                            wy9Var4.n(false);
                            addObserver(webView, "replyPostResult", wy9Var4, false);
                        }
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                }
            }
            return wy9Var2;
        }
        return (wy9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.uy9
    public sl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (sl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uy9
    public List<wy9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            wy9 wy9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                wy9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                wy9Var = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                wy9Var = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                wy9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                wy9Var = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                wy9Var = this.mJsBridge.s(webView, hashMap);
            }
            if (wy9Var != null) {
                wy9Var.z(0);
            }
            List<vy9> list = this.mAsyncCallBackMethodList.get(str);
            if (wy9Var != null && list != null) {
                Iterator<vy9> it = list.iterator();
                if (!TextUtils.isEmpty(wy9Var.e())) {
                    while (it.hasNext()) {
                        vy9 next = it.next();
                        if (next.b().equals(wy9Var.e())) {
                            wy9 wy9Var2 = new wy9();
                            wy9Var2.w(next.a());
                            wy9Var2.y(wy9Var.f());
                            wy9Var2.u(wy9Var.b());
                            wy9Var2.o(wy9Var.a());
                            wy9Var2.A(wy9Var.l());
                            arrayList.add(wy9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        vy9 next2 = it.next();
                        wy9 wy9Var3 = new wy9();
                        wy9Var3.w(next2.a());
                        wy9Var3.y(wy9Var.f());
                        wy9Var3.u(wy9Var.b());
                        wy9Var3.o(wy9Var.a());
                        wy9Var3.A(wy9Var.l());
                        arrayList.add(wy9Var3);
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
