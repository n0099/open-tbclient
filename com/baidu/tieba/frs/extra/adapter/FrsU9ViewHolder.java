package com.baidu.tieba.frs.extra.adapter;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.repackage.f9;
import com.repackage.jg8;
import com.repackage.li;
import com.repackage.sp4;
import com.repackage.up4;
/* loaded from: classes3.dex */
public class FrsU9ViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public RelativeLayout b;
    public LinearLayout c;
    public TbImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public View i;
    public TextView j;
    public sp4 k;
    public up4 l;
    public ImageView m;
    public View n;
    public int o;
    public View.OnClickListener p;

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) && li.D()) {
                if (view2 == this.a.b) {
                    if (this.a.k == null || TextUtils.isEmpty(this.a.k.b())) {
                        return;
                    }
                    TiebaStatic.eventStat(this.a.a.getPageActivity(), "num_click", "click", 1, new Object[0]);
                    UrlManager.getInstance().dealOneLink((TbPageContext) f9.a(this.a.a.getPageActivity()), new String[]{this.a.k.b()});
                } else if (view2 != this.a.c || this.a.l == null || TextUtils.isEmpty(this.a.l.M0())) {
                } else {
                    TiebaStatic.eventStat(this.a.a.getPageActivity(), "info_click", "click", 1, "page", "frs");
                    UrlManager.getInstance().dealOneLink((TbPageContext) f9.a(this.a.a.getPageActivity()), new String[]{this.a.l.M0()});
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsU9ViewHolder(TbPageContext tbPageContext, View view2, BdUniqueId bdUniqueId) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, bdUniqueId};
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
        this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f092236);
        this.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092235);
        TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f092093);
        this.d = tbImageView;
        tbImageView.setPageId(bdUniqueId);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09208f);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092090);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09208c);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092092);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f092237);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091543);
        this.m = imageView;
        imageView.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.icon_frs_news));
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091544);
        this.n = view2.findViewById(R.id.obfuscated_res_0x7f090b5e);
        SkinManager.setBackgroundResource(this.h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.h, (int) R.drawable.frs_text_color_selector);
        j();
    }

    public void h(jg8 jg8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jg8Var) == null) || jg8Var == null) {
            return;
        }
        sp4 e = jg8Var.e();
        up4 g = jg8Var.g();
        this.k = e;
        this.l = g;
        if (jg8Var.i()) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
        sp4 sp4Var = this.k;
        if (sp4Var == null) {
            this.b.setVisibility(8);
            this.i.setVisibility(8);
        } else if (StringUtils.isNull(sp4Var.g())) {
            this.b.setVisibility(8);
            this.i.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            this.i.setVisibility(0);
            this.d.K(this.k.e(), 10, false);
            this.e.setText(this.k.g());
            if (StringUtils.isNull(e.a())) {
                this.h.setVisibility(8);
            } else {
                this.h.setText(e.a());
                this.h.setVisibility(0);
            }
            int c = this.k.c();
            if (c != 1 && c != 2) {
                this.g.setVisibility(8);
                this.f.setText(e.f());
                this.f.setVisibility(0);
            } else {
                if (StringUtils.isNull(this.k.h())) {
                    this.f.setVisibility(8);
                } else {
                    String str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f149b) + this.k.h();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.k.h(), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f.setText(spannableString);
                    this.f.setVisibility(0);
                }
                if (e.d() <= 0) {
                    this.g.setVisibility(8);
                } else {
                    String str2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f149c) + this.k.d();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.k.d()), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.g.setText(spannableString2);
                    this.g.setVisibility(0);
                }
            }
        }
        if (this.l != null && !StringUtils.isNull(g.N0())) {
            this.c.setVisibility(0);
            this.j.setText(g.N0());
            return;
        }
        this.c.setVisibility(8);
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.o == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.m, R.drawable.icon_frs_news);
        SkinManager.setBackgroundResource(this.h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.h, (int) R.drawable.frs_text_color_selector);
        this.a.getLayoutMode().k(i == 1);
        this.a.getLayoutMode().j(b());
        this.o = i;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.setOnClickListener(this.p);
            this.c.setOnClickListener(this.p);
        }
    }
}
