package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ji8;
import com.repackage.li8;
import com.repackage.ni8;
import com.repackage.oi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SearchJsBridge_Proxy extends ji8 {
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

    @Override // com.repackage.ji8
    public li8 dispatch(ni8 ni8Var, li8 li8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ni8Var, li8Var)) == null) {
            if (li8Var == null) {
                li8Var = new li8();
            }
            String b = ni8Var.b();
            JSONObject e = ni8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                li8Var.r(true);
                li8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    li8Var.x(deleteSearchHistory.f());
                    li8Var.t(deleteSearchHistory.b());
                    li8Var.o(deleteSearchHistory.a());
                    li8Var.w(deleteSearchHistory.e());
                }
                li8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                li8Var.r(true);
                li8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    li8Var.x(deleteAllSearchHistory.f());
                    li8Var.t(deleteAllSearchHistory.b());
                    li8Var.o(deleteAllSearchHistory.a());
                    li8Var.w(deleteAllSearchHistory.e());
                }
                li8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                li8Var.r(true);
                li8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    li8Var.x(openSearchPage.f());
                    li8Var.t(openSearchPage.b());
                    li8Var.o(openSearchPage.a());
                    li8Var.w(openSearchPage.e());
                }
                li8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                li8Var.r(true);
                li8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    li8Var.x(searchHistoryJson.f());
                    li8Var.t(searchHistoryJson.b());
                    li8Var.o(searchHistoryJson.a());
                    li8Var.w(searchHistoryJson.e());
                }
                li8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                li8Var.r(true);
                li8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    li8Var.x(searchAdCookie.f());
                    li8Var.t(searchAdCookie.b());
                    li8Var.o(searchAdCookie.a());
                    li8Var.w(searchAdCookie.e());
                }
                li8Var.y(0);
            }
            return li8Var;
        }
        return (li8) invokeLL.objValue;
    }

    @Override // com.repackage.ji8
    public List<li8> processNotification(String str, HashMap hashMap) {
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
