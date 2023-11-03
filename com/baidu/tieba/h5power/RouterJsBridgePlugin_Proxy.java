package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.cj6;
import com.baidu.tieba.lsa;
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.psa;
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
public class RouterJsBridgePlugin_Proxy extends lsa {
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

    @Override // com.baidu.tieba.lsa
    public nsa dispatch(WebView webView, psa psaVar, nsa nsaVar) {
        InterceptResult invokeLLL;
        nsa nsaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, psaVar, nsaVar)) == null) {
            if (nsaVar == null) {
                nsaVar2 = new nsa();
            } else {
                nsaVar2 = nsaVar;
            }
            String b = psaVar.b();
            JSONObject e = psaVar.e();
            if (b.equals("router/finishThisPage")) {
                nsaVar2.s(true);
                nsa c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    nsaVar2.y(c.f());
                    nsaVar2.u(c.b());
                    nsaVar2.o(c.a());
                    nsaVar2.x(c.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("router/portal")) {
                nsaVar2.s(true);
                nsa i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (i != null) {
                    nsaVar2.y(i.f());
                    nsaVar2.u(i.b());
                    nsaVar2.o(i.a());
                    nsaVar2.x(i.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                nsaVar2.s(true);
                nsa nsaVar3 = nsaVar2;
                nsa g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("showComment"));
                if (g != null) {
                    nsaVar3.y(g.f());
                    nsaVar3.u(g.b());
                    nsaVar3.o(g.a());
                    nsaVar3.x(g.e());
                }
                nsaVar3.z(0);
                return nsaVar3;
            } else {
                nsa nsaVar4 = nsaVar2;
                if (b.equals("router/forumRulesEditPage")) {
                    nsaVar4.s(true);
                    nsa j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        nsaVar4.y(j.f());
                        nsaVar4.u(j.b());
                        nsaVar4.o(j.a());
                        nsaVar4.x(j.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("router/goToBarDetail")) {
                    nsaVar4.s(true);
                    nsa h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        nsaVar4.y(h.f());
                        nsaVar4.u(h.b());
                        nsaVar4.o(h.a());
                        nsaVar4.x(h.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    nsaVar4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    nsa u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        nsaVar4.y(u.f());
                        nsaVar4.u(u.b());
                        nsaVar4.o(u.a());
                        nsaVar4.x(u.e());
                        if (!nsaVar4.h()) {
                            nsaVar4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", nsaVar4, false);
                        }
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    nsaVar4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    nsa t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        nsaVar4.y(t.f());
                        nsaVar4.u(t.b());
                        nsaVar4.o(t.a());
                        nsaVar4.x(t.e());
                        if (!nsaVar4.h()) {
                            nsaVar4.n(false);
                            addObserver(webView, "goToReportThreadPage", nsaVar4, false);
                        }
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("router/goToEditPost")) {
                    nsaVar4.s(true);
                    nsa f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        nsaVar4.y(f.f());
                        nsaVar4.u(f.b());
                        nsaVar4.o(f.a());
                        nsaVar4.x(f.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("router/jumpToVideo")) {
                    nsaVar4.s(true);
                    nsa l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        nsaVar4.y(l.f());
                        nsaVar4.u(l.b());
                        nsaVar4.o(l.a());
                        nsaVar4.x(l.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    nsaVar4.s(true);
                    nsa n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        nsaVar4.y(n.f());
                        nsaVar4.u(n.b());
                        nsaVar4.o(n.a());
                        nsaVar4.x(n.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    nsaVar4.s(true);
                    nsa k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        nsaVar4.y(k.f());
                        nsaVar4.u(k.b());
                        nsaVar4.o(k.a());
                        nsaVar4.x(k.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (!b.equals("router/replyPost")) {
                    return nsaVar4;
                } else {
                    nsaVar4.s(true);
                    nsa r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        nsaVar4.y(r.f());
                        nsaVar4.u(r.b());
                        nsaVar4.o(r.a());
                        nsaVar4.x(r.e());
                        if (!nsaVar4.h()) {
                            nsaVar4.n(false);
                            addObserver(webView, "replyPostResult", nsaVar4, false);
                        }
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                }
            }
            return nsaVar2;
        }
        return (nsa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public cj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (cj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public List<nsa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            nsa nsaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                nsaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                nsaVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                nsaVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                nsaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                nsaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                nsaVar = this.mJsBridge.s(webView, hashMap);
            }
            if (nsaVar != null) {
                nsaVar.z(0);
            }
            List<msa> list = this.mAsyncCallBackMethodList.get(str);
            if (nsaVar != null && list != null) {
                Iterator<msa> it = list.iterator();
                if (!TextUtils.isEmpty(nsaVar.e())) {
                    while (it.hasNext()) {
                        msa next = it.next();
                        if (next.b().equals(nsaVar.e())) {
                            nsa nsaVar2 = new nsa();
                            nsaVar2.w(next.a());
                            nsaVar2.y(nsaVar.f());
                            nsaVar2.u(nsaVar.b());
                            nsaVar2.o(nsaVar.a());
                            nsaVar2.j = nsaVar.j;
                            nsaVar2.A(nsaVar.l());
                            arrayList.add(nsaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        msa next2 = it.next();
                        nsa nsaVar3 = new nsa();
                        nsaVar3.w(next2.a());
                        nsaVar3.y(nsaVar.f());
                        nsaVar3.u(nsaVar.b());
                        nsaVar3.o(nsaVar.a());
                        nsaVar3.j = nsaVar.j;
                        nsaVar3.A(nsaVar.l());
                        arrayList.add(nsaVar3);
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
