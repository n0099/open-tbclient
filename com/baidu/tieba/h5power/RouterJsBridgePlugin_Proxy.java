package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.gxa;
import com.baidu.tieba.ixa;
import com.baidu.tieba.qj6;
import com.baidu.tieba.zs4;
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
public class RouterJsBridgePlugin_Proxy extends exa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zs4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(zs4 zs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zs4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = zs4Var;
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

    @Override // com.baidu.tieba.exa
    public gxa dispatch(WebView webView, ixa ixaVar, gxa gxaVar) {
        InterceptResult invokeLLL;
        gxa gxaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ixaVar, gxaVar)) == null) {
            if (gxaVar == null) {
                gxaVar2 = new gxa();
            } else {
                gxaVar2 = gxaVar;
            }
            String b = ixaVar.b();
            JSONObject e = ixaVar.e();
            if (b.equals("router/finishThisPage")) {
                gxaVar2.s(true);
                gxa c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    gxaVar2.y(c.f());
                    gxaVar2.u(c.b());
                    gxaVar2.o(c.a());
                    gxaVar2.x(c.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("router/portal")) {
                gxaVar2.s(true);
                gxa i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (i != null) {
                    gxaVar2.y(i.f());
                    gxaVar2.u(i.b());
                    gxaVar2.o(i.a());
                    gxaVar2.x(i.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                gxaVar2.s(true);
                gxa gxaVar3 = gxaVar2;
                gxa g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("showComment"));
                if (g != null) {
                    gxaVar3.y(g.f());
                    gxaVar3.u(g.b());
                    gxaVar3.o(g.a());
                    gxaVar3.x(g.e());
                }
                gxaVar3.z(0);
                return gxaVar3;
            } else {
                gxa gxaVar4 = gxaVar2;
                if (b.equals("router/forumRulesEditPage")) {
                    gxaVar4.s(true);
                    gxa j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        gxaVar4.y(j.f());
                        gxaVar4.u(j.b());
                        gxaVar4.o(j.a());
                        gxaVar4.x(j.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("router/goToBarDetail")) {
                    gxaVar4.s(true);
                    gxa h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        gxaVar4.y(h.f());
                        gxaVar4.u(h.b());
                        gxaVar4.o(h.a());
                        gxaVar4.x(h.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    gxaVar4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    gxa u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        gxaVar4.y(u.f());
                        gxaVar4.u(u.b());
                        gxaVar4.o(u.a());
                        gxaVar4.x(u.e());
                        if (!gxaVar4.h()) {
                            gxaVar4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", gxaVar4, false);
                        }
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    gxaVar4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    gxa t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        gxaVar4.y(t.f());
                        gxaVar4.u(t.b());
                        gxaVar4.o(t.a());
                        gxaVar4.x(t.e());
                        if (!gxaVar4.h()) {
                            gxaVar4.n(false);
                            addObserver(webView, "goToReportThreadPage", gxaVar4, false);
                        }
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("router/goToEditPost")) {
                    gxaVar4.s(true);
                    gxa f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        gxaVar4.y(f.f());
                        gxaVar4.u(f.b());
                        gxaVar4.o(f.a());
                        gxaVar4.x(f.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("router/jumpToVideo")) {
                    gxaVar4.s(true);
                    gxa l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        gxaVar4.y(l.f());
                        gxaVar4.u(l.b());
                        gxaVar4.o(l.a());
                        gxaVar4.x(l.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    gxaVar4.s(true);
                    gxa n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        gxaVar4.y(n.f());
                        gxaVar4.u(n.b());
                        gxaVar4.o(n.a());
                        gxaVar4.x(n.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    gxaVar4.s(true);
                    gxa k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        gxaVar4.y(k.f());
                        gxaVar4.u(k.b());
                        gxaVar4.o(k.a());
                        gxaVar4.x(k.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (!b.equals("router/replyPost")) {
                    return gxaVar4;
                } else {
                    gxaVar4.s(true);
                    gxa r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        gxaVar4.y(r.f());
                        gxaVar4.u(r.b());
                        gxaVar4.o(r.a());
                        gxaVar4.x(r.e());
                        if (!gxaVar4.h()) {
                            gxaVar4.n(false);
                            addObserver(webView, "replyPostResult", gxaVar4, false);
                        }
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                }
            }
            return gxaVar2;
        }
        return (gxa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.exa
    public qj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.exa
    public List<gxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            gxa gxaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                gxaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                gxaVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                gxaVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                gxaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                gxaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                gxaVar = this.mJsBridge.s(webView, hashMap);
            }
            if (gxaVar != null) {
                gxaVar.z(0);
            }
            List<fxa> list = this.mAsyncCallBackMethodList.get(str);
            if (gxaVar != null && list != null) {
                Iterator<fxa> it = list.iterator();
                if (!TextUtils.isEmpty(gxaVar.e())) {
                    while (it.hasNext()) {
                        fxa next = it.next();
                        if (next.b().equals(gxaVar.e())) {
                            gxa gxaVar2 = new gxa();
                            gxaVar2.w(next.a());
                            gxaVar2.y(gxaVar.f());
                            gxaVar2.u(gxaVar.b());
                            gxaVar2.o(gxaVar.a());
                            gxaVar2.j = gxaVar.j;
                            gxaVar2.A(gxaVar.l());
                            arrayList.add(gxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        fxa next2 = it.next();
                        gxa gxaVar3 = new gxa();
                        gxaVar3.w(next2.a());
                        gxaVar3.y(gxaVar.f());
                        gxaVar3.u(gxaVar.b());
                        gxaVar3.o(gxaVar.a());
                        gxaVar3.j = gxaVar.j;
                        gxaVar3.A(gxaVar.l());
                        arrayList.add(gxaVar3);
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
