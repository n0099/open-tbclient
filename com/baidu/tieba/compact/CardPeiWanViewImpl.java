package com.baidu.tieba.compact;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.CardPeiWanView;
import com.baidu.tieba.b47;
import com.baidu.tieba.sm6;
import com.baidu.tieba.t27;
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
import tbclient.Voice;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/baidu/tieba/compact/CardPeiWanViewImpl;", "Lcom/baidu/tieba/feed/compat/Resolver$ICardPeiWanWrapperView;", "()V", "clickStatistic", "", "state", "Lcom/baidu/tieba/feed/component/uistate/CardPeiWanUiState;", "isVoice", "", "create", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "onSkinChange", "view", "showStat", StickerDataChangeType.UPDATE, "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardPeiWanViewImpl implements t27.f {
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

    @Override // com.baidu.tieba.t27.s
    public void b(ViewGroup view2) {
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

    @Override // com.baidu.tieba.t27.f
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new CardPeiWanView(context, null, 0, 6, null);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.t27.f
    public void f(ViewGroup view2, final b47 state) {
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
            if (state.l() != null) {
                n(state);
            }
            cardPeiWanView.setData(state.m(), new Function0<Unit>(this, state) { // from class: com.baidu.tieba.compact.CardPeiWanViewImpl$update$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b47 $state;
                public final /* synthetic */ CardPeiWanViewImpl this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, state};
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
                    this.this$0 = this;
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.m(this.$state, false);
                    }
                }
            }, new Function0<Unit>(this, state) { // from class: com.baidu.tieba.compact.CardPeiWanViewImpl$update$3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b47 $state;
                public final /* synthetic */ CardPeiWanViewImpl this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, state};
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
                    this.this$0 = this;
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.m(this.$state, true);
                    }
                }
            });
        }
    }

    public final void m(b47 b47Var, boolean z) {
        String str;
        boolean z2;
        Long l;
        Long l2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, b47Var, z) == null) {
            String str2 = b47Var.f().get("feed_social_source");
            if (str2 == null) {
                str2 = "1";
            }
            if (z) {
                if (Intrinsics.areEqual(str2, "1")) {
                    str = CommonStatisticKey.KEY_HOME_PEI_WAN_VOICE_CLICK;
                } else {
                    if (Intrinsics.areEqual(str2, "2")) {
                        str = CommonStatisticKey.KEY_FRS_HOT_PEI_WAN_VOICE_CLICK;
                    }
                    str = "";
                }
            } else if (Intrinsics.areEqual(str2, "1")) {
                str = CommonStatisticKey.KEY_HOME_PEI_WAN_CARD_CLICK;
            } else {
                if (Intrinsics.areEqual(str2, "2")) {
                    str = CommonStatisticKey.KEY_FRS_HOT_PEI_WAN_CARD_CLICK;
                }
                str = "";
            }
            sm6 m = b47Var.m();
            if (str.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                StatisticItem statisticItem = new StatisticItem(str);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.addParam("obj_locate", b47Var.k() + 1);
                statisticItem.addParam(TiebaStatic.Params.OBJ_TO, m.e());
                String str3 = null;
                if (z) {
                    Voice i = m.i();
                    if (i != null) {
                        l2 = i.uid;
                    } else {
                        l2 = null;
                    }
                    statisticItem.addParam("obj_id", String.valueOf(l2));
                }
                statisticItem.addParam("obj_param1", 1);
                ThreadData threadData = m.getThreadData();
                if (threadData != null) {
                    l = Long.valueOf(threadData.getFid());
                } else {
                    l = null;
                }
                statisticItem.addParam("fid", String.valueOf(l));
                ThreadData threadData2 = m.getThreadData();
                if (threadData2 != null) {
                    str3 = threadData2.getForum_name();
                }
                statisticItem.addParam("fname", str3);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public final void n(b47 b47Var) {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b47Var) == null) {
            sm6 m = b47Var.m();
            StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_FRS_HOT_PEI_WAN_CARD_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("obj_locate", b47Var.k() + 1).addParam(TiebaStatic.Params.OBJ_TO, String.valueOf(m.e())).addParam("obj_param1", 1);
            ThreadData threadData = m.getThreadData();
            String str = null;
            if (threadData != null) {
                l = Long.valueOf(threadData.getFid());
            } else {
                l = null;
            }
            StatisticItem addParam2 = addParam.addParam("fid", String.valueOf(l));
            ThreadData threadData2 = m.getThreadData();
            if (threadData2 != null) {
                str = threadData2.getForum_name();
            }
            TiebaStatic.log(addParam2.addParam("fname", str));
        }
    }
}
