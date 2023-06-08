package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
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
public class f08 extends qu7<wo6, ThreadCardViewHolder<wo6>> implements f56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.b d;
    public String e;
    public bo f;
    public go6<wo6> g;

    /* loaded from: classes5.dex */
    public class a extends go6<wo6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f08 b;

        public a(f08 f08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.go6
        /* renamed from: d */
        public void a(View view2, wo6 wo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, wo6Var) == null) {
                int i = 1;
                zn6.b().d(true);
                d56.c().h("page_recommend", "show_");
                if (view2 != null && wo6Var != null && wo6Var.getThreadData() != null && !StringUtils.isNull(wo6Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                        if (id == R.id.thread_card_voice) {
                            TiebaStatic.log(wo6Var.U());
                            d56.c().i("page_recommend", "clk_", wo6Var.U());
                        } else {
                            if (id == R.id.user_avatar) {
                                TiebaStatic.log(wo6Var.R());
                                d56.c().i("page_recommend", "clk_", wo6Var.R());
                                l18.c(wo6Var.a, wo6Var.k(), wo6Var.i(), 4);
                            } else if (id == R.id.user_name) {
                                TiebaStatic.log(wo6Var.R());
                                d56.c().i("page_recommend", "clk_", wo6Var.R());
                                l18.c(wo6Var.a, wo6Var.k(), wo6Var.i(), 4);
                            } else if (id == R.id.forum_name_text) {
                                TiebaStatic.log(wo6Var.f());
                                d56.c().i("page_recommend", "clk_", wo6Var.f());
                            } else if (id == R.id.god_reply_voice_btn) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.god_reply_content) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                l18.c(wo6Var.a, wo6Var.k(), wo6Var.i(), 1);
                            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(wo6Var.M());
                                    d56.c().i("page_recommend", "clk_", wo6Var.M());
                                    l18.c(wo6Var.a, wo6Var.k(), wo6Var.i(), 2);
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
                        TiebaStatic.log(wo6Var.P("c12642"));
                        d56.c().i("page_recommend", "clk_", wo6Var.q());
                        l18.c(wo6Var.a, wo6Var.k(), wo6Var.i(), 1);
                    }
                    if (i != 0) {
                        l18.d(wo6Var.a, this.b.b, wo6Var.i(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements xx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(f08 f08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var};
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
        public void a(h15 h15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, h15Var, view2) == null) && h15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    h15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    h15Var.objType = 4;
                } else {
                    h15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ux.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f08 a;

        public c(f08 f08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f08Var;
        }

        @Override // com.baidu.tieba.ux.a
        public void a(h15 h15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, h15Var) == null) && h15Var != null && h15Var.getThreadData() != null && h15Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(h15Var.getThreadData().originalThreadData, this.a.mContext, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ux.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f08 a;

        public d(f08 f08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f08Var;
        }

        @Override // com.baidu.tieba.ux.a
        public void a(h15 h15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, h15Var) == null) && h15Var != null && h15Var.getThreadData() != null && h15Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(h15Var.getThreadData().originalThreadData, this.a.mContext, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements fo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f08 a;

        public e(f08 f08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f08Var;
        }

        @Override // com.baidu.tieba.fo
        public void b(View view2, vn vnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, vnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (vnVar instanceof wo6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                wo6 wo6Var = (wo6) vnVar;
                wo6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), wo6Var);
                }
                ThreadCardUtils.jumpToPB((h15) wo6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().p(new uz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        y();
    }

    public void B(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void C(bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, boVar) == null) {
            this.f = boVar;
        }
    }

    @Override // com.baidu.tieba.f56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.e = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, wo6 wo6Var, ThreadCardViewHolder<wo6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wo6Var, threadCardViewHolder})) == null) {
            if (wo6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && wo6Var.a != null) {
                wo6Var.B(wo6Var.position + 1);
                wo6Var.a.statFloor = wo6Var.i();
                threadCardViewHolder.a().r(i);
                zn6.b().a(wo6Var.Q("c12641"));
                d56.c().i("page_recommend", "show_", wo6Var.s());
                threadCardViewHolder.a().b(this.e);
                threadCardViewHolder.p(true).s(this.d);
                threadCardViewHolder.l(wo6Var.showFollowBtn(), this.a);
                threadCardViewHolder.e(wo6Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                l18.p(wo6Var.a, this.b, wo6Var.i());
                l18.o(wo6Var.a, wo6Var.k(), wo6Var.i());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            wo6.f1184T = "c10705";
            wo6.U = "c10730";
            wo6.V = "c10731";
            wo6.W = "c10704";
            wo6.X = "c10755";
            wo6.Y = "c10710";
            wo6.Z = "c10736";
            wo6.a0 = "c10737";
            wo6.b0 = "c10711";
            wo6.c0 = "c10758";
            wo6.d0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: z */
    public ThreadCardViewHolder<wo6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            jz.b bVar = new jz.b(this.c.getPageActivity());
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
            ezVar2.x(vi.g(this.mContext, R.dimen.M_H_X003));
            ezVar2.setFrom("index");
            ezVar2.D(HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            bVar.h(ezVar2);
            ezVar2.B(new c(this));
            mz mzVar = new mz(this.c.getPageActivity());
            mzVar.r(Boolean.TRUE);
            mzVar.A(new d(this));
            bVar.h(mzVar);
            bVar.h(new fy(this.c.getPageActivity()));
            lz lzVar = new lz(this.c.getPageActivity());
            n15 n15Var = new n15();
            n15Var.b = 1;
            n15Var.h = 1;
            lzVar.B(n15Var);
            lzVar.D(1);
            lzVar.I(3);
            lzVar.E(2);
            lzVar.C(false);
            bVar.m(lzVar);
            jz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder<wo6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }
}
