package com.baidu.tieba.compact;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.CardPeiWanView;
import com.baidu.tieba.c67;
import com.baidu.tieba.i77;
import com.baidu.tieba.vc7;
import com.baidu.tieba.w97;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/tieba/compact/CardPeiWanViewImpl;", "Lcom/baidu/tieba/feed/compat/Resolver$ICardPeiWanWrapperView;", "()V", "create", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "onSkinChange", "", "view", StickerDataChangeType.UPDATE, "state", "Lcom/baidu/tieba/feed/component/uistate/CardPeiWanUiState;", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardPeiWanViewImpl implements c67.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CardPeiWanViewImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.c67.s
    public void a(ViewGroup view2) {
        CardPeiWanView cardPeiWanView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            if (view2 instanceof CardPeiWanView) {
                cardPeiWanView = (CardPeiWanView) view2;
            } else {
                cardPeiWanView = null;
            }
            if (cardPeiWanView == null) {
                return;
            }
            cardPeiWanView.onChangeSkinType(null, TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.c67.f
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new CardPeiWanView(context, null, 0, 6, null);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.c67.f
    public void update(ViewGroup view2, final i77 state) {
        CardPeiWanView cardPeiWanView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, state) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(state, "state");
            if (view2 instanceof CardPeiWanView) {
                cardPeiWanView = (CardPeiWanView) view2;
            } else {
                cardPeiWanView = null;
            }
            if (cardPeiWanView == null) {
                return;
            }
            w97 i = state.i();
            if (i != null) {
                vc7.a.b(i, state.g() + 1);
                state.f().invoke(i);
            }
            cardPeiWanView.setData(state.j(), new Function0<Unit>(state) { // from class: com.baidu.tieba.compact.CardPeiWanViewImpl$update$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ i77 $state;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {state};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$state = state;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    w97 h;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (h = this.$state.h()) != null) {
                        i77 i77Var = this.$state;
                        vc7.a.b(h, i77Var.g() + 1);
                        i77Var.f().invoke(h);
                    }
                }
            }, new Function0<Unit>(state) { // from class: com.baidu.tieba.compact.CardPeiWanViewImpl$update$3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ i77 $state;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {state};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$state = state;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    w97 k;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (k = this.$state.k()) != null) {
                        i77 i77Var = this.$state;
                        vc7.a.b(k, i77Var.g() + 1);
                        i77Var.f().invoke(k);
                    }
                }
            });
        }
    }
}
