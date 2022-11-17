package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.ax;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h47 extends kn<c56, AutoVideoCardViewHolder<c56>> implements mq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public c57 c;
    public String d;
    public Cdo e;
    public wy f;
    public m46<c56> g;

    /* loaded from: classes4.dex */
    public class a extends m46<c56> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h47 b;

        public a(h47 h47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h47Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m46
        /* renamed from: d */
        public void a(View view2, c56 c56Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, c56Var) == null) {
                f46.b().d(true);
                kq5.c().h("page_recommend", "show_");
                if (this.b.c != null && c56Var != null && c56Var.getThreadData() != null && !StringUtils.isNull(c56Var.getThreadData().getTid())) {
                    if (c56Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(c56Var.N(c56Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !f37.b(xg.g(c56Var.getThreadData().getTid(), 0L))) {
                        f37.a(xg.g(c56Var.getThreadData().getTid(), 0L));
                        this.b.c.e(xg.g(c56Var.getThreadData().getTid(), 0L), c56Var.D(), c56Var.r(), c56Var.n(), c56Var.c(), xg.e((String) view2.getTag(), 1), "homepage", c56Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.y(view2, c56Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy a;
        public final /* synthetic */ h47 b;

        public b(h47 h47Var, wy wyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h47Var, wyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h47Var;
            this.a = wyVar;
        }

        @Override // com.baidu.tieba.ax.a
        public void a(tr4 tr4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, tr4Var) != null) || tr4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (tr4Var instanceof c56) {
                tr4Var.objType = 5;
                ThreadCardUtils.jumpToPB(tr4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(tr4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h47 a;

        public c(h47 h47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h47Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof c56) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                c56 c56Var = (c56) xnVar;
                c56Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), c56Var);
                }
                ThreadCardUtils.jumpToPB((tr4) c56Var, view2.getContext(), 2, false, ex.a((Cdo) viewGroup, view2, i));
                autoVideoCardViewHolder.a().o(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h47(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.g = new a(this);
        this.b = tbPageContext;
        z();
    }

    public void C(c57 c57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c57Var) == null) {
            this.c = c57Var;
        }
    }

    public void D(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cdo) == null) {
            this.e = cdo;
        }
    }

    @Override // com.baidu.tieba.mq5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: A */
    public AutoVideoCardViewHolder<c56> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            l57 l57Var = new l57(this.b.getPageActivity());
            l57Var.y(new b(this, l57Var));
            this.f = l57Var;
            l57Var.A(this.a);
            this.f.x("index");
            this.f.B("2001");
            bVar.n(this.f);
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<c56> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.p(this.g);
            k.r(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, c56 c56Var, AutoVideoCardViewHolder<c56> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, c56Var, autoVideoCardViewHolder})) == null) {
            if (c56Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            c56Var.I(c56Var.position + 1);
            c56Var.a.statFloor = c56Var.n();
            autoVideoCardViewHolder.a().q(i);
            c56Var.T = 0;
            f46.b().a(c56Var.B());
            autoVideoCardViewHolder.u(x(c56Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(c56Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            h57.i(c56Var.a, this.a, c56Var.n());
            h57.h(c56Var.a, c56Var.r(), c56Var.n());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (wyVar = this.f) != null) {
            wyVar.v();
        }
    }

    public void onResume() {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (wyVar = this.f) != null) {
            wyVar.w();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c56.V = "c10708";
            c56.W = "c10735";
            c56.X = "c10709";
            c56.Y = "c10734";
            c56.Z = "c11929";
            c56.a0 = "c11928";
            c56.b0 = "c10756";
        }
    }

    public final gd8 x(c56 c56Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, c56Var)) == null) {
            if (c56Var != null) {
                gd8 gd8Var = new gd8();
                gd8Var.a = "1";
                gd8Var.c = c56Var.g;
                if (c56Var.getThreadData() != null) {
                    gd8Var.d = String.valueOf(c56Var.getThreadData().getFid());
                    gd8Var.v = c56Var.getThreadData().getNid();
                    if (c56Var.getThreadData().getThreadVideoInfo() != null) {
                        gd8Var.m = c56Var.getThreadData().getThreadVideoInfo().video_md5;
                        gd8Var.p = String.valueOf(c56Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                gd8Var.k = c56Var.h();
                gd8Var.f = c56Var.r();
                gd8Var.l = c56Var.c();
                gd8Var.h = c56Var.D();
                gd8Var.e = TbadkCoreApplication.getCurrentAccount();
                gd8Var.q = String.valueOf(c56Var.n());
                if (c56Var.getThreadData() != null && c56Var.getThreadData().getBaijiahaoData() != null) {
                    gd8Var.t = c56Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    gd8Var.u = c56Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return gd8Var;
                }
                return gd8Var;
            }
            return null;
        }
        return (gd8) invokeL.objValue;
    }

    public final void y(View view2, c56 c56Var) {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, view2, c56Var) == null) && (wyVar = this.f) != null && wyVar.s() != null && this.f.s().getMainView() != null) {
            if (view2.getId() == this.f.s().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, c56Var);
                h57.d(c56Var.a, this.a, c56Var.n(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(c56Var.P()));
                h57.c(c56Var.a, c56Var.r(), c56Var.n(), 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0921dd) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(c56Var.N(c56Var.a)));
                h57.c(c56Var.a, c56Var.r(), c56Var.n(), 1);
            }
        }
    }
}
