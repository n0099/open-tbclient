package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.er5;
import com.repackage.kr5;
import com.repackage.mm5;
import com.repackage.nv5;
/* loaded from: classes3.dex */
public class AlaGameFrsLiveNormalCardView extends nv5<er5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public kr5 j;

    /* loaded from: classes3.dex */
    public static class AlaGameFrsNormalViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AlaGameFrsLiveNormalCardView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AlaGameFrsNormalViewHolder(AlaGameFrsLiveNormalCardView alaGameFrsLiveNormalCardView) {
            super(alaGameFrsLiveNormalCardView.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveNormalCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaGameFrsLiveNormalCardView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaGameFrsLiveNormalCardView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = tbPageContext;
        s();
    }

    @Override // com.repackage.nv5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d010a : invokeV.intValue;
    }

    @Override // com.repackage.nv5
    public void m(TbPageContext<?> tbPageContext, int i) {
        kr5 kr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || (kr5Var = this.j) == null) {
            return;
        }
        kr5Var.e(tbPageContext, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.j = new kr5(this.i);
            ((ViewGroup) k()).addView(this.j.c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nv5
    /* renamed from: t */
    public void l(er5 er5Var) {
        ThreadData threadData;
        kr5 kr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, er5Var) == null) || er5Var == null || (threadData = er5Var.a) == null || (kr5Var = this.j) == null) {
            return;
        }
        kr5Var.d(threadData);
    }

    public void u(mm5 mm5Var) {
        kr5 kr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, mm5Var) == null) || (kr5Var = this.j) == null) {
            return;
        }
        kr5Var.g(mm5Var);
    }
}
