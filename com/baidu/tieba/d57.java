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
import com.baidu.tieba.ax;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dx;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d57 extends kz6<w56, ThreadCardViewHolder<w56>> implements hr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.b d;
    public String e;
    public Cdo f;
    public h56<w56> g;

    /* loaded from: classes4.dex */
    public class a extends h56<w56> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d57 b;

        public a(d57 d57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h56
        /* renamed from: d */
        public void a(View view2, w56 w56Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, w56Var) == null) {
                int i = 1;
                a56.b().d(true);
                fr5.c().h("page_recommend", "show_");
                if (view2 != null && w56Var != null && w56Var.getThreadData() != null && !StringUtils.isNull(w56Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                        if (id == R.id.thread_card_voice) {
                            TiebaStatic.log(w56Var.T());
                            fr5.c().i("page_recommend", "clk_", w56Var.T());
                        } else {
                            if (id == R.id.user_avatar) {
                                TiebaStatic.log(w56Var.S());
                                fr5.c().i("page_recommend", "clk_", w56Var.S());
                                f67.c(w56Var.a, w56Var.o(), w56Var.m(), 4);
                            } else if (id == R.id.user_name) {
                                TiebaStatic.log(w56Var.S());
                                fr5.c().i("page_recommend", "clk_", w56Var.S());
                                f67.c(w56Var.a, w56Var.o(), w56Var.m(), 4);
                            } else if (id == R.id.forum_name_text) {
                                TiebaStatic.log(w56Var.i());
                                fr5.c().i("page_recommend", "clk_", w56Var.i());
                            } else if (id == R.id.god_reply_voice_btn) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.god_reply_content) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                f67.c(w56Var.a, w56Var.o(), w56Var.m(), 1);
                            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(w56Var.P());
                                    fr5.c().i("page_recommend", "clk_", w56Var.P());
                                    f67.c(w56Var.a, w56Var.o(), w56Var.m(), 2);
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
                        TiebaStatic.log(w56Var.Q("c12642"));
                        fr5.c().i("page_recommend", "clk_", w56Var.v());
                        f67.c(w56Var.a, w56Var.o(), w56Var.m(), 1);
                    }
                    if (i != 0) {
                        f67.d(w56Var.a, this.b.b, w56Var.m(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements dx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(d57 d57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.dx.b
        public void a(vr4 vr4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, vr4Var, view2) == null) && vr4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    vr4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    vr4Var.objType = 4;
                } else {
                    vr4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ d57 b;

        public c(d57 d57Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d57Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d57Var;
            this.a = vyVar;
        }

        @Override // com.baidu.tieba.ax.a
        public void a(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) && vr4Var != null && vr4Var.getThreadData() != null && vr4Var.getThreadData().originalThreadData != null) {
                sj5.b(1, this.b.mContext, vr4Var.getThreadData(), 0, this.a.y(), "from_nani_video", "personalize_page", null, "index", "");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ d57 b;

        public d(d57 d57Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d57Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d57Var;
            this.a = vyVar;
        }

        @Override // com.baidu.tieba.ax.a
        public void a(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) && vr4Var != null && vr4Var.getThreadData() != null && vr4Var.getThreadData().originalThreadData != null) {
                sj5.b(1, this.b.mContext, vr4Var.getThreadData(), 0, this.a.y(), "from_nani_video", "personalize_page", null, "index", "");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements bz {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ d57 b;

        public e(d57 d57Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d57Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d57Var;
            this.a = vyVar;
        }

        @Override // com.baidu.tieba.bz
        public void a(vr4 vr4Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) && vr4Var != null && vr4Var.getThreadData() != null && vr4Var.getThreadData().originalThreadData != null) {
                boolean z2 = false;
                if (vr4Var.getThreadData().originalThreadData.r != null) {
                    if (vr4Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                sj5.a(1, z, this.b.mContext, vr4Var.getThreadData(), 0, this.a.y(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d57 a;

        public f(d57 d57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d57Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof w56) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                w56 w56Var = (w56) xnVar;
                w56Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), w56Var);
                }
                ThreadCardUtils.jumpToPB((vr4) w56Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d57(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.hr5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.e = str;
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            w56.R = "c10705";
            w56.S = "c10730";
            w56.T = "c10731";
            w56.U = "c10704";
            w56.V = "c10755";
            w56.W = "c10710";
            w56.X = "c10736";
            w56.Y = "c10737";
            w56.Z = "c10711";
            w56.a0 = "c10758";
            w56.b0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: y */
    public ThreadCardViewHolder<w56> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity());
            vy vyVar = new vy(this.c.getPageActivity());
            dx dxVar = new dx(this.c.getPageActivity());
            dxVar.x(this.b);
            dxVar.g(1024);
            dxVar.w(new b(this));
            bVar.o(dxVar);
            jy jyVar = new jy(this.c);
            jyVar.r(Boolean.FALSE);
            jyVar.z("index");
            bVar.n(jyVar);
            jy jyVar2 = new jy(this.c);
            jyVar2.r(Boolean.TRUE);
            jyVar2.z("index");
            jyVar2.C(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            jyVar2.A(new c(this, vyVar));
            bVar.h(jyVar2);
            vyVar.r(Boolean.TRUE);
            vyVar.A("index");
            vyVar.B(new d(this, vyVar));
            vyVar.C(new e(this, vyVar));
            bVar.h(vyVar);
            bVar.h(new sy(this.c.getPageActivity()));
            bVar.h(new kx(this.c.getPageActivity()));
            qy qyVar = new qy(this.c.getPageActivity());
            bs4 bs4Var = new bs4();
            bs4Var.b = 1;
            bs4Var.h = 1;
            qyVar.z(bs4Var);
            qyVar.B(1);
            qyVar.G(3);
            qyVar.C(2);
            qyVar.A(false);
            bVar.m(qyVar);
            oy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder<w56> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, w56 w56Var, ThreadCardViewHolder<w56> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, w56Var, threadCardViewHolder})) == null) {
            if (w56Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && w56Var.a != null) {
                w56Var.I(w56Var.position + 1);
                w56Var.a.statFloor = w56Var.m();
                threadCardViewHolder.a().r(i);
                a56.b().a(w56Var.R("c12641"));
                fr5.c().i("page_recommend", "show_", w56Var.x());
                threadCardViewHolder.a().b(this.e);
                threadCardViewHolder.o(true).s(this.d);
                threadCardViewHolder.k(w56Var.showFollowBtn(), this.a);
                threadCardViewHolder.e(w56Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                f67.k(w56Var.a, this.b, w56Var.m());
                f67.j(w56Var.a, w56Var.o(), w56Var.m());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
