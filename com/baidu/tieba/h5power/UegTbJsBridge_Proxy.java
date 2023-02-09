package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.b39;
import com.baidu.tieba.d39;
import com.baidu.tieba.dj;
import com.baidu.tieba.z29;
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
public class UegTbJsBridge_Proxy extends z29 {
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

    @Override // com.baidu.tieba.z29
    public b39 dispatch(d39 d39Var, b39 b39Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, d39Var, b39Var)) == null) {
            if (b39Var == null) {
                b39Var = new b39();
            }
            String b = d39Var.b();
            JSONObject e = d39Var.e();
            if (b.equals("host/callNativeSMS")) {
                b39Var.r(true);
                b39 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    b39Var.x(callNativeSMS.f());
                    b39Var.t(callNativeSMS.b());
                    b39Var.o(callNativeSMS.a());
                    b39Var.w(callNativeSMS.e());
                }
                b39Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                b39Var.r(true);
                b39 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    b39Var.x(blockPopInfo.f());
                    b39Var.t(blockPopInfo.b());
                    b39Var.o(blockPopInfo.a());
                    b39Var.w(blockPopInfo.e());
                }
                b39Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                b39Var.r(true);
                b39 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    b39Var.x(bindingMobileNumber.f());
                    b39Var.t(bindingMobileNumber.b());
                    b39Var.o(bindingMobileNumber.a());
                    b39Var.w(bindingMobileNumber.e());
                }
                b39Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                b39Var.r(true);
                b39 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    b39Var.x(recordNovelInfo.f());
                    b39Var.t(recordNovelInfo.b());
                    b39Var.o(recordNovelInfo.a());
                    b39Var.w(recordNovelInfo.e());
                }
                b39Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                b39Var.r(true);
                b39 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    b39Var.x(novelPayResultToClient.f());
                    b39Var.t(novelPayResultToClient.b());
                    b39Var.o(novelPayResultToClient.a());
                    b39Var.w(novelPayResultToClient.e());
                }
                b39Var.y(0);
            }
            return b39Var;
        }
        return (b39) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.z29
    public List<b39> processNotification(WebView webView, String str, HashMap hashMap) {
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
