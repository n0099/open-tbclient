package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gx6 extends qn<x26, ThreadCardViewHolder<x26>> implements to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public jo d;
    public NEGFeedBackView.b e;
    public i26<x26> f;

    /* loaded from: classes4.dex */
    public class a extends i26<x26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx6 b;

        public a(gx6 gx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, x26 x26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, x26Var) == null) {
                b26.b().d(true);
                if (view2 == null || x26Var == null || x26Var.getThreadData() == null || StringUtils.isNull(x26Var.getThreadData().getTid())) {
                    return;
                }
                this.b.x(view2, x26Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx6 a;

        public b(gx6 gx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gx6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof x26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                x26 x26Var = (x26) cdo;
                x26Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), x26Var);
                }
                ThreadCardUtils.jumpToPB((yq4) x26Var, view2.getContext(), 2, false, kx.a((jo) viewGroup, view2, i));
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gx6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new a(this);
        this.b = tbPageContext;
        u();
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            x26.R = "c10705";
            x26.S = "c10730";
            x26.T = "c10731";
            x26.U = "c10704";
            x26.V = "c10755";
            x26.W = "c10710";
            x26.X = "c10736";
            x26.Y = "c10737";
            x26.Z = "c10711";
            x26.a0 = "c10758";
            x26.b0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: v */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.b.getPageActivity());
            bVar.o(new sx(this.b.getPageActivity()));
            sy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, x26 x26Var, ThreadCardViewHolder<x26> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, x26Var, threadCardViewHolder})) == null) {
            if (x26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || x26Var.a == null) {
                return null;
            }
            x26Var.I(x26Var.position + 1);
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.a().b(this.c);
            threadCardViewHolder.p(false, Align.ALIGN_RIGHT_TOP, this.e);
            threadCardViewHolder.e(x26Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.f);
            b26.b().a(x26Var.B());
            ro5.c().a(x26Var.B());
            d37.i(x26Var.a, this.a, x26Var.n());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void x(View view2, x26 x26Var) {
        int i;
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, x26Var) == null) {
            int id = view2.getId();
            if (x26Var == null) {
                return;
            }
            if (id != R.id.obfuscated_res_0x7f090a72 && id != R.id.obfuscated_res_0x7f090a71 && id != R.id.obfuscated_res_0x7f090a73 && id != R.id.obfuscated_res_0x7f090a74) {
                if (x26Var.isVideoThreadType()) {
                    A = x26Var.C();
                } else {
                    A = x26Var.A();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                ro5.c().i("page_concern", "clk_", A);
                i = 1;
            } else {
                TiebaStatic.log(x26Var.j());
                ro5.c().i("page_concern", "clk_", x26Var.j());
                i = 9;
            }
            if (i != 0) {
                d37.d(x26Var.a, this.a, x26Var.n(), i);
            }
        }
    }

    public void y(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, joVar) == null) {
            this.d = joVar;
        }
    }
}
