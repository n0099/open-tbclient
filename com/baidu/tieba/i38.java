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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.ky;
import com.baidu.tieba.vy;
import com.baidu.tieba.zw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i38 extends dx7<sn6, ThreadCardViewHolder<sn6>> implements b46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.NEGFeedbackEventCallback d;
    public String e;
    public boolean f;
    public cn6<sn6> g;

    /* loaded from: classes6.dex */
    public class a extends cn6<sn6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i38 b;

        public a(i38 i38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cn6
        /* renamed from: d */
        public void a(View view2, sn6 sn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, sn6Var) == null) {
                int i = 1;
                vm6.b().d(true);
                z36.c().h("page_recommend", "show_");
                if (view2 != null && sn6Var != null && sn6Var.getThreadData() != null && !StringUtils.isNull(sn6Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                        if (id == R.id.thread_card_voice) {
                            TiebaStatic.log(sn6Var.O());
                            z36.c().i("page_recommend", "clk_", sn6Var.O());
                        } else {
                            if (id == R.id.user_avatar) {
                                TiebaStatic.log(sn6Var.N());
                                z36.c().i("page_recommend", "clk_", sn6Var.N());
                                r48.c(sn6Var.a, sn6Var.i(), sn6Var.h(), 4);
                            } else if (id == R.id.user_name) {
                                TiebaStatic.log(sn6Var.N());
                                z36.c().i("page_recommend", "clk_", sn6Var.N());
                                r48.c(sn6Var.a, sn6Var.i(), sn6Var.h(), 4);
                            } else if (id == R.id.forum_name_text) {
                                TiebaStatic.log(sn6Var.f());
                                z36.c().i("page_recommend", "clk_", sn6Var.f());
                            } else if (id == R.id.god_reply_voice_btn) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.god_reply_content) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                r48.c(sn6Var.a, sn6Var.i(), sn6Var.h(), 1);
                            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(sn6Var.K());
                                    z36.c().i("page_recommend", "clk_", sn6Var.K());
                                    r48.c(sn6Var.a, sn6Var.i(), sn6Var.h(), 2);
                                }
                            } else {
                                StatisticItem statisticItem4 = new StatisticItem("c10760");
                                statisticItem4.param("obj_locate", 1);
                                TiebaStatic.log(statisticItem4);
                            }
                            i = 2;
                        }
                        i = 0;
                    } else {
                        TiebaStatic.log(sn6Var.L("c12642"));
                        z36.c().i("page_recommend", "clk_", sn6Var.q());
                        r48.c(sn6Var.a, sn6Var.i(), sn6Var.h(), 1);
                    }
                    if (i != 0) {
                        r48.d(sn6Var.a, this.b.b, sn6Var.h(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(i38 i38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zw.b
        public void a(q05 q05Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, q05Var, view2) == null) && q05Var != null) {
                if (view2.getId() == R.id.user_name) {
                    q05Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    q05Var.objType = 4;
                } else {
                    q05Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements in {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i38 a;

        public c(i38 i38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i38Var;
        }

        @Override // com.baidu.tieba.in
        public void b(View view2, ym ymVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ymVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ymVar instanceof sn6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                sn6 sn6Var = (sn6) ymVar;
                sn6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), sn6Var);
                }
                ThreadCardUtils.jumpToPB((q05) sn6Var, view2.getContext(), 2, false);
                threadCardViewHolder.b().p(new vy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i38(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.b46
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

    public void z(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nEGFeedbackEventCallback) == null) {
            this.d = nEGFeedbackEventCallback;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            sn6.f1164T = "c10705";
            sn6.U = "c10730";
            sn6.V = "c10731";
            sn6.W = "c10704";
            sn6.X = "c10755";
            sn6.Y = "c10710";
            sn6.Z = "c10736";
            sn6.a0 = "c10737";
            sn6.b0 = "c10711";
            sn6.c0 = "c10758";
            sn6.d0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: x */
    public ThreadCardViewHolder<sn6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            ky.b bVar = new ky.b(this.c.getPageActivity());
            zw zwVar = new zw(this.c.getPageActivity());
            zwVar.q(this.b);
            zwVar.g(1024);
            zwVar.z(new b(this));
            bVar.o(zwVar);
            py pyVar = new py(this.c.getPageActivity());
            bVar.n(pyVar);
            pyVar.B(2);
            bVar.h(new oy(this.c.getPageActivity()));
            bVar.h(new hx(this.c.getPageActivity()));
            lx lxVar = new lx(this.c.getPageActivity());
            lxVar.E(this.f);
            lxVar.D("index");
            bVar.h(lxVar);
            my myVar = new my(this.c.getPageActivity());
            w05 w05Var = new w05();
            w05Var.b = 1;
            w05Var.h = 1;
            myVar.C(w05Var);
            myVar.E(1);
            myVar.J(3);
            myVar.F(2);
            myVar.D(false);
            bVar.m(myVar);
            ky i = bVar.i();
            i.s(2);
            ThreadCardViewHolder<sn6> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.j(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, sn6 sn6Var, ThreadCardViewHolder<sn6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, sn6Var, threadCardViewHolder})) == null) {
            if (sn6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && sn6Var.a != null) {
                sn6Var.A(sn6Var.position + 1);
                sn6Var.a.statFloor = sn6Var.h();
                vm6.b().a(sn6Var.M("c12641"));
                z36.c().i("page_recommend", "show_", sn6Var.r());
                threadCardViewHolder.b().b(this.e);
                threadCardViewHolder.q(true).setNegEventCallback(this.d);
                threadCardViewHolder.m(sn6Var.showFollowBtn(), this.a);
                threadCardViewHolder.f(sn6Var);
                threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.g);
                r48.p(sn6Var.a, this.b, sn6Var.h());
                r48.o(sn6Var.a, sn6Var.i(), sn6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
