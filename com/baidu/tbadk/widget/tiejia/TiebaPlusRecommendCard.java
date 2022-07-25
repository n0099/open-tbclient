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
import com.repackage.ng;
import com.repackage.pi;
import com.repackage.vr4;
import com.repackage.w05;
import com.repackage.zg5;
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
    public zg5 p;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.n == null || this.a.n.C() == null) {
                return;
            }
            TiebaPlusInfo C = this.a.n.C();
            if (C != null) {
                i = C.jump_type.intValue();
                str = C.app_package;
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
                        this.a.o.g(new w05(TiePlusStat.StatType.DOWNLOAD_FINISHED, richTextType, this.a.n.B(), str2, str));
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
                tiebaPlusRecommendCard.u(tiebaPlusRecommendCard.n.C(), this.a.n.getThreadData(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.a.n.B(), this.a.n.getForumId(), this.a.n.A());
            }
            landingType = null;
            cardBtnType = null;
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = this.a;
            tiebaPlusRecommendCard2.u(tiebaPlusRecommendCard2.n.C(), this.a.n.getThreadData(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.a.n.B(), this.a.n.getForumId(), this.a.n.A());
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
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && j == ng.g(this.a.item_id, 0L)) {
                TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder(this.a);
                builder.is_appoint = 1;
                TiebaPlusInfo build = builder.build(true);
                this.b.n.D(build);
                this.b.v(build);
                UtilHelper.showToast(this.b.m, (int) R.string.obfuscated_res_0x7f0f13cf);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                UtilHelper.showToast(this.b.m, (int) R.string.obfuscated_res_0x7f0f13ce);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements zg5.c {
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

        @Override // com.repackage.zg5.c
        public void a() {
            TiePlusStat.RichTextType richTextType;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.q) {
                    richTextType = TiePlusStat.RichTextType.BIG_CARD;
                } else {
                    richTextType = TiePlusStat.RichTextType.CARD;
                }
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, richTextType, this.b.n.B(), this.b.n.getForumId(), this.b.n.A(), this.a);
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
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.C() == null || StringUtils.isNull(this.n.C().button_desc)) {
                return null;
            }
            return this.n.C().button_desc;
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
                this.a.J(tiebaPlusInfo.app_icon, 10, false);
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
                this.e.setText(String.format(this.m.getString(R.string.obfuscated_res_0x7f0f0297), tiebaPlusInfo.app_version));
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
            tiePlusHelper.E(tiebaPlusInfo.app_id);
            tiePlusHelper.J(tiebaPlusInfo.download_url);
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
                this.a.J(tiebaPlusInfo.app_icon, 10, false);
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
                this.b.setText(this.m.getString(R.string.obfuscated_res_0x7f0f14f6));
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

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeAllViews();
            if (this.q) {
                LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0846, (ViewGroup) this, true);
            } else {
                LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0847, (ViewGroup) this, true);
            }
            this.a = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092089);
            q();
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f092088);
            this.b = progressButton;
            progressButton.setUseLongText(false);
            t();
            s();
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09208e);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f092087);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09208f);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f092086);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f09208d);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f09208c);
            this.i = findViewById(R.id.obfuscated_res_0x7f092090);
            this.j = findViewById(R.id.obfuscated_res_0x7f092085);
            this.k = findViewById(R.id.obfuscated_res_0x7f09208a);
            this.l = findViewById(R.id.obfuscated_res_0x7f09208b);
            this.g.setTag((byte) 16);
            this.h.setTag((byte) 17);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            if (this.q) {
                setPadding(0, 0, 0, 0);
            } else {
                setPadding(pi.f(getContext(), R.dimen.M_W_X003), pi.f(getContext(), R.dimen.M_H_X002), pi.f(getContext(), R.dimen.tbds0), pi.f(getContext(), R.dimen.M_H_X002));
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
            if (UbsABTestHelper.isTiebaPlusCardModelABTestA() && (tbRichTextTiebaPlusInfo = this.n) != null && tbRichTextTiebaPlusInfo.C() != null) {
                TiebaPlusInfo C = this.n.C();
                if (C.jump_type.intValue() == 2 && (pluginUser = C.plugin_user) != null && pluginUser.is_download_card_whiteuser.intValue() == 1) {
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
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (tbRichTextTiebaPlusInfo = this.n) == null || tbRichTextTiebaPlusInfo.C() == null) {
            return;
        }
        TiebaPlusInfo C = this.n.C();
        if (this.n.getType() == 36) {
            int intValue = C.jump_type.intValue();
            String str = "";
            if (intValue == 2) {
                if (this.n.getThreadData() != null && this.n.getThreadData().isTiebaPlusAdThread) {
                    str = this.n.getThreadData().tiebaPlusOrderId;
                }
                String str2 = str;
                if (this.p == null) {
                    this.p = new zg5(this.m, this.o, false);
                }
                this.o.I(this.p);
                ItemData itemData = new ItemData();
                itemData.parseProto(C);
                this.o.M(itemData);
                zg5 zg5Var = this.p;
                zg5Var.f(C.app_company);
                zg5Var.g(C.app_icon);
                zg5Var.h(C.title);
                zg5Var.i(C.app_version);
                zg5Var.j(new c(this, str2));
                this.p.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, this.q ? TiePlusStat.RichTextType.BIG_CARD : TiePlusStat.RichTextType.CARD, this.n.B(), this.n.getForumId(), this.n.A(), str2);
            } else if (intValue == 1) {
                this.o.l(C.jump_url, 1, "", C.h5_jump_type.intValue());
            } else if (intValue == 3) {
                this.o.U(C, TiePlusStat.RichTextType.CARD, this.n.B());
            } else if (intValue == 4) {
                this.o.l(C.h5_jump_number, intValue, C.h5_jump_param, 0);
            } else if (intValue == 6) {
                if (z) {
                    if (StringUtils.isNull(C.forum_name)) {
                        return;
                    }
                    ItemClickJumpUtil.itemClickJump(C.forum_name, C.item_id, 9, 9);
                } else if (C.is_appoint.intValue() != 1) {
                    this.o.D(ng.g(C.item_id, 0L), C.title, null);
                } else {
                    UtilHelper.showToast(this.m, (int) R.string.obfuscated_res_0x7f0f13cd);
                }
            } else if (intValue != 5) {
                if (intValue == 7) {
                    if (C.jump_setting.intValue() == 1) {
                        this.o.V(C, TiePlusStat.RichTextType.CARD, this.n.B());
                    } else {
                        this.o.U(C, TiePlusStat.RichTextType.CARD, this.n.B());
                    }
                }
            } else {
                PluginUser pluginUser = C.plugin_user;
                if (pluginUser != null) {
                    Context context = this.m;
                    if (context instanceof Activity) {
                        TiePlusHelper.u((Activity) context, pluginUser);
                    }
                }
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            vr4 d2 = vr4.d(this);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                if (this.q) {
                    r();
                } else {
                    vr4.d(tbImageView).n(R.string.J_X05);
                    this.a.setConrers(15);
                    this.a.setPlaceHolder(2);
                }
            }
            TextView textView = this.c;
            if (textView != null) {
                vr4 d3 = vr4.d(textView);
                d3.A(R.string.F_X01);
                d3.v(R.color.CAM_X0107);
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                vr4 d4 = vr4.d(textView2);
                d4.A(R.string.F_X01);
                d4.v(R.color.CAM_X0109);
            }
            TextView textView3 = this.e;
            if (textView3 != null) {
                vr4 d5 = vr4.d(textView3);
                d5.A(R.string.F_X01);
                d5.v(R.color.CAM_X0109);
            }
            TextView textView4 = this.f;
            if (textView4 != null) {
                vr4 d6 = vr4.d(textView4);
                d6.A(R.string.F_X01);
                d6.v(R.color.CAM_X0109);
            }
            TextView textView5 = this.g;
            if (textView5 != null) {
                vr4 d7 = vr4.d(textView5);
                d7.A(R.string.F_X01);
                d7.v(R.color.CAM_X0109);
            }
            TextView textView6 = this.h;
            if (textView6 != null) {
                vr4 d8 = vr4.d(textView6);
                d8.A(R.string.F_X01);
                d8.v(R.color.CAM_X0109);
            }
            View view2 = this.i;
            if (view2 != null) {
                vr4.d(view2).f(R.color.CAM_X0110);
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
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.C() == null) {
                return;
            }
            this.o.f(this.b);
            this.o.I(this.p);
            zg5 zg5Var = this.p;
            if (zg5Var != null && zg5Var.isShowing()) {
                this.p.onAttachedToWindow();
            }
            TiebaPlusInfo C = this.n.C();
            int intValue = C.jump_type.intValue();
            TiePlusStat.LandingType landingType = null;
            if (this.n.getType() == 36) {
                switch (intValue) {
                    case 1:
                        landingType = TiePlusStat.LandingType.H5;
                        break;
                    case 2:
                        landingType = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                        if (!StringUtils.isNull(C.app_package) && !StringUtils.isNull(C.app_id)) {
                            this.o.Z(C.app_package, C.app_id, this.m, this.b);
                            ItemData itemData = new ItemData();
                            itemData.parseProto(C);
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
            u(this.n.C(), this.n.getThreadData(), TiePlusStat.StatType.EXPOSE, landingType, null, this.n.B(), this.n.getForumId(), this.n.A());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            n(true);
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.n;
            if (tbRichTextTiebaPlusInfo == null || tbRichTextTiebaPlusInfo.C() == null) {
                return;
            }
            int intValue = this.n.C().jump_type.intValue();
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
            u(this.n.C(), this.n.getThreadData(), TiePlusStat.StatType.CLICK, landingType, null, this.n.B(), this.n.getForumId(), this.n.A());
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.setCurProgress(-1);
            this.a.F();
            this.c.setText("");
            this.d.setText("");
            this.e.setText("");
            this.f.setText("");
            this.o.C();
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
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.q && (tbImageView = this.a) != null) {
            tbImageView.post(new Runnable() { // from class: com.repackage.yg5
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

    public final void r() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.q && (tbImageView = this.a) != null) {
            tbImageView.setDrawCorner(true);
            this.a.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081179);
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || StringUtils.isNull(getButtonDescFromServer()) || (tiePlusHelper = this.o) == null) {
            return;
        }
        tiePlusHelper.H(this.n.C().button_desc);
    }

    public final void u(TiebaPlusInfo tiebaPlusInfo, ThreadData threadData, TiePlusStat.StatType statType, TiePlusStat.LandingType landingType, TiePlusStat.CardBtnType cardBtnType, String str, String str2, String str3) {
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

    public final void v(@NonNull TiebaPlusInfo tiebaPlusInfo) {
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
                this.b.setText(this.m.getString(R.string.obfuscated_res_0x7f0f097c));
                this.b.b();
                return;
            }
            this.o.A();
            this.b.setText(this.m.getString(R.string.obfuscated_res_0x7f0f097b));
            this.b.e();
            this.o.G(new b(this, tiebaPlusInfo));
        }
    }

    public void w(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tbRichTextTiebaPlusInfo) == null) {
            this.n = tbRichTextTiebaPlusInfo;
            if (tbRichTextTiebaPlusInfo != null && tbRichTextTiebaPlusInfo.C() != null) {
                this.q = l();
                k();
                TiebaPlusInfo C = this.n.C();
                if (36 == this.n.getType() && C != null) {
                    switch (C.jump_type.intValue()) {
                        case 1:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            j(C);
                            break;
                        case 2:
                            i(C);
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
