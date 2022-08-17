package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pi;
import com.repackage.ql8;
import com.repackage.sl8;
import com.repackage.ul8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UegTbJsBridge_Proxy extends ql8 {
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

    @Override // com.repackage.ql8
    public sl8 dispatch(ul8 ul8Var, sl8 sl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ul8Var, sl8Var)) == null) {
            if (sl8Var == null) {
                sl8Var = new sl8();
            }
            String b = ul8Var.b();
            JSONObject e = ul8Var.e();
            if (b.equals("host/callNativeSMS")) {
                sl8Var.r(true);
                sl8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    sl8Var.x(callNativeSMS.f());
                    sl8Var.t(callNativeSMS.b());
                    sl8Var.o(callNativeSMS.a());
                    sl8Var.w(callNativeSMS.e());
                }
                sl8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                sl8Var.r(true);
                sl8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    sl8Var.x(blockPopInfo.f());
                    sl8Var.t(blockPopInfo.b());
                    sl8Var.o(blockPopInfo.a());
                    sl8Var.w(blockPopInfo.e());
                }
                sl8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                sl8Var.r(true);
                sl8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    sl8Var.x(bindingMobileNumber.f());
                    sl8Var.t(bindingMobileNumber.b());
                    sl8Var.o(bindingMobileNumber.a());
                    sl8Var.w(bindingMobileNumber.e());
                }
                sl8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                sl8Var.r(true);
                sl8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString("gid"), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    sl8Var.x(recordNovelInfo.f());
                    sl8Var.t(recordNovelInfo.b());
                    sl8Var.o(recordNovelInfo.a());
                    sl8Var.w(recordNovelInfo.e());
                }
                sl8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                sl8Var.r(true);
                sl8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    sl8Var.x(novelPayResultToClient.f());
                    sl8Var.t(novelPayResultToClient.b());
                    sl8Var.o(novelPayResultToClient.a());
                    sl8Var.w(novelPayResultToClient.e());
                }
                sl8Var.y(0);
            }
            return sl8Var;
        }
        return (sl8) invokeLL.objValue;
    }

    @Override // com.repackage.ql8
    public List<sl8> processNotification(String str, HashMap hashMap) {
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
