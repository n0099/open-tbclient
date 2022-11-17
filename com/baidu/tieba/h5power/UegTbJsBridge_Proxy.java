package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.bq8;
import com.baidu.tieba.dq8;
import com.baidu.tieba.fq8;
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
public class UegTbJsBridge_Proxy extends bq8 {
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

    @Override // com.baidu.tieba.bq8
    public dq8 dispatch(fq8 fq8Var, dq8 dq8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fq8Var, dq8Var)) == null) {
            if (dq8Var == null) {
                dq8Var = new dq8();
            }
            String b = fq8Var.b();
            JSONObject e = fq8Var.e();
            if (b.equals("host/callNativeSMS")) {
                dq8Var.r(true);
                dq8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    dq8Var.x(callNativeSMS.f());
                    dq8Var.t(callNativeSMS.b());
                    dq8Var.o(callNativeSMS.a());
                    dq8Var.w(callNativeSMS.e());
                }
                dq8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                dq8Var.r(true);
                dq8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    dq8Var.x(blockPopInfo.f());
                    dq8Var.t(blockPopInfo.b());
                    dq8Var.o(blockPopInfo.a());
                    dq8Var.w(blockPopInfo.e());
                }
                dq8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                dq8Var.r(true);
                dq8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    dq8Var.x(bindingMobileNumber.f());
                    dq8Var.t(bindingMobileNumber.b());
                    dq8Var.o(bindingMobileNumber.a());
                    dq8Var.w(bindingMobileNumber.e());
                }
                dq8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                dq8Var.r(true);
                dq8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    dq8Var.x(recordNovelInfo.f());
                    dq8Var.t(recordNovelInfo.b());
                    dq8Var.o(recordNovelInfo.a());
                    dq8Var.w(recordNovelInfo.e());
                }
                dq8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                dq8Var.r(true);
                dq8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    dq8Var.x(novelPayResultToClient.f());
                    dq8Var.t(novelPayResultToClient.b());
                    dq8Var.o(novelPayResultToClient.a());
                    dq8Var.w(novelPayResultToClient.e());
                }
                dq8Var.y(0);
            }
            return dq8Var;
        }
        return (dq8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.bq8
    public List<dq8> processNotification(String str, HashMap hashMap) {
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
