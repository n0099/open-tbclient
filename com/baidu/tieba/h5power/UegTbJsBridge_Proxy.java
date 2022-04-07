package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ml8;
import com.repackage.ni;
import com.repackage.ol8;
import com.repackage.ql8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UegTbJsBridge_Proxy extends ml8 {
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

    @Override // com.repackage.ml8
    public ol8 dispatch(ql8 ql8Var, ol8 ol8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ql8Var, ol8Var)) == null) {
            if (ol8Var == null) {
                ol8Var = new ol8();
            }
            String b = ql8Var.b();
            JSONObject e = ql8Var.e();
            if (b.equals("host/callNativeSMS")) {
                ol8Var.r(true);
                ol8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    ol8Var.x(callNativeSMS.f());
                    ol8Var.t(callNativeSMS.b());
                    ol8Var.o(callNativeSMS.a());
                    ol8Var.w(callNativeSMS.e());
                }
                ol8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                ol8Var.r(true);
                ol8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    ol8Var.x(blockPopInfo.f());
                    ol8Var.t(blockPopInfo.b());
                    ol8Var.o(blockPopInfo.a());
                    ol8Var.w(blockPopInfo.e());
                }
                ol8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                ol8Var.r(true);
                ol8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    ol8Var.x(bindingMobileNumber.f());
                    ol8Var.t(bindingMobileNumber.b());
                    ol8Var.o(bindingMobileNumber.a());
                    ol8Var.w(bindingMobileNumber.e());
                }
                ol8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                ol8Var.r(true);
                ol8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString("gid"), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    ol8Var.x(recordNovelInfo.f());
                    ol8Var.t(recordNovelInfo.b());
                    ol8Var.o(recordNovelInfo.a());
                    ol8Var.w(recordNovelInfo.e());
                }
                ol8Var.y(0);
            }
            return ol8Var;
        }
        return (ol8) invokeLL.objValue;
    }

    @Override // com.repackage.ml8
    public List<ol8> processNotification(String str, HashMap hashMap) {
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
