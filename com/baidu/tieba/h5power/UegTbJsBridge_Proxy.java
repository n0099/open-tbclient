package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.by8;
import com.baidu.tieba.xx8;
import com.baidu.tieba.yi;
import com.baidu.tieba.zx8;
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
public class UegTbJsBridge_Proxy extends xx8 {
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

    @Override // com.baidu.tieba.xx8
    public zx8 dispatch(by8 by8Var, zx8 zx8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, by8Var, zx8Var)) == null) {
            if (zx8Var == null) {
                zx8Var = new zx8();
            }
            String b = by8Var.b();
            JSONObject e = by8Var.e();
            if (b.equals("host/callNativeSMS")) {
                zx8Var.r(true);
                zx8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    zx8Var.x(callNativeSMS.f());
                    zx8Var.t(callNativeSMS.b());
                    zx8Var.o(callNativeSMS.a());
                    zx8Var.w(callNativeSMS.e());
                }
                zx8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                zx8Var.r(true);
                zx8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    zx8Var.x(blockPopInfo.f());
                    zx8Var.t(blockPopInfo.b());
                    zx8Var.o(blockPopInfo.a());
                    zx8Var.w(blockPopInfo.e());
                }
                zx8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                zx8Var.r(true);
                zx8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    zx8Var.x(bindingMobileNumber.f());
                    zx8Var.t(bindingMobileNumber.b());
                    zx8Var.o(bindingMobileNumber.a());
                    zx8Var.w(bindingMobileNumber.e());
                }
                zx8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                zx8Var.r(true);
                zx8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    zx8Var.x(recordNovelInfo.f());
                    zx8Var.t(recordNovelInfo.b());
                    zx8Var.o(recordNovelInfo.a());
                    zx8Var.w(recordNovelInfo.e());
                }
                zx8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                zx8Var.r(true);
                zx8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    zx8Var.x(novelPayResultToClient.f());
                    zx8Var.t(novelPayResultToClient.b());
                    zx8Var.o(novelPayResultToClient.a());
                    zx8Var.w(novelPayResultToClient.e());
                }
                zx8Var.y(0);
            }
            return zx8Var;
        }
        return (zx8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.xx8
    public List<zx8> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!yi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
