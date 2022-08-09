package com.baidu.tieba.frs.recommend;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SymbolEMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gj8;
import com.repackage.ms4;
import com.repackage.pv4;
import com.repackage.qi;
import com.repackage.qj8;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes3.dex */
public class FrsLikeRecommendHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinearLayout a;
    public final BarImageView b;
    public final SymbolEMTextView c;
    public final TextView d;
    public final TBSpecificationBtn e;
    public final ThemeColorInfo f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLikeRecommendHolder(View view2, ThemeColorInfo themeColorInfo) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, themeColorInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = themeColorInfo;
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b68);
        this.a = linearLayout;
        this.b = (BarImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090a57);
        this.c = (SymbolEMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a75);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a70);
        this.e = (TBSpecificationBtn) this.a.findViewById(R.id.obfuscated_res_0x7f090a65);
        BarImageView barImageView = this.b;
        if (barImageView != null) {
            barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            BarImageView barImageView2 = this.b;
            barImageView2.setContentDescription(barImageView2.getResources().getString(R.string.obfuscated_res_0x7f0f02e1));
            this.b.setStrokeColorResId(R.color.CAM_X0401);
            BarImageView barImageView3 = this.b;
            barImageView3.setStrokeWith(qi.f(barImageView3.getContext(), R.dimen.tbds3));
            this.b.setShowOval(true);
            this.b.setPlaceHolder(1);
        }
        TBSpecificationBtn tBSpecificationBtn = this.e;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setTextSize(R.dimen.T_X08);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void a(qj8 qj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qj8Var) == null) {
            BarImageView barImageView = this.b;
            if (barImageView != null) {
                barImageView.K(qj8Var.a, 10, false);
            }
            SymbolEMTextView symbolEMTextView = this.c;
            if (symbolEMTextView != null) {
                symbolEMTextView.setText(qj8Var.b + this.c.getContext().getString(R.string.obfuscated_res_0x7f0f065a));
            }
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(qj8Var.c);
            }
            if (this.e != null) {
                if (qj8Var.d) {
                    pv4 pv4Var = new pv4();
                    pv4Var.p(R.color.CAM_X0903, R.color.CAM_X0109);
                    this.e.setConfig(pv4Var);
                    TBSpecificationBtn tBSpecificationBtn = this.e;
                    tBSpecificationBtn.setText(tBSpecificationBtn.getContext().getString(R.string.obfuscated_res_0x7f0f0645));
                    return;
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                String str = null;
                ThemeElement themeElement = this.f.dark;
                if (themeElement != null && skinType == 4) {
                    str = themeElement.font_color;
                } else {
                    ThemeElement themeElement2 = this.f.night;
                    if (themeElement2 != null && skinType == 1) {
                        str = themeElement2.font_color;
                    } else {
                        ThemeElement themeElement3 = this.f.day;
                        if (themeElement3 != null) {
                            str = themeElement3.font_color;
                        }
                    }
                }
                pv4 pv4Var2 = new pv4();
                pv4Var2.s(gj8.f(str));
                this.e.setConfig(pv4Var2);
                TBSpecificationBtn tBSpecificationBtn2 = this.e;
                tBSpecificationBtn2.setText(tBSpecificationBtn2.getContext().getString(R.string.obfuscated_res_0x7f0f071d));
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = this.a;
            if (linearLayout != null) {
                ms4 d = ms4.d(linearLayout);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0201);
            }
            SymbolEMTextView symbolEMTextView = this.c;
            if (symbolEMTextView != null) {
                ms4 d2 = ms4.d(symbolEMTextView);
                d2.A(R.string.F_X01);
                d2.v(R.color.CAM_X0105);
            }
            TextView textView = this.d;
            if (textView != null) {
                ms4.d(textView).v(R.color.CAM_X0109);
            }
            TBSpecificationBtn tBSpecificationBtn = this.e;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }

    public void c(View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || (tBSpecificationBtn = this.e) == null) {
            return;
        }
        tBSpecificationBtn.setOnClickListener(onClickListener);
    }
}
