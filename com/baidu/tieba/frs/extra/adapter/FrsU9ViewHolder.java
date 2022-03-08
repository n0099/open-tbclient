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
import c.a.q0.r.r.f2;
import c.a.q0.r.r.i2;
import c.a.r0.y3.h0;
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
    public RelativeLayout f41972b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f41973c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f41974d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f41975e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f41976f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41977g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f41978h;

    /* renamed from: i  reason: collision with root package name */
    public View f41979i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f41980j;
    public f2 k;
    public i2 l;
    public ImageView m;
    public View n;
    public int o;
    public View.OnClickListener p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsU9ViewHolder f41981e;

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
            this.f41981e = frsU9ViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f41981e.a.getPageActivity()) && n.C()) {
                if (view == this.f41981e.f41972b) {
                    if (this.f41981e.k == null || TextUtils.isEmpty(this.f41981e.k.b())) {
                        return;
                    }
                    TiebaStatic.eventStat(this.f41981e.a.getPageActivity(), "num_click", "click", 1, new Object[0]);
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f41981e.a.getPageActivity()), new String[]{this.f41981e.k.b()});
                } else if (view != this.f41981e.f41973c || this.f41981e.l == null || TextUtils.isEmpty(this.f41981e.l.J0())) {
                } else {
                    TiebaStatic.eventStat(this.f41981e.a.getPageActivity(), "info_click", "click", 1, "page", "frs");
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f41981e.a.getPageActivity()), new String[]{this.f41981e.l.J0()});
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
        this.f41972b = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.f41973c = (LinearLayout) view.findViewById(R.id.u9_news_info);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.top_code_img);
        this.f41974d = tbImageView;
        tbImageView.setPageId(bdUniqueId);
        this.f41975e = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.f41976f = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.f41977g = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.f41978h = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.f41979i = view.findViewById(R.id.u9_top_code_divider);
        ImageView imageView = (ImageView) view.findViewById(R.id.news_info_img);
        this.m = imageView;
        imageView.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.icon_frs_news));
        this.f41980j = (TextView) view.findViewById(R.id.news_info_text);
        this.n = view.findViewById(R.id.frs_list_item_u9_top_line);
        SkinManager.setBackgroundResource(this.f41978h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.f41978h, (int) R.drawable.frs_text_color_selector);
        setOnClickListener();
    }

    public void bindDataToView(h0 h0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, h0Var) == null) || h0Var == null) {
            return;
        }
        f2 U4 = h0Var.U4();
        i2 V4 = h0Var.V4();
        this.k = U4;
        this.l = V4;
        if (h0Var.W4()) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
        f2 f2Var = this.k;
        if (f2Var == null) {
            this.f41972b.setVisibility(8);
            this.f41979i.setVisibility(8);
        } else if (StringUtils.isNull(f2Var.g())) {
            this.f41972b.setVisibility(8);
            this.f41979i.setVisibility(8);
        } else {
            this.f41972b.setVisibility(0);
            this.f41979i.setVisibility(0);
            this.f41974d.startLoad(this.k.e(), 10, false);
            this.f41975e.setText(this.k.g());
            if (StringUtils.isNull(U4.a())) {
                this.f41978h.setVisibility(8);
            } else {
                this.f41978h.setText(U4.a());
                this.f41978h.setVisibility(0);
            }
            int c2 = this.k.c();
            if (c2 != 1 && c2 != 2) {
                this.f41977g.setVisibility(8);
                this.f41976f.setText(U4.f());
                this.f41976f.setVisibility(0);
            } else {
                if (StringUtils.isNull(this.k.h())) {
                    this.f41976f.setVisibility(8);
                } else {
                    String str = this.a.getResources().getString(R.string.u9_shengyu) + this.k.h();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.k.h(), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f41976f.setText(spannableString);
                    this.f41976f.setVisibility(0);
                }
                if (U4.d() <= 0) {
                    this.f41977g.setVisibility(8);
                } else {
                    String str2 = this.a.getResources().getString(R.string.u9_worth) + this.k.d();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.k.d()), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f41977g.setText(spannableString2);
                    this.f41977g.setVisibility(0);
                }
            }
        }
        if (this.l != null && !StringUtils.isNull(V4.K0())) {
            this.f41973c.setVisibility(0);
            this.f41980j.setText(V4.K0());
            return;
        }
        this.f41973c.setVisibility(8);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.o == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.m, R.drawable.icon_frs_news);
        SkinManager.setBackgroundResource(this.f41978h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.f41978h, (int) R.drawable.frs_text_color_selector);
        this.a.getLayoutMode().k(i2 == 1);
        this.a.getLayoutMode().j(getView());
        this.o = i2;
    }

    public void setOnClickListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f41972b.setOnClickListener(this.p);
            this.f41973c.setOnClickListener(this.p);
        }
    }
}
