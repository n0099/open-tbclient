package com.baidu.tieba;

import android.content.Context;
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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.tieba.zw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes4.dex */
public class g27 extends y17<vu4, AutoVideoCardViewHolder<ThreadData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vy e;
    public z36<ThreadData> f;

    /* loaded from: classes4.dex */
    public class a extends z36<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g27 b;

        public a(g27 g27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                this.b.s(view2, threadData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements zw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ g27 b;

        public b(g27 g27Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g27Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g27Var;
            this.a = vyVar;
        }

        @Override // com.baidu.tieba.zw.a
        public void a(rr4 rr4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, rr4Var) != null) || rr4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (rr4Var instanceof ThreadData) {
                rr4Var.objType = 5;
                ThreadCardUtils.jumpToPB(rr4Var, this.b.mContext, 0, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(rr4Var, this.b.mContext, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g27 a;

        public c(g27 g27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g27Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (wnVar instanceof vu4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                ThreadData threadData = ((vu4) wnVar).t;
                threadData.objType = 1;
                if (this.a.f != null) {
                    this.a.f.a(autoVideoCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((rr4) threadData, view2.getContext(), 0, false, dx.a((co) viewGroup, view2, i));
                autoVideoCardViewHolder.a().o(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g27(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), ThreadData.TYPE_VIDEO);
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
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
    }

    public final uc8 A(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData != null) {
                uc8 uc8Var = new uc8();
                uc8Var.a = PayUVEventType.PAY_WALLET_BANNER_SHOW;
                uc8Var.c = threadData.tid;
                uc8Var.f = threadData.mRecomSource;
                uc8Var.g = threadData.mRecomAbTag;
                uc8Var.h = threadData.mRecomWeight;
                uc8Var.i = "14";
                uc8Var.q = String.valueOf(threadData.statFloor);
                if (threadData.getThreadVideoChannelInfo() != null) {
                    uc8Var.k = String.valueOf(threadData.getThreadVideoChannelInfo().a);
                }
                if (threadData.getThreadData() != null) {
                    uc8Var.d = String.valueOf(threadData.getThreadData().getFid());
                    uc8Var.v = threadData.getThreadData().getNid();
                    if (threadData.getThreadData().getThreadVideoInfo() != null) {
                        uc8Var.m = threadData.getThreadData().getThreadVideoInfo().video_md5;
                        uc8Var.p = String.valueOf(threadData.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                uc8Var.e = TbadkCoreApplication.getCurrentAccount();
                if (threadData.getThreadData() != null && threadData.getThreadData().getBaijiahaoData() != null) {
                    uc8Var.t = threadData.getThreadData().getBaijiahaoData().oriUgcNid;
                    uc8Var.u = threadData.getThreadData().getBaijiahaoData().oriUgcVid;
                    return uc8Var;
                }
                return uc8Var;
            }
            return null;
        }
        return (uc8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: B */
    public AutoVideoCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity(), false);
            fx fxVar = new fx(this.b.getPageActivity());
            fxVar.y(new b(this, fxVar));
            this.e = fxVar;
            fxVar.A(this.mPageId);
            this.e.x("14");
            this.e.B("2001");
            bVar.n(this.e);
            ny k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.p(this.f);
            k.r(0);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y17, com.baidu.tieba.jn
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, vu4 vu4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vu4Var, autoVideoCardViewHolder})) == null) {
            if (vu4Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            vu4Var.t.statFloor = getPositionByType(i) + 1;
            autoVideoCardViewHolder.a().q(i);
            autoVideoCardViewHolder.u(A(vu4Var.t));
            autoVideoCardViewHolder.e(vu4Var.t);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.f);
            w(autoVideoCardViewHolder.getView(), vu4Var.t, i, i);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
