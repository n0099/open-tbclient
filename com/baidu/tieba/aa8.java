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
import com.baidu.tieba.mz;
import com.baidu.tieba.xx;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class aa8 extends ln<lq6, AutoVideoCardViewHolder<lq6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public eo c;
    public uz d;
    public s68 e;
    public up6<lq6> f;

    /* loaded from: classes5.dex */
    public class a extends up6<lq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 b;

        public a(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aa8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, lq6 lq6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, lq6Var) == null) && view2 != null && lq6Var != null && lq6Var.getThreadData() != null) {
                this.b.A(view2, lq6Var);
                if (this.b.e != null && (view2.getTag() instanceof String) && !u48.b(wg.g(lq6Var.getThreadData().getTid(), 0L))) {
                    u48.a(wg.g(lq6Var.getThreadData().getTid(), 0L));
                    this.b.e.e(wg.g(lq6Var.getThreadData().getTid(), 0L), lq6Var.v(), lq6Var.i(), lq6Var.h(), lq6Var.c(), wg.e("3", 1), "video_tab", lq6Var.getThreadData().getBaijiahaoData());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements xx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz a;
        public final /* synthetic */ aa8 b;

        public b(aa8 aa8Var, uz uzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var, uzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aa8Var;
            this.a = uzVar;
        }

        @Override // com.baidu.tieba.xx.a
        public void a(t15 t15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, t15Var) != null) || t15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (t15Var instanceof lq6) {
                t15Var.objType = 5;
                ia8.f((cq6) t15Var);
                ia8.c(t15Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            ia8.f((cq6) t15Var);
            ia8.c(t15Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public c(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof lq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                lq6 lq6Var = (lq6) ynVar;
                lq6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), lq6Var);
                }
                ia8.c(lq6Var, view2.getContext(), 19, false, by.a((eo) viewGroup, view2, i));
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa8(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void A(View view2, lq6 lq6Var) {
        uz uzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, lq6Var) == null) && (uzVar = this.d) != null && uzVar.x() != null && this.d.x().getMainView() != null) {
            if (view2.getId() == this.d.x().getMainView().getId()) {
                ia8.h(lq6Var);
            } else if (view2.getId() == R.id.thread_card_root) {
                ia8.f(lq6Var);
            }
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void E(s68 s68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s68Var) == null) {
            this.e = s68Var;
        }
    }

    public void F(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eoVar) == null) {
            this.c = eoVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: B */
    public AutoVideoCardViewHolder<lq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.a.getPageActivity(), false);
            dy dyVar = new dy(this.a.getPageActivity());
            dyVar.C(new b(this, dyVar));
            this.d = dyVar;
            dyVar.r(this.b);
            this.d.setFrom("video_tab");
            this.d.setStageType("2001");
            bVar.n(this.d);
            mz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<lq6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.b);
            k.q(this.f);
            k.s(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, lq6 lq6Var, AutoVideoCardViewHolder<lq6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lq6Var, autoVideoCardViewHolder})) == null) {
            if (lq6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lq6Var.B(lq6Var.position + 1);
            autoVideoCardViewHolder.b().r(i);
            autoVideoCardViewHolder.y(z(lq6Var));
            ia8.d(lq6Var);
            autoVideoCardViewHolder.f(lq6Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        uz uzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (uzVar = this.d) != null) {
            uzVar.A();
        }
    }

    public final av9 z(lq6 lq6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, lq6Var)) == null) {
            if (lq6Var != null) {
                av9 av9Var = new av9();
                av9Var.a = "19";
                av9Var.c = lq6Var.g;
                if (lq6Var.getThreadData() != null) {
                    av9Var.d = String.valueOf(lq6Var.getThreadData().getFid());
                    av9Var.v = lq6Var.getThreadData().getNid();
                    if (lq6Var.getThreadData().getThreadVideoInfo() != null) {
                        av9Var.m = lq6Var.getThreadData().getThreadVideoInfo().video_md5;
                        av9Var.p = String.valueOf(lq6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                av9Var.k = lq6Var.e();
                av9Var.f = lq6Var.i();
                av9Var.l = lq6Var.c();
                av9Var.h = lq6Var.v();
                av9Var.e = TbadkCoreApplication.getCurrentAccount();
                av9Var.q = String.valueOf(lq6Var.h());
                if (lq6Var.getThreadData() != null && lq6Var.getThreadData().getBaijiahaoData() != null) {
                    av9Var.t = lq6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    av9Var.u = lq6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return av9Var;
                }
                return av9Var;
            }
            return null;
        }
        return (av9) invokeL.objValue;
    }
}
