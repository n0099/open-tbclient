package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.is9;
import com.baidu.tieba.ks9;
import com.baidu.tieba.ms9;
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
public class UegTbJsBridge_Proxy extends is9 {
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

    @Override // com.baidu.tieba.is9
    public ks9 dispatch(ms9 ms9Var, ks9 ks9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ms9Var, ks9Var)) == null) {
            if (ks9Var == null) {
                ks9Var = new ks9();
            }
            String b = ms9Var.b();
            JSONObject e = ms9Var.e();
            if (b.equals("host/callNativeSMS")) {
                ks9Var.s(true);
                ks9 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    ks9Var.y(callNativeSMS.f());
                    ks9Var.u(callNativeSMS.b());
                    ks9Var.o(callNativeSMS.a());
                    ks9Var.x(callNativeSMS.e());
                }
                ks9Var.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                ks9Var.s(true);
                ks9 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    ks9Var.y(blockPopInfo.f());
                    ks9Var.u(blockPopInfo.b());
                    ks9Var.o(blockPopInfo.a());
                    ks9Var.x(blockPopInfo.e());
                }
                ks9Var.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                ks9Var.s(true);
                ks9 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    ks9Var.y(bindingMobileNumber.f());
                    ks9Var.u(bindingMobileNumber.b());
                    ks9Var.o(bindingMobileNumber.a());
                    ks9Var.x(bindingMobileNumber.e());
                }
                ks9Var.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                ks9Var.s(true);
                ks9 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    ks9Var.y(recordNovelInfo.f());
                    ks9Var.u(recordNovelInfo.b());
                    ks9Var.o(recordNovelInfo.a());
                    ks9Var.x(recordNovelInfo.e());
                }
                ks9Var.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                ks9Var.s(true);
                ks9 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    ks9Var.y(novelPayResultToClient.f());
                    ks9Var.u(novelPayResultToClient.b());
                    ks9Var.o(novelPayResultToClient.a());
                    ks9Var.x(novelPayResultToClient.e());
                }
                ks9Var.z(0);
            }
            return ks9Var;
        }
        return (ks9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.is9
    public List<ks9> processNotification(WebView webView, String str, HashMap hashMap) {
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
