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
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e38 extends pm<dq6, AutoVideoCardViewHolder<dq6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public in c;
    public wy d;
    public int e;
    public mp6<dq6> f;

    /* loaded from: classes5.dex */
    public class a extends mp6<dq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e38 b;

        public a(e38 e38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, dq6 dq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, dq6Var) == null) {
                this.b.x(view2, dq6Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e38 a;

        public b(e38 e38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e38Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof dq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                dq6 dq6Var = (dq6) cnVar;
                dq6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), dq6Var);
                }
                o38.b(dq6Var, view2.getContext(), 18, false, ex.a((in) viewGroup, view2, i));
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e38(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void x(View view2, dq6 dq6Var) {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, view2, dq6Var) == null) && (wyVar = this.d) != null && wyVar.t() != null && this.d.t().getMainView() != null) {
            if (view2.getId() == this.d.t().getMainView().getId()) {
                o38.d(dq6Var, this.e);
            } else if (view2.getId() == R.id.thread_card_root) {
                o38.d(dq6Var, this.e);
            }
        }
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.e = i;
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void C(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inVar) == null) {
            this.c = inVar;
        }
    }

    public void onPause() {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (wyVar = this.d) != null) {
            wyVar.y();
        }
    }

    public final pz9 u(dq6 dq6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dq6Var)) == null) {
            if (dq6Var != null) {
                pz9 pz9Var = new pz9();
                pz9Var.a = "17";
                pz9Var.c = dq6Var.g;
                if (dq6Var.getThreadData() != null) {
                    pz9Var.d = String.valueOf(dq6Var.getThreadData().getFid());
                    if (dq6Var.getThreadData().getThreadVideoInfo() != null) {
                        pz9Var.m = dq6Var.getThreadData().getThreadVideoInfo().video_md5;
                        pz9Var.p = String.valueOf(dq6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                pz9Var.k = dq6Var.e();
                pz9Var.f = dq6Var.i();
                pz9Var.l = dq6Var.c();
                pz9Var.h = dq6Var.u();
                pz9Var.e = TbadkCoreApplication.getCurrentAccount();
                pz9Var.q = String.valueOf(dq6Var.h());
                pz9Var.r = String.valueOf(this.e);
                return pz9Var;
            }
            return null;
        }
        return (pz9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: y */
    public AutoVideoCardViewHolder<dq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.a.getPageActivity(), false);
            fy fyVar = new fy(this.a.getPageActivity());
            this.d = fyVar;
            fyVar.p(this.b);
            this.d.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
            this.d.setStageType("2001");
            bVar.n(this.d);
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<dq6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.q(this.f);
            k.s(18);
            setOnAdapterItemClickListener(new b(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, dq6 dq6Var, AutoVideoCardViewHolder<dq6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dq6Var, autoVideoCardViewHolder})) == null) {
            if (dq6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            dq6Var.B(dq6Var.position + 1);
            autoVideoCardViewHolder.a().r(i);
            o38.c(dq6Var, this.e);
            autoVideoCardViewHolder.x(u(dq6Var));
            autoVideoCardViewHolder.e(dq6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
