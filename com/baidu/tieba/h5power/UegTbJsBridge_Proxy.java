package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.lsa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.psa;
import com.baidu.tieba.qd;
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
public class UegTbJsBridge_Proxy extends lsa {
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

    @Override // com.baidu.tieba.lsa
    public nsa dispatch(psa psaVar, nsa nsaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, psaVar, nsaVar)) == null) {
            if (nsaVar == null) {
                nsaVar = new nsa();
            }
            String b = psaVar.b();
            JSONObject e = psaVar.e();
            if (b.equals("host/callNativeSMS")) {
                nsaVar.s(true);
                nsa callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    nsaVar.y(callNativeSMS.f());
                    nsaVar.u(callNativeSMS.b());
                    nsaVar.o(callNativeSMS.a());
                    nsaVar.x(callNativeSMS.e());
                }
                nsaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                nsaVar.s(true);
                nsa blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    nsaVar.y(blockPopInfo.f());
                    nsaVar.u(blockPopInfo.b());
                    nsaVar.o(blockPopInfo.a());
                    nsaVar.x(blockPopInfo.e());
                }
                nsaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                nsaVar.s(true);
                nsa bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    nsaVar.y(bindingMobileNumber.f());
                    nsaVar.u(bindingMobileNumber.b());
                    nsaVar.o(bindingMobileNumber.a());
                    nsaVar.x(bindingMobileNumber.e());
                }
                nsaVar.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                nsaVar.s(true);
                nsa recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    nsaVar.y(recordNovelInfo.f());
                    nsaVar.u(recordNovelInfo.b());
                    nsaVar.o(recordNovelInfo.a());
                    nsaVar.x(recordNovelInfo.e());
                }
                nsaVar.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                nsaVar.s(true);
                nsa novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    nsaVar.y(novelPayResultToClient.f());
                    nsaVar.u(novelPayResultToClient.b());
                    nsaVar.o(novelPayResultToClient.a());
                    nsaVar.x(novelPayResultToClient.e());
                }
                nsaVar.z(0);
            }
            return nsaVar;
        }
        return (nsa) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public List<nsa> processNotification(WebView webView, String str, HashMap hashMap) {
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
