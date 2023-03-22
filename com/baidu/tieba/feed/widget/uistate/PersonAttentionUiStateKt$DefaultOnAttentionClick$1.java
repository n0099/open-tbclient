package com.baidu.tieba.feed.widget.uistate;

import android.util.Log;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.dt6;
import com.baidu.tieba.hi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "state", "Lcom/baidu/tieba/feed/widget/uistate/PersonAttentionUiState;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PersonAttentionUiStateKt$DefaultOnAttentionClick$1 extends Lambda implements Function2<dt6, TbPageContext<?>, Unit> {
    public static /* synthetic */ Interceptable $ic;
    public static final PersonAttentionUiStateKt$DefaultOnAttentionClick$1 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-224076239, "Lcom/baidu/tieba/feed/widget/uistate/PersonAttentionUiStateKt$DefaultOnAttentionClick$1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-224076239, "Lcom/baidu/tieba/feed/widget/uistate/PersonAttentionUiStateKt$DefaultOnAttentionClick$1;");
                return;
            }
        }
        INSTANCE = new PersonAttentionUiStateKt$DefaultOnAttentionClick$1();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonAttentionUiStateKt$DefaultOnAttentionClick$1() {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(dt6 dt6Var, TbPageContext<?> tbPageContext) {
        invoke2(dt6Var, tbPageContext);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(dt6 state, TbPageContext<?> pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, state, pageContext) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            Log.d("PersonAttentionUiState", "DefaultOnAttentionClick");
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                hi.P(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0d1f);
            } else if (!ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst().getContext())) {
            } else {
                state.d().b();
                throw null;
            }
        }
    }
}
