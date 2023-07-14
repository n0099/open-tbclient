package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.in6;
import com.baidu.tieba.oda;
import com.baidu.tieba.oy4;
import com.baidu.tieba.pda;
import com.baidu.tieba.qda;
import com.baidu.tieba.sda;
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
public class RouterJsBridgePlugin_Proxy extends oda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oy4 mJsBridge;

    public RouterJsBridgePlugin_Proxy(oy4 oy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = oy4Var;
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

    @Override // com.baidu.tieba.oda
    public qda dispatch(WebView webView, sda sdaVar, qda qdaVar) {
        InterceptResult invokeLLL;
        qda qdaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, sdaVar, qdaVar)) == null) {
            if (qdaVar == null) {
                qdaVar2 = new qda();
            } else {
                qdaVar2 = qdaVar;
            }
            String b = sdaVar.b();
            JSONObject e = sdaVar.e();
            if (b.equals("router/finishThisPage")) {
                qdaVar2.s(true);
                qda c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    qdaVar2.y(c.f());
                    qdaVar2.u(c.b());
                    qdaVar2.o(c.a());
                    qdaVar2.x(c.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("router/portal")) {
                qdaVar2.s(true);
                qda i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (i != null) {
                    qdaVar2.y(i.f());
                    qdaVar2.u(i.b());
                    qdaVar2.o(i.a());
                    qdaVar2.x(i.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                qdaVar2.s(true);
                qda qdaVar3 = qdaVar2;
                qda g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    qdaVar3.y(g.f());
                    qdaVar3.u(g.b());
                    qdaVar3.o(g.a());
                    qdaVar3.x(g.e());
                }
                qdaVar3.z(0);
                return qdaVar3;
            } else {
                qda qdaVar4 = qdaVar2;
                if (b.equals("router/forumRulesEditPage")) {
                    qdaVar4.s(true);
                    qda j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        qdaVar4.y(j.f());
                        qdaVar4.u(j.b());
                        qdaVar4.o(j.a());
                        qdaVar4.x(j.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("router/goToBarDetail")) {
                    qdaVar4.s(true);
                    qda h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        qdaVar4.y(h.f());
                        qdaVar4.u(h.b());
                        qdaVar4.o(h.a());
                        qdaVar4.x(h.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    qdaVar4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    qda u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        qdaVar4.y(u.f());
                        qdaVar4.u(u.b());
                        qdaVar4.o(u.a());
                        qdaVar4.x(u.e());
                        if (!qdaVar4.h()) {
                            qdaVar4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", qdaVar4, false);
                        }
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    qdaVar4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    qda t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        qdaVar4.y(t.f());
                        qdaVar4.u(t.b());
                        qdaVar4.o(t.a());
                        qdaVar4.x(t.e());
                        if (!qdaVar4.h()) {
                            qdaVar4.n(false);
                            addObserver(webView, "goToReportThreadPage", qdaVar4, false);
                        }
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("router/goToEditPost")) {
                    qdaVar4.s(true);
                    qda f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        qdaVar4.y(f.f());
                        qdaVar4.u(f.b());
                        qdaVar4.o(f.a());
                        qdaVar4.x(f.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("router/jumpToVideo")) {
                    qdaVar4.s(true);
                    qda l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        qdaVar4.y(l.f());
                        qdaVar4.u(l.b());
                        qdaVar4.o(l.a());
                        qdaVar4.x(l.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    qdaVar4.s(true);
                    qda n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        qdaVar4.y(n.f());
                        qdaVar4.u(n.b());
                        qdaVar4.o(n.a());
                        qdaVar4.x(n.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    qdaVar4.s(true);
                    qda k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        qdaVar4.y(k.f());
                        qdaVar4.u(k.b());
                        qdaVar4.o(k.a());
                        qdaVar4.x(k.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (!b.equals("router/replyPost")) {
                    return qdaVar4;
                } else {
                    qdaVar4.s(true);
                    qda r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        qdaVar4.y(r.f());
                        qdaVar4.u(r.b());
                        qdaVar4.o(r.a());
                        qdaVar4.x(r.e());
                        if (!qdaVar4.h()) {
                            qdaVar4.n(false);
                            addObserver(webView, "replyPostResult", qdaVar4, false);
                        }
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                }
            }
            return qdaVar2;
        }
        return (qda) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.oda
    public in6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (in6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oda
    public List<qda> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            qda qdaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                qdaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                qdaVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                qdaVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                qdaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                qdaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                qdaVar = this.mJsBridge.s(webView, hashMap);
            }
            if (qdaVar != null) {
                qdaVar.z(0);
            }
            List<pda> list = this.mAsyncCallBackMethodList.get(str);
            if (qdaVar != null && list != null) {
                Iterator<pda> it = list.iterator();
                if (!TextUtils.isEmpty(qdaVar.e())) {
                    while (it.hasNext()) {
                        pda next = it.next();
                        if (next.b().equals(qdaVar.e())) {
                            qda qdaVar2 = new qda();
                            qdaVar2.w(next.a());
                            qdaVar2.y(qdaVar.f());
                            qdaVar2.u(qdaVar.b());
                            qdaVar2.o(qdaVar.a());
                            qdaVar2.A(qdaVar.l());
                            arrayList.add(qdaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        pda next2 = it.next();
                        qda qdaVar3 = new qda();
                        qdaVar3.w(next2.a());
                        qdaVar3.y(qdaVar.f());
                        qdaVar3.u(qdaVar.b());
                        qdaVar3.o(qdaVar.a());
                        qdaVar3.A(qdaVar.l());
                        arrayList.add(qdaVar3);
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
