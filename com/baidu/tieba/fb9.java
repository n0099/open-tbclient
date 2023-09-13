package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public ImageView b;
    public Context c;
    public TextView d;

    public fb9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            BDLayoutMode layoutMode = tbPageContext.getLayoutMode();
            if (skinType == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            tbPageContext.getLayoutMode().onModeChanged(this.a);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.b.setOnClickListener(onClickListener);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.d.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f15f6), Integer.valueOf(i)));
        }
    }

    public View b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.c = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d097a, (ViewGroup) null);
            this.a = inflate;
            inflate.setTag(this);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092478);
            this.b = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092477);
            return this.a;
        }
        return (View) invokeL.objValue;
    }
}
