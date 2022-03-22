package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.o0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsForumToolDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32934b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f32935c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32936d;

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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0313, this);
            this.f32935c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090fd9);
            this.f32934b = (TextView) findViewById(R.id.obfuscated_res_0x7f092198);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f09040a);
            this.f32936d = (TextView) findViewById(R.id.obfuscated_res_0x7f090424);
            this.a.setText(R.string.obfuscated_res_0x7f0f036c);
            this.f32936d.setText(R.string.obfuscated_res_0x7f0f0985);
            this.f32935c.setPlaceHolder(3);
            this.f32935c.setDrawCorner(true);
            this.f32935c.setAutoChangeStyle(true);
            this.f32935c.setConrers(3);
            this.f32935c.setRadiusById(R.string.J_X06);
            c d2 = c.d(this.f32934b);
            d2.v(R.color.CAM_X0107);
            d2.w(R.dimen.M_T_X001);
            d2.z(R.dimen.T_X06);
            c d3 = c.d(this.a);
            d3.v(R.color.CAM_X0105);
            d3.n(R.string.J_X07);
            d3.l(R.dimen.L_X02);
            d3.z(R.dimen.T_X08);
            d3.k(R.color.CAM_X0902);
            d3.f(R.color.CAM_X0201);
            c d4 = c.d(this.f32936d);
            d4.v(R.color.CAM_X0302);
            d4.n(R.string.J_X07);
            d4.z(R.dimen.T_X08);
            d4.l(R.dimen.L_X02);
            d4.e(R.string.A_X07);
            d4.k(R.color.CAM_X0302);
            d4.f(R.color.CAM_X0201);
            c d5 = c.d(this);
            d5.n(R.string.J_X06);
            d5.m(0);
            d5.f(R.color.CAM_X0201);
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
        this.f32936d.setOnClickListener(onClickListener);
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f32934b.setText(str);
        }
    }

    public void setStartLoadUrl(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            if (i != 1 && i != 2) {
                this.f32935c.J(str, 10, false);
            } else {
                this.f32935c.J(str, 24, false);
            }
        }
    }
}
