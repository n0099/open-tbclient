package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tieba.am8;
import com.baidu.tieba.cm8;
import com.baidu.tieba.qi;
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
public class UegTbJsBridge_Proxy extends yl8 {
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

    @Override // com.baidu.tieba.yl8
    public am8 dispatch(cm8 cm8Var, am8 am8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cm8Var, am8Var)) == null) {
            if (am8Var == null) {
                am8Var = new am8();
            }
            String b = cm8Var.b();
            JSONObject e = cm8Var.e();
            if (b.equals("host/callNativeSMS")) {
                am8Var.r(true);
                am8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    am8Var.x(callNativeSMS.f());
                    am8Var.t(callNativeSMS.b());
                    am8Var.o(callNativeSMS.a());
                    am8Var.w(callNativeSMS.e());
                }
                am8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                am8Var.r(true);
                am8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    am8Var.x(blockPopInfo.f());
                    am8Var.t(blockPopInfo.b());
                    am8Var.o(blockPopInfo.a());
                    am8Var.w(blockPopInfo.e());
                }
                am8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                am8Var.r(true);
                am8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    am8Var.x(bindingMobileNumber.f());
                    am8Var.t(bindingMobileNumber.b());
                    am8Var.o(bindingMobileNumber.a());
                    am8Var.w(bindingMobileNumber.e());
                }
                am8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                am8Var.r(true);
                am8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString("gid"), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    am8Var.x(recordNovelInfo.f());
                    am8Var.t(recordNovelInfo.b());
                    am8Var.o(recordNovelInfo.a());
                    am8Var.w(recordNovelInfo.e());
                }
                am8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                am8Var.r(true);
                am8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    am8Var.x(novelPayResultToClient.f());
                    am8Var.t(novelPayResultToClient.b());
                    am8Var.o(novelPayResultToClient.a());
                    am8Var.w(novelPayResultToClient.e());
                }
                am8Var.y(0);
            }
            return am8Var;
        }
        return (am8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.yl8
    public List<am8> processNotification(String str, HashMap hashMap) {
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
