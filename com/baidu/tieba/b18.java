package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
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
import com.baidu.tieba.lz;
import com.baidu.tieba.wz;
import com.baidu.tieba.zx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b18 extends dv7<gp6, ThreadCardViewHolder<gp6>> implements p56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public y18 d;
    public String e;
    public Cdo f;
    public NEGFeedBackView.b g;
    public qo6<gp6> h;

    /* loaded from: classes5.dex */
    public class a extends qo6<gp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b18 b;

        public a(b18 b18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qo6
        /* renamed from: d */
        public void a(View view2, gp6 gp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, gp6Var) == null) {
                jo6.b().d(true);
                n56.c().h("page_recommend", "show_");
                if (view2 != null && this.b.d != null && gp6Var != null && gp6Var.getThreadData() != null && !StringUtils.isNull(gp6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !b08.b(vg.g(gp6Var.getThreadData().getTid(), 0L))) {
                        b08.a(vg.g(gp6Var.getThreadData().getTid(), 0L));
                        this.b.d.e(vg.g(gp6Var.getThreadData().getTid(), 0L), gp6Var.w(), gp6Var.k(), gp6Var.i(), gp6Var.c(), vg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, gp6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.C(view2, gp6Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(b18 b18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var};
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

    /* loaded from: classes5.dex */
    public class c implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b18 a;

        public c(b18 b18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b18Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof gp6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                gp6 gp6Var = (gp6) xnVar;
                gp6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), gp6Var);
                }
                if (!e28.a(this.a.c, gp6Var)) {
                    ThreadCardUtils.jumpToPB((l15) gp6Var, view2.getContext(), 2, false, ay.a((Cdo) viewGroup, view2, i));
                    threadCardViewHolder.a().p(new wz.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b18(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        z();
    }

    public void D(y18 y18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, y18Var) == null) {
            this.d = y18Var;
        }
    }

    public void E(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cdo) == null) {
            this.f = cdo;
        }
    }

    @Override // com.baidu.tieba.p56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.e = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: A */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            lz.b bVar = new lz.b(this.c.getPageActivity());
            zx zxVar = new zx(this.c.getPageActivity());
            zxVar.z(this.b);
            zxVar.g(1024);
            zxVar.y(new b(this));
            zxVar.B(this.c);
            bVar.o(zxVar);
            lz k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new c(this));
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
                if (i == 0) {
                    dx9.a("main", true);
                }
                gp6Var.B(gp6Var.position + 1);
                gp6Var.a.statFloor = gp6Var.i();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.e);
                threadCardViewHolder.q(true, Align.ALIGN_RIGHT_TOP, this.g);
                threadCardViewHolder.m(gp6Var.showFollowBtn(), this.a, true);
                threadCardViewHolder.e(gp6Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                jo6.b().a(gp6Var.s());
                n56.c().a(gp6Var.s());
                d28.p(gp6Var.a, this.b, gp6Var.i());
                d28.o(gp6Var.a, gp6Var.k(), gp6Var.i());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void C(View view2, gp6 gp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, gp6Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
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
                    i = 9;
                } else {
                    if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        d28.c(gp6Var.a, gp6Var.k(), gp6Var.i(), 1);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(gp6Var.M());
                            n56.c().i("page_recommend", "clk_", gp6Var.M());
                            d28.c(gp6Var.a, gp6Var.k(), gp6Var.i(), 2);
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
            } else {
                if (hp6.P(gp6Var.a)) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(gp6Var.u()));
                } else {
                    TiebaStatic.log(gp6Var.q());
                }
                n56.c().i("page_recommend", "clk_", gp6Var.q());
                d28.c(gp6Var.a, gp6Var.k(), gp6Var.i(), 1);
                i = 1;
            }
            if (i != 0) {
                d28.d(gp6Var.a, this.b, gp6Var.i(), i);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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
            gp6.g0 = "c10734";
            gp6.h0 = "c10708";
            gp6.i0 = "c10735";
        }
    }
}
