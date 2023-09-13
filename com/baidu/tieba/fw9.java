package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.dx;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fw9 extends pm<xp6, ThreadCardViewHolder<xp6>> implements o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public int d;
    public int e;
    public boolean f;
    public mp6<xp6> g;

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends mp6<xp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(fw9 fw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, xp6 xp6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, xp6Var) == null) && view2 != null && xp6Var != null && xp6Var.getThreadData() != null) {
                int id = view2.getId();
                if (id != R.id.thread_card_root && id != R.id.bottom_mask) {
                    if (id == R.id.forum_name_text) {
                        nv9.a(view2, xp6Var, 7);
                        return;
                    }
                    return;
                }
                nv9.a(view2, xp6Var, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements dx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw9 a;

        public b(fw9 fw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw9Var;
        }

        @Override // com.baidu.tieba.dx.b
        public void a(b15 b15Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, b15Var, view2) == null) {
                this.a.E(view2, b15Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends mp6<b15> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw9 b;

        public c(fw9 fw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, b15 b15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, b15Var) == null) {
                this.b.E(view2, b15Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw9 a;

        public d(fw9 fw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw9Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.x(view2, cnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fw9(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.d = 0;
        this.e = 0;
        this.g = new a(this);
        this.b = tbPageContext;
        u();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f = z;
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.d = i;
        }
    }

    @Override // com.baidu.tieba.o56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.c = str;
        }
    }

    public final void E(View view2, b15 b15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, view2, b15Var) == null) && view2 != null && b15Var != null && view2.getId() != -1) {
            int id = view2.getId();
            if (id != R.id.user_name && id != R.id.user_avatar) {
                if (id == R.id.cover_img || id == R.id.bottom_mask) {
                    nv9.a(view2, b15Var, 3);
                    return;
                }
                return;
            }
            nv9.a(view2, b15Var, 1);
        }
    }

    public final void x(View view2, cn cnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, view2, cnVar) == null) && (cnVar instanceof xp6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            xp6 xp6Var = (xp6) cnVar;
            xp6Var.f = 1;
            ThreadCardUtils.jumpToPB((b15) xp6Var, view2.getContext(), 4, false);
            ((ThreadCardViewHolder) view2.getTag()).a().p(new zy.a(1));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            cq6.j0 = "c13542";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: y */
    public ThreadCardViewHolder<xp6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity());
            dx dxVar = new dx(this.b.getPageActivity());
            dxVar.p(this.a);
            dxVar.B(this.b);
            dxVar.f(32768);
            int i = this.d;
            if (i > 0) {
                dxVar.e(i);
            }
            dxVar.x(false);
            dxVar.C(false);
            dxVar.y(new b(this));
            bVar.o(dxVar);
            bVar.l().i(BdUtilHelper.getDimens(this.mContext, R.dimen.tbds25));
            bx bxVar = new bx(this.b.getPageActivity());
            bxVar.o(new c(this));
            bVar.n(bxVar);
            bVar.h(new lx(this.b.getPageActivity()));
            qy qyVar = new qy(this.b.getPageActivity());
            qyVar.e(32);
            qyVar.E(false);
            h15 h15Var = new h15();
            h15Var.b = 3;
            h15Var.h = 3;
            qyVar.D(h15Var);
            qyVar.F(8);
            qyVar.K(6);
            qyVar.G(4);
            bVar.m(qyVar);
            oy i2 = bVar.i();
            i2.s(4);
            ThreadCardViewHolder<xp6> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.i(this.a);
            threadCardViewHolder.r(this.e);
            setOnAdapterItemClickListener(new d(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, xp6 xp6Var, ThreadCardViewHolder<xp6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xp6Var, threadCardViewHolder})) == null) {
            if (xp6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                xp6Var.B(xp6Var.position + 1);
                threadCardViewHolder.a().b(this.c);
                if (!this.f) {
                    threadCardViewHolder.s();
                }
                threadCardViewHolder.e(xp6Var);
                threadCardViewHolder.a().q(this.g);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                nv9.b(xp6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
