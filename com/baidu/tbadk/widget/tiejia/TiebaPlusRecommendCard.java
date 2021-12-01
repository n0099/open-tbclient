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
import c.a.q0.b.d;
import c.a.q0.s.q.d2;
import c.a.q0.u.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.util.TiePlusHelper;
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
import com.kwad.yoga.YogaNodeJNIBase;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes9.dex */
public class TiebaPlusRecommendCard extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f42406e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressButton f42407f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42408g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42409h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42410i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42411j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f42412k;
    public TextView l;
    public View m;
    public View n;
    public View o;
    public View p;
    public final Context q;
    public TbRichTextTiebaPlusInfo r;
    public final TiePlusHelper s;
    public TiePlusDownloadDialog t;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f42413e;

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
            this.f42413e = tiebaPlusRecommendCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            int i2;
            TiePlusStat.LandingType landingType;
            TiePlusStat.CardBtnType cardBtnType;
            TiePlusStat.LandingType landingType2;
            TiePlusStat.CardBtnType cardBtnType2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42413e.r == null || this.f42413e.r.z() == null) {
                return;
            }
            TiebaPlusInfo z = this.f42413e.r.z();
            if (z != null) {
                i2 = z.jump_type.intValue();
                str = z.app_package;
            } else {
                str = null;
                i2 = 0;
            }
            String str2 = (this.f42413e.r.x() == null || !this.f42413e.r.x().U2) ? "" : this.f42413e.r.x().V2;
            if (this.f42413e.r.getType() == 36) {
                switch (i2) {
                    case 1:
                        landingType2 = TiePlusStat.LandingType.H5;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f42413e.j(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 2:
                        landingType2 = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                        TiePlusStat.CardBtnType cardBtnType3 = TiePlusStat.CardBtnType.DOWNLOAD;
                        this.f42413e.s.g(new l(TiePlusStat.StatType.DOWNLOAD_FINISHED, TiePlusStat.RichTextType.CARD, this.f42413e.r.y(), str2, str));
                        if (d.w0()) {
                            this.f42413e.j(false);
                        } else {
                            this.f42413e.s.onClick(view);
                        }
                        cardBtnType = cardBtnType3;
                        landingType = landingType2;
                        break;
                    case 3:
                        landingType2 = TiePlusStat.LandingType.WECHAT;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f42413e.j(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 4:
                        landingType2 = TiePlusStat.LandingType.WECHAT_MINIAPP;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f42413e.j(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 5:
                        landingType2 = TiePlusStat.LandingType.MESSAGE;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f42413e.j(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 6:
                        landingType2 = TiePlusStat.LandingType.APPOINT;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f42413e.j(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                }
                TiebaPlusRecommendCard tiebaPlusRecommendCard = this.f42413e;
                tiebaPlusRecommendCard.k(tiebaPlusRecommendCard.r.z(), this.f42413e.r.x(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.f42413e.r.y(), this.f42413e.r.getForumId(), this.f42413e.r.w());
            }
            landingType = null;
            cardBtnType = null;
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = this.f42413e;
            tiebaPlusRecommendCard2.k(tiebaPlusRecommendCard2.r.z(), this.f42413e.r.x(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.f42413e.r.y(), this.f42413e.r.getForumId(), this.f42413e.r.w());
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f42414b;

        public b(TiebaPlusRecommendCard tiebaPlusRecommendCard, TiebaPlusInfo tiebaPlusInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaPlusRecommendCard, tiebaPlusInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42414b = tiebaPlusRecommendCard;
            this.a = tiebaPlusInfo;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) && j2 == c.a.d.f.m.b.g(this.a.item_id, 0L)) {
                TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder(this.a);
                builder.is_appoint = 1;
                TiebaPlusInfo build = builder.build(true);
                this.f42414b.r.B(build);
                this.f42414b.l(build);
                UtilHelper.showToast(this.f42414b.q, R.string.tip_order_successs);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                UtilHelper.showToast(this.f42414b.q, R.string.tip_order_fail);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements TiePlusDownloadDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f42415b;

        public c(TiebaPlusRecommendCard tiebaPlusRecommendCard, String str) {
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
            this.f42415b = tiebaPlusRecommendCard;
            this.a = str;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, this.f42415b.r.y(), this.f42415b.r.getForumId(), this.f42415b.r.w(), this.a);
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

    public final void g(@NonNull TiebaPlusInfo tiebaPlusInfo) {
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
            this.f42408g.setMaxLines(1);
            if (StringUtils.isNull(tiebaPlusInfo.title)) {
                this.f42408g.setVisibility(8);
            } else {
                this.f42408g.setVisibility(0);
                this.f42408g.setText(tiebaPlusInfo.title);
            }
            if (!StringUtils.isNull(tiebaPlusInfo.app_icon)) {
                this.f42406e.startLoad(tiebaPlusInfo.app_icon, 10, false);
            }
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.f42409h.setVisibility(8);
            } else {
                this.f42409h.setVisibility(0);
                this.f42409h.setText(tiebaPlusInfo.desc);
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_version)) {
                this.f42410i.setVisibility(8);
            } else {
                this.f42410i.setVisibility(0);
                this.f42410i.setText(String.format(this.q.getString(R.string.app_version), tiebaPlusInfo.app_version));
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_company)) {
                this.f42411j.setVisibility(8);
            } else {
                this.f42411j.setVisibility(0);
                this.f42411j.setText(tiebaPlusInfo.app_company);
            }
            if (!d.w0() && !d.x0()) {
                this.f42410i.setVisibility(0);
                this.p.setVisibility(0);
            } else {
                this.f42410i.setVisibility(8);
                this.p.setVisibility(8);
            }
            if (d.x0()) {
                this.n.setVisibility(0);
                this.f42407f.setVisibility(8);
            } else {
                this.n.setVisibility(8);
                this.f42407f.setVisibility(0);
            }
            if (this.o.getVisibility() != 8) {
                this.f42409h.requestLayout();
            }
            TiePlusHelper tiePlusHelper = this.s;
            tiePlusHelper.C(tiebaPlusInfo.app_id);
            tiePlusHelper.G(tiebaPlusInfo.download_url);
            tiePlusHelper.M(tiebaPlusInfo.app_package);
            tiePlusHelper.O(tiebaPlusInfo.app_power);
            tiePlusHelper.Q(tiebaPlusInfo.app_privacy);
            tiePlusHelper.f(this.f42407f);
            this.f42412k.setOnClickListener(this.s);
            this.l.setOnClickListener(this.s);
            Context context = this.q;
            if (!(context instanceof TbPageContextSupport) || (pageContext = ((TbPageContextSupport) context).getPageContext()) == null) {
                return;
            }
            pageContext.registerListener(this.s);
        }
    }

    public final void h(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tiebaPlusInfo) == null) {
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.f42408g.setMaxLines(2);
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.f42408g.setText("");
            } else {
                this.f42408g.setText(tiebaPlusInfo.desc);
            }
            if (!StringUtils.isNull(tiebaPlusInfo.app_icon)) {
                this.f42406e.startLoad(tiebaPlusInfo.app_icon, 10, false);
            }
            if (tiebaPlusInfo.jump_type.intValue() == 6) {
                l(tiebaPlusInfo);
                this.n.setVisibility(8);
                this.f42407f.setVisibility(0);
            } else if (tiebaPlusInfo.jump_type.intValue() == 5) {
                this.n.setVisibility(0);
                this.f42407f.setVisibility(8);
            } else {
                this.f42407f.setTag(null);
                this.f42407f.setText(this.q.getString(R.string.view));
                this.f42407f.enableText();
                if (d.y0()) {
                    this.n.setVisibility(8);
                    this.f42407f.setVisibility(0);
                } else {
                    this.n.setVisibility(0);
                    this.f42407f.setVisibility(8);
                }
            }
            this.f42407f.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.tiejia_recommend_card, (ViewGroup) this, true);
            this.f42406e = (TbImageView) findViewById(R.id.tiejia_card_icon);
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.tiejia_card_download);
            this.f42407f = progressButton;
            progressButton.setUseLongText(false);
            this.f42408g = (TextView) findViewById(R.id.tiejia_card_title);
            this.f42409h = (TextView) findViewById(R.id.tiejia_card_desc);
            this.f42410i = (TextView) findViewById(R.id.tiejia_card_version);
            this.f42411j = (TextView) findViewById(R.id.tiejia_card_company);
            this.f42412k = (TextView) findViewById(R.id.tiejia_card_privacy);
            this.l = (TextView) findViewById(R.id.tiejia_card_permission);
            this.m = findViewById(R.id.tiejia_divider);
            this.n = findViewById(R.id.tiejia_card_arrow);
            this.o = findViewById(R.id.tiejia_card_line2);
            this.p = findViewById(R.id.tiejia_card_line3);
            this.f42412k.setTag(Byte.valueOf((byte) YogaNodeJNIBase.HAS_NEW_LAYOUT));
            this.l.setTag((byte) 17);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            setPadding(c.a.d.f.p.l.f(getContext(), R.dimen.M_W_X003), c.a.d.f.p.l.f(getContext(), R.dimen.M_H_X002), c.a.d.f.p.l.f(getContext(), R.dimen.tbds0), c.a.d.f.p.l.f(getContext(), R.dimen.M_H_X002));
            onSkinChanged();
        }
    }

    public final void j(boolean z) {
        TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo;
        PluginUser pluginUser;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (tbRichTextTiebaPlusInfo = this.r) == null || tbRichTextTiebaPlusInfo.z() == null) {
            return;
        }
        TiebaPlusInfo z2 = this.r.z();
        if (this.r.getType() == 36) {
            int intValue = z2.jump_type.intValue();
            String str = "";
            if (intValue == 2) {
                if (this.r.x() != null && this.r.x().U2) {
                    str = this.r.x().V2;
                }
                String str2 = str;
                if (this.t == null) {
                    this.t = new TiePlusDownloadDialog(this.q, this.s, false);
                }
                this.s.F(this.t);
                ItemData itemData = new ItemData();
                itemData.parseProto(z2);
                this.s.L(itemData);
                this.t.setAppCompany(z2.app_company).setAppIcon(z2.app_icon).setAppTitle(z2.title).setAppVersion(z2.app_version).setDownloadClickCallback(new c(this, str2));
                this.t.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, this.r.y(), this.r.getForumId(), this.r.w(), str2);
            } else if (intValue == 1) {
                this.s.l(z2.jump_url, 1, "", z2.h5_jump_type.intValue());
            } else if (intValue == 3) {
                this.s.l(z2.h5_jump_number, intValue, "", 0);
            } else if (intValue == 4) {
                this.s.l(z2.h5_jump_number, intValue, z2.h5_jump_param, 0);
            } else if (intValue != 6) {
                if (intValue != 5 || (pluginUser = z2.plugin_user) == null) {
                    return;
                }
                TiePlusHelper.u(this.q, pluginUser);
            } else if (z) {
                ItemClickJumpUtil.itemClickJump(z2.title, z2.item_id, 9, 9);
            } else if (z2.is_appoint.intValue() != 1) {
                this.s.B(c.a.d.f.m.b.g(z2.item_id, 0L), z2.title, null);
            } else {
                UtilHelper.showToast(this.q, R.string.tip_order_completed);
            }
        }
    }

    public final void k(TiebaPlusInfo tiebaPlusInfo, d2 d2Var, TiePlusStat.StatType statType, TiePlusStat.LandingType landingType, TiePlusStat.CardBtnType cardBtnType, String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tiebaPlusInfo, d2Var, statType, landingType, cardBtnType, str, str2, str3}) == null) {
            if (tiebaPlusInfo == null || d2Var == null) {
                return;
            }
            int a2 = TiePlusStat.a(tiebaPlusInfo, this);
            if (d2Var.U2) {
                str4 = d2Var.V2;
                str5 = d2Var.W2;
                str6 = d2Var.X2;
            } else {
                str4 = "";
                str5 = str4;
                str6 = str5;
            }
            TiePlusStat.b(a2, statType, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, tiebaPlusInfo.target_type.intValue(), landingType, str, str2, str3, str4, cardBtnType);
            TiePlusStat.c(a2, statType, TiePlusStat.Locate.PB, str4, str5, str6, d2Var.M2);
        }
    }

    public final void l(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, tiebaPlusInfo) == null) && tiebaPlusInfo != null && tiebaPlusInfo.jump_type.intValue() == 6) {
            if (tiebaPlusInfo.is_appoint.intValue() == 1) {
                this.f42407f.setText(this.q.getString(R.string.item_order_complete));
                this.f42407f.disableText();
                return;
            }
            this.s.y();
            this.f42407f.setText(this.q.getString(R.string.item_order));
            this.f42407f.enableText();
            this.s.E(new b(this, tiebaPlusInfo));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.r;
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.z() == null) {
                return;
            }
            this.s.f(this.f42407f);
            this.s.F(this.t);
            TiePlusDownloadDialog tiePlusDownloadDialog = this.t;
            if (tiePlusDownloadDialog != null && tiePlusDownloadDialog.isShowing()) {
                this.t.onAttachedToWindow();
            }
            TiebaPlusInfo z = this.r.z();
            int intValue = z.jump_type.intValue();
            TiePlusStat.LandingType landingType = null;
            if (this.r.getType() == 36) {
                switch (intValue) {
                    case 1:
                        landingType = TiePlusStat.LandingType.H5;
                        break;
                    case 2:
                        landingType = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                        if (!StringUtils.isNull(z.app_package) && !StringUtils.isNull(z.app_id)) {
                            this.s.a0(z.app_package, z.app_id, this.q, this.f42407f);
                            ItemData itemData = new ItemData();
                            itemData.parseProto(z);
                            this.s.L(itemData);
                            break;
                        }
                        break;
                    case 3:
                        landingType = TiePlusStat.LandingType.WECHAT;
                        break;
                    case 4:
                        landingType = TiePlusStat.LandingType.WECHAT_MINIAPP;
                        break;
                    case 5:
                        landingType = TiePlusStat.LandingType.MESSAGE;
                        break;
                    case 6:
                        landingType = TiePlusStat.LandingType.APPOINT;
                        break;
                }
            }
            k(this.r.z(), this.r.x(), TiePlusStat.StatType.EXPOSE, landingType, null, this.r.y(), this.r.getForumId(), this.r.w());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            j(true);
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
                } else if (intValue == 6) {
                    landingType = TiePlusStat.LandingType.APPOINT;
                } else if (intValue == 5) {
                    landingType = TiePlusStat.LandingType.MESSAGE;
                }
            }
            k(this.r.z(), this.r.x(), TiePlusStat.StatType.CLICK, landingType, null, this.r.y(), this.r.getForumId(), this.r.w());
        }
    }

    public void onSkinChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            c.a.q0.s.u.c.d(this.f42406e).n(R.string.J_X05);
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(this.f42408g);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0107);
            c.a.q0.s.u.c d4 = c.a.q0.s.u.c.d(this.f42409h);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0109);
            c.a.q0.s.u.c d5 = c.a.q0.s.u.c.d(this.f42410i);
            d5.A(R.string.F_X01);
            d5.v(R.color.CAM_X0109);
            c.a.q0.s.u.c d6 = c.a.q0.s.u.c.d(this.f42411j);
            d6.A(R.string.F_X01);
            d6.v(R.color.CAM_X0109);
            c.a.q0.s.u.c d7 = c.a.q0.s.u.c.d(this.f42412k);
            d7.A(R.string.F_X01);
            d7.v(R.color.CAM_X0109);
            c.a.q0.s.u.c d8 = c.a.q0.s.u.c.d(this.l);
            d8.A(R.string.F_X01);
            d8.v(R.color.CAM_X0109);
            c.a.q0.s.u.c.d(this.m).f(R.color.CAM_X0110);
            this.n.setBackgroundResource(R.drawable.icon_ad_dislike_arrow20_right_n);
            this.f42406e.setPlaceHolder(2);
            this.f42406e.setConrers(15);
        }
    }

    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f42407f.setCurProgress(-1);
            this.f42406e.reset();
            this.f42408g.setText("");
            this.f42409h.setText("");
            this.f42410i.setText("");
            this.f42411j.setText("");
            this.s.A();
            setOnClickListener(null);
            this.f42412k.setOnClickListener(null);
            this.l.setOnClickListener(null);
            this.f42407f.setOnClickListener(null);
            MessageManager.getInstance().unRegisterListener(this.s);
        }
    }

    public void updateCardView(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbRichTextTiebaPlusInfo) == null) {
            this.r = tbRichTextTiebaPlusInfo;
            if (tbRichTextTiebaPlusInfo != null && tbRichTextTiebaPlusInfo.z() != null) {
                TiebaPlusInfo z = this.r.z();
                if (36 == this.r.getType() && z != null) {
                    switch (z.jump_type.intValue()) {
                        case 1:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            h(z);
                            break;
                        case 2:
                            g(z);
                            break;
                    }
                }
                setOnClickListener(this);
                this.f42407f.setOnClickListener(new a(this));
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
        this.s = new TiePlusHelper(this.q);
        i();
    }
}
