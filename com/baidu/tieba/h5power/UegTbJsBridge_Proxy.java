package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.dj;
import com.baidu.tieba.v19;
import com.baidu.tieba.x19;
import com.baidu.tieba.z19;
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
/* loaded from: classes4.dex */
public class UegTbJsBridge_Proxy extends v19 {
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

    @Override // com.baidu.tieba.v19
    public x19 dispatch(z19 z19Var, x19 x19Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, z19Var, x19Var)) == null) {
            if (x19Var == null) {
                x19Var = new x19();
            }
            String b = z19Var.b();
            JSONObject e = z19Var.e();
            if (b.equals("host/callNativeSMS")) {
                x19Var.r(true);
                x19 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    x19Var.x(callNativeSMS.f());
                    x19Var.t(callNativeSMS.b());
                    x19Var.o(callNativeSMS.a());
                    x19Var.w(callNativeSMS.e());
                }
                x19Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                x19Var.r(true);
                x19 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    x19Var.x(blockPopInfo.f());
                    x19Var.t(blockPopInfo.b());
                    x19Var.o(blockPopInfo.a());
                    x19Var.w(blockPopInfo.e());
                }
                x19Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                x19Var.r(true);
                x19 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    x19Var.x(bindingMobileNumber.f());
                    x19Var.t(bindingMobileNumber.b());
                    x19Var.o(bindingMobileNumber.a());
                    x19Var.w(bindingMobileNumber.e());
                }
                x19Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                x19Var.r(true);
                x19 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    x19Var.x(recordNovelInfo.f());
                    x19Var.t(recordNovelInfo.b());
                    x19Var.o(recordNovelInfo.a());
                    x19Var.w(recordNovelInfo.e());
                }
                x19Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                x19Var.r(true);
                x19 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    x19Var.x(novelPayResultToClient.f());
                    x19Var.t(novelPayResultToClient.b());
                    x19Var.o(novelPayResultToClient.a());
                    x19Var.w(novelPayResultToClient.e());
                }
                x19Var.y(0);
            }
            return x19Var;
        }
        return (x19) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.v19
    public List<x19> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!dj.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
