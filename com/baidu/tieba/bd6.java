package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListGameDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bd6 extends in<dd6, AlaSubListGameDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public md6 b;
    public boolean c;
    public hd6 d;
    public int e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd6(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), dd6.c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.c = false;
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: t */
    public AlaSubListGameDoubleViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.d = new hd6(this.a, this.c);
            return new AlaSubListGameDoubleViewHolder(this.d);
        }
        return (AlaSubListGameDoubleViewHolder) invokeL.objValue;
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f = i;
        }
    }

    public void y(md6 md6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, md6Var) == null) {
            this.b = md6Var;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public final void s(dd6 dd6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dd6Var) != null) || dd6Var == null) {
            return;
        }
        int i = this.f;
        if (i == 1) {
            if (dd6Var.a != null) {
                mc6 b = mc6.b();
                mc6 b2 = mc6.b();
                int i2 = this.e;
                na6 na6Var = dd6Var.a;
                b.a(b2.d(i2, "c12117", na6Var.a, na6Var.b, na6Var.getThreadData()));
            }
            if (dd6Var.b != null) {
                mc6 b3 = mc6.b();
                mc6 b4 = mc6.b();
                int i3 = this.e;
                na6 na6Var2 = dd6Var.b;
                b3.a(b4.d(i3, "c12117", na6Var2.a, na6Var2.b, na6Var2.getThreadData()));
            }
        } else if (i == 2) {
            na6 na6Var3 = dd6Var.a;
            if (na6Var3 != null && na6Var3.getThreadData() != null && dd6Var.a.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData = dd6Var.a.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.getThreadAlaInfo().appId).param("locate_type", dd6Var.a.b));
            }
            na6 na6Var4 = dd6Var.b;
            if (na6Var4 != null && na6Var4.getThreadData() != null && dd6Var.b.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData2 = dd6Var.b.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.getThreadAlaInfo().appId).param("locate_type", dd6Var.b.b));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, dd6 dd6Var, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dd6Var, alaSubListGameDoubleViewHolder})) == null) {
            s(dd6Var);
            alaSubListGameDoubleViewHolder.a.i(dd6Var);
            alaSubListGameDoubleViewHolder.a.s(this.b);
            return alaSubListGameDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
