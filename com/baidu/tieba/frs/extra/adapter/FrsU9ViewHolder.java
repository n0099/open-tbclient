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
import c.a.s0.s.q.g2;
import c.a.s0.s.q.j2;
import c.a.t0.x3.g0;
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
    public RelativeLayout f43335b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f43336c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f43337d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f43338e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f43339f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f43340g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f43341h;

    /* renamed from: i  reason: collision with root package name */
    public View f43342i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f43343j;
    public g2 k;
    public j2 l;
    public ImageView m;
    public View n;
    public int o;
    public View.OnClickListener p;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsU9ViewHolder f43344e;

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
            this.f43344e = frsU9ViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f43344e.a.getPageActivity()) && n.C()) {
                if (view == this.f43344e.f43335b) {
                    if (this.f43344e.k == null || TextUtils.isEmpty(this.f43344e.k.b())) {
                        return;
                    }
                    TiebaStatic.eventStat(this.f43344e.a.getPageActivity(), "num_click", "click", 1, new Object[0]);
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f43344e.a.getPageActivity()), new String[]{this.f43344e.k.b()});
                } else if (view != this.f43344e.f43336c || this.f43344e.l == null || TextUtils.isEmpty(this.f43344e.l.J0())) {
                } else {
                    TiebaStatic.eventStat(this.f43344e.a.getPageActivity(), "info_click", "click", 1, "page", "frs");
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f43344e.a.getPageActivity()), new String[]{this.f43344e.l.J0()});
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
        this.f43335b = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.f43336c = (LinearLayout) view.findViewById(R.id.u9_news_info);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.top_code_img);
        this.f43337d = tbImageView;
        tbImageView.setPageId(bdUniqueId);
        this.f43338e = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.f43339f = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.f43340g = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.f43341h = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.f43342i = view.findViewById(R.id.u9_top_code_divider);
        ImageView imageView = (ImageView) view.findViewById(R.id.news_info_img);
        this.m = imageView;
        imageView.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.icon_frs_news));
        this.f43343j = (TextView) view.findViewById(R.id.news_info_text);
        this.n = view.findViewById(R.id.frs_list_item_u9_top_line);
        SkinManager.setBackgroundResource(this.f43341h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.f43341h, R.drawable.frs_text_color_selector);
        setOnClickListener();
    }

    public void bindDataToView(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, g0Var) == null) || g0Var == null) {
            return;
        }
        g2 U4 = g0Var.U4();
        j2 V4 = g0Var.V4();
        this.k = U4;
        this.l = V4;
        if (g0Var.W4()) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
        g2 g2Var = this.k;
        if (g2Var == null) {
            this.f43335b.setVisibility(8);
            this.f43342i.setVisibility(8);
        } else if (StringUtils.isNull(g2Var.g())) {
            this.f43335b.setVisibility(8);
            this.f43342i.setVisibility(8);
        } else {
            this.f43335b.setVisibility(0);
            this.f43342i.setVisibility(0);
            this.f43337d.startLoad(this.k.e(), 10, false);
            this.f43338e.setText(this.k.g());
            if (StringUtils.isNull(U4.a())) {
                this.f43341h.setVisibility(8);
            } else {
                this.f43341h.setText(U4.a());
                this.f43341h.setVisibility(0);
            }
            int c2 = this.k.c();
            if (c2 != 1 && c2 != 2) {
                this.f43340g.setVisibility(8);
                this.f43339f.setText(U4.f());
                this.f43339f.setVisibility(0);
            } else {
                if (StringUtils.isNull(this.k.h())) {
                    this.f43339f.setVisibility(8);
                } else {
                    String str = this.a.getResources().getString(R.string.u9_shengyu) + this.k.h();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.k.h(), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f43339f.setText(spannableString);
                    this.f43339f.setVisibility(0);
                }
                if (U4.d() <= 0) {
                    this.f43340g.setVisibility(8);
                } else {
                    String str2 = this.a.getResources().getString(R.string.u9_worth) + this.k.d();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.k.d()), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f43340g.setText(spannableString2);
                    this.f43340g.setVisibility(0);
                }
            }
        }
        if (this.l != null && !StringUtils.isNull(V4.K0())) {
            this.f43336c.setVisibility(0);
            this.f43343j.setText(V4.K0());
            return;
        }
        this.f43336c.setVisibility(8);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.o == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.m, R.drawable.icon_frs_news);
        SkinManager.setBackgroundResource(this.f43341h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.f43341h, R.drawable.frs_text_color_selector);
        this.a.getLayoutMode().k(i2 == 1);
        this.a.getLayoutMode().j(getView());
        this.o = i2;
    }

    public void setOnClickListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f43335b.setOnClickListener(this.p);
            this.f43336c.setOnClickListener(this.p);
        }
    }
}
