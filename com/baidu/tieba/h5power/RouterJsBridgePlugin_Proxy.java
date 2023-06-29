package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.d5a;
import com.baidu.tieba.e5a;
import com.baidu.tieba.em6;
import com.baidu.tieba.f5a;
import com.baidu.tieba.h5a;
import com.baidu.tieba.vy4;
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
public class RouterJsBridgePlugin_Proxy extends d5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vy4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(vy4 vy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = vy4Var;
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

    @Override // com.baidu.tieba.d5a
    public f5a dispatch(WebView webView, h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLLL;
        f5a f5aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, h5aVar, f5aVar)) == null) {
            if (f5aVar == null) {
                f5aVar2 = new f5a();
            } else {
                f5aVar2 = f5aVar;
            }
            String b = h5aVar.b();
            JSONObject e = h5aVar.e();
            if (b.equals("router/finishThisPage")) {
                f5aVar2.s(true);
                f5a c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    f5aVar2.y(c.f());
                    f5aVar2.u(c.b());
                    f5aVar2.o(c.a());
                    f5aVar2.x(c.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("router/portal")) {
                f5aVar2.s(true);
                f5a i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (i != null) {
                    f5aVar2.y(i.f());
                    f5aVar2.u(i.b());
                    f5aVar2.o(i.a());
                    f5aVar2.x(i.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                f5aVar2.s(true);
                f5a f5aVar3 = f5aVar2;
                f5a g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    f5aVar3.y(g.f());
                    f5aVar3.u(g.b());
                    f5aVar3.o(g.a());
                    f5aVar3.x(g.e());
                }
                f5aVar3.z(0);
                return f5aVar3;
            } else {
                f5a f5aVar4 = f5aVar2;
                if (b.equals("router/forumRulesEditPage")) {
                    f5aVar4.s(true);
                    f5a j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        f5aVar4.y(j.f());
                        f5aVar4.u(j.b());
                        f5aVar4.o(j.a());
                        f5aVar4.x(j.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("router/goToBarDetail")) {
                    f5aVar4.s(true);
                    f5a h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        f5aVar4.y(h.f());
                        f5aVar4.u(h.b());
                        f5aVar4.o(h.a());
                        f5aVar4.x(h.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    f5aVar4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    f5a u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        f5aVar4.y(u.f());
                        f5aVar4.u(u.b());
                        f5aVar4.o(u.a());
                        f5aVar4.x(u.e());
                        if (!f5aVar4.h()) {
                            f5aVar4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", f5aVar4, false);
                        }
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    f5aVar4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    f5a t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        f5aVar4.y(t.f());
                        f5aVar4.u(t.b());
                        f5aVar4.o(t.a());
                        f5aVar4.x(t.e());
                        if (!f5aVar4.h()) {
                            f5aVar4.n(false);
                            addObserver(webView, "goToReportThreadPage", f5aVar4, false);
                        }
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("router/goToEditPost")) {
                    f5aVar4.s(true);
                    f5a f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        f5aVar4.y(f.f());
                        f5aVar4.u(f.b());
                        f5aVar4.o(f.a());
                        f5aVar4.x(f.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("router/jumpToVideo")) {
                    f5aVar4.s(true);
                    f5a l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        f5aVar4.y(l.f());
                        f5aVar4.u(l.b());
                        f5aVar4.o(l.a());
                        f5aVar4.x(l.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    f5aVar4.s(true);
                    f5a n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        f5aVar4.y(n.f());
                        f5aVar4.u(n.b());
                        f5aVar4.o(n.a());
                        f5aVar4.x(n.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    f5aVar4.s(true);
                    f5a k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        f5aVar4.y(k.f());
                        f5aVar4.u(k.b());
                        f5aVar4.o(k.a());
                        f5aVar4.x(k.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (!b.equals("router/replyPost")) {
                    return f5aVar4;
                } else {
                    f5aVar4.s(true);
                    f5a r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        f5aVar4.y(r.f());
                        f5aVar4.u(r.b());
                        f5aVar4.o(r.a());
                        f5aVar4.x(r.e());
                        if (!f5aVar4.h()) {
                            f5aVar4.n(false);
                            addObserver(webView, "replyPostResult", f5aVar4, false);
                        }
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                }
            }
            return f5aVar2;
        }
        return (f5a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public em6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (em6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public List<f5a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            f5a f5aVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                f5aVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                f5aVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                f5aVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                f5aVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                f5aVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                f5aVar = this.mJsBridge.s(webView, hashMap);
            }
            if (f5aVar != null) {
                f5aVar.z(0);
            }
            List<e5a> list = this.mAsyncCallBackMethodList.get(str);
            if (f5aVar != null && list != null) {
                Iterator<e5a> it = list.iterator();
                if (!TextUtils.isEmpty(f5aVar.e())) {
                    while (it.hasNext()) {
                        e5a next = it.next();
                        if (next.b().equals(f5aVar.e())) {
                            f5a f5aVar2 = new f5a();
                            f5aVar2.w(next.a());
                            f5aVar2.y(f5aVar.f());
                            f5aVar2.u(f5aVar.b());
                            f5aVar2.o(f5aVar.a());
                            f5aVar2.A(f5aVar.l());
                            arrayList.add(f5aVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        e5a next2 = it.next();
                        f5a f5aVar3 = new f5a();
                        f5aVar3.w(next2.a());
                        f5aVar3.y(f5aVar.f());
                        f5aVar3.u(f5aVar.b());
                        f5aVar3.o(f5aVar.a());
                        f5aVar3.A(f5aVar.l());
                        arrayList.add(f5aVar3);
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
