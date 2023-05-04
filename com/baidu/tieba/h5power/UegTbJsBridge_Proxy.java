package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.fq9;
import com.baidu.tieba.hi;
import com.baidu.tieba.hq9;
import com.baidu.tieba.jq9;
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
public class UegTbJsBridge_Proxy extends fq9 {
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

    @Override // com.baidu.tieba.fq9
    public hq9 dispatch(jq9 jq9Var, hq9 hq9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jq9Var, hq9Var)) == null) {
            if (hq9Var == null) {
                hq9Var = new hq9();
            }
            String b = jq9Var.b();
            JSONObject e = jq9Var.e();
            if (b.equals("host/callNativeSMS")) {
                hq9Var.s(true);
                hq9 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    hq9Var.y(callNativeSMS.f());
                    hq9Var.u(callNativeSMS.b());
                    hq9Var.o(callNativeSMS.a());
                    hq9Var.x(callNativeSMS.e());
                }
                hq9Var.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                hq9Var.s(true);
                hq9 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    hq9Var.y(blockPopInfo.f());
                    hq9Var.u(blockPopInfo.b());
                    hq9Var.o(blockPopInfo.a());
                    hq9Var.x(blockPopInfo.e());
                }
                hq9Var.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                hq9Var.s(true);
                hq9 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    hq9Var.y(bindingMobileNumber.f());
                    hq9Var.u(bindingMobileNumber.b());
                    hq9Var.o(bindingMobileNumber.a());
                    hq9Var.x(bindingMobileNumber.e());
                }
                hq9Var.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                hq9Var.s(true);
                hq9 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    hq9Var.y(recordNovelInfo.f());
                    hq9Var.u(recordNovelInfo.b());
                    hq9Var.o(recordNovelInfo.a());
                    hq9Var.x(recordNovelInfo.e());
                }
                hq9Var.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                hq9Var.s(true);
                hq9 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    hq9Var.y(novelPayResultToClient.f());
                    hq9Var.u(novelPayResultToClient.b());
                    hq9Var.o(novelPayResultToClient.a());
                    hq9Var.x(novelPayResultToClient.e());
                }
                hq9Var.z(0);
            }
            return hq9Var;
        }
        return (hq9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public List<hq9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!hi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
