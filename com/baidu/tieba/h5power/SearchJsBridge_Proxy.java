package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.msa;
import com.baidu.tieba.osa;
import com.baidu.tieba.qd;
import com.baidu.tieba.qsa;
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
public class SearchJsBridge_Proxy extends msa {
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

    @Override // com.baidu.tieba.msa
    public osa dispatch(qsa qsaVar, osa osaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qsaVar, osaVar)) == null) {
            if (osaVar == null) {
                osaVar = new osa();
            }
            String b = qsaVar.b();
            JSONObject e = qsaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                osaVar.s(true);
                osa deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    osaVar.y(deleteSearchHistory.f());
                    osaVar.u(deleteSearchHistory.b());
                    osaVar.o(deleteSearchHistory.a());
                    osaVar.x(deleteSearchHistory.e());
                }
                osaVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                osaVar.s(true);
                osa deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    osaVar.y(deleteAllSearchHistory.f());
                    osaVar.u(deleteAllSearchHistory.b());
                    osaVar.o(deleteAllSearchHistory.a());
                    osaVar.x(deleteAllSearchHistory.e());
                }
                osaVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                osaVar.s(true);
                osa openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    osaVar.y(openSearchPage.f());
                    osaVar.u(openSearchPage.b());
                    osaVar.o(openSearchPage.a());
                    osaVar.x(openSearchPage.e());
                }
                osaVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                osaVar.s(true);
                osa searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    osaVar.y(searchHistoryJson.f());
                    osaVar.u(searchHistoryJson.b());
                    osaVar.o(searchHistoryJson.a());
                    osaVar.x(searchHistoryJson.e());
                }
                osaVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                osaVar.s(true);
                osa searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    osaVar.y(searchAdCookie.f());
                    osaVar.u(searchAdCookie.b());
                    osaVar.o(searchAdCookie.a());
                    osaVar.x(searchAdCookie.e());
                }
                osaVar.z(0);
            }
            return osaVar;
        }
        return (osa) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.msa
    public List<osa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!qd.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
