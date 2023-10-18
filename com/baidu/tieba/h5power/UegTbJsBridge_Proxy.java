package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.ad;
import com.baidu.tieba.gfa;
import com.baidu.tieba.ifa;
import com.baidu.tieba.kfa;
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
/* loaded from: classes6.dex */
public class UegTbJsBridge_Proxy extends gfa {
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

    @Override // com.baidu.tieba.gfa
    public ifa dispatch(kfa kfaVar, ifa ifaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kfaVar, ifaVar)) == null) {
            if (ifaVar == null) {
                ifaVar = new ifa();
            }
            String b = kfaVar.b();
            JSONObject e = kfaVar.e();
            if (b.equals("host/callNativeSMS")) {
                ifaVar.s(true);
                ifa callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    ifaVar.y(callNativeSMS.f());
                    ifaVar.u(callNativeSMS.b());
                    ifaVar.o(callNativeSMS.a());
                    ifaVar.x(callNativeSMS.e());
                }
                ifaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                ifaVar.s(true);
                ifa blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    ifaVar.y(blockPopInfo.f());
                    ifaVar.u(blockPopInfo.b());
                    ifaVar.o(blockPopInfo.a());
                    ifaVar.x(blockPopInfo.e());
                }
                ifaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                ifaVar.s(true);
                ifa bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    ifaVar.y(bindingMobileNumber.f());
                    ifaVar.u(bindingMobileNumber.b());
                    ifaVar.o(bindingMobileNumber.a());
                    ifaVar.x(bindingMobileNumber.e());
                }
                ifaVar.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                ifaVar.s(true);
                ifa recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    ifaVar.y(recordNovelInfo.f());
                    ifaVar.u(recordNovelInfo.b());
                    ifaVar.o(recordNovelInfo.a());
                    ifaVar.x(recordNovelInfo.e());
                }
                ifaVar.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                ifaVar.s(true);
                ifa novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    ifaVar.y(novelPayResultToClient.f());
                    ifaVar.u(novelPayResultToClient.b());
                    ifaVar.o(novelPayResultToClient.a());
                    ifaVar.x(novelPayResultToClient.e());
                }
                ifaVar.z(0);
            }
            return ifaVar;
        }
        return (ifa) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.gfa
    public List<ifa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!ad.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
