package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.li;
import com.repackage.qk8;
import com.repackage.sk8;
import com.repackage.uk8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UegTbJsBridge_Proxy extends qk8 {
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

    @Override // com.repackage.qk8
    public sk8 dispatch(uk8 uk8Var, sk8 sk8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uk8Var, sk8Var)) == null) {
            if (sk8Var == null) {
                sk8Var = new sk8();
            }
            String b = uk8Var.b();
            JSONObject e = uk8Var.e();
            if (b.equals("host/callNativeSMS")) {
                sk8Var.r(true);
                sk8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    sk8Var.x(callNativeSMS.f());
                    sk8Var.t(callNativeSMS.b());
                    sk8Var.o(callNativeSMS.a());
                    sk8Var.w(callNativeSMS.e());
                }
                sk8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                sk8Var.r(true);
                sk8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    sk8Var.x(blockPopInfo.f());
                    sk8Var.t(blockPopInfo.b());
                    sk8Var.o(blockPopInfo.a());
                    sk8Var.w(blockPopInfo.e());
                }
                sk8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                sk8Var.r(true);
                sk8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    sk8Var.x(bindingMobileNumber.f());
                    sk8Var.t(bindingMobileNumber.b());
                    sk8Var.o(bindingMobileNumber.a());
                    sk8Var.w(bindingMobileNumber.e());
                }
                sk8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                sk8Var.r(true);
                sk8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString("gid"), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    sk8Var.x(recordNovelInfo.f());
                    sk8Var.t(recordNovelInfo.b());
                    sk8Var.o(recordNovelInfo.a());
                    sk8Var.w(recordNovelInfo.e());
                }
                sk8Var.y(0);
            }
            return sk8Var;
        }
        return (sk8) invokeLL.objValue;
    }

    @Override // com.repackage.qk8
    public List<sk8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (li.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
