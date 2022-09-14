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
/* loaded from: classes3.dex */
public class ex6 extends qn<l26, AutoVideoCardViewHolder<l26>> implements go5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public jo e;
    public az f;
    public v16<l26> g;

    /* loaded from: classes3.dex */
    public class a extends v16<l26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex6 b;

        public a(ex6 ex6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ex6Var;
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

    /* loaded from: classes3.dex */
    public class b implements gx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az a;
        public final /* synthetic */ ex6 b;

        public b(ex6 ex6Var, az azVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex6Var, azVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ex6Var;
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

    /* loaded from: classes3.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex6 a;

        public c(ex6 ex6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof wn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                wn wnVar = (wn) cdo;
                if (wnVar.c() instanceof l26) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    l26 l26Var = (l26) wnVar.c();
                    l26Var.f = 1;
                    if (this.a.g != null) {
                        this.a.g.a(threadCardViewHolder.getView(), l26Var);
                    }
                    ThreadCardUtils.jumpToPB((lq4) l26Var, view2.getContext(), 1, false, kx.a((jo) viewGroup, view2, i));
                    threadCardViewHolder.a().o(new dz.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ex6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
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
        this.g = new a(this);
        this.c = tbPageContext;
        this.b = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: A */
    public View onFillContentViewHolder(int i, View view2, ViewGroup viewGroup, l26 l26Var, AutoVideoCardViewHolder<l26> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, l26Var, autoVideoCardViewHolder})) == null) {
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
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(l26Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, l26 l26Var, AutoVideoCardViewHolder<l26> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, l26Var, autoVideoCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void C(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, joVar) == null) {
            this.e = joVar;
        }
    }

    @Override // com.baidu.tieba.go5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    @Override // com.baidu.tieba.qn
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c26.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qn
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? c26.J : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qn
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c26.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qn
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdUniqueId bdUniqueId = this.b;
            return bdUniqueId != null ? bdUniqueId : c26.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final ma8 w(l26 l26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, l26Var)) == null) {
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
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, view2, l26Var) == null) || (azVar = this.f) == null || azVar.p() == null || this.f.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.f.p().getMainView().getId()) {
            ew6.b(view2, l26Var, 4);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09217e) {
            ew6.b(view2, l26Var, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: y */
    public AutoVideoCardViewHolder<l26> onCreateContentViewHolder(ViewGroup viewGroup, l26 l26Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, viewGroup, l26Var)) == null) {
            sy.b bVar = new sy.b(this.c.getPageActivity(), false);
            t27 t27Var = new t27(this.c.getPageActivity());
            t27Var.x(this.a);
            t27Var.u("concern_tab");
            t27Var.v(new b(this, t27Var));
            this.f = t27Var;
            bVar.n(t27Var);
            az azVar = this.f;
            if (azVar != null) {
                azVar.y("2001");
            }
            sy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<l26> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.p(this.g);
            k.r(1);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: z */
    public AutoVideoCardViewHolder<l26> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, viewGroup)) == null) {
            return null;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }
}
