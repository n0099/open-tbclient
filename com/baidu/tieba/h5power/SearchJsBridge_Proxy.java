package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.bi;
import com.baidu.tieba.hca;
import com.baidu.tieba.jca;
import com.baidu.tieba.lca;
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
public class SearchJsBridge_Proxy extends hca {
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

    @Override // com.baidu.tieba.hca
    public jca dispatch(lca lcaVar, jca jcaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, lcaVar, jcaVar)) == null) {
            if (jcaVar == null) {
                jcaVar = new jca();
            }
            String b = lcaVar.b();
            JSONObject e = lcaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                jcaVar.s(true);
                jca deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    jcaVar.y(deleteSearchHistory.f());
                    jcaVar.u(deleteSearchHistory.b());
                    jcaVar.o(deleteSearchHistory.a());
                    jcaVar.x(deleteSearchHistory.e());
                }
                jcaVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                jcaVar.s(true);
                jca deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    jcaVar.y(deleteAllSearchHistory.f());
                    jcaVar.u(deleteAllSearchHistory.b());
                    jcaVar.o(deleteAllSearchHistory.a());
                    jcaVar.x(deleteAllSearchHistory.e());
                }
                jcaVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                jcaVar.s(true);
                jca openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    jcaVar.y(openSearchPage.f());
                    jcaVar.u(openSearchPage.b());
                    jcaVar.o(openSearchPage.a());
                    jcaVar.x(openSearchPage.e());
                }
                jcaVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                jcaVar.s(true);
                jca searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    jcaVar.y(searchHistoryJson.f());
                    jcaVar.u(searchHistoryJson.b());
                    jcaVar.o(searchHistoryJson.a());
                    jcaVar.x(searchHistoryJson.e());
                }
                jcaVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                jcaVar.s(true);
                jca searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    jcaVar.y(searchAdCookie.f());
                    jcaVar.u(searchAdCookie.b());
                    jcaVar.o(searchAdCookie.a());
                    jcaVar.x(searchAdCookie.e());
                }
                jcaVar.z(0);
            }
            return jcaVar;
        }
        return (jca) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.hca
    public List<jca> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!bi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
