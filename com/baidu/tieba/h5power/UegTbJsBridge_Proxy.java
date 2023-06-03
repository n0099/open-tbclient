package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.ui;
import com.baidu.tieba.uy9;
import com.baidu.tieba.wy9;
import com.baidu.tieba.yy9;
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
public class UegTbJsBridge_Proxy extends uy9 {
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

    @Override // com.baidu.tieba.uy9
    public wy9 dispatch(yy9 yy9Var, wy9 wy9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, yy9Var, wy9Var)) == null) {
            if (wy9Var == null) {
                wy9Var = new wy9();
            }
            String b = yy9Var.b();
            JSONObject e = yy9Var.e();
            if (b.equals("host/callNativeSMS")) {
                wy9Var.s(true);
                wy9 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    wy9Var.y(callNativeSMS.f());
                    wy9Var.u(callNativeSMS.b());
                    wy9Var.o(callNativeSMS.a());
                    wy9Var.x(callNativeSMS.e());
                }
                wy9Var.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                wy9Var.s(true);
                wy9 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    wy9Var.y(blockPopInfo.f());
                    wy9Var.u(blockPopInfo.b());
                    wy9Var.o(blockPopInfo.a());
                    wy9Var.x(blockPopInfo.e());
                }
                wy9Var.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                wy9Var.s(true);
                wy9 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    wy9Var.y(bindingMobileNumber.f());
                    wy9Var.u(bindingMobileNumber.b());
                    wy9Var.o(bindingMobileNumber.a());
                    wy9Var.x(bindingMobileNumber.e());
                }
                wy9Var.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                wy9Var.s(true);
                wy9 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    wy9Var.y(recordNovelInfo.f());
                    wy9Var.u(recordNovelInfo.b());
                    wy9Var.o(recordNovelInfo.a());
                    wy9Var.x(recordNovelInfo.e());
                }
                wy9Var.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                wy9Var.s(true);
                wy9 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    wy9Var.y(novelPayResultToClient.f());
                    wy9Var.u(novelPayResultToClient.b());
                    wy9Var.o(novelPayResultToClient.a());
                    wy9Var.x(novelPayResultToClient.e());
                }
                wy9Var.z(0);
            }
            return wy9Var;
        }
        return (wy9) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.uy9
    public List<wy9> processNotification(WebView webView, String str, HashMap hashMap) {
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
