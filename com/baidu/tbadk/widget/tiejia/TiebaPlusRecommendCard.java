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
import c.a.q0.b.d;
import c.a.q0.d1.p0;
import c.a.q0.s.q.d2;
import c.a.q0.s.u.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.ItemData;
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
    public TbImageView f48998e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressButton f48999f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49000g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49001h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49002i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f49003j;
    public TextView k;
    public TextView l;
    public View m;
    public View n;
    public View o;
    public View p;
    public final Context q;
    public TbRichTextTiebaPlusInfo r;
    public final p0 s;
    public TiePlusDownloadDialog t;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f49004e;

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
            this.f49004e = tiebaPlusRecommendCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiePlusStat.LandingType landingType;
            TiePlusStat.CardBtnType cardBtnType;
            TiePlusStat.LandingType landingType2;
            TiePlusStat.CardBtnType cardBtnType2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f49004e.r == null || this.f49004e.r.z() == null) {
                return;
            }
            TiebaPlusInfo z = this.f49004e.r.z();
            int intValue = z != null ? z.jump_type.intValue() : 0;
            if (this.f49004e.r.getType() == 36) {
                if (intValue == 2) {
                    landingType2 = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                    TiePlusStat.CardBtnType cardBtnType3 = TiePlusStat.CardBtnType.DOWNLOAD;
                    if (d.m0()) {
                        this.f49004e.h();
                    } else {
                        this.f49004e.s.onClick(view);
                    }
                    cardBtnType = cardBtnType3;
                } else {
                    if (intValue == 1) {
                        landingType2 = TiePlusStat.LandingType.H5;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f49004e.h();
                    } else if (intValue == 3) {
                        landingType2 = TiePlusStat.LandingType.WECHAT;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f49004e.h();
                    } else if (intValue == 4) {
                        landingType2 = TiePlusStat.LandingType.WECHAT_MINIAPP;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f49004e.h();
                    }
                    cardBtnType = cardBtnType2;
                }
                landingType = landingType2;
                TiebaPlusRecommendCard tiebaPlusRecommendCard = this.f49004e;
                tiebaPlusRecommendCard.i(tiebaPlusRecommendCard.r.z(), this.f49004e.r.x(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.f49004e.r.y(), this.f49004e.r.getForumId(), this.f49004e.r.w());
            }
            landingType = null;
            cardBtnType = null;
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = this.f49004e;
            tiebaPlusRecommendCard2.i(tiebaPlusRecommendCard2.r.z(), this.f49004e.r.x(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.f49004e.r.y(), this.f49004e.r.getForumId(), this.f49004e.r.w());
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TiePlusDownloadDialog.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49005a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f49006b;

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
            this.f49006b = tiebaPlusRecommendCard;
            this.f49005a = str;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, this.f49006b.r.y(), this.f49006b.r.getForumId(), this.f49006b.r.w(), this.f49005a);
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
            this.f49000g.setMaxLines(1);
            if (StringUtils.isNull(tiebaPlusInfo.title)) {
                this.f49000g.setVisibility(8);
            } else {
                this.f49000g.setVisibility(0);
                this.f49000g.setText(tiebaPlusInfo.title);
            }
            if (!StringUtils.isNull(tiebaPlusInfo.app_icon)) {
                this.f48998e.startLoad(tiebaPlusInfo.app_icon, 10, false);
            }
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.f49001h.setVisibility(8);
            } else {
                this.f49001h.setVisibility(0);
                this.f49001h.setText(tiebaPlusInfo.desc);
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_version)) {
                this.f49002i.setVisibility(8);
            } else {
                this.f49002i.setVisibility(0);
                this.f49002i.setText(String.format(this.q.getString(R.string.app_version), tiebaPlusInfo.app_version));
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_company)) {
                this.f49003j.setVisibility(8);
            } else {
                this.f49003j.setVisibility(0);
                this.f49003j.setText(tiebaPlusInfo.app_company);
            }
            if (!d.m0() && !d.n0()) {
                this.f49002i.setVisibility(0);
                this.p.setVisibility(0);
            } else {
                this.f49002i.setVisibility(8);
                this.p.setVisibility(8);
            }
            if (d.n0()) {
                this.n.setVisibility(0);
                this.f48999f.setVisibility(8);
            } else {
                this.n.setVisibility(8);
                this.f48999f.setVisibility(0);
            }
            if (this.o.getVisibility() != 8) {
                this.f49001h.requestLayout();
            }
            p0 p0Var = this.s;
            p0Var.r(tiebaPlusInfo.app_id);
            p0Var.t(tiebaPlusInfo.download_url);
            p0Var.v(tiebaPlusInfo.app_package);
            p0Var.w(tiebaPlusInfo.app_power);
            p0Var.x(tiebaPlusInfo.app_privacy);
            p0Var.d(this.f48999f);
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
            this.f49000g.setMaxLines(2);
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.f49000g.setText("");
            } else {
                this.f49000g.setText(tiebaPlusInfo.desc);
            }
            if (!StringUtils.isNull(tiebaPlusInfo.app_icon)) {
                this.f48998e.startLoad(tiebaPlusInfo.app_icon, 10, false);
            }
            this.f48999f.setText(this.q.getString(R.string.view));
            this.f48999f.setOnClickListener(this);
            if (d.o0()) {
                this.n.setVisibility(8);
                this.f48999f.setVisibility(0);
                return;
            }
            this.n.setVisibility(0);
            this.f48999f.setVisibility(8);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.tiejia_recommend_card, (ViewGroup) this, true);
            this.f48998e = (TbImageView) findViewById(R.id.tiejia_card_icon);
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.tiejia_card_download);
            this.f48999f = progressButton;
            progressButton.setUseLongText(false);
            this.f49000g = (TextView) findViewById(R.id.tiejia_card_title);
            this.f49001h = (TextView) findViewById(R.id.tiejia_card_desc);
            this.f49002i = (TextView) findViewById(R.id.tiejia_card_version);
            this.f49003j = (TextView) findViewById(R.id.tiejia_card_company);
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
        if (this.r.getType() == 36) {
            int intValue = z.jump_type.intValue();
            if (intValue != 2) {
                if (intValue == 1) {
                    this.s.f(z.jump_url, z.h5_jump_type.intValue());
                    return;
                } else if (intValue == 3) {
                    this.s.f(z.h5_jump_number, intValue);
                    return;
                } else if (intValue == 4) {
                    this.s.g(z.h5_jump_number, intValue, z.h5_jump_param);
                    return;
                } else {
                    return;
                }
            }
            String str = (this.r.x() == null || !this.r.x().R2) ? "" : this.r.x().S2;
            if (this.t == null) {
                this.t = new TiePlusDownloadDialog(this.q, this.s, false);
            }
            this.s.s(this.t);
            ItemData itemData = new ItemData();
            itemData.parseProto(z);
            this.s.u(itemData);
            this.t.setAppCompany(z.app_company).setAppIcon(z.app_icon).setAppTitle(z.title).setAppVersion(z.app_version).setDownloadClickCallback(new b(this, str));
            this.t.show();
            TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, this.r.y(), this.r.getForumId(), this.r.w(), str);
        }
    }

    public final void i(TiebaPlusInfo tiebaPlusInfo, d2 d2Var, TiePlusStat.StatType statType, TiePlusStat.LandingType landingType, TiePlusStat.CardBtnType cardBtnType, String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tiebaPlusInfo, d2Var, statType, landingType, cardBtnType, str, str2, str3}) == null) {
            if (tiebaPlusInfo == null || d2Var == null) {
                return;
            }
            int a2 = TiePlusStat.a(tiebaPlusInfo, this);
            if (d2Var.R2) {
                str4 = d2Var.S2;
                str5 = d2Var.T2;
                str6 = d2Var.U2;
            } else {
                str4 = "";
                str5 = str4;
                str6 = str5;
            }
            TiePlusStat.b(a2, statType, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, tiebaPlusInfo.target_type.intValue(), landingType, str, str2, str3, str4, cardBtnType);
            TiePlusStat.c(a2, statType, TiePlusStat.Locate.PB, str4, str5, str6, d2Var.J2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.r;
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.z() == null) {
                return;
            }
            this.s.d(this.f48999f);
            this.s.s(this.t);
            TiePlusDownloadDialog tiePlusDownloadDialog = this.t;
            if (tiePlusDownloadDialog != null && tiePlusDownloadDialog.isShowing()) {
                this.t.onAttachedToWindow();
            }
            TiebaPlusInfo z = this.r.z();
            int intValue = z.jump_type.intValue();
            TiePlusStat.LandingType landingType = null;
            if (this.r.getType() == 36) {
                if (intValue == 2) {
                    landingType = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                    if (!StringUtils.isNull(z.app_package) && !StringUtils.isNull(z.app_id)) {
                        this.s.D(z.app_package, z.app_id, this.q, this.f48999f);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(z);
                        this.s.u(itemData);
                    }
                } else if (intValue == 1) {
                    landingType = TiePlusStat.LandingType.H5;
                } else if (intValue == 3) {
                    landingType = TiePlusStat.LandingType.WECHAT;
                } else if (intValue == 4) {
                    landingType = TiePlusStat.LandingType.WECHAT_MINIAPP;
                }
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
            int intValue = this.r.z().jump_type.intValue();
            TiePlusStat.LandingType landingType = null;
            if (this.r.getType() == 36) {
                if (intValue == 2) {
                    landingType = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                } else if (intValue == 1) {
                    landingType = TiePlusStat.LandingType.H5;
                } else if (intValue == 3) {
                    landingType = TiePlusStat.LandingType.WECHAT;
                } else if (intValue == 4) {
                    landingType = TiePlusStat.LandingType.WECHAT_MINIAPP;
                }
            }
            i(this.r.z(), this.r.x(), TiePlusStat.StatType.CLICK, landingType, null, this.r.y(), this.r.getForumId(), this.r.w());
        }
    }

    public void onSkinChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c d2 = c.d(this);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            c.d(this.f48998e).n(R.string.J_X05);
            c d3 = c.d(this.f49000g);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0107);
            c d4 = c.d(this.f49001h);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0109);
            c d5 = c.d(this.f49002i);
            d5.A(R.string.F_X01);
            d5.v(R.color.CAM_X0109);
            c d6 = c.d(this.f49003j);
            d6.A(R.string.F_X01);
            d6.v(R.color.CAM_X0109);
            c d7 = c.d(this.k);
            d7.A(R.string.F_X01);
            d7.v(R.color.CAM_X0109);
            c d8 = c.d(this.l);
            d8.A(R.string.F_X01);
            d8.v(R.color.CAM_X0109);
            c.d(this.m).f(R.color.CAM_X0110);
            this.n.setBackgroundResource(R.drawable.icon_ad_dislike_arrow20_right_n);
            this.f48998e.setPlaceHolder(2);
            this.f48998e.setConrers(15);
        }
    }

    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f48999f.setCurProgress(-1);
            this.f48998e.reset();
            this.f49000g.setText("");
            this.f49001h.setText("");
            this.f49002i.setText("");
            this.f49003j.setText("");
            this.s.q();
            setOnClickListener(null);
            this.k.setOnClickListener(null);
            this.l.setOnClickListener(null);
            this.f48999f.setOnClickListener(null);
            MessageManager.getInstance().unRegisterListener(this.s);
        }
    }

    public void updateCardView(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbRichTextTiebaPlusInfo) == null) {
            this.r = tbRichTextTiebaPlusInfo;
            if (tbRichTextTiebaPlusInfo != null && tbRichTextTiebaPlusInfo.z() != null) {
                TiebaPlusInfo z = this.r.z();
                if (this.r.getType() == 36 && z != null) {
                    int intValue = z.jump_type.intValue();
                    if (intValue == 2) {
                        e(z);
                    } else if (intValue == 1 || intValue == 3 || intValue == 4) {
                        f(z);
                    }
                }
                setOnClickListener(this);
                this.f48999f.setOnClickListener(new a(this));
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
        this.s = new p0(context);
        g();
    }
}
