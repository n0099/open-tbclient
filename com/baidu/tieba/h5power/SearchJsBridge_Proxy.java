package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.bt8;
import com.baidu.tieba.dt8;
import com.baidu.tieba.ft8;
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
public class SearchJsBridge_Proxy extends bt8 {
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

    @Override // com.baidu.tieba.bt8
    public dt8 dispatch(ft8 ft8Var, dt8 dt8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ft8Var, dt8Var)) == null) {
            if (dt8Var == null) {
                dt8Var = new dt8();
            }
            String b = ft8Var.b();
            JSONObject e = ft8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                dt8Var.r(true);
                dt8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    dt8Var.x(deleteSearchHistory.f());
                    dt8Var.t(deleteSearchHistory.b());
                    dt8Var.o(deleteSearchHistory.a());
                    dt8Var.w(deleteSearchHistory.e());
                }
                dt8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                dt8Var.r(true);
                dt8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    dt8Var.x(deleteAllSearchHistory.f());
                    dt8Var.t(deleteAllSearchHistory.b());
                    dt8Var.o(deleteAllSearchHistory.a());
                    dt8Var.w(deleteAllSearchHistory.e());
                }
                dt8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                dt8Var.r(true);
                dt8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    dt8Var.x(openSearchPage.f());
                    dt8Var.t(openSearchPage.b());
                    dt8Var.o(openSearchPage.a());
                    dt8Var.w(openSearchPage.e());
                }
                dt8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                dt8Var.r(true);
                dt8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    dt8Var.x(searchHistoryJson.f());
                    dt8Var.t(searchHistoryJson.b());
                    dt8Var.o(searchHistoryJson.a());
                    dt8Var.w(searchHistoryJson.e());
                }
                dt8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                dt8Var.r(true);
                dt8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    dt8Var.x(searchAdCookie.f());
                    dt8Var.t(searchAdCookie.b());
                    dt8Var.o(searchAdCookie.a());
                    dt8Var.w(searchAdCookie.e());
                }
                dt8Var.y(0);
            }
            return dt8Var;
        }
        return (dt8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.bt8
    public List<dt8> processNotification(String str, HashMap hashMap) {
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
