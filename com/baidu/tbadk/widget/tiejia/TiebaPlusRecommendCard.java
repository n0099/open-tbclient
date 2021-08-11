package com.baidu.tbadk.widget.tiejia;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.o0.b.d;
import c.a.o0.b1.o0;
import c.a.o0.s.q.c2;
import c.a.o0.s.u.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextTiebaPlusInfo;
import com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.TiebaPlusInfo;
/* loaded from: classes6.dex */
public class TiebaPlusRecommendCard extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f48721e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressButton f48722f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f48723g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f48724h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f48725i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f48726j;
    public TextView k;
    public TextView l;
    public View m;
    public View n;
    public View o;
    public View p;
    public final Context q;
    public TbRichTextTiebaPlusInfo r;
    public final o0 s;
    public TiePlusDownloadDialog t;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f48727e;

        public a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaPlusRecommendCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48727e = tiebaPlusRecommendCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiePlusStat.LandingType landingType;
            TiePlusStat.CardBtnType cardBtnType;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f48727e.r == null || this.f48727e.r.z() == null) {
                return;
            }
            if (this.f48727e.r.getType() == 33) {
                landingType = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                cardBtnType = TiePlusStat.CardBtnType.DOWNLOAD;
                if (d.t0()) {
                    this.f48727e.h();
                } else {
                    this.f48727e.s.onClick(view);
                }
            } else {
                landingType = TiePlusStat.LandingType.H5;
                cardBtnType = TiePlusStat.CardBtnType.H5;
                this.f48727e.h();
            }
            TiebaPlusRecommendCard tiebaPlusRecommendCard = this.f48727e;
            tiebaPlusRecommendCard.i(tiebaPlusRecommendCard.r.z(), this.f48727e.r.x(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.f48727e.r.y(), this.f48727e.r.getForumId(), this.f48727e.r.w());
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TiePlusDownloadDialog.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48728a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f48729b;

        public b(TiebaPlusRecommendCard tiebaPlusRecommendCard, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaPlusRecommendCard, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48729b = tiebaPlusRecommendCard;
            this.f48728a = str;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, this.f48729b.r.y(), this.f48729b.r.getForumId(), this.f48729b.r.w(), this.f48728a);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TiebaPlusRecommendCard(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void e(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        TbPageContext pageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tiebaPlusInfo) == null) {
            if (StringUtils.isNull(tiebaPlusInfo.desc) && StringUtils.isNull(tiebaPlusInfo.app_version)) {
                this.o.setVisibility(8);
            } else {
                this.o.setVisibility(0);
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_company) && StringUtils.isNull(tiebaPlusInfo.app_privacy) && StringUtils.isNull(tiebaPlusInfo.app_power)) {
                this.p.setVisibility(8);
            } else {
                this.p.setVisibility(0);
            }
            this.f48723g.setMaxLines(1);
            if (StringUtils.isNull(tiebaPlusInfo.title)) {
                this.f48723g.setVisibility(8);
            } else {
                this.f48723g.setVisibility(0);
                this.f48723g.setText(tiebaPlusInfo.title);
            }
            if (!StringUtils.isNull(tiebaPlusInfo.app_icon)) {
                this.f48721e.startLoad(tiebaPlusInfo.app_icon, 10, false);
            }
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.f48724h.setVisibility(8);
            } else {
                this.f48724h.setVisibility(0);
                this.f48724h.setText(tiebaPlusInfo.desc);
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_version)) {
                this.f48725i.setVisibility(8);
            } else {
                this.f48725i.setVisibility(0);
                this.f48725i.setText(String.format(this.q.getString(R.string.app_version), tiebaPlusInfo.app_version));
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_company)) {
                this.f48726j.setVisibility(8);
            } else {
                this.f48726j.setVisibility(0);
                this.f48726j.setText(tiebaPlusInfo.app_company);
            }
            if (!d.t0() && !d.u0()) {
                this.f48725i.setVisibility(0);
                this.p.setVisibility(0);
            } else {
                this.f48725i.setVisibility(8);
                this.p.setVisibility(8);
            }
            if (d.u0()) {
                this.n.setVisibility(0);
                this.f48722f.setVisibility(8);
            } else {
                this.n.setVisibility(8);
                this.f48722f.setVisibility(0);
            }
            if (this.o.getVisibility() != 8) {
                this.f48724h.requestLayout();
            }
            o0 o0Var = this.s;
            o0Var.o(tiebaPlusInfo.app_id);
            o0Var.q(tiebaPlusInfo.download_url);
            o0Var.r(tiebaPlusInfo.app_package);
            o0Var.s(tiebaPlusInfo.app_power);
            o0Var.t(tiebaPlusInfo.app_privacy);
            o0Var.d(this.f48722f);
            this.k.setOnClickListener(this.s);
            this.l.setOnClickListener(this.s);
            Context context = this.q;
            if (!(context instanceof TbPageContextSupport) || (pageContext = ((TbPageContextSupport) context).getPageContext()) == null) {
                return;
            }
            pageContext.registerListener(this.s);
        }
    }

    public final void f(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tiebaPlusInfo) == null) {
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.f48723g.setMaxLines(2);
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.f48723g.setText("");
            } else {
                this.f48723g.setText(tiebaPlusInfo.desc);
            }
            if (!StringUtils.isNull(tiebaPlusInfo.app_icon)) {
                this.f48721e.startLoad(tiebaPlusInfo.app_icon, 10, false);
            }
            this.f48722f.setText(this.q.getString(R.string.view));
            this.f48722f.setOnClickListener(this);
            if (d.v0()) {
                this.n.setVisibility(8);
                this.f48722f.setVisibility(0);
                return;
            }
            this.n.setVisibility(0);
            this.f48722f.setVisibility(8);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.tiejia_recommend_card, (ViewGroup) this, true);
            this.f48721e = (TbImageView) findViewById(R.id.tiejia_card_icon);
            this.f48722f = (ProgressButton) findViewById(R.id.tiejia_card_download);
            this.f48723g = (TextView) findViewById(R.id.tiejia_card_title);
            this.f48724h = (TextView) findViewById(R.id.tiejia_card_desc);
            this.f48725i = (TextView) findViewById(R.id.tiejia_card_version);
            this.f48726j = (TextView) findViewById(R.id.tiejia_card_company);
            this.k = (TextView) findViewById(R.id.tiejia_card_privacy);
            this.l = (TextView) findViewById(R.id.tiejia_card_permission);
            this.m = findViewById(R.id.tiejia_divider);
            this.n = findViewById(R.id.tiejia_card_arrow);
            this.o = findViewById(R.id.tiejia_card_line2);
            this.p = findViewById(R.id.tiejia_card_line3);
            this.k.setTag((byte) 16);
            this.l.setTag((byte) 17);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            setPadding(l.g(getContext(), R.dimen.M_W_X003), l.g(getContext(), R.dimen.M_H_X002), l.g(getContext(), R.dimen.tbds0), l.g(getContext(), R.dimen.M_H_X002));
            onSkinChanged();
        }
    }

    public final void h() {
        TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbRichTextTiebaPlusInfo = this.r) == null || tbRichTextTiebaPlusInfo.z() == null) {
            return;
        }
        TiebaPlusInfo z = this.r.z();
        int type = this.r.getType();
        if (type != 33) {
            if (type != 50) {
                return;
            }
            this.s.f(z.jump_url, z.h5_jump_type.intValue() == 1);
            return;
        }
        String str = (this.r.x() == null || !this.r.x().O2) ? "" : this.r.x().P2;
        if (this.t == null) {
            this.t = new TiePlusDownloadDialog(this.q, this.s, false);
        }
        this.s.p(this.t);
        this.t.setAppCompany(z.app_company).setAppIcon(z.app_icon).setAppTitle(z.title).setAppVersion(z.app_version).setDownloadClickCallback(new b(this, str));
        this.t.show();
        TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, this.r.y(), this.r.getForumId(), this.r.w(), str);
    }

    public final void i(TiebaPlusInfo tiebaPlusInfo, c2 c2Var, TiePlusStat.StatType statType, TiePlusStat.LandingType landingType, TiePlusStat.CardBtnType cardBtnType, String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tiebaPlusInfo, c2Var, statType, landingType, cardBtnType, str, str2, str3}) == null) {
            if (tiebaPlusInfo == null || c2Var == null) {
                return;
            }
            int a2 = TiePlusStat.a(tiebaPlusInfo, this);
            if (c2Var.O2) {
                str4 = c2Var.P2;
                str5 = c2Var.Q2;
                str6 = c2Var.R2;
            } else {
                str4 = "";
                str5 = str4;
                str6 = str5;
            }
            TiePlusStat.b(a2, statType, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, tiebaPlusInfo.target_type.intValue(), landingType, str, str2, str3, str4, cardBtnType);
            TiePlusStat.c(a2, statType, TiePlusStat.Locate.PB, str4, str5, str6, c2Var.G2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        TiePlusStat.LandingType landingType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.r;
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.z() == null) {
                return;
            }
            this.s.d(this.f48722f);
            this.s.p(this.t);
            TiePlusDownloadDialog tiePlusDownloadDialog = this.t;
            if (tiePlusDownloadDialog != null && tiePlusDownloadDialog.isShowing()) {
                this.t.onAttachedToWindow();
            }
            TiebaPlusInfo z = this.r.z();
            if (this.r.getType() == 33) {
                landingType = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                if (!StringUtils.isNull(z.app_package) && !StringUtils.isNull(z.app_id)) {
                    this.s.v(z.app_package, z.app_id, this.q, this.f48722f);
                }
            } else {
                landingType = TiePlusStat.LandingType.H5;
            }
            i(this.r.z(), this.r.x(), TiePlusStat.StatType.EXPOSE, landingType, null, this.r.y(), this.r.getForumId(), this.r.w());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            h();
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.r;
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.z() == null) {
                return;
            }
            i(this.r.z(), this.r.x(), TiePlusStat.StatType.CLICK, this.r.getType() == 33 ? TiePlusStat.LandingType.DIALOG_DOWNLOAD : TiePlusStat.LandingType.H5, null, this.r.y(), this.r.getForumId(), this.r.w());
        }
    }

    public void onSkinChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c d2 = c.d(this);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            c.d(this.f48721e).n(R.string.J_X05);
            c d3 = c.d(this.f48723g);
            d3.y(R.string.F_X01);
            d3.t(R.color.CAM_X0107);
            c d4 = c.d(this.f48724h);
            d4.y(R.string.F_X01);
            d4.t(R.color.CAM_X0109);
            c d5 = c.d(this.f48725i);
            d5.y(R.string.F_X01);
            d5.t(R.color.CAM_X0109);
            c d6 = c.d(this.f48726j);
            d6.y(R.string.F_X01);
            d6.t(R.color.CAM_X0109);
            c d7 = c.d(this.k);
            d7.y(R.string.F_X01);
            d7.t(R.color.CAM_X0109);
            c d8 = c.d(this.l);
            d8.y(R.string.F_X01);
            d8.t(R.color.CAM_X0109);
            c.d(this.m).f(R.color.CAM_X0110);
            this.n.setBackgroundResource(R.drawable.icon_ad_dislike_arrow20_right_n);
            this.f48721e.setPlaceHolder(2);
            this.f48721e.setConrers(15);
        }
    }

    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f48722f.setCurProgress(-1);
            this.f48721e.reset();
            this.f48723g.setText("");
            this.f48724h.setText("");
            this.f48725i.setText("");
            this.f48726j.setText("");
            this.s.n();
            setOnClickListener(null);
            this.k.setOnClickListener(null);
            this.l.setOnClickListener(null);
            this.f48722f.setOnClickListener(null);
            MessageManager.getInstance().unRegisterListener(this.s);
        }
    }

    public void updateCardView(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbRichTextTiebaPlusInfo) == null) {
            this.r = tbRichTextTiebaPlusInfo;
            if (tbRichTextTiebaPlusInfo != null && tbRichTextTiebaPlusInfo.z() != null) {
                TiebaPlusInfo z = this.r.z();
                int type = this.r.getType();
                if (type == 33) {
                    e(z);
                } else if (type == 50) {
                    f(z);
                }
                setOnClickListener(this);
                this.f48722f.setOnClickListener(new a(this));
                return;
            }
            resetData();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TiebaPlusRecommendCard(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TiebaPlusRecommendCard(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.q = context;
        this.s = new o0(context);
        g();
    }
}
