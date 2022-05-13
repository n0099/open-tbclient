package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.li;
import com.repackage.qk8;
import com.repackage.sk8;
import com.repackage.uk8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SearchJsBridge_Proxy extends qk8 {
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

    @Override // com.repackage.qk8
    public sk8 dispatch(uk8 uk8Var, sk8 sk8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uk8Var, sk8Var)) == null) {
            if (sk8Var == null) {
                sk8Var = new sk8();
            }
            String b = uk8Var.b();
            JSONObject e = uk8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                sk8Var.r(true);
                sk8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    sk8Var.x(deleteSearchHistory.f());
                    sk8Var.t(deleteSearchHistory.b());
                    sk8Var.o(deleteSearchHistory.a());
                    sk8Var.w(deleteSearchHistory.e());
                }
                sk8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                sk8Var.r(true);
                sk8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    sk8Var.x(deleteAllSearchHistory.f());
                    sk8Var.t(deleteAllSearchHistory.b());
                    sk8Var.o(deleteAllSearchHistory.a());
                    sk8Var.w(deleteAllSearchHistory.e());
                }
                sk8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                sk8Var.r(true);
                sk8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    sk8Var.x(openSearchPage.f());
                    sk8Var.t(openSearchPage.b());
                    sk8Var.o(openSearchPage.a());
                    sk8Var.w(openSearchPage.e());
                }
                sk8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                sk8Var.r(true);
                sk8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    sk8Var.x(searchHistoryJson.f());
                    sk8Var.t(searchHistoryJson.b());
                    sk8Var.o(searchHistoryJson.a());
                    sk8Var.w(searchHistoryJson.e());
                }
                sk8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                sk8Var.r(true);
                sk8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    sk8Var.x(searchAdCookie.f());
                    sk8Var.t(searchAdCookie.b());
                    sk8Var.o(searchAdCookie.a());
                    sk8Var.w(searchAdCookie.e());
                }
                sk8Var.y(0);
            }
            return sk8Var;
        }
        return (sk8) invokeLL.objValue;
    }

    @Override // com.repackage.qk8
    public List<sk8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (li.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
