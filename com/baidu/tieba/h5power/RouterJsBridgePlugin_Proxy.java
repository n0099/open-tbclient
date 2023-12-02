package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.dxa;
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.hxa;
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
public class RouterJsBridgePlugin_Proxy extends dxa {
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

    @Override // com.baidu.tieba.dxa
    public fxa dispatch(WebView webView, hxa hxaVar, fxa fxaVar) {
        InterceptResult invokeLLL;
        fxa fxaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, hxaVar, fxaVar)) == null) {
            if (fxaVar == null) {
                fxaVar2 = new fxa();
            } else {
                fxaVar2 = fxaVar;
            }
            String b = hxaVar.b();
            JSONObject e = hxaVar.e();
            if (b.equals("router/finishThisPage")) {
                fxaVar2.s(true);
                fxa c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    fxaVar2.y(c.f());
                    fxaVar2.u(c.b());
                    fxaVar2.o(c.a());
                    fxaVar2.x(c.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("router/portal")) {
                fxaVar2.s(true);
                fxa i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (i != null) {
                    fxaVar2.y(i.f());
                    fxaVar2.u(i.b());
                    fxaVar2.o(i.a());
                    fxaVar2.x(i.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                fxaVar2.s(true);
                fxa fxaVar3 = fxaVar2;
                fxa g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("showComment"));
                if (g != null) {
                    fxaVar3.y(g.f());
                    fxaVar3.u(g.b());
                    fxaVar3.o(g.a());
                    fxaVar3.x(g.e());
                }
                fxaVar3.z(0);
                return fxaVar3;
            } else {
                fxa fxaVar4 = fxaVar2;
                if (b.equals("router/forumRulesEditPage")) {
                    fxaVar4.s(true);
                    fxa j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        fxaVar4.y(j.f());
                        fxaVar4.u(j.b());
                        fxaVar4.o(j.a());
                        fxaVar4.x(j.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("router/goToBarDetail")) {
                    fxaVar4.s(true);
                    fxa h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        fxaVar4.y(h.f());
                        fxaVar4.u(h.b());
                        fxaVar4.o(h.a());
                        fxaVar4.x(h.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    fxaVar4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    fxa u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        fxaVar4.y(u.f());
                        fxaVar4.u(u.b());
                        fxaVar4.o(u.a());
                        fxaVar4.x(u.e());
                        if (!fxaVar4.h()) {
                            fxaVar4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", fxaVar4, false);
                        }
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    fxaVar4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    fxa t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        fxaVar4.y(t.f());
                        fxaVar4.u(t.b());
                        fxaVar4.o(t.a());
                        fxaVar4.x(t.e());
                        if (!fxaVar4.h()) {
                            fxaVar4.n(false);
                            addObserver(webView, "goToReportThreadPage", fxaVar4, false);
                        }
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("router/goToEditPost")) {
                    fxaVar4.s(true);
                    fxa f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        fxaVar4.y(f.f());
                        fxaVar4.u(f.b());
                        fxaVar4.o(f.a());
                        fxaVar4.x(f.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("router/jumpToVideo")) {
                    fxaVar4.s(true);
                    fxa l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        fxaVar4.y(l.f());
                        fxaVar4.u(l.b());
                        fxaVar4.o(l.a());
                        fxaVar4.x(l.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    fxaVar4.s(true);
                    fxa n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        fxaVar4.y(n.f());
                        fxaVar4.u(n.b());
                        fxaVar4.o(n.a());
                        fxaVar4.x(n.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    fxaVar4.s(true);
                    fxa k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        fxaVar4.y(k.f());
                        fxaVar4.u(k.b());
                        fxaVar4.o(k.a());
                        fxaVar4.x(k.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (!b.equals("router/replyPost")) {
                    return fxaVar4;
                } else {
                    fxaVar4.s(true);
                    fxa r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        fxaVar4.y(r.f());
                        fxaVar4.u(r.b());
                        fxaVar4.o(r.a());
                        fxaVar4.x(r.e());
                        if (!fxaVar4.h()) {
                            fxaVar4.n(false);
                            addObserver(webView, "replyPostResult", fxaVar4, false);
                        }
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                }
            }
            return fxaVar2;
        }
        return (fxa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public qj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public List<fxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            fxa fxaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                fxaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                fxaVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                fxaVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                fxaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                fxaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                fxaVar = this.mJsBridge.s(webView, hashMap);
            }
            if (fxaVar != null) {
                fxaVar.z(0);
            }
            List<exa> list = this.mAsyncCallBackMethodList.get(str);
            if (fxaVar != null && list != null) {
                Iterator<exa> it = list.iterator();
                if (!TextUtils.isEmpty(fxaVar.e())) {
                    while (it.hasNext()) {
                        exa next = it.next();
                        if (next.b().equals(fxaVar.e())) {
                            fxa fxaVar2 = new fxa();
                            fxaVar2.w(next.a());
                            fxaVar2.y(fxaVar.f());
                            fxaVar2.u(fxaVar.b());
                            fxaVar2.o(fxaVar.a());
                            fxaVar2.j = fxaVar.j;
                            fxaVar2.A(fxaVar.l());
                            arrayList.add(fxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        exa next2 = it.next();
                        fxa fxaVar3 = new fxa();
                        fxaVar3.w(next2.a());
                        fxaVar3.y(fxaVar.f());
                        fxaVar3.u(fxaVar.b());
                        fxaVar3.o(fxaVar.a());
                        fxaVar3.j = fxaVar.j;
                        fxaVar3.A(fxaVar.l());
                        arrayList.add(fxaVar3);
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
