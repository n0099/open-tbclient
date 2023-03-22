package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbLabelWidget;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gh7 extends tm<ag6, ThreadCardViewHolder<ag6>> implements jx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public ki7 c;
    public String d;
    public mn e;
    public lf6<ag6> f;

    /* loaded from: classes4.dex */
    public class a extends lf6<ag6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh7 b;

        public a(gh7 gh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        public void a(View view2, ag6 ag6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ag6Var) == null) {
                ef6.b().d(true);
                hx5.c().h("page_recommend", "show_");
                if (view2 != null && this.b.c != null && ag6Var != null && ag6Var.getThreadData() != null && !StringUtils.isNull(ag6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !pg7.b(gg.g(ag6Var.getThreadData().getTid(), 0L))) {
                        pg7.a(gg.g(ag6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(gg.g(ag6Var.getThreadData().getTid(), 0L), ag6Var.w(), ag6Var.m(), ag6Var.k(), ag6Var.c(), gg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, ag6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.z(view2, ag6Var);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TbLabelWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wx a;

        public b(gh7 gh7Var, wx wxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh7Var, wxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wxVar;
        }

        @Override // com.baidu.tbadk.widget.TbLabelWidget.b
        public void a(View view2, int i, TbLabelWidget.c cVar) {
            ThreadRecommendInfoData threadRecommendInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, view2, i, cVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c14686");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 1);
                if (this.a.x() != null) {
                    ThreadData x = this.a.x();
                    statisticItem.param("tid", x.getTid());
                    if (!ListUtils.isEmpty(x.getThreadRecommendInfoDataList()) && (threadRecommendInfoData = x.getThreadRecommendInfoDataList().get(0)) != null) {
                        statisticItem.param("obj_param1", threadRecommendInfoData.businessId);
                    }
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh7 a;

        public c(gh7 gh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gh7Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof ag6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ag6 ag6Var = (ag6) gnVar;
                ag6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), ag6Var);
                }
                ThreadCardUtils.jumpToPB((hw4) ag6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().p(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gh7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new a(this);
        this.b = tbPageContext;
    }

    public void B(ki7 ki7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ki7Var) == null) {
            this.c = ki7Var;
        }
    }

    public void C(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mnVar) == null) {
            this.e = mnVar;
        }
    }

    @Override // com.baidu.tieba.jx5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(ag6 ag6Var) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ag6Var) == null) && ag6Var != null && (threadData = ag6Var.a) != null && threadData.getThreadRecommendInfoDataList() != null) {
            StatisticItem statisticItem = new StatisticItem("c14686");
            ThreadRecommendInfoData threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(ag6Var.a.getThreadRecommendInfoDataList(), 0);
            if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", 1);
                statisticItem.param("tid", ag6Var.a.getTid());
                statisticItem.param("obj_param1", threadRecommendInfoData.businessId);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.b.getPageActivity(), false);
            wx wxVar = new wx(this.b.getPageActivity());
            wxVar.z(new b(this, wxVar));
            wxVar.w();
            wxVar.A(this.b);
            bVar.h(wxVar);
            cy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.e);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ag6Var, threadCardViewHolder})) == null) {
            if (ag6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && ag6Var.a != null) {
                A(ag6Var);
                ag6Var.E(ag6Var.position + 1);
                ag6Var.a.statFloor = ag6Var.k();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.d);
                threadCardViewHolder.e(ag6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.f);
                ef6.b().a(ag6Var.u());
                hx5.c().a(ag6Var.u());
                pi7.p(ag6Var.a, this.a, ag6Var.k());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(View view2, ag6 ag6Var) {
        StatisticItem t;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, ag6Var) == null) {
            int id = view2.getId();
            if (ag6Var == null) {
                return;
            }
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id != R.id.forum_name_text && id != R.id.forum_enter_button) {
                    i = 0;
                } else {
                    TiebaStatic.log(ag6Var.h());
                    hx5.c().i("page_recommend", "clk_", ag6Var.h());
                    i = 9;
                }
            } else {
                if (ag6Var.isVideoThreadType()) {
                    t = ag6Var.v();
                } else {
                    t = ag6Var.t();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(t));
                hx5.c().i("page_recommend", "clk_", t);
                i = 1;
                pi7.b(ag6Var.a, ag6Var.m(), ag6Var.k());
            }
            if (i != 0) {
                pi7.d(ag6Var.a, this.a, ag6Var.k(), i);
            }
        }
    }
}
