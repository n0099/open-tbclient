package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.bi;
import com.baidu.tieba.ica;
import com.baidu.tieba.kca;
import com.baidu.tieba.mca;
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
public class SearchJsBridge_Proxy extends ica {
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

    @Override // com.baidu.tieba.ica
    public kca dispatch(mca mcaVar, kca kcaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mcaVar, kcaVar)) == null) {
            if (kcaVar == null) {
                kcaVar = new kca();
            }
            String b = mcaVar.b();
            JSONObject e = mcaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                kcaVar.s(true);
                kca deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    kcaVar.y(deleteSearchHistory.f());
                    kcaVar.u(deleteSearchHistory.b());
                    kcaVar.o(deleteSearchHistory.a());
                    kcaVar.x(deleteSearchHistory.e());
                }
                kcaVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                kcaVar.s(true);
                kca deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    kcaVar.y(deleteAllSearchHistory.f());
                    kcaVar.u(deleteAllSearchHistory.b());
                    kcaVar.o(deleteAllSearchHistory.a());
                    kcaVar.x(deleteAllSearchHistory.e());
                }
                kcaVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                kcaVar.s(true);
                kca openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    kcaVar.y(openSearchPage.f());
                    kcaVar.u(openSearchPage.b());
                    kcaVar.o(openSearchPage.a());
                    kcaVar.x(openSearchPage.e());
                }
                kcaVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                kcaVar.s(true);
                kca searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    kcaVar.y(searchHistoryJson.f());
                    kcaVar.u(searchHistoryJson.b());
                    kcaVar.o(searchHistoryJson.a());
                    kcaVar.x(searchHistoryJson.e());
                }
                kcaVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                kcaVar.s(true);
                kca searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    kcaVar.y(searchAdCookie.f());
                    kcaVar.u(searchAdCookie.b());
                    kcaVar.o(searchAdCookie.a());
                    kcaVar.x(searchAdCookie.e());
                }
                kcaVar.z(0);
            }
            return kcaVar;
        }
        return (kca) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ica
    public List<kca> processNotification(WebView webView, String str, HashMap hashMap) {
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
