package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.ax;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes3.dex */
public class ah5 extends vg5<yu4, AutoVideoCardViewHolder<yu4>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wy g;
    public h56<yu4> h;

    /* loaded from: classes3.dex */
    public class a extends h56<yu4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah5 b;

        public a(ah5 ah5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h56
        /* renamed from: d */
        public void a(View view2, yu4 yu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yu4Var) == null) {
                this.b.u(view2, yu4Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy a;
        public final /* synthetic */ ah5 b;

        public b(ah5 ah5Var, wy wyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah5Var, wyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah5Var;
            this.a = wyVar;
        }

        @Override // com.baidu.tieba.ax.a
        public void a(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, vr4Var) != null) || vr4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (vr4Var instanceof yu4) {
                vr4Var.objType = 5;
                ThreadCardUtils.jumpToPB(vr4Var, this.b.mContext, this.b.A(), false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(vr4Var, this.b.mContext, this.b.A(), false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah5 a;

        public c(ah5 ah5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ah5Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof yu4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                yu4 yu4Var = (yu4) xnVar;
                yu4Var.objType = 1;
                if (this.a.h != null) {
                    this.a.h.a(autoVideoCardViewHolder.getView(), yu4Var);
                }
                ThreadCardUtils.jumpToPB((vr4) yu4Var, view2.getContext(), this.a.A(), false, ex.a((Cdo) viewGroup, view2, i));
                autoVideoCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah5(TbPageContext<?> tbPageContext) {
        super(tbPageContext, ThreadData.TYPE_VIDEO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
    }

    public final yf8 P(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData != null) {
                yf8 yf8Var = new yf8();
                yf8Var.a = PayUVEventType.PAY_WALLET_BANNER_SHOW;
                yf8Var.c = threadData.tid;
                yf8Var.f = threadData.mRecomSource;
                yf8Var.g = threadData.mRecomAbTag;
                yf8Var.h = threadData.mRecomWeight;
                yf8Var.i = "14";
                yf8Var.q = String.valueOf(threadData.statFloor);
                if (threadData.getThreadVideoChannelInfo() != null) {
                    yf8Var.k = String.valueOf(threadData.getThreadVideoChannelInfo().a);
                }
                if (threadData.getThreadData() != null) {
                    yf8Var.d = String.valueOf(threadData.getThreadData().getFid());
                    yf8Var.v = threadData.getThreadData().getNid();
                    if (threadData.getThreadData().getThreadVideoInfo() != null) {
                        yf8Var.m = threadData.getThreadData().getThreadVideoInfo().video_md5;
                        yf8Var.p = String.valueOf(threadData.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                yf8Var.e = TbadkCoreApplication.getCurrentAccount();
                if (threadData.getThreadData() != null && threadData.getThreadData().getBaijiahaoData() != null) {
                    yf8Var.t = threadData.getThreadData().getBaijiahaoData().oriUgcNid;
                    yf8Var.u = threadData.getThreadData().getBaijiahaoData().oriUgcVid;
                    return yf8Var;
                }
                return yf8Var;
            }
            return null;
        }
        return (yf8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: Q */
    public AutoVideoCardViewHolder<yu4> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity(), false);
            gx gxVar = new gx(this.c.getPageActivity());
            gxVar.y(new b(this, gxVar));
            this.g = gxVar;
            gxVar.A(this.mPageId);
            this.g.x(C());
            this.g.B(D());
            bVar.n(this.g);
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            AutoVideoCardViewHolder<yu4> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.q(this.h);
            k.s(A());
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: R */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, yu4 yu4Var, AutoVideoCardViewHolder<yu4> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yu4Var, autoVideoCardViewHolder})) == null) {
            if (yu4Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            yu4Var.t.statFloor = getPositionByType(i) + 1;
            autoVideoCardViewHolder.a().r(i);
            autoVideoCardViewHolder.u(P(yu4Var.t));
            autoVideoCardViewHolder.e(yu4Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.h);
            L(autoVideoCardViewHolder.getView(), yu4Var.t, i, i);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
