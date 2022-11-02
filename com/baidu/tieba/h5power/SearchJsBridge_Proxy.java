package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.pp8;
import com.baidu.tieba.rp8;
import com.baidu.tieba.tp8;
import com.baidu.tieba.wi;
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
public class SearchJsBridge_Proxy extends pp8 {
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

    @Override // com.baidu.tieba.pp8
    public rp8 dispatch(tp8 tp8Var, rp8 rp8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tp8Var, rp8Var)) == null) {
            if (rp8Var == null) {
                rp8Var = new rp8();
            }
            String b = tp8Var.b();
            JSONObject e = tp8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                rp8Var.r(true);
                rp8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    rp8Var.x(deleteSearchHistory.f());
                    rp8Var.t(deleteSearchHistory.b());
                    rp8Var.o(deleteSearchHistory.a());
                    rp8Var.w(deleteSearchHistory.e());
                }
                rp8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                rp8Var.r(true);
                rp8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    rp8Var.x(deleteAllSearchHistory.f());
                    rp8Var.t(deleteAllSearchHistory.b());
                    rp8Var.o(deleteAllSearchHistory.a());
                    rp8Var.w(deleteAllSearchHistory.e());
                }
                rp8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                rp8Var.r(true);
                rp8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    rp8Var.x(openSearchPage.f());
                    rp8Var.t(openSearchPage.b());
                    rp8Var.o(openSearchPage.a());
                    rp8Var.w(openSearchPage.e());
                }
                rp8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                rp8Var.r(true);
                rp8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    rp8Var.x(searchHistoryJson.f());
                    rp8Var.t(searchHistoryJson.b());
                    rp8Var.o(searchHistoryJson.a());
                    rp8Var.w(searchHistoryJson.e());
                }
                rp8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                rp8Var.r(true);
                rp8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    rp8Var.x(searchAdCookie.f());
                    rp8Var.t(searchAdCookie.b());
                    rp8Var.o(searchAdCookie.a());
                    rp8Var.w(searchAdCookie.e());
                }
                rp8Var.y(0);
            }
            return rp8Var;
        }
        return (rp8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.pp8
    public List<rp8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (!wi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }
}
