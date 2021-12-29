package com.baidu.tbadk.widget.tiejia;

import android.app.Activity;
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
import c.a.d.f.p.n;
import c.a.s0.b.d;
import c.a.s0.s.q.d2;
import c.a.s0.u.o;
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
/* loaded from: classes11.dex */
public class TiebaPlusRecommendCard extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f43085e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressButton f43086f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f43087g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f43088h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f43089i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f43090j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f43091k;
    public TextView l;
    public View m;
    public View n;
    public View o;
    public View p;
    public final Context q;
    public TbRichTextTiebaPlusInfo r;
    public final TiePlusHelper s;
    public TiePlusDownloadDialog t;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f43092e;

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
            this.f43092e = tiebaPlusRecommendCard;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f43092e.r == null || this.f43092e.r.z() == null) {
                return;
            }
            TiebaPlusInfo z = this.f43092e.r.z();
            if (z != null) {
                i2 = z.jump_type.intValue();
                str = z.app_package;
            } else {
                str = null;
                i2 = 0;
            }
            String str2 = (this.f43092e.r.x() == null || !this.f43092e.r.x().V2) ? "" : this.f43092e.r.x().W2;
            if (this.f43092e.r.getType() == 36) {
                switch (i2) {
                    case 1:
                        landingType2 = TiePlusStat.LandingType.H5;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f43092e.j(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 2:
                        landingType2 = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                        TiePlusStat.CardBtnType cardBtnType3 = TiePlusStat.CardBtnType.DOWNLOAD;
                        this.f43092e.s.g(new o(TiePlusStat.StatType.DOWNLOAD_FINISHED, TiePlusStat.RichTextType.CARD, this.f43092e.r.y(), str2, str));
                        if (d.y0()) {
                            this.f43092e.j(false);
                        } else {
                            this.f43092e.s.onClick(view);
                        }
                        cardBtnType = cardBtnType3;
                        landingType = landingType2;
                        break;
                    case 3:
                        landingType2 = TiePlusStat.LandingType.WECHAT;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f43092e.j(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 4:
                        landingType2 = TiePlusStat.LandingType.WECHAT_MINIAPP;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f43092e.j(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 5:
                        landingType2 = TiePlusStat.LandingType.MESSAGE;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f43092e.j(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 6:
                        landingType2 = TiePlusStat.LandingType.APPOINT;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f43092e.j(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 7:
                        landingType2 = TiePlusStat.LandingType.WECHAT_OFFICIAL;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f43092e.j(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                }
                TiebaPlusRecommendCard tiebaPlusRecommendCard = this.f43092e;
                tiebaPlusRecommendCard.k(tiebaPlusRecommendCard.r.z(), this.f43092e.r.x(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.f43092e.r.y(), this.f43092e.r.getForumId(), this.f43092e.r.w());
            }
            landingType = null;
            cardBtnType = null;
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = this.f43092e;
            tiebaPlusRecommendCard2.k(tiebaPlusRecommendCard2.r.z(), this.f43092e.r.x(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.f43092e.r.y(), this.f43092e.r.getForumId(), this.f43092e.r.w());
        }
    }

    /* loaded from: classes11.dex */
    public class b implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f43093b;

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
            this.f43093b = tiebaPlusRecommendCard;
            this.a = tiebaPlusInfo;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) && j2 == c.a.d.f.m.b.g(this.a.item_id, 0L)) {
                TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder(this.a);
                builder.is_appoint = 1;
                TiebaPlusInfo build = builder.build(true);
                this.f43093b.r.B(build);
                this.f43093b.l(build);
                UtilHelper.showToast(this.f43093b.q, R.string.tip_order_successs);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                UtilHelper.showToast(this.f43093b.q, R.string.tip_order_fail);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements TiePlusDownloadDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f43094b;

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
            this.f43094b = tiebaPlusRecommendCard;
            this.a = str;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, this.f43094b.r.y(), this.f43094b.r.getForumId(), this.f43094b.r.w(), this.a);
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
            this.f43087g.setMaxLines(1);
            if (StringUtils.isNull(tiebaPlusInfo.title)) {
                this.f43087g.setVisibility(8);
            } else {
                this.f43087g.setVisibility(0);
                this.f43087g.setText(tiebaPlusInfo.title);
            }
            if (!StringUtils.isNull(tiebaPlusInfo.app_icon)) {
                this.f43085e.startLoad(tiebaPlusInfo.app_icon, 10, false);
            }
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.f43088h.setVisibility(8);
            } else {
                this.f43088h.setVisibility(0);
                this.f43088h.setText(tiebaPlusInfo.desc);
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_version)) {
                this.f43089i.setVisibility(8);
            } else {
                this.f43089i.setVisibility(0);
                this.f43089i.setText(String.format(this.q.getString(R.string.app_version), tiebaPlusInfo.app_version));
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_company)) {
                this.f43090j.setVisibility(8);
            } else {
                this.f43090j.setVisibility(0);
                this.f43090j.setText(tiebaPlusInfo.app_company);
            }
            if (!d.y0() && !d.z0()) {
                this.f43089i.setVisibility(0);
                this.p.setVisibility(0);
            } else {
                this.f43089i.setVisibility(8);
                this.p.setVisibility(8);
            }
            if (d.z0()) {
                this.n.setVisibility(0);
                this.f43086f.setVisibility(8);
            } else {
                this.n.setVisibility(8);
                this.f43086f.setVisibility(0);
            }
            if (this.o.getVisibility() != 8) {
                this.f43088h.requestLayout();
            }
            TiePlusHelper tiePlusHelper = this.s;
            tiePlusHelper.E(tiebaPlusInfo.app_id);
            tiePlusHelper.I(tiebaPlusInfo.download_url);
            tiePlusHelper.L(tiebaPlusInfo.app_package);
            tiePlusHelper.M(tiebaPlusInfo.app_power);
            tiePlusHelper.N(tiebaPlusInfo.app_privacy);
            tiePlusHelper.f(this.f43086f);
            this.f43091k.setOnClickListener(this.s);
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
            this.f43087g.setMaxLines(2);
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.f43087g.setText("");
            } else {
                this.f43087g.setText(tiebaPlusInfo.desc);
            }
            if (!StringUtils.isNull(tiebaPlusInfo.app_icon)) {
                this.f43085e.startLoad(tiebaPlusInfo.app_icon, 10, false);
            }
            if (tiebaPlusInfo.jump_type.intValue() == 6) {
                l(tiebaPlusInfo);
                this.n.setVisibility(8);
                this.f43086f.setVisibility(0);
            } else if (tiebaPlusInfo.jump_type.intValue() == 5) {
                this.n.setVisibility(0);
                this.f43086f.setVisibility(8);
            } else if (tiebaPlusInfo.jump_type.intValue() == 7) {
                this.n.setVisibility(0);
                this.f43086f.setVisibility(8);
            } else {
                this.f43086f.setTag(null);
                this.f43086f.setText(this.q.getString(R.string.view));
                this.f43086f.enableText();
                if (d.A0()) {
                    this.n.setVisibility(8);
                    this.f43086f.setVisibility(0);
                } else {
                    this.n.setVisibility(0);
                    this.f43086f.setVisibility(8);
                }
            }
            this.f43086f.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.tiejia_recommend_card, (ViewGroup) this, true);
            this.f43085e = (TbImageView) findViewById(R.id.tiejia_card_icon);
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.tiejia_card_download);
            this.f43086f = progressButton;
            progressButton.setUseLongText(false);
            this.f43087g = (TextView) findViewById(R.id.tiejia_card_title);
            this.f43088h = (TextView) findViewById(R.id.tiejia_card_desc);
            this.f43089i = (TextView) findViewById(R.id.tiejia_card_version);
            this.f43090j = (TextView) findViewById(R.id.tiejia_card_company);
            this.f43091k = (TextView) findViewById(R.id.tiejia_card_privacy);
            this.l = (TextView) findViewById(R.id.tiejia_card_permission);
            this.m = findViewById(R.id.tiejia_divider);
            this.n = findViewById(R.id.tiejia_card_arrow);
            this.o = findViewById(R.id.tiejia_card_line2);
            this.p = findViewById(R.id.tiejia_card_line3);
            this.f43091k.setTag(Byte.valueOf((byte) YogaNodeJNIBase.HAS_NEW_LAYOUT));
            this.l.setTag((byte) 17);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            setPadding(n.f(getContext(), R.dimen.M_W_X003), n.f(getContext(), R.dimen.M_H_X002), n.f(getContext(), R.dimen.tbds0), n.f(getContext(), R.dimen.M_H_X002));
            onSkinChanged();
        }
    }

    public final void j(boolean z) {
        TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (tbRichTextTiebaPlusInfo = this.r) == null || tbRichTextTiebaPlusInfo.z() == null) {
            return;
        }
        TiebaPlusInfo z2 = this.r.z();
        if (this.r.getType() == 36) {
            int intValue = z2.jump_type.intValue();
            String str = "";
            if (intValue == 2) {
                if (this.r.x() != null && this.r.x().V2) {
                    str = this.r.x().W2;
                }
                String str2 = str;
                if (this.t == null) {
                    this.t = new TiePlusDownloadDialog(this.q, this.s, false);
                }
                this.s.H(this.t);
                ItemData itemData = new ItemData();
                itemData.parseProto(z2);
                this.s.K(itemData);
                this.t.setAppCompany(z2.app_company).setAppIcon(z2.app_icon).setAppTitle(z2.title).setAppVersion(z2.app_version).setDownloadClickCallback(new c(this, str2));
                this.t.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, this.r.y(), this.r.getForumId(), this.r.w(), str2);
            } else if (intValue == 1) {
                this.s.l(z2.jump_url, 1, "", z2.h5_jump_type.intValue());
            } else if (intValue == 3) {
                this.s.S(z2, TiePlusStat.RichTextType.CARD, this.r.y());
            } else if (intValue == 4) {
                this.s.l(z2.h5_jump_number, intValue, z2.h5_jump_param, 0);
            } else if (intValue == 6) {
                if (z) {
                    if (StringUtils.isNull(z2.forum_name)) {
                        return;
                    }
                    ItemClickJumpUtil.itemClickJump(z2.forum_name, z2.item_id, 9, 9);
                } else if (z2.is_appoint.intValue() != 1) {
                    this.s.D(c.a.d.f.m.b.g(z2.item_id, 0L), z2.title, null);
                } else {
                    UtilHelper.showToast(this.q, R.string.tip_order_completed);
                }
            } else if (intValue != 5) {
                if (intValue == 7) {
                    if (z2.jump_setting.intValue() == 1) {
                        this.s.T(z2, TiePlusStat.RichTextType.CARD, this.r.y());
                    } else {
                        this.s.S(z2, TiePlusStat.RichTextType.CARD, this.r.y());
                    }
                }
            } else {
                PluginUser pluginUser = z2.plugin_user;
                if (pluginUser != null) {
                    Context context = this.q;
                    if (context instanceof Activity) {
                        TiePlusHelper.u((Activity) context, pluginUser);
                    }
                }
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
            if (d2Var.V2) {
                str4 = d2Var.W2;
                str5 = d2Var.X2;
                str6 = d2Var.Y2;
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
            if (StringUtils.isNull(tiebaPlusInfo.title)) {
                this.f43087g.setText("");
            } else {
                this.f43087g.setText(tiebaPlusInfo.title);
            }
            this.f43089i.setVisibility(8);
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.o.setVisibility(8);
                this.f43088h.setVisibility(8);
            } else {
                this.o.setVisibility(0);
                this.f43088h.setVisibility(0);
                this.f43088h.setText(tiebaPlusInfo.desc);
            }
            if (tiebaPlusInfo.is_appoint.intValue() == 1) {
                this.f43086f.setText(this.q.getString(R.string.item_order_complete));
                this.f43086f.disableText();
                return;
            }
            this.s.A();
            this.f43086f.setText(this.q.getString(R.string.item_order));
            this.f43086f.enableText();
            this.s.G(new b(this, tiebaPlusInfo));
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
            this.s.f(this.f43086f);
            this.s.H(this.t);
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
                            this.s.X(z.app_package, z.app_id, this.q, this.f43086f);
                            ItemData itemData = new ItemData();
                            itemData.parseProto(z);
                            this.s.K(itemData);
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
                    case 7:
                        landingType = TiePlusStat.LandingType.WECHAT_OFFICIAL;
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
                } else if (intValue == 7) {
                    landingType = TiePlusStat.LandingType.WECHAT_OFFICIAL;
                }
            }
            k(this.r.z(), this.r.x(), TiePlusStat.StatType.CLICK, landingType, null, this.r.y(), this.r.getForumId(), this.r.w());
        }
    }

    public void onSkinChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            c.a.s0.s.u.c.d(this.f43085e).n(R.string.J_X05);
            c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(this.f43087g);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0107);
            c.a.s0.s.u.c d4 = c.a.s0.s.u.c.d(this.f43088h);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0109);
            c.a.s0.s.u.c d5 = c.a.s0.s.u.c.d(this.f43089i);
            d5.A(R.string.F_X01);
            d5.v(R.color.CAM_X0109);
            c.a.s0.s.u.c d6 = c.a.s0.s.u.c.d(this.f43090j);
            d6.A(R.string.F_X01);
            d6.v(R.color.CAM_X0109);
            c.a.s0.s.u.c d7 = c.a.s0.s.u.c.d(this.f43091k);
            d7.A(R.string.F_X01);
            d7.v(R.color.CAM_X0109);
            c.a.s0.s.u.c d8 = c.a.s0.s.u.c.d(this.l);
            d8.A(R.string.F_X01);
            d8.v(R.color.CAM_X0109);
            c.a.s0.s.u.c.d(this.m).f(R.color.CAM_X0110);
            this.n.setBackgroundResource(R.drawable.icon_ad_dislike_arrow20_right_n);
            this.f43085e.setPlaceHolder(2);
            this.f43085e.setConrers(15);
        }
    }

    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f43086f.setCurProgress(-1);
            this.f43085e.reset();
            this.f43087g.setText("");
            this.f43088h.setText("");
            this.f43089i.setText("");
            this.f43090j.setText("");
            this.s.C();
            setOnClickListener(null);
            this.f43091k.setOnClickListener(null);
            this.l.setOnClickListener(null);
            this.f43086f.setOnClickListener(null);
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
                        case 7:
                            h(z);
                            break;
                        case 2:
                            g(z);
                            break;
                    }
                }
                setOnClickListener(this);
                this.f43086f.setOnClickListener(new a(this));
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
