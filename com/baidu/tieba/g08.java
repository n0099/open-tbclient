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
import com.baidu.tieba.jz;
import com.baidu.tieba.ux;
import com.baidu.tieba.uz;
import com.baidu.tieba.xx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class g08 extends ou7<uo6, ThreadCardViewHolder<uo6>> implements d56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.b d;
    public String e;
    public bo f;
    public eo6<uo6> g;

    /* loaded from: classes5.dex */
    public class a extends eo6<uo6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g08 b;

        public a(g08 g08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.eo6
        /* renamed from: d */
        public void a(View view2, uo6 uo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, uo6Var) == null) {
                int i = 1;
                xn6.b().d(true);
                b56.c().h("page_recommend", "show_");
                if (view2 != null && uo6Var != null && uo6Var.getThreadData() != null && !StringUtils.isNull(uo6Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                        if (id == R.id.thread_card_voice) {
                            TiebaStatic.log(uo6Var.U());
                            b56.c().i("page_recommend", "clk_", uo6Var.U());
                        } else {
                            if (id == R.id.user_avatar) {
                                TiebaStatic.log(uo6Var.R());
                                b56.c().i("page_recommend", "clk_", uo6Var.R());
                                j18.c(uo6Var.a, uo6Var.k(), uo6Var.i(), 4);
                            } else if (id == R.id.user_name) {
                                TiebaStatic.log(uo6Var.R());
                                b56.c().i("page_recommend", "clk_", uo6Var.R());
                                j18.c(uo6Var.a, uo6Var.k(), uo6Var.i(), 4);
                            } else if (id == R.id.forum_name_text) {
                                TiebaStatic.log(uo6Var.f());
                                b56.c().i("page_recommend", "clk_", uo6Var.f());
                            } else if (id == R.id.god_reply_voice_btn) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.god_reply_content) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                j18.c(uo6Var.a, uo6Var.k(), uo6Var.i(), 1);
                            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(uo6Var.M());
                                    b56.c().i("page_recommend", "clk_", uo6Var.M());
                                    j18.c(uo6Var.a, uo6Var.k(), uo6Var.i(), 2);
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
                        TiebaStatic.log(uo6Var.P("c12642"));
                        b56.c().i("page_recommend", "clk_", uo6Var.q());
                        j18.c(uo6Var.a, uo6Var.k(), uo6Var.i(), 1);
                    }
                    if (i != 0) {
                        j18.d(uo6Var.a, this.b.b, uo6Var.i(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements xx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(g08 g08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.xx.b
        public void a(f15 f15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, f15Var, view2) == null) && f15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    f15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    f15Var.objType = 4;
                } else {
                    f15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ux.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz a;
        public final /* synthetic */ g08 b;

        public c(g08 g08Var, qz qzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g08Var, qzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g08Var;
            this.a = qzVar;
        }

        @Override // com.baidu.tieba.ux.a
        public void a(f15 f15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, f15Var) == null) && f15Var != null && f15Var.getThreadData() != null && f15Var.getThreadData().originalThreadData != null) {
                qw5.b(1, this.b.mContext, f15Var.getThreadData(), 0, this.a.A(), "from_nani_video", "personalize_page", null, "index", "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ux.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz a;
        public final /* synthetic */ g08 b;

        public d(g08 g08Var, qz qzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g08Var, qzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g08Var;
            this.a = qzVar;
        }

        @Override // com.baidu.tieba.ux.a
        public void a(f15 f15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, f15Var) == null) && f15Var != null && f15Var.getThreadData() != null && f15Var.getThreadData().originalThreadData != null) {
                qw5.b(1, this.b.mContext, f15Var.getThreadData(), 0, this.a.A(), "from_nani_video", "personalize_page", null, "index", "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements zz {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz a;
        public final /* synthetic */ g08 b;

        public e(g08 g08Var, qz qzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g08Var, qzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g08Var;
            this.a = qzVar;
        }

        @Override // com.baidu.tieba.zz
        public void a(f15 f15Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, f15Var) == null) && f15Var != null && f15Var.getThreadData() != null && f15Var.getThreadData().originalThreadData != null) {
                boolean z2 = false;
                if (f15Var.getThreadData().originalThreadData.r != null) {
                    if (f15Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                qw5.a(1, z, this.b.mContext, f15Var.getThreadData(), 0, this.a.A(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements fo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g08 a;

        public f(g08 g08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g08Var;
        }

        @Override // com.baidu.tieba.fo
        public void b(View view2, vn vnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, vnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (vnVar instanceof uo6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                uo6 uo6Var = (uo6) vnVar;
                uo6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), uo6Var);
                }
                ThreadCardUtils.jumpToPB((f15) uo6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().p(new uz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        z();
    }

    public void C(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.d = bVar;
        }
    }

    @Override // com.baidu.tieba.d56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.e = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: A */
    public ThreadCardViewHolder<uo6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            jz.b bVar = new jz.b(this.c.getPageActivity());
            qz qzVar = new qz(this.c.getPageActivity());
            xx xxVar = new xx(this.c.getPageActivity());
            xxVar.z(this.b);
            xxVar.g(1024);
            xxVar.y(new b(this));
            bVar.o(xxVar);
            ez ezVar = new ez(this.c);
            ezVar.r(Boolean.FALSE);
            ezVar.setFrom("index");
            bVar.n(ezVar);
            ez ezVar2 = new ez(this.c);
            ezVar2.r(Boolean.TRUE);
            ezVar2.setFrom("index");
            ezVar2.D(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            ezVar2.B(new c(this, qzVar));
            bVar.h(ezVar2);
            qzVar.r(Boolean.TRUE);
            qzVar.setFrom("index");
            qzVar.C(new d(this, qzVar));
            qzVar.D(new e(this, qzVar));
            bVar.h(qzVar);
            bVar.h(new nz(this.c.getPageActivity()));
            bVar.h(new fy(this.c.getPageActivity()));
            lz lzVar = new lz(this.c.getPageActivity());
            l15 l15Var = new l15();
            l15Var.b = 1;
            l15Var.h = 1;
            lzVar.B(l15Var);
            lzVar.D(1);
            lzVar.I(3);
            lzVar.E(2);
            lzVar.C(false);
            bVar.m(lzVar);
            jz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder<uo6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, uo6 uo6Var, ThreadCardViewHolder<uo6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, uo6Var, threadCardViewHolder})) == null) {
            if (uo6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && uo6Var.a != null) {
                uo6Var.B(uo6Var.position + 1);
                uo6Var.a.statFloor = uo6Var.i();
                threadCardViewHolder.a().r(i);
                xn6.b().a(uo6Var.Q("c12641"));
                b56.c().i("page_recommend", "show_", uo6Var.s());
                threadCardViewHolder.a().b(this.e);
                threadCardViewHolder.p(true).s(this.d);
                threadCardViewHolder.l(uo6Var.showFollowBtn(), this.a);
                threadCardViewHolder.e(uo6Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                j18.p(uo6Var.a, this.b, uo6Var.i());
                j18.o(uo6Var.a, uo6Var.k(), uo6Var.i());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            uo6.f1170T = "c10705";
            uo6.U = "c10730";
            uo6.V = "c10731";
            uo6.W = "c10704";
            uo6.X = "c10755";
            uo6.Y = "c10710";
            uo6.Z = "c10736";
            uo6.a0 = "c10737";
            uo6.b0 = "c10711";
            uo6.c0 = "c10758";
            uo6.d0 = "c10757";
        }
    }
}
