package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.bi;
import com.baidu.tieba.ica;
import com.baidu.tieba.kca;
import com.baidu.tieba.mca;
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
public class UegTbJsBridge_Proxy extends ica {
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

    @Override // com.baidu.tieba.ica
    public kca dispatch(mca mcaVar, kca kcaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mcaVar, kcaVar)) == null) {
            if (kcaVar == null) {
                kcaVar = new kca();
            }
            String b = mcaVar.b();
            JSONObject e = mcaVar.e();
            if (b.equals("host/callNativeSMS")) {
                kcaVar.s(true);
                kca callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    kcaVar.y(callNativeSMS.f());
                    kcaVar.u(callNativeSMS.b());
                    kcaVar.o(callNativeSMS.a());
                    kcaVar.x(callNativeSMS.e());
                }
                kcaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                kcaVar.s(true);
                kca blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    kcaVar.y(blockPopInfo.f());
                    kcaVar.u(blockPopInfo.b());
                    kcaVar.o(blockPopInfo.a());
                    kcaVar.x(blockPopInfo.e());
                }
                kcaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                kcaVar.s(true);
                kca bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    kcaVar.y(bindingMobileNumber.f());
                    kcaVar.u(bindingMobileNumber.b());
                    kcaVar.o(bindingMobileNumber.a());
                    kcaVar.x(bindingMobileNumber.e());
                }
                kcaVar.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                kcaVar.s(true);
                kca recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    kcaVar.y(recordNovelInfo.f());
                    kcaVar.u(recordNovelInfo.b());
                    kcaVar.o(recordNovelInfo.a());
                    kcaVar.x(recordNovelInfo.e());
                }
                kcaVar.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                kcaVar.s(true);
                kca novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    kcaVar.y(novelPayResultToClient.f());
                    kcaVar.u(novelPayResultToClient.b());
                    kcaVar.o(novelPayResultToClient.a());
                    kcaVar.x(novelPayResultToClient.e());
                }
                kcaVar.z(0);
            }
            return kcaVar;
        }
        return (kca) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ica
    public List<kca> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!bi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
