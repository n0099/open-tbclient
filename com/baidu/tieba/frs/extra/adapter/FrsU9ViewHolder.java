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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.i0.r.q.c2;
import d.a.i0.r.q.f2;
import d.a.j0.d3.e0;
/* loaded from: classes4.dex */
public class FrsU9ViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f16116a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f16117b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f16118c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f16119d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16120e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16121f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16122g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16123h;

    /* renamed from: i  reason: collision with root package name */
    public View f16124i;
    public TextView j;
    public c2 k;
    public f2 l;
    public ImageView m;
    public View n;
    public int o;
    public View.OnClickListener p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(FrsU9ViewHolder.this.f16116a.getPageActivity()) && l.D()) {
                if (view == FrsU9ViewHolder.this.f16117b) {
                    if (FrsU9ViewHolder.this.k == null || TextUtils.isEmpty(FrsU9ViewHolder.this.k.b())) {
                        return;
                    }
                    TiebaStatic.eventStat(FrsU9ViewHolder.this.f16116a.getPageActivity(), "num_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(FrsU9ViewHolder.this.f16116a.getPageActivity()), new String[]{FrsU9ViewHolder.this.k.b()});
                } else if (view != FrsU9ViewHolder.this.f16118c || FrsU9ViewHolder.this.l == null || TextUtils.isEmpty(FrsU9ViewHolder.this.l.C0())) {
                } else {
                    TiebaStatic.eventStat(FrsU9ViewHolder.this.f16116a.getPageActivity(), "info_click", PrefetchEvent.STATE_CLICK, 1, "page", "frs");
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(FrsU9ViewHolder.this.f16116a.getPageActivity()), new String[]{FrsU9ViewHolder.this.l.C0()});
                }
            }
        }
    }

    public FrsU9ViewHolder(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.o = 3;
        this.p = new a();
        this.f16116a = tbPageContext;
        this.f16117b = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.f16118c = (LinearLayout) view.findViewById(R.id.u9_news_info);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.top_code_img);
        this.f16119d = tbImageView;
        tbImageView.setPageId(bdUniqueId);
        this.f16120e = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.f16121f = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.f16122g = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.f16123h = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.f16124i = view.findViewById(R.id.u9_top_code_divider);
        ImageView imageView = (ImageView) view.findViewById(R.id.news_info_img);
        this.m = imageView;
        imageView.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.icon_frs_news));
        this.j = (TextView) view.findViewById(R.id.news_info_text);
        this.n = view.findViewById(R.id.frs_list_item_u9_top_line);
        SkinManager.setBackgroundResource(this.f16123h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.f16123h, R.drawable.frs_text_color_selector);
        i();
    }

    public void g(e0 e0Var) {
        if (e0Var == null) {
            return;
        }
        c2 z4 = e0Var.z4();
        f2 A4 = e0Var.A4();
        this.k = z4;
        this.l = A4;
        if (e0Var.B4()) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
        c2 c2Var = this.k;
        if (c2Var == null) {
            this.f16117b.setVisibility(8);
            this.f16124i.setVisibility(8);
        } else if (StringUtils.isNull(c2Var.g())) {
            this.f16117b.setVisibility(8);
            this.f16124i.setVisibility(8);
        } else {
            this.f16117b.setVisibility(0);
            this.f16124i.setVisibility(0);
            this.f16119d.V(this.k.e(), 10, false);
            this.f16120e.setText(this.k.g());
            if (StringUtils.isNull(z4.a())) {
                this.f16123h.setVisibility(8);
            } else {
                this.f16123h.setText(z4.a());
                this.f16123h.setVisibility(0);
            }
            int c2 = this.k.c();
            if (c2 != 1 && c2 != 2) {
                this.f16122g.setVisibility(8);
                this.f16121f.setText(z4.f());
                this.f16121f.setVisibility(0);
            } else {
                if (StringUtils.isNull(this.k.h())) {
                    this.f16121f.setVisibility(8);
                } else {
                    String str = this.f16116a.getResources().getString(R.string.u9_shengyu) + this.k.h();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.k.h(), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f16121f.setText(spannableString);
                    this.f16121f.setVisibility(0);
                }
                if (z4.d() <= 0) {
                    this.f16122g.setVisibility(8);
                } else {
                    String str2 = this.f16116a.getResources().getString(R.string.u9_worth) + this.k.d();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.k.d()), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f16122g.setText(spannableString2);
                    this.f16122g.setVisibility(0);
                }
            }
        }
        if (this.l != null && !StringUtils.isNull(A4.D0())) {
            this.f16118c.setVisibility(0);
            this.j.setText(A4.D0());
            return;
        }
        this.f16118c.setVisibility(8);
    }

    public void h(int i2) {
        if (this.o != i2) {
            SkinManager.setBackgroundResource(this.m, R.drawable.icon_frs_news);
            SkinManager.setBackgroundResource(this.f16123h, R.drawable.frs_star_btn_like);
            SkinManager.setViewTextColor(this.f16123h, R.drawable.frs_text_color_selector);
            this.f16116a.getLayoutMode().k(i2 == 1);
            this.f16116a.getLayoutMode().j(a());
            this.o = i2;
        }
    }

    public void i() {
        this.f16117b.setOnClickListener(this.p);
        this.f16118c.setOnClickListener(this.p);
    }
}
