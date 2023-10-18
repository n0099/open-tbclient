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
import com.baidu.tieba.kt;
import com.baidu.tieba.vt;
import com.baidu.tieba.wr;
import com.baidu.tieba.zr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c18 extends vu7<rk6, ThreadCardViewHolder<rk6>> implements yz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.NEGFeedbackEventCallback d;
    public String e;
    public ei f;
    public bk6<rk6> g;

    /* loaded from: classes5.dex */
    public class a extends bk6<rk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c18 b;

        public a(c18 c18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bk6
        /* renamed from: d */
        public void a(View view2, rk6 rk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, rk6Var) == null) {
                int i = 1;
                tj6.b().d(true);
                wz5.c().h("page_recommend", "show_");
                if (view2 != null && rk6Var != null && rk6Var.getThreadData() != null && !StringUtils.isNull(rk6Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                        if (id == R.id.thread_card_voice) {
                            TiebaStatic.log(rk6Var.O());
                            wz5.c().i("page_recommend", "clk_", rk6Var.O());
                        } else {
                            if (id == R.id.user_avatar) {
                                TiebaStatic.log(rk6Var.N());
                                wz5.c().i("page_recommend", "clk_", rk6Var.N());
                                k28.c(rk6Var.a, rk6Var.i(), rk6Var.h(), 4);
                            } else if (id == R.id.user_name) {
                                TiebaStatic.log(rk6Var.N());
                                wz5.c().i("page_recommend", "clk_", rk6Var.N());
                                k28.c(rk6Var.a, rk6Var.i(), rk6Var.h(), 4);
                            } else if (id == R.id.forum_name_text) {
                                TiebaStatic.log(rk6Var.f());
                                wz5.c().i("page_recommend", "clk_", rk6Var.f());
                            } else if (id == R.id.god_reply_voice_btn) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.god_reply_content) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                k28.c(rk6Var.a, rk6Var.i(), rk6Var.h(), 1);
                            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(rk6Var.K());
                                    wz5.c().i("page_recommend", "clk_", rk6Var.K());
                                    k28.c(rk6Var.a, rk6Var.i(), rk6Var.h(), 2);
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
                        TiebaStatic.log(rk6Var.L("c12642"));
                        wz5.c().i("page_recommend", "clk_", rk6Var.q());
                        k28.c(rk6Var.a, rk6Var.i(), rk6Var.h(), 1);
                    }
                    if (i != 0) {
                        k28.d(rk6Var.a, this.b.b, rk6Var.h(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zr.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c18 c18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zr.b
        public void a(jv4 jv4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, jv4Var, view2) == null) && jv4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    jv4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    jv4Var.objType = 4;
                } else {
                    jv4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements wr.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rt a;
        public final /* synthetic */ c18 b;

        public c(c18 c18Var, rt rtVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c18Var, rtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c18Var;
            this.a = rtVar;
        }

        @Override // com.baidu.tieba.wr.a
        public void a(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) && jv4Var != null && jv4Var.getThreadData() != null && jv4Var.getThreadData().originalThreadData != null) {
                rr5.b(1, this.b.mContext, jv4Var.getThreadData(), 0, this.a.B(), "from_nani_video", "personalize_page", null, "index", "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements wr.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rt a;
        public final /* synthetic */ c18 b;

        public d(c18 c18Var, rt rtVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c18Var, rtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c18Var;
            this.a = rtVar;
        }

        @Override // com.baidu.tieba.wr.a
        public void a(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) && jv4Var != null && jv4Var.getThreadData() != null && jv4Var.getThreadData().originalThreadData != null) {
                rr5.b(1, this.b.mContext, jv4Var.getThreadData(), 0, this.a.B(), "from_nani_video", "personalize_page", null, "index", "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements au {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rt a;
        public final /* synthetic */ c18 b;

        public e(c18 c18Var, rt rtVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c18Var, rtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c18Var;
            this.a = rtVar;
        }

        @Override // com.baidu.tieba.au
        public void a(jv4 jv4Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) && jv4Var != null && jv4Var.getThreadData() != null && jv4Var.getThreadData().originalThreadData != null) {
                boolean z2 = false;
                if (jv4Var.getThreadData().originalThreadData.r != null) {
                    if (jv4Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                rr5.a(1, z, this.b.mContext, jv4Var.getThreadData(), 0, this.a.B(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c18 a;

        public f(c18 c18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c18Var;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (yhVar instanceof rk6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                rk6 rk6Var = (rk6) yhVar;
                rk6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), rk6Var);
                }
                ThreadCardUtils.jumpToPB((jv4) rk6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().q(new vt.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c18(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void C(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nEGFeedbackEventCallback) == null) {
            this.d = nEGFeedbackEventCallback;
        }
    }

    @Override // com.baidu.tieba.yz5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.e = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: A */
    public ThreadCardViewHolder<rk6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            kt.b bVar = new kt.b(this.c.getPageActivity());
            rt rtVar = new rt(this.c.getPageActivity());
            zr zrVar = new zr(this.c.getPageActivity());
            zrVar.q(this.b);
            zrVar.f(1024);
            zrVar.z(new b(this));
            bVar.o(zrVar);
            ft ftVar = new ft(this.c);
            ftVar.s(Boolean.FALSE);
            ftVar.setFrom("index");
            bVar.n(ftVar);
            ft ftVar2 = new ft(this.c);
            ftVar2.s(Boolean.TRUE);
            ftVar2.setFrom("index");
            ftVar2.E(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            ftVar2.C(new c(this, rtVar));
            bVar.h(ftVar2);
            rtVar.s(Boolean.TRUE);
            rtVar.setFrom("index");
            rtVar.D(new d(this, rtVar));
            rtVar.E(new e(this, rtVar));
            bVar.h(rtVar);
            bVar.h(new ot(this.c.getPageActivity()));
            bVar.h(new hs(this.c.getPageActivity()));
            mt mtVar = new mt(this.c.getPageActivity());
            pv4 pv4Var = new pv4();
            pv4Var.b = 1;
            pv4Var.h = 1;
            mtVar.E(pv4Var);
            mtVar.G(1);
            mtVar.L(3);
            mtVar.H(2);
            mtVar.F(false);
            bVar.m(mtVar);
            kt k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.t(2);
            ThreadCardViewHolder<rk6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, rk6 rk6Var, ThreadCardViewHolder<rk6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rk6Var, threadCardViewHolder})) == null) {
            if (rk6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && rk6Var.a != null) {
                rk6Var.A(rk6Var.position + 1);
                rk6Var.a.statFloor = rk6Var.h();
                threadCardViewHolder.a().s(i);
                tj6.b().a(rk6Var.M("c12641"));
                wz5.c().i("page_recommend", "show_", rk6Var.r());
                threadCardViewHolder.a().b(this.e);
                threadCardViewHolder.q(true).setNegEventCallback(this.d);
                threadCardViewHolder.m(rk6Var.showFollowBtn(), this.a);
                threadCardViewHolder.e(rk6Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.g);
                k28.p(rk6Var.a, this.b, rk6Var.h());
                k28.o(rk6Var.a, rk6Var.i(), rk6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            rk6.f1159T = "c10705";
            rk6.U = "c10730";
            rk6.V = "c10731";
            rk6.W = "c10704";
            rk6.X = "c10755";
            rk6.Y = "c10710";
            rk6.Z = "c10736";
            rk6.a0 = "c10737";
            rk6.b0 = "c10711";
            rk6.c0 = "c10758";
            rk6.d0 = "c10757";
        }
    }
}
