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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.gx;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes3.dex */
public class br7 extends rq7<bu4, AutoVideoCardViewHolder<ThreadData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId c;
    public TbPageContext<?> d;
    public jo e;
    public az f;
    public i26<ThreadData> g;

    /* loaded from: classes3.dex */
    public class a extends i26<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ br7 b;

        public a(br7 br7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {br7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = br7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                b26.b().d(true);
                this.b.A(view2, threadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements gx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az a;
        public final /* synthetic */ br7 b;

        public b(br7 br7Var, az azVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {br7Var, azVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = br7Var;
            this.a = azVar;
        }

        @Override // com.baidu.tieba.gx.a
        public void a(yq4 yq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, yq4Var) == null) || yq4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(yq4Var instanceof ThreadData)) {
                ThreadCardUtils.jumpToPB(yq4Var, this.b.mContext, 17, false, computeViewArea);
                return;
            }
            yq4Var.objType = 5;
            ThreadCardUtils.jumpToPB(yq4Var, this.b.mContext, 17, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ br7 a;

        public c(br7 br7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {br7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = br7Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof bu4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                ThreadData threadData = ((bu4) cdo).t;
                threadData.objType = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB(threadData, view2.getContext(), 17, false, kx.a((jo) viewGroup, view2, i), this.a.b.getOrignalPage().B1(), this.a.s() ? "3" : "2");
                autoVideoCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
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
        this.g = new a(this);
        this.d = tbPageContext;
        this.c = bdUniqueId2;
    }

    public final void A(View view2, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, threadData) == null) {
            oq7.b(this, threadData);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: B */
    public AutoVideoCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.d.getPageActivity(), false);
            mx mxVar = new mx(this.d.getPageActivity());
            mxVar.v(new b(this, mxVar));
            this.f = mxVar;
            mxVar.x(this.c);
            this.f.u("14");
            this.f.y("2001");
            bVar.n(this.f);
            sy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.c);
            k.p(this.g);
            k.r(17);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bu4 bu4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bu4Var, autoVideoCardViewHolder})) == null) {
            if (bu4Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            bu4Var.t.statFloor = getPositionByType(i) + 1;
            autoVideoCardViewHolder.a().q(i);
            autoVideoCardViewHolder.u(z(bu4Var.t));
            autoVideoCardViewHolder.e(bu4Var.t);
            autoVideoCardViewHolder.a().onChangeSkinType(this.d, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            oq7.c(this, bu4Var);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void D(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, joVar) == null) {
            this.e = joVar;
        }
    }

    public final ab8 z(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, threadData)) == null) {
            if (threadData != null) {
                ab8 ab8Var = new ab8();
                ab8Var.a = PayUVEventType.PAY_WALLET_BANNER_SHOW;
                ab8Var.c = threadData.tid;
                ab8Var.f = threadData.mRecomSource;
                ab8Var.g = threadData.mRecomAbTag;
                ab8Var.h = threadData.mRecomWeight;
                ab8Var.i = "14";
                ab8Var.q = String.valueOf(threadData.statFloor);
                if (threadData.getThreadVideoChannelInfo() != null) {
                    ab8Var.k = String.valueOf(threadData.getThreadVideoChannelInfo().a);
                }
                if (threadData.getThreadData() != null) {
                    ab8Var.d = String.valueOf(threadData.getThreadData().getFid());
                    ab8Var.v = threadData.getThreadData().getNid();
                    if (threadData.getThreadData().getThreadVideoInfo() != null) {
                        ab8Var.m = threadData.getThreadData().getThreadVideoInfo().video_md5;
                        ab8Var.p = String.valueOf(threadData.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                ab8Var.e = TbadkCoreApplication.getCurrentAccount();
                if (threadData.getThreadData() == null || threadData.getThreadData().getBaijiahaoData() == null) {
                    return ab8Var;
                }
                ab8Var.t = threadData.getThreadData().getBaijiahaoData().oriUgcNid;
                ab8Var.u = threadData.getThreadData().getBaijiahaoData().oriUgcVid;
                return ab8Var;
            }
            return null;
        }
        return (ab8) invokeL.objValue;
    }
}
