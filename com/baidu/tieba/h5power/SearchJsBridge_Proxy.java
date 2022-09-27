package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.bo8;
import com.baidu.tieba.dj;
import com.baidu.tieba.do8;
import com.baidu.tieba.zn8;
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
public class SearchJsBridge_Proxy extends zn8 {
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

    @Override // com.baidu.tieba.zn8
    public bo8 dispatch(do8 do8Var, bo8 bo8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, do8Var, bo8Var)) == null) {
            if (bo8Var == null) {
                bo8Var = new bo8();
            }
            String b = do8Var.b();
            JSONObject e = do8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                bo8Var.r(true);
                bo8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    bo8Var.x(deleteSearchHistory.f());
                    bo8Var.t(deleteSearchHistory.b());
                    bo8Var.o(deleteSearchHistory.a());
                    bo8Var.w(deleteSearchHistory.e());
                }
                bo8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                bo8Var.r(true);
                bo8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    bo8Var.x(deleteAllSearchHistory.f());
                    bo8Var.t(deleteAllSearchHistory.b());
                    bo8Var.o(deleteAllSearchHistory.a());
                    bo8Var.w(deleteAllSearchHistory.e());
                }
                bo8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                bo8Var.r(true);
                bo8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    bo8Var.x(openSearchPage.f());
                    bo8Var.t(openSearchPage.b());
                    bo8Var.o(openSearchPage.a());
                    bo8Var.w(openSearchPage.e());
                }
                bo8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                bo8Var.r(true);
                bo8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    bo8Var.x(searchHistoryJson.f());
                    bo8Var.t(searchHistoryJson.b());
                    bo8Var.o(searchHistoryJson.a());
                    bo8Var.w(searchHistoryJson.e());
                }
                bo8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                bo8Var.r(true);
                bo8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    bo8Var.x(searchAdCookie.f());
                    bo8Var.t(searchAdCookie.b());
                    bo8Var.o(searchAdCookie.a());
                    bo8Var.w(searchAdCookie.e());
                }
                bo8Var.y(0);
            }
            return bo8Var;
        }
        return (bo8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.zn8
    public List<bo8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (dj.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
