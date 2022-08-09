package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pi;
import com.repackage.rl8;
import com.repackage.tl8;
import com.repackage.vl8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UegTbJsBridge_Proxy extends rl8 {
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

    @Override // com.repackage.rl8
    public tl8 dispatch(vl8 vl8Var, tl8 tl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vl8Var, tl8Var)) == null) {
            if (tl8Var == null) {
                tl8Var = new tl8();
            }
            String b = vl8Var.b();
            JSONObject e = vl8Var.e();
            if (b.equals("host/callNativeSMS")) {
                tl8Var.r(true);
                tl8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    tl8Var.x(callNativeSMS.f());
                    tl8Var.t(callNativeSMS.b());
                    tl8Var.o(callNativeSMS.a());
                    tl8Var.w(callNativeSMS.e());
                }
                tl8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                tl8Var.r(true);
                tl8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    tl8Var.x(blockPopInfo.f());
                    tl8Var.t(blockPopInfo.b());
                    tl8Var.o(blockPopInfo.a());
                    tl8Var.w(blockPopInfo.e());
                }
                tl8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                tl8Var.r(true);
                tl8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    tl8Var.x(bindingMobileNumber.f());
                    tl8Var.t(bindingMobileNumber.b());
                    tl8Var.o(bindingMobileNumber.a());
                    tl8Var.w(bindingMobileNumber.e());
                }
                tl8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                tl8Var.r(true);
                tl8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString("gid"), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    tl8Var.x(recordNovelInfo.f());
                    tl8Var.t(recordNovelInfo.b());
                    tl8Var.o(recordNovelInfo.a());
                    tl8Var.w(recordNovelInfo.e());
                }
                tl8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                tl8Var.r(true);
                tl8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    tl8Var.x(novelPayResultToClient.f());
                    tl8Var.t(novelPayResultToClient.b());
                    tl8Var.o(novelPayResultToClient.a());
                    tl8Var.w(novelPayResultToClient.e());
                }
                tl8Var.y(0);
            }
            return tl8Var;
        }
        return (tl8) invokeLL.objValue;
    }

    @Override // com.repackage.rl8
    public List<tl8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (pi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
