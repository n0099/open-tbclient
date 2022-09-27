package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.gx;
import com.baidu.tieba.jx;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b27 extends lw6<x26, ThreadCardViewHolder<x26>> implements to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.b d;
    public String e;
    public jo f;
    public i26<x26> g;

    /* loaded from: classes3.dex */
    public class a extends i26<x26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b27 b;

        public a(b27 b27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, x26 x26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, x26Var) == null) {
                int i = 1;
                b26.b().d(true);
                ro5.c().h("page_recommend", "show_");
                if (view2 == null || x26Var == null || x26Var.getThreadData() == null || StringUtils.isNull(x26Var.getThreadData().getTid())) {
                    return;
                }
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f092180 || id == R.id.obfuscated_res_0x7f092194) {
                    TiebaStatic.log(x26Var.Q("c12642"));
                    ro5.c().i("page_recommend", "clk_", x26Var.A());
                    d37.c(x26Var.a, x26Var.r(), x26Var.n(), 1);
                } else {
                    if (id == R.id.obfuscated_res_0x7f092182) {
                        TiebaStatic.log(x26Var.T());
                        ro5.c().i("page_recommend", "clk_", x26Var.T());
                    } else {
                        if (id == R.id.obfuscated_res_0x7f092488) {
                            TiebaStatic.log(x26Var.S());
                            ro5.c().i("page_recommend", "clk_", x26Var.S());
                            d37.c(x26Var.a, x26Var.r(), x26Var.n(), 4);
                        } else if (id == R.id.obfuscated_res_0x7f0924b6) {
                            TiebaStatic.log(x26Var.S());
                            ro5.c().i("page_recommend", "clk_", x26Var.S());
                            d37.c(x26Var.a, x26Var.r(), x26Var.n(), 4);
                        } else if (id == R.id.obfuscated_res_0x7f090a8f) {
                            TiebaStatic.log(x26Var.j());
                            ro5.c().i("page_recommend", "clk_", x26Var.j());
                        } else if (id == R.id.obfuscated_res_0x7f090cd9) {
                            StatisticItem statisticItem = new StatisticItem("c10760");
                            statisticItem.param("obj_locate", 4);
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.obfuscated_res_0x7f090cd4) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 2);
                            TiebaStatic.log(statisticItem2);
                            d37.c(x26Var.a, x26Var.r(), x26Var.n(), 1);
                        } else if (id != R.id.obfuscated_res_0x7f090cd7 && id != R.id.obfuscated_res_0x7f090cd8) {
                            if (view2 instanceof TbImageView) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f090cd5) instanceof Integer) {
                                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                                    statisticItem3.param("obj_locate", 3);
                                    TiebaStatic.log(statisticItem3);
                                }
                                TiebaStatic.log(x26Var.P());
                                ro5.c().i("page_recommend", "clk_", x26Var.P());
                                d37.c(x26Var.a, x26Var.r(), x26Var.n(), 2);
                            }
                        } else {
                            StatisticItem statisticItem4 = new StatisticItem("c10760");
                            statisticItem4.param("obj_locate", 1);
                            TiebaStatic.log(statisticItem4);
                        }
                        i = 2;
                    }
                    i = 0;
                }
                if (i != 0) {
                    d37.d(x26Var.a, this.b.b, x26Var.n(), i);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements jx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(b27 b27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b27Var};
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
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b6) {
                yq4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092488) {
                yq4Var.objType = 4;
            } else {
                yq4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements gx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy a;
        public final /* synthetic */ b27 b;

        public c(b27 b27Var, zy zyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b27Var, zyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b27Var;
            this.a = zyVar;
        }

        @Override // com.baidu.tieba.gx.a
        public void a(yq4 yq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, yq4Var) == null) || yq4Var == null || yq4Var.getThreadData() == null || yq4Var.getThreadData().originalThreadData == null) {
                return;
            }
            oh5.b(1, this.b.mContext, yq4Var.getThreadData(), 0, this.a.v(), "from_nani_video", "personalize_page", null, "index", "");
        }
    }

    /* loaded from: classes3.dex */
    public class d implements gx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy a;
        public final /* synthetic */ b27 b;

        public d(b27 b27Var, zy zyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b27Var, zyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b27Var;
            this.a = zyVar;
        }

        @Override // com.baidu.tieba.gx.a
        public void a(yq4 yq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, yq4Var) == null) || yq4Var == null || yq4Var.getThreadData() == null || yq4Var.getThreadData().originalThreadData == null) {
                return;
            }
            oh5.b(1, this.b.mContext, yq4Var.getThreadData(), 0, this.a.v(), "from_nani_video", "personalize_page", null, "index", "");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ez {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy a;
        public final /* synthetic */ b27 b;

        public e(b27 b27Var, zy zyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b27Var, zyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b27Var;
            this.a = zyVar;
        }

        @Override // com.baidu.tieba.ez
        public void a(yq4 yq4Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, yq4Var) == null) || yq4Var == null || yq4Var.getThreadData() == null || yq4Var.getThreadData().originalThreadData == null) {
                return;
            }
            if (yq4Var.getThreadData().originalThreadData.r != null) {
                z = yq4Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1;
            } else {
                z = false;
            }
            oh5.a(1, z, this.b.mContext, yq4Var.getThreadData(), 0, this.a.v(), "from_nani_video", "frs_page", null, "frs", "");
        }
    }

    /* loaded from: classes3.dex */
    public class f implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b27 a;

        public f(b27 b27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b27Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof x26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                x26 x26Var = (x26) cdo;
                x26Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), x26Var);
                }
                ThreadCardUtils.jumpToPB((yq4) x26Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b27(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.d = null;
        this.g = new a(this);
        this.c = tbPageContext;
        x();
    }

    public void A(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.d = bVar;
        }
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.e = str;
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
    /* renamed from: y */
    public ThreadCardViewHolder<x26> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.c.getPageActivity());
            zy zyVar = new zy(this.c.getPageActivity());
            jx jxVar = new jx(this.c.getPageActivity());
            jxVar.u(this.b);
            jxVar.d(1024);
            jxVar.t(new b(this));
            bVar.o(jxVar);
            ny nyVar = new ny(this.c);
            nyVar.o(Boolean.FALSE);
            nyVar.w("index");
            bVar.n(nyVar);
            ny nyVar2 = new ny(this.c);
            nyVar2.o(Boolean.TRUE);
            nyVar2.w("index");
            nyVar2.z(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            nyVar2.x(new c(this, zyVar));
            bVar.h(nyVar2);
            zyVar.o(Boolean.TRUE);
            zyVar.x("index");
            zyVar.y(new d(this, zyVar));
            zyVar.z(new e(this, zyVar));
            bVar.h(zyVar);
            bVar.h(new wy(this.c.getPageActivity()));
            bVar.h(new qx(this.c.getPageActivity()));
            uy uyVar = new uy(this.c.getPageActivity());
            er4 er4Var = new er4();
            er4Var.b = 1;
            er4Var.h = 1;
            uyVar.w(er4Var);
            uyVar.y(1);
            uyVar.D(3);
            uyVar.z(2);
            uyVar.x(false);
            bVar.m(uyVar);
            sy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.r(2);
            ThreadCardViewHolder<x26> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new f(this));
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, x26Var, threadCardViewHolder})) == null) {
            if (x26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || x26Var.a == null) {
                return null;
            }
            x26Var.I(x26Var.position + 1);
            x26Var.a.statFloor = x26Var.n();
            threadCardViewHolder.a().q(i);
            b26.b().a(x26Var.R("c12641"));
            ro5.c().i("page_recommend", "show_", x26Var.B());
            threadCardViewHolder.a().b(this.e);
            threadCardViewHolder.o(true).u(this.d);
            threadCardViewHolder.k(x26Var.showFollowBtn(), this.a);
            threadCardViewHolder.e(x26Var);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.g);
            d37.i(x26Var.a, this.b, x26Var.n());
            d37.h(x26Var.a, x26Var.r(), x26Var.n());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
