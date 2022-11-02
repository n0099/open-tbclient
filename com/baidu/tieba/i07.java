package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i07 extends jn<p46, AutoVideoCardViewHolder<p46>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public co c;
    public vy d;
    public int e;
    public z36<p46> f;

    /* loaded from: classes4.dex */
    public class a extends z36<p46> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i07 b;

        public a(i07 i07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, p46 p46Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, p46Var) == null) {
                this.b.v(view2, p46Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i07 a;

        public b(i07 i07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i07Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (wnVar instanceof p46) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                p46 p46Var = (p46) wnVar;
                p46Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), p46Var);
                }
                s07.b(p46Var, view2.getContext(), 18, false, dx.a((co) viewGroup, view2, i));
                threadCardViewHolder.a().o(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i07(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void v(View view2, p46 p46Var) {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, view2, p46Var) == null) && (vyVar = this.d) != null && vyVar.s() != null && this.d.s().getMainView() != null) {
            if (view2.getId() == this.d.s().getMainView().getId()) {
                s07.d(p46Var, this.e);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0921d0) {
                s07.d(p46Var, this.e);
            }
        }
    }

    public void A(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, coVar) == null) {
            this.c = coVar;
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.e = i;
        }
    }

    public void z(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void onPause() {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (vyVar = this.d) != null) {
            vyVar.v();
        }
    }

    public final uc8 u(p46 p46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, p46Var)) == null) {
            if (p46Var != null) {
                uc8 uc8Var = new uc8();
                uc8Var.a = "17";
                uc8Var.c = p46Var.g;
                if (p46Var.getThreadData() != null) {
                    uc8Var.d = String.valueOf(p46Var.getThreadData().getFid());
                    if (p46Var.getThreadData().getThreadVideoInfo() != null) {
                        uc8Var.m = p46Var.getThreadData().getThreadVideoInfo().video_md5;
                        uc8Var.p = String.valueOf(p46Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                uc8Var.k = p46Var.h();
                uc8Var.f = p46Var.r();
                uc8Var.l = p46Var.c();
                uc8Var.h = p46Var.D();
                uc8Var.e = TbadkCoreApplication.getCurrentAccount();
                uc8Var.q = String.valueOf(p46Var.n());
                uc8Var.r = String.valueOf(this.e);
                return uc8Var;
            }
            return null;
        }
        return (uc8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: w */
    public AutoVideoCardViewHolder<p46> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.a.getPageActivity(), false);
            ey eyVar = new ey(this.a.getPageActivity());
            this.d = eyVar;
            eyVar.A(this.b);
            this.d.x(ImageViewerConfig.FROM_GAME_VIDEO);
            this.d.B("2001");
            bVar.n(this.d);
            ny k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<p46> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.p(this.f);
            k.r(18);
            setOnAdapterItemClickListener(new b(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, p46 p46Var, AutoVideoCardViewHolder<p46> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, p46Var, autoVideoCardViewHolder})) == null) {
            if (p46Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            p46Var.I(p46Var.position + 1);
            autoVideoCardViewHolder.a().q(i);
            s07.c(p46Var, this.e);
            autoVideoCardViewHolder.u(u(p46Var));
            autoVideoCardViewHolder.e(p46Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
