package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.cx;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.tieba.zw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b58 extends yy7<zo6, ThreadCardViewHolder<zo6>> implements s46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.NEGFeedbackEventCallback d;
    public String e;
    public hn f;
    public jo6<zo6> g;

    /* loaded from: classes5.dex */
    public class a extends jo6<zo6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 b;

        public a(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, zo6 zo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zo6Var) == null) {
                int i = 1;
                co6.b().d(true);
                q46.c().h("page_recommend", "show_");
                if (view2 != null && zo6Var != null && zo6Var.getThreadData() != null && !StringUtils.isNull(zo6Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                        if (id == R.id.thread_card_voice) {
                            TiebaStatic.log(zo6Var.O());
                            q46.c().i("page_recommend", "clk_", zo6Var.O());
                        } else {
                            if (id == R.id.user_avatar) {
                                TiebaStatic.log(zo6Var.N());
                                q46.c().i("page_recommend", "clk_", zo6Var.N());
                                m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 4);
                            } else if (id == R.id.user_name) {
                                TiebaStatic.log(zo6Var.N());
                                q46.c().i("page_recommend", "clk_", zo6Var.N());
                                m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 4);
                            } else if (id == R.id.forum_name_text) {
                                TiebaStatic.log(zo6Var.f());
                                q46.c().i("page_recommend", "clk_", zo6Var.f());
                            } else if (id == R.id.god_reply_voice_btn) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.god_reply_content) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 1);
                            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(zo6Var.K());
                                    q46.c().i("page_recommend", "clk_", zo6Var.K());
                                    m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 2);
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
                        TiebaStatic.log(zo6Var.L("c12642"));
                        q46.c().i("page_recommend", "clk_", zo6Var.q());
                        m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 1);
                    }
                    if (i != 0) {
                        m68.d(zo6Var.a, this.b.b, zo6Var.h(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements cx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.cx.b
        public void a(w05 w05Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, w05Var, view2) == null) && w05Var != null) {
                if (view2.getId() == R.id.user_name) {
                    w05Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    w05Var.objType = 4;
                } else {
                    w05Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements zw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        public c(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        @Override // com.baidu.tieba.zw.a
        public void a(w05 w05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, w05Var) == null) && w05Var != null && w05Var.getThreadData() != null && w05Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(w05Var.getThreadData().originalThreadData, this.a.mContext, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements zw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        public d(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        @Override // com.baidu.tieba.zw.a
        public void a(w05 w05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, w05Var) == null) && w05Var != null && w05Var.getThreadData() != null && w05Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(w05Var.getThreadData().originalThreadData, this.a.mContext, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        public e(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof zo6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                zo6 zo6Var = (zo6) bnVar;
                zo6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), zo6Var);
                }
                ThreadCardUtils.jumpToPB((w05) zo6Var, view2.getContext(), 2, false);
                threadCardViewHolder.b().p(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b58(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void B(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nEGFeedbackEventCallback) == null) {
            this.d = nEGFeedbackEventCallback;
        }
    }

    public void C(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hnVar) == null) {
            this.f = hnVar;
        }
    }

    @Override // com.baidu.tieba.s46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.e = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, zo6 zo6Var, ThreadCardViewHolder<zo6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zo6Var, threadCardViewHolder})) == null) {
            if (zo6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && zo6Var.a != null) {
                zo6Var.A(zo6Var.position + 1);
                zo6Var.a.statFloor = zo6Var.h();
                threadCardViewHolder.b().r(i);
                co6.b().a(zo6Var.M("c12641"));
                q46.c().i("page_recommend", "show_", zo6Var.r());
                threadCardViewHolder.b().b(this.e);
                threadCardViewHolder.q(true).setNegEventCallback(this.d);
                threadCardViewHolder.m(zo6Var.showFollowBtn(), this.a);
                threadCardViewHolder.f(zo6Var);
                threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.g);
                m68.p(zo6Var.a, this.b, zo6Var.h());
                m68.o(zo6Var.a, zo6Var.i(), zo6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            zo6.f1193T = "c10705";
            zo6.U = "c10730";
            zo6.V = "c10731";
            zo6.W = "c10704";
            zo6.X = "c10755";
            zo6.Y = "c10710";
            zo6.Z = "c10736";
            zo6.a0 = "c10737";
            zo6.b0 = "c10711";
            zo6.c0 = "c10758";
            zo6.d0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: z */
    public ThreadCardViewHolder<zo6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.c.getPageActivity());
            cx cxVar = new cx(this.c.getPageActivity());
            cxVar.q(this.b);
            cxVar.g(1024);
            cxVar.z(new b(this));
            bVar.o(cxVar);
            iy iyVar = new iy(this.c);
            iyVar.s(Boolean.FALSE);
            iyVar.setFrom("index");
            bVar.n(iyVar);
            iy iyVar2 = new iy(this.c);
            iyVar2.s(Boolean.TRUE);
            iyVar2.y(BdUtilHelper.getDimens(this.mContext, R.dimen.M_H_X003));
            iyVar2.setFrom("index");
            iyVar2.E(HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            bVar.h(iyVar2);
            iyVar2.C(new c(this));
            qy qyVar = new qy(this.c.getPageActivity());
            qyVar.s(Boolean.TRUE);
            qyVar.B(new d(this));
            bVar.h(qyVar);
            bVar.h(new kx(this.c.getPageActivity()));
            py pyVar = new py(this.c.getPageActivity());
            c15 c15Var = new c15();
            c15Var.b = 1;
            c15Var.h = 1;
            pyVar.C(c15Var);
            pyVar.E(1);
            pyVar.J(3);
            pyVar.F(2);
            pyVar.D(false);
            bVar.m(pyVar);
            ny k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder<zo6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.b);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }
}
