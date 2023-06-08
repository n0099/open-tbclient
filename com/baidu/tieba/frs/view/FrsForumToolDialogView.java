package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.o75;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsForumToolDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TbImageView c;
    public TextView d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsForumToolDialogView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d034b, this);
            this.c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0911da);
            this.b = (TextView) findViewById(R.id.tv_content);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0904a6);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0904ca);
            this.a.setText(R.string.obfuscated_res_0x7f0f03c9);
            this.d.setText(R.string.know_more);
            this.c.setPlaceHolder(3);
            this.c.setDrawCorner(true);
            this.c.setAutoChangeStyle(true);
            this.c.setConrers(3);
            this.c.setRadiusById(R.string.J_X06);
            o75 d = o75.d(this.b);
            d.w(R.color.CAM_X0107);
            d.y(R.dimen.M_T_X001);
            d.B(R.dimen.T_X06);
            o75 d2 = o75.d(this.a);
            d2.w(R.color.CAM_X0105);
            d2.o(R.string.J_X07);
            d2.m(R.dimen.L_X02);
            d2.B(R.dimen.T_X08);
            d2.l(R.color.CAM_X0902);
            d2.f(R.color.CAM_X0201);
            o75 d3 = o75.d(this.d);
            d3.w(R.color.CAM_X0302);
            d3.o(R.string.J_X07);
            d3.B(R.dimen.T_X08);
            d3.m(R.dimen.L_X02);
            d3.e(R.string.A_X07);
            d3.l(R.color.CAM_X0302);
            d3.f(R.color.CAM_X0201);
            o75 d4 = o75.d(this);
            d4.o(R.string.J_X06);
            d4.n(0);
            d4.f(R.color.CAM_X0201);
        }
    }

    public void setCancleButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) && onClickListener != null) {
            this.a.setOnClickListener(onClickListener);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) && onClickListener != null) {
            this.d.setOnClickListener(onClickListener);
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.b.setText(str);
        }
    }

    public void setStartLoadUrl(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            if (i != 1 && i != 2) {
                this.c.N(str, 10, false);
            } else {
                this.c.N(str, 24, false);
            }
        }
    }
}
