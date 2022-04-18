package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ni;
import com.repackage.tl8;
import com.repackage.vl8;
import com.repackage.xl8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SearchJsBridge_Proxy extends tl8 {
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

    @Override // com.repackage.tl8
    public vl8 dispatch(xl8 xl8Var, vl8 vl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, xl8Var, vl8Var)) == null) {
            if (vl8Var == null) {
                vl8Var = new vl8();
            }
            String b = xl8Var.b();
            JSONObject e = xl8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                vl8Var.r(true);
                vl8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    vl8Var.x(deleteSearchHistory.f());
                    vl8Var.t(deleteSearchHistory.b());
                    vl8Var.o(deleteSearchHistory.a());
                    vl8Var.w(deleteSearchHistory.e());
                }
                vl8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                vl8Var.r(true);
                vl8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    vl8Var.x(deleteAllSearchHistory.f());
                    vl8Var.t(deleteAllSearchHistory.b());
                    vl8Var.o(deleteAllSearchHistory.a());
                    vl8Var.w(deleteAllSearchHistory.e());
                }
                vl8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                vl8Var.r(true);
                vl8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    vl8Var.x(openSearchPage.f());
                    vl8Var.t(openSearchPage.b());
                    vl8Var.o(openSearchPage.a());
                    vl8Var.w(openSearchPage.e());
                }
                vl8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                vl8Var.r(true);
                vl8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    vl8Var.x(searchHistoryJson.f());
                    vl8Var.t(searchHistoryJson.b());
                    vl8Var.o(searchHistoryJson.a());
                    vl8Var.w(searchHistoryJson.e());
                }
                vl8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                vl8Var.r(true);
                vl8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    vl8Var.x(searchAdCookie.f());
                    vl8Var.t(searchAdCookie.b());
                    vl8Var.o(searchAdCookie.a());
                    vl8Var.w(searchAdCookie.e());
                }
                vl8Var.y(0);
            }
            return vl8Var;
        }
        return (vl8) invokeLL.objValue;
    }

    @Override // com.repackage.tl8
    public List<vl8> processNotification(String str, HashMap hashMap) {
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
