package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.ei;
import com.baidu.tieba.kia;
import com.baidu.tieba.mia;
import com.baidu.tieba.oia;
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
public class SearchJsBridge_Proxy extends kia {
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

    @Override // com.baidu.tieba.kia
    public mia dispatch(oia oiaVar, mia miaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, oiaVar, miaVar)) == null) {
            if (miaVar == null) {
                miaVar = new mia();
            }
            String b = oiaVar.b();
            JSONObject e = oiaVar.e();
            if (b.equals("hybrid/deleteSearchHistory")) {
                miaVar.s(true);
                mia deleteSearchHistory = this.mJsBridge.deleteSearchHistory(e.optString("query"));
                if (deleteSearchHistory != null) {
                    miaVar.y(deleteSearchHistory.f());
                    miaVar.u(deleteSearchHistory.b());
                    miaVar.o(deleteSearchHistory.a());
                    miaVar.x(deleteSearchHistory.e());
                }
                miaVar.z(0);
            } else if (b.equals("hybrid/deleteAllSearchHistory")) {
                miaVar.s(true);
                mia deleteAllSearchHistory = this.mJsBridge.deleteAllSearchHistory();
                if (deleteAllSearchHistory != null) {
                    miaVar.y(deleteAllSearchHistory.f());
                    miaVar.u(deleteAllSearchHistory.b());
                    miaVar.o(deleteAllSearchHistory.a());
                    miaVar.x(deleteAllSearchHistory.e());
                }
                miaVar.z(0);
            } else if (b.equals("hybrid/openSearchPage")) {
                miaVar.s(true);
                mia openSearchPage = this.mJsBridge.openSearchPage(e.optString("query"), e.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY));
                if (openSearchPage != null) {
                    miaVar.y(openSearchPage.f());
                    miaVar.u(openSearchPage.b());
                    miaVar.o(openSearchPage.a());
                    miaVar.x(openSearchPage.e());
                }
                miaVar.z(0);
            } else if (b.equals("hybrid/getSearchHistory")) {
                miaVar.s(true);
                mia searchHistoryJson = this.mJsBridge.getSearchHistoryJson();
                if (searchHistoryJson != null) {
                    miaVar.y(searchHistoryJson.f());
                    miaVar.u(searchHistoryJson.b());
                    miaVar.o(searchHistoryJson.a());
                    miaVar.x(searchHistoryJson.e());
                }
                miaVar.z(0);
            } else if (b.equals("hybrid/getSearchAdCookie")) {
                miaVar.s(true);
                mia searchAdCookie = this.mJsBridge.getSearchAdCookie();
                if (searchAdCookie != null) {
                    miaVar.y(searchAdCookie.f());
                    miaVar.u(searchAdCookie.b());
                    miaVar.o(searchAdCookie.a());
                    miaVar.x(searchAdCookie.e());
                }
                miaVar.z(0);
            }
            return miaVar;
        }
        return (mia) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.kia
    public List<mia> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!ei.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
