package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.pp8;
import com.baidu.tieba.rp8;
import com.baidu.tieba.tp8;
import com.baidu.tieba.wi;
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
public class UegTbJsBridge_Proxy extends pp8 {
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

    @Override // com.baidu.tieba.pp8
    public rp8 dispatch(tp8 tp8Var, rp8 rp8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tp8Var, rp8Var)) == null) {
            if (rp8Var == null) {
                rp8Var = new rp8();
            }
            String b = tp8Var.b();
            JSONObject e = tp8Var.e();
            if (b.equals("host/callNativeSMS")) {
                rp8Var.r(true);
                rp8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    rp8Var.x(callNativeSMS.f());
                    rp8Var.t(callNativeSMS.b());
                    rp8Var.o(callNativeSMS.a());
                    rp8Var.w(callNativeSMS.e());
                }
                rp8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                rp8Var.r(true);
                rp8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    rp8Var.x(blockPopInfo.f());
                    rp8Var.t(blockPopInfo.b());
                    rp8Var.o(blockPopInfo.a());
                    rp8Var.w(blockPopInfo.e());
                }
                rp8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                rp8Var.r(true);
                rp8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    rp8Var.x(bindingMobileNumber.f());
                    rp8Var.t(bindingMobileNumber.b());
                    rp8Var.o(bindingMobileNumber.a());
                    rp8Var.w(bindingMobileNumber.e());
                }
                rp8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                rp8Var.r(true);
                rp8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    rp8Var.x(recordNovelInfo.f());
                    rp8Var.t(recordNovelInfo.b());
                    rp8Var.o(recordNovelInfo.a());
                    rp8Var.w(recordNovelInfo.e());
                }
                rp8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                rp8Var.r(true);
                rp8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    rp8Var.x(novelPayResultToClient.f());
                    rp8Var.t(novelPayResultToClient.b());
                    rp8Var.o(novelPayResultToClient.a());
                    rp8Var.w(novelPayResultToClient.e());
                }
                rp8Var.y(0);
            }
            return rp8Var;
        }
        return (rp8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.pp8
    public List<rp8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (!wi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }
}
