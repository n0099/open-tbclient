package com.baidu.tieba.frs.extra.adapter;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.a.j;
import c.a.e.e.p.l;
import c.a.p0.s.q.e2;
import c.a.p0.s.q.h2;
import c.a.q0.i3.f0;
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
/* loaded from: classes7.dex */
public class FrsU9ViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f50946a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f50947b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f50948c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f50949d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f50950e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f50951f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50952g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50953h;

    /* renamed from: i  reason: collision with root package name */
    public View f50954i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f50955j;
    public e2 k;
    public h2 l;
    public ImageView m;
    public View n;
    public int o;
    public View.OnClickListener p;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsU9ViewHolder f50956e;

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
            this.f50956e = frsU9ViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f50956e.f50946a.getPageActivity()) && l.D()) {
                if (view == this.f50956e.f50947b) {
                    if (this.f50956e.k == null || TextUtils.isEmpty(this.f50956e.k.b())) {
                        return;
                    }
                    TiebaStatic.eventStat(this.f50956e.f50946a.getPageActivity(), "num_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f50956e.f50946a.getPageActivity()), new String[]{this.f50956e.k.b()});
                } else if (view != this.f50956e.f50948c || this.f50956e.l == null || TextUtils.isEmpty(this.f50956e.l.C0())) {
                } else {
                    TiebaStatic.eventStat(this.f50956e.f50946a.getPageActivity(), "info_click", PrefetchEvent.STATE_CLICK, 1, "page", "frs");
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f50956e.f50946a.getPageActivity()), new String[]{this.f50956e.l.C0()});
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
        this.f50946a = tbPageContext;
        this.f50947b = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.f50948c = (LinearLayout) view.findViewById(R.id.u9_news_info);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.top_code_img);
        this.f50949d = tbImageView;
        tbImageView.setPageId(bdUniqueId);
        this.f50950e = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.f50951f = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.f50952g = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.f50953h = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.f50954i = view.findViewById(R.id.u9_top_code_divider);
        ImageView imageView = (ImageView) view.findViewById(R.id.news_info_img);
        this.m = imageView;
        imageView.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.icon_frs_news));
        this.f50955j = (TextView) view.findViewById(R.id.news_info_text);
        this.n = view.findViewById(R.id.frs_list_item_u9_top_line);
        SkinManager.setBackgroundResource(this.f50953h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.f50953h, R.drawable.frs_text_color_selector);
        setOnClickListener();
    }

    public void bindDataToView(f0 f0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, f0Var) == null) || f0Var == null) {
            return;
        }
        e2 D4 = f0Var.D4();
        h2 E4 = f0Var.E4();
        this.k = D4;
        this.l = E4;
        if (f0Var.F4()) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
        e2 e2Var = this.k;
        if (e2Var == null) {
            this.f50947b.setVisibility(8);
            this.f50954i.setVisibility(8);
        } else if (StringUtils.isNull(e2Var.g())) {
            this.f50947b.setVisibility(8);
            this.f50954i.setVisibility(8);
        } else {
            this.f50947b.setVisibility(0);
            this.f50954i.setVisibility(0);
            this.f50949d.startLoad(this.k.e(), 10, false);
            this.f50950e.setText(this.k.g());
            if (StringUtils.isNull(D4.a())) {
                this.f50953h.setVisibility(8);
            } else {
                this.f50953h.setText(D4.a());
                this.f50953h.setVisibility(0);
            }
            int c2 = this.k.c();
            if (c2 != 1 && c2 != 2) {
                this.f50952g.setVisibility(8);
                this.f50951f.setText(D4.f());
                this.f50951f.setVisibility(0);
            } else {
                if (StringUtils.isNull(this.k.h())) {
                    this.f50951f.setVisibility(8);
                } else {
                    String str = this.f50946a.getResources().getString(R.string.u9_shengyu) + this.k.h();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.k.h(), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f50951f.setText(spannableString);
                    this.f50951f.setVisibility(0);
                }
                if (D4.d() <= 0) {
                    this.f50952g.setVisibility(8);
                } else {
                    String str2 = this.f50946a.getResources().getString(R.string.u9_worth) + this.k.d();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.k.d()), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
                    this.f50952g.setText(spannableString2);
                    this.f50952g.setVisibility(0);
                }
            }
        }
        if (this.l != null && !StringUtils.isNull(E4.D0())) {
            this.f50948c.setVisibility(0);
            this.f50955j.setText(E4.D0());
            return;
        }
        this.f50948c.setVisibility(8);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.o == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.m, R.drawable.icon_frs_news);
        SkinManager.setBackgroundResource(this.f50953h, R.drawable.frs_star_btn_like);
        SkinManager.setViewTextColor(this.f50953h, R.drawable.frs_text_color_selector);
        this.f50946a.getLayoutMode().k(i2 == 1);
        this.f50946a.getLayoutMode().j(getView());
        this.o = i2;
    }

    public void setOnClickListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f50947b.setOnClickListener(this.p);
            this.f50948c.setOnClickListener(this.p);
        }
    }
}
