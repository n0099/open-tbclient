package com.baidu.tbadk.widget.tiejia;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.s.r.e2;
import c.a.t0.u.o;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextTiebaPlusInfo;
import com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.yoga.YogaNodeJNIBase;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes12.dex */
public class TiebaPlusRecommendCard extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f41806e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressButton f41807f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41808g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f41809h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f41810i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f41811j;
    public TextView k;
    public TextView l;
    public View m;
    public View n;
    public View o;
    public View p;
    public final Context q;
    public TbRichTextTiebaPlusInfo r;
    public final TiePlusHelper s;
    public TiePlusDownloadDialog t;
    public boolean u;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f41812e;

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
            this.f41812e = tiebaPlusRecommendCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            int i2;
            TiePlusStat.LandingType landingType;
            TiePlusStat.CardBtnType cardBtnType;
            TiePlusStat.LandingType landingType2;
            TiePlusStat.CardBtnType cardBtnType2;
            TiePlusStat.RichTextType richTextType;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41812e.r == null || this.f41812e.r.z() == null) {
                return;
            }
            TiebaPlusInfo z = this.f41812e.r.z();
            if (z != null) {
                i2 = z.jump_type.intValue();
                str = z.app_package;
            } else {
                str = null;
                i2 = 0;
            }
            String str2 = (this.f41812e.r.x() == null || !this.f41812e.r.x().U2) ? "" : this.f41812e.r.x().V2;
            if (this.f41812e.r.getType() == 36) {
                switch (i2) {
                    case 1:
                        landingType2 = TiePlusStat.LandingType.H5;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f41812e.n(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 2:
                        landingType2 = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                        TiePlusStat.CardBtnType cardBtnType3 = TiePlusStat.CardBtnType.DOWNLOAD;
                        if (this.f41812e.u) {
                            richTextType = TiePlusStat.RichTextType.BIG_CARD;
                        } else {
                            richTextType = TiePlusStat.RichTextType.CARD;
                        }
                        this.f41812e.s.g(new o(TiePlusStat.StatType.DOWNLOAD_FINISHED, richTextType, this.f41812e.r.y(), str2, str));
                        if (this.f41812e.u) {
                            this.f41812e.s.onClick(view);
                        } else if (c.a.t0.b.d.N0()) {
                            this.f41812e.n(false);
                        } else {
                            this.f41812e.s.onClick(view);
                        }
                        cardBtnType = cardBtnType3;
                        landingType = landingType2;
                        break;
                    case 3:
                        landingType2 = TiePlusStat.LandingType.WECHAT;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f41812e.n(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 4:
                        landingType2 = TiePlusStat.LandingType.WECHAT_MINIAPP;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f41812e.n(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 5:
                        landingType2 = TiePlusStat.LandingType.MESSAGE;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f41812e.n(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 6:
                        landingType2 = TiePlusStat.LandingType.APPOINT;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f41812e.n(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 7:
                        landingType2 = TiePlusStat.LandingType.WECHAT_OFFICIAL;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.f41812e.n(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                }
                TiebaPlusRecommendCard tiebaPlusRecommendCard = this.f41812e;
                tiebaPlusRecommendCard.s(tiebaPlusRecommendCard.r.z(), this.f41812e.r.x(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.f41812e.r.y(), this.f41812e.r.getForumId(), this.f41812e.r.w());
            }
            landingType = null;
            cardBtnType = null;
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = this.f41812e;
            tiebaPlusRecommendCard2.s(tiebaPlusRecommendCard2.r.z(), this.f41812e.r.x(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.f41812e.r.y(), this.f41812e.r.getForumId(), this.f41812e.r.w());
        }
    }

    /* loaded from: classes12.dex */
    public class b implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f41813b;

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
            this.f41813b = tiebaPlusRecommendCard;
            this.a = tiebaPlusInfo;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                UtilHelper.showToast(this.f41813b.q, j.tip_order_fail);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) && j2 == c.a.d.f.m.b.g(this.a.item_id, 0L)) {
                TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder(this.a);
                builder.is_appoint = 1;
                TiebaPlusInfo build = builder.build(true);
                this.f41813b.r.B(build);
                this.f41813b.t(build);
                UtilHelper.showToast(this.f41813b.q, j.tip_order_successs);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements TiePlusDownloadDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f41814b;

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
            this.f41814b = tiebaPlusRecommendCard;
            this.a = str;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog.c
        public void a() {
            TiePlusStat.RichTextType richTextType;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f41814b.u) {
                    richTextType = TiePlusStat.RichTextType.BIG_CARD;
                } else {
                    richTextType = TiePlusStat.RichTextType.CARD;
                }
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, richTextType, this.f41814b.r.y(), this.f41814b.r.getForumId(), this.f41814b.r.w(), this.a);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41815e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TiebaPlusRecommendCard f41816f;

        public d(TiebaPlusRecommendCard tiebaPlusRecommendCard, String str) {
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
            this.f41816f = tiebaPlusRecommendCard;
            this.f41815e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int btnWidthSize;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (btnWidthSize = this.f41816f.f41807f.getBtnWidthSize(this.f41815e)) <= 0) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f41816f.f41807f.getLayoutParams();
            layoutParams.width = btnWidthSize;
            this.f41816f.f41807f.setLayoutParams(layoutParams);
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

    private String getButtonDescFromServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.r;
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.z() == null || StringUtils.isNull(this.r.z().button_desc)) {
                return null;
            }
            return this.r.z().button_desc;
        }
        return (String) invokeV.objValue;
    }

    public final void i(@NonNull TiebaPlusInfo tiebaPlusInfo) {
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
            this.f41808g.setMaxLines(1);
            if (StringUtils.isNull(tiebaPlusInfo.title)) {
                this.f41808g.setVisibility(8);
            } else {
                this.f41808g.setVisibility(0);
                this.f41808g.setText(tiebaPlusInfo.title);
            }
            if (!StringUtils.isNull(tiebaPlusInfo.app_icon)) {
                this.f41806e.startLoad(tiebaPlusInfo.app_icon, 10, false);
            }
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.f41809h.setVisibility(8);
            } else {
                this.f41809h.setVisibility(0);
                this.f41809h.setText(tiebaPlusInfo.desc);
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_version)) {
                this.f41810i.setVisibility(8);
            } else {
                this.f41810i.setVisibility(0);
                this.f41810i.setText(String.format(this.q.getString(j.app_version), tiebaPlusInfo.app_version));
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_company)) {
                this.f41811j.setVisibility(8);
            } else {
                this.f41811j.setVisibility(0);
                this.f41811j.setText(tiebaPlusInfo.app_company);
            }
            if (this.u) {
                this.f41810i.setVisibility(0);
                this.p.setVisibility(0);
            } else if (!c.a.t0.b.d.N0() && !c.a.t0.b.d.O0()) {
                this.f41810i.setVisibility(0);
                this.p.setVisibility(0);
            } else {
                this.f41810i.setVisibility(8);
                this.p.setVisibility(8);
            }
            if (this.u) {
                this.n.setVisibility(8);
                this.f41807f.setVisibility(0);
            } else if (c.a.t0.b.d.O0()) {
                this.n.setVisibility(0);
                this.f41807f.setVisibility(8);
            } else {
                this.n.setVisibility(8);
                this.f41807f.setVisibility(0);
            }
            if (this.o.getVisibility() != 8) {
                this.f41809h.requestLayout();
            }
            TiePlusHelper tiePlusHelper = this.s;
            tiePlusHelper.E(tiebaPlusInfo.app_id);
            tiePlusHelper.J(tiebaPlusInfo.download_url);
            tiePlusHelper.M(tiebaPlusInfo.app_package);
            tiePlusHelper.N(tiebaPlusInfo.app_power);
            tiePlusHelper.O(tiebaPlusInfo.app_privacy);
            tiePlusHelper.f(this.f41807f);
            this.k.setOnClickListener(this.s);
            this.l.setOnClickListener(this.s);
            Context context = this.q;
            if (!(context instanceof TbPageContextSupport) || (pageContext = ((TbPageContextSupport) context).getPageContext()) == null) {
                return;
            }
            pageContext.registerListener(this.s);
        }
    }

    public final void j(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tiebaPlusInfo) == null) {
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.f41808g.setMaxLines(2);
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.f41808g.setText("");
            } else {
                this.f41808g.setText(tiebaPlusInfo.desc);
            }
            if (!StringUtils.isNull(tiebaPlusInfo.app_icon)) {
                this.f41806e.startLoad(tiebaPlusInfo.app_icon, 10, false);
            }
            if (tiebaPlusInfo.jump_type.intValue() == 6) {
                t(tiebaPlusInfo);
                this.n.setVisibility(8);
                this.f41807f.setVisibility(0);
            } else if (tiebaPlusInfo.jump_type.intValue() == 5) {
                this.n.setVisibility(0);
                this.f41807f.setVisibility(8);
            } else if (tiebaPlusInfo.jump_type.intValue() != 7 && tiebaPlusInfo.jump_type.intValue() != 3) {
                this.f41807f.setTag(null);
                this.f41807f.setText(this.q.getString(j.view));
                this.f41807f.enableText();
                if (c.a.t0.b.d.P0()) {
                    this.n.setVisibility(8);
                    this.f41807f.setVisibility(0);
                } else {
                    this.n.setVisibility(0);
                    this.f41807f.setVisibility(8);
                }
            } else if (c.a.t0.b.d.P0()) {
                this.n.setVisibility(8);
                this.f41807f.setTag(null);
                this.f41807f.setText(this.q.getString(j.attention));
                this.f41807f.enableText();
                this.f41807f.setVisibility(0);
            } else {
                this.n.setVisibility(0);
                this.f41807f.setVisibility(8);
            }
            this.f41807f.setOnClickListener(this);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeAllViews();
            if (this.u) {
                LayoutInflater.from(getContext()).inflate(h.tiejia_recommend_big_card, (ViewGroup) this, true);
            } else {
                LayoutInflater.from(getContext()).inflate(h.tiejia_recommend_card, (ViewGroup) this, true);
            }
            this.f41806e = (TbImageView) findViewById(g.tiejia_card_icon);
            o();
            ProgressButton progressButton = (ProgressButton) findViewById(g.tiejia_card_download);
            this.f41807f = progressButton;
            progressButton.setUseLongText(false);
            r();
            q();
            this.f41808g = (TextView) findViewById(g.tiejia_card_title);
            this.f41809h = (TextView) findViewById(g.tiejia_card_desc);
            this.f41810i = (TextView) findViewById(g.tiejia_card_version);
            this.f41811j = (TextView) findViewById(g.tiejia_card_company);
            this.k = (TextView) findViewById(g.tiejia_card_privacy);
            this.l = (TextView) findViewById(g.tiejia_card_permission);
            this.m = findViewById(g.tiejia_divider);
            this.n = findViewById(g.tiejia_card_arrow);
            this.o = findViewById(g.tiejia_card_line2);
            this.p = findViewById(g.tiejia_card_line3);
            this.k.setTag(Byte.valueOf((byte) YogaNodeJNIBase.HAS_NEW_LAYOUT));
            this.l.setTag((byte) 17);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            if (this.u) {
                setPadding(0, 0, 0, 0);
            } else {
                setPadding(n.f(getContext(), e.M_W_X003), n.f(getContext(), e.M_H_X002), n.f(getContext(), e.tbds0), n.f(getContext(), e.M_H_X002));
            }
            onSkinChanged();
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo;
        PluginUser pluginUser;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (c.a.t0.b.d.v0() && (tbRichTextTiebaPlusInfo = this.r) != null && tbRichTextTiebaPlusInfo.z() != null) {
                TiebaPlusInfo z = this.r.z();
                if (z.jump_type.intValue() == 2 && (pluginUser = z.plugin_user) != null && pluginUser.is_download_card_whiteuser.intValue() == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ void m() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f41806e.getLayoutParams();
        layoutParams.height = (this.f41806e.getWidth() * 567) / 1009;
        this.f41806e.setLayoutParams(layoutParams);
    }

    public final void n(boolean z) {
        TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (tbRichTextTiebaPlusInfo = this.r) == null || tbRichTextTiebaPlusInfo.z() == null) {
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
                this.s.I(this.t);
                ItemData itemData = new ItemData();
                itemData.parseProto(z2);
                this.s.L(itemData);
                this.t.setAppCompany(z2.app_company).setAppIcon(z2.app_icon).setAppTitle(z2.title).setAppVersion(z2.app_version).setDownloadClickCallback(new c(this, str2));
                this.t.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, this.u ? TiePlusStat.RichTextType.BIG_CARD : TiePlusStat.RichTextType.CARD, this.r.y(), this.r.getForumId(), this.r.w(), str2);
            } else if (intValue == 1) {
                this.s.l(z2.jump_url, 1, "", z2.h5_jump_type.intValue());
            } else if (intValue == 3) {
                this.s.T(z2, TiePlusStat.RichTextType.CARD, this.r.y());
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
                    UtilHelper.showToast(this.q, j.tip_order_completed);
                }
            } else if (intValue != 5) {
                if (intValue == 7) {
                    if (z2.jump_setting.intValue() == 1) {
                        this.s.U(z2, TiePlusStat.RichTextType.CARD, this.r.y());
                    } else {
                        this.s.T(z2, TiePlusStat.RichTextType.CARD, this.r.y());
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

    public final void o() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.u && (tbImageView = this.f41806e) != null) {
            tbImageView.post(new Runnable() { // from class: c.a.t0.f1.p.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TiebaPlusRecommendCard.this.m();
                    }
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.r;
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.z() == null) {
                return;
            }
            this.s.f(this.f41807f);
            this.s.I(this.t);
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
                            this.s.Y(z.app_package, z.app_id, this.q, this.f41807f);
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
                    case 7:
                        landingType = TiePlusStat.LandingType.WECHAT_OFFICIAL;
                        break;
                }
            }
            s(this.r.z(), this.r.x(), TiePlusStat.StatType.EXPOSE, landingType, null, this.r.y(), this.r.getForumId(), this.r.w());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            n(true);
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
            s(this.r.z(), this.r.x(), TiePlusStat.StatType.CLICK, landingType, null, this.r.y(), this.r.getForumId(), this.r.w());
        }
    }

    public void onSkinChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this);
            d2.n(j.J_X05);
            d2.f(c.a.u0.a4.d.CAM_X0206);
            TbImageView tbImageView = this.f41806e;
            if (tbImageView != null) {
                if (this.u) {
                    p();
                } else {
                    c.a.t0.s.v.c.d(tbImageView).n(j.J_X05);
                    this.f41806e.setConrers(15);
                    this.f41806e.setPlaceHolder(2);
                }
            }
            TextView textView = this.f41808g;
            if (textView != null) {
                c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(textView);
                d3.A(j.F_X01);
                d3.v(c.a.u0.a4.d.CAM_X0107);
            }
            TextView textView2 = this.f41809h;
            if (textView2 != null) {
                c.a.t0.s.v.c d4 = c.a.t0.s.v.c.d(textView2);
                d4.A(j.F_X01);
                d4.v(c.a.u0.a4.d.CAM_X0109);
            }
            TextView textView3 = this.f41810i;
            if (textView3 != null) {
                c.a.t0.s.v.c d5 = c.a.t0.s.v.c.d(textView3);
                d5.A(j.F_X01);
                d5.v(c.a.u0.a4.d.CAM_X0109);
            }
            TextView textView4 = this.f41811j;
            if (textView4 != null) {
                c.a.t0.s.v.c d6 = c.a.t0.s.v.c.d(textView4);
                d6.A(j.F_X01);
                d6.v(c.a.u0.a4.d.CAM_X0109);
            }
            TextView textView5 = this.k;
            if (textView5 != null) {
                c.a.t0.s.v.c d7 = c.a.t0.s.v.c.d(textView5);
                d7.A(j.F_X01);
                d7.v(c.a.u0.a4.d.CAM_X0109);
            }
            TextView textView6 = this.l;
            if (textView6 != null) {
                c.a.t0.s.v.c d8 = c.a.t0.s.v.c.d(textView6);
                d8.A(j.F_X01);
                d8.v(c.a.u0.a4.d.CAM_X0109);
            }
            View view = this.m;
            if (view != null) {
                c.a.t0.s.v.c.d(view).f(c.a.u0.a4.d.CAM_X0110);
            }
            View view2 = this.n;
            if (view2 != null) {
                view2.setBackgroundResource(f.icon_ad_dislike_arrow20_right_n);
            }
        }
    }

    public final void p() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.u && (tbImageView = this.f41806e) != null) {
            tbImageView.setDrawCorner(true);
            this.f41806e.setDefaultBgResource(f.tiejia_big_card_default);
            this.f41806e.setRadiusById(j.J_X05);
            this.f41806e.setConrers(3);
            this.f41806e.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.tbds1));
            this.f41806e.setBorderColor(SkinManager.getColor(c.a.u0.a4.d.CAM_X0401));
            this.f41806e.setBorderSurroundContent(true);
            this.f41806e.setDrawBorder(true);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String buttonDescFromServer = getButtonDescFromServer();
            if (this.f41807f == null || StringUtils.isNull(buttonDescFromServer)) {
                return;
            }
            this.f41807f.post(new d(this, buttonDescFromServer));
        }
    }

    public final void r() {
        TiePlusHelper tiePlusHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || StringUtils.isNull(getButtonDescFromServer()) || (tiePlusHelper = this.s) == null) {
            return;
        }
        tiePlusHelper.H(this.r.z().button_desc);
    }

    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f41807f.setCurProgress(-1);
            this.f41806e.reset();
            this.f41808g.setText("");
            this.f41809h.setText("");
            this.f41810i.setText("");
            this.f41811j.setText("");
            this.s.C();
            setOnClickListener(null);
            this.k.setOnClickListener(null);
            this.l.setOnClickListener(null);
            this.f41807f.setOnClickListener(null);
            MessageManager.getInstance().unRegisterListener(this.s);
        }
    }

    public final void s(TiebaPlusInfo tiebaPlusInfo, e2 e2Var, TiePlusStat.StatType statType, TiePlusStat.LandingType landingType, TiePlusStat.CardBtnType cardBtnType, String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{tiebaPlusInfo, e2Var, statType, landingType, cardBtnType, str, str2, str3}) == null) || tiebaPlusInfo == null || e2Var == null) {
            return;
        }
        int a2 = TiePlusStat.a(tiebaPlusInfo, this);
        if (e2Var.U2) {
            str4 = e2Var.V2;
            str5 = e2Var.W2;
            str6 = e2Var.X2;
        } else {
            str4 = "";
            str5 = str4;
            str6 = str5;
        }
        TiePlusStat.b(a2, statType, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, this.u ? TiePlusStat.RichTextType.BIG_CARD : TiePlusStat.RichTextType.CARD, tiebaPlusInfo.target_type.intValue(), landingType, str, str2, str3, str4, cardBtnType);
        TiePlusStat.c(a2, statType, TiePlusStat.Locate.PB, str4, str5, str6, e2Var.L2);
    }

    public final void t(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, tiebaPlusInfo) == null) && tiebaPlusInfo != null && tiebaPlusInfo.jump_type.intValue() == 6) {
            if (StringUtils.isNull(tiebaPlusInfo.title)) {
                this.f41808g.setText("");
            } else {
                this.f41808g.setText(tiebaPlusInfo.title);
            }
            this.f41810i.setVisibility(8);
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.o.setVisibility(8);
                this.f41809h.setVisibility(8);
            } else {
                this.o.setVisibility(0);
                this.f41809h.setVisibility(0);
                this.f41809h.setText(tiebaPlusInfo.desc);
            }
            if (tiebaPlusInfo.is_appoint.intValue() == 1) {
                this.f41807f.setText(this.q.getString(j.item_order_complete));
                this.f41807f.disableText();
                return;
            }
            this.s.A();
            this.f41807f.setText(this.q.getString(j.item_order));
            this.f41807f.enableText();
            this.s.G(new b(this, tiebaPlusInfo));
        }
    }

    public void updateCardView(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tbRichTextTiebaPlusInfo) == null) {
            this.r = tbRichTextTiebaPlusInfo;
            if (tbRichTextTiebaPlusInfo != null && tbRichTextTiebaPlusInfo.z() != null) {
                this.u = l();
                k();
                TiebaPlusInfo z = this.r.z();
                if (36 == this.r.getType() && z != null) {
                    switch (z.jump_type.intValue()) {
                        case 1:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            j(z);
                            break;
                        case 2:
                            i(z);
                            break;
                    }
                }
                setOnClickListener(this);
                this.f41807f.setOnClickListener(new a(this));
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
    }
}
