package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fj8;
import com.repackage.hj8;
import com.repackage.jj8;
import com.repackage.oi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SearchJsBridge_Proxy extends fj8 {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = searchJsBridge;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.repackage.fj8
    public hj8 dispatch(jj8 jj8Var, hj8 hj8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jj8Var, hj8Var)) == null) {
            if (hj8Var == null) {
                hj8Var = new hj8();
            }
            String b = jj8Var.b();
            JSONObject e = jj8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                hj8Var.r(true);
                hj8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    hj8Var.x(deleteSearchHistory.f());
                    hj8Var.t(deleteSearchHistory.b());
                    hj8Var.o(deleteSearchHistory.a());
                    hj8Var.w(deleteSearchHistory.e());
                }
                hj8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                hj8Var.r(true);
                hj8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    hj8Var.x(deleteAllSearchHistory.f());
                    hj8Var.t(deleteAllSearchHistory.b());
                    hj8Var.o(deleteAllSearchHistory.a());
                    hj8Var.w(deleteAllSearchHistory.e());
                }
                hj8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                hj8Var.r(true);
                hj8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    hj8Var.x(openSearchPage.f());
                    hj8Var.t(openSearchPage.b());
                    hj8Var.o(openSearchPage.a());
                    hj8Var.w(openSearchPage.e());
                }
                hj8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                hj8Var.r(true);
                hj8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    hj8Var.x(searchHistoryJson.f());
                    hj8Var.t(searchHistoryJson.b());
                    hj8Var.o(searchHistoryJson.a());
                    hj8Var.w(searchHistoryJson.e());
                }
                hj8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                hj8Var.r(true);
                hj8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    hj8Var.x(searchAdCookie.f());
                    hj8Var.t(searchAdCookie.b());
                    hj8Var.o(searchAdCookie.a());
                    hj8Var.w(searchAdCookie.e());
                }
                hj8Var.y(0);
            }
            return hj8Var;
        }
        return (hj8) invokeLL.objValue;
    }

    @Override // com.repackage.fj8
    public List<hj8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (oi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
