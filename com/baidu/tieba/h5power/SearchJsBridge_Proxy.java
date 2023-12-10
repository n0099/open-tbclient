package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.exa;
import com.baidu.tieba.gxa;
import com.baidu.tieba.ixa;
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
public class SearchJsBridge_Proxy extends exa {
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

    @Override // com.baidu.tieba.exa
    public gxa dispatch(ixa ixaVar, gxa gxaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ixaVar, gxaVar)) == null) {
            if (gxaVar == null) {
                gxaVar = new gxa();
            }
            String b = ixaVar.b();
            JSONObject e = ixaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                gxaVar.s(true);
                gxa deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    gxaVar.y(deleteSearchHistory.f());
                    gxaVar.u(deleteSearchHistory.b());
                    gxaVar.o(deleteSearchHistory.a());
                    gxaVar.x(deleteSearchHistory.e());
                }
                gxaVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                gxaVar.s(true);
                gxa deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    gxaVar.y(deleteAllSearchHistory.f());
                    gxaVar.u(deleteAllSearchHistory.b());
                    gxaVar.o(deleteAllSearchHistory.a());
                    gxaVar.x(deleteAllSearchHistory.e());
                }
                gxaVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                gxaVar.s(true);
                gxa openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    gxaVar.y(openSearchPage.f());
                    gxaVar.u(openSearchPage.b());
                    gxaVar.o(openSearchPage.a());
                    gxaVar.x(openSearchPage.e());
                }
                gxaVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                gxaVar.s(true);
                gxa searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    gxaVar.y(searchHistoryJson.f());
                    gxaVar.u(searchHistoryJson.b());
                    gxaVar.o(searchHistoryJson.a());
                    gxaVar.x(searchHistoryJson.e());
                }
                gxaVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                gxaVar.s(true);
                gxa searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    gxaVar.y(searchAdCookie.f());
                    gxaVar.u(searchAdCookie.b());
                    gxaVar.o(searchAdCookie.a());
                    gxaVar.x(searchAdCookie.e());
                }
                gxaVar.z(0);
            }
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.exa
    public List<gxa> processNotification(WebView webView, String str, HashMap hashMap) {
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
