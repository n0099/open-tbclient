package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.az9;
import com.baidu.tieba.bz9;
import com.baidu.tieba.dz9;
import com.baidu.tieba.sy4;
import com.baidu.tieba.ul6;
import com.baidu.tieba.zy9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ShareJsBridgePlugin_Proxy extends zy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sy4 mJsBridge;

    public ShareJsBridgePlugin_Proxy(sy4 sy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = sy4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
    }

    @Override // com.baidu.tieba.zy9
    public bz9 dispatch(WebView webView, dz9 dz9Var, bz9 bz9Var) {
        InterceptResult invokeLLL;
        bz9 bz9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, dz9Var, bz9Var)) == null) {
            if (bz9Var == null) {
                bz9Var2 = new bz9();
            } else {
                bz9Var2 = bz9Var;
            }
            String b = dz9Var.b();
            JSONObject e = dz9Var.e();
            if (b.equals("share/registerShareDataNew")) {
                bz9Var2.s(true);
                bz9 d = this.mJsBridge.d(webView, e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (d != null) {
                    bz9Var2.y(d.f());
                    bz9Var2.u(d.b());
                    bz9Var2.o(d.a());
                    bz9Var2.x(d.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("share/share")) {
                bz9Var2.s(true);
                bz9 f = this.mJsBridge.f(webView, e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (f != null) {
                    bz9Var2.y(f.f());
                    bz9Var2.u(f.b());
                    bz9Var2.o(f.a());
                    bz9Var2.x(f.e());
                    if (!bz9Var2.h()) {
                        bz9Var2.n(false);
                        addObserver(webView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, bz9Var2, false);
                    }
                }
                bz9Var2.z(0);
            }
            return bz9Var2;
        }
        return (bz9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public ul6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (ul6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public List<bz9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            bz9 bz9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                bz9Var = this.mJsBridge.h(webView, hashMap);
            }
            if (bz9Var != null) {
                bz9Var.z(0);
            }
            List<az9> list = this.mAsyncCallBackMethodList.get(str);
            if (bz9Var != null && list != null) {
                Iterator<az9> it = list.iterator();
                if (!TextUtils.isEmpty(bz9Var.e())) {
                    while (it.hasNext()) {
                        az9 next = it.next();
                        if (next.b().equals(bz9Var.e())) {
                            bz9 bz9Var2 = new bz9();
                            bz9Var2.w(next.a());
                            bz9Var2.y(bz9Var.f());
                            bz9Var2.u(bz9Var.b());
                            bz9Var2.o(bz9Var.a());
                            bz9Var2.A(bz9Var.l());
                            arrayList.add(bz9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        az9 next2 = it.next();
                        bz9 bz9Var3 = new bz9();
                        bz9Var3.w(next2.a());
                        bz9Var3.y(bz9Var.f());
                        bz9Var3.u(bz9Var.b());
                        bz9Var3.o(bz9Var.a());
                        bz9Var3.A(bz9Var.l());
                        arrayList.add(bz9Var3);
                        if (!next2.c()) {
                            it.remove();
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
