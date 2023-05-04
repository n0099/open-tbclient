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
import com.baidu.tieba.do9;
import com.baidu.tieba.e65;
import com.baidu.tieba.g35;
import com.baidu.tieba.ii;
import com.baidu.tieba.un9;
import com.baidu.tieba.view.SymbolEMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
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
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c92);
        this.a = linearLayout;
        this.b = (BarImageView) linearLayout.findViewById(R.id.forum_head_image);
        this.c = (SymbolEMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090b96);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090b91);
        this.e = (TBSpecificationBtn) this.a.findViewById(R.id.obfuscated_res_0x7f090b86);
        BarImageView barImageView = this.b;
        if (barImageView != null) {
            barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            BarImageView barImageView2 = this.b;
            barImageView2.setContentDescription(barImageView2.getResources().getString(R.string.obfuscated_res_0x7f0f02ed));
            this.b.setStrokeColorResId(R.color.CAM_X0401);
            BarImageView barImageView3 = this.b;
            barImageView3.setStrokeWith(ii.g(barImageView3.getContext(), R.dimen.tbds3));
            this.b.setShowOval(true);
            this.b.setPlaceHolder(1);
        }
        TBSpecificationBtn tBSpecificationBtn = this.e;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setTextSize(R.dimen.T_X08);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void a(do9 do9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, do9Var) == null) {
            BarImageView barImageView = this.b;
            if (barImageView != null) {
                barImageView.N(do9Var.a, 10, false);
            }
            SymbolEMTextView symbolEMTextView = this.c;
            if (symbolEMTextView != null) {
                symbolEMTextView.setText(do9Var.b + this.c.getContext().getString(R.string.obfuscated_res_0x7f0f06c2));
            }
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(do9Var.c);
            }
            if (this.e != null) {
                if (do9Var.d) {
                    e65 e65Var = new e65();
                    e65Var.r(R.color.CAM_X0903, R.color.CAM_X0109);
                    this.e.setConfig(e65Var);
                    TBSpecificationBtn tBSpecificationBtn = this.e;
                    tBSpecificationBtn.setText(tBSpecificationBtn.getContext().getString(R.string.obfuscated_res_0x7f0f06ad));
                    return;
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                String str = null;
                ThemeElement themeElement = this.f.dark;
                if (themeElement != null && skinType == 4) {
                    str = themeElement.font_color;
                } else {
                    ThemeElement themeElement2 = this.f.day;
                    if (themeElement2 != null) {
                        str = themeElement2.font_color;
                    }
                }
                e65 e65Var2 = new e65();
                e65Var2.u(un9.f(str));
                this.e.setConfig(e65Var2);
                TBSpecificationBtn tBSpecificationBtn2 = this.e;
                tBSpecificationBtn2.setText(tBSpecificationBtn2.getContext().getString(R.string.obfuscated_res_0x7f0f078b));
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = this.a;
            if (linearLayout != null) {
                g35 d = g35.d(linearLayout);
                d.o(R.string.J_X05);
                d.f(R.color.CAM_X0201);
            }
            SymbolEMTextView symbolEMTextView = this.c;
            if (symbolEMTextView != null) {
                g35 d2 = g35.d(symbolEMTextView);
                d2.C(R.string.F_X01);
                d2.w(R.color.CAM_X0105);
            }
            TextView textView = this.d;
            if (textView != null) {
                g35.d(textView).w(R.color.CAM_X0109);
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
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) && (tBSpecificationBtn = this.e) != null) {
            tBSpecificationBtn.setOnClickListener(onClickListener);
        }
    }
}
