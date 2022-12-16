package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.at8;
import com.baidu.tieba.ct8;
import com.baidu.tieba.et8;
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
public class UegTbJsBridge_Proxy extends at8 {
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

    @Override // com.baidu.tieba.at8
    public ct8 dispatch(et8 et8Var, ct8 ct8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, et8Var, ct8Var)) == null) {
            if (ct8Var == null) {
                ct8Var = new ct8();
            }
            String b = et8Var.b();
            JSONObject e = et8Var.e();
            if (b.equals("host/callNativeSMS")) {
                ct8Var.r(true);
                ct8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    ct8Var.x(callNativeSMS.f());
                    ct8Var.t(callNativeSMS.b());
                    ct8Var.o(callNativeSMS.a());
                    ct8Var.w(callNativeSMS.e());
                }
                ct8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                ct8Var.r(true);
                ct8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    ct8Var.x(blockPopInfo.f());
                    ct8Var.t(blockPopInfo.b());
                    ct8Var.o(blockPopInfo.a());
                    ct8Var.w(blockPopInfo.e());
                }
                ct8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                ct8Var.r(true);
                ct8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    ct8Var.x(bindingMobileNumber.f());
                    ct8Var.t(bindingMobileNumber.b());
                    ct8Var.o(bindingMobileNumber.a());
                    ct8Var.w(bindingMobileNumber.e());
                }
                ct8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                ct8Var.r(true);
                ct8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    ct8Var.x(recordNovelInfo.f());
                    ct8Var.t(recordNovelInfo.b());
                    ct8Var.o(recordNovelInfo.a());
                    ct8Var.w(recordNovelInfo.e());
                }
                ct8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                ct8Var.r(true);
                ct8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    ct8Var.x(novelPayResultToClient.f());
                    ct8Var.t(novelPayResultToClient.b());
                    ct8Var.o(novelPayResultToClient.a());
                    ct8Var.w(novelPayResultToClient.e());
                }
                ct8Var.y(0);
            }
            return ct8Var;
        }
        return (ct8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.at8
    public List<ct8> processNotification(String str, HashMap hashMap) {
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
