package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fj8;
import com.repackage.hj8;
import com.repackage.jj8;
import com.repackage.oi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UegTbJsBridge_Proxy extends fj8 {
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

    @Override // com.repackage.fj8
    public hj8 dispatch(jj8 jj8Var, hj8 hj8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jj8Var, hj8Var)) == null) {
            if (hj8Var == null) {
                hj8Var = new hj8();
            }
            String b = jj8Var.b();
            JSONObject e = jj8Var.e();
            if (b.equals("host/callNativeSMS")) {
                hj8Var.r(true);
                hj8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    hj8Var.x(callNativeSMS.f());
                    hj8Var.t(callNativeSMS.b());
                    hj8Var.o(callNativeSMS.a());
                    hj8Var.w(callNativeSMS.e());
                }
                hj8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                hj8Var.r(true);
                hj8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    hj8Var.x(blockPopInfo.f());
                    hj8Var.t(blockPopInfo.b());
                    hj8Var.o(blockPopInfo.a());
                    hj8Var.w(blockPopInfo.e());
                }
                hj8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                hj8Var.r(true);
                hj8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    hj8Var.x(bindingMobileNumber.f());
                    hj8Var.t(bindingMobileNumber.b());
                    hj8Var.o(bindingMobileNumber.a());
                    hj8Var.w(bindingMobileNumber.e());
                }
                hj8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                hj8Var.r(true);
                hj8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString("gid"), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    hj8Var.x(recordNovelInfo.f());
                    hj8Var.t(recordNovelInfo.b());
                    hj8Var.o(recordNovelInfo.a());
                    hj8Var.w(recordNovelInfo.e());
                }
                hj8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                hj8Var.r(true);
                hj8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    hj8Var.x(novelPayResultToClient.f());
                    hj8Var.t(novelPayResultToClient.b());
                    hj8Var.o(novelPayResultToClient.a());
                    hj8Var.w(novelPayResultToClient.e());
                }
                hj8Var.y(0);
            }
            return hj8Var;
        }
        return (hj8) invokeLL.objValue;
    }

    @Override // com.repackage.fj8
    public List<hj8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (oi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
