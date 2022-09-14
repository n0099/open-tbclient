package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.gx;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fx6 extends qn<l26, AutoVideoCardViewHolder<l26>> implements go5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public jo d;
    public az e;
    public v16<l26> f;

    /* loaded from: classes4.dex */
    public class a extends v16<l26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx6 b;

        public a(fx6 fx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v16
        /* renamed from: d */
        public void a(View view2, l26 l26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, l26Var) == null) {
                o16.b().d(true);
                eo5.c().h("page_recommend", "show_");
                if (l26Var == null || l26Var.getThreadData() == null || StringUtils.isNull(l26Var.getThreadData().getTid())) {
                    return;
                }
                if (l26Var.getThreadData().middle_page_num <= 0) {
                    this.b.x(view2, l26Var);
                    return;
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(l26Var.N(l26Var.getThreadData())));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements gx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az a;
        public final /* synthetic */ fx6 b;

        public b(fx6 fx6Var, az azVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx6Var, azVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fx6Var;
            this.a = azVar;
        }

        @Override // com.baidu.tieba.gx.a
        public void a(lq4 lq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, lq4Var) == null) || lq4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(lq4Var instanceof l26)) {
                ThreadCardUtils.jumpToPB(lq4Var, this.b.mContext, 1, false, computeViewArea);
                return;
            }
            lq4Var.objType = 5;
            ThreadCardUtils.jumpToPB(lq4Var, this.b.mContext, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx6 a;

        public c(fx6 fx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fx6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof l26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                l26 l26Var = (l26) cdo;
                l26Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), l26Var);
                }
                ThreadCardUtils.jumpToPB((lq4) l26Var, view2.getContext(), 1, false, kx.a((jo) viewGroup, view2, i));
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fx6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void A(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, joVar) == null) {
            this.d = joVar;
        }
    }

    @Override // com.baidu.tieba.go5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c = str;
        }
    }

    public final ma8 w(l26 l26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, l26Var)) == null) {
            if (l26Var != null) {
                ma8 ma8Var = new ma8();
                ma8Var.a = "7";
                ma8Var.c = l26Var.g;
                if (l26Var.getThreadData() != null) {
                    ma8Var.d = String.valueOf(l26Var.getThreadData().getFid());
                    if (l26Var.getThreadData().getThreadVideoInfo() != null) {
                        ma8Var.m = l26Var.getThreadData().getThreadVideoInfo().video_md5;
                        ma8Var.p = String.valueOf(l26Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                ma8Var.k = l26Var.h();
                ma8Var.f = l26Var.r();
                ma8Var.l = l26Var.c();
                ma8Var.h = l26Var.D();
                ma8Var.e = TbadkCoreApplication.getCurrentAccount();
                ma8Var.q = String.valueOf(l26Var.n());
                return ma8Var;
            }
            return null;
        }
        return (ma8) invokeL.objValue;
    }

    public final void x(View view2, l26 l26Var) {
        az azVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, view2, l26Var) == null) || (azVar = this.e) == null || azVar.p() == null || this.e.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.e.p().getMainView().getId()) {
            ew6.b(view2, l26Var, 4);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09217e) {
            ew6.b(view2, l26Var, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: y */
    public AutoVideoCardViewHolder<l26> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.b.getPageActivity(), false);
            t27 t27Var = new t27(this.b.getPageActivity());
            t27Var.x(this.a);
            t27Var.u("concern_tab");
            t27Var.v(new b(this, t27Var));
            this.e = t27Var;
            bVar.n(t27Var);
            az azVar = this.e;
            if (azVar != null) {
                azVar.y("2001");
            }
            sy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            AutoVideoCardViewHolder<l26> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.p(this.f);
            k.r(1);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, l26 l26Var, AutoVideoCardViewHolder<l26> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, l26Var, autoVideoCardViewHolder})) == null) {
            if (l26Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            l26Var.I(l26Var.position + 1);
            o16.b().a(l26Var.f("c12351"));
            autoVideoCardViewHolder.a().q(i);
            l26Var.T = 0;
            autoVideoCardViewHolder.u(w(l26Var));
            if (autoVideoCardViewHolder.a() instanceof fo5) {
                autoVideoCardViewHolder.a().b(this.c);
            }
            autoVideoCardViewHolder.e(l26Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
