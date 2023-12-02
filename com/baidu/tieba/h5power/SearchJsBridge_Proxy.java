package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.dxa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.hxa;
import com.baidu.tieba.rd;
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
/* loaded from: classes6.dex */
public class SearchJsBridge_Proxy extends dxa {
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

    @Override // com.baidu.tieba.dxa
    public fxa dispatch(hxa hxaVar, fxa fxaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hxaVar, fxaVar)) == null) {
            if (fxaVar == null) {
                fxaVar = new fxa();
            }
            String b = hxaVar.b();
            JSONObject e = hxaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                fxaVar.s(true);
                fxa deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    fxaVar.y(deleteSearchHistory.f());
                    fxaVar.u(deleteSearchHistory.b());
                    fxaVar.o(deleteSearchHistory.a());
                    fxaVar.x(deleteSearchHistory.e());
                }
                fxaVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                fxaVar.s(true);
                fxa deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    fxaVar.y(deleteAllSearchHistory.f());
                    fxaVar.u(deleteAllSearchHistory.b());
                    fxaVar.o(deleteAllSearchHistory.a());
                    fxaVar.x(deleteAllSearchHistory.e());
                }
                fxaVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                fxaVar.s(true);
                fxa openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    fxaVar.y(openSearchPage.f());
                    fxaVar.u(openSearchPage.b());
                    fxaVar.o(openSearchPage.a());
                    fxaVar.x(openSearchPage.e());
                }
                fxaVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                fxaVar.s(true);
                fxa searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    fxaVar.y(searchHistoryJson.f());
                    fxaVar.u(searchHistoryJson.b());
                    fxaVar.o(searchHistoryJson.a());
                    fxaVar.x(searchHistoryJson.e());
                }
                fxaVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                fxaVar.s(true);
                fxa searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    fxaVar.y(searchAdCookie.f());
                    fxaVar.u(searchAdCookie.b());
                    fxaVar.o(searchAdCookie.a());
                    fxaVar.x(searchAdCookie.e());
                }
                fxaVar.z(0);
            }
            return fxaVar;
        }
        return (fxa) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public List<fxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!rd.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
