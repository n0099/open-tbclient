package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.at8;
import com.baidu.tieba.ct8;
import com.baidu.tieba.et8;
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
public class SearchJsBridge_Proxy extends at8 {
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

    @Override // com.baidu.tieba.at8
    public ct8 dispatch(et8 et8Var, ct8 ct8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, et8Var, ct8Var)) == null) {
            if (ct8Var == null) {
                ct8Var = new ct8();
            }
            String b = et8Var.b();
            JSONObject e = et8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                ct8Var.r(true);
                ct8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    ct8Var.x(deleteSearchHistory.f());
                    ct8Var.t(deleteSearchHistory.b());
                    ct8Var.o(deleteSearchHistory.a());
                    ct8Var.w(deleteSearchHistory.e());
                }
                ct8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                ct8Var.r(true);
                ct8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    ct8Var.x(deleteAllSearchHistory.f());
                    ct8Var.t(deleteAllSearchHistory.b());
                    ct8Var.o(deleteAllSearchHistory.a());
                    ct8Var.w(deleteAllSearchHistory.e());
                }
                ct8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                ct8Var.r(true);
                ct8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    ct8Var.x(openSearchPage.f());
                    ct8Var.t(openSearchPage.b());
                    ct8Var.o(openSearchPage.a());
                    ct8Var.w(openSearchPage.e());
                }
                ct8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                ct8Var.r(true);
                ct8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    ct8Var.x(searchHistoryJson.f());
                    ct8Var.t(searchHistoryJson.b());
                    ct8Var.o(searchHistoryJson.a());
                    ct8Var.w(searchHistoryJson.e());
                }
                ct8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                ct8Var.r(true);
                ct8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    ct8Var.x(searchAdCookie.f());
                    ct8Var.t(searchAdCookie.b());
                    ct8Var.o(searchAdCookie.a());
                    ct8Var.w(searchAdCookie.e());
                }
                ct8Var.y(0);
            }
            return ct8Var;
        }
        return (ct8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.at8
    public List<ct8> processNotification(String str, HashMap hashMap) {
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
