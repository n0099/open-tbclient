package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.r0a;
import com.baidu.tieba.t0a;
import com.baidu.tieba.v0a;
import com.baidu.tieba.vi;
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
public class UegTbJsBridge_Proxy extends r0a {
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

    @Override // com.baidu.tieba.r0a
    public t0a dispatch(v0a v0aVar, t0a t0aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, v0aVar, t0aVar)) == null) {
            if (t0aVar == null) {
                t0aVar = new t0a();
            }
            String b = v0aVar.b();
            JSONObject e = v0aVar.e();
            if (b.equals("host/callNativeSMS")) {
                t0aVar.s(true);
                t0a callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    t0aVar.y(callNativeSMS.f());
                    t0aVar.u(callNativeSMS.b());
                    t0aVar.o(callNativeSMS.a());
                    t0aVar.x(callNativeSMS.e());
                }
                t0aVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                t0aVar.s(true);
                t0a blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    t0aVar.y(blockPopInfo.f());
                    t0aVar.u(blockPopInfo.b());
                    t0aVar.o(blockPopInfo.a());
                    t0aVar.x(blockPopInfo.e());
                }
                t0aVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                t0aVar.s(true);
                t0a bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    t0aVar.y(bindingMobileNumber.f());
                    t0aVar.u(bindingMobileNumber.b());
                    t0aVar.o(bindingMobileNumber.a());
                    t0aVar.x(bindingMobileNumber.e());
                }
                t0aVar.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                t0aVar.s(true);
                t0a recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    t0aVar.y(recordNovelInfo.f());
                    t0aVar.u(recordNovelInfo.b());
                    t0aVar.o(recordNovelInfo.a());
                    t0aVar.x(recordNovelInfo.e());
                }
                t0aVar.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                t0aVar.s(true);
                t0a novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    t0aVar.y(novelPayResultToClient.f());
                    t0aVar.u(novelPayResultToClient.b());
                    t0aVar.o(novelPayResultToClient.a());
                    t0aVar.x(novelPayResultToClient.e());
                }
                t0aVar.z(0);
            }
            return t0aVar;
        }
        return (t0a) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public List<t0a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!vi.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
