package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.kia;
import com.baidu.tieba.lia;
import com.baidu.tieba.mia;
import com.baidu.tieba.oia;
import com.baidu.tieba.tm6;
import com.baidu.tieba.zx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ToastJsBridgePlugin_Proxy extends kia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zx4 mJsBridge;

    public ToastJsBridgePlugin_Proxy(zx4 zx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = zx4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("showDialog");
    }

    @Override // com.baidu.tieba.kia
    public mia dispatch(WebView webView, oia oiaVar, mia miaVar) {
        InterceptResult invokeLLL;
        mia miaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, oiaVar, miaVar)) == null) {
            if (miaVar == null) {
                miaVar2 = new mia();
            } else {
                miaVar2 = miaVar;
            }
            String b = oiaVar.b();
            JSONObject e = oiaVar.e();
            if (b.equals("toast/toastPopupView")) {
                miaVar2.s(true);
                mia miaVar3 = miaVar2;
                mia h = this.mJsBridge.h(webView, e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (h != null) {
                    miaVar3.y(h.f());
                    miaVar3.u(h.b());
                    miaVar3.o(h.a());
                    miaVar3.x(h.e());
                }
                miaVar3.z(0);
                return miaVar3;
            }
            mia miaVar4 = miaVar2;
            if (b.equals("toast/showTipToast")) {
                miaVar4.s(true);
                mia i = this.mJsBridge.i(webView, e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (i != null) {
                    miaVar4.y(i.f());
                    miaVar4.u(i.b());
                    miaVar4.o(i.a());
                    miaVar4.x(i.e());
                }
                miaVar4.z(0);
                return miaVar4;
            } else if (b.equals("toast/getModalData")) {
                miaVar4.s(true);
                mia e2 = this.mJsBridge.e(webView, e.optString("url"));
                if (e2 != null) {
                    miaVar4.y(e2.f());
                    miaVar4.u(e2.b());
                    miaVar4.o(e2.a());
                    miaVar4.x(e2.e());
                }
                miaVar4.z(0);
                return miaVar4;
            } else if (!b.equals("toast/showDialog")) {
                return miaVar4;
            } else {
                miaVar4.s(true);
                mia f = this.mJsBridge.f(webView, e.optInt("type"), e.optString("content"), e.optString("dialogId"));
                this.mNotificationNameList.add("showDialog");
                if (f != null) {
                    miaVar4.y(f.f());
                    miaVar4.u(f.b());
                    miaVar4.o(f.a());
                    miaVar4.x(f.e());
                    if (!miaVar4.h()) {
                        miaVar4.n(false);
                        addObserver(webView, "showDialog", miaVar4, false);
                    }
                }
                miaVar4.z(0);
                return miaVar4;
            }
        }
        return (mia) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.kia
    public tm6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (tm6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kia
    public List<mia> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            mia miaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("showDialog")) {
                miaVar = this.mJsBridge.g(webView, hashMap);
            }
            if (miaVar != null) {
                miaVar.z(0);
            }
            List<lia> list = this.mAsyncCallBackMethodList.get(str);
            if (miaVar != null && list != null) {
                Iterator<lia> it = list.iterator();
                if (!TextUtils.isEmpty(miaVar.e())) {
                    while (it.hasNext()) {
                        lia next = it.next();
                        if (next.b().equals(miaVar.e())) {
                            mia miaVar2 = new mia();
                            miaVar2.w(next.a());
                            miaVar2.y(miaVar.f());
                            miaVar2.u(miaVar.b());
                            miaVar2.o(miaVar.a());
                            miaVar2.j = miaVar.j;
                            miaVar2.A(miaVar.l());
                            arrayList.add(miaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        lia next2 = it.next();
                        mia miaVar3 = new mia();
                        miaVar3.w(next2.a());
                        miaVar3.y(miaVar.f());
                        miaVar3.u(miaVar.b());
                        miaVar3.o(miaVar.a());
                        miaVar3.j = miaVar.j;
                        miaVar3.A(miaVar.l());
                        arrayList.add(miaVar3);
                        if (!next2.c()) {
                            it.remove();
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
