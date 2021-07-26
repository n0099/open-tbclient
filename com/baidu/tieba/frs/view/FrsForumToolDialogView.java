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
import d.a.p0.s.u.c;
/* loaded from: classes4.dex */
public class FrsForumToolDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16216e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16217f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16218g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16219h;

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
            LayoutInflater.from(context).inflate(R.layout.frs_forum_tool_dialog, this);
            this.f16218g = (TbImageView) findViewById(R.id.iv_image);
            this.f16217f = (TextView) findViewById(R.id.tv_content);
            this.f16216e = (TextView) findViewById(R.id.btn_cancle);
            this.f16219h = (TextView) findViewById(R.id.btn_more);
            this.f16216e.setText(R.string.cancel);
            this.f16219h.setText(R.string.know_more);
            this.f16218g.setPlaceHolder(3);
            this.f16218g.setDrawCorner(true);
            this.f16218g.setAutoChangeStyle(true);
            this.f16218g.setConrers(3);
            this.f16218g.setRadiusById(R.string.J_X06);
            c d2 = c.d(this.f16217f);
            d2.t(R.color.CAM_X0107);
            d2.u(R.dimen.M_T_X001);
            d2.x(R.dimen.T_X06);
            c d3 = c.d(this.f16216e);
            d3.t(R.color.CAM_X0105);
            d3.n(R.string.J_X07);
            d3.l(R.dimen.L_X02);
            d3.x(R.dimen.T_X08);
            d3.k(R.color.CAM_X0902);
            d3.f(R.color.CAM_X0201);
            c d4 = c.d(this.f16219h);
            d4.t(R.color.CAM_X0302);
            d4.n(R.string.J_X07);
            d4.x(R.dimen.T_X08);
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
        this.f16216e.setOnClickListener(onClickListener);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f16219h.setOnClickListener(onClickListener);
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f16217f.setText(str);
        }
    }

    public void setStartLoadUrl(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
            if (i2 != 1 && i2 != 2) {
                this.f16218g.M(str, 10, false);
            } else {
                this.f16218g.M(str, 24, false);
            }
        }
    }
}
