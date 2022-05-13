package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gs4;
/* loaded from: classes3.dex */
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d030b, this);
            this.c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090fe1);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0921d4);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f09040f);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090428);
            this.a.setText(R.string.obfuscated_res_0x7f0f0374);
            this.d.setText(R.string.obfuscated_res_0x7f0f0989);
            this.c.setPlaceHolder(3);
            this.c.setDrawCorner(true);
            this.c.setAutoChangeStyle(true);
            this.c.setConrers(3);
            this.c.setRadiusById(R.string.J_X06);
            gs4 d = gs4.d(this.b);
            d.v(R.color.CAM_X0107);
            d.w(R.dimen.M_T_X001);
            d.z(R.dimen.T_X06);
            gs4 d2 = gs4.d(this.a);
            d2.v(R.color.CAM_X0105);
            d2.n(R.string.J_X07);
            d2.l(R.dimen.L_X02);
            d2.z(R.dimen.T_X08);
            d2.k(R.color.CAM_X0902);
            d2.f(R.color.CAM_X0201);
            gs4 d3 = gs4.d(this.d);
            d3.v(R.color.CAM_X0302);
            d3.n(R.string.J_X07);
            d3.z(R.dimen.T_X08);
            d3.l(R.dimen.L_X02);
            d3.e(R.string.A_X07);
            d3.k(R.color.CAM_X0302);
            d3.f(R.color.CAM_X0201);
            gs4 d4 = gs4.d(this);
            d4.n(R.string.J_X06);
            d4.m(0);
            d4.f(R.color.CAM_X0201);
        }
    }

    public void setCancleButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.a.setOnClickListener(onClickListener);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.d.setOnClickListener(onClickListener);
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
                this.c.K(str, 10, false);
            } else {
                this.c.K(str, 24, false);
            }
        }
    }
}
