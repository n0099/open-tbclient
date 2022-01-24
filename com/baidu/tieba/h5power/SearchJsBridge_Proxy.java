package com.baidu.tieba.h5power;

import c.a.d.f.p.m;
import c.a.t0.x3.n0.d.a;
import c.a.t0.x3.n0.d.c;
import c.a.t0.x3.n0.d.e;
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
/* loaded from: classes12.dex */
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

    @Override // c.a.t0.x3.n0.d.a
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
                cVar.r(true);
                c deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e2.optString("query"));
                if (deleteSearchHistory != null) {
                    cVar.x(deleteSearchHistory.f());
                    cVar.t(deleteSearchHistory.b());
                    cVar.o(deleteSearchHistory.a());
                    cVar.w(deleteSearchHistory.e());
                }
                cVar.y(0);
            } else if (b2.equals("hybrid/deleteAllSearchHistory")) {
                cVar.r(true);
                c deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    cVar.x(deleteAllSearchHistory.f());
                    cVar.t(deleteAllSearchHistory.b());
                    cVar.o(deleteAllSearchHistory.a());
                    cVar.w(deleteAllSearchHistory.e());
                }
                cVar.y(0);
            } else if (b2.equals("hybrid/openSearchPage")) {
                cVar.r(true);
                c openSearchPage = this.mJsBridge.openSearchPage(e2.optString("query"), e2.optInt("subType"));
                if (openSearchPage != null) {
                    cVar.x(openSearchPage.f());
                    cVar.t(openSearchPage.b());
                    cVar.o(openSearchPage.a());
                    cVar.w(openSearchPage.e());
                }
                cVar.y(0);
            } else if (b2.equals("hybrid/getSearchHistory")) {
                cVar.r(true);
                c searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    cVar.x(searchHistoryJson.f());
                    cVar.t(searchHistoryJson.b());
                    cVar.o(searchHistoryJson.a());
                    cVar.w(searchHistoryJson.e());
                }
                cVar.y(0);
            } else if (b2.equals("hybrid/getSearchAdCookie")) {
                cVar.r(true);
                c searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    cVar.x(searchAdCookie.f());
                    cVar.t(searchAdCookie.b());
                    cVar.o(searchAdCookie.a());
                    cVar.w(searchAdCookie.e());
                }
                cVar.y(0);
            }
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    @Override // c.a.t0.x3.n0.d.a
    public List<c> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (m.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
