package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.q0.s.u.c;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FrsForumToolDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f49105e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f49106f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f49107g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49108h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsForumToolDialogView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            LayoutInflater.from(context).inflate(f1.frs_forum_tool_dialog, this);
            this.f49107g = (TbImageView) findViewById(e1.iv_image);
            this.f49106f = (TextView) findViewById(e1.tv_content);
            this.f49105e = (TextView) findViewById(e1.btn_cancle);
            this.f49108h = (TextView) findViewById(e1.btn_more);
            this.f49105e.setText(h1.cancel);
            this.f49108h.setText(h1.know_more);
            this.f49107g.setPlaceHolder(3);
            this.f49107g.setDrawCorner(true);
            this.f49107g.setAutoChangeStyle(true);
            this.f49107g.setConrers(3);
            this.f49107g.setRadiusById(h1.J_X06);
            c d2 = c.d(this.f49106f);
            d2.v(b1.CAM_X0107);
            d2.w(c1.M_T_X001);
            d2.z(c1.T_X06);
            c d3 = c.d(this.f49105e);
            d3.v(b1.CAM_X0105);
            d3.n(h1.J_X07);
            d3.l(c1.L_X02);
            d3.z(c1.T_X08);
            d3.k(b1.CAM_X0902);
            d3.f(b1.CAM_X0201);
            c d4 = c.d(this.f49108h);
            d4.v(b1.CAM_X0302);
            d4.n(h1.J_X07);
            d4.z(c1.T_X08);
            d4.l(c1.L_X02);
            d4.e(h1.A_X07);
            d4.k(b1.CAM_X0302);
            d4.f(b1.CAM_X0201);
            c d5 = c.d(this);
            d5.n(h1.J_X06);
            d5.m(0);
            d5.f(b1.CAM_X0201);
        }
    }

    public void setCancleButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f49105e.setOnClickListener(onClickListener);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f49108h.setOnClickListener(onClickListener);
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f49106f.setText(str);
        }
    }

    public void setStartLoadUrl(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
            if (i2 != 1 && i2 != 2) {
                this.f49107g.startLoad(str, 10, false);
            } else {
                this.f49107g.startLoad(str, 24, false);
            }
        }
    }
}
