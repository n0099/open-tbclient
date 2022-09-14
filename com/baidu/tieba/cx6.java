package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.dz;
import com.baidu.tieba.jx;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cx6 extends qn<k26, ThreadCardViewHolder<k26>> implements go5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public boolean d;
    public v16<k26> e;

    /* loaded from: classes3.dex */
    public class a extends v16<k26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(cx6 cx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v16
        /* renamed from: d */
        public void a(View view2, k26 k26Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, k26Var) == null) || view2 == null || k26Var == null || k26Var.getThreadData() == null || StringUtils.isNull(k26Var.getThreadData().getTid())) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09217e || id == R.id.obfuscated_res_0x7f092192) {
                ew6.b(view2, k26Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f092180) {
                ew6.b(view2, k26Var, 6);
            } else if (id == R.id.obfuscated_res_0x7f092486 || id == R.id.obfuscated_res_0x7f0924b4) {
                ew6.b(view2, k26Var, 1);
            } else if (id == R.id.obfuscated_res_0x7f090cda) {
                StatisticItem statisticItem = new StatisticItem("c13423");
                statisticItem.param("obj_locate", 4);
                if (k26Var != null) {
                    statisticItem.param("tid", k26Var.g);
                    ThreadData threadData = k26Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", k26Var.a.getTopAgreePost().L());
                    }
                }
                TiebaStatic.log(statisticItem);
            } else if (id == R.id.obfuscated_res_0x7f090cd5) {
                StatisticItem statisticItem2 = new StatisticItem("c13423");
                statisticItem2.param("obj_locate", 2);
                if (k26Var != null) {
                    statisticItem2.param("tid", k26Var.g);
                    ThreadData threadData2 = k26Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", k26Var.a.getTopAgreePost().L());
                    }
                }
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.obfuscated_res_0x7f090cd8 || id == R.id.obfuscated_res_0x7f090cd9) {
                StatisticItem statisticItem3 = new StatisticItem("c13423");
                statisticItem3.param("obj_locate", 1);
                if (k26Var != null) {
                    statisticItem3.param("tid", k26Var.g);
                    ThreadData threadData3 = k26Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", k26Var.a.getTopAgreePost().L());
                    }
                }
                TiebaStatic.log(statisticItem3);
            } else if (id == R.id.obfuscated_res_0x7f090cd4) {
                StatisticItem statisticItem4 = new StatisticItem("c13423");
                statisticItem4.param("obj_locate", 5);
                if (k26Var != null) {
                    statisticItem4.param("tid", k26Var.g);
                    ThreadData threadData4 = k26Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", k26Var.a.getTopAgreePost().L());
                    }
                }
                TiebaStatic.log(statisticItem4);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090a8f) {
                ew6.b(view2, k26Var, 7);
            } else if (view2 instanceof TbImageView) {
                if (view2.getTag(R.id.obfuscated_res_0x7f090cd6) instanceof Integer) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    if (k26Var != null) {
                        statisticItem5.param("tid", k26Var.g);
                        ThreadData threadData5 = k26Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", k26Var.a.getTopAgreePost().L());
                        }
                    }
                    TiebaStatic.log(statisticItem5);
                    return;
                }
                ew6.b(view2, k26Var, 6);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements jx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(cx6 cx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jx.b
        public void a(lq4 lq4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, lq4Var, view2) == null) || lq4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b4) {
                lq4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092486) {
                lq4Var.objType = 4;
            } else {
                lq4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cx6 a;

        public c(cx6 cx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cx6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof k26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                k26 k26Var = (k26) cdo;
                k26Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), k26Var);
                }
                ThreadCardUtils.jumpToPB((lq4) k26Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cx6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.go5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: t */
    public ThreadCardViewHolder<k26> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.b.getPageActivity());
            jx jxVar = new jx(this.b.getPageActivity());
            jxVar.u(this.a);
            jxVar.c(128);
            jxVar.d(1024);
            jxVar.t(new b(this));
            bVar.o(jxVar);
            xy xyVar = new xy(this.b.getPageActivity());
            bVar.n(xyVar);
            xyVar.v(2);
            bVar.h(new wy(this.b.getPageActivity()));
            bVar.h(new qx(this.b.getPageActivity()));
            ux uxVar = new ux(this.b.getPageActivity());
            uxVar.y(this.d);
            uxVar.x(ImageViewerConfig.FROM_CONCERN);
            bVar.h(uxVar);
            uy uyVar = new uy(this.b.getPageActivity());
            rq4 rq4Var = new rq4();
            rq4Var.b = 9;
            rq4Var.h = 9;
            uyVar.w(rq4Var);
            uyVar.y(9);
            uyVar.D(4);
            uyVar.z(1);
            uyVar.x(false);
            bVar.m(uyVar);
            sy i = bVar.i();
            i.r(1);
            ThreadCardViewHolder<k26> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, k26 k26Var, ThreadCardViewHolder<k26> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, k26Var, threadCardViewHolder})) == null) {
            if (k26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || k26Var.a == null) {
                return null;
            }
            k26Var.I(k26Var.position + 1);
            o16.b().a(k26Var.f("c12351"));
            threadCardViewHolder.a().b(this.c);
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.j();
            threadCardViewHolder.e(k26Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.e);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
