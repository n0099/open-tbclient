package com.baidu.tieba;

import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ax;
import com.baidu.tieba.oy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class em7 extends ul7 implements kp6, xt7, o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ em7 b;

        public a(em7 em7Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em7Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = em7Var;
            this.a = vyVar;
        }

        @Override // com.baidu.tieba.ax.a
        public void a(b15 b15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, b15Var) == null) && b15Var != null && b15Var.getThreadData() != null && b15Var.getThreadData().originalThreadData != null) {
                ix5.b(3, this.b.mContext, b15Var.getThreadData(), 0, this.a.A(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ em7 b;

        public b(em7 em7Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em7Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = em7Var;
            this.a = vyVar;
        }

        @Override // com.baidu.tieba.ax.a
        public void a(b15 b15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, b15Var) == null) && b15Var != null && b15Var.getThreadData() != null && b15Var.getThreadData().originalThreadData != null) {
                ix5.b(3, this.b.mContext, b15Var.getThreadData(), 0, this.a.A(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ez {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ em7 b;

        public c(em7 em7Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em7Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = em7Var;
            this.a = vyVar;
        }

        @Override // com.baidu.tieba.ez
        public void a(b15 b15Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, b15Var) == null) && b15Var != null && b15Var.getThreadData() != null && b15Var.getThreadData().originalThreadData != null) {
                boolean z2 = false;
                if (b15Var.getThreadData().originalThreadData.r != null) {
                    if (b15Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                ix5.a(3, z, this.b.mContext, b15Var.getThreadData(), 0, this.a.A(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public em7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: T */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.l.getPageActivity());
            vy vyVar = new vy(this.l.getPageActivity());
            M(bVar);
            J(bVar, R.dimen.tbds38);
            jy jyVar = new jy(this.l);
            jyVar.r(Boolean.TRUE);
            jyVar.setFrom("frs");
            jyVar.C(true);
            jyVar.D(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            bVar.h(jyVar);
            jyVar.B(new a(this, vyVar));
            vyVar.r(Boolean.TRUE);
            vyVar.setFrom("frs");
            vyVar.C(new b(this, vyVar));
            vyVar.D(new c(this, vyVar));
            bVar.h(vyVar);
            I(bVar, this.o);
            L(bVar);
            ThreadCardViewHolder H = H(bVar, viewGroup, this.p, this.s);
            H.n();
            return H;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }
}
