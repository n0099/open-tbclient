package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.s0.h3.l0.d.a;
import d.a.s0.h3.l0.d.c;
import d.a.s0.h3.l0.d.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
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

    @Override // d.a.s0.h3.l0.d.a
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
                cVar.o(true);
                c deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e2.optString("query"));
                if (deleteSearchHistory != null) {
                    cVar.t(deleteSearchHistory.e());
                    cVar.q(deleteSearchHistory.b());
                    cVar.l(deleteSearchHistory.a());
                }
                cVar.u(0);
            } else if (b2.equals("hybrid/deleteAllSearchHistory")) {
                cVar.o(true);
                c deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    cVar.t(deleteAllSearchHistory.e());
                    cVar.q(deleteAllSearchHistory.b());
                    cVar.l(deleteAllSearchHistory.a());
                }
                cVar.u(0);
            } else if (b2.equals("hybrid/openSearchPage")) {
                cVar.o(true);
                c openSearchPage = this.mJsBridge.openSearchPage(e2.optString("query"), e2.optInt("subType"));
                if (openSearchPage != null) {
                    cVar.t(openSearchPage.e());
                    cVar.q(openSearchPage.b());
                    cVar.l(openSearchPage.a());
                }
                cVar.u(0);
            } else if (b2.equals("hybrid/getSearchHistory")) {
                cVar.o(true);
                c searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    cVar.t(searchHistoryJson.e());
                    cVar.q(searchHistoryJson.b());
                    cVar.l(searchHistoryJson.a());
                }
                cVar.u(0);
            } else if (b2.equals("hybrid/getSearchAdCookie")) {
                cVar.o(true);
                c searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    cVar.t(searchAdCookie.e());
                    cVar.q(searchAdCookie.b());
                    cVar.l(searchAdCookie.a());
                }
                cVar.u(0);
            }
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    @Override // d.a.s0.h3.l0.d.a
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
