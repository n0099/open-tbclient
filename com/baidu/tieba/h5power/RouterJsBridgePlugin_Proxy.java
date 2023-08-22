package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.qga;
import com.baidu.tieba.rga;
import com.baidu.tieba.rx4;
import com.baidu.tieba.sga;
import com.baidu.tieba.uga;
import com.baidu.tieba.vl6;
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
public class RouterJsBridgePlugin_Proxy extends qga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rx4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(rx4 rx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = rx4Var;
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

    @Override // com.baidu.tieba.qga
    public sga dispatch(WebView webView, uga ugaVar, sga sgaVar) {
        InterceptResult invokeLLL;
        sga sgaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ugaVar, sgaVar)) == null) {
            if (sgaVar == null) {
                sgaVar2 = new sga();
            } else {
                sgaVar2 = sgaVar;
            }
            String b = ugaVar.b();
            JSONObject e = ugaVar.e();
            if (b.equals("router/finishThisPage")) {
                sgaVar2.s(true);
                sga c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    sgaVar2.y(c.f());
                    sgaVar2.u(c.b());
                    sgaVar2.o(c.a());
                    sgaVar2.x(c.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("router/portal")) {
                sgaVar2.s(true);
                sga i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (i != null) {
                    sgaVar2.y(i.f());
                    sgaVar2.u(i.b());
                    sgaVar2.o(i.a());
                    sgaVar2.x(i.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                sgaVar2.s(true);
                sga sgaVar3 = sgaVar2;
                sga g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    sgaVar3.y(g.f());
                    sgaVar3.u(g.b());
                    sgaVar3.o(g.a());
                    sgaVar3.x(g.e());
                }
                sgaVar3.z(0);
                return sgaVar3;
            } else {
                sga sgaVar4 = sgaVar2;
                if (b.equals("router/forumRulesEditPage")) {
                    sgaVar4.s(true);
                    sga j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        sgaVar4.y(j.f());
                        sgaVar4.u(j.b());
                        sgaVar4.o(j.a());
                        sgaVar4.x(j.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("router/goToBarDetail")) {
                    sgaVar4.s(true);
                    sga h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        sgaVar4.y(h.f());
                        sgaVar4.u(h.b());
                        sgaVar4.o(h.a());
                        sgaVar4.x(h.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    sgaVar4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    sga u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        sgaVar4.y(u.f());
                        sgaVar4.u(u.b());
                        sgaVar4.o(u.a());
                        sgaVar4.x(u.e());
                        if (!sgaVar4.h()) {
                            sgaVar4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", sgaVar4, false);
                        }
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    sgaVar4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    sga t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        sgaVar4.y(t.f());
                        sgaVar4.u(t.b());
                        sgaVar4.o(t.a());
                        sgaVar4.x(t.e());
                        if (!sgaVar4.h()) {
                            sgaVar4.n(false);
                            addObserver(webView, "goToReportThreadPage", sgaVar4, false);
                        }
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("router/goToEditPost")) {
                    sgaVar4.s(true);
                    sga f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        sgaVar4.y(f.f());
                        sgaVar4.u(f.b());
                        sgaVar4.o(f.a());
                        sgaVar4.x(f.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("router/jumpToVideo")) {
                    sgaVar4.s(true);
                    sga l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        sgaVar4.y(l.f());
                        sgaVar4.u(l.b());
                        sgaVar4.o(l.a());
                        sgaVar4.x(l.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    sgaVar4.s(true);
                    sga n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        sgaVar4.y(n.f());
                        sgaVar4.u(n.b());
                        sgaVar4.o(n.a());
                        sgaVar4.x(n.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    sgaVar4.s(true);
                    sga k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        sgaVar4.y(k.f());
                        sgaVar4.u(k.b());
                        sgaVar4.o(k.a());
                        sgaVar4.x(k.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (!b.equals("router/replyPost")) {
                    return sgaVar4;
                } else {
                    sgaVar4.s(true);
                    sga r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        sgaVar4.y(r.f());
                        sgaVar4.u(r.b());
                        sgaVar4.o(r.a());
                        sgaVar4.x(r.e());
                        if (!sgaVar4.h()) {
                            sgaVar4.n(false);
                            addObserver(webView, "replyPostResult", sgaVar4, false);
                        }
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                }
            }
            return sgaVar2;
        }
        return (sga) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qga
    public vl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (vl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qga
    public List<sga> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            sga sgaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                sgaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                sgaVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                sgaVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                sgaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                sgaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                sgaVar = this.mJsBridge.s(webView, hashMap);
            }
            if (sgaVar != null) {
                sgaVar.z(0);
            }
            List<rga> list = this.mAsyncCallBackMethodList.get(str);
            if (sgaVar != null && list != null) {
                Iterator<rga> it = list.iterator();
                if (!TextUtils.isEmpty(sgaVar.e())) {
                    while (it.hasNext()) {
                        rga next = it.next();
                        if (next.b().equals(sgaVar.e())) {
                            sga sgaVar2 = new sga();
                            sgaVar2.w(next.a());
                            sgaVar2.y(sgaVar.f());
                            sgaVar2.u(sgaVar.b());
                            sgaVar2.o(sgaVar.a());
                            sgaVar2.A(sgaVar.l());
                            arrayList.add(sgaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rga next2 = it.next();
                        sga sgaVar3 = new sga();
                        sgaVar3.w(next2.a());
                        sgaVar3.y(sgaVar.f());
                        sgaVar3.u(sgaVar.b());
                        sgaVar3.o(sgaVar.a());
                        sgaVar3.A(sgaVar.l());
                        arrayList.add(sgaVar3);
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
