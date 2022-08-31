package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.am8;
import com.baidu.tieba.qi;
import com.baidu.tieba.wl8;
import com.baidu.tieba.yl8;
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
public class SearchJsBridge_Proxy extends wl8 {
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

    @Override // com.baidu.tieba.wl8
    public yl8 dispatch(am8 am8Var, yl8 yl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, am8Var, yl8Var)) == null) {
            if (yl8Var == null) {
                yl8Var = new yl8();
            }
            String b = am8Var.b();
            JSONObject e = am8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                yl8Var.r(true);
                yl8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    yl8Var.x(deleteSearchHistory.f());
                    yl8Var.t(deleteSearchHistory.b());
                    yl8Var.o(deleteSearchHistory.a());
                    yl8Var.w(deleteSearchHistory.e());
                }
                yl8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                yl8Var.r(true);
                yl8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    yl8Var.x(deleteAllSearchHistory.f());
                    yl8Var.t(deleteAllSearchHistory.b());
                    yl8Var.o(deleteAllSearchHistory.a());
                    yl8Var.w(deleteAllSearchHistory.e());
                }
                yl8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                yl8Var.r(true);
                yl8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    yl8Var.x(openSearchPage.f());
                    yl8Var.t(openSearchPage.b());
                    yl8Var.o(openSearchPage.a());
                    yl8Var.w(openSearchPage.e());
                }
                yl8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                yl8Var.r(true);
                yl8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    yl8Var.x(searchHistoryJson.f());
                    yl8Var.t(searchHistoryJson.b());
                    yl8Var.o(searchHistoryJson.a());
                    yl8Var.w(searchHistoryJson.e());
                }
                yl8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                yl8Var.r(true);
                yl8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    yl8Var.x(searchAdCookie.f());
                    yl8Var.t(searchAdCookie.b());
                    yl8Var.o(searchAdCookie.a());
                    yl8Var.w(searchAdCookie.e());
                }
                yl8Var.y(0);
            }
            return yl8Var;
        }
        return (yl8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.wl8
    public List<yl8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (qi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
