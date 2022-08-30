package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.am8;
import com.baidu.tieba.cm8;
import com.baidu.tieba.qi;
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
public class SearchJsBridge_Proxy extends yl8 {
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

    @Override // com.baidu.tieba.yl8
    public am8 dispatch(cm8 cm8Var, am8 am8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cm8Var, am8Var)) == null) {
            if (am8Var == null) {
                am8Var = new am8();
            }
            String b = cm8Var.b();
            JSONObject e = cm8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                am8Var.r(true);
                am8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    am8Var.x(deleteSearchHistory.f());
                    am8Var.t(deleteSearchHistory.b());
                    am8Var.o(deleteSearchHistory.a());
                    am8Var.w(deleteSearchHistory.e());
                }
                am8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                am8Var.r(true);
                am8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    am8Var.x(deleteAllSearchHistory.f());
                    am8Var.t(deleteAllSearchHistory.b());
                    am8Var.o(deleteAllSearchHistory.a());
                    am8Var.w(deleteAllSearchHistory.e());
                }
                am8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                am8Var.r(true);
                am8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    am8Var.x(openSearchPage.f());
                    am8Var.t(openSearchPage.b());
                    am8Var.o(openSearchPage.a());
                    am8Var.w(openSearchPage.e());
                }
                am8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                am8Var.r(true);
                am8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    am8Var.x(searchHistoryJson.f());
                    am8Var.t(searchHistoryJson.b());
                    am8Var.o(searchHistoryJson.a());
                    am8Var.w(searchHistoryJson.e());
                }
                am8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                am8Var.r(true);
                am8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    am8Var.x(searchAdCookie.f());
                    am8Var.t(searchAdCookie.b());
                    am8Var.o(searchAdCookie.a());
                    am8Var.w(searchAdCookie.e());
                }
                am8Var.y(0);
            }
            return am8Var;
        }
        return (am8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.yl8
    public List<am8> processNotification(String str, HashMap hashMap) {
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
