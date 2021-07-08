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
import d.a.c.e.m.g;
/* loaded from: classes4.dex */
public class FunAdDownloadView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f16277e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdButton f16278f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16279g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16280h;

    /* renamed from: i  reason: collision with root package name */
    public RankStarView f16281i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ViewGroup m;
    public TextView n;
    public TextView o;
    public TextView p;
    public EBusinessProtocolView q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f16282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16283f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FunAdDownloadView f16284g;

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
            this.f16284g = funAdDownloadView;
            this.f16282e = activity;
            this.f16283f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                g.i(this.f16284g.q, this.f16282e);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_AUTHORITY_CLICK).param("obj_source", 6).param("obj_type", this.f16283f));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16285e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16286f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FunAdDownloadView f16287g;

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
            this.f16287g = funAdDownloadView;
            this.f16285e = cVar;
            this.f16286f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.o0.l.a.e(this.f16287g.f16277e, this.f16285e.d());
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_PRIVACY_CLICK).param("obj_source", 6).param("obj_type", this.f16286f));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f16288a;

        /* renamed from: b  reason: collision with root package name */
        public final float f16289b;

        /* renamed from: c  reason: collision with root package name */
        public final String f16290c;

        /* renamed from: d  reason: collision with root package name */
        public final String f16291d;

        /* renamed from: e  reason: collision with root package name */
        public final String f16292e;

        /* renamed from: f  reason: collision with root package name */
        public final String f16293f;

        /* renamed from: g  reason: collision with root package name */
        public final String f16294g;

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
                this.f16289b = tTNativeAd.getAppScore();
                this.f16290c = null;
                this.f16291d = null;
                this.f16292e = tTNativeAd.getSource();
                this.f16294g = null;
                this.f16293f = null;
                this.f16288a = tTNativeAd.getTitle();
            } else if (channelNativeAds_6 != null && (ksNativeAd = channelNativeAds_6.ksNative) != null) {
                this.f16288a = ksNativeAd.getAppName();
                this.f16289b = ksNativeAd.getAppScore() / 2.0f;
                this.f16290c = ksNativeAd.getAppDownloadCountDes();
                this.f16291d = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_version) + ksNativeAd.getAppVersion();
                this.f16292e = ksNativeAd.getCorporationName();
                this.f16294g = ksNativeAd.getPermissionInfo();
                this.f16293f = ksNativeAd.getAppPrivacyUrl();
            } else if (channelNativeAds_6 != null && (nativeUnifiedADData = channelNativeAds_6.gdtNative) != null) {
                this.f16288a = nativeUnifiedADData.getTitle();
                this.f16289b = nativeUnifiedADData.getAppScore() / 2.0f;
                this.f16290c = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_download_count, new Object[]{StringHelper.numberUniformFormat(nativeUnifiedADData.getDownloadCount())});
                this.f16291d = null;
                this.f16292e = null;
                this.f16294g = null;
                this.f16293f = null;
            } else {
                this.f16289b = 0.0f;
                this.f16290c = null;
                this.f16291d = null;
                this.f16292e = null;
                this.f16294g = null;
                this.f16293f = null;
                this.f16288a = "";
            }
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16294g : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16292e : (String) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16290c : (String) invokeV.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16293f : (String) invokeV.objValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16291d : (String) invokeV.objValue;
        }

        public float f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16289b : invokeV.floatValue;
        }

        public CharSequence g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16288a : (CharSequence) invokeV.objValue;
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
            LayoutInflater.from(this.f16277e).inflate(R.layout.fun_ad_download_info, (ViewGroup) this, true);
            this.f16278f = (FunAdButton) findViewById(R.id.fun_ad_download_button);
            this.f16279g = (TextView) findViewById(R.id.fun_ad_download_title);
            this.f16280h = (LinearLayout) findViewById(R.id.fun_ad_download_score_layout);
            this.f16281i = (RankStarView) findViewById(R.id.fun_ad_download_star);
            this.j = (TextView) findViewById(R.id.fun_ad_download_score);
            this.k = (TextView) findViewById(R.id.fun_ad_download_count);
            this.l = (TextView) findViewById(R.id.fun_ad_download_version);
            this.m = (ViewGroup) findViewById(R.id.fun_download_line_2);
            this.n = (TextView) findViewById(R.id.fun_ad_download_company);
            this.o = (TextView) findViewById(R.id.fun_ad_download_privacy);
            this.p = (TextView) findViewById(R.id.fun_ad_download_authority);
            this.q = new EBusinessProtocolView(this.f16277e, EBusinessProtocolView.WindowType.TIP);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(this);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            d.a.o0.r.u.c.d(this.f16279g).t(R.color.CAM_X0107);
            d.a.o0.r.u.c.d(this.l).t(R.color.CAM_X0109);
            d.a.o0.r.u.c.d(this.j).t(R.color.CAM_X0109);
            d.a.o0.r.u.c.d(this.k).t(R.color.CAM_X0109);
            d.a.o0.r.u.c.d(this.n).t(R.color.CAM_X0109);
            d.a.o0.r.u.c.d(this.o).t(R.color.CAM_X0109);
            d.a.o0.r.u.c.d(this.p).t(R.color.CAM_X0109);
            this.f16278f.g();
            this.f16281i.e(i2);
        }
    }

    public FunAdButton getDownloadButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16278f : (FunAdButton) invokeV.objValue;
    }

    public void setViewData(FunNativeAd funNativeAd, Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, funNativeAd, activity, str) == null) {
            if (d.a.p0.w0.b.j(funNativeAd) && FunAdSdkSwitch.isOn()) {
                setVisibility(0);
                c cVar = new c(funNativeAd);
                this.f16279g.setText(cVar.g());
                float f2 = cVar.f();
                if (f2 > 2.5d) {
                    this.f16280h.setVisibility(0);
                    this.k.setVisibility(8);
                    this.j.setText(String.valueOf(f2));
                    this.f16281i.setStarCount(f2);
                } else if (!TextUtils.isEmpty(cVar.c())) {
                    this.f16280h.setVisibility(8);
                    this.k.setVisibility(0);
                    this.k.setText(cVar.c());
                } else {
                    this.f16280h.setVisibility(8);
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
                    this.q.k(cVar.a());
                    this.q.o(this.f16277e.getString(R.string.fun_ad_privacy_dialog_title));
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
        this.f16277e = context;
        c();
    }
}
