package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.ad;
import com.baidu.tieba.gfa;
import com.baidu.tieba.ifa;
import com.baidu.tieba.kfa;
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
public class SearchJsBridge_Proxy extends gfa {
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

    @Override // com.baidu.tieba.gfa
    public ifa dispatch(kfa kfaVar, ifa ifaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kfaVar, ifaVar)) == null) {
            if (ifaVar == null) {
                ifaVar = new ifa();
            }
            String b = kfaVar.b();
            JSONObject e = kfaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                ifaVar.s(true);
                ifa deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    ifaVar.y(deleteSearchHistory.f());
                    ifaVar.u(deleteSearchHistory.b());
                    ifaVar.o(deleteSearchHistory.a());
                    ifaVar.x(deleteSearchHistory.e());
                }
                ifaVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                ifaVar.s(true);
                ifa deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    ifaVar.y(deleteAllSearchHistory.f());
                    ifaVar.u(deleteAllSearchHistory.b());
                    ifaVar.o(deleteAllSearchHistory.a());
                    ifaVar.x(deleteAllSearchHistory.e());
                }
                ifaVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                ifaVar.s(true);
                ifa openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    ifaVar.y(openSearchPage.f());
                    ifaVar.u(openSearchPage.b());
                    ifaVar.o(openSearchPage.a());
                    ifaVar.x(openSearchPage.e());
                }
                ifaVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                ifaVar.s(true);
                ifa searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    ifaVar.y(searchHistoryJson.f());
                    ifaVar.u(searchHistoryJson.b());
                    ifaVar.o(searchHistoryJson.a());
                    ifaVar.x(searchHistoryJson.e());
                }
                ifaVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                ifaVar.s(true);
                ifa searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    ifaVar.y(searchAdCookie.f());
                    ifaVar.u(searchAdCookie.b());
                    ifaVar.o(searchAdCookie.a());
                    ifaVar.x(searchAdCookie.e());
                }
                ifaVar.z(0);
            }
            return ifaVar;
        }
        return (ifa) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.gfa
    public List<ifa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!ad.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
