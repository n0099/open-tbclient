package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lz;
import com.baidu.tieba.wz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class g08 extends dv7<bp6, ThreadCardViewHolder<bp6>> implements p56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public NEGFeedBackView.b e;
    public Cdo f;
    public qo6<bp6> g;

    /* loaded from: classes5.dex */
    public class a extends qo6<bp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g08 b;

        public a(g08 g08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qo6
        /* renamed from: d */
        public void a(View view2, bp6 bp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bp6Var) == null) {
                jo6.b().d(true);
                n56.c().h("page_recommend", "show_");
                if (view2 != null && bp6Var != null && bp6Var.getThreadData() != null && !StringUtils.isNull(bp6Var.getThreadData().getTid())) {
                    this.b.A(view2, bp6Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g08 a;

        public b(g08 g08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g08Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.x(view2, xnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g08(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.c = tbPageContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A(View view2, bp6 bp6Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, bp6Var) == null) {
            int id = view2.getId();
            if (id == R.id.thread_card_root) {
                TiebaStatic.log(bp6Var.q());
            } else if (id == R.id.user_avatar || id == R.id.user_name) {
                i = 2;
                if (i == 0) {
                    d28.d(bp6Var.a, this.b, bp6Var.i(), i);
                    return;
                }
                return;
            }
            i = 0;
            if (i == 0) {
            }
        }
    }

    public final void x(View view2, xn xnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, xnVar) == null) && (xnVar instanceof bp6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            bp6 bp6Var = (bp6) xnVar;
            bp6Var.f = 1;
            ThreadCardUtils.jumpToPB((l15) bp6Var, view2.getContext(), 2, false);
            ((ThreadCardViewHolder) view2.getTag()).a().p(new wz.a(1));
        }
    }

    public void B(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public void C(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cdo) == null) {
            this.f = cdo;
        }
    }

    @Override // com.baidu.tieba.p56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: y */
    public ThreadCardViewHolder<bp6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            lz.b bVar = new lz.b(this.c.getPageActivity());
            zx zxVar = new zx(this.c.getPageActivity());
            zxVar.z(this.b);
            zxVar.B(this.c);
            bVar.o(zxVar);
            bVar.n(new xx(this.c.getPageActivity()));
            bVar.h(new hy(this.c.getPageActivity()));
            nz nzVar = new nz(this.c.getPageActivity());
            r15 r15Var = new r15();
            r15Var.b = 1;
            r15Var.h = 1;
            nzVar.B(r15Var);
            nzVar.D(1);
            nzVar.I(3);
            nzVar.E(2);
            nzVar.C(false);
            bVar.m(nzVar);
            bVar.l().i(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            lz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder<bp6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bp6 bp6Var, ThreadCardViewHolder<bp6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bp6Var, threadCardViewHolder})) == null) {
            if (bp6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                bp6Var.B(bp6Var.position + 1);
                bp6Var.a.statFloor = bp6Var.i();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.d);
                threadCardViewHolder.p(true).s(this.e);
                threadCardViewHolder.l(bp6Var.showFollowBtn(), this.a);
                threadCardViewHolder.e(bp6Var);
                threadCardViewHolder.a().q(this.g);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                jo6.b().a(bp6Var.s());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
