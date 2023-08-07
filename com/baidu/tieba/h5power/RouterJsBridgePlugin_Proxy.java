package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.hca;
import com.baidu.tieba.ica;
import com.baidu.tieba.jca;
import com.baidu.tieba.lca;
import com.baidu.tieba.pk6;
import com.baidu.tieba.px4;
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
public class RouterJsBridgePlugin_Proxy extends hca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public px4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(px4 px4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {px4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = px4Var;
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

    @Override // com.baidu.tieba.hca
    public jca dispatch(WebView webView, lca lcaVar, jca jcaVar) {
        InterceptResult invokeLLL;
        jca jcaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, lcaVar, jcaVar)) == null) {
            if (jcaVar == null) {
                jcaVar2 = new jca();
            } else {
                jcaVar2 = jcaVar;
            }
            String b = lcaVar.b();
            JSONObject e = lcaVar.e();
            if (b.equals("router/finishThisPage")) {
                jcaVar2.s(true);
                jca c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    jcaVar2.y(c.f());
                    jcaVar2.u(c.b());
                    jcaVar2.o(c.a());
                    jcaVar2.x(c.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("router/portal")) {
                jcaVar2.s(true);
                jca i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (i != null) {
                    jcaVar2.y(i.f());
                    jcaVar2.u(i.b());
                    jcaVar2.o(i.a());
                    jcaVar2.x(i.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                jcaVar2.s(true);
                jca jcaVar3 = jcaVar2;
                jca g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    jcaVar3.y(g.f());
                    jcaVar3.u(g.b());
                    jcaVar3.o(g.a());
                    jcaVar3.x(g.e());
                }
                jcaVar3.z(0);
                return jcaVar3;
            } else {
                jca jcaVar4 = jcaVar2;
                if (b.equals("router/forumRulesEditPage")) {
                    jcaVar4.s(true);
                    jca j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        jcaVar4.y(j.f());
                        jcaVar4.u(j.b());
                        jcaVar4.o(j.a());
                        jcaVar4.x(j.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("router/goToBarDetail")) {
                    jcaVar4.s(true);
                    jca h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        jcaVar4.y(h.f());
                        jcaVar4.u(h.b());
                        jcaVar4.o(h.a());
                        jcaVar4.x(h.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    jcaVar4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    jca u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        jcaVar4.y(u.f());
                        jcaVar4.u(u.b());
                        jcaVar4.o(u.a());
                        jcaVar4.x(u.e());
                        if (!jcaVar4.h()) {
                            jcaVar4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", jcaVar4, false);
                        }
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    jcaVar4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    jca t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        jcaVar4.y(t.f());
                        jcaVar4.u(t.b());
                        jcaVar4.o(t.a());
                        jcaVar4.x(t.e());
                        if (!jcaVar4.h()) {
                            jcaVar4.n(false);
                            addObserver(webView, "goToReportThreadPage", jcaVar4, false);
                        }
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("router/goToEditPost")) {
                    jcaVar4.s(true);
                    jca f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        jcaVar4.y(f.f());
                        jcaVar4.u(f.b());
                        jcaVar4.o(f.a());
                        jcaVar4.x(f.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("router/jumpToVideo")) {
                    jcaVar4.s(true);
                    jca l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        jcaVar4.y(l.f());
                        jcaVar4.u(l.b());
                        jcaVar4.o(l.a());
                        jcaVar4.x(l.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    jcaVar4.s(true);
                    jca n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        jcaVar4.y(n.f());
                        jcaVar4.u(n.b());
                        jcaVar4.o(n.a());
                        jcaVar4.x(n.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    jcaVar4.s(true);
                    jca k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        jcaVar4.y(k.f());
                        jcaVar4.u(k.b());
                        jcaVar4.o(k.a());
                        jcaVar4.x(k.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (!b.equals("router/replyPost")) {
                    return jcaVar4;
                } else {
                    jcaVar4.s(true);
                    jca r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        jcaVar4.y(r.f());
                        jcaVar4.u(r.b());
                        jcaVar4.o(r.a());
                        jcaVar4.x(r.e());
                        if (!jcaVar4.h()) {
                            jcaVar4.n(false);
                            addObserver(webView, "replyPostResult", jcaVar4, false);
                        }
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                }
            }
            return jcaVar2;
        }
        return (jca) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.hca
    public pk6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (pk6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hca
    public List<jca> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            jca jcaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                jcaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                jcaVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                jcaVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                jcaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                jcaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                jcaVar = this.mJsBridge.s(webView, hashMap);
            }
            if (jcaVar != null) {
                jcaVar.z(0);
            }
            List<ica> list = this.mAsyncCallBackMethodList.get(str);
            if (jcaVar != null && list != null) {
                Iterator<ica> it = list.iterator();
                if (!TextUtils.isEmpty(jcaVar.e())) {
                    while (it.hasNext()) {
                        ica next = it.next();
                        if (next.b().equals(jcaVar.e())) {
                            jca jcaVar2 = new jca();
                            jcaVar2.w(next.a());
                            jcaVar2.y(jcaVar.f());
                            jcaVar2.u(jcaVar.b());
                            jcaVar2.o(jcaVar.a());
                            jcaVar2.A(jcaVar.l());
                            arrayList.add(jcaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        ica next2 = it.next();
                        jca jcaVar3 = new jca();
                        jcaVar3.w(next2.a());
                        jcaVar3.y(jcaVar.f());
                        jcaVar3.u(jcaVar.b());
                        jcaVar3.o(jcaVar.a());
                        jcaVar3.A(jcaVar.l());
                        arrayList.add(jcaVar3);
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
