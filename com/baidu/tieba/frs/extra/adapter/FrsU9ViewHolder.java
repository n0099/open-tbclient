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
import c.a.d.f.p.m;
import c.a.r0.s.r.f2;
import c.a.r0.s.r.i2;
import c.a.s0.v3.g0;
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
/* loaded from: classes12.dex */
public class FrsU9ViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f44753b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f44754c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f44755d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f44756e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f44757f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44758g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44759h;

    /* renamed from: i  reason: collision with root package name */
    public View f44760i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f44761j;

    /* renamed from: k  reason: collision with root package name */
    public f2 f44762k;
    public i2 l;
    public ImageView m;
    public View n;
    public int o;
    public View.OnClickListener p;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsU9ViewHolder f44763e;

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
            this.f44763e = frsU9ViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f44763e.a.getPageActivity()) && m.C()) {
                if (view == this.f44763e.f44753b) {
                    if (this.f44763e.f44762k == null || TextUtils.isEmpty(this.f44763e.f44762k.b())) {
                        return;
                    }
                    TiebaStatic.eventStat(this.f44763e.a.getPageActivity(), "num_click", "click", 1, new Object[0]);
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f44763e.a.getPageActivity()), new String[]{this.f44763e.f44762k.b()});
                } else if (view != this.f44763e.f44754c || this.f44763e.l == null || TextUtils.isEmpty(this.f44763e.l.I0())) {
                } else {
                    TiebaStatic.eventStat(this.f44763e.a.getPageActivity(), "info_click", "click", 1, "page", "frs");
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f44763e.a.getPageActivity()), new String[]{this.f44763e.l.I0()});
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
        this.a = tbPageContext;
        this.f44753b = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.f44754c = (LinearLayout) view.findViewById(R.id.u9_news_info);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.top_code_img);
        this.f44755d = tbImageView;
        tbImageView.setPageId(bdUniqueId);
        this.f44756e = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.f44757f = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.f44758g = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.f44759h = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.f44760i = view.findViewById(R.id.u9_top_code_divider);
        ImageView imageView = (ImageView) view.findViewById(R.id.news_info_img);
        this.m = imageView;
        imageView.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.icon_frs_news));
        this.f44761j = (TextView) view.findViewById(R.id.news_info_text);
        this.n = view.findViewById(R.id.frs_list_item_u9_top_line);
        SkinManager.setBackgroundResource(this.f44759h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.f44759h, R.drawable.frs_text_color_selector);
        setOnClickListener();
    }

    public void bindDataToView(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, g0Var) == null) || g0Var == null) {
            return;
        }
        f2 T4 = g0Var.T4();
        i2 U4 = g0Var.U4();
        this.f44762k = T4;
        this.l = U4;
        if (g0Var.V4()) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
        f2 f2Var = this.f44762k;
        if (f2Var == null) {
            this.f44753b.setVisibility(8);
            this.f44760i.setVisibility(8);
        } else if (StringUtils.isNull(f2Var.g())) {
            this.f44753b.setVisibility(8);
            this.f44760i.setVisibility(8);
        } else {
            this.f44753b.setVisibility(0);
            this.f44760i.setVisibility(0);
            this.f44755d.startLoad(this.f44762k.e(), 10, false);
            this.f44756e.setText(this.f44762k.g());
            if (StringUtils.isNull(T4.a())) {
                this.f44759h.setVisibility(8);
            } else {
                this.f44759h.setText(T4.a());
                this.f44759h.setVisibility(0);
            }
            int c2 = this.f44762k.c();
            if (c2 != 1 && c2 != 2) {
                this.f44758g.setVisibility(8);
                this.f44757f.setText(T4.f());
                this.f44757f.setVisibility(0);
            } else {
                if (StringUtils.isNull(this.f44762k.h())) {
                    this.f44757f.setVisibility(8);
                } else {
                    String str = this.a.getResources().getString(R.string.u9_shengyu) + this.f44762k.h();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.f44762k.h(), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f44757f.setText(spannableString);
                    this.f44757f.setVisibility(0);
                }
                if (T4.d() <= 0) {
                    this.f44758g.setVisibility(8);
                } else {
                    String str2 = this.a.getResources().getString(R.string.u9_worth) + this.f44762k.d();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.f44762k.d()), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f44758g.setText(spannableString2);
                    this.f44758g.setVisibility(0);
                }
            }
        }
        if (this.l != null && !StringUtils.isNull(U4.J0())) {
            this.f44754c.setVisibility(0);
            this.f44761j.setText(U4.J0());
            return;
        }
        this.f44754c.setVisibility(8);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.o == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.m, R.drawable.icon_frs_news);
        SkinManager.setBackgroundResource(this.f44759h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.f44759h, R.drawable.frs_text_color_selector);
        this.a.getLayoutMode().k(i2 == 1);
        this.a.getLayoutMode().j(getView());
        this.o = i2;
    }

    public void setOnClickListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f44753b.setOnClickListener(this.p);
            this.f44754c.setOnClickListener(this.p);
        }
    }
}
