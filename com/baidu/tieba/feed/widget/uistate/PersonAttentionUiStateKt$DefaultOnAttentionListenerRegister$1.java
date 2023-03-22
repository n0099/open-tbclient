package com.baidu.tieba.feed.widget.uistate;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.c85;
import com.baidu.tieba.dt6;
import com.baidu.tieba.jh6;
import com.baidu.tieba.kh6;
import com.baidu.tieba.nh6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "state", "Lcom/baidu/tieba/feed/widget/uistate/PersonAttentionUiState;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "tag", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PersonAttentionUiStateKt$DefaultOnAttentionListenerRegister$1 extends Lambda implements Function3<dt6, TbPageContext<?>, Object, Unit> {
    public static /* synthetic */ Interceptable $ic;
    public static final PersonAttentionUiStateKt$DefaultOnAttentionListenerRegister$1 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132787668, "Lcom/baidu/tieba/feed/widget/uistate/PersonAttentionUiStateKt$DefaultOnAttentionListenerRegister$1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2132787668, "Lcom/baidu/tieba/feed/widget/uistate/PersonAttentionUiStateKt$DefaultOnAttentionListenerRegister$1;");
                return;
            }
        }
        INSTANCE = new PersonAttentionUiStateKt$DefaultOnAttentionListenerRegister$1();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonAttentionUiStateKt$DefaultOnAttentionListenerRegister$1() {
        super(3);
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

    /* loaded from: classes4.dex */
    public static final class a extends nh6<c85> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dt6 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dt6 dt6Var, Class<c85> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dt6Var, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nh6
        public void onEvent(c85 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                event.a();
                this.b.d().a();
                throw null;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(dt6 dt6Var, TbPageContext<?> tbPageContext, Object obj) {
        invoke2(dt6Var, tbPageContext, obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(dt6 state, TbPageContext<?> pageContext, Object tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, state, pageContext, tag) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(pageContext, "pageContext");
            Intrinsics.checkNotNullParameter(tag, "tag");
            kh6.b().a(new jh6(pageContext, tag), new a(state, c85.class));
        }
    }
}
