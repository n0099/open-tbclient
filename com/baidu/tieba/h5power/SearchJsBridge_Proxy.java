package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pi;
import com.repackage.ql8;
import com.repackage.sl8;
import com.repackage.ul8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SearchJsBridge_Proxy extends ql8 {
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

    @Override // com.repackage.ql8
    public sl8 dispatch(ul8 ul8Var, sl8 sl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ul8Var, sl8Var)) == null) {
            if (sl8Var == null) {
                sl8Var = new sl8();
            }
            String b = ul8Var.b();
            JSONObject e = ul8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                sl8Var.r(true);
                sl8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    sl8Var.x(deleteSearchHistory.f());
                    sl8Var.t(deleteSearchHistory.b());
                    sl8Var.o(deleteSearchHistory.a());
                    sl8Var.w(deleteSearchHistory.e());
                }
                sl8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                sl8Var.r(true);
                sl8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    sl8Var.x(deleteAllSearchHistory.f());
                    sl8Var.t(deleteAllSearchHistory.b());
                    sl8Var.o(deleteAllSearchHistory.a());
                    sl8Var.w(deleteAllSearchHistory.e());
                }
                sl8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                sl8Var.r(true);
                sl8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt("subType"));
                if (openSearchPage != null) {
                    sl8Var.x(openSearchPage.f());
                    sl8Var.t(openSearchPage.b());
                    sl8Var.o(openSearchPage.a());
                    sl8Var.w(openSearchPage.e());
                }
                sl8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                sl8Var.r(true);
                sl8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    sl8Var.x(searchHistoryJson.f());
                    sl8Var.t(searchHistoryJson.b());
                    sl8Var.o(searchHistoryJson.a());
                    sl8Var.w(searchHistoryJson.e());
                }
                sl8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                sl8Var.r(true);
                sl8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    sl8Var.x(searchAdCookie.f());
                    sl8Var.t(searchAdCookie.b());
                    sl8Var.o(searchAdCookie.a());
                    sl8Var.w(searchAdCookie.e());
                }
                sl8Var.y(0);
            }
            return sl8Var;
        }
        return (sl8) invokeLL.objValue;
    }

    @Override // com.repackage.ql8
    public List<sl8> processNotification(String str, HashMap hashMap) {
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
