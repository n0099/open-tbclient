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
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fg8 extends ci<zm6, ThreadCardViewHolder<zm6>> implements a26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public vi d;
    public nf8 e;
    public NEGFeedBackView.NEGFeedbackEventCallback f;
    public im6<zm6> g;

    /* loaded from: classes5.dex */
    public class a extends im6<zm6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fg8 b;

        public a(fg8 fg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fg8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im6
        /* renamed from: d */
        public void a(View view2, zm6 zm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zm6Var) == null) {
                am6.b().d(true);
                if (view2 != null && zm6Var != null && zm6Var.getThreadData() != null && !StringUtils.isNull(zm6Var.getThreadData().getTid())) {
                    this.b.A(view2, zm6Var);
                    nua.t(CommonStatisticKey.KEY_LIVE_MERGE_CARD_CLICK, zm6Var.getThreadData(), 5);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fg8 a;

        public b(fg8 fg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fg8Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof zm6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                zm6 zm6Var = (zm6) piVar;
                zm6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), zm6Var);
                }
                if (!o36.a(view2.getContext(), zm6Var.getThreadData())) {
                    ThreadCardUtils.jumpToPB((cw4) zm6Var, view2.getContext(), 2, false, ss.a((vi) viewGroup, view2, i));
                    threadCardViewHolder.a().q(new nu.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fg8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        x();
    }

    public void B(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nEGFeedbackEventCallback) == null) {
            this.f = nEGFeedbackEventCallback;
        }
    }

    public void C(nf8 nf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nf8Var) == null) {
            this.e = nf8Var;
        }
    }

    public void D(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viVar) == null) {
            this.d = viVar;
        }
    }

    @Override // com.baidu.tieba.a26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.c = str;
        }
    }

    public final void A(View view2, zm6 zm6Var) {
        int i;
        StatisticItem q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, zm6Var) == null) {
            int id = view2.getId();
            if (zm6Var == null) {
                return;
            }
            if (this.e != null && zm6Var.getThreadData() != null && zm6Var.getThreadData().isFromHomPage) {
                this.e.d(zm6Var.G(), zm6Var.getThreadData());
            }
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread && id != R.id.forum_recommend_reason) {
                if (zm6Var.isVideoThreadType()) {
                    q = zm6Var.t();
                } else {
                    q = zm6Var.q();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                y16.c().i("page_recommend", "clk_", q);
                i = 1;
                di8.b(zm6Var.a, zm6Var.k(), zm6Var.h());
            } else {
                TiebaStatic.log(zm6Var.f());
                y16.c().i("page_recommend", "clk_", zm6Var.f());
                i = 9;
            }
            if (i != 0) {
                di8.d(zm6Var.a, this.a, zm6Var.h(), i);
                di8.c(zm6Var.a, zm6Var.k(), zm6Var.h(), 3);
            }
        }
    }

    public final void E(zm6 zm6Var, zm6 zm6Var2) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, zm6Var, zm6Var2) == null) && (threadData = zm6Var2.a) != null && threadData.getForumData() != null && !StringUtils.isNull(zm6Var2.a.getForumData().i())) {
            if (zm6Var != null && (threadData2 = zm6Var.a) != null && threadData2.getTid() != null && zm6Var.a.getForumData() != null && zm6Var.a.getForumData().i() != null && (!zm6Var.a.getTid().equals(zm6Var2.a.getTid()) || !zm6Var.a.getForumData().i().equals(zm6Var2.a.getForumData().i()))) {
                di8.h(zm6Var2.a);
            }
            if (zm6Var == null) {
                di8.h(zm6Var2.a);
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            zm6.f1181T = "c10705";
            zm6.U = "c10730";
            zm6.V = "c10731";
            zm6.W = "c10704";
            zm6.X = "c10755";
            zm6.Y = "c10710";
            zm6.Z = "c10736";
            zm6.a0 = "c10737";
            zm6.b0 = "c10711";
            zm6.c0 = "c10758";
            zm6.d0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: y */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.b.getPageActivity());
            bVar.o(new bt(this.b.getPageActivity()));
            cu k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.t(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, zm6 zm6Var, ThreadCardViewHolder<zm6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zm6Var, threadCardViewHolder})) == null) {
            if (zm6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && zm6Var.a != null) {
                if (i == 0) {
                    soa.a("main", true);
                }
                bp5.a.h(this.a);
                zm6Var.B(zm6Var.position + 1);
                zm6Var.a.statFloor = zm6Var.h();
                zm6Var.U(i);
                threadCardViewHolder.a().s(i);
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP, this.f);
                threadCardViewHolder.l(zm6Var.a.isNeedShowFollowForum(), true);
                threadCardViewHolder.e(zm6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.g);
                am6.b().a(zm6Var.s());
                y16.c().a(zm6Var.s());
                di8.p(zm6Var.a, this.a, zm6Var.h());
                di8.o(zm6Var.a, zm6Var.k(), zm6Var.h());
                E(threadCardViewHolder.a().i(), zm6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
