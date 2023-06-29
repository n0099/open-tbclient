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
import com.baidu.tieba.lz;
import com.baidu.tieba.wx;
import com.baidu.tieba.wz;
import com.baidu.tieba.zx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a18 extends dv7<gp6, ThreadCardViewHolder<gp6>> implements p56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.b d;
    public String e;
    public Cdo f;
    public qo6<gp6> g;

    /* loaded from: classes4.dex */
    public class a extends qo6<gp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a18 b;

        public a(a18 a18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qo6
        /* renamed from: d */
        public void a(View view2, gp6 gp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, gp6Var) == null) {
                int i = 1;
                jo6.b().d(true);
                n56.c().h("page_recommend", "show_");
                if (view2 != null && gp6Var != null && gp6Var.getThreadData() != null && !StringUtils.isNull(gp6Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                        if (id == R.id.thread_card_voice) {
                            TiebaStatic.log(gp6Var.U());
                            n56.c().i("page_recommend", "clk_", gp6Var.U());
                        } else {
                            if (id == R.id.user_avatar) {
                                TiebaStatic.log(gp6Var.R());
                                n56.c().i("page_recommend", "clk_", gp6Var.R());
                                d28.c(gp6Var.a, gp6Var.k(), gp6Var.i(), 4);
                            } else if (id == R.id.user_name) {
                                TiebaStatic.log(gp6Var.R());
                                n56.c().i("page_recommend", "clk_", gp6Var.R());
                                d28.c(gp6Var.a, gp6Var.k(), gp6Var.i(), 4);
                            } else if (id == R.id.forum_name_text) {
                                TiebaStatic.log(gp6Var.f());
                                n56.c().i("page_recommend", "clk_", gp6Var.f());
                            } else if (id == R.id.god_reply_voice_btn) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.god_reply_content) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                d28.c(gp6Var.a, gp6Var.k(), gp6Var.i(), 1);
                            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(gp6Var.M());
                                    n56.c().i("page_recommend", "clk_", gp6Var.M());
                                    d28.c(gp6Var.a, gp6Var.k(), gp6Var.i(), 2);
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
                        TiebaStatic.log(gp6Var.P("c12642"));
                        n56.c().i("page_recommend", "clk_", gp6Var.q());
                        d28.c(gp6Var.a, gp6Var.k(), gp6Var.i(), 1);
                    }
                    if (i != 0) {
                        d28.d(gp6Var.a, this.b.b, gp6Var.i(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements zx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a18 a18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zx.b
        public void a(l15 l15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, l15Var, view2) == null) && l15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    l15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    l15Var.objType = 4;
                } else {
                    l15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements wx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz a;
        public final /* synthetic */ a18 b;

        public c(a18 a18Var, sz szVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var, szVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a18Var;
            this.a = szVar;
        }

        @Override // com.baidu.tieba.wx.a
        public void a(l15 l15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, l15Var) == null) && l15Var != null && l15Var.getThreadData() != null && l15Var.getThreadData().originalThreadData != null) {
                cx5.b(1, this.b.mContext, l15Var.getThreadData(), 0, this.a.A(), "from_nani_video", "personalize_page", null, "index", "");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements wx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz a;
        public final /* synthetic */ a18 b;

        public d(a18 a18Var, sz szVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var, szVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a18Var;
            this.a = szVar;
        }

        @Override // com.baidu.tieba.wx.a
        public void a(l15 l15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, l15Var) == null) && l15Var != null && l15Var.getThreadData() != null && l15Var.getThreadData().originalThreadData != null) {
                cx5.b(1, this.b.mContext, l15Var.getThreadData(), 0, this.a.A(), "from_nani_video", "personalize_page", null, "index", "");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b00 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz a;
        public final /* synthetic */ a18 b;

        public e(a18 a18Var, sz szVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var, szVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a18Var;
            this.a = szVar;
        }

        @Override // com.baidu.tieba.b00
        public void a(l15 l15Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, l15Var) == null) && l15Var != null && l15Var.getThreadData() != null && l15Var.getThreadData().originalThreadData != null) {
                boolean z2 = false;
                if (l15Var.getThreadData().originalThreadData.r != null) {
                    if (l15Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                cx5.a(1, z, this.b.mContext, l15Var.getThreadData(), 0, this.a.A(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a18 a;

        public f(a18 a18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a18Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof gp6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                gp6 gp6Var = (gp6) xnVar;
                gp6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), gp6Var);
                }
                ThreadCardUtils.jumpToPB((l15) gp6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().p(new wz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a18(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.p56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.e = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: A */
    public ThreadCardViewHolder<gp6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            lz.b bVar = new lz.b(this.c.getPageActivity());
            sz szVar = new sz(this.c.getPageActivity());
            zx zxVar = new zx(this.c.getPageActivity());
            zxVar.z(this.b);
            zxVar.g(1024);
            zxVar.y(new b(this));
            bVar.o(zxVar);
            gz gzVar = new gz(this.c);
            gzVar.r(Boolean.FALSE);
            gzVar.setFrom("index");
            bVar.n(gzVar);
            gz gzVar2 = new gz(this.c);
            gzVar2.r(Boolean.TRUE);
            gzVar2.setFrom("index");
            gzVar2.D(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            gzVar2.B(new c(this, szVar));
            bVar.h(gzVar2);
            szVar.r(Boolean.TRUE);
            szVar.setFrom("index");
            szVar.C(new d(this, szVar));
            szVar.D(new e(this, szVar));
            bVar.h(szVar);
            bVar.h(new pz(this.c.getPageActivity()));
            bVar.h(new hy(this.c.getPageActivity()));
            nz nzVar = new nz(this.c.getPageActivity());
            r15 r15Var = new r15();
            r15Var.b = 1;
            r15Var.h = 1;
            nzVar.B(r15Var);
            nzVar.D(1);
            nzVar.I(3);
            nzVar.E(2);
            nzVar.C(false);
            bVar.m(nzVar);
            lz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder<gp6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, gp6 gp6Var, ThreadCardViewHolder<gp6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gp6Var, threadCardViewHolder})) == null) {
            if (gp6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && gp6Var.a != null) {
                gp6Var.B(gp6Var.position + 1);
                gp6Var.a.statFloor = gp6Var.i();
                threadCardViewHolder.a().r(i);
                jo6.b().a(gp6Var.Q("c12641"));
                n56.c().i("page_recommend", "show_", gp6Var.s());
                threadCardViewHolder.a().b(this.e);
                threadCardViewHolder.p(true).s(this.d);
                threadCardViewHolder.l(gp6Var.showFollowBtn(), this.a);
                threadCardViewHolder.e(gp6Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                d28.p(gp6Var.a, this.b, gp6Var.i());
                d28.o(gp6Var.a, gp6Var.k(), gp6Var.i());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            gp6.f1101T = "c10705";
            gp6.U = "c10730";
            gp6.V = "c10731";
            gp6.W = "c10704";
            gp6.X = "c10755";
            gp6.Y = "c10710";
            gp6.Z = "c10736";
            gp6.a0 = "c10737";
            gp6.b0 = "c10711";
            gp6.c0 = "c10758";
            gp6.d0 = "c10757";
        }
    }
}
