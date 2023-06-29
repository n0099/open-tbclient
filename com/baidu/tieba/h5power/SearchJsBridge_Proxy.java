package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.d5a;
import com.baidu.tieba.f5a;
import com.baidu.tieba.h5a;
import com.baidu.tieba.wi;
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
public class SearchJsBridge_Proxy extends d5a {
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

    @Override // com.baidu.tieba.d5a
    public f5a dispatch(h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, h5aVar, f5aVar)) == null) {
            if (f5aVar == null) {
                f5aVar = new f5a();
            }
            String b = h5aVar.b();
            JSONObject e = h5aVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                f5aVar.s(true);
                f5a deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    f5aVar.y(deleteSearchHistory.f());
                    f5aVar.u(deleteSearchHistory.b());
                    f5aVar.o(deleteSearchHistory.a());
                    f5aVar.x(deleteSearchHistory.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                f5aVar.s(true);
                f5a deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    f5aVar.y(deleteAllSearchHistory.f());
                    f5aVar.u(deleteAllSearchHistory.b());
                    f5aVar.o(deleteAllSearchHistory.a());
                    f5aVar.x(deleteAllSearchHistory.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                f5aVar.s(true);
                f5a openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    f5aVar.y(openSearchPage.f());
                    f5aVar.u(openSearchPage.b());
                    f5aVar.o(openSearchPage.a());
                    f5aVar.x(openSearchPage.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                f5aVar.s(true);
                f5a searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    f5aVar.y(searchHistoryJson.f());
                    f5aVar.u(searchHistoryJson.b());
                    f5aVar.o(searchHistoryJson.a());
                    f5aVar.x(searchHistoryJson.e());
                }
                f5aVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                f5aVar.s(true);
                f5a searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    f5aVar.y(searchAdCookie.f());
                    f5aVar.u(searchAdCookie.b());
                    f5aVar.o(searchAdCookie.a());
                    f5aVar.x(searchAdCookie.e());
                }
                f5aVar.z(0);
            }
            return f5aVar;
        }
        return (f5a) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public List<f5a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!wi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
