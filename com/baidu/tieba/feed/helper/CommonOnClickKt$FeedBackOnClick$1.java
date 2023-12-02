package com.baidu.tieba.feed.helper;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.model.AttentionModel;
import com.baidu.tieba.R;
import com.baidu.tieba.br6;
import com.baidu.tieba.feed.helper.CommonOnClickKt$FeedBackOnClick$1;
import com.baidu.tieba.l55;
import com.baidu.tieba.ra7;
import com.baidu.tieba.t67;
import com.baidu.tieba.u67;
import com.baidu.tieba.v67;
import com.baidu.tieba.v95;
import com.baidu.tieba.w95;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "data", "Lcom/baidu/tieba/feed/data/FeedFeedbackData;", "view", "Landroid/view/View;", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CommonOnClickKt$FeedBackOnClick$1 extends Lambda implements Function2<t67, View, Unit> {
    public static /* synthetic */ Interceptable $ic;
    public static final CommonOnClickKt$FeedBackOnClick$1 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1066952421, "Lcom/baidu/tieba/feed/helper/CommonOnClickKt$FeedBackOnClick$1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1066952421, "Lcom/baidu/tieba/feed/helper/CommonOnClickKt$FeedBackOnClick$1;");
                return;
            }
        }
        INSTANCE = new CommonOnClickKt$FeedBackOnClick$1();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonOnClickKt$FeedBackOnClick$1() {
        super(2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m135invoke$lambda2(t67 data, View view2, ra7 helper, List reasons, boolean z) {
        JSONObject c;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{data, view2, helper, reasons, Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(view2, "$view");
            Intrinsics.checkNotNullParameter(helper, "$helper");
            if (Intrinsics.areEqual(data.d(), ImageViewerConfig.FROM_CONCERN) && (data.a() instanceof v67)) {
                if (view2.getContext() instanceof TbPageContextSupport) {
                    Context context = view2.getContext();
                    if (context != null) {
                        TbPageContext pageContext = ((TbPageContextSupport) context).getPageContext();
                        if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                            BdUtilHelper.showToast(view2.getContext(), (int) R.string.obfuscated_res_0x7f0f0e70);
                        } else if (ViewHelper.checkUpIsLogin(view2.getContext())) {
                            AttentionModel attentionModel = new AttentionModel(pageContext);
                            Object a = data.a();
                            if (a != null) {
                                String a2 = ((v67) a).a();
                                Object a3 = data.a();
                                if (a3 != null) {
                                    attentionModel.l(false, a2, ((v67) a3).b(), false, "0", pageContext.getUniqueId(), null, "0");
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.data.FeedFeedbackUserData");
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.data.FeedFeedbackUserData");
                            }
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.TbPageContextSupport");
                    }
                }
            } else if ((Intrinsics.areEqual(data.d(), "recommend_post") || Intrinsics.areEqual(data.d(), "frs_post")) && (data.a() instanceof u67)) {
                Object a4 = data.a();
                if (a4 != null) {
                    u67 u67Var = (u67) a4;
                    ArrayList arrayList = new ArrayList();
                    Object a5 = data.a();
                    if (a5 != null) {
                        Intrinsics.checkNotNullExpressionValue(reasons, "reasons");
                        c = CommonOnClickKt.c((u67) a5, arrayList, reasons);
                        helper.j();
                        new l55().a = 1500L;
                        if (c != null && Intrinsics.areEqual("7", c.optString("dislike_ids"))) {
                            string = view2.getContext().getResources().getString(R.string.forbidden_forum_success);
                            Intrinsics.checkNotNullExpressionValue(string, "{\n                      …ss)\n                    }");
                        } else {
                            string = view2.getContext().getResources().getString(R.string.reduce_related_thread_recommend);
                            Intrinsics.checkNotNullExpressionValue(string, "{\n                      …nd)\n                    }");
                        }
                        BdUtilHelper.showToast(view2.getContext(), string);
                        br6.b().c(new v95(arrayList, helper.l(), data));
                        br6.b().c(new w95(data.d(), c));
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.data.FeedFeedbackPostData");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.data.FeedFeedbackPostData");
            }
            c = null;
            br6.b().c(new w95(data.d(), c));
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(t67 t67Var, View view2) {
        invoke2(t67Var, view2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final t67 data, final View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data, view2) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(view2, "view");
            final ra7 ra7Var = new ra7(view2);
            ra7Var.x(true);
            ra7Var.t(data.c());
            ra7Var.v(data.b());
            if ((Intrinsics.areEqual(data.d(), "recommend_post") || Intrinsics.areEqual(data.d(), "frs_post")) && (data.a() instanceof u67)) {
                Object a = data.a();
                if (a != null) {
                    u67 u67Var = (u67) a;
                    ra7Var.q(u67Var.c(), u67Var.b());
                    ra7Var.r(u67Var);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.data.FeedFeedbackPostData");
                }
            }
            ra7Var.u(new ra7.f() { // from class: com.baidu.tieba.pa7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ra7.f
                public final void a(List list, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, list, z) == null) {
                        CommonOnClickKt$FeedBackOnClick$1.m135invoke$lambda2(t67.this, view2, ra7Var, list, z);
                    }
                }
            });
            ra7Var.s(true);
            ra7Var.w(view2);
        }
    }
}
