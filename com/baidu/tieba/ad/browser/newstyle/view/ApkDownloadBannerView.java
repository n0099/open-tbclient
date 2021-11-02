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
import b.a.e.e.p.l;
import b.a.r0.r.e.g.b;
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
/* loaded from: classes9.dex */
public class ApkDownloadBannerView extends LinearLayout implements b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int POS_LEFT = 0;
    public static final int POS_RIGHT = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f46668e;

    /* renamed from: f  reason: collision with root package name */
    public View f46669f;

    /* renamed from: g  reason: collision with root package name */
    public BannerDownloadProgressBar f46670g;

    /* renamed from: h  reason: collision with root package name */
    public BannerDownloadStateBar f46671h;

    /* renamed from: i  reason: collision with root package name */
    public BannerDownloadStateBar f46672i;
    public TextView j;
    public int k;
    public boolean l;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f46673a;
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
            f46673a = iArr;
            try {
                iArr[DownloadStatus.STATUS_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46673a[DownloadStatus.STATUS_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46673a[DownloadStatus.STATUS_INSTALL_SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46673a[DownloadStatus.STATUS_DOWNLOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46673a[DownloadStatus.STATUS_PAUSED.ordinal()] = 5;
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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f46669f = LayoutInflater.from(context).inflate(R.layout.ad_apk_download_banner_view, (ViewGroup) this, true);
            setOrientation(1);
            int e2 = l.e(getContext(), 22.0f);
            int e3 = l.e(getContext(), 11.0f);
            setPadding(e2, e3, e2, e3);
            this.f46670g = (BannerDownloadProgressBar) this.f46669f.findViewById(R.id.apk_download_progress);
            this.f46671h = (BannerDownloadStateBar) this.f46669f.findViewById(R.id.apk_download_state_left);
            this.f46672i = (BannerDownloadStateBar) this.f46669f.findViewById(R.id.apk_download_state_right);
            this.f46670g.setTextColor(Color.parseColor("#999999"));
            TextView textView = (TextView) this.f46669f.findViewById(R.id.download_waring);
            this.j = textView;
            textView.setVisibility(this.l ? 0 : 8);
        }
    }

    public final int b(DownloadStatus downloadStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadStatus)) == null) {
            int i2 = a.f46673a[downloadStatus.ordinal()];
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

    @Override // b.a.r0.r.e.g.b
    @NonNull
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (View) invokeV.objValue;
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getVisibility() == 0 : invokeV.booleanValue;
    }

    @Override // b.a.r0.r.e.g.b
    public boolean onClickIntercept(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r0.r.e.g.b
    public void onProgressChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f46670g.setProgress(i2);
        }
    }

    @Override // b.a.r0.r.e.g.b
    public void onStateAndProgressChanged(DownloadStatus downloadStatus, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadStatus, i2) == null) {
            int i3 = a.f46673a[downloadStatus.ordinal()];
            if (i3 == 1) {
                onProgressChanged(0);
                this.f46670g.setText("");
            } else if (i3 == 2 || i3 == 3) {
                onProgressChanged(this.f46668e);
                this.f46670g.setText("");
            } else if (i3 != 4 && i3 != 5) {
                onProgressChanged(0);
                this.f46670g.setText("");
            } else {
                onProgressChanged(i2);
            }
            onStatusChanged(downloadStatus);
        }
    }

    @Override // b.a.r0.r.e.g.b
    public void onStatusChanged(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, downloadStatus) == null) {
            getActionBar().setState(b(downloadStatus));
        }
    }

    public void setDownloadStateBarPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.k = i2;
            if (i2 == 0) {
                this.f46671h.setVisibility(0);
                this.f46672i.setVisibility(8);
            } else if (i2 != 1) {
                this.f46671h.setVisibility(0);
                this.f46672i.setVisibility(8);
            } else {
                this.f46671h.setVisibility(8);
                this.f46672i.setVisibility(0);
            }
        }
    }

    public void setDownloadWarningVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
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
    @Override // b.a.r0.r.e.g.b
    public BannerDownloadStateBar getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f46671h.getVisibility() == 0 ? this.f46671h : this.f46672i : (BannerDownloadStateBar) invokeV.objValue;
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
        this.f46668e = 100;
        this.k = 1;
        this.l = true;
        a(context);
        setDownloadStateBarPosition(1);
    }
}
