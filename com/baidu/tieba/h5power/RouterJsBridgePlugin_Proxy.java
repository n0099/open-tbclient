package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.az9;
import com.baidu.tieba.bz9;
import com.baidu.tieba.dz9;
import com.baidu.tieba.ry4;
import com.baidu.tieba.ul6;
import com.baidu.tieba.zy9;
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
public class RouterJsBridgePlugin_Proxy extends zy9 {
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

    @Override // com.baidu.tieba.zy9
    public bz9 dispatch(WebView webView, dz9 dz9Var, bz9 bz9Var) {
        InterceptResult invokeLLL;
        bz9 bz9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, dz9Var, bz9Var)) == null) {
            if (bz9Var == null) {
                bz9Var2 = new bz9();
            } else {
                bz9Var2 = bz9Var;
            }
            String b = dz9Var.b();
            JSONObject e = dz9Var.e();
            if (b.equals("router/finishThisPage")) {
                bz9Var2.s(true);
                bz9 c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    bz9Var2.y(c.f());
                    bz9Var2.u(c.b());
                    bz9Var2.o(c.a());
                    bz9Var2.x(c.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("router/portal")) {
                bz9Var2.s(true);
                bz9 i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (i != null) {
                    bz9Var2.y(i.f());
                    bz9Var2.u(i.b());
                    bz9Var2.o(i.a());
                    bz9Var2.x(i.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                bz9Var2.s(true);
                bz9 bz9Var3 = bz9Var2;
                bz9 g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    bz9Var3.y(g.f());
                    bz9Var3.u(g.b());
                    bz9Var3.o(g.a());
                    bz9Var3.x(g.e());
                }
                bz9Var3.z(0);
                return bz9Var3;
            } else {
                bz9 bz9Var4 = bz9Var2;
                if (b.equals("router/forumRulesEditPage")) {
                    bz9Var4.s(true);
                    bz9 j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        bz9Var4.y(j.f());
                        bz9Var4.u(j.b());
                        bz9Var4.o(j.a());
                        bz9Var4.x(j.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("router/goToBarDetail")) {
                    bz9Var4.s(true);
                    bz9 h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        bz9Var4.y(h.f());
                        bz9Var4.u(h.b());
                        bz9Var4.o(h.a());
                        bz9Var4.x(h.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    bz9Var4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    bz9 u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        bz9Var4.y(u.f());
                        bz9Var4.u(u.b());
                        bz9Var4.o(u.a());
                        bz9Var4.x(u.e());
                        if (!bz9Var4.h()) {
                            bz9Var4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", bz9Var4, false);
                        }
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    bz9Var4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    bz9 t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        bz9Var4.y(t.f());
                        bz9Var4.u(t.b());
                        bz9Var4.o(t.a());
                        bz9Var4.x(t.e());
                        if (!bz9Var4.h()) {
                            bz9Var4.n(false);
                            addObserver(webView, "goToReportThreadPage", bz9Var4, false);
                        }
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("router/goToEditPost")) {
                    bz9Var4.s(true);
                    bz9 f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        bz9Var4.y(f.f());
                        bz9Var4.u(f.b());
                        bz9Var4.o(f.a());
                        bz9Var4.x(f.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("router/jumpToVideo")) {
                    bz9Var4.s(true);
                    bz9 l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        bz9Var4.y(l.f());
                        bz9Var4.u(l.b());
                        bz9Var4.o(l.a());
                        bz9Var4.x(l.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    bz9Var4.s(true);
                    bz9 n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        bz9Var4.y(n.f());
                        bz9Var4.u(n.b());
                        bz9Var4.o(n.a());
                        bz9Var4.x(n.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    bz9Var4.s(true);
                    bz9 k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        bz9Var4.y(k.f());
                        bz9Var4.u(k.b());
                        bz9Var4.o(k.a());
                        bz9Var4.x(k.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (!b.equals("router/replyPost")) {
                    return bz9Var4;
                } else {
                    bz9Var4.s(true);
                    bz9 r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        bz9Var4.y(r.f());
                        bz9Var4.u(r.b());
                        bz9Var4.o(r.a());
                        bz9Var4.x(r.e());
                        if (!bz9Var4.h()) {
                            bz9Var4.n(false);
                            addObserver(webView, "replyPostResult", bz9Var4, false);
                        }
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                }
            }
            return bz9Var2;
        }
        return (bz9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public ul6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (ul6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public List<bz9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            bz9 bz9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                bz9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                bz9Var = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                bz9Var = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                bz9Var = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                bz9Var = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                bz9Var = this.mJsBridge.s(webView, hashMap);
            }
            if (bz9Var != null) {
                bz9Var.z(0);
            }
            List<az9> list = this.mAsyncCallBackMethodList.get(str);
            if (bz9Var != null && list != null) {
                Iterator<az9> it = list.iterator();
                if (!TextUtils.isEmpty(bz9Var.e())) {
                    while (it.hasNext()) {
                        az9 next = it.next();
                        if (next.b().equals(bz9Var.e())) {
                            bz9 bz9Var2 = new bz9();
                            bz9Var2.w(next.a());
                            bz9Var2.y(bz9Var.f());
                            bz9Var2.u(bz9Var.b());
                            bz9Var2.o(bz9Var.a());
                            bz9Var2.A(bz9Var.l());
                            arrayList.add(bz9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        az9 next2 = it.next();
                        bz9 bz9Var3 = new bz9();
                        bz9Var3.w(next2.a());
                        bz9Var3.y(bz9Var.f());
                        bz9Var3.u(bz9Var.b());
                        bz9Var3.o(bz9Var.a());
                        bz9Var3.A(bz9Var.l());
                        arrayList.add(bz9Var3);
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
