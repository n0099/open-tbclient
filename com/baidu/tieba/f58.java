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
import com.baidu.tieba.lz;
import com.baidu.tieba.wx;
import com.baidu.tieba.wz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f58 extends kn<hp6, AutoVideoCardViewHolder<hp6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public Cdo c;
    public tz d;
    public y18 e;
    public qo6<hp6> f;

    /* loaded from: classes5.dex */
    public class a extends qo6<hp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f58 b;

        public a(f58 f58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qo6
        /* renamed from: d */
        public void a(View view2, hp6 hp6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, hp6Var) == null) && view2 != null && hp6Var != null && hp6Var.getThreadData() != null) {
                this.b.A(view2, hp6Var);
                if (this.b.e != null && (view2.getTag() instanceof String) && !b08.b(vg.g(hp6Var.getThreadData().getTid(), 0L))) {
                    b08.a(vg.g(hp6Var.getThreadData().getTid(), 0L));
                    this.b.e.e(vg.g(hp6Var.getThreadData().getTid(), 0L), hp6Var.w(), hp6Var.k(), hp6Var.i(), hp6Var.c(), vg.e("3", 1), "video_tab", hp6Var.getThreadData().getBaijiahaoData());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements wx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz a;
        public final /* synthetic */ f58 b;

        public b(f58 f58Var, tz tzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f58Var, tzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f58Var;
            this.a = tzVar;
        }

        @Override // com.baidu.tieba.wx.a
        public void a(l15 l15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, l15Var) != null) || l15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (l15Var instanceof hp6) {
                l15Var.objType = 5;
                n58.f((yo6) l15Var);
                n58.c(l15Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            n58.f((yo6) l15Var);
            n58.c(l15Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f58 a;

        public c(f58 f58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f58Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof hp6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                hp6 hp6Var = (hp6) xnVar;
                hp6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), hp6Var);
                }
                n58.c(hp6Var, view2.getContext(), 19, false, ay.a((Cdo) viewGroup, view2, i));
                threadCardViewHolder.a().p(new wz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f58(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void A(View view2, hp6 hp6Var) {
        tz tzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, hp6Var) == null) && (tzVar = this.d) != null && tzVar.t() != null && this.d.t().getMainView() != null) {
            if (view2.getId() == this.d.t().getMainView().getId()) {
                n58.h(hp6Var);
            } else if (view2.getId() == R.id.thread_card_root) {
                n58.f(hp6Var);
            }
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void E(y18 y18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, y18Var) == null) {
            this.e = y18Var;
        }
    }

    public void F(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cdo) == null) {
            this.c = cdo;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: B */
    public AutoVideoCardViewHolder<hp6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            lz.b bVar = new lz.b(this.a.getPageActivity(), false);
            cy cyVar = new cy(this.a.getPageActivity());
            cyVar.A(new b(this, cyVar));
            this.d = cyVar;
            cyVar.C(this.b);
            this.d.setFrom("video_tab");
            this.d.setStageType("2001");
            bVar.n(this.d);
            lz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<hp6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.q(this.f);
            k.s(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, hp6 hp6Var, AutoVideoCardViewHolder<hp6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hp6Var, autoVideoCardViewHolder})) == null) {
            if (hp6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            hp6Var.B(hp6Var.position + 1);
            autoVideoCardViewHolder.a().r(i);
            autoVideoCardViewHolder.x(z(hp6Var));
            n58.d(hp6Var);
            autoVideoCardViewHolder.e(hp6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        tz tzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (tzVar = this.d) != null) {
            tzVar.y();
        }
    }

    public final to9 z(hp6 hp6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, hp6Var)) == null) {
            if (hp6Var != null) {
                to9 to9Var = new to9();
                to9Var.a = "19";
                to9Var.c = hp6Var.g;
                if (hp6Var.getThreadData() != null) {
                    to9Var.d = String.valueOf(hp6Var.getThreadData().getFid());
                    to9Var.v = hp6Var.getThreadData().getNid();
                    if (hp6Var.getThreadData().getThreadVideoInfo() != null) {
                        to9Var.m = hp6Var.getThreadData().getThreadVideoInfo().video_md5;
                        to9Var.p = String.valueOf(hp6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                to9Var.k = hp6Var.e();
                to9Var.f = hp6Var.k();
                to9Var.l = hp6Var.c();
                to9Var.h = hp6Var.w();
                to9Var.e = TbadkCoreApplication.getCurrentAccount();
                to9Var.q = String.valueOf(hp6Var.i());
                if (hp6Var.getThreadData() != null && hp6Var.getThreadData().getBaijiahaoData() != null) {
                    to9Var.t = hp6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    to9Var.u = hp6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return to9Var;
                }
                return to9Var;
            }
            return null;
        }
        return (to9) invokeL.objValue;
    }
}
