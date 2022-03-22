package com.baidu.tieba.frs.extra.adapter;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.d.f.p.n;
import c.a.o0.r.r.b2;
import c.a.o0.r.r.d2;
import c.a.p0.a4.h0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsU9ViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f32485b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f32486c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f32487d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32488e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f32489f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f32490g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f32491h;
    public View i;
    public TextView j;
    public b2 k;
    public d2 l;
    public ImageView m;
    public View n;
    public int o;
    public View.OnClickListener p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsU9ViewHolder a;

        public a(FrsU9ViewHolder frsU9ViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsU9ViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsU9ViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) && n.C()) {
                if (view == this.a.f32485b) {
                    if (this.a.k == null || TextUtils.isEmpty(this.a.k.b())) {
                        return;
                    }
                    TiebaStatic.eventStat(this.a.a.getPageActivity(), "num_click", "click", 1, new Object[0]);
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.a.a.getPageActivity()), new String[]{this.a.k.b()});
                } else if (view != this.a.f32486c || this.a.l == null || TextUtils.isEmpty(this.a.l.J0())) {
                } else {
                    TiebaStatic.eventStat(this.a.a.getPageActivity(), "info_click", "click", 1, "page", "frs");
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.a.a.getPageActivity()), new String[]{this.a.l.J0()});
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsU9ViewHolder(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, bdUniqueId};
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
        this.o = 3;
        this.p = new a(this);
        this.a = tbPageContext;
        this.f32485b = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f092254);
        this.f32486c = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f092253);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0920ac);
        this.f32487d = tbImageView;
        tbImageView.setPageId(bdUniqueId);
        this.f32488e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920a8);
        this.f32489f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920a9);
        this.f32490g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920a5);
        this.f32491h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920ab);
        this.i = view.findViewById(R.id.obfuscated_res_0x7f092255);
        ImageView imageView = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09156c);
        this.m = imageView;
        imageView.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.icon_frs_news));
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09156d);
        this.n = view.findViewById(R.id.obfuscated_res_0x7f090b7a);
        SkinManager.setBackgroundResource(this.f32491h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.f32491h, (int) R.drawable.frs_text_color_selector);
        j();
    }

    public void h(h0 h0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, h0Var) == null) || h0Var == null) {
            return;
        }
        b2 e2 = h0Var.e();
        d2 g2 = h0Var.g();
        this.k = e2;
        this.l = g2;
        if (h0Var.i()) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
        b2 b2Var = this.k;
        if (b2Var == null) {
            this.f32485b.setVisibility(8);
            this.i.setVisibility(8);
        } else if (StringUtils.isNull(b2Var.g())) {
            this.f32485b.setVisibility(8);
            this.i.setVisibility(8);
        } else {
            this.f32485b.setVisibility(0);
            this.i.setVisibility(0);
            this.f32487d.J(this.k.e(), 10, false);
            this.f32488e.setText(this.k.g());
            if (StringUtils.isNull(e2.a())) {
                this.f32491h.setVisibility(8);
            } else {
                this.f32491h.setText(e2.a());
                this.f32491h.setVisibility(0);
            }
            int c2 = this.k.c();
            if (c2 != 1 && c2 != 2) {
                this.f32490g.setVisibility(8);
                this.f32489f.setText(e2.f());
                this.f32489f.setVisibility(0);
            } else {
                if (StringUtils.isNull(this.k.h())) {
                    this.f32489f.setVisibility(8);
                } else {
                    String str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1458) + this.k.h();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.k.h(), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f32489f.setText(spannableString);
                    this.f32489f.setVisibility(0);
                }
                if (e2.d() <= 0) {
                    this.f32490g.setVisibility(8);
                } else {
                    String str2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1459) + this.k.d();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.k.d()), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f32490g.setText(spannableString2);
                    this.f32490g.setVisibility(0);
                }
            }
        }
        if (this.l != null && !StringUtils.isNull(g2.K0())) {
            this.f32486c.setVisibility(0);
            this.j.setText(g2.K0());
            return;
        }
        this.f32486c.setVisibility(8);
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.o == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.m, R.drawable.icon_frs_news);
        SkinManager.setBackgroundResource(this.f32491h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.f32491h, (int) R.drawable.frs_text_color_selector);
        this.a.getLayoutMode().k(i == 1);
        this.a.getLayoutMode().j(b());
        this.o = i;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f32485b.setOnClickListener(this.p);
            this.f32486c.setOnClickListener(this.p);
        }
    }
}
