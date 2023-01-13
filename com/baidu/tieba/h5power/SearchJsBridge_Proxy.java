package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.by8;
import com.baidu.tieba.xx8;
import com.baidu.tieba.yi;
import com.baidu.tieba.zx8;
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
public class SearchJsBridge_Proxy extends xx8 {
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

    @Override // com.baidu.tieba.xx8
    public zx8 dispatch(by8 by8Var, zx8 zx8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, by8Var, zx8Var)) == null) {
            if (zx8Var == null) {
                zx8Var = new zx8();
            }
            String b = by8Var.b();
            JSONObject e = by8Var.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                zx8Var.r(true);
                zx8 deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    zx8Var.x(deleteSearchHistory.f());
                    zx8Var.t(deleteSearchHistory.b());
                    zx8Var.o(deleteSearchHistory.a());
                    zx8Var.w(deleteSearchHistory.e());
                }
                zx8Var.y(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                zx8Var.r(true);
                zx8 deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    zx8Var.x(deleteAllSearchHistory.f());
                    zx8Var.t(deleteAllSearchHistory.b());
                    zx8Var.o(deleteAllSearchHistory.a());
                    zx8Var.w(deleteAllSearchHistory.e());
                }
                zx8Var.y(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                zx8Var.r(true);
                zx8 openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    zx8Var.x(openSearchPage.f());
                    zx8Var.t(openSearchPage.b());
                    zx8Var.o(openSearchPage.a());
                    zx8Var.w(openSearchPage.e());
                }
                zx8Var.y(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                zx8Var.r(true);
                zx8 searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    zx8Var.x(searchHistoryJson.f());
                    zx8Var.t(searchHistoryJson.b());
                    zx8Var.o(searchHistoryJson.a());
                    zx8Var.w(searchHistoryJson.e());
                }
                zx8Var.y(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                zx8Var.r(true);
                zx8 searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    zx8Var.x(searchAdCookie.f());
                    zx8Var.t(searchAdCookie.b());
                    zx8Var.o(searchAdCookie.a());
                    zx8Var.w(searchAdCookie.e());
                }
                zx8Var.y(0);
            }
            return zx8Var;
        }
        return (zx8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.xx8
    public List<zx8> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!yi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
