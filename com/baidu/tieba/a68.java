package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a68 extends pm<cq6, ThreadCardViewHolder<cq6>> implements o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public in d;
    public i58 e;
    public NEGFeedBackView.NEGFeedbackEventCallback f;
    public mp6<cq6> g;

    /* loaded from: classes5.dex */
    public class a extends mp6<cq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a68 b;

        public a(a68 a68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, cq6 cq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, cq6Var) == null) {
                ep6.b().d(true);
                if (view2 != null && cq6Var != null && cq6Var.getThreadData() != null && !StringUtils.isNull(cq6Var.getThreadData().getTid())) {
                    this.b.z(view2, cq6Var);
                    sfa.r(CommonStatisticKey.KEY_LIVE_MERGE_CARD_CLICK, cq6Var.getThreadData(), 5);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a68 a;

        public b(a68 a68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a68Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof cq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                cq6 cq6Var = (cq6) cnVar;
                cq6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), cq6Var);
                }
                ThreadCardUtils.jumpToPB((b15) cq6Var, view2.getContext(), 2, false, ex.a((in) viewGroup, view2, i));
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a68(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.g = new a(this);
        this.b = tbPageContext;
        u();
    }

    public void A(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nEGFeedbackEventCallback) == null) {
            this.f = nEGFeedbackEventCallback;
        }
    }

    public void B(i58 i58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i58Var) == null) {
            this.e = i58Var;
        }
    }

    public void C(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inVar) == null) {
            this.d = inVar;
        }
    }

    @Override // com.baidu.tieba.o56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.c = str;
        }
    }

    public final void D(cq6 cq6Var, cq6 cq6Var2) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, cq6Var, cq6Var2) == null) && (threadData = cq6Var2.a) != null && threadData.getForumData() != null && !StringUtils.isNull(cq6Var2.a.getForumData().i())) {
            if (cq6Var != null && (threadData2 = cq6Var.a) != null && threadData2.getTid() != null && cq6Var.a.getForumData() != null && cq6Var.a.getForumData().i() != null && (!cq6Var.a.getTid().equals(cq6Var2.a.getTid()) || !cq6Var.a.getForumData().i().equals(cq6Var2.a.getForumData().i()))) {
                x78.h(cq6Var2.a);
            }
            if (cq6Var == null) {
                x78.h(cq6Var2.a);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            cq6.f1090T = "c10705";
            cq6.U = "c10730";
            cq6.V = "c10731";
            cq6.W = "c10704";
            cq6.X = "c10755";
            cq6.Y = "c10710";
            cq6.Z = "c10736";
            cq6.a0 = "c10737";
            cq6.b0 = "c10711";
            cq6.c0 = "c10758";
            cq6.d0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity());
            bVar.o(new nx(this.b.getPageActivity()));
            oy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, cq6 cq6Var, ThreadCardViewHolder<cq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, cq6Var, threadCardViewHolder})) == null) {
            if (cq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && cq6Var.a != null) {
                if (i == 0) {
                    x9a.a("main", true);
                }
                cq6Var.B(cq6Var.position + 1);
                cq6Var.a.statFloor = cq6Var.h();
                cq6Var.U(i);
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.q(true, Align.ALIGN_RIGHT_TOP, this.f);
                cq6 h = threadCardViewHolder.a().h();
                boolean z = false;
                if (cq6Var.a.getForumData() != null && ((cq6Var.a.getForumData().k() && !cq6Var.a.getForumData().f()) || (cq6Var.a.getForumData().f() && cq6Var.a.getForumData().g()))) {
                    z = true;
                }
                threadCardViewHolder.k(z, true);
                threadCardViewHolder.e(cq6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                ep6.b().a(cq6Var.s());
                m56.c().a(cq6Var.s());
                x78.p(cq6Var.a, this.a, cq6Var.h());
                x78.o(cq6Var.a, cq6Var.i(), cq6Var.h());
                D(h, cq6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(View view2, cq6 cq6Var) {
        int i;
        StatisticItem q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view2, cq6Var) == null) {
            int id = view2.getId();
            if (cq6Var == null) {
                return;
            }
            if (this.e != null && cq6Var.getThreadData() != null && cq6Var.getThreadData().isFromHomPage) {
                this.e.d(cq6Var.G(), cq6Var.getThreadData());
            }
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread && id != R.id.forum_recommend_reason) {
                if (cq6Var.isVideoThreadType()) {
                    q = cq6Var.t();
                } else {
                    q = cq6Var.q();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                m56.c().i("page_recommend", "clk_", q);
                i = 1;
                x78.b(cq6Var.a, cq6Var.i(), cq6Var.h());
            } else {
                TiebaStatic.log(cq6Var.f());
                m56.c().i("page_recommend", "clk_", cq6Var.f());
                i = 9;
            }
            if (i != 0) {
                x78.d(cq6Var.a, this.a, cq6Var.h(), i);
                x78.c(cq6Var.a, cq6Var.i(), cq6Var.h(), 3);
            }
        }
    }
}
