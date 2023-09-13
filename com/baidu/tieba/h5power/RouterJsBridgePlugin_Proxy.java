package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.kia;
import com.baidu.tieba.lia;
import com.baidu.tieba.mia;
import com.baidu.tieba.oia;
import com.baidu.tieba.tm6;
import com.baidu.tieba.vx4;
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
public class RouterJsBridgePlugin_Proxy extends kia {
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

    @Override // com.baidu.tieba.kia
    public mia dispatch(WebView webView, oia oiaVar, mia miaVar) {
        InterceptResult invokeLLL;
        mia miaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, oiaVar, miaVar)) == null) {
            if (miaVar == null) {
                miaVar2 = new mia();
            } else {
                miaVar2 = miaVar;
            }
            String b = oiaVar.b();
            JSONObject e = oiaVar.e();
            if (b.equals("router/finishThisPage")) {
                miaVar2.s(true);
                mia c = this.mJsBridge.c(webView, e.optString("nextPage"), e.optString("source"));
                if (c != null) {
                    miaVar2.y(c.f());
                    miaVar2.u(c.b());
                    miaVar2.o(c.a());
                    miaVar2.x(c.e());
                }
                miaVar2.z(0);
            } else if (b.equals("router/portal")) {
                miaVar2.s(true);
                mia i = this.mJsBridge.i(webView, e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (i != null) {
                    miaVar2.y(i.f());
                    miaVar2.u(i.b());
                    miaVar2.o(i.a());
                    miaVar2.x(i.e());
                }
                miaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                miaVar2.s(true);
                mia miaVar3 = miaVar2;
                mia g = this.mJsBridge.g(webView, e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (g != null) {
                    miaVar3.y(g.f());
                    miaVar3.u(g.b());
                    miaVar3.o(g.a());
                    miaVar3.x(g.e());
                }
                miaVar3.z(0);
                return miaVar3;
            } else {
                mia miaVar4 = miaVar2;
                if (b.equals("router/forumRulesEditPage")) {
                    miaVar4.s(true);
                    mia j = this.mJsBridge.j(webView, e.optString("forum_id"), e.optString("forum_name"));
                    if (j != null) {
                        miaVar4.y(j.f());
                        miaVar4.u(j.b());
                        miaVar4.o(j.a());
                        miaVar4.x(j.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("router/goToBarDetail")) {
                    miaVar4.s(true);
                    mia h = this.mJsBridge.h(webView, e.optString("forumId"), e.optInt("selectHostTab"));
                    if (h != null) {
                        miaVar4.y(h.f());
                        miaVar4.u(h.b());
                        miaVar4.o(h.a());
                        miaVar4.x(h.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                    miaVar4.s(true);
                    String optString = e.optString("portrait");
                    ArrayList<JSONObject> arrayList = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("msgArray"));
                    mia u = this.mJsBridge.u(webView, optString, arrayList);
                    this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                    if (u != null) {
                        miaVar4.y(u.f());
                        miaVar4.u(u.b());
                        miaVar4.o(u.a());
                        miaVar4.x(u.e());
                        if (!miaVar4.h()) {
                            miaVar4.n(false);
                            addObserver(webView, "goToSelectPrivateMsgPage", miaVar4, false);
                        }
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("router/goToReportThreadPage")) {
                    miaVar4.s(true);
                    String optString2 = e.optString("portrait");
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("threadArray"));
                    mia t = this.mJsBridge.t(webView, optString2, arrayList2);
                    this.mNotificationNameList.add("goToReportThreadPage");
                    if (t != null) {
                        miaVar4.y(t.f());
                        miaVar4.u(t.b());
                        miaVar4.o(t.a());
                        miaVar4.x(t.e());
                        if (!miaVar4.h()) {
                            miaVar4.n(false);
                            addObserver(webView, "goToReportThreadPage", miaVar4, false);
                        }
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("router/goToEditPost")) {
                    miaVar4.s(true);
                    mia f = this.mJsBridge.f(webView, e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                    if (f != null) {
                        miaVar4.y(f.f());
                        miaVar4.u(f.b());
                        miaVar4.o(f.a());
                        miaVar4.x(f.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("router/jumpToVideo")) {
                    miaVar4.s(true);
                    mia l = this.mJsBridge.l(webView, e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                    if (l != null) {
                        miaVar4.y(l.f());
                        miaVar4.u(l.b());
                        miaVar4.o(l.a());
                        miaVar4.x(l.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("router/openThirdPartyApp")) {
                    miaVar4.s(true);
                    mia n = this.mJsBridge.n(webView, e.optInt("type"), e.optString("data"));
                    if (n != null) {
                        miaVar4.y(n.f());
                        miaVar4.u(n.b());
                        miaVar4.o(n.a());
                        miaVar4.x(n.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("router/jumpToHTMLPage")) {
                    miaVar4.s(true);
                    mia k = this.mJsBridge.k(webView, e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                    if (k != null) {
                        miaVar4.y(k.f());
                        miaVar4.u(k.b());
                        miaVar4.o(k.a());
                        miaVar4.x(k.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (!b.equals("router/replyPost")) {
                    return miaVar4;
                } else {
                    miaVar4.s(true);
                    mia r = this.mJsBridge.r(webView, e.optString("tid"));
                    this.mNotificationNameList.add("replyPostResult");
                    if (r != null) {
                        miaVar4.y(r.f());
                        miaVar4.u(r.b());
                        miaVar4.o(r.a());
                        miaVar4.x(r.e());
                        if (!miaVar4.h()) {
                            miaVar4.n(false);
                            addObserver(webView, "replyPostResult", miaVar4, false);
                        }
                    }
                    miaVar4.z(0);
                    return miaVar4;
                }
            }
            return miaVar2;
        }
        return (mia) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.kia
    public tm6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (tm6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kia
    public List<mia> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            mia miaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                miaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                miaVar = this.mJsBridge.o(webView, hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                miaVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                miaVar = this.mJsBridge.e(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                miaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals("replyPostResult")) {
                miaVar = this.mJsBridge.s(webView, hashMap);
            }
            if (miaVar != null) {
                miaVar.z(0);
            }
            List<lia> list = this.mAsyncCallBackMethodList.get(str);
            if (miaVar != null && list != null) {
                Iterator<lia> it = list.iterator();
                if (!TextUtils.isEmpty(miaVar.e())) {
                    while (it.hasNext()) {
                        lia next = it.next();
                        if (next.b().equals(miaVar.e())) {
                            mia miaVar2 = new mia();
                            miaVar2.w(next.a());
                            miaVar2.y(miaVar.f());
                            miaVar2.u(miaVar.b());
                            miaVar2.o(miaVar.a());
                            miaVar2.j = miaVar.j;
                            miaVar2.A(miaVar.l());
                            arrayList.add(miaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        lia next2 = it.next();
                        mia miaVar3 = new mia();
                        miaVar3.w(next2.a());
                        miaVar3.y(miaVar.f());
                        miaVar3.u(miaVar.b());
                        miaVar3.o(miaVar.a());
                        miaVar3.j = miaVar.j;
                        miaVar3.A(miaVar.l());
                        arrayList.add(miaVar3);
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
