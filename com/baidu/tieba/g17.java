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
import com.baidu.tieba.dz;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g17 extends lw6<s26, ThreadCardViewHolder<s26>> implements to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public NEGFeedBackView.b e;
    public jo f;
    public i26<s26> g;

    /* loaded from: classes4.dex */
    public class a extends i26<s26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g17 b;

        public a(g17 g17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g17Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, s26 s26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, s26Var) == null) {
                b26.b().d(true);
                ro5.c().h("page_recommend", "show_");
                if (view2 == null || s26Var == null || s26Var.getThreadData() == null || StringUtils.isNull(s26Var.getThreadData().getTid())) {
                    return;
                }
                this.b.y(view2, s26Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g17 a;

        public b(g17 g17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g17Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.v(view2, cdo);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g17(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public void A(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, joVar) == null) {
            this.f = joVar;
        }
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.d = str;
        }
    }

    public final void v(View view2, Cdo cdo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, view2, cdo) == null) && (cdo instanceof s26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            s26 s26Var = (s26) cdo;
            s26Var.f = 1;
            ThreadCardUtils.jumpToPB((yq4) s26Var, view2.getContext(), 2, false);
            ((ThreadCardViewHolder) view2.getTag()).a().o(new dz.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: w */
    public ThreadCardViewHolder<s26> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.c.getPageActivity());
            jx jxVar = new jx(this.c.getPageActivity());
            jxVar.u(this.b);
            jxVar.w(this.c);
            bVar.o(jxVar);
            bVar.n(new hx(this.c.getPageActivity()));
            bVar.h(new qx(this.c.getPageActivity()));
            uy uyVar = new uy(this.c.getPageActivity());
            er4 er4Var = new er4();
            er4Var.b = 1;
            er4Var.h = 1;
            uyVar.w(er4Var);
            uyVar.y(1);
            uyVar.D(3);
            uyVar.z(2);
            uyVar.x(false);
            bVar.m(uyVar);
            bVar.l().h(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            sy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.r(2);
            ThreadCardViewHolder<s26> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, s26 s26Var, ThreadCardViewHolder<s26> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, s26Var, threadCardViewHolder})) == null) {
            if (s26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            s26Var.I(s26Var.position + 1);
            s26Var.a.statFloor = s26Var.n();
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.a().b(this.d);
            threadCardViewHolder.o(true).u(this.e);
            threadCardViewHolder.k(s26Var.showFollowBtn(), this.a);
            threadCardViewHolder.e(s26Var);
            threadCardViewHolder.a().p(this.g);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            b26.b().a(s26Var.B());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y(View view2, s26 s26Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048583, this, view2, s26Var) != null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f092180) {
            TiebaStatic.log(s26Var.A());
        } else if (id == R.id.obfuscated_res_0x7f092488 || id == R.id.obfuscated_res_0x7f0924b6) {
            i = 2;
            if (i == 0) {
                d37.d(s26Var.a, this.b, s26Var.n(), i);
                return;
            }
            return;
        }
        i = 0;
        if (i == 0) {
        }
    }

    public void z(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.e = bVar;
        }
    }
}
