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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mz;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f58 extends ln<kq6, ThreadCardViewHolder<kq6>> implements t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public eo d;
    public o48 e;
    public NEGFeedBackView.b f;
    public up6<kq6> g;

    /* loaded from: classes5.dex */
    public class a extends up6<kq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f58 b;

        public a(f58 f58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, kq6 kq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, kq6Var) == null) {
                np6.b().d(true);
                if (view2 != null && kq6Var != null && kq6Var.getThreadData() != null && !StringUtils.isNull(kq6Var.getThreadData().getTid())) {
                    this.b.z(view2, kq6Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f58 a;

        public b(f58 f58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f58Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof kq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                kq6 kq6Var = (kq6) ynVar;
                kq6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), kq6Var);
                }
                ThreadCardUtils.jumpToPB((t15) kq6Var, view2.getContext(), 2, false, by.a((eo) viewGroup, view2, i));
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f58(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void A(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void B(o48 o48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o48Var) == null) {
            this.e = o48Var;
        }
    }

    public void C(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eoVar) == null) {
            this.d = eoVar;
        }
    }

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.c = str;
        }
    }

    public final void D(kq6 kq6Var, kq6 kq6Var2) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, kq6Var, kq6Var2) == null) && (threadData = kq6Var2.a) != null && threadData.getForumData() != null && !StringUtils.isNull(kq6Var2.a.getForumData().i())) {
            if (kq6Var != null && (threadData2 = kq6Var.a) != null && threadData2.getTid() != null && kq6Var.a.getForumData() != null && kq6Var.a.getForumData().i() != null && (!kq6Var.a.getTid().equals(kq6Var2.a.getTid()) || !kq6Var.a.getForumData().i().equals(kq6Var2.a.getForumData().i()))) {
                x68.h(kq6Var2.a);
            }
            if (kq6Var == null) {
                x68.h(kq6Var2.a);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            kq6.f1135T = "c10705";
            kq6.U = "c10730";
            kq6.V = "c10731";
            kq6.W = "c10704";
            kq6.X = "c10755";
            kq6.Y = "c10710";
            kq6.Z = "c10736";
            kq6.a0 = "c10737";
            kq6.b0 = "c10711";
            kq6.c0 = "c10758";
            kq6.d0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity());
            bVar.o(new ky(this.b.getPageActivity()));
            mz k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, kq6 kq6Var, ThreadCardViewHolder<kq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, kq6Var, threadCardViewHolder})) == null) {
            if (kq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && kq6Var.a != null) {
                if (i == 0) {
                    e5a.a("main", true);
                }
                kq6Var.B(kq6Var.position + 1);
                kq6Var.a.statFloor = kq6Var.h();
                kq6Var.a0(i);
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.b().b(this.c);
                threadCardViewHolder.r(true, Align.ALIGN_RIGHT_TOP, this.f);
                kq6 h = threadCardViewHolder.b().h();
                boolean z = false;
                if (kq6Var.a.getForumData() != null && ((kq6Var.a.getForumData().j() && !kq6Var.a.getForumData().f()) || (kq6Var.a.getForumData().f() && kq6Var.a.getForumData().g()))) {
                    z = true;
                }
                threadCardViewHolder.l(z, true);
                threadCardViewHolder.f(kq6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.g);
                np6.b().a(kq6Var.r());
                r66.c().a(kq6Var.r());
                x68.p(kq6Var.a, this.a, kq6Var.h());
                x68.o(kq6Var.a, kq6Var.i(), kq6Var.h());
                D(h, kq6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(View view2, kq6 kq6Var) {
        int i;
        StatisticItem p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view2, kq6Var) == null) {
            int id = view2.getId();
            if (kq6Var == null) {
                return;
            }
            if (this.e != null && kq6Var.getThreadData() != null && kq6Var.getThreadData().isFromHomPage) {
                this.e.d(kq6Var.J(), kq6Var.getThreadData());
            }
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread && id != R.id.forum_recommend_reason) {
                if (kq6Var.isVideoThreadType()) {
                    p = kq6Var.t();
                } else {
                    p = kq6Var.p();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(p));
                r66.c().i("page_recommend", "clk_", p);
                i = 1;
                x68.b(kq6Var.a, kq6Var.i(), kq6Var.h());
            } else {
                TiebaStatic.log(kq6Var.f());
                r66.c().i("page_recommend", "clk_", kq6Var.f());
                i = 9;
            }
            if (i != 0) {
                x68.d(kq6Var.a, this.a, kq6Var.h(), i);
                x68.c(kq6Var.a, kq6Var.i(), kq6Var.h(), 3);
            }
        }
    }
}
