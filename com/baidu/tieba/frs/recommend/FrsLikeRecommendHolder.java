package com.baidu.tieba.frs.recommend;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.o0.r.l0.n.b;
import c.a.p0.a4.c;
import c.a.p0.a4.m;
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
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes5.dex */
public class FrsLikeRecommendHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public final BarImageView f32806b;

    /* renamed from: c  reason: collision with root package name */
    public final SymbolEMTextView f32807c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f32808d;

    /* renamed from: e  reason: collision with root package name */
    public final TBSpecificationBtn f32809e;

    /* renamed from: f  reason: collision with root package name */
    public final ThemeColorInfo f32810f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLikeRecommendHolder(View view, ThemeColorInfo themeColorInfo) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, themeColorInfo};
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
        this.f32810f = themeColorInfo;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090b58);
        this.a = linearLayout;
        this.f32806b = (BarImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090a44);
        this.f32807c = (SymbolEMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a69);
        this.f32808d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a64);
        this.f32809e = (TBSpecificationBtn) this.a.findViewById(R.id.obfuscated_res_0x7f090a59);
        BarImageView barImageView = this.f32806b;
        if (barImageView != null) {
            barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            BarImageView barImageView2 = this.f32806b;
            barImageView2.setContentDescription(barImageView2.getResources().getString(R.string.obfuscated_res_0x7f0f02d1));
            this.f32806b.setStrokeColorResId(R.color.CAM_X0401);
            BarImageView barImageView3 = this.f32806b;
            barImageView3.setStrokeWith(n.f(barImageView3.getContext(), R.dimen.tbds3));
            this.f32806b.setShowOval(true);
            this.f32806b.setPlaceHolder(1);
        }
        TBSpecificationBtn tBSpecificationBtn = this.f32809e;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setTextSize(R.dimen.T_X08);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void c(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mVar) == null) {
            BarImageView barImageView = this.f32806b;
            if (barImageView != null) {
                barImageView.J(mVar.f12278b, 10, false);
            }
            SymbolEMTextView symbolEMTextView = this.f32807c;
            if (symbolEMTextView != null) {
                symbolEMTextView.setText(mVar.f12279c + this.f32807c.getContext().getString(R.string.obfuscated_res_0x7f0f063c));
            }
            TextView textView = this.f32808d;
            if (textView != null) {
                textView.setText(mVar.f12280d);
            }
            if (this.f32809e != null) {
                if (mVar.f12281e) {
                    b bVar = new b();
                    bVar.p(R.color.CAM_X0903, R.color.CAM_X0109);
                    this.f32809e.setConfig(bVar);
                    TBSpecificationBtn tBSpecificationBtn = this.f32809e;
                    tBSpecificationBtn.setText(tBSpecificationBtn.getContext().getString(R.string.obfuscated_res_0x7f0f0627));
                    return;
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                String str = null;
                ThemeElement themeElement = this.f32810f.dark;
                if (themeElement != null && skinType == 4) {
                    str = themeElement.font_color;
                } else {
                    ThemeElement themeElement2 = this.f32810f.night;
                    if (themeElement2 != null && skinType == 1) {
                        str = themeElement2.font_color;
                    } else {
                        ThemeElement themeElement3 = this.f32810f.day;
                        if (themeElement3 != null) {
                            str = themeElement3.font_color;
                        }
                    }
                }
                b bVar2 = new b();
                bVar2.s(c.e(str));
                this.f32809e.setConfig(bVar2);
                TBSpecificationBtn tBSpecificationBtn2 = this.f32809e;
                tBSpecificationBtn2.setText(tBSpecificationBtn2.getContext().getString(R.string.obfuscated_res_0x7f0f06fe));
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = this.a;
            if (linearLayout != null) {
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(linearLayout);
                d2.n(R.string.J_X05);
                d2.f(R.color.CAM_X0201);
            }
            SymbolEMTextView symbolEMTextView = this.f32807c;
            if (symbolEMTextView != null) {
                c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(symbolEMTextView);
                d3.A(R.string.F_X01);
                d3.v(R.color.CAM_X0105);
            }
            TextView textView = this.f32808d;
            if (textView != null) {
                c.a.o0.r.v.c.d(textView).v(R.color.CAM_X0109);
            }
            TBSpecificationBtn tBSpecificationBtn = this.f32809e;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }

    public void e(View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || (tBSpecificationBtn = this.f32809e) == null) {
            return;
        }
        tBSpecificationBtn.setOnClickListener(onClickListener);
    }
}
