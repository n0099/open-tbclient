package com.baidu.tieba.funad.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.e.e.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.FunAdSdkSwitch;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.EBusinessProtocolView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes7.dex */
public class FunAdDownloadView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f51691e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdButton f51692f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51693g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f51694h;

    /* renamed from: i  reason: collision with root package name */
    public RankStarView f51695i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f51696j;
    public TextView k;
    public TextView l;
    public ViewGroup m;
    public TextView n;
    public TextView o;
    public TextView p;
    public EBusinessProtocolView q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f51697e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f51698f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FunAdDownloadView f51699g;

        public a(FunAdDownloadView funAdDownloadView, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdDownloadView, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51699g = funAdDownloadView;
            this.f51697e = activity;
            this.f51698f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                g.i(this.f51699g.q, this.f51697e);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_AUTHORITY_CLICK).param("obj_source", 6).param("obj_type", this.f51698f));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f51700e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f51701f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FunAdDownloadView f51702g;

        public b(FunAdDownloadView funAdDownloadView, c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdDownloadView, cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51702g = funAdDownloadView;
            this.f51700e = cVar;
            this.f51701f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.m.a.e(this.f51702g.f51691e, this.f51700e.d());
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_PRIVACY_CLICK).param("obj_source", 6).param("obj_type", this.f51701f));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f51703a;

        /* renamed from: b  reason: collision with root package name */
        public final float f51704b;

        /* renamed from: c  reason: collision with root package name */
        public final String f51705c;

        /* renamed from: d  reason: collision with root package name */
        public final String f51706d;

        /* renamed from: e  reason: collision with root package name */
        public final String f51707e;

        /* renamed from: f  reason: collision with root package name */
        public final String f51708f;

        /* renamed from: g  reason: collision with root package name */
        public final String f51709g;

        public c(@NonNull FunNativeAd funNativeAd) {
            NativeUnifiedADData nativeUnifiedADData;
            KsNativeAd ksNativeAd;
            TTNativeAd tTNativeAd;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funNativeAd};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
            if (channelNativeAds_6 != null && (tTNativeAd = channelNativeAds_6.csjNative) != null) {
                this.f51704b = tTNativeAd.getAppScore();
                this.f51705c = null;
                this.f51706d = null;
                this.f51707e = tTNativeAd.getSource();
                this.f51709g = null;
                this.f51708f = null;
                this.f51703a = tTNativeAd.getTitle();
            } else if (channelNativeAds_6 != null && (ksNativeAd = channelNativeAds_6.ksNative) != null) {
                this.f51703a = ksNativeAd.getAppName();
                this.f51704b = ksNativeAd.getAppScore() / 2.0f;
                this.f51705c = ksNativeAd.getAppDownloadCountDes();
                this.f51706d = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_version) + ksNativeAd.getAppVersion();
                this.f51707e = ksNativeAd.getCorporationName();
                this.f51709g = ksNativeAd.getPermissionInfo();
                this.f51708f = ksNativeAd.getAppPrivacyUrl();
            } else if (channelNativeAds_6 != null && (nativeUnifiedADData = channelNativeAds_6.gdtNative) != null) {
                this.f51703a = nativeUnifiedADData.getTitle();
                this.f51704b = nativeUnifiedADData.getAppScore() / 2.0f;
                this.f51705c = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_download_count, new Object[]{StringHelper.numberUniformFormat(nativeUnifiedADData.getDownloadCount())});
                this.f51706d = null;
                this.f51707e = null;
                this.f51709g = null;
                this.f51708f = null;
            } else {
                this.f51704b = 0.0f;
                this.f51705c = null;
                this.f51706d = null;
                this.f51707e = null;
                this.f51709g = null;
                this.f51708f = null;
                this.f51703a = "";
            }
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51709g : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51707e : (String) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51705c : (String) invokeV.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51708f : (String) invokeV.objValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f51706d : (String) invokeV.objValue;
        }

        public float f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f51704b : invokeV.floatValue;
        }

        public CharSequence g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f51703a : (CharSequence) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunAdDownloadView(Context context) {
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

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.f51691e).inflate(R.layout.fun_ad_download_info, (ViewGroup) this, true);
            this.f51692f = (FunAdButton) findViewById(R.id.fun_ad_download_button);
            this.f51693g = (TextView) findViewById(R.id.fun_ad_download_title);
            this.f51694h = (LinearLayout) findViewById(R.id.fun_ad_download_score_layout);
            this.f51695i = (RankStarView) findViewById(R.id.fun_ad_download_star);
            this.f51696j = (TextView) findViewById(R.id.fun_ad_download_score);
            this.k = (TextView) findViewById(R.id.fun_ad_download_count);
            this.l = (TextView) findViewById(R.id.fun_ad_download_version);
            this.m = (ViewGroup) findViewById(R.id.fun_download_line_2);
            this.n = (TextView) findViewById(R.id.fun_ad_download_company);
            this.o = (TextView) findViewById(R.id.fun_ad_download_privacy);
            this.p = (TextView) findViewById(R.id.fun_ad_download_authority);
            this.q = new EBusinessProtocolView(this.f51691e, EBusinessProtocolView.WindowType.TIP);
        }
    }

    public FunAdButton getDownloadButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51692f : (FunAdButton) invokeV.objValue;
    }

    public void onSkinChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            c.a.p0.s.u.c.d(this.f51693g).u(R.color.CAM_X0107);
            c.a.p0.s.u.c.d(this.l).u(R.color.CAM_X0109);
            c.a.p0.s.u.c.d(this.f51696j).u(R.color.CAM_X0109);
            c.a.p0.s.u.c.d(this.k).u(R.color.CAM_X0109);
            c.a.p0.s.u.c.d(this.n).u(R.color.CAM_X0109);
            c.a.p0.s.u.c.d(this.o).u(R.color.CAM_X0109);
            c.a.p0.s.u.c.d(this.p).u(R.color.CAM_X0109);
            this.f51692f.onChangeSkinType();
            this.f51695i.onChangeSkinType(i2);
        }
    }

    public void setViewData(FunNativeAd funNativeAd, Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, funNativeAd, activity, str) == null) {
            if (c.a.q0.x0.b.o(funNativeAd) && FunAdSdkSwitch.isOn()) {
                setVisibility(0);
                c cVar = new c(funNativeAd);
                this.f51693g.setText(cVar.g());
                float f2 = cVar.f();
                if (f2 > 2.5d) {
                    this.f51694h.setVisibility(0);
                    this.k.setVisibility(8);
                    this.f51696j.setText(String.valueOf(f2));
                    this.f51695i.setStarCount(f2);
                } else if (!TextUtils.isEmpty(cVar.c())) {
                    this.f51694h.setVisibility(8);
                    this.k.setVisibility(0);
                    this.k.setText(cVar.c());
                } else {
                    this.f51694h.setVisibility(8);
                    this.k.setVisibility(8);
                }
                if (!TextUtils.isEmpty(cVar.e())) {
                    this.l.setText(cVar.e());
                    this.l.setVisibility(0);
                } else {
                    this.l.setVisibility(8);
                }
                if (!TextUtils.isEmpty(cVar.b())) {
                    this.n.setText(cVar.b());
                    this.n.setVisibility(0);
                    this.n.requestLayout();
                } else {
                    this.n.setVisibility(8);
                }
                if (!TextUtils.isEmpty(cVar.a())) {
                    this.p.setVisibility(0);
                    this.q.setContent(cVar.a());
                    this.q.setTitle(this.f51691e.getString(R.string.fun_ad_privacy_dialog_title));
                    this.p.setOnClickListener(new a(this, activity, str));
                } else {
                    this.p.setVisibility(8);
                }
                if (!TextUtils.isEmpty(cVar.d())) {
                    this.o.setVisibility(0);
                    this.o.setOnClickListener(new b(this, cVar, str));
                } else {
                    this.o.setVisibility(8);
                }
                if ((this.n.getVisibility() & this.p.getVisibility() & this.o.getVisibility()) != 8) {
                    this.m.setVisibility(0);
                    return;
                } else {
                    this.m.setVisibility(8);
                    return;
                }
            }
            setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunAdDownloadView(Context context, AttributeSet attributeSet) {
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
    public FunAdDownloadView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f51691e = context;
        c();
    }
}
