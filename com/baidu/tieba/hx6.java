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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hx6 extends qn<x26, ThreadCardViewHolder<x26>> implements to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public boolean d;
    public jo e;
    public i26<x26> f;

    /* loaded from: classes4.dex */
    public class a extends i26<x26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx6 b;

        public a(hx6 hx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, x26 x26Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, x26Var) == null) || view2 == null || x26Var == null || x26Var.getThreadData() == null || StringUtils.isNull(x26Var.getThreadData().getTid())) {
                return;
            }
            this.b.w(view2, x26Var);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx6 a;

        public b(hx6 hx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof x26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                x26 x26Var = (x26) cdo;
                x26Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), x26Var);
                }
                ThreadCardUtils.jumpToPB((yq4) x26Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hx6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.d = true;
        this.f = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: u */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.b.getPageActivity(), false);
            ux uxVar = new ux(this.b.getPageActivity());
            uxVar.y(this.d);
            uxVar.x(ImageViewerConfig.FROM_CONCERN);
            bVar.h(uxVar);
            sy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.e);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: v */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, x26 x26Var, ThreadCardViewHolder<x26> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, x26Var, threadCardViewHolder})) == null) {
            if (x26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || x26Var.a == null) {
                return null;
            }
            x26Var.I(x26Var.position + 1);
            b26.b().a(new StatisticItem("c13424"));
            threadCardViewHolder.a().q(i);
            if (threadCardViewHolder.a() instanceof so5) {
                threadCardViewHolder.a().b(this.c);
            }
            threadCardViewHolder.e(x26Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.f);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void w(View view2, x26 x26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, x26Var) == null) {
            int id = view2.getId();
            if (view2.getId() == R.id.obfuscated_res_0x7f092180) {
                sw6.b(view2, x26Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f090cd9) {
                StatisticItem statisticItem = new StatisticItem("c13423");
                statisticItem.param("obj_locate", 4);
                if (x26Var != null) {
                    statisticItem.param("tid", x26Var.g);
                    ThreadData threadData = x26Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", x26Var.a.getTopAgreePost().L());
                    }
                }
                TiebaStatic.log(statisticItem);
            } else if (id == R.id.obfuscated_res_0x7f090cd4) {
                StatisticItem statisticItem2 = new StatisticItem("c13423");
                statisticItem2.param("obj_locate", 2);
                if (x26Var != null) {
                    statisticItem2.param("tid", x26Var.g);
                    ThreadData threadData2 = x26Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", x26Var.a.getTopAgreePost().L());
                    }
                }
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.obfuscated_res_0x7f090cd7 || id == R.id.obfuscated_res_0x7f090cd8) {
                StatisticItem statisticItem3 = new StatisticItem("c13423");
                statisticItem3.param("obj_locate", 1);
                if (x26Var != null) {
                    statisticItem3.param("tid", x26Var.g);
                    ThreadData threadData3 = x26Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", x26Var.a.getTopAgreePost().L());
                    }
                }
                TiebaStatic.log(statisticItem3);
            } else if (id == R.id.obfuscated_res_0x7f090cd3) {
                StatisticItem statisticItem4 = new StatisticItem("c13423");
                statisticItem4.param("obj_locate", 5);
                if (x26Var != null) {
                    statisticItem4.param("tid", x26Var.g);
                    ThreadData threadData4 = x26Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", x26Var.a.getTopAgreePost().L());
                    }
                }
                TiebaStatic.log(statisticItem4);
            } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.obfuscated_res_0x7f090cd5) instanceof Integer)) {
                StatisticItem statisticItem5 = new StatisticItem("c13423");
                statisticItem5.param("obj_locate", 3);
                if (x26Var != null) {
                    statisticItem5.param("tid", x26Var.g);
                    ThreadData threadData5 = x26Var.a;
                    if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                        statisticItem5.param("pid", x26Var.a.getTopAgreePost().L());
                    }
                }
                TiebaStatic.log(statisticItem5);
            }
        }
    }

    public void x(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, joVar) == null) {
            this.e = joVar;
        }
    }
}
