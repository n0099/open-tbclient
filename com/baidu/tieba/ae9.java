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
/* loaded from: classes5.dex */
public class ae9 extends qd9<h45, AutoVideoCardViewHolder<ThreadData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId c;
    public TbPageContext<?> d;
    public in e;
    public wy f;
    public mp6<ThreadData> g;

    /* loaded from: classes5.dex */
    public class a extends mp6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae9 b;

        public a(ae9 ae9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ae9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                ep6.b().d(true);
                this.b.C(view2, threadData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy a;
        public final /* synthetic */ ae9 b;

        public b(ae9 ae9Var, wy wyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae9Var, wyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ae9Var;
            this.a = wyVar;
        }

        @Override // com.baidu.tieba.ax.a
        public void a(b15 b15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, b15Var) != null) || b15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (b15Var instanceof ThreadData) {
                b15Var.objType = 5;
                ThreadCardUtils.jumpToPB(b15Var, this.b.mContext, 17, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(b15Var, this.b.mContext, 17, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae9 a;

        public c(ae9 ae9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae9Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof h45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                ThreadData threadData = ((h45) cnVar).t;
                threadData.objType = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), threadData);
                }
                Rect a = ex.a((in) viewGroup, view2, i);
                Context context = view2.getContext();
                String q1 = this.a.b.getOrignalPage().q1();
                if (this.a.s()) {
                    str = "3";
                } else {
                    str = "2";
                }
                ThreadCardUtils.jumpToPB(threadData, context, 17, false, a, q1, str);
                autoVideoCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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

    public void F(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, inVar) == null) {
            this.e = inVar;
        }
    }

    public final pz9 B(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData != null) {
                pz9 pz9Var = new pz9();
                pz9Var.a = PayUVEventType.PAY_WALLET_BANNER_SHOW;
                pz9Var.c = threadData.tid;
                pz9Var.f = threadData.mRecomSource;
                pz9Var.g = threadData.mRecomAbTag;
                pz9Var.h = threadData.mRecomWeight;
                pz9Var.i = "14";
                pz9Var.q = String.valueOf(threadData.statFloor);
                if (threadData.getThreadVideoChannelInfo() != null) {
                    pz9Var.k = String.valueOf(threadData.getThreadVideoChannelInfo().a);
                }
                if (threadData.getThreadData() != null) {
                    pz9Var.d = String.valueOf(threadData.getThreadData().getFid());
                    pz9Var.v = threadData.getThreadData().getNid();
                    if (threadData.getThreadData().getThreadVideoInfo() != null) {
                        pz9Var.m = threadData.getThreadData().getThreadVideoInfo().video_md5;
                        pz9Var.p = String.valueOf(threadData.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                pz9Var.e = TbadkCoreApplication.getCurrentAccount();
                if (threadData.getThreadData() != null && threadData.getThreadData().getBaijiahaoData() != null) {
                    pz9Var.t = threadData.getThreadData().getBaijiahaoData().oriUgcNid;
                    pz9Var.u = threadData.getThreadData().getBaijiahaoData().oriUgcVid;
                    return pz9Var;
                }
                return pz9Var;
            }
            return null;
        }
        return (pz9) invokeL.objValue;
    }

    public final void C(View view2, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
            md9.b(this, threadData);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: D */
    public AutoVideoCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.d.getPageActivity(), false);
            gx gxVar = new gx(this.d.getPageActivity());
            gxVar.A(new b(this, gxVar));
            this.f = gxVar;
            gxVar.p(this.c);
            this.f.setFrom("14");
            this.f.setStageType("2001");
            bVar.n(this.f);
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.c);
            k.q(this.g);
            k.s(17);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: E */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, h45 h45Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, h45Var, autoVideoCardViewHolder})) == null) {
            if (h45Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            h45Var.t.statFloor = getPositionByType(i) + 1;
            autoVideoCardViewHolder.a().r(i);
            autoVideoCardViewHolder.x(B(h45Var.t));
            autoVideoCardViewHolder.e(h45Var.t);
            autoVideoCardViewHolder.a().onChangeSkinType(this.d, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.g);
            md9.c(this, h45Var);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
