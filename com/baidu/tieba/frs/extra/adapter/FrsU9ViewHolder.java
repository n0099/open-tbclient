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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.o0.r.q.d2;
import d.a.o0.r.q.g2;
import d.a.p0.h3.e0;
/* loaded from: classes4.dex */
public class FrsU9ViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f15610a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f15611b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15612c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f15613d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15614e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15615f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15616g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15617h;

    /* renamed from: i  reason: collision with root package name */
    public View f15618i;
    public TextView j;
    public d2 k;
    public g2 l;
    public ImageView m;
    public View n;
    public int o;
    public View.OnClickListener p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsU9ViewHolder f15619e;

        public a(FrsU9ViewHolder frsU9ViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsU9ViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15619e = frsU9ViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f15619e.f15610a.getPageActivity()) && l.D()) {
                if (view == this.f15619e.f15611b) {
                    if (this.f15619e.k == null || TextUtils.isEmpty(this.f15619e.k.b())) {
                        return;
                    }
                    TiebaStatic.eventStat(this.f15619e.f15610a.getPageActivity(), "num_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f15619e.f15610a.getPageActivity()), new String[]{this.f15619e.k.b()});
                } else if (view != this.f15619e.f15612c || this.f15619e.l == null || TextUtils.isEmpty(this.f15619e.l.C0())) {
                } else {
                    TiebaStatic.eventStat(this.f15619e.f15610a.getPageActivity(), "info_click", PrefetchEvent.STATE_CLICK, 1, "page", "frs");
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f15619e.f15610a.getPageActivity()), new String[]{this.f15619e.l.C0()});
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 3;
        this.p = new a(this);
        this.f15610a = tbPageContext;
        this.f15611b = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.f15612c = (LinearLayout) view.findViewById(R.id.u9_news_info);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.top_code_img);
        this.f15613d = tbImageView;
        tbImageView.setPageId(bdUniqueId);
        this.f15614e = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.f15615f = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.f15616g = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.f15617h = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.f15618i = view.findViewById(R.id.u9_top_code_divider);
        ImageView imageView = (ImageView) view.findViewById(R.id.news_info_img);
        this.m = imageView;
        imageView.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.icon_frs_news));
        this.j = (TextView) view.findViewById(R.id.news_info_text);
        this.n = view.findViewById(R.id.frs_list_item_u9_top_line);
        SkinManager.setBackgroundResource(this.f15617h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.f15617h, R.drawable.frs_text_color_selector);
        i();
    }

    public void g(e0 e0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, e0Var) == null) || e0Var == null) {
            return;
        }
        d2 r4 = e0Var.r4();
        g2 s4 = e0Var.s4();
        this.k = r4;
        this.l = s4;
        if (e0Var.t4()) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
        d2 d2Var = this.k;
        if (d2Var == null) {
            this.f15611b.setVisibility(8);
            this.f15618i.setVisibility(8);
        } else if (StringUtils.isNull(d2Var.g())) {
            this.f15611b.setVisibility(8);
            this.f15618i.setVisibility(8);
        } else {
            this.f15611b.setVisibility(0);
            this.f15618i.setVisibility(0);
            this.f15613d.M(this.k.e(), 10, false);
            this.f15614e.setText(this.k.g());
            if (StringUtils.isNull(r4.a())) {
                this.f15617h.setVisibility(8);
            } else {
                this.f15617h.setText(r4.a());
                this.f15617h.setVisibility(0);
            }
            int c2 = this.k.c();
            if (c2 != 1 && c2 != 2) {
                this.f15616g.setVisibility(8);
                this.f15615f.setText(r4.f());
                this.f15615f.setVisibility(0);
            } else {
                if (StringUtils.isNull(this.k.h())) {
                    this.f15615f.setVisibility(8);
                } else {
                    String str = this.f15610a.getResources().getString(R.string.u9_shengyu) + this.k.h();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.k.h(), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f15615f.setText(spannableString);
                    this.f15615f.setVisibility(0);
                }
                if (r4.d() <= 0) {
                    this.f15616g.setVisibility(8);
                } else {
                    String str2 = this.f15610a.getResources().getString(R.string.u9_worth) + this.k.d();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.k.d()), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f15616g.setText(spannableString2);
                    this.f15616g.setVisibility(0);
                }
            }
        }
        if (this.l != null && !StringUtils.isNull(s4.D0())) {
            this.f15612c.setVisibility(0);
            this.j.setText(s4.D0());
            return;
        }
        this.f15612c.setVisibility(8);
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.o == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.m, R.drawable.icon_frs_news);
        SkinManager.setBackgroundResource(this.f15617h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.f15617h, R.drawable.frs_text_color_selector);
        this.f15610a.getLayoutMode().k(i2 == 1);
        this.f15610a.getLayoutMode().j(a());
        this.o = i2;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15611b.setOnClickListener(this.p);
            this.f15612c.setOnClickListener(this.p);
        }
    }
}
