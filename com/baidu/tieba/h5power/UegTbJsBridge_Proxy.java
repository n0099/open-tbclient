package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.bi;
import com.baidu.tieba.hca;
import com.baidu.tieba.jca;
import com.baidu.tieba.lca;
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
public class UegTbJsBridge_Proxy extends hca {
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

    @Override // com.baidu.tieba.hca
    public jca dispatch(lca lcaVar, jca jcaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, lcaVar, jcaVar)) == null) {
            if (jcaVar == null) {
                jcaVar = new jca();
            }
            String b = lcaVar.b();
            JSONObject e = lcaVar.e();
            if (b.equals("host/callNativeSMS")) {
                jcaVar.s(true);
                jca callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    jcaVar.y(callNativeSMS.f());
                    jcaVar.u(callNativeSMS.b());
                    jcaVar.o(callNativeSMS.a());
                    jcaVar.x(callNativeSMS.e());
                }
                jcaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                jcaVar.s(true);
                jca blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    jcaVar.y(blockPopInfo.f());
                    jcaVar.u(blockPopInfo.b());
                    jcaVar.o(blockPopInfo.a());
                    jcaVar.x(blockPopInfo.e());
                }
                jcaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                jcaVar.s(true);
                jca bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    jcaVar.y(bindingMobileNumber.f());
                    jcaVar.u(bindingMobileNumber.b());
                    jcaVar.o(bindingMobileNumber.a());
                    jcaVar.x(bindingMobileNumber.e());
                }
                jcaVar.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                jcaVar.s(true);
                jca recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    jcaVar.y(recordNovelInfo.f());
                    jcaVar.u(recordNovelInfo.b());
                    jcaVar.o(recordNovelInfo.a());
                    jcaVar.x(recordNovelInfo.e());
                }
                jcaVar.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                jcaVar.s(true);
                jca novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    jcaVar.y(novelPayResultToClient.f());
                    jcaVar.u(novelPayResultToClient.b());
                    jcaVar.o(novelPayResultToClient.a());
                    jcaVar.x(novelPayResultToClient.e());
                }
                jcaVar.z(0);
            }
            return jcaVar;
        }
        return (jca) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.hca
    public List<jca> processNotification(WebView webView, String str, HashMap hashMap) {
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
