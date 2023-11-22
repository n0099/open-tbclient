package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a96 extends zk6<r86> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public TextView j;
    public HeadImageView k;
    public TextView l;
    public View m;
    public r86 n;
    public RelativeLayout o;

    @Override // com.baidu.tieba.zk6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0970 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a96(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = i();
        this.o = (RelativeLayout) i().findViewById(R.id.obfuscated_res_0x7f09108b);
        this.i = (TextView) i().findViewById(R.id.obfuscated_res_0x7f091089);
        this.j = (TextView) i().findViewById(R.id.obfuscated_res_0x7f091088);
        HeadImageView headImageView = (HeadImageView) i().findViewById(R.id.obfuscated_res_0x7f091087);
        this.k = headImageView;
        headImageView.setAutoChangeStyle(true);
        this.k.setIsRound(true);
        this.k.setDrawBorder(true);
        this.k.setPlaceHolder(1);
        this.k.setBorderWidth(BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.k.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.l = (TextView) i().findViewById(R.id.obfuscated_res_0x7f09108a);
        this.o.setOnClickListener(this);
        l(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && f() != null) {
            f().a(view2, this.n);
        }
    }

    @Override // com.baidu.tieba.zk6
    public void l(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0108);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zk6
    /* renamed from: p */
    public void k(r86 r86Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, r86Var) == null) && r86Var != null) {
            this.n = r86Var;
            String str2 = r86Var.c;
            String str3 = "";
            if (StringUtils.isNull(str2)) {
                if (StringUtils.isNull(r86Var.b)) {
                    str2 = "";
                } else {
                    str2 = r86Var.b;
                }
            }
            this.i.setText(str2);
            TextView textView = this.j;
            if (StringUtils.isNull(r86Var.e)) {
                str = "";
            } else {
                str = r86Var.e;
            }
            textView.setText(str);
            this.k.startLoad(r86Var.d, 10, false);
            TextView textView2 = this.l;
            if (!StringUtils.isNull(r86Var.f)) {
                str3 = r86Var.f;
            }
            textView2.setText(str3);
        }
    }
}
