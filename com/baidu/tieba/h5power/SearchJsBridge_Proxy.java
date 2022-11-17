package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.bq8;
import com.baidu.tieba.dq8;
import com.baidu.tieba.fq8;
import com.baidu.tieba.xi;
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
/* loaded from: classes4.dex */
public class SearchJsBridge_Proxy extends bq8 {
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

    @Override // com.baidu.tieba.bq8
    public dq8 dispatch(fq8 fq8Var, dq8 dq8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fq8Var, dq8Var)) == null) {
            if (dq8Var == null) {
                dq8Var = new dq8();
            }
            String b = fq8Var.b();
            JSONObject e = fq8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                dq8Var.r(true);
                dq8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    dq8Var.x(deleteSearchHistory.f());
                    dq8Var.t(deleteSearchHistory.b());
                    dq8Var.o(deleteSearchHistory.a());
                    dq8Var.w(deleteSearchHistory.e());
                }
                dq8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                dq8Var.r(true);
                dq8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    dq8Var.x(deleteAllSearchHistory.f());
                    dq8Var.t(deleteAllSearchHistory.b());
                    dq8Var.o(deleteAllSearchHistory.a());
                    dq8Var.w(deleteAllSearchHistory.e());
                }
                dq8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                dq8Var.r(true);
                dq8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    dq8Var.x(openSearchPage.f());
                    dq8Var.t(openSearchPage.b());
                    dq8Var.o(openSearchPage.a());
                    dq8Var.w(openSearchPage.e());
                }
                dq8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                dq8Var.r(true);
                dq8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    dq8Var.x(searchHistoryJson.f());
                    dq8Var.t(searchHistoryJson.b());
                    dq8Var.o(searchHistoryJson.a());
                    dq8Var.w(searchHistoryJson.e());
                }
                dq8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                dq8Var.r(true);
                dq8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    dq8Var.x(searchAdCookie.f());
                    dq8Var.t(searchAdCookie.b());
                    dq8Var.o(searchAdCookie.a());
                    dq8Var.w(searchAdCookie.e());
                }
                dq8Var.y(0);
            }
            return dq8Var;
        }
        return (dq8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.bq8
    public List<dq8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (!xi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }
}
