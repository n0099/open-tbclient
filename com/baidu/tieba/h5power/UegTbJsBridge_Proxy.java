package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.p0.h3.l0.d.a;
import d.a.p0.h3.l0.d.c;
import d.a.p0.h3.l0.d.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UegTbJsBridge_Proxy extends a {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = uegTbJsBridge;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // d.a.p0.h3.l0.d.a
    public c dispatch(e eVar, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, cVar)) == null) {
            if (cVar == null) {
                cVar = new c();
            }
            String b2 = eVar.b();
            JSONObject e2 = eVar.e();
            if (b2.equals("host/callNativeSMS")) {
                cVar.o(true);
                c callNativeSMS = this.mJsBridge.callNativeSMS(e2.optString("phoneNumber"), e2.optString("content"));
                if (callNativeSMS != null) {
                    cVar.t(callNativeSMS.e());
                    cVar.q(callNativeSMS.b());
                    cVar.l(callNativeSMS.a());
                }
                cVar.u(0);
            } else if (b2.equals("device/setBlockPopInfo")) {
                cVar.o(true);
                c blockPopInfo = this.mJsBridge.setBlockPopInfo(e2.optInt("canPost"), e2.optString("blockInfo"), e2.optString("aheadInfo"), e2.optString("aheadUrl"), e2.optString("okInfo"), e2.optInt("aheadType"));
                if (blockPopInfo != null) {
                    cVar.t(blockPopInfo.e());
                    cVar.q(blockPopInfo.b());
                    cVar.l(blockPopInfo.a());
                }
                cVar.u(0);
            } else if (b2.equals("account/bindMobileNumber")) {
                cVar.o(true);
                c bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    cVar.t(bindingMobileNumber.e());
                    cVar.q(bindingMobileNumber.b());
                    cVar.l(bindingMobileNumber.a());
                }
                cVar.u(0);
            }
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    @Override // d.a.p0.h3.l0.d.a
    public List<c> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            if (k.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            this.mAsyncCallBackMethodList.get(str);
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
