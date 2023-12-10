package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.exa;
import com.baidu.tieba.gxa;
import com.baidu.tieba.ixa;
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
public class UegTbJsBridge_Proxy extends exa {
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

    @Override // com.baidu.tieba.exa
    public gxa dispatch(ixa ixaVar, gxa gxaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ixaVar, gxaVar)) == null) {
            if (gxaVar == null) {
                gxaVar = new gxa();
            }
            String b = ixaVar.b();
            JSONObject e = ixaVar.e();
            if (b.equals("host/callNativeSMS")) {
                gxaVar.s(true);
                gxa callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    gxaVar.y(callNativeSMS.f());
                    gxaVar.u(callNativeSMS.b());
                    gxaVar.o(callNativeSMS.a());
                    gxaVar.x(callNativeSMS.e());
                }
                gxaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                gxaVar.s(true);
                gxa blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    gxaVar.y(blockPopInfo.f());
                    gxaVar.u(blockPopInfo.b());
                    gxaVar.o(blockPopInfo.a());
                    gxaVar.x(blockPopInfo.e());
                }
                gxaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                gxaVar.s(true);
                gxa bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    gxaVar.y(bindingMobileNumber.f());
                    gxaVar.u(bindingMobileNumber.b());
                    gxaVar.o(bindingMobileNumber.a());
                    gxaVar.x(bindingMobileNumber.e());
                }
                gxaVar.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                gxaVar.s(true);
                gxa recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    gxaVar.y(recordNovelInfo.f());
                    gxaVar.u(recordNovelInfo.b());
                    gxaVar.o(recordNovelInfo.a());
                    gxaVar.x(recordNovelInfo.e());
                }
                gxaVar.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                gxaVar.s(true);
                gxa novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    gxaVar.y(novelPayResultToClient.f());
                    gxaVar.u(novelPayResultToClient.b());
                    gxaVar.o(novelPayResultToClient.a());
                    gxaVar.x(novelPayResultToClient.e());
                }
                gxaVar.z(0);
            }
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.exa
    public List<gxa> processNotification(WebView webView, String str, HashMap hashMap) {
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
