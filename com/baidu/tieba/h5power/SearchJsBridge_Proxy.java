package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.oda;
import com.baidu.tieba.qda;
import com.baidu.tieba.sda;
import com.baidu.tieba.xi;
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
public class SearchJsBridge_Proxy extends oda {
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

    @Override // com.baidu.tieba.oda
    public qda dispatch(sda sdaVar, qda qdaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sdaVar, qdaVar)) == null) {
            if (qdaVar == null) {
                qdaVar = new qda();
            }
            String b = sdaVar.b();
            JSONObject e = sdaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                qdaVar.s(true);
                qda deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    qdaVar.y(deleteSearchHistory.f());
                    qdaVar.u(deleteSearchHistory.b());
                    qdaVar.o(deleteSearchHistory.a());
                    qdaVar.x(deleteSearchHistory.e());
                }
                qdaVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                qdaVar.s(true);
                qda deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    qdaVar.y(deleteAllSearchHistory.f());
                    qdaVar.u(deleteAllSearchHistory.b());
                    qdaVar.o(deleteAllSearchHistory.a());
                    qdaVar.x(deleteAllSearchHistory.e());
                }
                qdaVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                qdaVar.s(true);
                qda openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    qdaVar.y(openSearchPage.f());
                    qdaVar.u(openSearchPage.b());
                    qdaVar.o(openSearchPage.a());
                    qdaVar.x(openSearchPage.e());
                }
                qdaVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                qdaVar.s(true);
                qda searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    qdaVar.y(searchHistoryJson.f());
                    qdaVar.u(searchHistoryJson.b());
                    qdaVar.o(searchHistoryJson.a());
                    qdaVar.x(searchHistoryJson.e());
                }
                qdaVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                qdaVar.s(true);
                qda searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    qdaVar.y(searchAdCookie.f());
                    qdaVar.u(searchAdCookie.b());
                    qdaVar.o(searchAdCookie.a());
                    qdaVar.x(searchAdCookie.e());
                }
                qdaVar.z(0);
            }
            return qdaVar;
        }
        return (qda) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.oda
    public List<qda> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!xi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
