package com.baidu.tieba.ala.frsgamelive.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ee6;
import com.baidu.tieba.ha6;
import com.baidu.tieba.je6;
import com.baidu.tieba.ln6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AlaGameFrsLiveDoubleView extends ln6<je6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ee6 i;
    public ee6 j;

    @Override // com.baidu.tieba.ln6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0116 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class AlaGameFrsLiveDoubleViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AlaGameFrsLiveDoubleView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AlaGameFrsLiveDoubleViewHolder(AlaGameFrsLiveDoubleView alaGameFrsLiveDoubleView) {
            super(alaGameFrsLiveDoubleView.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveDoubleView};
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
            this.a = alaGameFrsLiveDoubleView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaGameFrsLiveDoubleView(TbPageContext<?> tbPageContext) {
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
        r();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln6
    /* renamed from: s */
    public void i(je6 je6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, je6Var) == null) && je6Var != null) {
            this.i.d(je6Var.a);
            this.j.d(je6Var.b);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.i.f(str);
            this.j.f(str);
        }
    }

    public void u(ha6 ha6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ha6Var) == null) {
            this.i.g(ha6Var);
            this.j.g(ha6Var);
        }
    }

    @Override // com.baidu.tieba.ln6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.i.e(tbPageContext, i);
            this.j.e(tbPageContext, i);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i = new ee6(g());
            this.j = new ee6(g());
            ViewGroup viewGroup = (ViewGroup) h();
            View view2 = new View(getContext());
            viewGroup.addView(this.i.c());
            viewGroup.addView(view2, new LinearLayout.LayoutParams(g().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be), -1));
            viewGroup.addView(this.j.c());
        }
    }
}
