package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.di;
import com.baidu.tieba.qka;
import com.baidu.tieba.ska;
import com.baidu.tieba.uka;
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
public class SearchJsBridge_Proxy extends qka {
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

    @Override // com.baidu.tieba.qka
    public ska dispatch(uka ukaVar, ska skaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ukaVar, skaVar)) == null) {
            if (skaVar == null) {
                skaVar = new ska();
            }
            String b = ukaVar.b();
            JSONObject e = ukaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                skaVar.s(true);
                ska deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    skaVar.y(deleteSearchHistory.f());
                    skaVar.u(deleteSearchHistory.b());
                    skaVar.o(deleteSearchHistory.a());
                    skaVar.x(deleteSearchHistory.e());
                }
                skaVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                skaVar.s(true);
                ska deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    skaVar.y(deleteAllSearchHistory.f());
                    skaVar.u(deleteAllSearchHistory.b());
                    skaVar.o(deleteAllSearchHistory.a());
                    skaVar.x(deleteAllSearchHistory.e());
                }
                skaVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                skaVar.s(true);
                ska openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    skaVar.y(openSearchPage.f());
                    skaVar.u(openSearchPage.b());
                    skaVar.o(openSearchPage.a());
                    skaVar.x(openSearchPage.e());
                }
                skaVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                skaVar.s(true);
                ska searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    skaVar.y(searchHistoryJson.f());
                    skaVar.u(searchHistoryJson.b());
                    skaVar.o(searchHistoryJson.a());
                    skaVar.x(searchHistoryJson.e());
                }
                skaVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                skaVar.s(true);
                ska searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    skaVar.y(searchAdCookie.f());
                    skaVar.u(searchAdCookie.b());
                    skaVar.o(searchAdCookie.a());
                    skaVar.x(searchAdCookie.e());
                }
                skaVar.z(0);
            }
            return skaVar;
        }
        return (ska) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.qka
    public List<ska> processNotification(WebView webView, String str, HashMap hashMap) {
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
