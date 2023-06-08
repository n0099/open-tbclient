package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.bz9;
import com.baidu.tieba.dz9;
import com.baidu.tieba.ui;
import com.baidu.tieba.zy9;
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
public class UegTbJsBridge_Proxy extends zy9 {
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

    @Override // com.baidu.tieba.zy9
    public bz9 dispatch(dz9 dz9Var, bz9 bz9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dz9Var, bz9Var)) == null) {
            if (bz9Var == null) {
                bz9Var = new bz9();
            }
            String b = dz9Var.b();
            JSONObject e = dz9Var.e();
            if (b.equals("host/callNativeSMS")) {
                bz9Var.s(true);
                bz9 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    bz9Var.y(callNativeSMS.f());
                    bz9Var.u(callNativeSMS.b());
                    bz9Var.o(callNativeSMS.a());
                    bz9Var.x(callNativeSMS.e());
                }
                bz9Var.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                bz9Var.s(true);
                bz9 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    bz9Var.y(blockPopInfo.f());
                    bz9Var.u(blockPopInfo.b());
                    bz9Var.o(blockPopInfo.a());
                    bz9Var.x(blockPopInfo.e());
                }
                bz9Var.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                bz9Var.s(true);
                bz9 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    bz9Var.y(bindingMobileNumber.f());
                    bz9Var.u(bindingMobileNumber.b());
                    bz9Var.o(bindingMobileNumber.a());
                    bz9Var.x(bindingMobileNumber.e());
                }
                bz9Var.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                bz9Var.s(true);
                bz9 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    bz9Var.y(recordNovelInfo.f());
                    bz9Var.u(recordNovelInfo.b());
                    bz9Var.o(recordNovelInfo.a());
                    bz9Var.x(recordNovelInfo.e());
                }
                bz9Var.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                bz9Var.s(true);
                bz9 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    bz9Var.y(novelPayResultToClient.f());
                    bz9Var.u(novelPayResultToClient.b());
                    bz9Var.o(novelPayResultToClient.a());
                    bz9Var.x(novelPayResultToClient.e());
                }
                bz9Var.z(0);
            }
            return bz9Var;
        }
        return (bz9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public List<bz9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!ui.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
