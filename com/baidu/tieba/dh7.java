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
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.tieba.rw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class dh7 extends vb7<ag6, ThreadCardViewHolder<ag6>> implements jx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.b d;
    public String e;
    public boolean f;
    public lf6<ag6> g;

    /* loaded from: classes4.dex */
    public class a extends lf6<ag6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh7 b;

        public a(dh7 dh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        public void a(View view2, ag6 ag6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ag6Var) == null) {
                int i = 1;
                ef6.b().d(true);
                hx5.c().h("page_recommend", "show_");
                if (ag6Var != null && ag6Var.getThreadData() != null && !gi.isEmpty(ag6Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id == R.id.thread_card_root) {
                        TiebaStatic.log(ag6Var.t());
                        hx5.c().i("page_recommend", "clk_", ag6Var.t());
                        pi7.c(ag6Var.a, ag6Var.m(), ag6Var.k(), 1);
                    } else if (id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(ag6Var.t());
                        hx5.c().i("page_recommend", "clk_", ag6Var.t());
                        pi7.c(ag6Var.a, ag6Var.m(), ag6Var.k(), 1);
                        i = 5;
                    } else {
                        if (id == R.id.thread_card_voice) {
                            TiebaStatic.log(ag6Var.T());
                            hx5.c().i("page_recommend", "clk_", ag6Var.T());
                        } else {
                            if (id == R.id.user_avatar) {
                                TiebaStatic.log(ag6Var.S());
                                hx5.c().i("page_recommend", "clk_", ag6Var.S());
                                pi7.c(ag6Var.a, ag6Var.m(), ag6Var.k(), 4);
                            } else if (id == R.id.user_name) {
                                TiebaStatic.log(ag6Var.S());
                                hx5.c().i("page_recommend", "clk_", ag6Var.S());
                                pi7.c(ag6Var.a, ag6Var.m(), ag6Var.k(), 4);
                            } else if (id == R.id.forum_name_text) {
                                TiebaStatic.log(ag6Var.h());
                                hx5.c().i("page_recommend", "clk_", ag6Var.h());
                            } else if (id == R.id.god_reply_voice_btn) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.god_reply_content) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                pi7.c(ag6Var.a, ag6Var.m(), ag6Var.k(), 1);
                            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(ag6Var.N());
                                    hx5.c().i("page_recommend", "clk_", ag6Var.N());
                                    pi7.c(ag6Var.a, ag6Var.m(), ag6Var.k(), 2);
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
                        pi7.d(ag6Var.a, this.b.b, ag6Var.k(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements rw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(dh7 dh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.rw.b
        public void a(hw4 hw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, hw4Var, view2) == null) && hw4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    hw4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    hw4Var.objType = 4;
                } else {
                    hw4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh7 a;

        public c(dh7 dh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh7Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof ag6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ag6 ag6Var = (ag6) gnVar;
                ag6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), ag6Var);
                }
                ThreadCardUtils.jumpToPB((hw4) ag6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().p(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.jx5
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

    public void z(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ag6.S = "c10705";
            ag6.T = "c10730";
            ag6.U = "c10731";
            ag6.V = "c10704";
            ag6.W = "c10755";
            ag6.X = "c10710";
            ag6.Y = "c10736";
            ag6.Z = "c10737";
            ag6.a0 = "c10711";
            ag6.b0 = "c10758";
            ag6.c0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: x */
    public ThreadCardViewHolder<ag6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.c.getPageActivity());
            rw rwVar = new rw(this.c.getPageActivity());
            rwVar.x(this.b);
            rwVar.g(1024);
            rwVar.w(new b(this));
            bVar.o(rwVar);
            bVar.n(new kx(this.c.getPageActivity()));
            bVar.h(new yw(this.c.getPageActivity()));
            cx cxVar = new cx(this.c.getPageActivity());
            cxVar.B(this.f);
            cxVar.A("index");
            cxVar.C(new StatisticItem("c13342"));
            bVar.h(cxVar);
            ey eyVar = new ey(this.c.getPageActivity());
            nw4 nw4Var = new nw4();
            nw4Var.b = 1;
            nw4Var.h = 1;
            eyVar.z(nw4Var);
            eyVar.B(1);
            eyVar.G(3);
            eyVar.C(2);
            eyVar.A(false);
            bVar.m(eyVar);
            cy i = bVar.i();
            i.s(2);
            ThreadCardViewHolder<ag6> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ag6 ag6Var, ThreadCardViewHolder<ag6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ag6Var, threadCardViewHolder})) == null) {
            if (ag6Var != null && threadCardViewHolder != null && threadCardViewHolder.a() != null) {
                ag6Var.E(ag6Var.position + 1);
                ag6Var.a.statFloor = ag6Var.k();
                ef6.b().a(ag6Var.M("c12190"));
                if (threadCardViewHolder.a() instanceof ix5) {
                    threadCardViewHolder.a().b(this.e);
                }
                sx o = threadCardViewHolder.o(true);
                o.s(this.d);
                threadCardViewHolder.k(ag6Var.showFollowBtn(), this.a);
                o.a(ag6Var.getNegFeedBackData());
                threadCardViewHolder.e(ag6Var);
                threadCardViewHolder.h(this.g);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                pi7.p(ag6Var.a, this.b, ag6Var.k());
                pi7.o(ag6Var.a, ag6Var.m(), ag6Var.k());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
