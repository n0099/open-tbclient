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
/* loaded from: classes3.dex */
public class e07 extends cn<u06, AutoVideoCardViewHolder<u06>> implements vl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public a17 c;
    public String d;
    public vn e;
    public my f;
    public h06<u06> g;

    /* loaded from: classes3.dex */
    public class a extends h06<u06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e07 b;

        public a(e07 e07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h06
        /* renamed from: d */
        public void a(View view2, u06 u06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, u06Var) == null) {
                a06.b().d(true);
                tl5.c().h("page_recommend", "show_");
                if (this.b.c == null || u06Var == null || u06Var.getThreadData() == null || StringUtils.isNull(u06Var.getThreadData().getTid())) {
                    return;
                }
                if (u06Var.getThreadData().middle_page_num > 0) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(u06Var.N(u06Var.getThreadData())));
                    return;
                }
                if ((view2.getTag() instanceof String) && !dz6.b(pg.g(u06Var.getThreadData().getTid(), 0L))) {
                    dz6.a(pg.g(u06Var.getThreadData().getTid(), 0L));
                    this.b.c.e(pg.g(u06Var.getThreadData().getTid(), 0L), u06Var.D(), u06Var.r(), u06Var.n(), u06Var.c(), pg.e((String) view2.getTag(), 1), "homepage", u06Var.getThreadData().getBaijiahaoData());
                }
                this.b.y(view2, u06Var);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements sw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my a;
        public final /* synthetic */ e07 b;

        public b(e07 e07Var, my myVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e07Var, myVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e07Var;
            this.a = myVar;
        }

        @Override // com.baidu.tieba.sw.a
        public void a(go4 go4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, go4Var) == null) || go4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(go4Var instanceof u06)) {
                ThreadCardUtils.jumpToPB(go4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            go4Var.objType = 5;
            ThreadCardUtils.jumpToPB(go4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e07 a;

        public c(e07 e07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e07Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (pnVar instanceof u06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                u06 u06Var = (u06) pnVar;
                u06Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), u06Var);
                }
                ThreadCardUtils.jumpToPB((go4) u06Var, view2.getContext(), 2, false, ww.a((vn) viewGroup, view2, i));
                autoVideoCardViewHolder.a().o(new py.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e07(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    public AutoVideoCardViewHolder<u06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.b.getPageActivity(), false);
            m17 m17Var = new m17(this.b.getPageActivity());
            m17Var.v(new b(this, m17Var));
            this.f = m17Var;
            m17Var.x(this.a);
            this.f.u("index");
            this.f.y("2001");
            bVar.n(this.f);
            ey k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<u06> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
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
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, u06 u06Var, AutoVideoCardViewHolder<u06> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, u06Var, autoVideoCardViewHolder})) == null) {
            if (u06Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            u06Var.I(u06Var.position + 1);
            u06Var.a.statFloor = u06Var.n();
            autoVideoCardViewHolder.a().q(i);
            u06Var.T = 0;
            a06.b().a(u06Var.B());
            autoVideoCardViewHolder.u(x(u06Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(u06Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            h17.i(u06Var.a, this.a, u06Var.n());
            h17.h(u06Var.a, u06Var.r(), u06Var.n());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void C(a17 a17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a17Var) == null) {
            this.c = a17Var;
        }
    }

    public void D(vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vnVar) == null) {
            this.e = vnVar;
        }
    }

    @Override // com.baidu.tieba.vl5
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

    public final e98 x(u06 u06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, u06Var)) == null) {
            if (u06Var != null) {
                e98 e98Var = new e98();
                e98Var.a = "1";
                e98Var.c = u06Var.g;
                if (u06Var.getThreadData() != null) {
                    e98Var.d = String.valueOf(u06Var.getThreadData().getFid());
                    e98Var.v = u06Var.getThreadData().getNid();
                    if (u06Var.getThreadData().getThreadVideoInfo() != null) {
                        e98Var.m = u06Var.getThreadData().getThreadVideoInfo().video_md5;
                        e98Var.p = String.valueOf(u06Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                e98Var.k = u06Var.h();
                e98Var.f = u06Var.r();
                e98Var.l = u06Var.c();
                e98Var.h = u06Var.D();
                e98Var.e = TbadkCoreApplication.getCurrentAccount();
                e98Var.q = String.valueOf(u06Var.n());
                if (u06Var.getThreadData() == null || u06Var.getThreadData().getBaijiahaoData() == null) {
                    return e98Var;
                }
                e98Var.t = u06Var.getThreadData().getBaijiahaoData().oriUgcNid;
                e98Var.u = u06Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return e98Var;
            }
            return null;
        }
        return (e98) invokeL.objValue;
    }

    public final void y(View view2, u06 u06Var) {
        my myVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, view2, u06Var) == null) || (myVar = this.f) == null || myVar.p() == null || this.f.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.f.p().getMainView().getId()) {
            CardLinkageManager.INSTANCE.cancelHighLight(this.e, u06Var);
            h17.d(u06Var.a, this.a, u06Var.n(), 4);
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(u06Var.P()));
            h17.c(u06Var.a, u06Var.r(), u06Var.n(), 2);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09212d) {
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(u06Var.N(u06Var.a)));
            h17.c(u06Var.a, u06Var.r(), u06Var.n(), 1);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            u06.V = "c10708";
            u06.W = "c10735";
            u06.X = "c10709";
            u06.Y = "c10734";
            u06.Z = "c11929";
            u06.a0 = "c11928";
            u06.b0 = "c10756";
        }
    }
}
