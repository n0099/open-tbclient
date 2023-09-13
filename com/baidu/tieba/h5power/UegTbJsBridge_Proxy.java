package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.ei;
import com.baidu.tieba.kia;
import com.baidu.tieba.mia;
import com.baidu.tieba.oia;
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
public class UegTbJsBridge_Proxy extends kia {
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

    @Override // com.baidu.tieba.kia
    public mia dispatch(oia oiaVar, mia miaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, oiaVar, miaVar)) == null) {
            if (miaVar == null) {
                miaVar = new mia();
            }
            String b = oiaVar.b();
            JSONObject e = oiaVar.e();
            if (b.equals("host/callNativeSMS")) {
                miaVar.s(true);
                mia callNativeSMS = this.mJsBridge.callNativeSMS(e.optString("phoneNumber"), e.optString("content"));
                if (callNativeSMS != null) {
                    miaVar.y(callNativeSMS.f());
                    miaVar.u(callNativeSMS.b());
                    miaVar.o(callNativeSMS.a());
                    miaVar.x(callNativeSMS.e());
                }
                miaVar.z(0);
            } else if (b.equals("device/setBlockPopInfo")) {
                miaVar.s(true);
                mia blockPopInfo = this.mJsBridge.setBlockPopInfo(e.optInt("canPost"), e.optString("blockInfo"), e.optString("aheadInfo"), e.optString("aheadUrl"), e.optString("okInfo"), e.optInt("aheadType"));
                if (blockPopInfo != null) {
                    miaVar.y(blockPopInfo.f());
                    miaVar.u(blockPopInfo.b());
                    miaVar.o(blockPopInfo.a());
                    miaVar.x(blockPopInfo.e());
                }
                miaVar.z(0);
            } else if (b.equals("account/bindMobileNumber")) {
                miaVar.s(true);
                mia bindingMobileNumber = this.mJsBridge.bindingMobileNumber();
                if (bindingMobileNumber != null) {
                    miaVar.y(bindingMobileNumber.f());
                    miaVar.u(bindingMobileNumber.b());
                    miaVar.o(bindingMobileNumber.a());
                    miaVar.x(bindingMobileNumber.e());
                }
                miaVar.z(0);
            } else if (b.equals("host/recordNovelInfo")) {
                miaVar.s(true);
                mia recordNovelInfo = this.mJsBridge.recordNovelInfo(e.optString("bookProgress"), e.optString(TbEnum.ParamKey.GID), e.optString("lastReadChapterId"), e.optString("lastReadChapterIndex"), e.optString("lastReadChapterName"));
                if (recordNovelInfo != null) {
                    miaVar.y(recordNovelInfo.f());
                    miaVar.u(recordNovelInfo.b());
                    miaVar.o(recordNovelInfo.a());
                    miaVar.x(recordNovelInfo.e());
                }
                miaVar.z(0);
            } else if (b.equals("host/novelPayResultToClient")) {
                miaVar.s(true);
                mia novelPayResultToClient = this.mJsBridge.novelPayResultToClient(e.optBoolean("isPaySuccess"));
                if (novelPayResultToClient != null) {
                    miaVar.y(novelPayResultToClient.f());
                    miaVar.u(novelPayResultToClient.b());
                    miaVar.o(novelPayResultToClient.a());
                    miaVar.x(novelPayResultToClient.e());
                }
                miaVar.z(0);
            }
            return miaVar;
        }
        return (mia) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.kia
    public List<mia> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            if (!ei.isEmpty(str) && this.mNotificationNameList.contains(str)) {
                ArrayList arrayList = new ArrayList();
                this.mAsyncCallBackMethodList.get(str);
                return arrayList;
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
