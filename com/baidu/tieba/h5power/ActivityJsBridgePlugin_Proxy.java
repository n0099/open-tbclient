package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.d5a;
import com.baidu.tieba.e5a;
import com.baidu.tieba.em6;
import com.baidu.tieba.f5a;
import com.baidu.tieba.h5a;
import com.baidu.tieba.my4;
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
public class ActivityJsBridgePlugin_Proxy extends d5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public my4 mJsBridge;

    public ActivityJsBridgePlugin_Proxy(my4 my4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {my4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = my4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("writePostSuccess");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
    }

    @Override // com.baidu.tieba.d5a
    public f5a dispatch(WebView webView, h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, h5aVar, f5aVar)) == null) {
            if (f5aVar == null) {
                f5aVar = new f5a();
            }
            String b = h5aVar.b();
            JSONObject e = h5aVar.e();
            if (b.equals("activity/updateSearchForumInfo")) {
                f5aVar.s(true);
                f5a h = this.mJsBridge.h(webView, e.optString("forumParams"));
                if (h != null) {
                    f5aVar.y(h.f());
                    f5aVar.u(h.b());
                    f5aVar.o(h.a());
                    f5aVar.x(h.e());
                }
                f5aVar.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                f5aVar.s(true);
                f5a d = this.mJsBridge.d(webView, e.optString("personlizedSwitchStatus"));
                if (d != null) {
                    f5aVar.y(d.f());
                    f5aVar.u(d.b());
                    f5aVar.o(d.a());
                    f5aVar.x(d.e());
                }
                f5aVar.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                f5aVar.s(true);
                f5a i = this.mJsBridge.i(webView, e.optInt("type"), e.optString("tailId"));
                if (i != null) {
                    f5aVar.y(i.f());
                    f5aVar.u(i.b());
                    f5aVar.o(i.a());
                    f5aVar.x(i.e());
                }
                f5aVar.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                f5aVar.s(true);
                f5a g = this.mJsBridge.g(webView);
                if (g != null) {
                    f5aVar.y(g.f());
                    f5aVar.u(g.b());
                    f5aVar.o(g.a());
                    f5aVar.x(g.e());
                }
                f5aVar.z(0);
            } else if (b.equals("activity/completeTask")) {
                f5aVar.s(true);
                f5a f = this.mJsBridge.f(webView, e.optString("activityId"), e.optString("missionId"));
                if (f != null) {
                    f5aVar.y(f.f());
                    f5aVar.u(f.b());
                    f5aVar.o(f.a());
                    f5aVar.x(f.e());
                }
                f5aVar.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                f5aVar.s(true);
                f5a c = this.mJsBridge.c(webView, e.optLong("testId"));
                if (c != null) {
                    f5aVar.y(c.f());
                    f5aVar.u(c.b());
                    f5aVar.o(c.a());
                    f5aVar.x(c.e());
                }
                f5aVar.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                f5aVar.s(true);
                f5a j = this.mJsBridge.j(webView, e.optString("portrait"), e.optString("flagUrl"));
                if (j != null) {
                    f5aVar.y(j.f());
                    f5aVar.u(j.b());
                    f5aVar.o(j.a());
                    f5aVar.x(j.e());
                }
                f5aVar.z(0);
            }
            return f5aVar;
        }
        return (f5a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public em6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (em6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public List<f5a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            f5a f5aVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("writePostSuccess")) {
                f5aVar = this.mJsBridge.k(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                f5aVar = this.mJsBridge.e(webView, hashMap);
            }
            if (f5aVar != null) {
                f5aVar.z(0);
            }
            List<e5a> list = this.mAsyncCallBackMethodList.get(str);
            if (f5aVar != null && list != null) {
                Iterator<e5a> it = list.iterator();
                if (!TextUtils.isEmpty(f5aVar.e())) {
                    while (it.hasNext()) {
                        e5a next = it.next();
                        if (next.b().equals(f5aVar.e())) {
                            f5a f5aVar2 = new f5a();
                            f5aVar2.w(next.a());
                            f5aVar2.y(f5aVar.f());
                            f5aVar2.u(f5aVar.b());
                            f5aVar2.o(f5aVar.a());
                            f5aVar2.A(f5aVar.l());
                            arrayList.add(f5aVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        e5a next2 = it.next();
                        f5a f5aVar3 = new f5a();
                        f5aVar3.w(next2.a());
                        f5aVar3.y(f5aVar.f());
                        f5aVar3.u(f5aVar.b());
                        f5aVar3.o(f5aVar.a());
                        f5aVar3.A(f5aVar.l());
                        arrayList.add(f5aVar3);
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
