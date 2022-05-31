package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ki;
import com.repackage.rh8;
import com.repackage.th8;
import com.repackage.vh8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UegTbJsBridge_Proxy extends rh8 {
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

    @Override // com.repackage.rh8
    public th8 dispatch(vh8 vh8Var, th8 th8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vh8Var, th8Var)) == null) {
            if (th8Var == null) {
                th8Var = new th8();
            }
            String b = vh8Var.b();
            JSONObject e = vh8Var.e();
            if (b.equals("host/callNativeSMS")) {
                th8Var.r(true);
                th8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    th8Var.x(callNativeSMS.f());
                    th8Var.t(callNativeSMS.b());
                    th8Var.o(callNativeSMS.a());
                    th8Var.w(callNativeSMS.e());
                }
                th8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                th8Var.r(true);
                th8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    th8Var.x(blockPopInfo.f());
                    th8Var.t(blockPopInfo.b());
                    th8Var.o(blockPopInfo.a());
                    th8Var.w(blockPopInfo.e());
                }
                th8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                th8Var.r(true);
                th8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    th8Var.x(bindingMobileNumber.f());
                    th8Var.t(bindingMobileNumber.b());
                    th8Var.o(bindingMobileNumber.a());
                    th8Var.w(bindingMobileNumber.e());
                }
                th8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                th8Var.r(true);
                th8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString("gid"), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    th8Var.x(recordNovelInfo.f());
                    th8Var.t(recordNovelInfo.b());
                    th8Var.o(recordNovelInfo.a());
                    th8Var.w(recordNovelInfo.e());
                }
                th8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                th8Var.r(true);
                th8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    th8Var.x(novelPayResultToClient.f());
                    th8Var.t(novelPayResultToClient.b());
                    th8Var.o(novelPayResultToClient.a());
                    th8Var.w(novelPayResultToClient.e());
                }
                th8Var.y(0);
            }
            return th8Var;
        }
        return (th8) invokeLL.objValue;
    }

    @Override // com.repackage.rh8
    public List<th8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (ki.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
