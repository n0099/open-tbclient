package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.r0a;
import com.baidu.tieba.t0a;
import com.baidu.tieba.v0a;
import com.baidu.tieba.vi;
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
public class SearchJsBridge_Proxy extends r0a {
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

    @Override // com.baidu.tieba.r0a
    public t0a dispatch(v0a v0aVar, t0a t0aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, v0aVar, t0aVar)) == null) {
            if (t0aVar == null) {
                t0aVar = new t0a();
            }
            String b = v0aVar.b();
            JSONObject e = v0aVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                t0aVar.s(true);
                t0a deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    t0aVar.y(deleteSearchHistory.f());
                    t0aVar.u(deleteSearchHistory.b());
                    t0aVar.o(deleteSearchHistory.a());
                    t0aVar.x(deleteSearchHistory.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                t0aVar.s(true);
                t0a deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    t0aVar.y(deleteAllSearchHistory.f());
                    t0aVar.u(deleteAllSearchHistory.b());
                    t0aVar.o(deleteAllSearchHistory.a());
                    t0aVar.x(deleteAllSearchHistory.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                t0aVar.s(true);
                t0a openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    t0aVar.y(openSearchPage.f());
                    t0aVar.u(openSearchPage.b());
                    t0aVar.o(openSearchPage.a());
                    t0aVar.x(openSearchPage.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                t0aVar.s(true);
                t0a searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    t0aVar.y(searchHistoryJson.f());
                    t0aVar.u(searchHistoryJson.b());
                    t0aVar.o(searchHistoryJson.a());
                    t0aVar.x(searchHistoryJson.e());
                }
                t0aVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                t0aVar.s(true);
                t0a searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    t0aVar.y(searchAdCookie.f());
                    t0aVar.u(searchAdCookie.b());
                    t0aVar.o(searchAdCookie.a());
                    t0aVar.x(searchAdCookie.e());
                }
                t0aVar.z(0);
            }
            return t0aVar;
        }
        return (t0a) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public List<t0a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!vi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
