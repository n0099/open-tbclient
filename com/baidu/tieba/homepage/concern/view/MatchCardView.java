package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.fp7;
import com.baidu.tieba.g35;
import com.baidu.tieba.ii;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.MatchCardInfo;
/* loaded from: classes4.dex */
public class MatchCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public EMTextView b;
    public HeadImageView c;
    public EMTextView d;
    public HeadImageView e;
    public EMTextView f;
    public EMTextView g;
    public EMTextView h;
    public View i;
    public MatchCardInfo j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MatchCardView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchCardView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MatchCardView(TbPageContext tbPageContext) {
        this(tbPageContext.getPageActivity(), null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g35 d = g35.d(this.b);
            int i = R.dimen.T_X12;
            d.B(R.dimen.T_X12);
            d.w(R.color.CAM_X0107);
            g35 d2 = g35.d(this.d);
            d2.B(R.dimen.T_X12);
            d2.w(R.color.CAM_X0107);
            this.c.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.e.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            g35 d3 = g35.d(this.f);
            d3.B(R.dimen.T_X09);
            int i2 = R.color.CAM_X0108;
            d3.w(R.color.CAM_X0108);
            MatchCardInfo matchCardInfo = this.j;
            if (matchCardInfo == null || matchCardInfo.status.intValue() != 1) {
                i = R.dimen.T_X04;
            }
            g35 d4 = g35.d(this.g);
            d4.C(R.string.F_X02);
            d4.B(i);
            d4.w(R.color.CAM_X0105);
            MatchCardInfo matchCardInfo2 = this.j;
            if (matchCardInfo2 != null && matchCardInfo2.status.intValue() == 2) {
                i2 = R.color.CAM_X0302;
            }
            g35 d5 = g35.d(this.h);
            d5.B(R.dimen.T_X10);
            d5.w(i2);
            d5.o(R.string.J_X04);
            d5.e(R.string.A_X11);
            d5.f(i2);
            g35.d(this.i).f(R.color.CAM_X0203);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07e3, (ViewGroup) this, true);
            setOrientation(1);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.bottomMargin = ii.g(getContext(), R.dimen.tbds4);
            setLayoutParams(marginLayoutParams);
            this.b = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0922f6);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f0922f4);
            this.c = headImageView;
            headImageView.setIsRound(true);
            this.c.setDefaultResource(R.drawable.pic_head_topic);
            this.d = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0922f7);
            HeadImageView headImageView2 = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f0922f5);
            this.e = headImageView2;
            headImageView2.setIsRound(true);
            this.e.setDefaultResource(R.drawable.pic_head_topic);
            this.f = (EMTextView) findViewById(R.id.obfuscated_res_0x7f09164e);
            this.g = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091650);
            this.h = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091651);
            this.i = findViewById(R.id.bottom_divider);
        }
    }

    public void setData(fp7 fp7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fp7Var) == null) && fp7Var != null && fp7Var.a() != null) {
            this.j = fp7Var.a();
            this.b.setText(fp7Var.a().team_name_a);
            this.c.N(fp7Var.a().team_icon_a, 12, false);
            this.d.setText(fp7Var.a().team_name_b);
            this.e.N(fp7Var.a().team_icon_b, 12, false);
            this.f.setText(fp7Var.a().name);
            int intValue = this.j.status.intValue();
            if (intValue != 2) {
                if (intValue != 3) {
                    this.g.setText(fp7Var.a().start_desc);
                    this.h.setText("未开始");
                } else {
                    this.h.setText("已结束");
                    this.g.setText(String.format("%d - %d", fp7Var.a().team_score_a, fp7Var.a().team_score_b));
                }
            } else {
                this.h.setText("进行中");
                this.g.setText(String.format("%d - %d", fp7Var.a().team_score_a, fp7Var.a().team_score_b));
            }
            a();
        }
    }
}
