package com.baidu.tieba.h5power;

import c.a.e.e.p.k;
import c.a.r0.j3.m0.d.a;
import c.a.r0.j3.m0.d.c;
import c.a.r0.j3.m0.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SearchJsBridge_Proxy extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SearchJsBridge mJsBridge;

    public SearchJsBridge_Proxy(SearchJsBridge searchJsBridge) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {searchJsBridge};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = searchJsBridge;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // c.a.r0.j3.m0.d.a
    public c dispatch(e eVar, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, cVar)) == null) {
            if (cVar == null) {
                cVar = new c();
            }
            String b2 = eVar.b();
            JSONObject e2 = eVar.e();
            if (b2.equals("hybrid/deleteSearchHistory")) {
                cVar.p(true);
                c deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e2.optString("query"));
                if (deleteSearchHistory != null) {
                    cVar.v(deleteSearchHistory.f());
                    cVar.r(deleteSearchHistory.b());
                    cVar.m(deleteSearchHistory.a());
                    cVar.u(deleteSearchHistory.e());
                }
                cVar.w(0);
            } else if (b2.equals("hybrid/deleteAllSearchHistory")) {
                cVar.p(true);
                c deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    cVar.v(deleteAllSearchHistory.f());
                    cVar.r(deleteAllSearchHistory.b());
                    cVar.m(deleteAllSearchHistory.a());
                    cVar.u(deleteAllSearchHistory.e());
                }
                cVar.w(0);
            } else if (b2.equals("hybrid/openSearchPage")) {
                cVar.p(true);
                c openSearchPage = this.mJsBridge.openSearchPage(e2.optString("query"), e2.optInt("subType"));
                if (openSearchPage != null) {
                    cVar.v(openSearchPage.f());
                    cVar.r(openSearchPage.b());
                    cVar.m(openSearchPage.a());
                    cVar.u(openSearchPage.e());
                }
                cVar.w(0);
            } else if (b2.equals("hybrid/getSearchHistory")) {
                cVar.p(true);
                c searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    cVar.v(searchHistoryJson.f());
                    cVar.r(searchHistoryJson.b());
                    cVar.m(searchHistoryJson.a());
                    cVar.u(searchHistoryJson.e());
                }
                cVar.w(0);
            } else if (b2.equals("hybrid/getSearchAdCookie")) {
                cVar.p(true);
                c searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    cVar.v(searchAdCookie.f());
                    cVar.r(searchAdCookie.b());
                    cVar.m(searchAdCookie.a());
                    cVar.u(searchAdCookie.e());
                }
                cVar.w(0);
            }
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    @Override // c.a.r0.j3.m0.d.a
    public List<c> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (k.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
