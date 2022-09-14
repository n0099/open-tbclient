package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tieba.dj;
import com.baidu.tieba.kn8;
import com.baidu.tieba.mn8;
import com.baidu.tieba.on8;
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
public class UegTbJsBridge_Proxy extends kn8 {
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

    @Override // com.baidu.tieba.kn8
    public mn8 dispatch(on8 on8Var, mn8 mn8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, on8Var, mn8Var)) == null) {
            if (mn8Var == null) {
                mn8Var = new mn8();
            }
            String b = on8Var.b();
            JSONObject e = on8Var.e();
            if (b.equals("host/callNativeSMS")) {
                mn8Var.r(true);
                mn8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    mn8Var.x(callNativeSMS.f());
                    mn8Var.t(callNativeSMS.b());
                    mn8Var.o(callNativeSMS.a());
                    mn8Var.w(callNativeSMS.e());
                }
                mn8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                mn8Var.r(true);
                mn8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    mn8Var.x(blockPopInfo.f());
                    mn8Var.t(blockPopInfo.b());
                    mn8Var.o(blockPopInfo.a());
                    mn8Var.w(blockPopInfo.e());
                }
                mn8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                mn8Var.r(true);
                mn8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    mn8Var.x(bindingMobileNumber.f());
                    mn8Var.t(bindingMobileNumber.b());
                    mn8Var.o(bindingMobileNumber.a());
                    mn8Var.w(bindingMobileNumber.e());
                }
                mn8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                mn8Var.r(true);
                mn8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString("gid"), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    mn8Var.x(recordNovelInfo.f());
                    mn8Var.t(recordNovelInfo.b());
                    mn8Var.o(recordNovelInfo.a());
                    mn8Var.w(recordNovelInfo.e());
                }
                mn8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                mn8Var.r(true);
                mn8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    mn8Var.x(novelPayResultToClient.f());
                    mn8Var.t(novelPayResultToClient.b());
                    mn8Var.o(novelPayResultToClient.a());
                    mn8Var.w(novelPayResultToClient.e());
                }
                mn8Var.y(0);
            }
            return mn8Var;
        }
        return (mn8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.kn8
    public List<mn8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (dj.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
