package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.ds4;
import com.baidu.tieba.gfa;
import com.baidu.tieba.gh6;
import com.baidu.tieba.hfa;
import com.baidu.tieba.ifa;
import com.baidu.tieba.kfa;
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
public class RouterJsBridgePlugin_Proxy extends gfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ds4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(ds4 ds4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ds4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ds4Var;
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

    @Override // com.baidu.tieba.gfa
    public ifa dispatch(WebView webView, kfa kfaVar, ifa ifaVar) {
        InterceptResult invokeLLL;
        ifa ifaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, kfaVar, ifaVar)) == null) {
            if (ifaVar == null) {
                ifaVar2 = new ifa();
            } else {
                ifaVar2 = ifaVar;
            }
            String b = kfaVar.b();
            JSONObject e = kfaVar.e();
            if (b.equals("router/finishThisPage")) {
                ifaVar2.s(true);
                ifa c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    ifaVar2.y(c.f());
                    ifaVar2.u(c.b());
                    ifaVar2.o(c.a());
                    ifaVar2.x(c.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("router/portal")) {
                ifaVar2.s(true);
                ifa i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (i != null) {
                    ifaVar2.y(i.f());
                    ifaVar2.u(i.b());
                    ifaVar2.o(i.a());
                    ifaVar2.x(i.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                ifaVar2.s(true);
                ifa ifaVar3 = ifaVar2;
                ifa g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    ifaVar3.y(g.f());
                    ifaVar3.u(g.b());
                    ifaVar3.o(g.a());
                    ifaVar3.x(g.e());
                }
                ifaVar3.z(0);
                return ifaVar3;
            } else {
                ifa ifaVar4 = ifaVar2;
                if (b.equals("router/forumRulesEditPage")) {
                    ifaVar4.s(true);
                    ifa j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        ifaVar4.y(j.f());
                        ifaVar4.u(j.b());
                        ifaVar4.o(j.a());
                        ifaVar4.x(j.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("router/goToBarDetail")) {
                    ifaVar4.s(true);
                    ifa h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        ifaVar4.y(h.f());
                        ifaVar4.u(h.b());
                        ifaVar4.o(h.a());
                        ifaVar4.x(h.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    ifaVar4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    ifa u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        ifaVar4.y(u.f());
                        ifaVar4.u(u.b());
                        ifaVar4.o(u.a());
                        ifaVar4.x(u.e());
                        if (!ifaVar4.h()) {
                            ifaVar4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", ifaVar4, false);
                        }
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    ifaVar4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    ifa t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        ifaVar4.y(t.f());
                        ifaVar4.u(t.b());
                        ifaVar4.o(t.a());
                        ifaVar4.x(t.e());
                        if (!ifaVar4.h()) {
                            ifaVar4.n(false);
                            addObserver(webView, "goToReportThreadPage", ifaVar4, false);
                        }
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("router/goToEditPost")) {
                    ifaVar4.s(true);
                    ifa f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        ifaVar4.y(f.f());
                        ifaVar4.u(f.b());
                        ifaVar4.o(f.a());
                        ifaVar4.x(f.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("router/jumpToVideo")) {
                    ifaVar4.s(true);
                    ifa l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        ifaVar4.y(l.f());
                        ifaVar4.u(l.b());
                        ifaVar4.o(l.a());
                        ifaVar4.x(l.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    ifaVar4.s(true);
                    ifa n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        ifaVar4.y(n.f());
                        ifaVar4.u(n.b());
                        ifaVar4.o(n.a());
                        ifaVar4.x(n.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    ifaVar4.s(true);
                    ifa k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        ifaVar4.y(k.f());
                        ifaVar4.u(k.b());
                        ifaVar4.o(k.a());
                        ifaVar4.x(k.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (!b.equals("router/replyPost")) {
                    return ifaVar4;
                } else {
                    ifaVar4.s(true);
                    ifa r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        ifaVar4.y(r.f());
                        ifaVar4.u(r.b());
                        ifaVar4.o(r.a());
                        ifaVar4.x(r.e());
                        if (!ifaVar4.h()) {
                            ifaVar4.n(false);
                            addObserver(webView, "replyPostResult", ifaVar4, false);
                        }
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                }
            }
            return ifaVar2;
        }
        return (ifa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.gfa
    public gh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (gh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gfa
    public List<ifa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ifa ifaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                ifaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                ifaVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                ifaVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                ifaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                ifaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                ifaVar = this.mJsBridge.s(webView, hashMap);
            }
            if (ifaVar != null) {
                ifaVar.z(0);
            }
            List<hfa> list = this.mAsyncCallBackMethodList.get(str);
            if (ifaVar != null && list != null) {
                Iterator<hfa> it = list.iterator();
                if (!TextUtils.isEmpty(ifaVar.e())) {
                    while (it.hasNext()) {
                        hfa next = it.next();
                        if (next.b().equals(ifaVar.e())) {
                            ifa ifaVar2 = new ifa();
                            ifaVar2.w(next.a());
                            ifaVar2.y(ifaVar.f());
                            ifaVar2.u(ifaVar.b());
                            ifaVar2.o(ifaVar.a());
                            ifaVar2.j = ifaVar.j;
                            ifaVar2.A(ifaVar.l());
                            arrayList.add(ifaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        hfa next2 = it.next();
                        ifa ifaVar3 = new ifa();
                        ifaVar3.w(next2.a());
                        ifaVar3.y(ifaVar.f());
                        ifaVar3.u(ifaVar.b());
                        ifaVar3.o(ifaVar.a());
                        ifaVar3.j = ifaVar.j;
                        ifaVar3.A(ifaVar.l());
                        arrayList.add(ifaVar3);
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
