package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.aq8;
import com.baidu.tieba.cq8;
import com.baidu.tieba.eq8;
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
public class UegTbJsBridge_Proxy extends aq8 {
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

    @Override // com.baidu.tieba.aq8
    public cq8 dispatch(eq8 eq8Var, cq8 cq8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eq8Var, cq8Var)) == null) {
            if (cq8Var == null) {
                cq8Var = new cq8();
            }
            String b = eq8Var.b();
            JSONObject e = eq8Var.e();
            if (b.equals("host/callNativeSMS")) {
                cq8Var.r(true);
                cq8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    cq8Var.x(callNativeSMS.f());
                    cq8Var.t(callNativeSMS.b());
                    cq8Var.o(callNativeSMS.a());
                    cq8Var.w(callNativeSMS.e());
                }
                cq8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                cq8Var.r(true);
                cq8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    cq8Var.x(blockPopInfo.f());
                    cq8Var.t(blockPopInfo.b());
                    cq8Var.o(blockPopInfo.a());
                    cq8Var.w(blockPopInfo.e());
                }
                cq8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                cq8Var.r(true);
                cq8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    cq8Var.x(bindingMobileNumber.f());
                    cq8Var.t(bindingMobileNumber.b());
                    cq8Var.o(bindingMobileNumber.a());
                    cq8Var.w(bindingMobileNumber.e());
                }
                cq8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                cq8Var.r(true);
                cq8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    cq8Var.x(recordNovelInfo.f());
                    cq8Var.t(recordNovelInfo.b());
                    cq8Var.o(recordNovelInfo.a());
                    cq8Var.w(recordNovelInfo.e());
                }
                cq8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                cq8Var.r(true);
                cq8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    cq8Var.x(novelPayResultToClient.f());
                    cq8Var.t(novelPayResultToClient.b());
                    cq8Var.o(novelPayResultToClient.a());
                    cq8Var.w(novelPayResultToClient.e());
                }
                cq8Var.y(0);
            }
            return cq8Var;
        }
        return (cq8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.aq8
    public List<cq8> processNotification(String str, HashMap hashMap) {
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
