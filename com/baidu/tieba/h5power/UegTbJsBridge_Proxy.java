package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.dj;
import com.baidu.tieba.l69;
import com.baidu.tieba.n69;
import com.baidu.tieba.p69;
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
/* loaded from: classes4.dex */
public class UegTbJsBridge_Proxy extends l69 {
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

    @Override // com.baidu.tieba.l69
    public n69 dispatch(p69 p69Var, n69 n69Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, p69Var, n69Var)) == null) {
            if (n69Var == null) {
                n69Var = new n69();
            }
            String b = p69Var.b();
            JSONObject e = p69Var.e();
            if (b.equals("host/callNativeSMS")) {
                n69Var.r(true);
                n69 callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    n69Var.x(callNativeSMS.f());
                    n69Var.t(callNativeSMS.b());
                    n69Var.o(callNativeSMS.a());
                    n69Var.w(callNativeSMS.e());
                }
                n69Var.y(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                n69Var.r(true);
                n69 blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    n69Var.x(blockPopInfo.f());
                    n69Var.t(blockPopInfo.b());
                    n69Var.o(blockPopInfo.a());
                    n69Var.w(blockPopInfo.e());
                }
                n69Var.y(0);
            } else if (b.equals("account/bindMobileNumber")) {
                n69Var.r(true);
                n69 bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    n69Var.x(bindingMobileNumber.f());
                    n69Var.t(bindingMobileNumber.b());
                    n69Var.o(bindingMobileNumber.a());
                    n69Var.w(bindingMobileNumber.e());
                }
                n69Var.y(0);
            } else if (b.equals("host/recordNovelInfo")) {
                n69Var.r(true);
                n69 recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    n69Var.x(recordNovelInfo.f());
                    n69Var.t(recordNovelInfo.b());
                    n69Var.o(recordNovelInfo.a());
                    n69Var.w(recordNovelInfo.e());
                }
                n69Var.y(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                n69Var.r(true);
                n69 novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    n69Var.x(novelPayResultToClient.f());
                    n69Var.t(novelPayResultToClient.b());
                    n69Var.o(novelPayResultToClient.a());
                    n69Var.w(novelPayResultToClient.e());
                }
                n69Var.y(0);
            }
            return n69Var;
        }
        return (n69) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.l69
    public List<n69> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!dj.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
