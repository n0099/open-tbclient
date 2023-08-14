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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextTiebaPlusInfo;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.v06;
import com.baidu.tieba.vg5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes5.dex */
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
    public v06 p;

    /* loaded from: classes5.dex */
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
            String str2;
            TiePlusStat.LandingType landingType;
            TiePlusStat.CardBtnType cardBtnType;
            TiePlusStat.LandingType landingType2;
            TiePlusStat.CardBtnType cardBtnType2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.n != null && this.a.n.P() != null) {
                TiebaPlusInfo P = this.a.n.P();
                if (P != null) {
                    i = P.jump_type.intValue();
                    str = P.app_package;
                } else {
                    str = null;
                    i = 0;
                }
                if (this.a.n.getThreadData() != null && this.a.n.getThreadData().isTiebaPlusAdThread) {
                    str2 = this.a.n.getThreadData().tiebaPlusOrderId;
                } else {
                    str2 = "";
                }
                String str3 = str2;
                if (this.a.n.getType() == 36) {
                    switch (i) {
                        case 1:
                            landingType2 = TiePlusStat.LandingType.H5;
                            cardBtnType2 = TiePlusStat.CardBtnType.H5;
                            this.a.k(false);
                            cardBtnType = cardBtnType2;
                            landingType = landingType2;
                            break;
                        case 2:
                            landingType2 = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                            TiePlusStat.CardBtnType cardBtnType3 = TiePlusStat.CardBtnType.DOWNLOAD;
                            this.a.o.j(new vg5(TiePlusStat.StatType.DOWNLOAD_FINISHED, TiePlusStat.RichTextType.CARD, this.a.n.O(), str3, str));
                            this.a.o.onClick(view2);
                            cardBtnType = cardBtnType3;
                            landingType = landingType2;
                            break;
                        case 3:
                            landingType2 = TiePlusStat.LandingType.WECHAT;
                            cardBtnType2 = TiePlusStat.CardBtnType.H5;
                            this.a.k(false);
                            cardBtnType = cardBtnType2;
                            landingType = landingType2;
                            break;
                        case 4:
                            landingType2 = TiePlusStat.LandingType.WECHAT_MINIAPP;
                            cardBtnType2 = TiePlusStat.CardBtnType.H5;
                            this.a.k(false);
                            cardBtnType = cardBtnType2;
                            landingType = landingType2;
                            break;
                        case 5:
                            landingType2 = TiePlusStat.LandingType.MESSAGE;
                            cardBtnType2 = TiePlusStat.CardBtnType.H5;
                            this.a.k(false);
                            cardBtnType = cardBtnType2;
                            landingType = landingType2;
                            break;
                        case 6:
                            landingType2 = TiePlusStat.LandingType.APPOINT;
                            cardBtnType2 = TiePlusStat.CardBtnType.H5;
                            this.a.k(false);
                            cardBtnType = cardBtnType2;
                            landingType = landingType2;
                            break;
                        case 7:
                            landingType2 = TiePlusStat.LandingType.WECHAT_OFFICIAL;
                            cardBtnType2 = TiePlusStat.CardBtnType.H5;
                            this.a.k(false);
                            cardBtnType = cardBtnType2;
                            landingType = landingType2;
                            break;
                    }
                    TiebaPlusRecommendCard tiebaPlusRecommendCard = this.a;
                    tiebaPlusRecommendCard.p(tiebaPlusRecommendCard.n.P(), this.a.n.getThreadData(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.a.n.O(), this.a.n.getForumId(), this.a.n.N());
                }
                landingType = null;
                cardBtnType = null;
                TiebaPlusRecommendCard tiebaPlusRecommendCard2 = this.a;
                tiebaPlusRecommendCard2.p(tiebaPlusRecommendCard2.n.P(), this.a.n.getThreadData(), TiePlusStat.StatType.CLICK, landingType, cardBtnType, this.a.n.O(), this.a.n.getForumId(), this.a.n.N());
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                UtilHelper.showToast(this.b.m, (int) R.string.tip_order_fail);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || j != JavaTypesHelper.toLong(this.a.item_id, 0L)) {
                return;
            }
            TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder(this.a);
            builder.is_appoint = 1;
            TiebaPlusInfo build = builder.build(true);
            this.b.n.Q(build);
            this.b.q(build);
            UtilHelper.showToast(this.b.m, (int) R.string.tip_order_successs);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements v06.c {
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

        @Override // com.baidu.tieba.v06.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, this.b.n.O(), this.b.n.getForumId(), this.b.n.N(), this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (f = this.b.b.f(this.a)) > 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.b.getLayoutParams();
                layoutParams.width = f;
                this.b.b.setLayoutParams(layoutParams);
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

    public void r(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tbRichTextTiebaPlusInfo) == null) {
            this.n = tbRichTextTiebaPlusInfo;
            if (tbRichTextTiebaPlusInfo != null && tbRichTextTiebaPlusInfo.P() != null) {
                j();
                TiebaPlusInfo P = this.n.P();
                if (36 == this.n.getType() && P != null) {
                    switch (P.jump_type.intValue()) {
                        case 1:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            i(P);
                            break;
                        case 2:
                            h(P);
                            break;
                    }
                }
                setOnClickListener(this);
                this.b.setOnClickListener(new a(this));
                return;
            }
            m();
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

    private String getButtonDescFromServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.n;
            if (tbRichTextTiebaPlusInfo != null && tbRichTextTiebaPlusInfo.P() != null && !StringUtils.isNull(this.n.P().button_desc)) {
                return this.n.P().button_desc;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void h(@NonNull TiebaPlusInfo tiebaPlusInfo) {
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
                this.a.startLoad(tiebaPlusInfo.app_icon, 10, false);
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
                this.e.setText(String.format(this.m.getString(R.string.app_version), tiebaPlusInfo.app_version));
            }
            if (StringUtils.isNull(tiebaPlusInfo.app_company)) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                this.f.setText(tiebaPlusInfo.app_company);
            }
            this.e.setVisibility(8);
            this.l.setVisibility(8);
            this.j.setVisibility(0);
            this.b.setVisibility(8);
            if (this.k.getVisibility() != 8) {
                this.d.requestLayout();
            }
            TiePlusHelper tiePlusHelper = this.o;
            tiePlusHelper.F(tiebaPlusInfo.app_id);
            tiePlusHelper.K(tiebaPlusInfo.download_url);
            tiePlusHelper.O(tiebaPlusInfo.app_package);
            tiePlusHelper.P(tiebaPlusInfo.app_power);
            tiePlusHelper.Q(tiebaPlusInfo.app_privacy);
            tiePlusHelper.i(this.b);
            this.g.setOnClickListener(this.o);
            this.h.setOnClickListener(this.o);
            Context context = this.m;
            if ((context instanceof TbPageContextSupport) && (pageContext = ((TbPageContextSupport) context).getPageContext()) != null) {
                pageContext.registerListener(this.o);
            }
        }
    }

    public final void k(boolean z) {
        TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (tbRichTextTiebaPlusInfo = this.n) != null && tbRichTextTiebaPlusInfo.P() != null) {
            TiebaPlusInfo P = this.n.P();
            if (this.n.getType() == 36) {
                int intValue = P.jump_type.intValue();
                String str = "";
                if (intValue == 2) {
                    if (this.n.getThreadData() != null && this.n.getThreadData().isTiebaPlusAdThread) {
                        str = this.n.getThreadData().tiebaPlusOrderId;
                    }
                    String str2 = str;
                    if (this.p == null) {
                        this.p = new v06(this.m, this.o, false);
                    }
                    this.o.J(this.p);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(P);
                    this.o.N(itemData);
                    v06 v06Var = this.p;
                    v06Var.f(P.app_company);
                    v06Var.g(P.app_icon);
                    v06Var.h(P.title);
                    v06Var.i(P.app_version);
                    v06Var.j(new c(this, str2));
                    this.p.show();
                    TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, this.n.O(), this.n.getForumId(), this.n.N(), str2);
                } else if (intValue == 1) {
                    this.o.o(P.jump_url, 1, "", P.h5_jump_type.intValue());
                } else if (intValue == 3) {
                    this.o.V(P, TiePlusStat.RichTextType.CARD, this.n.O());
                } else if (intValue == 4) {
                    this.o.o(P.h5_jump_number, intValue, P.h5_jump_param, 0);
                } else if (intValue == 6) {
                    if (z) {
                        if (!StringUtils.isNull(P.forum_name)) {
                            ItemClickJumpUtil.itemClickJump(P.forum_name, P.item_id, 9, 9);
                        }
                    } else if (P.is_appoint.intValue() != 1) {
                        this.o.E(JavaTypesHelper.toLong(P.item_id, 0L), P.title, null);
                    } else {
                        UtilHelper.showToast(this.m, (int) R.string.tip_order_completed);
                    }
                } else if (intValue == 5) {
                    PluginUser pluginUser = P.plugin_user;
                    if (pluginUser != null) {
                        Context context = this.m;
                        if (context instanceof Activity) {
                            TiePlusHelper.z((Activity) context, pluginUser);
                        }
                    }
                } else if (intValue == 7) {
                    if (P.jump_setting.intValue() == 1) {
                        this.o.W(P, TiePlusStat.RichTextType.CARD, this.n.O());
                    } else {
                        this.o.V(P, TiePlusStat.RichTextType.CARD, this.n.O());
                    }
                }
            }
        }
    }

    public final void i(@NonNull TiebaPlusInfo tiebaPlusInfo) {
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
                this.a.startLoad(tiebaPlusInfo.app_icon, 10, false);
            }
            if (tiebaPlusInfo.jump_type.intValue() == 6) {
                q(tiebaPlusInfo);
                this.j.setVisibility(8);
                this.b.setVisibility(0);
            } else if (tiebaPlusInfo.jump_type.intValue() == 5) {
                this.j.setVisibility(0);
                this.b.setVisibility(8);
            } else if (tiebaPlusInfo.jump_type.intValue() != 7 && tiebaPlusInfo.jump_type.intValue() != 3) {
                this.b.setTag(null);
                this.b.setText(this.m.getString(R.string.obfuscated_res_0x7f0f181f));
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

    public final void q(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, tiebaPlusInfo) != null) || tiebaPlusInfo == null || tiebaPlusInfo.jump_type.intValue() != 6) {
            return;
        }
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
            this.b.setText(this.m.getString(R.string.item_order_complete));
            this.b.b();
            return;
        }
        this.o.B();
        this.b.setText(this.m.getString(R.string.item_order));
        this.b.e();
        this.o.H(new b(this, tiebaPlusInfo));
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeAllViews();
            LayoutInflater.from(getContext()).inflate(R.layout.tiejia_recommend_card, (ViewGroup) this, true);
            this.a = (TbImageView) findViewById(R.id.tiejia_card_icon);
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.tiejia_card_download);
            this.b = progressButton;
            progressButton.setUseLongText(false);
            o();
            n();
            this.c = (TextView) findViewById(R.id.tiejia_card_title);
            this.d = (TextView) findViewById(R.id.tiejia_card_desc);
            this.e = (TextView) findViewById(R.id.tiejia_card_version);
            this.f = (TextView) findViewById(R.id.tiejia_card_company);
            this.g = (TextView) findViewById(R.id.tiejia_card_privacy);
            this.h = (TextView) findViewById(R.id.tiejia_card_permission);
            this.i = findViewById(R.id.tiejia_divider);
            this.j = findViewById(R.id.tiejia_card_arrow);
            this.k = findViewById(R.id.tiejia_card_line2);
            this.l = findViewById(R.id.tiejia_card_line3);
            this.g.setTag((byte) 16);
            this.h.setTag((byte) 17);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X003), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X002), BdUtilHelper.getDimens(getContext(), R.dimen.tbds0), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X002));
            l();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.n;
            if (tbRichTextTiebaPlusInfo != null && tbRichTextTiebaPlusInfo.P() != null) {
                this.o.i(this.b);
                this.o.J(this.p);
                v06 v06Var = this.p;
                if (v06Var != null && v06Var.isShowing()) {
                    this.p.onAttachedToWindow();
                }
                TiebaPlusInfo P = this.n.P();
                int intValue = P.jump_type.intValue();
                TiePlusStat.LandingType landingType = null;
                if (this.n.getType() == 36) {
                    switch (intValue) {
                        case 1:
                            landingType = TiePlusStat.LandingType.H5;
                            break;
                        case 2:
                            landingType = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                            if (!StringUtils.isNull(P.app_package) && !StringUtils.isNull(P.app_id)) {
                                this.o.a0(P.app_package, P.app_id, this.m, this.b);
                                ItemData itemData = new ItemData();
                                itemData.parseProto(P);
                                this.o.N(itemData);
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
                p(this.n.P(), this.n.getThreadData(), TiePlusStat.StatType.EXPOSE, landingType, null, this.n.O(), this.n.getForumId(), this.n.N());
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            EMManager.from(this).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                EMManager.from(tbImageView).setCorner(R.string.J_X05);
                this.a.setConrers(15);
                this.a.setPlaceHolder(2);
            }
            TextView textView = this.c;
            if (textView != null) {
                EMManager.from(textView).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107);
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                EMManager.from(textView2).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0109);
            }
            TextView textView3 = this.e;
            if (textView3 != null) {
                EMManager.from(textView3).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0109);
            }
            TextView textView4 = this.f;
            if (textView4 != null) {
                EMManager.from(textView4).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0109);
            }
            TextView textView5 = this.g;
            if (textView5 != null) {
                EMManager.from(textView5).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0109);
            }
            TextView textView6 = this.h;
            if (textView6 != null) {
                EMManager.from(textView6).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0109);
            }
            View view2 = this.i;
            if (view2 != null) {
                EMManager.from(view2).setBackGroundColor(R.color.CAM_X0110);
            }
            View view3 = this.j;
            if (view3 != null) {
                view3.setBackgroundResource(R.drawable.icon_ad_dislike_arrow20_right_n);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.setCurProgress(-1);
            this.a.reset();
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

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String buttonDescFromServer = getButtonDescFromServer();
            if (this.b != null && !StringUtils.isNull(buttonDescFromServer)) {
                this.b.post(new d(this, buttonDescFromServer));
            }
        }
    }

    public final void o() {
        TiePlusHelper tiePlusHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !StringUtils.isNull(getButtonDescFromServer()) && (tiePlusHelper = this.o) != null) {
            tiePlusHelper.I(this.n.P().button_desc);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            k(true);
            TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo = this.n;
            if (tbRichTextTiebaPlusInfo != null && tbRichTextTiebaPlusInfo.P() != null) {
                int intValue = this.n.P().jump_type.intValue();
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
                p(this.n.P(), this.n.getThreadData(), TiePlusStat.StatType.CLICK, landingType, null, this.n.O(), this.n.getForumId(), this.n.N());
            }
        }
    }

    public final void p(TiebaPlusInfo tiebaPlusInfo, ThreadData threadData, TiePlusStat.StatType statType, TiePlusStat.LandingType landingType, TiePlusStat.CardBtnType cardBtnType, String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{tiebaPlusInfo, threadData, statType, landingType, cardBtnType, str, str2, str3}) == null) {
            if (tiebaPlusInfo != null && threadData != null) {
                int a2 = TiePlusStat.a(tiebaPlusInfo, this);
                if (!threadData.isTiebaPlusAdThread) {
                    str4 = "";
                    str5 = str4;
                    str6 = str5;
                } else {
                    str4 = threadData.tiebaPlusOrderId;
                    str5 = threadData.tiebaPlusToken;
                    str6 = threadData.tiebaPlusExtraParam;
                }
                TiePlusStat.b(a2, statType, TiePlusStat.Locate.PB, TiePlusStat.ThreadType.IMAGE_TEXT, TiePlusStat.RichTextType.CARD, tiebaPlusInfo.target_type.intValue(), landingType, str, str2, str3, str4, cardBtnType);
                TiePlusStat.c(a2, statType, TiePlusStat.Locate.PB, str4, str5, str6, threadData.floorNum);
            }
        }
    }
}
