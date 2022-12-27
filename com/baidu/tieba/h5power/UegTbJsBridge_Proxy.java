package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.bt8;
import com.baidu.tieba.dt8;
import com.baidu.tieba.ft8;
import com.baidu.tieba.xi;
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
public class UegTbJsBridge_Proxy extends bt8 {
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

    @Override // com.baidu.tieba.bt8
    public dt8 dispatch(ft8 ft8Var, dt8 dt8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ft8Var, dt8Var)) == null) {
            if (dt8Var == null) {
                dt8Var = new dt8();
            }
            String b = ft8Var.b();
            JSONObject e = ft8Var.e();
            if (b.equals("host/callNativeSMS")) {
                dt8Var.r(true);
                dt8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    dt8Var.x(callNativeSMS.f());
                    dt8Var.t(callNativeSMS.b());
                    dt8Var.o(callNativeSMS.a());
                    dt8Var.w(callNativeSMS.e());
                }
                dt8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                dt8Var.r(true);
                dt8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    dt8Var.x(blockPopInfo.f());
                    dt8Var.t(blockPopInfo.b());
                    dt8Var.o(blockPopInfo.a());
                    dt8Var.w(blockPopInfo.e());
                }
                dt8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                dt8Var.r(true);
                dt8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    dt8Var.x(bindingMobileNumber.f());
                    dt8Var.t(bindingMobileNumber.b());
                    dt8Var.o(bindingMobileNumber.a());
                    dt8Var.w(bindingMobileNumber.e());
                }
                dt8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                dt8Var.r(true);
                dt8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    dt8Var.x(recordNovelInfo.f());
                    dt8Var.t(recordNovelInfo.b());
                    dt8Var.o(recordNovelInfo.a());
                    dt8Var.w(recordNovelInfo.e());
                }
                dt8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                dt8Var.r(true);
                dt8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    dt8Var.x(novelPayResultToClient.f());
                    dt8Var.t(novelPayResultToClient.b());
                    dt8Var.o(novelPayResultToClient.a());
                    dt8Var.w(novelPayResultToClient.e());
                }
                dt8Var.y(0);
            }
            return dt8Var;
        }
        return (dt8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.bt8
    public List<dt8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (!xi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }
}
