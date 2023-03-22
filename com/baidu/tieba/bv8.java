package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.tieba.ow;
import com.baidu.tieba.rw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bv8 extends tm<ag6, ThreadCardViewHolder<ag6>> implements jx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public int d;
    public int e;
    public boolean f;
    public lf6<ag6> g;

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a extends lf6<ag6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(bv8 bv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv8Var};
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
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        public void a(View view2, ag6 ag6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ag6Var) == null) && view2 != null && ag6Var != null && ag6Var.getThreadData() != null && view2.getId() == R.id.forum_name_text) {
                eu8.a(view2, ag6Var, 7);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements rw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(bv8 bv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.rw.b
        public void a(hw4 hw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, hw4Var, view2) == null) && view2 != null && hw4Var != null) {
                int id = view2.getId();
                if (id == R.id.user_name || id == R.id.user_avatar) {
                    eu8.a(view2, hw4Var, 1);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ow.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx a;
        public final /* synthetic */ bv8 b;

        public c(bv8 bv8Var, xx xxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv8Var, xxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bv8Var;
            this.a = xxVar;
        }

        @Override // com.baidu.tieba.ow.a
        public void a(hw4 hw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hw4Var) == null) && hw4Var != null && hw4Var.getThreadData() != null && hw4Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(hw4Var.getThreadData().originalThreadData, this.b.mContext, 4);
                eu8.a(this.a.k(), hw4Var, 6);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ow.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy a;
        public final /* synthetic */ bv8 b;

        public d(bv8 bv8Var, jy jyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv8Var, jyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bv8Var;
            this.a = jyVar;
        }

        @Override // com.baidu.tieba.ow.a
        public void a(hw4 hw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hw4Var) == null) && hw4Var != null && hw4Var.getThreadData() != null && hw4Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(hw4Var.getThreadData().originalThreadData, this.b.mContext, 4);
                eu8.a(this.a.k(), hw4Var, 6);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv8 a;

        public e(bv8 bv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv8Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof ag6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ag6 ag6Var = (ag6) gnVar;
                ag6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), ag6Var);
                }
                ThreadCardUtils.jumpToPB((hw4) ag6Var, view2.getContext(), 4, false);
                threadCardViewHolder.a().p(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.e = i;
        }
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.d = i;
        }
    }

    @Override // com.baidu.tieba.jx5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.c = str;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: x */
    public ThreadCardViewHolder<ag6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.b.getPageActivity());
            rw rwVar = new rw(this.b.getPageActivity());
            rwVar.x(this.a);
            rwVar.g(1024);
            rwVar.g(32768);
            int i = this.d;
            if (i > 0) {
                rwVar.f(i);
            }
            rwVar.v(false);
            rwVar.A(false);
            rwVar.w(new b(this));
            bVar.o(rwVar);
            xx xxVar = new xx(this.b);
            xxVar.r(Boolean.FALSE);
            xxVar.v(hi.g(this.mContext, R.dimen.tbds9));
            bVar.n(xxVar);
            bVar.l().i(hi.g(this.mContext, R.dimen.tbds25));
            xx xxVar2 = new xx(this.b);
            xxVar2.r(Boolean.TRUE);
            xxVar2.C(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            xxVar2.A(new c(this, xxVar2));
            bVar.h(xxVar2);
            jy jyVar = new jy(this.b.getPageActivity());
            jyVar.r(Boolean.TRUE);
            jyVar.B(new d(this, jyVar));
            bVar.h(jyVar);
            bVar.h(new gy(this.b.getPageActivity()));
            bVar.h(new yw(this.b.getPageActivity()));
            ey eyVar = new ey(this.b.getPageActivity());
            eyVar.f(32);
            eyVar.A(false);
            nw4 nw4Var = new nw4();
            nw4Var.b = 3;
            nw4Var.h = 3;
            eyVar.z(nw4Var);
            eyVar.B(8);
            eyVar.G(6);
            eyVar.C(4);
            bVar.m(eyVar);
            cy i2 = bVar.i();
            i2.s(4);
            ThreadCardViewHolder<ag6> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.i(this.a);
            threadCardViewHolder.q(this.e);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ag6 ag6Var, ThreadCardViewHolder<ag6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ag6Var, threadCardViewHolder})) == null) {
            if (ag6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && ag6Var.a != null) {
                ag6Var.E(ag6Var.position + 1);
                threadCardViewHolder.a().b(this.c);
                if (!this.f) {
                    threadCardViewHolder.r();
                }
                threadCardViewHolder.e(ag6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                eu8.b(ag6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
