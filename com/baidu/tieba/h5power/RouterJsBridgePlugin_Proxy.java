package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.qka;
import com.baidu.tieba.rka;
import com.baidu.tieba.ska;
import com.baidu.tieba.uka;
import com.baidu.tieba.vx4;
import com.baidu.tieba.xm6;
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
public class RouterJsBridgePlugin_Proxy extends qka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vx4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(vx4 vx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = vx4Var;
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

    @Override // com.baidu.tieba.qka
    public ska dispatch(WebView webView, uka ukaVar, ska skaVar) {
        InterceptResult invokeLLL;
        ska skaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ukaVar, skaVar)) == null) {
            if (skaVar == null) {
                skaVar2 = new ska();
            } else {
                skaVar2 = skaVar;
            }
            String b = ukaVar.b();
            JSONObject e = ukaVar.e();
            if (b.equals("router/finishThisPage")) {
                skaVar2.s(true);
                ska c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    skaVar2.y(c.f());
                    skaVar2.u(c.b());
                    skaVar2.o(c.a());
                    skaVar2.x(c.e());
                }
                skaVar2.z(0);
            } else if (b.equals("router/portal")) {
                skaVar2.s(true);
                ska i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (i != null) {
                    skaVar2.y(i.f());
                    skaVar2.u(i.b());
                    skaVar2.o(i.a());
                    skaVar2.x(i.e());
                }
                skaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                skaVar2.s(true);
                ska skaVar3 = skaVar2;
                ska g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    skaVar3.y(g.f());
                    skaVar3.u(g.b());
                    skaVar3.o(g.a());
                    skaVar3.x(g.e());
                }
                skaVar3.z(0);
                return skaVar3;
            } else {
                ska skaVar4 = skaVar2;
                if (b.equals("router/forumRulesEditPage")) {
                    skaVar4.s(true);
                    ska j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        skaVar4.y(j.f());
                        skaVar4.u(j.b());
                        skaVar4.o(j.a());
                        skaVar4.x(j.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("router/goToBarDetail")) {
                    skaVar4.s(true);
                    ska h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        skaVar4.y(h.f());
                        skaVar4.u(h.b());
                        skaVar4.o(h.a());
                        skaVar4.x(h.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    skaVar4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    ska u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        skaVar4.y(u.f());
                        skaVar4.u(u.b());
                        skaVar4.o(u.a());
                        skaVar4.x(u.e());
                        if (!skaVar4.h()) {
                            skaVar4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", skaVar4, false);
                        }
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    skaVar4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    ska t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        skaVar4.y(t.f());
                        skaVar4.u(t.b());
                        skaVar4.o(t.a());
                        skaVar4.x(t.e());
                        if (!skaVar4.h()) {
                            skaVar4.n(false);
                            addObserver(webView, "goToReportThreadPage", skaVar4, false);
                        }
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("router/goToEditPost")) {
                    skaVar4.s(true);
                    ska f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        skaVar4.y(f.f());
                        skaVar4.u(f.b());
                        skaVar4.o(f.a());
                        skaVar4.x(f.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("router/jumpToVideo")) {
                    skaVar4.s(true);
                    ska l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        skaVar4.y(l.f());
                        skaVar4.u(l.b());
                        skaVar4.o(l.a());
                        skaVar4.x(l.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    skaVar4.s(true);
                    ska n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        skaVar4.y(n.f());
                        skaVar4.u(n.b());
                        skaVar4.o(n.a());
                        skaVar4.x(n.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    skaVar4.s(true);
                    ska k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        skaVar4.y(k.f());
                        skaVar4.u(k.b());
                        skaVar4.o(k.a());
                        skaVar4.x(k.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (!b.equals("router/replyPost")) {
                    return skaVar4;
                } else {
                    skaVar4.s(true);
                    ska r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        skaVar4.y(r.f());
                        skaVar4.u(r.b());
                        skaVar4.o(r.a());
                        skaVar4.x(r.e());
                        if (!skaVar4.h()) {
                            skaVar4.n(false);
                            addObserver(webView, "replyPostResult", skaVar4, false);
                        }
                    }
                    skaVar4.z(0);
                    return skaVar4;
                }
            }
            return skaVar2;
        }
        return (ska) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qka
    public xm6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (xm6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qka
    public List<ska> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ska skaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                skaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                skaVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                skaVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                skaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                skaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                skaVar = this.mJsBridge.s(webView, hashMap);
            }
            if (skaVar != null) {
                skaVar.z(0);
            }
            List<rka> list = this.mAsyncCallBackMethodList.get(str);
            if (skaVar != null && list != null) {
                Iterator<rka> it = list.iterator();
                if (!TextUtils.isEmpty(skaVar.e())) {
                    while (it.hasNext()) {
                        rka next = it.next();
                        if (next.b().equals(skaVar.e())) {
                            ska skaVar2 = new ska();
                            skaVar2.w(next.a());
                            skaVar2.y(skaVar.f());
                            skaVar2.u(skaVar.b());
                            skaVar2.o(skaVar.a());
                            skaVar2.j = skaVar.j;
                            skaVar2.A(skaVar.l());
                            arrayList.add(skaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rka next2 = it.next();
                        ska skaVar3 = new ska();
                        skaVar3.w(next2.a());
                        skaVar3.y(skaVar.f());
                        skaVar3.u(skaVar.b());
                        skaVar3.o(skaVar.a());
                        skaVar3.j = skaVar.j;
                        skaVar3.A(skaVar.l());
                        arrayList.add(skaVar3);
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
