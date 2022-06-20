package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ji8;
import com.repackage.li8;
import com.repackage.ni8;
import com.repackage.oi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UegTbJsBridge_Proxy extends ji8 {
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

    @Override // com.repackage.ji8
    public li8 dispatch(ni8 ni8Var, li8 li8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ni8Var, li8Var)) == null) {
            if (li8Var == null) {
                li8Var = new li8();
            }
            String b = ni8Var.b();
            JSONObject e = ni8Var.e();
            if (b.equals("host/callNativeSMS")) {
                li8Var.r(true);
                li8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    li8Var.x(callNativeSMS.f());
                    li8Var.t(callNativeSMS.b());
                    li8Var.o(callNativeSMS.a());
                    li8Var.w(callNativeSMS.e());
                }
                li8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                li8Var.r(true);
                li8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    li8Var.x(blockPopInfo.f());
                    li8Var.t(blockPopInfo.b());
                    li8Var.o(blockPopInfo.a());
                    li8Var.w(blockPopInfo.e());
                }
                li8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                li8Var.r(true);
                li8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    li8Var.x(bindingMobileNumber.f());
                    li8Var.t(bindingMobileNumber.b());
                    li8Var.o(bindingMobileNumber.a());
                    li8Var.w(bindingMobileNumber.e());
                }
                li8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                li8Var.r(true);
                li8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString("gid"), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    li8Var.x(recordNovelInfo.f());
                    li8Var.t(recordNovelInfo.b());
                    li8Var.o(recordNovelInfo.a());
                    li8Var.w(recordNovelInfo.e());
                }
                li8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                li8Var.r(true);
                li8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    li8Var.x(novelPayResultToClient.f());
                    li8Var.t(novelPayResultToClient.b());
                    li8Var.o(novelPayResultToClient.a());
                    li8Var.w(novelPayResultToClient.e());
                }
                li8Var.y(0);
            }
            return li8Var;
        }
        return (li8) invokeLL.objValue;
    }

    @Override // com.repackage.ji8
    public List<li8> processNotification(String str, HashMap hashMap) {
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
