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
import com.baidu.tieba.dz;
import com.baidu.tieba.gx;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d27 extends qn<y26, AutoVideoCardViewHolder<y26>> implements to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public y27 c;
    public String d;
    public jo e;
    public az f;
    public i26<y26> g;

    /* loaded from: classes3.dex */
    public class a extends i26<y26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d27 b;

        public a(d27 d27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, y26 y26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, y26Var) == null) {
                b26.b().d(true);
                ro5.c().h("page_recommend", "show_");
                if (this.b.c == null || y26Var == null || y26Var.getThreadData() == null || StringUtils.isNull(y26Var.getThreadData().getTid())) {
                    return;
                }
                if (y26Var.getThreadData().middle_page_num > 0) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(y26Var.N(y26Var.getThreadData())));
                    return;
                }
                if ((view2.getTag() instanceof String) && !c17.b(dh.g(y26Var.getThreadData().getTid(), 0L))) {
                    c17.a(dh.g(y26Var.getThreadData().getTid(), 0L));
                    this.b.c.e(dh.g(y26Var.getThreadData().getTid(), 0L), y26Var.D(), y26Var.r(), y26Var.n(), y26Var.c(), dh.e((String) view2.getTag(), 1), "homepage", y26Var.getThreadData().getBaijiahaoData());
                }
                this.b.y(view2, y26Var);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements gx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az a;
        public final /* synthetic */ d27 b;

        public b(d27 d27Var, az azVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d27Var, azVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d27Var;
            this.a = azVar;
        }

        @Override // com.baidu.tieba.gx.a
        public void a(yq4 yq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, yq4Var) == null) || yq4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(yq4Var instanceof y26)) {
                ThreadCardUtils.jumpToPB(yq4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            yq4Var.objType = 5;
            ThreadCardUtils.jumpToPB(yq4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d27 a;

        public c(d27 d27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d27Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof y26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                y26 y26Var = (y26) cdo;
                y26Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), y26Var);
                }
                ThreadCardUtils.jumpToPB((yq4) y26Var, view2.getContext(), 2, false, kx.a((jo) viewGroup, view2, i));
                autoVideoCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d27(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    @Override // com.baidu.tieba.qn
    /* renamed from: A */
    public AutoVideoCardViewHolder<y26> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.b.getPageActivity(), false);
            h37 h37Var = new h37(this.b.getPageActivity());
            h37Var.v(new b(this, h37Var));
            this.f = h37Var;
            h37Var.x(this.a);
            this.f.u("index");
            this.f.y("2001");
            bVar.n(this.f);
            sy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<y26> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.p(this.g);
            k.r(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, y26 y26Var, AutoVideoCardViewHolder<y26> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, y26Var, autoVideoCardViewHolder})) == null) {
            if (y26Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            y26Var.I(y26Var.position + 1);
            y26Var.a.statFloor = y26Var.n();
            autoVideoCardViewHolder.a().q(i);
            y26Var.T = 0;
            b26.b().a(y26Var.B());
            autoVideoCardViewHolder.u(x(y26Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(y26Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            d37.i(y26Var.a, this.a, y26Var.n());
            d37.h(y26Var.a, y26Var.r(), y26Var.n());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void C(y27 y27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y27Var) == null) {
            this.c = y27Var;
        }
    }

    public void D(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, joVar) == null) {
            this.e = joVar;
        }
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    public void onPause() {
        az azVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (azVar = this.f) == null) {
            return;
        }
        azVar.s();
    }

    public void onResume() {
        az azVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (azVar = this.f) == null) {
            return;
        }
        azVar.t();
    }

    public final ab8 x(y26 y26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, y26Var)) == null) {
            if (y26Var != null) {
                ab8 ab8Var = new ab8();
                ab8Var.a = "1";
                ab8Var.c = y26Var.g;
                if (y26Var.getThreadData() != null) {
                    ab8Var.d = String.valueOf(y26Var.getThreadData().getFid());
                    ab8Var.v = y26Var.getThreadData().getNid();
                    if (y26Var.getThreadData().getThreadVideoInfo() != null) {
                        ab8Var.m = y26Var.getThreadData().getThreadVideoInfo().video_md5;
                        ab8Var.p = String.valueOf(y26Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                ab8Var.k = y26Var.h();
                ab8Var.f = y26Var.r();
                ab8Var.l = y26Var.c();
                ab8Var.h = y26Var.D();
                ab8Var.e = TbadkCoreApplication.getCurrentAccount();
                ab8Var.q = String.valueOf(y26Var.n());
                if (y26Var.getThreadData() == null || y26Var.getThreadData().getBaijiahaoData() == null) {
                    return ab8Var;
                }
                ab8Var.t = y26Var.getThreadData().getBaijiahaoData().oriUgcNid;
                ab8Var.u = y26Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return ab8Var;
            }
            return null;
        }
        return (ab8) invokeL.objValue;
    }

    public final void y(View view2, y26 y26Var) {
        az azVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, view2, y26Var) == null) || (azVar = this.f) == null || azVar.p() == null || this.f.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.f.p().getMainView().getId()) {
            CardLinkageManager.INSTANCE.cancelHighLight(this.e, y26Var);
            d37.d(y26Var.a, this.a, y26Var.n(), 4);
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(y26Var.P()));
            d37.c(y26Var.a, y26Var.r(), y26Var.n(), 2);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f092181) {
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(y26Var.N(y26Var.a)));
            d37.c(y26Var.a, y26Var.r(), y26Var.n(), 1);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            y26.V = "c10708";
            y26.W = "c10735";
            y26.X = "c10709";
            y26.Y = "c10734";
            y26.Z = "c11929";
            y26.a0 = "c11928";
            y26.b0 = "c10756";
        }
    }
}
