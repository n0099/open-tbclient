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
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.tieba.sw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g07 extends cn<w06, AutoVideoCardViewHolder<w06>> implements xl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public c17 c;
    public String d;
    public vn e;
    public my f;
    public j06<w06> g;

    /* loaded from: classes4.dex */
    public class a extends j06<w06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 b;

        public a(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j06
        /* renamed from: d */
        public void a(View view2, w06 w06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, w06Var) == null) {
                c06.b().d(true);
                vl5.c().h("page_recommend", "show_");
                if (this.b.c == null || w06Var == null || w06Var.getThreadData() == null || StringUtils.isNull(w06Var.getThreadData().getTid())) {
                    return;
                }
                if (w06Var.getThreadData().middle_page_num > 0) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(w06Var.N(w06Var.getThreadData())));
                    return;
                }
                if ((view2.getTag() instanceof String) && !fz6.b(pg.g(w06Var.getThreadData().getTid(), 0L))) {
                    fz6.a(pg.g(w06Var.getThreadData().getTid(), 0L));
                    this.b.c.e(pg.g(w06Var.getThreadData().getTid(), 0L), w06Var.D(), w06Var.r(), w06Var.n(), w06Var.c(), pg.e((String) view2.getTag(), 1), "homepage", w06Var.getThreadData().getBaijiahaoData());
                }
                this.b.y(view2, w06Var);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements sw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my a;
        public final /* synthetic */ g07 b;

        public b(g07 g07Var, my myVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var, myVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g07Var;
            this.a = myVar;
        }

        @Override // com.baidu.tieba.sw.a
        public void a(ho4 ho4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ho4Var) == null) || ho4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(ho4Var instanceof w06)) {
                ThreadCardUtils.jumpToPB(ho4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ho4Var.objType = 5;
            ThreadCardUtils.jumpToPB(ho4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        public c(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (pnVar instanceof w06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                w06 w06Var = (w06) pnVar;
                w06Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), w06Var);
                }
                ThreadCardUtils.jumpToPB((ho4) w06Var, view2.getContext(), 2, false, ww.a((vn) viewGroup, view2, i));
                autoVideoCardViewHolder.a().o(new py.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g07(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: A */
    public AutoVideoCardViewHolder<w06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.b.getPageActivity(), false);
            o17 o17Var = new o17(this.b.getPageActivity());
            o17Var.v(new b(this, o17Var));
            this.f = o17Var;
            o17Var.x(this.a);
            this.f.u("index");
            this.f.y("2001");
            bVar.n(this.f);
            ey k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<w06> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.p(this.g);
            k.r(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, w06 w06Var, AutoVideoCardViewHolder<w06> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, w06Var, autoVideoCardViewHolder})) == null) {
            if (w06Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            w06Var.I(w06Var.position + 1);
            w06Var.a.statFloor = w06Var.n();
            autoVideoCardViewHolder.a().q(i);
            w06Var.T = 0;
            c06.b().a(w06Var.B());
            autoVideoCardViewHolder.u(x(w06Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(w06Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            j17.i(w06Var.a, this.a, w06Var.n());
            j17.h(w06Var.a, w06Var.r(), w06Var.n());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void C(c17 c17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c17Var) == null) {
            this.c = c17Var;
        }
    }

    public void D(vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vnVar) == null) {
            this.e = vnVar;
        }
    }

    @Override // com.baidu.tieba.xl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    public void onPause() {
        my myVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (myVar = this.f) == null) {
            return;
        }
        myVar.s();
    }

    public void onResume() {
        my myVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (myVar = this.f) == null) {
            return;
        }
        myVar.t();
    }

    public final g98 x(w06 w06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, w06Var)) == null) {
            if (w06Var != null) {
                g98 g98Var = new g98();
                g98Var.a = "1";
                g98Var.c = w06Var.g;
                if (w06Var.getThreadData() != null) {
                    g98Var.d = String.valueOf(w06Var.getThreadData().getFid());
                    g98Var.v = w06Var.getThreadData().getNid();
                    if (w06Var.getThreadData().getThreadVideoInfo() != null) {
                        g98Var.m = w06Var.getThreadData().getThreadVideoInfo().video_md5;
                        g98Var.p = String.valueOf(w06Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                g98Var.k = w06Var.h();
                g98Var.f = w06Var.r();
                g98Var.l = w06Var.c();
                g98Var.h = w06Var.D();
                g98Var.e = TbadkCoreApplication.getCurrentAccount();
                g98Var.q = String.valueOf(w06Var.n());
                if (w06Var.getThreadData() == null || w06Var.getThreadData().getBaijiahaoData() == null) {
                    return g98Var;
                }
                g98Var.t = w06Var.getThreadData().getBaijiahaoData().oriUgcNid;
                g98Var.u = w06Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return g98Var;
            }
            return null;
        }
        return (g98) invokeL.objValue;
    }

    public final void y(View view2, w06 w06Var) {
        my myVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, view2, w06Var) == null) || (myVar = this.f) == null || myVar.p() == null || this.f.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.f.p().getMainView().getId()) {
            CardLinkageManager.INSTANCE.cancelHighLight(this.e, w06Var);
            j17.d(w06Var.a, this.a, w06Var.n(), 4);
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(w06Var.P()));
            j17.c(w06Var.a, w06Var.r(), w06Var.n(), 2);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09212d) {
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(w06Var.N(w06Var.a)));
            j17.c(w06Var.a, w06Var.r(), w06Var.n(), 1);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            w06.V = "c10708";
            w06.W = "c10735";
            w06.X = "c10709";
            w06.Y = "c10734";
            w06.Z = "c11929";
            w06.a0 = "c11928";
            w06.b0 = "c10756";
        }
    }
}
