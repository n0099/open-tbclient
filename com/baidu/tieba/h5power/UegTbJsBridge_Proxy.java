package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.hs9;
import com.baidu.tieba.js9;
import com.baidu.tieba.ls9;
import com.baidu.tieba.qi;
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
/* loaded from: classes5.dex */
public class UegTbJsBridge_Proxy extends hs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public UegTbJsBridge mJsBridge;

    public UegTbJsBridge_Proxy(UegTbJsBridge uegTbJsBridge) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uegTbJsBridge};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = uegTbJsBridge;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.hs9
    public js9 dispatch(ls9 ls9Var, js9 js9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ls9Var, js9Var)) == null) {
            if (js9Var == null) {
                js9Var = new js9();
            }
            String b = ls9Var.b();
            JSONObject e = ls9Var.e();
            if (b.equals("host/callNativeSMS")) {
                js9Var.s(true);
                js9 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    js9Var.y(callNativeSMS.f());
                    js9Var.u(callNativeSMS.b());
                    js9Var.o(callNativeSMS.a());
                    js9Var.x(callNativeSMS.e());
                }
                js9Var.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                js9Var.s(true);
                js9 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    js9Var.y(blockPopInfo.f());
                    js9Var.u(blockPopInfo.b());
                    js9Var.o(blockPopInfo.a());
                    js9Var.x(blockPopInfo.e());
                }
                js9Var.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                js9Var.s(true);
                js9 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    js9Var.y(bindingMobileNumber.f());
                    js9Var.u(bindingMobileNumber.b());
                    js9Var.o(bindingMobileNumber.a());
                    js9Var.x(bindingMobileNumber.e());
                }
                js9Var.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                js9Var.s(true);
                js9 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    js9Var.y(recordNovelInfo.f());
                    js9Var.u(recordNovelInfo.b());
                    js9Var.o(recordNovelInfo.a());
                    js9Var.x(recordNovelInfo.e());
                }
                js9Var.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                js9Var.s(true);
                js9 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    js9Var.y(novelPayResultToClient.f());
                    js9Var.u(novelPayResultToClient.b());
                    js9Var.o(novelPayResultToClient.a());
                    js9Var.x(novelPayResultToClient.e());
                }
                js9Var.z(0);
            }
            return js9Var;
        }
        return (js9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public List<js9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!qi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
