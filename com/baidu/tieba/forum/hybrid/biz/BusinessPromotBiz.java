package com.baidu.tieba.forum.hybrid.biz;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.forum.hybrid.manager.BizBase;
import com.baidu.tieba.forum.hybrid.manager.WrapListener;
import com.baidu.tieba.fqa;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.m0b;
import com.baidu.tieba.muc;
import com.baidu.tieba.ui7;
import com.baidu.tieba.xx5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\nH\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/forum/hybrid/biz/BusinessPromotBiz;", "Lcom/baidu/tieba/forum/hybrid/manager/BizBase;", "Lcom/baidu/tieba/forum/hybrid/manager/Clean;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;)V", "businessPromotJump", "", "data", "", "keyListeners", "", "Lcom/baidu/tieba/forum/hybrid/manager/WrapListener;", "()[Lcom/baidu/tieba/forum/hybrid/manager/WrapListener;", MissionEvent.MESSAGE_DESTROY, "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BusinessPromotBiz extends BizBase implements ui7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-677011616, "Lcom/baidu/tieba/forum/hybrid/biz/BusinessPromotBiz;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-677011616, "Lcom/baidu/tieba/forum/hybrid/biz/BusinessPromotBiz;");
        }
    }

    @Override // com.baidu.tieba.ui7
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BusinessPromotBiz(TbPageContext<BaseFragmentActivity> pageContext, TbWebView webView) {
        super(pageContext, webView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.tieba.ti7
    public WrapListener[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new WrapListener[]{e().invoke("frsPage.businessPromotJump", new BusinessPromotBiz$keyListeners$1(this))} : (WrapListener[]) invokeV.objValue;
    }

    public final void n(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            fqa fqaVar = new fqa();
            try {
                fqaVar.t(muc.b(new JSONObject(str)));
            } catch (Exception unused) {
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.e("BusinessPromotBiz", "平台推广区域数据解析失败: " + str);
            }
            String q = fqaVar.q();
            Intrinsics.checkNotNullExpressionValue(q, "promotData.url");
            if (q.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            if (!xx5.a(f().getPageActivity(), fqaVar.i()) && !UtilHelper.isMatchScheme(f().getPageActivity().getBaseContext(), fqaVar.k(), fqaVar.j()) && fqaVar.q() != null) {
                m0b.a(f(), fqaVar.q());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", fqaVar.c());
            MessageManager.getInstance().sendMessage(httpMessage);
            List<String> l = fqaVar.l();
            Intrinsics.checkNotNullExpressionValue(l, "promotData.thirdStatisticUrlList");
            ThirdStatisticHelper.sendReq((String) CollectionsKt___CollectionsKt.getOrNull(l, 1));
        }
    }
}
