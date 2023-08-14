package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.ica;
import com.baidu.tieba.jca;
import com.baidu.tieba.kca;
import com.baidu.tieba.mca;
import com.baidu.tieba.px4;
import com.baidu.tieba.qk6;
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
public class RouterJsBridgePlugin_Proxy extends ica {
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

    @Override // com.baidu.tieba.ica
    public kca dispatch(WebView webView, mca mcaVar, kca kcaVar) {
        InterceptResult invokeLLL;
        kca kcaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, mcaVar, kcaVar)) == null) {
            if (kcaVar == null) {
                kcaVar2 = new kca();
            } else {
                kcaVar2 = kcaVar;
            }
            String b = mcaVar.b();
            JSONObject e = mcaVar.e();
            if (b.equals("router/finishThisPage")) {
                kcaVar2.s(true);
                kca c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    kcaVar2.y(c.f());
                    kcaVar2.u(c.b());
                    kcaVar2.o(c.a());
                    kcaVar2.x(c.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("router/portal")) {
                kcaVar2.s(true);
                kca i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (i != null) {
                    kcaVar2.y(i.f());
                    kcaVar2.u(i.b());
                    kcaVar2.o(i.a());
                    kcaVar2.x(i.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                kcaVar2.s(true);
                kca kcaVar3 = kcaVar2;
                kca g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    kcaVar3.y(g.f());
                    kcaVar3.u(g.b());
                    kcaVar3.o(g.a());
                    kcaVar3.x(g.e());
                }
                kcaVar3.z(0);
                return kcaVar3;
            } else {
                kca kcaVar4 = kcaVar2;
                if (b.equals("router/forumRulesEditPage")) {
                    kcaVar4.s(true);
                    kca j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        kcaVar4.y(j.f());
                        kcaVar4.u(j.b());
                        kcaVar4.o(j.a());
                        kcaVar4.x(j.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("router/goToBarDetail")) {
                    kcaVar4.s(true);
                    kca h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        kcaVar4.y(h.f());
                        kcaVar4.u(h.b());
                        kcaVar4.o(h.a());
                        kcaVar4.x(h.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    kcaVar4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    kca u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        kcaVar4.y(u.f());
                        kcaVar4.u(u.b());
                        kcaVar4.o(u.a());
                        kcaVar4.x(u.e());
                        if (!kcaVar4.h()) {
                            kcaVar4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", kcaVar4, false);
                        }
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    kcaVar4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    kca t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        kcaVar4.y(t.f());
                        kcaVar4.u(t.b());
                        kcaVar4.o(t.a());
                        kcaVar4.x(t.e());
                        if (!kcaVar4.h()) {
                            kcaVar4.n(false);
                            addObserver(webView, "goToReportThreadPage", kcaVar4, false);
                        }
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("router/goToEditPost")) {
                    kcaVar4.s(true);
                    kca f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        kcaVar4.y(f.f());
                        kcaVar4.u(f.b());
                        kcaVar4.o(f.a());
                        kcaVar4.x(f.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("router/jumpToVideo")) {
                    kcaVar4.s(true);
                    kca l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        kcaVar4.y(l.f());
                        kcaVar4.u(l.b());
                        kcaVar4.o(l.a());
                        kcaVar4.x(l.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    kcaVar4.s(true);
                    kca n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        kcaVar4.y(n.f());
                        kcaVar4.u(n.b());
                        kcaVar4.o(n.a());
                        kcaVar4.x(n.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    kcaVar4.s(true);
                    kca k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        kcaVar4.y(k.f());
                        kcaVar4.u(k.b());
                        kcaVar4.o(k.a());
                        kcaVar4.x(k.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (!b.equals("router/replyPost")) {
                    return kcaVar4;
                } else {
                    kcaVar4.s(true);
                    kca r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        kcaVar4.y(r.f());
                        kcaVar4.u(r.b());
                        kcaVar4.o(r.a());
                        kcaVar4.x(r.e());
                        if (!kcaVar4.h()) {
                            kcaVar4.n(false);
                            addObserver(webView, "replyPostResult", kcaVar4, false);
                        }
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                }
            }
            return kcaVar2;
        }
        return (kca) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ica
    public qk6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qk6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ica
    public List<kca> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            kca kcaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                kcaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                kcaVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                kcaVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                kcaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                kcaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                kcaVar = this.mJsBridge.s(webView, hashMap);
            }
            if (kcaVar != null) {
                kcaVar.z(0);
            }
            List<jca> list = this.mAsyncCallBackMethodList.get(str);
            if (kcaVar != null && list != null) {
                Iterator<jca> it = list.iterator();
                if (!TextUtils.isEmpty(kcaVar.e())) {
                    while (it.hasNext()) {
                        jca next = it.next();
                        if (next.b().equals(kcaVar.e())) {
                            kca kcaVar2 = new kca();
                            kcaVar2.w(next.a());
                            kcaVar2.y(kcaVar.f());
                            kcaVar2.u(kcaVar.b());
                            kcaVar2.o(kcaVar.a());
                            kcaVar2.A(kcaVar.l());
                            arrayList.add(kcaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        jca next2 = it.next();
                        kca kcaVar3 = new kca();
                        kcaVar3.w(next2.a());
                        kcaVar3.y(kcaVar.f());
                        kcaVar3.u(kcaVar.b());
                        kcaVar3.o(kcaVar.a());
                        kcaVar3.A(kcaVar.l());
                        arrayList.add(kcaVar3);
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
