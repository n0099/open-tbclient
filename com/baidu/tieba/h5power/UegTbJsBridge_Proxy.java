package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tieba.am8;
import com.baidu.tieba.qi;
import com.baidu.tieba.wl8;
import com.baidu.tieba.yl8;
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
public class UegTbJsBridge_Proxy extends wl8 {
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

    @Override // com.baidu.tieba.wl8
    public yl8 dispatch(am8 am8Var, yl8 yl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, am8Var, yl8Var)) == null) {
            if (yl8Var == null) {
                yl8Var = new yl8();
            }
            String b = am8Var.b();
            JSONObject e = am8Var.e();
            if (b.equals("host/callNativeSMS")) {
                yl8Var.r(true);
                yl8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    yl8Var.x(callNativeSMS.f());
                    yl8Var.t(callNativeSMS.b());
                    yl8Var.o(callNativeSMS.a());
                    yl8Var.w(callNativeSMS.e());
                }
                yl8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                yl8Var.r(true);
                yl8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    yl8Var.x(blockPopInfo.f());
                    yl8Var.t(blockPopInfo.b());
                    yl8Var.o(blockPopInfo.a());
                    yl8Var.w(blockPopInfo.e());
                }
                yl8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                yl8Var.r(true);
                yl8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    yl8Var.x(bindingMobileNumber.f());
                    yl8Var.t(bindingMobileNumber.b());
                    yl8Var.o(bindingMobileNumber.a());
                    yl8Var.w(bindingMobileNumber.e());
                }
                yl8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                yl8Var.r(true);
                yl8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString("gid"), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    yl8Var.x(recordNovelInfo.f());
                    yl8Var.t(recordNovelInfo.b());
                    yl8Var.o(recordNovelInfo.a());
                    yl8Var.w(recordNovelInfo.e());
                }
                yl8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                yl8Var.r(true);
                yl8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    yl8Var.x(novelPayResultToClient.f());
                    yl8Var.t(novelPayResultToClient.b());
                    yl8Var.o(novelPayResultToClient.a());
                    yl8Var.w(novelPayResultToClient.e());
                }
                yl8Var.y(0);
            }
            return yl8Var;
        }
        return (yl8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.wl8
    public List<yl8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (qi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
