package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pi;
import com.repackage.rl8;
import com.repackage.tl8;
import com.repackage.vl8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SearchJsBridge_Proxy extends rl8 {
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

    @Override // com.repackage.rl8
    public tl8 dispatch(vl8 vl8Var, tl8 tl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vl8Var, tl8Var)) == null) {
            if (tl8Var == null) {
                tl8Var = new tl8();
            }
            String b = vl8Var.b();
            JSONObject e = vl8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                tl8Var.r(true);
                tl8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    tl8Var.x(deleteSearchHistory.f());
                    tl8Var.t(deleteSearchHistory.b());
                    tl8Var.o(deleteSearchHistory.a());
                    tl8Var.w(deleteSearchHistory.e());
                }
                tl8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                tl8Var.r(true);
                tl8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    tl8Var.x(deleteAllSearchHistory.f());
                    tl8Var.t(deleteAllSearchHistory.b());
                    tl8Var.o(deleteAllSearchHistory.a());
                    tl8Var.w(deleteAllSearchHistory.e());
                }
                tl8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                tl8Var.r(true);
                tl8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    tl8Var.x(openSearchPage.f());
                    tl8Var.t(openSearchPage.b());
                    tl8Var.o(openSearchPage.a());
                    tl8Var.w(openSearchPage.e());
                }
                tl8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                tl8Var.r(true);
                tl8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    tl8Var.x(searchHistoryJson.f());
                    tl8Var.t(searchHistoryJson.b());
                    tl8Var.o(searchHistoryJson.a());
                    tl8Var.w(searchHistoryJson.e());
                }
                tl8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                tl8Var.r(true);
                tl8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    tl8Var.x(searchAdCookie.f());
                    tl8Var.t(searchAdCookie.b());
                    tl8Var.o(searchAdCookie.a());
                    tl8Var.w(searchAdCookie.e());
                }
                tl8Var.y(0);
            }
            return tl8Var;
        }
        return (tl8) invokeLL.objValue;
    }

    @Override // com.repackage.rl8
    public List<tl8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (pi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
