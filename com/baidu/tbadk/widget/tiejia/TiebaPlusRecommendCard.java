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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextTiebaPlusInfo;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.yoga.YogaNodeJNIBase;
import com.repackage.fz4;
import com.repackage.jg;
import com.repackage.li;
import com.repackage.wq4;
import com.repackage.ze5;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes3.dex */
public class TiebaPlusRecommendCard extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public ProgressButton b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public View i;
    public View j;
    public View k;
    public View l;
    public final Context m;
    public TbRichTextTiebaPlusInfo n;
    public final TiePlusHelper o;
    public ze5 p;
    public boolean q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusRecommendCard a;

        public a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaPlusRecommendCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tiebaPlusRecommendCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            int i;
            TiePlusStat.LandingType landingType;
            TiePlusStat.CardBtnType cardBtnType;
            TiePlusStat.LandingType landingType2;
            TiePlusStat.CardBtnType cardBtnType2;
            TiePlusStat.RichTextType richTextType;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.n == null || this.a.n.A() == null) {
                return;
            }
            TiebaPlusInfo A = this.a.n.A();
            if (A != null) {
                i = A.jump_type.intValue();
                str = A.app_package;
            } else {
                str = null;
                i = 0;
            }
            String str2 = (this.a.n.getThreadData() == null || !this.a.n.getThreadData().isTiebaPlusAdThread) ? "" : this.a.n.getThreadData().tiebaPlusOrderId;
            if (this.a.n.getType() == 36) {
                switch (i) {
                    case 1:
                        landingType2 = TiePlusStat.LandingType.H5;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.a.n(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 2:
                        landingType2 = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                        TiePlusStat.CardBtnType cardBtnType3 = TiePlusStat.CardBtnType.DOWNLOAD;
                        if (this.a.q) {
                            richTextType = TiePlusStat.RichTextType.BIG_CARD;
                        } else {
                            richTextType = TiePlusStat.RichTextType.CARD;
                        }
                        this.a.o.g(new fz4(TiePlusStat.StatType.DOWNLOAD_FINISHED, richTextType, this.a.n.z(), str2, str));
                        if (this.a.q) {
                            this.a.o.onClick(view2);
                        } else if (UbsABTestHelper.tiebaPlusDownloadTestA()) {
                            this.a.n(false);
                        } else {
                            this.a.o.onClick(view2);
                        }
                        cardBtnType = cardBtnType3;
                        landingType = landingType2;
                        break;
                    case 3:
                        landingType2 = TiePlusStat.LandingType.WECHAT;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.a.n(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 4:
                        landingType2 = TiePlusStat.LandingType.WECHAT_MINIAPP;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.a.n(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 5:
                        landingType2 = TiePlusStat.LandingType.MESSAGE;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.a.n(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 6:
                        landingType2 = TiePlusStat.LandingType.APPOINT;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.a.n(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                    case 7:
                        landingType2 = TiePlusStat.LandingType.WECHAT_OFFICIAL;
                        cardBtnType2 = TiePlusStat.CardBtnType.H5;
                        this.a.n(false);
                        cardBtnType = cardBtnType2;
                        landingType = landingType2;
                        break;
                }
                TiebaPlusRecommendCard tiebaPlusRecommendCard = this.a;
                tiebaPlusRecommendCard.v(tiebaPlusRecommendCard.n.A(), this.a.n.getThreadData(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.a.n.z(), this.a.n.getForumId(), this.a.n.y());
            }
            landingType = null;
            cardBtnType = null;
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = this.a;
            tiebaPlusRecommendCard2.v(tiebaPlusRecommendCard2.n.A(), this.a.n.getThreadData(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.a.n.z(), this.a.n.getForumId(), this.a.n.y());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;
        public final /* synthetic */ TiebaPlusRecommendCard b;

        public b(TiebaPlusRecommendCard tiebaPlusRecommendCard, TiebaPlusInfo tiebaPlusInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaPlusRecommendCard, tiebaPlusInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tiebaPlusRecommendCard;
            this.a = tiebaPlusInfo;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                UtilHelper.showToast(this.b.m, (int) R.string.obfuscated_res_0x7f0f1419);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && j == jg.g(this.a.item_id, 0L)) {
                TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder(this.a);
                builder.is_appoint = 1;
                TiebaPlusInfo build = builder.build(true);
                this.b.n.B(build);
                this.b.w(build);
                UtilHelper.showToast(this.b.m, (int) R.string.obfuscated_res_0x7f0f141a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ze5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ TiebaPlusRecommendCard b;

        public c(TiebaPlusRecommendCard tiebaPlusRecommendCard, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaPlusRecommendCard, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tiebaPlusRecommendCard;
            this.a = str;
        }

        @Override // com.repackage.ze5.c
        public void a() {
            TiePlusStat.RichTextType richTextType;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.q) {
                    richTextType = TiePlusStat.RichTextType.BIG_CARD;
                } else {
                    richTextType = TiePlusStat.RichTextType.CARD;
                }
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, richTextType, this.b.n.z(), this.b.n.getForumId(), this.b.n.y(), this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ TiebaPlusRecommendCard b;

        public d(TiebaPlusRecommendCard tiebaPlusRecommendCard, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaPlusRecommendCard, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tiebaPlusRecommendCard;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int f;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (f = this.b.b.f(this.a)) <= 0) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.b.getLayoutParams();
            layoutParams.width = f;
            this.b.b.setLayoutParams(layoutParams);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.n;
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.A() == null || StringUtils.isNull(this.n.A().button_desc)) {
                return null;
            }
            return this.n.A().button_desc;
        }
        return (String) invokeV.objValue;
    }

    public final void i(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        TbPageContext pageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tiebaPlusInfo) == null) {
            if (StringUtils.isNull(tiebaPlusInfo.desc) && StringUtils.isNull(tiebaPlusInfo.app_version)) {
                this.k.setVisibility(8);
            } else {
                this.k.setVisibility(0);
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_company) && StringUtils.isNull(tiebaPlusInfo.app_privacy) && StringUtils.isNull(tiebaPlusInfo.app_power)) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
            }
            this.c.setMaxLines(1);
            if (StringUtils.isNull(tiebaPlusInfo.title)) {
                this.c.setVisibility(8);
            } else {
                this.c.setVisibility(0);
                this.c.setText(tiebaPlusInfo.title);
            }
            if (!StringUtils.isNull(tiebaPlusInfo.app_icon)) {
                this.a.K(tiebaPlusInfo.app_icon, 10, false);
            }
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
                this.d.setText(tiebaPlusInfo.desc);
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_version)) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                this.e.setText(String.format(this.m.getString(R.string.obfuscated_res_0x7f0f0294), tiebaPlusInfo.app_version));
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_company)) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                this.f.setText(tiebaPlusInfo.app_company);
            }
            if (this.q) {
                this.e.setVisibility(0);
                this.l.setVisibility(0);
            } else if (!UbsABTestHelper.tiebaPlusDownloadTestA() && !UbsABTestHelper.tiebaPlusDownloadTestB()) {
                this.e.setVisibility(0);
                this.l.setVisibility(0);
            } else {
                this.e.setVisibility(8);
                this.l.setVisibility(8);
            }
            if (this.q) {
                this.j.setVisibility(8);
                this.b.setVisibility(0);
            } else if (UbsABTestHelper.tiebaPlusDownloadTestB()) {
                this.j.setVisibility(0);
                this.b.setVisibility(8);
            } else {
                this.j.setVisibility(8);
                this.b.setVisibility(0);
            }
            if (this.k.getVisibility() != 8) {
                this.d.requestLayout();
            }
            TiePlusHelper tiePlusHelper = this.o;
            tiePlusHelper.F(tiebaPlusInfo.app_id);
            tiePlusHelper.K(tiebaPlusInfo.download_url);
            tiePlusHelper.N(tiebaPlusInfo.app_package);
            tiePlusHelper.O(tiebaPlusInfo.app_power);
            tiePlusHelper.P(tiebaPlusInfo.app_privacy);
            tiePlusHelper.f(this.b);
            this.g.setOnClickListener(this.o);
            this.h.setOnClickListener(this.o);
            Context context = this.m;
            if (!(context instanceof TbPageContextSupport) || (pageContext = ((TbPageContextSupport) context).getPageContext()) == null) {
                return;
            }
            pageContext.registerListener(this.o);
        }
    }

    public final void j(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tiebaPlusInfo) == null) {
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.c.setMaxLines(2);
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.c.setText("");
            } else {
                this.c.setText(tiebaPlusInfo.desc);
            }
            if (!StringUtils.isNull(tiebaPlusInfo.app_icon)) {
                this.a.K(tiebaPlusInfo.app_icon, 10, false);
            }
            if (tiebaPlusInfo.jump_type.intValue() == 6) {
                w(tiebaPlusInfo);
                this.j.setVisibility(8);
                this.b.setVisibility(0);
            } else if (tiebaPlusInfo.jump_type.intValue() == 5) {
                this.j.setVisibility(0);
                this.b.setVisibility(8);
            } else if (tiebaPlusInfo.jump_type.intValue() != 7 && tiebaPlusInfo.jump_type.intValue() != 3) {
                this.b.setTag(null);
                this.b.setText(this.m.getString(R.string.obfuscated_res_0x7f0f1545));
                this.b.e();
                if (UbsABTestHelper.tiebaPlusLinkTestA()) {
                    this.j.setVisibility(8);
                    this.b.setVisibility(0);
                } else {
                    this.j.setVisibility(0);
                    this.b.setVisibility(8);
                }
            } else if (UbsABTestHelper.tiebaPlusLinkTestA()) {
                this.j.setVisibility(8);
                this.b.setTag(null);
                this.b.setText(this.m.getString(R.string.obfuscated_res_0x7f0f02a4));
                this.b.e();
                this.b.setVisibility(0);
            } else {
                this.j.setVisibility(0);
                this.b.setVisibility(8);
            }
            this.b.setOnClickListener(this);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeAllViews();
            if (this.q) {
                LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d081e, (ViewGroup) this, true);
            } else {
                LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d081f, (ViewGroup) this, true);
            }
            this.a = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091fe1);
            r();
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f091fe0);
            this.b = progressButton;
            progressButton.setUseLongText(false);
            u();
            t();
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091fe6);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091fdf);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091fe7);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091fde);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091fe5);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091fe4);
            this.i = findViewById(R.id.obfuscated_res_0x7f091fe8);
            this.j = findViewById(R.id.obfuscated_res_0x7f091fdd);
            this.k = findViewById(R.id.obfuscated_res_0x7f091fe2);
            this.l = findViewById(R.id.obfuscated_res_0x7f091fe3);
            this.g.setTag(Byte.valueOf((byte) YogaNodeJNIBase.HAS_NEW_LAYOUT));
            this.h.setTag((byte) 17);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            if (this.q) {
                setPadding(0, 0, 0, 0);
            } else {
                setPadding(li.f(getContext(), R.dimen.M_W_X003), li.f(getContext(), R.dimen.M_H_X002), li.f(getContext(), R.dimen.tbds0), li.f(getContext(), R.dimen.M_H_X002));
            }
            o();
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo;
        PluginUser pluginUser;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (UbsABTestHelper.isTiebaPlusCardModelABTestA() && (tbRichTextTiebaPlusInfo = this.n) != null && tbRichTextTiebaPlusInfo.A() != null) {
                TiebaPlusInfo A = this.n.A();
                if (A.jump_type.intValue() == 2 && (pluginUser = A.plugin_user) != null && pluginUser.is_download_card_whiteuser.intValue() == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ void m() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams.height = (this.a.getWidth() * 567) / 1009;
        this.a.setLayoutParams(layoutParams);
    }

    public final void n(boolean z) {
        TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (tbRichTextTiebaPlusInfo = this.n) == null || tbRichTextTiebaPlusInfo.A() == null) {
            return;
        }
        TiebaPlusInfo A = this.n.A();
        if (this.n.getType() == 36) {
            int intValue = A.jump_type.intValue();
            String str = "";
            if (intValue == 2) {
                if (this.n.getThreadData() != null && this.n.getThreadData().isTiebaPlusAdThread) {
                    str = this.n.getThreadData().tiebaPlusOrderId;
                }
                String str2 = str;
                if (this.p == null) {
                    this.p = new ze5(this.m, this.o, false);
                }
                this.o.J(this.p);
                ItemData itemData = new ItemData();
                itemData.parseProto(A);
                this.o.M(itemData);
                ze5 ze5Var = this.p;
                ze5Var.f(A.app_company);
                ze5Var.g(A.app_icon);
                ze5Var.h(A.title);
                ze5Var.i(A.app_version);
                ze5Var.j(new c(this, str2));
                this.p.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, this.q ? TiePlusStat.RichTextType.BIG_CARD : TiePlusStat.RichTextType.CARD, this.n.z(), this.n.getForumId(), this.n.y(), str2);
            } else if (intValue == 1) {
                this.o.l(A.jump_url, 1, "", A.h5_jump_type.intValue());
            } else if (intValue == 3) {
                this.o.U(A, TiePlusStat.RichTextType.CARD, this.n.z());
            } else if (intValue == 4) {
                this.o.l(A.h5_jump_number, intValue, A.h5_jump_param, 0);
            } else if (intValue == 6) {
                if (z) {
                    if (StringUtils.isNull(A.forum_name)) {
                        return;
                    }
                    ItemClickJumpUtil.itemClickJump(A.forum_name, A.item_id, 9, 9);
                } else if (A.is_appoint.intValue() != 1) {
                    this.o.E(jg.g(A.item_id, 0L), A.title, null);
                } else {
                    UtilHelper.showToast(this.m, (int) R.string.obfuscated_res_0x7f0f1418);
                }
            } else if (intValue != 5) {
                if (intValue == 7) {
                    if (A.jump_setting.intValue() == 1) {
                        this.o.V(A, TiePlusStat.RichTextType.CARD, this.n.z());
                    } else {
                        this.o.U(A, TiePlusStat.RichTextType.CARD, this.n.z());
                    }
                }
            } else {
                PluginUser pluginUser = A.plugin_user;
                if (pluginUser != null) {
                    Context context = this.m;
                    if (context instanceof Activity) {
                        TiePlusHelper.v((Activity) context, pluginUser);
                    }
                }
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            wq4 d2 = wq4.d(this);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                if (this.q) {
                    s();
                } else {
                    wq4.d(tbImageView).n(R.string.J_X05);
                    this.a.setConrers(15);
                    this.a.setPlaceHolder(2);
                }
            }
            TextView textView = this.c;
            if (textView != null) {
                wq4 d3 = wq4.d(textView);
                d3.A(R.string.F_X01);
                d3.v(R.color.CAM_X0107);
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                wq4 d4 = wq4.d(textView2);
                d4.A(R.string.F_X01);
                d4.v(R.color.CAM_X0109);
            }
            TextView textView3 = this.e;
            if (textView3 != null) {
                wq4 d5 = wq4.d(textView3);
                d5.A(R.string.F_X01);
                d5.v(R.color.CAM_X0109);
            }
            TextView textView4 = this.f;
            if (textView4 != null) {
                wq4 d6 = wq4.d(textView4);
                d6.A(R.string.F_X01);
                d6.v(R.color.CAM_X0109);
            }
            TextView textView5 = this.g;
            if (textView5 != null) {
                wq4 d7 = wq4.d(textView5);
                d7.A(R.string.F_X01);
                d7.v(R.color.CAM_X0109);
            }
            TextView textView6 = this.h;
            if (textView6 != null) {
                wq4 d8 = wq4.d(textView6);
                d8.A(R.string.F_X01);
                d8.v(R.color.CAM_X0109);
            }
            View view2 = this.i;
            if (view2 != null) {
                wq4.d(view2).f(R.color.CAM_X0110);
            }
            View view3 = this.j;
            if (view3 != null) {
                view3.setBackgroundResource(R.drawable.icon_ad_dislike_arrow20_right_n);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.n;
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.A() == null) {
                return;
            }
            this.o.f(this.b);
            this.o.J(this.p);
            ze5 ze5Var = this.p;
            if (ze5Var != null && ze5Var.isShowing()) {
                this.p.onAttachedToWindow();
            }
            TiebaPlusInfo A = this.n.A();
            int intValue = A.jump_type.intValue();
            TiePlusStat.LandingType landingType = null;
            if (this.n.getType() == 36) {
                switch (intValue) {
                    case 1:
                        landingType = TiePlusStat.LandingType.H5;
                        break;
                    case 2:
                        landingType = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                        if (!StringUtils.isNull(A.app_package) && !StringUtils.isNull(A.app_id)) {
                            this.o.Z(A.app_package, A.app_id, this.m, this.b);
                            ItemData itemData = new ItemData();
                            itemData.parseProto(A);
                            this.o.M(itemData);
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
            v(this.n.A(), this.n.getThreadData(), TiePlusStat.StatType.EXPOSE, landingType, null, this.n.z(), this.n.getForumId(), this.n.y());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            n(true);
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.n;
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.A() == null) {
                return;
            }
            int intValue = this.n.A().jump_type.intValue();
            TiePlusStat.LandingType landingType = null;
            if (this.n.getType() == 36) {
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
            v(this.n.A(), this.n.getThreadData(), TiePlusStat.StatType.CLICK, landingType, null, this.n.z(), this.n.getForumId(), this.n.y());
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.setCurProgress(-1);
            this.a.G();
            this.c.setText("");
            this.d.setText("");
            this.e.setText("");
            this.f.setText("");
            this.o.D();
            setOnClickListener(null);
            this.g.setOnClickListener(null);
            this.h.setOnClickListener(null);
            this.b.setOnClickListener(null);
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public final void r() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.q && (tbImageView = this.a) != null) {
            tbImageView.post(new Runnable() { // from class: com.repackage.ye5
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

    public final void s() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.q && (tbImageView = this.a) != null) {
            tbImageView.setDrawCorner(true);
            this.a.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081204);
            this.a.setRadiusById(R.string.J_X05);
            this.a.setConrers(3);
            this.a.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.a.setBorderSurroundContent(true);
            this.a.setDrawBorder(true);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String buttonDescFromServer = getButtonDescFromServer();
            if (this.b == null || StringUtils.isNull(buttonDescFromServer)) {
                return;
            }
            this.b.post(new d(this, buttonDescFromServer));
        }
    }

    public final void u() {
        TiePlusHelper tiePlusHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || StringUtils.isNull(getButtonDescFromServer()) || (tiePlusHelper = this.o) == null) {
            return;
        }
        tiePlusHelper.I(this.n.A().button_desc);
    }

    public final void v(TiebaPlusInfo tiebaPlusInfo, ThreadData threadData, TiePlusStat.StatType statType, TiePlusStat.LandingType landingType, TiePlusStat.CardBtnType cardBtnType, String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{tiebaPlusInfo, threadData, statType, landingType, cardBtnType, str, str2, str3}) == null) || tiebaPlusInfo == null || threadData == null) {
            return;
        }
        int a2 = TiePlusStat.a(tiebaPlusInfo, this);
        if (threadData.isTiebaPlusAdThread) {
            str4 = threadData.tiebaPlusOrderId;
            str5 = threadData.tiebaPlusToken;
            str6 = threadData.tiebaPlusExtraParam;
        } else {
            str4 = "";
            str5 = str4;
            str6 = str5;
        }
        TiePlusStat.b(a2, statType, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, this.q ? TiePlusStat.RichTextType.BIG_CARD : TiePlusStat.RichTextType.CARD, tiebaPlusInfo.target_type.intValue(), landingType, str, str2, str3, str4, cardBtnType);
        TiePlusStat.c(a2, statType, TiePlusStat.Locate.PB, str4, str5, str6, threadData.floorNum);
    }

    public final void w(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, tiebaPlusInfo) == null) && tiebaPlusInfo != null && tiebaPlusInfo.jump_type.intValue() == 6) {
            if (StringUtils.isNull(tiebaPlusInfo.title)) {
                this.c.setText("");
            } else {
                this.c.setText(tiebaPlusInfo.title);
            }
            this.e.setVisibility(8);
            if (StringUtils.isNull(tiebaPlusInfo.desc)) {
                this.k.setVisibility(8);
                this.d.setVisibility(8);
            } else {
                this.k.setVisibility(0);
                this.d.setVisibility(0);
                this.d.setText(tiebaPlusInfo.desc);
            }
            if (tiebaPlusInfo.is_appoint.intValue() == 1) {
                this.b.setText(this.m.getString(R.string.obfuscated_res_0x7f0f0981));
                this.b.b();
                return;
            }
            this.o.B();
            this.b.setText(this.m.getString(R.string.obfuscated_res_0x7f0f0980));
            this.b.e();
            this.o.H(new b(this, tiebaPlusInfo));
        }
    }

    public void x(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tbRichTextTiebaPlusInfo) == null) {
            this.n = tbRichTextTiebaPlusInfo;
            if (tbRichTextTiebaPlusInfo != null && tbRichTextTiebaPlusInfo.A() != null) {
                this.q = l();
                k();
                TiebaPlusInfo A = this.n.A();
                if (36 == this.n.getType() && A != null) {
                    switch (A.jump_type.intValue()) {
                        case 1:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            j(A);
                            break;
                        case 2:
                            i(A);
                            break;
                    }
                }
                setOnClickListener(this);
                this.b.setOnClickListener(new a(this));
                return;
            }
            q();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TiebaPlusRecommendCard(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = context;
        this.o = new TiePlusHelper(this.m);
    }
}
