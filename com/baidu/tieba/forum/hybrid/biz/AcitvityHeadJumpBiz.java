package com.baidu.tieba.forum.hybrid.biz;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.common.JSONKt;
import com.baidu.tieba.fk7;
import com.baidu.tieba.forum.hybrid.manager.BizBase;
import com.baidu.tieba.forum.hybrid.manager.WrapListener;
import com.baidu.tieba.hx4;
import com.baidu.tieba.jy5;
import com.baidu.tieba.kx4;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.rd;
import com.baidu.tieba.rk7;
import com.baidu.tieba.xyc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0012"}, d2 = {"Lcom/baidu/tieba/forum/hybrid/biz/AcitvityHeadJumpBiz;", "Lcom/baidu/tieba/forum/hybrid/manager/BizBase;", "Lcom/baidu/tieba/forum/hybrid/manager/Clean;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;)V", "keyListeners", "", "Lcom/baidu/tieba/forum/hybrid/manager/WrapListener;", "()[Lcom/baidu/tieba/forum/hybrid/manager/WrapListener;", MissionEvent.MESSAGE_DESTROY, "", "onFrsAcitvityHeadJump", "data", "", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AcitvityHeadJumpBiz extends BizBase implements rk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.rk7
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcitvityHeadJumpBiz(TbPageContext<BaseFragmentActivity> pageContext, TbWebView webView) {
        super(pageContext, webView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(webView, "webView");
    }

    @Override // com.baidu.tieba.qk7
    public WrapListener[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new WrapListener[]{e().invoke("frsPage.activityHeadJump", new AcitvityHeadJumpBiz$keyListeners$1(this))} : (WrapListener[]) invokeV.objValue;
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            final hx4 hx4Var = new hx4();
            try {
                JSONKt.a(str, new Function1<JSONObject, Unit>(hx4Var) { // from class: com.baidu.tieba.forum.hybrid.biz.AcitvityHeadJumpBiz$onFrsAcitvityHeadJump$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ hx4 $forumActivityHeadData;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {hx4Var};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$forumActivityHeadData = hx4Var;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                        invoke2(jSONObject);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(JSONObject it) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            this.$forumActivityHeadData.d(xyc.b(it), 0L);
                        }
                    }
                });
            } catch (Exception unused) {
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.e("BusinessPromotBiz", "头图点击数据解析失败: " + str);
            }
            kx4 kx4Var = (kx4) ListUtils.getItem(hx4Var.b(), 0);
            if (kx4Var != null && !jy5.a(f().getContext(), kx4Var.f()) && !TextUtils.isEmpty(kx4Var.e())) {
                if (rd.isEquals(TbadkCoreApplication.getInst().getPackageName(), kx4Var.g()) && !StringUtils.isNull(kx4Var.i())) {
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<BaseFragmentActivity> f = f();
                    String i = kx4Var.i();
                    Intrinsics.checkNotNullExpressionValue(i, "forumHeadImageData.getSchema()");
                    urlManager.dealOneLink(f, new String[]{i});
                    return;
                }
                fk7.b(f(), kx4Var.i(), kx4Var.e(), kx4Var.g());
            }
        }
    }
}
