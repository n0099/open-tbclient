package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.di;
import com.baidu.tieba.qka;
import com.baidu.tieba.ska;
import com.baidu.tieba.uka;
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
public class UegTbJsBridge_Proxy extends qka {
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

    @Override // com.baidu.tieba.qka
    public ska dispatch(uka ukaVar, ska skaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ukaVar, skaVar)) == null) {
            if (skaVar == null) {
                skaVar = new ska();
            }
            String b = ukaVar.b();
            JSONObject e = ukaVar.e();
            if (b.equals("host/callNativeSMS")) {
                skaVar.s(true);
                ska callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    skaVar.y(callNativeSMS.f());
                    skaVar.u(callNativeSMS.b());
                    skaVar.o(callNativeSMS.a());
                    skaVar.x(callNativeSMS.e());
                }
                skaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                skaVar.s(true);
                ska blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    skaVar.y(blockPopInfo.f());
                    skaVar.u(blockPopInfo.b());
                    skaVar.o(blockPopInfo.a());
                    skaVar.x(blockPopInfo.e());
                }
                skaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                skaVar.s(true);
                ska bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    skaVar.y(bindingMobileNumber.f());
                    skaVar.u(bindingMobileNumber.b());
                    skaVar.o(bindingMobileNumber.a());
                    skaVar.x(bindingMobileNumber.e());
                }
                skaVar.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                skaVar.s(true);
                ska recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    skaVar.y(recordNovelInfo.f());
                    skaVar.u(recordNovelInfo.b());
                    skaVar.o(recordNovelInfo.a());
                    skaVar.x(recordNovelInfo.e());
                }
                skaVar.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                skaVar.s(true);
                ska novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    skaVar.y(novelPayResultToClient.f());
                    skaVar.u(novelPayResultToClient.b());
                    skaVar.o(novelPayResultToClient.a());
                    skaVar.x(novelPayResultToClient.e());
                }
                skaVar.z(0);
            }
            return skaVar;
        }
        return (ska) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.qka
    public List<ska> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!di.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
