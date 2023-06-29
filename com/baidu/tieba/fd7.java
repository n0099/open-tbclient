package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fd7 extends sn6<ad7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public int m;
    public ad7 n;
    public View.OnClickListener o;

    @Override // com.baidu.tieba.sn6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0308 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fd7(TbPageContext<?> tbPageContext) {
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
        this.m = 3;
        this.i = (BarImageView) h().findViewById(R.id.forum_avatar);
        this.j = (TextView) h().findViewById(R.id.forum_name);
        this.k = (TextView) h().findViewById(R.id.obfuscated_res_0x7f090b91);
        this.l = (TextView) h().findViewById(R.id.obfuscated_res_0x7f090c01);
        h().setOnClickListener(this);
        j(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sn6
    /* renamed from: r */
    public void i(ad7 ad7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, ad7Var) != null) || ad7Var == null) {
            return;
        }
        this.n = ad7Var;
        this.i.N(ad7Var.c(), 10, false);
        this.j.setText(s(ad7Var.f(), ad7Var.k()));
        this.k.setText(String.format(this.b.getString(R.string.obfuscated_res_0x7f0f04b2), ad7Var.d()));
        this.l.setText(String.format(this.b.getString(R.string.obfuscated_res_0x7f0f12e9), ad7Var.i()));
        j(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || this.n == null) {
            return;
        }
        TiebaStatic.log("c12261");
        yc7.d(this.n.k());
        view2.setTag(this.n);
        View.OnClickListener onClickListener = this.o;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    @Override // com.baidu.tieba.sn6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) != null) || this.m == i) {
            return;
        }
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundResource(h(), R.drawable.square_search_item_bg);
        this.m = i;
    }

    public SpannableStringBuilder s(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                String trim = str2.trim();
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                int indexOf = str.indexOf(trim);
                if (indexOf != -1) {
                    spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, trim.length() + indexOf, 33);
                }
                return spannableStringBuilder;
            }
            return null;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }
}
