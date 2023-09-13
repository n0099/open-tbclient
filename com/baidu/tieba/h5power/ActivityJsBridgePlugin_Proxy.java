package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.kia;
import com.baidu.tieba.lia;
import com.baidu.tieba.mia;
import com.baidu.tieba.mx4;
import com.baidu.tieba.oia;
import com.baidu.tieba.tm6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ActivityJsBridgePlugin_Proxy extends kia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mx4 mJsBridge;

    public ActivityJsBridgePlugin_Proxy(mx4 mx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = mx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("writePostSuccess");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
    }

    @Override // com.baidu.tieba.kia
    public mia dispatch(WebView webView, oia oiaVar, mia miaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, oiaVar, miaVar)) == null) {
            if (miaVar == null) {
                miaVar = new mia();
            }
            String b = oiaVar.b();
            JSONObject e = oiaVar.e();
            if (b.equals("activity/updateSearchForumInfo")) {
                miaVar.s(true);
                mia h = this.mJsBridge.h(webView, e.optString("forumParams"));
                if (h != null) {
                    miaVar.y(h.f());
                    miaVar.u(h.b());
                    miaVar.o(h.a());
                    miaVar.x(h.e());
                }
                miaVar.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                miaVar.s(true);
                mia d = this.mJsBridge.d(webView, e.optString("personlizedSwitchStatus"));
                if (d != null) {
                    miaVar.y(d.f());
                    miaVar.u(d.b());
                    miaVar.o(d.a());
                    miaVar.x(d.e());
                }
                miaVar.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                miaVar.s(true);
                mia i = this.mJsBridge.i(webView, e.optInt("type"), e.optString("tailId"));
                if (i != null) {
                    miaVar.y(i.f());
                    miaVar.u(i.b());
                    miaVar.o(i.a());
                    miaVar.x(i.e());
                }
                miaVar.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                miaVar.s(true);
                mia g = this.mJsBridge.g(webView);
                if (g != null) {
                    miaVar.y(g.f());
                    miaVar.u(g.b());
                    miaVar.o(g.a());
                    miaVar.x(g.e());
                }
                miaVar.z(0);
            } else if (b.equals("activity/completeTask")) {
                miaVar.s(true);
                mia f = this.mJsBridge.f(webView, e.optString("activityId"), e.optString("missionId"));
                if (f != null) {
                    miaVar.y(f.f());
                    miaVar.u(f.b());
                    miaVar.o(f.a());
                    miaVar.x(f.e());
                }
                miaVar.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                miaVar.s(true);
                mia c = this.mJsBridge.c(webView, e.optLong("testId"));
                if (c != null) {
                    miaVar.y(c.f());
                    miaVar.u(c.b());
                    miaVar.o(c.a());
                    miaVar.x(c.e());
                }
                miaVar.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                miaVar.s(true);
                mia j = this.mJsBridge.j(webView, e.optString("portrait"), e.optString("flagUrl"));
                if (j != null) {
                    miaVar.y(j.f());
                    miaVar.u(j.b());
                    miaVar.o(j.a());
                    miaVar.x(j.e());
                }
                miaVar.z(0);
            }
            return miaVar;
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
            if (str.equals("writePostSuccess")) {
                miaVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                miaVar = this.mJsBridge.e(webView, hashMap);
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
