package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e47 extends cn<v06, ThreadCardViewHolder<v06>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public c17 c;
    public vn d;
    public j06<v06> e;

    /* loaded from: classes3.dex */
    public class a extends j06<v06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e47 b;

        public a(e47 e47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e47Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j06
        /* renamed from: d */
        public void a(View view2, v06 v06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, v06Var) == null) {
                c06.b().d(true);
                if (view2 == null || this.b.c == null || v06Var == null || v06Var.getThreadData() == null || StringUtils.isNull(v06Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !fz6.b(pg.g(v06Var.getThreadData().getTid(), 0L))) {
                    fz6.a(pg.g(v06Var.getThreadData().getTid(), 0L));
                    this.b.c.e(pg.g(v06Var.getThreadData().getTid(), 0L), v06Var.D(), v06Var.r(), v06Var.n(), v06Var.c(), pg.e((String) view2.getTag(), 1), "video_tab", v06Var.getThreadData().getBaijiahaoData());
                }
                this.b.x(view2, v06Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e47 a;

        public b(e47 e47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e47Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (pnVar instanceof v06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                v06 v06Var = (v06) pnVar;
                v06Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), v06Var);
                }
                ThreadCardUtils.jumpToPB((ho4) v06Var, view2.getContext(), 19, false);
                threadCardViewHolder.a().o(new py.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e47(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = new a(this);
        this.b = tbPageContext;
    }

    public void A(vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vnVar) == null) {
            this.d = vnVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: v */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.b.getPageActivity(), false);
            cx cxVar = new cx(this.b.getPageActivity());
            cxVar.u();
            bVar.h(cxVar);
            ey k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.d);
            k.r(19);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, v06 v06Var, ThreadCardViewHolder<v06> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, v06Var, threadCardViewHolder})) == null) {
            if (v06Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || v06Var.a == null) {
                return null;
            }
            v06Var.I(v06Var.position + 1);
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.e(v06Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.e);
            c06.b().a(v06Var.B());
            vl5.c().a(v06Var.B());
            j17.i(v06Var.a, this.a, v06Var.n());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void x(View view2, v06 v06Var) {
        StatisticItem A;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, v06Var) == null) {
            int id = view2.getId();
            if (v06Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09212d || id == R.id.obfuscated_res_0x7f092141) {
                if (v06Var.isVideoThreadType()) {
                    A = v06Var.C();
                } else {
                    A = v06Var.A();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                i = 1;
            } else if (id == R.id.obfuscated_res_0x7f090a75 || id == R.id.obfuscated_res_0x7f090a4d) {
                TiebaStatic.log(v06Var.j());
                i = 9;
            } else {
                i = 0;
            }
            if (i != 0) {
                j17.d(v06Var.a, this.a, v06Var.n(), i);
            }
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void z(c17 c17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c17Var) == null) {
            this.c = c17Var;
        }
    }
}
