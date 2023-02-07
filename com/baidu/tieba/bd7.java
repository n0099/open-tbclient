package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.gz;
import com.baidu.tieba.kx;
import com.baidu.tieba.vy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bd7 extends t77<ae6, ThreadCardViewHolder<ae6>> implements mw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.b d;
    public String e;
    public boolean f;
    public ld6<ae6> g;

    /* loaded from: classes3.dex */
    public class a extends ld6<ae6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bd7 b;

        public a(bd7 bd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bd7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ld6
        /* renamed from: d */
        public void a(View view2, ae6 ae6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ae6Var) == null) {
                int i = 1;
                ed6.b().d(true);
                kw5.c().h("page_recommend", "show_");
                if (ae6Var != null && ae6Var.getThreadData() != null && !dj.isEmpty(ae6Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id == R.id.thread_card_root) {
                        TiebaStatic.log(ae6Var.u());
                        kw5.c().i("page_recommend", "clk_", ae6Var.u());
                        oe7.c(ae6Var.a, ae6Var.o(), ae6Var.m(), 1);
                    } else if (id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(ae6Var.u());
                        kw5.c().i("page_recommend", "clk_", ae6Var.u());
                        oe7.c(ae6Var.a, ae6Var.o(), ae6Var.m(), 1);
                        i = 5;
                    } else {
                        if (id == R.id.thread_card_voice) {
                            TiebaStatic.log(ae6Var.T());
                            kw5.c().i("page_recommend", "clk_", ae6Var.T());
                        } else {
                            if (id == R.id.user_avatar) {
                                TiebaStatic.log(ae6Var.S());
                                kw5.c().i("page_recommend", "clk_", ae6Var.S());
                                oe7.c(ae6Var.a, ae6Var.o(), ae6Var.m(), 4);
                            } else if (id == R.id.user_name) {
                                TiebaStatic.log(ae6Var.S());
                                kw5.c().i("page_recommend", "clk_", ae6Var.S());
                                oe7.c(ae6Var.a, ae6Var.o(), ae6Var.m(), 4);
                            } else if (id == R.id.forum_name_text) {
                                TiebaStatic.log(ae6Var.i());
                                kw5.c().i("page_recommend", "clk_", ae6Var.i());
                            } else if (id == R.id.god_reply_voice_btn) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.god_reply_content) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                oe7.c(ae6Var.a, ae6Var.o(), ae6Var.m(), 1);
                            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(ae6Var.P());
                                    kw5.c().i("page_recommend", "clk_", ae6Var.P());
                                    oe7.c(ae6Var.a, ae6Var.o(), ae6Var.m(), 2);
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
                        oe7.d(ae6Var.a, this.b.b, ae6Var.m(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements kx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(bd7 bd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kx.b
        public void a(sw4 sw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, sw4Var, view2) == null) && sw4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    sw4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    sw4Var.objType = 4;
                } else {
                    sw4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bd7 a;

        public c(bd7 bd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bd7Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof ae6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ae6 ae6Var = (ae6) cdo;
                ae6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), ae6Var);
                }
                ThreadCardUtils.jumpToPB((sw4) ae6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().p(new gz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = true;
        this.g = new a(this);
        this.c = tbPageContext;
        u();
    }

    @Override // com.baidu.tieba.mw5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.e = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f = z;
        }
    }

    public void x(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ae6.R = "c10705";
            ae6.S = "c10730";
            ae6.T = "c10731";
            ae6.U = "c10704";
            ae6.V = "c10755";
            ae6.W = "c10710";
            ae6.X = "c10736";
            ae6.Y = "c10737";
            ae6.Z = "c10711";
            ae6.a0 = "c10758";
            ae6.b0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: v */
    public ThreadCardViewHolder<ae6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            vy.b bVar = new vy.b(this.c.getPageActivity());
            kx kxVar = new kx(this.c.getPageActivity());
            kxVar.x(this.b);
            kxVar.g(1024);
            kxVar.w(new b(this));
            bVar.o(kxVar);
            bVar.n(new dy(this.c.getPageActivity()));
            bVar.h(new rx(this.c.getPageActivity()));
            vx vxVar = new vx(this.c.getPageActivity());
            vxVar.B(this.f);
            vxVar.A("index");
            vxVar.C(new StatisticItem("c13342"));
            bVar.h(vxVar);
            xy xyVar = new xy(this.c.getPageActivity());
            yw4 yw4Var = new yw4();
            yw4Var.b = 1;
            yw4Var.h = 1;
            xyVar.z(yw4Var);
            xyVar.B(1);
            xyVar.G(3);
            xyVar.C(2);
            xyVar.A(false);
            bVar.m(xyVar);
            vy i = bVar.i();
            i.s(2);
            ThreadCardViewHolder<ae6> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ae6 ae6Var, ThreadCardViewHolder<ae6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ae6Var, threadCardViewHolder})) == null) {
            if (ae6Var != null && threadCardViewHolder != null && threadCardViewHolder.a() != null) {
                ae6Var.I(ae6Var.position + 1);
                ae6Var.a.statFloor = ae6Var.m();
                ed6.b().a(ae6Var.O("c12190"));
                if (threadCardViewHolder.a() instanceof lw5) {
                    threadCardViewHolder.a().b(this.e);
                }
                ly o = threadCardViewHolder.o(true);
                o.s(this.d);
                threadCardViewHolder.k(ae6Var.showFollowBtn(), this.a);
                o.a(ae6Var.getNegFeedBackData());
                threadCardViewHolder.e(ae6Var);
                threadCardViewHolder.h(this.g);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                oe7.k(ae6Var.a, this.b, ae6Var.m());
                oe7.j(ae6Var.a, ae6Var.o(), ae6Var.m());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
