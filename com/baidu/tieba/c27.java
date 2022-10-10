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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.jx;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c27 extends lw6<x26, ThreadCardViewHolder<x26>> implements to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public y27 d;
    public String e;
    public jo f;
    public NEGFeedBackView.b g;
    public i26<x26> h;

    /* loaded from: classes3.dex */
    public class a extends i26<x26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c27 b;

        public a(c27 c27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, x26 x26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, x26Var) == null) {
                b26.b().d(true);
                ro5.c().h("page_recommend", "show_");
                if (view2 == null || this.b.d == null || x26Var == null || x26Var.getThreadData() == null || StringUtils.isNull(x26Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !c17.b(dh.g(x26Var.getThreadData().getTid(), 0L))) {
                    c17.a(dh.g(x26Var.getThreadData().getTid(), 0L));
                    this.b.d.e(dh.g(x26Var.getThreadData().getTid(), 0L), x26Var.D(), x26Var.r(), x26Var.n(), x26Var.c(), dh.e((String) view2.getTag(), 1), "homepage", x26Var.getThreadData().getBaijiahaoData());
                }
                this.b.A(view2, x26Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements jx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c27 c27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jx.b
        public void a(yq4 yq4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, yq4Var, view2) == null) || yq4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b7) {
                yq4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092489) {
                yq4Var.objType = 4;
            } else {
                yq4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c27 a;

        public c(c27 c27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c27Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof x26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                x26 x26Var = (x26) cdo;
                x26Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), x26Var);
                }
                if (e37.a(this.a.c, x26Var)) {
                    return;
                }
                ThreadCardUtils.jumpToPB((yq4) x26Var, view2.getContext(), 2, false, kx.a((jo) viewGroup, view2, i));
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c27(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.h = new a(this);
        this.c = tbPageContext;
        x();
    }

    public final void A(View view2, x26 x26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, x26Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() == R.id.obfuscated_res_0x7f092181 || id == R.id.obfuscated_res_0x7f092195) {
                if (y26.R(x26Var.a)) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(x26Var.C()));
                } else {
                    TiebaStatic.log(x26Var.A());
                }
                ro5.c().i("page_recommend", "clk_", x26Var.A());
                d37.c(x26Var.a, x26Var.r(), x26Var.n(), 1);
                i = 1;
            } else {
                if (id == R.id.obfuscated_res_0x7f092489) {
                    TiebaStatic.log(x26Var.S());
                    ro5.c().i("page_recommend", "clk_", x26Var.S());
                    d37.c(x26Var.a, x26Var.r(), x26Var.n(), 4);
                } else if (id == R.id.obfuscated_res_0x7f0924b7) {
                    TiebaStatic.log(x26Var.S());
                    ro5.c().i("page_recommend", "clk_", x26Var.S());
                    d37.c(x26Var.a, x26Var.r(), x26Var.n(), 4);
                } else if (id == R.id.obfuscated_res_0x7f090a8f) {
                    TiebaStatic.log(x26Var.j());
                    ro5.c().i("page_recommend", "clk_", x26Var.j());
                    i = 9;
                } else {
                    if (id == R.id.obfuscated_res_0x7f090cd4) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        d37.c(x26Var.a, x26Var.r(), x26Var.n(), 1);
                    } else if (id != R.id.obfuscated_res_0x7f090cd7 && id != R.id.obfuscated_res_0x7f090cd8) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f090cd5) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(x26Var.P());
                            ro5.c().i("page_recommend", "clk_", x26Var.P());
                            d37.c(x26Var.a, x26Var.r(), x26Var.n(), 2);
                        } else {
                            i = 0;
                        }
                    } else {
                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                        statisticItem3.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem3);
                    }
                    i = 5;
                }
                i = 2;
            }
            if (i != 0) {
                d37.d(x26Var.a, this.b, x26Var.n(), i);
            }
        }
    }

    public void B(y27 y27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y27Var) == null) {
            this.d = y27Var;
        }
    }

    public void C(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, joVar) == null) {
            this.f = joVar;
        }
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.e = str;
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
            x26.e0 = "c10734";
            x26.f0 = "c10708";
            x26.g0 = "c10735";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: y */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.c.getPageActivity());
            jx jxVar = new jx(this.c.getPageActivity());
            jxVar.u(this.b);
            jxVar.d(1024);
            jxVar.t(new b(this));
            jxVar.w(this.c);
            bVar.o(jxVar);
            sy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.f);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, x26 x26Var, ThreadCardViewHolder<x26> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, x26Var, threadCardViewHolder})) == null) {
            if (x26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || x26Var.a == null) {
                return null;
            }
            x26Var.I(x26Var.position + 1);
            x26Var.a.statFloor = x26Var.n();
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.a().b(this.e);
            threadCardViewHolder.p(true, Align.ALIGN_RIGHT_TOP, this.g);
            threadCardViewHolder.l(x26Var.showFollowBtn(), this.a, true);
            threadCardViewHolder.e(x26Var);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.h);
            b26.b().a(x26Var.B());
            ro5.c().a(x26Var.B());
            d37.i(x26Var.a, this.b, x26Var.n());
            d37.h(x26Var.a, x26Var.r(), x26Var.n());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
