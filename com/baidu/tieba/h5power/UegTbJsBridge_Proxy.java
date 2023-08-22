package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.di;
import com.baidu.tieba.qga;
import com.baidu.tieba.sga;
import com.baidu.tieba.uga;
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
public class UegTbJsBridge_Proxy extends qga {
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

    @Override // com.baidu.tieba.qga
    public sga dispatch(uga ugaVar, sga sgaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ugaVar, sgaVar)) == null) {
            if (sgaVar == null) {
                sgaVar = new sga();
            }
            String b = ugaVar.b();
            JSONObject e = ugaVar.e();
            if (b.equals("host/callNativeSMS")) {
                sgaVar.s(true);
                sga callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    sgaVar.y(callNativeSMS.f());
                    sgaVar.u(callNativeSMS.b());
                    sgaVar.o(callNativeSMS.a());
                    sgaVar.x(callNativeSMS.e());
                }
                sgaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                sgaVar.s(true);
                sga blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    sgaVar.y(blockPopInfo.f());
                    sgaVar.u(blockPopInfo.b());
                    sgaVar.o(blockPopInfo.a());
                    sgaVar.x(blockPopInfo.e());
                }
                sgaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                sgaVar.s(true);
                sga bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    sgaVar.y(bindingMobileNumber.f());
                    sgaVar.u(bindingMobileNumber.b());
                    sgaVar.o(bindingMobileNumber.a());
                    sgaVar.x(bindingMobileNumber.e());
                }
                sgaVar.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                sgaVar.s(true);
                sga recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    sgaVar.y(recordNovelInfo.f());
                    sgaVar.u(recordNovelInfo.b());
                    sgaVar.o(recordNovelInfo.a());
                    sgaVar.x(recordNovelInfo.e());
                }
                sgaVar.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                sgaVar.s(true);
                sga novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    sgaVar.y(novelPayResultToClient.f());
                    sgaVar.u(novelPayResultToClient.b());
                    sgaVar.o(novelPayResultToClient.a());
                    sgaVar.x(novelPayResultToClient.e());
                }
                sgaVar.z(0);
            }
            return sgaVar;
        }
        return (sga) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.qga
    public List<sga> processNotification(WebView webView, String str, HashMap hashMap) {
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
