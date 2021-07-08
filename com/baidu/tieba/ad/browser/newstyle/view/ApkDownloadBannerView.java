package com.baidu.tieba.ad.browser.newstyle.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.p0.q.d.g.b;
/* loaded from: classes3.dex */
public class ApkDownloadBannerView extends LinearLayout implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f13739e;

    /* renamed from: f  reason: collision with root package name */
    public View f13740f;

    /* renamed from: g  reason: collision with root package name */
    public BannerDownloadProgressBar f13741g;

    /* renamed from: h  reason: collision with root package name */
    public BannerDownloadStateBar f13742h;

    /* renamed from: i  reason: collision with root package name */
    public BannerDownloadStateBar f13743i;
    public TextView j;
    public int k;
    public boolean l;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13744a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-240785382, "Lcom/baidu/tieba/ad/browser/newstyle/view/ApkDownloadBannerView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-240785382, "Lcom/baidu/tieba/ad/browser/newstyle/view/ApkDownloadBannerView$a;");
                    return;
                }
            }
            int[] iArr = new int[DownloadStatus.values().length];
            f13744a = iArr;
            try {
                iArr[DownloadStatus.STATUS_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13744a[DownloadStatus.STATUS_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13744a[DownloadStatus.STATUS_INSTALL_SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13744a[DownloadStatus.STATUS_DOWNLOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13744a[DownloadStatus.STATUS_PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ApkDownloadBannerView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.p0.q.d.g.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f13741g.setProgress(i2);
        }
    }

    @Override // d.a.p0.q.d.g.b
    public boolean b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.p0.q.d.g.b
    public void c(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadStatus) == null) {
            getActionBar().setState(f(downloadStatus));
        }
    }

    @Override // d.a.p0.q.d.g.b
    public void d(DownloadStatus downloadStatus, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, downloadStatus, i2) == null) {
            int i3 = a.f13744a[downloadStatus.ordinal()];
            if (i3 == 1) {
                a(0);
                this.f13741g.setText("");
            } else if (i3 == 2 || i3 == 3) {
                a(this.f13739e);
                this.f13741g.setText("");
            } else if (i3 != 4 && i3 != 5) {
                a(0);
                this.f13741g.setText("");
            } else {
                a(i2);
            }
            c(downloadStatus);
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f13740f = LayoutInflater.from(context).inflate(R.layout.ad_apk_download_banner_view, (ViewGroup) this, true);
            setOrientation(1);
            int e2 = l.e(getContext(), 22.0f);
            int e3 = l.e(getContext(), 11.0f);
            setPadding(e2, e3, e2, e3);
            this.f13741g = (BannerDownloadProgressBar) this.f13740f.findViewById(R.id.apk_download_progress);
            this.f13742h = (BannerDownloadStateBar) this.f13740f.findViewById(R.id.apk_download_state_left);
            this.f13743i = (BannerDownloadStateBar) this.f13740f.findViewById(R.id.apk_download_state_right);
            this.f13741g.setTextColor(Color.parseColor("#999999"));
            TextView textView = (TextView) this.f13740f.findViewById(R.id.download_waring);
            this.j = textView;
            textView.setVisibility(this.l ? 0 : 8);
        }
    }

    public final int f(DownloadStatus downloadStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, downloadStatus)) == null) {
            int i2 = a.f13744a[downloadStatus.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return i2 != 5 ? 0 : 2;
                    }
                    return 1;
                }
                return 4;
            }
            return 3;
        }
        return invokeL.intValue;
    }

    @Override // d.a.p0.q.d.g.b
    @NonNull
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (View) invokeV.objValue;
    }

    public void setDownloadStateBarPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.k = i2;
            if (i2 == 0) {
                this.f13742h.setVisibility(0);
                this.f13743i.setVisibility(8);
            } else if (i2 != 1) {
                this.f13742h.setVisibility(0);
                this.f13743i.setVisibility(8);
            } else {
                this.f13742h.setVisibility(8);
                this.f13743i.setVisibility(0);
            }
        }
    }

    public void setDownloadWarningVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.l = z;
            this.j.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.q.d.g.b
    public BannerDownloadStateBar getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f13742h.getVisibility() == 0 ? this.f13742h : this.f13743i : (BannerDownloadStateBar) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f13739e = 100;
        this.k = 1;
        this.l = true;
        e(context);
        setDownloadStateBarPosition(1);
    }
}
