package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.d5a;
import com.baidu.tieba.f5a;
import com.baidu.tieba.h5a;
import com.baidu.tieba.wi;
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
public class UegTbJsBridge_Proxy extends d5a {
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

    @Override // com.baidu.tieba.d5a
    public f5a dispatch(h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, h5aVar, f5aVar)) == null) {
            if (f5aVar == null) {
                f5aVar = new f5a();
            }
            String b = h5aVar.b();
            JSONObject e = h5aVar.e();
            if (b.equals("host/callNativeSMS")) {
                f5aVar.s(true);
                f5a callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    f5aVar.y(callNativeSMS.f());
                    f5aVar.u(callNativeSMS.b());
                    f5aVar.o(callNativeSMS.a());
                    f5aVar.x(callNativeSMS.e());
                }
                f5aVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                f5aVar.s(true);
                f5a blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    f5aVar.y(blockPopInfo.f());
                    f5aVar.u(blockPopInfo.b());
                    f5aVar.o(blockPopInfo.a());
                    f5aVar.x(blockPopInfo.e());
                }
                f5aVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                f5aVar.s(true);
                f5a bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    f5aVar.y(bindingMobileNumber.f());
                    f5aVar.u(bindingMobileNumber.b());
                    f5aVar.o(bindingMobileNumber.a());
                    f5aVar.x(bindingMobileNumber.e());
                }
                f5aVar.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                f5aVar.s(true);
                f5a recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    f5aVar.y(recordNovelInfo.f());
                    f5aVar.u(recordNovelInfo.b());
                    f5aVar.o(recordNovelInfo.a());
                    f5aVar.x(recordNovelInfo.e());
                }
                f5aVar.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                f5aVar.s(true);
                f5a novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    f5aVar.y(novelPayResultToClient.f());
                    f5aVar.u(novelPayResultToClient.b());
                    f5aVar.o(novelPayResultToClient.a());
                    f5aVar.x(novelPayResultToClient.e());
                }
                f5aVar.z(0);
            }
            return f5aVar;
        }
        return (f5a) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public List<f5a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!wi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
