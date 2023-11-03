package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.lsa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.psa;
import com.baidu.tieba.qd;
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
public class SearchJsBridge_Proxy extends lsa {
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

    @Override // com.baidu.tieba.lsa
    public nsa dispatch(psa psaVar, nsa nsaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, psaVar, nsaVar)) == null) {
            if (nsaVar == null) {
                nsaVar = new nsa();
            }
            String b = psaVar.b();
            JSONObject e = psaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                nsaVar.s(true);
                nsa deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    nsaVar.y(deleteSearchHistory.f());
                    nsaVar.u(deleteSearchHistory.b());
                    nsaVar.o(deleteSearchHistory.a());
                    nsaVar.x(deleteSearchHistory.e());
                }
                nsaVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                nsaVar.s(true);
                nsa deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    nsaVar.y(deleteAllSearchHistory.f());
                    nsaVar.u(deleteAllSearchHistory.b());
                    nsaVar.o(deleteAllSearchHistory.a());
                    nsaVar.x(deleteAllSearchHistory.e());
                }
                nsaVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                nsaVar.s(true);
                nsa openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    nsaVar.y(openSearchPage.f());
                    nsaVar.u(openSearchPage.b());
                    nsaVar.o(openSearchPage.a());
                    nsaVar.x(openSearchPage.e());
                }
                nsaVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                nsaVar.s(true);
                nsa searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    nsaVar.y(searchHistoryJson.f());
                    nsaVar.u(searchHistoryJson.b());
                    nsaVar.o(searchHistoryJson.a());
                    nsaVar.x(searchHistoryJson.e());
                }
                nsaVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                nsaVar.s(true);
                nsa searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    nsaVar.y(searchAdCookie.f());
                    nsaVar.u(searchAdCookie.b());
                    nsaVar.o(searchAdCookie.a());
                    nsaVar.x(searchAdCookie.e());
                }
                nsaVar.z(0);
            }
            return nsaVar;
        }
        return (nsa) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public List<nsa> processNotification(WebView webView, String str, HashMap hashMap) {
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
