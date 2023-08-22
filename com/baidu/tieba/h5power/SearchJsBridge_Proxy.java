package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.di;
import com.baidu.tieba.qga;
import com.baidu.tieba.sga;
import com.baidu.tieba.uga;
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
public class SearchJsBridge_Proxy extends qga {
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

    @Override // com.baidu.tieba.qga
    public sga dispatch(uga ugaVar, sga sgaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ugaVar, sgaVar)) == null) {
            if (sgaVar == null) {
                sgaVar = new sga();
            }
            String b = ugaVar.b();
            JSONObject e = ugaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                sgaVar.s(true);
                sga deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    sgaVar.y(deleteSearchHistory.f());
                    sgaVar.u(deleteSearchHistory.b());
                    sgaVar.o(deleteSearchHistory.a());
                    sgaVar.x(deleteSearchHistory.e());
                }
                sgaVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                sgaVar.s(true);
                sga deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    sgaVar.y(deleteAllSearchHistory.f());
                    sgaVar.u(deleteAllSearchHistory.b());
                    sgaVar.o(deleteAllSearchHistory.a());
                    sgaVar.x(deleteAllSearchHistory.e());
                }
                sgaVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                sgaVar.s(true);
                sga openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    sgaVar.y(openSearchPage.f());
                    sgaVar.u(openSearchPage.b());
                    sgaVar.o(openSearchPage.a());
                    sgaVar.x(openSearchPage.e());
                }
                sgaVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                sgaVar.s(true);
                sga searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    sgaVar.y(searchHistoryJson.f());
                    sgaVar.u(searchHistoryJson.b());
                    sgaVar.o(searchHistoryJson.a());
                    sgaVar.x(searchHistoryJson.e());
                }
                sgaVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                sgaVar.s(true);
                sga searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    sgaVar.y(searchAdCookie.f());
                    sgaVar.u(searchAdCookie.b());
                    sgaVar.o(searchAdCookie.a());
                    sgaVar.x(searchAdCookie.e());
                }
                sgaVar.z(0);
            }
            return sgaVar;
        }
        return (sga) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.qga
    public List<sga> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!di.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
