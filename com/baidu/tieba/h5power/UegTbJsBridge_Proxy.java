package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.oda;
import com.baidu.tieba.qda;
import com.baidu.tieba.sda;
import com.baidu.tieba.xi;
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
public class UegTbJsBridge_Proxy extends oda {
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

    @Override // com.baidu.tieba.oda
    public qda dispatch(sda sdaVar, qda qdaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sdaVar, qdaVar)) == null) {
            if (qdaVar == null) {
                qdaVar = new qda();
            }
            String b = sdaVar.b();
            JSONObject e = sdaVar.e();
            if (b.equals("host/callNativeSMS")) {
                qdaVar.s(true);
                qda callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    qdaVar.y(callNativeSMS.f());
                    qdaVar.u(callNativeSMS.b());
                    qdaVar.o(callNativeSMS.a());
                    qdaVar.x(callNativeSMS.e());
                }
                qdaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                qdaVar.s(true);
                qda blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    qdaVar.y(blockPopInfo.f());
                    qdaVar.u(blockPopInfo.b());
                    qdaVar.o(blockPopInfo.a());
                    qdaVar.x(blockPopInfo.e());
                }
                qdaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                qdaVar.s(true);
                qda bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    qdaVar.y(bindingMobileNumber.f());
                    qdaVar.u(bindingMobileNumber.b());
                    qdaVar.o(bindingMobileNumber.a());
                    qdaVar.x(bindingMobileNumber.e());
                }
                qdaVar.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                qdaVar.s(true);
                qda recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    qdaVar.y(recordNovelInfo.f());
                    qdaVar.u(recordNovelInfo.b());
                    qdaVar.o(recordNovelInfo.a());
                    qdaVar.x(recordNovelInfo.e());
                }
                qdaVar.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                qdaVar.s(true);
                qda novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    qdaVar.y(novelPayResultToClient.f());
                    qdaVar.u(novelPayResultToClient.b());
                    qdaVar.o(novelPayResultToClient.a());
                    qdaVar.x(novelPayResultToClient.e());
                }
                qdaVar.z(0);
            }
            return qdaVar;
        }
        return (qda) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.oda
    public List<qda> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!xi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
