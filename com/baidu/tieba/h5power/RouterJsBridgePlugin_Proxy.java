package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.dj6;
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.osa;
import com.baidu.tieba.qsa;
import com.baidu.tieba.us4;
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
public class RouterJsBridgePlugin_Proxy extends msa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public us4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(us4 us4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {us4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = us4Var;
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

    @Override // com.baidu.tieba.msa
    public osa dispatch(WebView webView, qsa qsaVar, osa osaVar) {
        InterceptResult invokeLLL;
        osa osaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, qsaVar, osaVar)) == null) {
            if (osaVar == null) {
                osaVar2 = new osa();
            } else {
                osaVar2 = osaVar;
            }
            String b = qsaVar.b();
            JSONObject e = qsaVar.e();
            if (b.equals("router/finishThisPage")) {
                osaVar2.s(true);
                osa c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    osaVar2.y(c.f());
                    osaVar2.u(c.b());
                    osaVar2.o(c.a());
                    osaVar2.x(c.e());
                }
                osaVar2.z(0);
            } else if (b.equals("router/portal")) {
                osaVar2.s(true);
                osa i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (i != null) {
                    osaVar2.y(i.f());
                    osaVar2.u(i.b());
                    osaVar2.o(i.a());
                    osaVar2.x(i.e());
                }
                osaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                osaVar2.s(true);
                osa osaVar3 = osaVar2;
                osa g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("showComment"));
                if (g != null) {
                    osaVar3.y(g.f());
                    osaVar3.u(g.b());
                    osaVar3.o(g.a());
                    osaVar3.x(g.e());
                }
                osaVar3.z(0);
                return osaVar3;
            } else {
                osa osaVar4 = osaVar2;
                if (b.equals("router/forumRulesEditPage")) {
                    osaVar4.s(true);
                    osa j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        osaVar4.y(j.f());
                        osaVar4.u(j.b());
                        osaVar4.o(j.a());
                        osaVar4.x(j.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("router/goToBarDetail")) {
                    osaVar4.s(true);
                    osa h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        osaVar4.y(h.f());
                        osaVar4.u(h.b());
                        osaVar4.o(h.a());
                        osaVar4.x(h.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    osaVar4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    osa u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        osaVar4.y(u.f());
                        osaVar4.u(u.b());
                        osaVar4.o(u.a());
                        osaVar4.x(u.e());
                        if (!osaVar4.h()) {
                            osaVar4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", osaVar4, false);
                        }
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    osaVar4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    osa t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        osaVar4.y(t.f());
                        osaVar4.u(t.b());
                        osaVar4.o(t.a());
                        osaVar4.x(t.e());
                        if (!osaVar4.h()) {
                            osaVar4.n(false);
                            addObserver(webView, "goToReportThreadPage", osaVar4, false);
                        }
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("router/goToEditPost")) {
                    osaVar4.s(true);
                    osa f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        osaVar4.y(f.f());
                        osaVar4.u(f.b());
                        osaVar4.o(f.a());
                        osaVar4.x(f.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("router/jumpToVideo")) {
                    osaVar4.s(true);
                    osa l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        osaVar4.y(l.f());
                        osaVar4.u(l.b());
                        osaVar4.o(l.a());
                        osaVar4.x(l.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    osaVar4.s(true);
                    osa n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        osaVar4.y(n.f());
                        osaVar4.u(n.b());
                        osaVar4.o(n.a());
                        osaVar4.x(n.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    osaVar4.s(true);
                    osa k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        osaVar4.y(k.f());
                        osaVar4.u(k.b());
                        osaVar4.o(k.a());
                        osaVar4.x(k.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (!b.equals("router/replyPost")) {
                    return osaVar4;
                } else {
                    osaVar4.s(true);
                    osa r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        osaVar4.y(r.f());
                        osaVar4.u(r.b());
                        osaVar4.o(r.a());
                        osaVar4.x(r.e());
                        if (!osaVar4.h()) {
                            osaVar4.n(false);
                            addObserver(webView, "replyPostResult", osaVar4, false);
                        }
                    }
                    osaVar4.z(0);
                    return osaVar4;
                }
            }
            return osaVar2;
        }
        return (osa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.msa
    public dj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (dj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.msa
    public List<osa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            osa osaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                osaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                osaVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                osaVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                osaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                osaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                osaVar = this.mJsBridge.s(webView, hashMap);
            }
            if (osaVar != null) {
                osaVar.z(0);
            }
            List<nsa> list = this.mAsyncCallBackMethodList.get(str);
            if (osaVar != null && list != null) {
                Iterator<nsa> it = list.iterator();
                if (!TextUtils.isEmpty(osaVar.e())) {
                    while (it.hasNext()) {
                        nsa next = it.next();
                        if (next.b().equals(osaVar.e())) {
                            osa osaVar2 = new osa();
                            osaVar2.w(next.a());
                            osaVar2.y(osaVar.f());
                            osaVar2.u(osaVar.b());
                            osaVar2.o(osaVar.a());
                            osaVar2.j = osaVar.j;
                            osaVar2.A(osaVar.l());
                            arrayList.add(osaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        nsa next2 = it.next();
                        osa osaVar3 = new osa();
                        osaVar3.w(next2.a());
                        osaVar3.y(osaVar.f());
                        osaVar3.u(osaVar.b());
                        osaVar3.o(osaVar.a());
                        osaVar3.j = osaVar.j;
                        osaVar3.A(osaVar.l());
                        arrayList.add(osaVar3);
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
