package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.msa;
import com.baidu.tieba.osa;
import com.baidu.tieba.qd;
import com.baidu.tieba.qsa;
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
public class UegTbJsBridge_Proxy extends msa {
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

    @Override // com.baidu.tieba.msa
    public osa dispatch(qsa qsaVar, osa osaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qsaVar, osaVar)) == null) {
            if (osaVar == null) {
                osaVar = new osa();
            }
            String b = qsaVar.b();
            JSONObject e = qsaVar.e();
            if (b.equals("host/callNativeSMS")) {
                osaVar.s(true);
                osa callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    osaVar.y(callNativeSMS.f());
                    osaVar.u(callNativeSMS.b());
                    osaVar.o(callNativeSMS.a());
                    osaVar.x(callNativeSMS.e());
                }
                osaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                osaVar.s(true);
                osa blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    osaVar.y(blockPopInfo.f());
                    osaVar.u(blockPopInfo.b());
                    osaVar.o(blockPopInfo.a());
                    osaVar.x(blockPopInfo.e());
                }
                osaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                osaVar.s(true);
                osa bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    osaVar.y(bindingMobileNumber.f());
                    osaVar.u(bindingMobileNumber.b());
                    osaVar.o(bindingMobileNumber.a());
                    osaVar.x(bindingMobileNumber.e());
                }
                osaVar.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                osaVar.s(true);
                osa recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    osaVar.y(recordNovelInfo.f());
                    osaVar.u(recordNovelInfo.b());
                    osaVar.o(recordNovelInfo.a());
                    osaVar.x(recordNovelInfo.e());
                }
                osaVar.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                osaVar.s(true);
                osa novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    osaVar.y(novelPayResultToClient.f());
                    osaVar.u(novelPayResultToClient.b());
                    osaVar.o(novelPayResultToClient.a());
                    osaVar.x(novelPayResultToClient.e());
                }
                osaVar.z(0);
            }
            return osaVar;
        }
        return (osa) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.msa
    public List<osa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!qd.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
