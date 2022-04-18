package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ni;
import com.repackage.tl8;
import com.repackage.vl8;
import com.repackage.xl8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UegTbJsBridge_Proxy extends tl8 {
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

    @Override // com.repackage.tl8
    public vl8 dispatch(xl8 xl8Var, vl8 vl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, xl8Var, vl8Var)) == null) {
            if (vl8Var == null) {
                vl8Var = new vl8();
            }
            String b = xl8Var.b();
            JSONObject e = xl8Var.e();
            if (b.equals("host/callNativeSMS")) {
                vl8Var.r(true);
                vl8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    vl8Var.x(callNativeSMS.f());
                    vl8Var.t(callNativeSMS.b());
                    vl8Var.o(callNativeSMS.a());
                    vl8Var.w(callNativeSMS.e());
                }
                vl8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                vl8Var.r(true);
                vl8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    vl8Var.x(blockPopInfo.f());
                    vl8Var.t(blockPopInfo.b());
                    vl8Var.o(blockPopInfo.a());
                    vl8Var.w(blockPopInfo.e());
                }
                vl8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                vl8Var.r(true);
                vl8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    vl8Var.x(bindingMobileNumber.f());
                    vl8Var.t(bindingMobileNumber.b());
                    vl8Var.o(bindingMobileNumber.a());
                    vl8Var.w(bindingMobileNumber.e());
                }
                vl8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                vl8Var.r(true);
                vl8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString("gid"), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    vl8Var.x(recordNovelInfo.f());
                    vl8Var.t(recordNovelInfo.b());
                    vl8Var.o(recordNovelInfo.a());
                    vl8Var.w(recordNovelInfo.e());
                }
                vl8Var.y(0);
            }
            return vl8Var;
        }
        return (vl8) invokeLL.objValue;
    }

    @Override // com.repackage.tl8
    public List<vl8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (ni.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
