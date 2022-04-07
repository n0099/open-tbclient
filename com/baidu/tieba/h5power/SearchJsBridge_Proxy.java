package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ml8;
import com.repackage.ni;
import com.repackage.ol8;
import com.repackage.ql8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SearchJsBridge_Proxy extends ml8 {
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

    @Override // com.repackage.ml8
    public ol8 dispatch(ql8 ql8Var, ol8 ol8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ql8Var, ol8Var)) == null) {
            if (ol8Var == null) {
                ol8Var = new ol8();
            }
            String b = ql8Var.b();
            JSONObject e = ql8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                ol8Var.r(true);
                ol8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    ol8Var.x(deleteSearchHistory.f());
                    ol8Var.t(deleteSearchHistory.b());
                    ol8Var.o(deleteSearchHistory.a());
                    ol8Var.w(deleteSearchHistory.e());
                }
                ol8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                ol8Var.r(true);
                ol8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    ol8Var.x(deleteAllSearchHistory.f());
                    ol8Var.t(deleteAllSearchHistory.b());
                    ol8Var.o(deleteAllSearchHistory.a());
                    ol8Var.w(deleteAllSearchHistory.e());
                }
                ol8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                ol8Var.r(true);
                ol8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    ol8Var.x(openSearchPage.f());
                    ol8Var.t(openSearchPage.b());
                    ol8Var.o(openSearchPage.a());
                    ol8Var.w(openSearchPage.e());
                }
                ol8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                ol8Var.r(true);
                ol8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    ol8Var.x(searchHistoryJson.f());
                    ol8Var.t(searchHistoryJson.b());
                    ol8Var.o(searchHistoryJson.a());
                    ol8Var.w(searchHistoryJson.e());
                }
                ol8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                ol8Var.r(true);
                ol8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    ol8Var.x(searchAdCookie.f());
                    ol8Var.t(searchAdCookie.b());
                    ol8Var.o(searchAdCookie.a());
                    ol8Var.w(searchAdCookie.e());
                }
                ol8Var.y(0);
            }
            return ol8Var;
        }
        return (ol8) invokeLL.objValue;
    }

    @Override // com.repackage.ml8
    public List<ol8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (ni.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
