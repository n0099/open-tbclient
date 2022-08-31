package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
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
public class b47 extends cn<u06, AutoVideoCardViewHolder<u06>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public vn c;
    public my d;
    public a17 e;
    public h06<u06> f;

    /* loaded from: classes3.dex */
    public class a extends h06<u06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b47 b;

        public a(b47 b47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b47Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h06
        /* renamed from: d */
        public void a(View view2, u06 u06Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, u06Var) == null) || view2 == null || u06Var == null || u06Var.getThreadData() == null) {
                return;
            }
            this.b.y(view2, u06Var);
            if (this.b.e == null || !(view2.getTag() instanceof String) || dz6.b(pg.g(u06Var.getThreadData().getTid(), 0L))) {
                return;
            }
            dz6.a(pg.g(u06Var.getThreadData().getTid(), 0L));
            this.b.e.e(pg.g(u06Var.getThreadData().getTid(), 0L), u06Var.D(), u06Var.r(), u06Var.n(), u06Var.c(), pg.e("3", 1), "video_tab", u06Var.getThreadData().getBaijiahaoData());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements sw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my a;
        public final /* synthetic */ b47 b;

        public b(b47 b47Var, my myVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b47Var, myVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b47Var;
            this.a = myVar;
        }

        @Override // com.baidu.tieba.sw.a
        public void a(go4 go4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, go4Var) == null) || go4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (go4Var instanceof u06) {
                go4Var.objType = 5;
                j47.f((l06) go4Var);
                j47.c(go4Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            j47.f((l06) go4Var);
            j47.c(go4Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b47 a;

        public c(b47 b47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b47Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (pnVar instanceof u06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                u06 u06Var = (u06) pnVar;
                u06Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), u06Var);
                }
                j47.c(u06Var, view2.getContext(), 19, false, ww.a((vn) viewGroup, view2, i));
                threadCardViewHolder.a().o(new py.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b47(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, u06 u06Var, AutoVideoCardViewHolder<u06> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, u06Var, autoVideoCardViewHolder})) == null) {
            if (u06Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            u06Var.I(u06Var.position + 1);
            autoVideoCardViewHolder.a().q(i);
            autoVideoCardViewHolder.u(x(u06Var));
            j47.d(u06Var);
            autoVideoCardViewHolder.e(u06Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void C(a17 a17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a17Var) == null) {
            this.e = a17Var;
        }
    }

    public void D(vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vnVar) == null) {
            this.c = vnVar;
        }
    }

    public void onPause() {
        my myVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (myVar = this.d) == null) {
            return;
        }
        myVar.s();
    }

    public final e98 x(u06 u06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, u06Var)) == null) {
            if (u06Var != null) {
                e98 e98Var = new e98();
                e98Var.a = "19";
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
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, u06Var) == null) || (myVar = this.d) == null || myVar.p() == null || this.d.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.d.p().getMainView().getId()) {
            j47.h(u06Var);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09212d) {
            j47.f(u06Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: z */
    public AutoVideoCardViewHolder<u06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.a.getPageActivity(), false);
            yw ywVar = new yw(this.a.getPageActivity());
            ywVar.v(new b(this, ywVar));
            this.d = ywVar;
            ywVar.x(this.b);
            this.d.u("video_tab");
            this.d.y("2001");
            bVar.n(this.d);
            ey k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<u06> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.p(this.f);
            k.r(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }
}
