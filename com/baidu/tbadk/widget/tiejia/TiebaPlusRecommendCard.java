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
import com.baidu.tieba.R;
import com.baidu.tieba.dh;
import com.baidu.tieba.ej;
import com.baidu.tieba.hv4;
import com.baidu.tieba.ol5;
import com.baidu.tieba.r45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public ol5 p;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.n == null || this.a.n.B() == null) {
                return;
            }
            TiebaPlusInfo B = this.a.n.B();
            if (B != null) {
                i = B.jump_type.intValue();
                str = B.app_package;
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
                        this.a.o.j(new r45(TiePlusStat.StatType.DOWNLOAD_FINISHED, richTextType, this.a.n.A(), str2, str));
                        if (this.a.q) {
                            this.a.o.onClick(view2);
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
                tiebaPlusRecommendCard.u(tiebaPlusRecommendCard.n.B(), this.a.n.getThreadData(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.a.n.A(), this.a.n.getForumId(), this.a.n.z());
            }
            landingType = null;
            cardBtnType = null;
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = this.a;
            tiebaPlusRecommendCard2.u(tiebaPlusRecommendCard2.n.B(), this.a.n.getThreadData(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.a.n.A(), this.a.n.getForumId(), this.a.n.z());
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
        public void a(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && j == dh.g(this.a.item_id, 0L)) {
                TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder(this.a);
                builder.is_appoint = 1;
                TiebaPlusInfo build = builder.build(true);
                this.b.n.C(build);
                this.b.v(build);
                UtilHelper.showToast(this.b.m, (int) R.string.obfuscated_res_0x7f0f1433);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                UtilHelper.showToast(this.b.m, (int) R.string.obfuscated_res_0x7f0f1432);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ol5.c {
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

        @Override // com.baidu.tieba.ol5.c
        public void a() {
            TiePlusStat.RichTextType richTextType;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.q) {
                    richTextType = TiePlusStat.RichTextType.BIG_CARD;
                } else {
                    richTextType = TiePlusStat.RichTextType.CARD;
                }
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, richTextType, this.b.n.A(), this.b.n.getForumId(), this.b.n.z(), this.a);
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

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusRecommendCard a;

        public e(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.a.getLayoutParams();
                layoutParams.height = (this.a.a.getWidth() * 567) / 1009;
                this.a.a.setLayoutParams(layoutParams);
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
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.B() == null || StringUtils.isNull(this.n.B().button_desc)) {
                return null;
            }
            return this.n.B().button_desc;
        }
        return (String) invokeV.objValue;
    }

    public final void j(@NonNull TiebaPlusInfo tiebaPlusInfo) {
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
                this.e.setText(String.format(this.m.getString(R.string.obfuscated_res_0x7f0f02a1), tiebaPlusInfo.app_version));
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
            } else {
                this.e.setVisibility(8);
                this.l.setVisibility(8);
            }
            if (this.q) {
                this.j.setVisibility(8);
                this.b.setVisibility(0);
            } else {
                this.j.setVisibility(0);
                this.b.setVisibility(8);
            }
            if (this.k.getVisibility() != 8) {
                this.d.requestLayout();
            }
            TiePlusHelper tiePlusHelper = this.o;
            tiePlusHelper.D(tiebaPlusInfo.app_id);
            tiePlusHelper.I(tiebaPlusInfo.download_url);
            tiePlusHelper.M(tiebaPlusInfo.app_package);
            tiePlusHelper.N(tiebaPlusInfo.app_power);
            tiePlusHelper.O(tiebaPlusInfo.app_privacy);
            tiePlusHelper.i(this.b);
            this.g.setOnClickListener(this.o);
            this.h.setOnClickListener(this.o);
            Context context = this.m;
            if (!(context instanceof TbPageContextSupport) || (pageContext = ((TbPageContextSupport) context).getPageContext()) == null) {
                return;
            }
            pageContext.registerListener(this.o);
        }
    }

    public final void k(@NonNull TiebaPlusInfo tiebaPlusInfo) {
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
                v(tiebaPlusInfo);
                this.j.setVisibility(8);
                this.b.setVisibility(0);
            } else if (tiebaPlusInfo.jump_type.intValue() == 5) {
                this.j.setVisibility(0);
                this.b.setVisibility(8);
            } else if (tiebaPlusInfo.jump_type.intValue() != 7 && tiebaPlusInfo.jump_type.intValue() != 3) {
                this.b.setTag(null);
                this.b.setText(this.m.getString(R.string.obfuscated_res_0x7f0f1564));
                this.b.e();
                this.j.setVisibility(0);
                this.b.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                this.b.setVisibility(8);
            }
            this.b.setOnClickListener(this);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeAllViews();
            if (this.q) {
                LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d088d, (ViewGroup) this, true);
            } else {
                LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d088e, (ViewGroup) this, true);
            }
            this.a = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0921de);
            q();
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f0921dd);
            this.b = progressButton;
            progressButton.setUseLongText(false);
            t();
            s();
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0921e3);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0921dc);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0921e4);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f0921db);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0921e2);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0921e1);
            this.i = findViewById(R.id.obfuscated_res_0x7f0921e5);
            this.j = findViewById(R.id.obfuscated_res_0x7f0921da);
            this.k = findViewById(R.id.obfuscated_res_0x7f0921df);
            this.l = findViewById(R.id.obfuscated_res_0x7f0921e0);
            this.g.setTag((byte) 16);
            this.h.setTag((byte) 17);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            if (this.q) {
                setPadding(0, 0, 0, 0);
            } else {
                setPadding(ej.f(getContext(), R.dimen.M_W_X003), ej.f(getContext(), R.dimen.M_H_X002), ej.f(getContext(), R.dimen.tbds0), ej.f(getContext(), R.dimen.M_H_X002));
            }
            o();
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo;
        PluginUser pluginUser;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (UbsABTestHelper.isTiebaPlusCardModelABTestA() && (tbRichTextTiebaPlusInfo = this.n) != null && tbRichTextTiebaPlusInfo.B() != null) {
                TiebaPlusInfo B = this.n.B();
                if (B.jump_type.intValue() == 2 && (pluginUser = B.plugin_user) != null && pluginUser.is_download_card_whiteuser.intValue() == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n(boolean z) {
        TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (tbRichTextTiebaPlusInfo = this.n) == null || tbRichTextTiebaPlusInfo.B() == null) {
            return;
        }
        TiebaPlusInfo B = this.n.B();
        if (this.n.getType() == 36) {
            int intValue = B.jump_type.intValue();
            String str = "";
            if (intValue == 2) {
                if (this.n.getThreadData() != null && this.n.getThreadData().isTiebaPlusAdThread) {
                    str = this.n.getThreadData().tiebaPlusOrderId;
                }
                String str2 = str;
                if (this.p == null) {
                    this.p = new ol5(this.m, this.o, false);
                }
                this.o.H(this.p);
                ItemData itemData = new ItemData();
                itemData.parseProto(B);
                this.o.L(itemData);
                ol5 ol5Var = this.p;
                ol5Var.f(B.app_company);
                ol5Var.g(B.app_icon);
                ol5Var.h(B.title);
                ol5Var.i(B.app_version);
                ol5Var.j(new c(this, str2));
                this.p.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, this.q ? TiePlusStat.RichTextType.BIG_CARD : TiePlusStat.RichTextType.CARD, this.n.A(), this.n.getForumId(), this.n.z(), str2);
            } else if (intValue == 1) {
                this.o.o(B.jump_url, 1, "", B.h5_jump_type.intValue());
            } else if (intValue == 3) {
                this.o.T(B, TiePlusStat.RichTextType.CARD, this.n.A());
            } else if (intValue == 4) {
                this.o.o(B.h5_jump_number, intValue, B.h5_jump_param, 0);
            } else if (intValue == 6) {
                if (z) {
                    if (StringUtils.isNull(B.forum_name)) {
                        return;
                    }
                    ItemClickJumpUtil.itemClickJump(B.forum_name, B.item_id, 9, 9);
                } else if (B.is_appoint.intValue() != 1) {
                    this.o.C(dh.g(B.item_id, 0L), B.title, null);
                } else {
                    UtilHelper.showToast(this.m, (int) R.string.obfuscated_res_0x7f0f1431);
                }
            } else if (intValue != 5) {
                if (intValue == 7) {
                    if (B.jump_setting.intValue() == 1) {
                        this.o.U(B, TiePlusStat.RichTextType.CARD, this.n.A());
                    } else {
                        this.o.T(B, TiePlusStat.RichTextType.CARD, this.n.A());
                    }
                }
            } else {
                PluginUser pluginUser = B.plugin_user;
                if (pluginUser != null) {
                    Context context = this.m;
                    if (context instanceof Activity) {
                        TiePlusHelper.x((Activity) context, pluginUser);
                    }
                }
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            hv4 d2 = hv4.d(this);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                if (this.q) {
                    r();
                } else {
                    hv4.d(tbImageView).n(R.string.J_X05);
                    this.a.setConrers(15);
                    this.a.setPlaceHolder(2);
                }
            }
            TextView textView = this.c;
            if (textView != null) {
                hv4 d3 = hv4.d(textView);
                d3.A(R.string.F_X01);
                d3.v(R.color.CAM_X0107);
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                hv4 d4 = hv4.d(textView2);
                d4.A(R.string.F_X01);
                d4.v(R.color.CAM_X0109);
            }
            TextView textView3 = this.e;
            if (textView3 != null) {
                hv4 d5 = hv4.d(textView3);
                d5.A(R.string.F_X01);
                d5.v(R.color.CAM_X0109);
            }
            TextView textView4 = this.f;
            if (textView4 != null) {
                hv4 d6 = hv4.d(textView4);
                d6.A(R.string.F_X01);
                d6.v(R.color.CAM_X0109);
            }
            TextView textView5 = this.g;
            if (textView5 != null) {
                hv4 d7 = hv4.d(textView5);
                d7.A(R.string.F_X01);
                d7.v(R.color.CAM_X0109);
            }
            TextView textView6 = this.h;
            if (textView6 != null) {
                hv4 d8 = hv4.d(textView6);
                d8.A(R.string.F_X01);
                d8.v(R.color.CAM_X0109);
            }
            View view2 = this.i;
            if (view2 != null) {
                hv4.d(view2).f(R.color.CAM_X0110);
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
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.n;
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.B() == null) {
                return;
            }
            this.o.i(this.b);
            this.o.H(this.p);
            ol5 ol5Var = this.p;
            if (ol5Var != null && ol5Var.isShowing()) {
                this.p.onAttachedToWindow();
            }
            TiebaPlusInfo B = this.n.B();
            int intValue = B.jump_type.intValue();
            TiePlusStat.LandingType landingType = null;
            if (this.n.getType() == 36) {
                switch (intValue) {
                    case 1:
                        landingType = TiePlusStat.LandingType.H5;
                        break;
                    case 2:
                        landingType = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                        if (!StringUtils.isNull(B.app_package) && !StringUtils.isNull(B.app_id)) {
                            this.o.Y(B.app_package, B.app_id, this.m, this.b);
                            ItemData itemData = new ItemData();
                            itemData.parseProto(B);
                            this.o.L(itemData);
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
            u(this.n.B(), this.n.getThreadData(), TiePlusStat.StatType.EXPOSE, landingType, null, this.n.A(), this.n.getForumId(), this.n.z());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            n(true);
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.n;
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.B() == null) {
                return;
            }
            int intValue = this.n.B().jump_type.intValue();
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
            u(this.n.B(), this.n.getThreadData(), TiePlusStat.StatType.CLICK, landingType, null, this.n.A(), this.n.getForumId(), this.n.z());
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b.setCurProgress(-1);
            this.a.F();
            this.c.setText("");
            this.d.setText("");
            this.e.setText("");
            this.f.setText("");
            this.o.B();
            setOnClickListener(null);
            this.g.setOnClickListener(null);
            this.h.setOnClickListener(null);
            this.b.setOnClickListener(null);
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public final void q() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.q && (tbImageView = this.a) != null) {
            tbImageView.post(new e(this));
        }
    }

    public final void r() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.q && (tbImageView = this.a) != null) {
            tbImageView.setDrawCorner(true);
            this.a.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081210);
            this.a.setRadiusById(R.string.J_X05);
            this.a.setConrers(3);
            this.a.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.a.setBorderSurroundContent(true);
            this.a.setDrawBorder(true);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String buttonDescFromServer = getButtonDescFromServer();
            if (this.b == null || StringUtils.isNull(buttonDescFromServer)) {
                return;
            }
            this.b.post(new d(this, buttonDescFromServer));
        }
    }

    public final void t() {
        TiePlusHelper tiePlusHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || StringUtils.isNull(getButtonDescFromServer()) || (tiePlusHelper = this.o) == null) {
            return;
        }
        tiePlusHelper.G(this.n.B().button_desc);
    }

    public final void u(TiebaPlusInfo tiebaPlusInfo, ThreadData threadData, TiePlusStat.StatType statType, TiePlusStat.LandingType landingType, TiePlusStat.CardBtnType cardBtnType, String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{tiebaPlusInfo, threadData, statType, landingType, cardBtnType, str, str2, str3}) == null) || tiebaPlusInfo == null || threadData == null) {
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

    public final void v(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, tiebaPlusInfo) == null) && tiebaPlusInfo != null && tiebaPlusInfo.jump_type.intValue() == 6) {
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
                this.b.setText(this.m.getString(R.string.obfuscated_res_0x7f0f09aa));
                this.b.b();
                return;
            }
            this.o.z();
            this.b.setText(this.m.getString(R.string.obfuscated_res_0x7f0f09a9));
            this.b.e();
            this.o.F(new b(this, tiebaPlusInfo));
        }
    }

    public void w(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tbRichTextTiebaPlusInfo) == null) {
            this.n = tbRichTextTiebaPlusInfo;
            if (tbRichTextTiebaPlusInfo != null && tbRichTextTiebaPlusInfo.B() != null) {
                this.q = m();
                l();
                TiebaPlusInfo B = this.n.B();
                if (36 == this.n.getType() && B != null) {
                    switch (B.jump_type.intValue()) {
                        case 1:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            k(B);
                            break;
                        case 2:
                            j(B);
                            break;
                    }
                }
                setOnClickListener(this);
                this.b.setOnClickListener(new a(this));
                return;
            }
            p();
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
