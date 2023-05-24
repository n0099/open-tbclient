package com.baidu.tieba.feed.helper;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.feed.helper.CommonOnClickKt$FeedBackOnClick$1;
import com.baidu.tieba.hb5;
import com.baidu.tieba.jn6;
import com.baidu.tieba.k07;
import com.baidu.tieba.k27;
import com.baidu.tieba.l07;
import com.baidu.tieba.ri;
import com.baidu.tieba.sb5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "data", "Lcom/baidu/tieba/feed/data/FeedFeedbackData;", "view", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CommonOnClickKt$FeedBackOnClick$1 extends Lambda implements Function2<k07, View, Unit> {
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

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m79invoke$lambda0(k07 data, View view2, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{data, view2, list, Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(view2, "$view");
            if (Intrinsics.areEqual(data.getType(), ImageViewerConfig.FROM_CONCERN) && (data.a() instanceof l07) && (view2.getContext() instanceof TbPageContextSupport)) {
                Context context = view2.getContext();
                if (context != null) {
                    TbPageContext pageContext = ((TbPageContextSupport) context).getPageContext();
                    if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                        ri.P(view2.getContext(), R.string.obfuscated_res_0x7f0f0db6);
                    } else if (ViewHelper.checkUpIsLogin(view2.getContext())) {
                        sb5 sb5Var = new sb5(pageContext);
                        Object a = data.a();
                        if (a != null) {
                            String a2 = ((l07) a).a();
                            Object a3 = data.a();
                            if (a3 != null) {
                                sb5Var.i(false, a2, ((l07) a3).b(), false, "0", pageContext.getUniqueId(), null, "0");
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
            jn6.b().b(new hb5(data.getType()));
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(k07 k07Var, View view2) {
        invoke2(k07Var, view2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final k07 data, final View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data, view2) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(view2, "view");
            k27 k27Var = new k27(view2);
            k27Var.t(true);
            k27Var.p(data.c());
            k27Var.r(data.b());
            k27Var.q(new k27.f() { // from class: com.baidu.tieba.j27
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.k27.f
                public final void a(List list, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, list, z) == null) {
                        CommonOnClickKt$FeedBackOnClick$1.m79invoke$lambda0(k07.this, view2, list, z);
                    }
                }
            });
            k27Var.o(true);
            k27Var.s(view2);
        }
    }
}
