package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tieba.bo8;
import com.baidu.tieba.dj;
import com.baidu.tieba.do8;
import com.baidu.tieba.zn8;
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
public class UegTbJsBridge_Proxy extends zn8 {
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

    @Override // com.baidu.tieba.zn8
    public bo8 dispatch(do8 do8Var, bo8 bo8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, do8Var, bo8Var)) == null) {
            if (bo8Var == null) {
                bo8Var = new bo8();
            }
            String b = do8Var.b();
            JSONObject e = do8Var.e();
            if (b.equals("host/callNativeSMS")) {
                bo8Var.r(true);
                bo8 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    bo8Var.x(callNativeSMS.f());
                    bo8Var.t(callNativeSMS.b());
                    bo8Var.o(callNativeSMS.a());
                    bo8Var.w(callNativeSMS.e());
                }
                bo8Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                bo8Var.r(true);
                bo8 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    bo8Var.x(blockPopInfo.f());
                    bo8Var.t(blockPopInfo.b());
                    bo8Var.o(blockPopInfo.a());
                    bo8Var.w(blockPopInfo.e());
                }
                bo8Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                bo8Var.r(true);
                bo8 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    bo8Var.x(bindingMobileNumber.f());
                    bo8Var.t(bindingMobileNumber.b());
                    bo8Var.o(bindingMobileNumber.a());
                    bo8Var.w(bindingMobileNumber.e());
                }
                bo8Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                bo8Var.r(true);
                bo8 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString("gid"), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    bo8Var.x(recordNovelInfo.f());
                    bo8Var.t(recordNovelInfo.b());
                    bo8Var.o(recordNovelInfo.a());
                    bo8Var.w(recordNovelInfo.e());
                }
                bo8Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                bo8Var.r(true);
                bo8 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    bo8Var.x(novelPayResultToClient.f());
                    bo8Var.t(novelPayResultToClient.b());
                    bo8Var.o(novelPayResultToClient.a());
                    bo8Var.w(novelPayResultToClient.e());
                }
                bo8Var.y(0);
            }
            return bo8Var;
        }
        return (bo8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.zn8
    public List<bo8> processNotification(String str, HashMap hashMap) {
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
