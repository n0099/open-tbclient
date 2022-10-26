package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.ej;
import com.baidu.tieba.go8;
import com.baidu.tieba.io8;
import com.baidu.tieba.ko8;
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
public class UegTbJsBridge_Proxy extends go8 {
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
        this.mNotificationNameList = new HashSet();
    }

    @Override // com.baidu.tieba.go8
    public io8 dispatch(ko8 ko8Var, io8 io8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ko8Var, io8Var)) == null) {
            if (io8Var == null) {
                io8Var = new io8();
            }
            String b = ko8Var.b();
            JSONObject e = ko8Var.e();
            if (b.equals("host/callNativeSMS")) {
                io8Var.r(true);
                io8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    io8Var.x(callNativeSMS.f());
                    io8Var.t(callNativeSMS.b());
                    io8Var.o(callNativeSMS.a());
                    io8Var.w(callNativeSMS.e());
                }
                io8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                io8Var.r(true);
                io8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    io8Var.x(blockPopInfo.f());
                    io8Var.t(blockPopInfo.b());
                    io8Var.o(blockPopInfo.a());
                    io8Var.w(blockPopInfo.e());
                }
                io8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                io8Var.r(true);
                io8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    io8Var.x(bindingMobileNumber.f());
                    io8Var.t(bindingMobileNumber.b());
                    io8Var.o(bindingMobileNumber.a());
                    io8Var.w(bindingMobileNumber.e());
                }
                io8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                io8Var.r(true);
                io8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    io8Var.x(recordNovelInfo.f());
                    io8Var.t(recordNovelInfo.b());
                    io8Var.o(recordNovelInfo.a());
                    io8Var.w(recordNovelInfo.e());
                }
                io8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                io8Var.r(true);
                io8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    io8Var.x(novelPayResultToClient.f());
                    io8Var.t(novelPayResultToClient.b());
                    io8Var.o(novelPayResultToClient.a());
                    io8Var.w(novelPayResultToClient.e());
                }
                io8Var.y(0);
            }
            return io8Var;
        }
        return (io8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.go8
    public List processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (!ej.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                List list = (List) this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }
}
