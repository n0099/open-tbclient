package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ida extends nl6<fca> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public View j;
    public TbImageView k;
    public TextView l;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0487 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ida(TbPageContext tbPageContext) {
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
        View i3 = i();
        this.j = i3;
        this.i = tbPageContext;
        i3.setTag(this);
        this.k = (TbImageView) this.j.findViewById(R.id.obfuscated_res_0x7f090eb5);
        this.l = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f090eb3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: p */
    public void j(fca fcaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fcaVar) == null) {
            if (fcaVar == null) {
                this.j.setVisibility(8);
                return;
            }
            k(this.i, TbadkCoreApplication.getInst().getSkinType());
            this.k.startLoad(fcaVar.a, 10, false);
            this.j.setOnClickListener(this);
            if (fcaVar.b > 0) {
                this.l.setVisibility(0);
                long j = fcaVar.b;
                if (j > 99) {
                    this.l.setText("99");
                    return;
                } else {
                    this.l.setText(String.valueOf(j));
                    return;
                }
            }
            this.l.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.k, R.drawable.item_gift_selector);
            SkinManager.setBackgroundColor(this.l, R.color.common_color_10294);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0302);
        }
    }
}
