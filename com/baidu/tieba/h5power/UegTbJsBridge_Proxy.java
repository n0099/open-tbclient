package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.dxa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.hxa;
import com.baidu.tieba.rd;
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
public class UegTbJsBridge_Proxy extends dxa {
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

    @Override // com.baidu.tieba.dxa
    public fxa dispatch(hxa hxaVar, fxa fxaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hxaVar, fxaVar)) == null) {
            if (fxaVar == null) {
                fxaVar = new fxa();
            }
            String b = hxaVar.b();
            JSONObject e = hxaVar.e();
            if (b.equals("host/callNativeSMS")) {
                fxaVar.s(true);
                fxa callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    fxaVar.y(callNativeSMS.f());
                    fxaVar.u(callNativeSMS.b());
                    fxaVar.o(callNativeSMS.a());
                    fxaVar.x(callNativeSMS.e());
                }
                fxaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                fxaVar.s(true);
                fxa blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    fxaVar.y(blockPopInfo.f());
                    fxaVar.u(blockPopInfo.b());
                    fxaVar.o(blockPopInfo.a());
                    fxaVar.x(blockPopInfo.e());
                }
                fxaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                fxaVar.s(true);
                fxa bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    fxaVar.y(bindingMobileNumber.f());
                    fxaVar.u(bindingMobileNumber.b());
                    fxaVar.o(bindingMobileNumber.a());
                    fxaVar.x(bindingMobileNumber.e());
                }
                fxaVar.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                fxaVar.s(true);
                fxa recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    fxaVar.y(recordNovelInfo.f());
                    fxaVar.u(recordNovelInfo.b());
                    fxaVar.o(recordNovelInfo.a());
                    fxaVar.x(recordNovelInfo.e());
                }
                fxaVar.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                fxaVar.s(true);
                fxa novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    fxaVar.y(novelPayResultToClient.f());
                    fxaVar.u(novelPayResultToClient.b());
                    fxaVar.o(novelPayResultToClient.a());
                    fxaVar.x(novelPayResultToClient.e());
                }
                fxaVar.z(0);
            }
            return fxaVar;
        }
        return (fxa) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public List<fxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!rd.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
