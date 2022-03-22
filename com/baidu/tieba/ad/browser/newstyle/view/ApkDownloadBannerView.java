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
import c.a.a0.j.f.i;
import c.a.d.f.p.n;
import c.a.p0.x.g.g.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ApkDownloadBannerView extends LinearLayout implements b, i<View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public View f31113b;

    /* renamed from: c  reason: collision with root package name */
    public BannerDownloadProgressBar f31114c;

    /* renamed from: d  reason: collision with root package name */
    public BannerDownloadStateBar f31115d;

    /* renamed from: e  reason: collision with root package name */
    public BannerDownloadStateBar f31116e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f31117f;

    /* renamed from: g  reason: collision with root package name */
    public int f31118g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31119h;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f31120b;
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
            int[] iArr = new int[AdDownloadStatus.values().length];
            f31120b = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31120b[AdDownloadStatus.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31120b[AdDownloadStatus.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31120b[AdDownloadStatus.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31120b[AdDownloadStatus.INSTALLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[DownloadStatus.values().length];
            a = iArr2;
            try {
                iArr2[DownloadStatus.STATUS_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[DownloadStatus.STATUS_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[DownloadStatus.STATUS_INSTALL_SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[DownloadStatus.STATUS_DOWNLOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[DownloadStatus.STATUS_PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.x.g.g.b
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.f31114c.setProgress(i);
        }
    }

    @Override // c.a.p0.x.g.g.b
    public boolean b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.a0.j.f.i
    public void c(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) {
        }
    }

    @Override // c.a.p0.x.g.g.b
    public void d(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadStatus) == null) {
            getActionBar().setState(h(downloadStatus));
        }
    }

    @Override // c.a.p0.x.g.g.b
    public void e(DownloadStatus downloadStatus, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, downloadStatus, i) == null) {
            int i2 = a.a[downloadStatus.ordinal()];
            if (i2 == 1) {
                a(0);
                this.f31114c.setText("");
            } else if (i2 == 2 || i2 == 3) {
                a(this.a);
                this.f31114c.setText("");
            } else if (i2 != 4 && i2 != 5) {
                a(0);
                this.f31114c.setText("");
            } else {
                a(i);
            }
            d(downloadStatus);
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.f31113b = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0064, (ViewGroup) this, true);
            setOrientation(1);
            int d2 = n.d(getContext(), 22.0f);
            int d3 = n.d(getContext(), 11.0f);
            setPadding(d2, d3, d2, d3);
            this.f31114c = (BannerDownloadProgressBar) this.f31113b.findViewById(R.id.obfuscated_res_0x7f090276);
            this.f31115d = (BannerDownloadStateBar) this.f31113b.findViewById(R.id.obfuscated_res_0x7f09027a);
            this.f31116e = (BannerDownloadStateBar) this.f31113b.findViewById(R.id.obfuscated_res_0x7f09027b);
            this.f31114c.setTextColor(Color.parseColor("#999999"));
            TextView textView = (TextView) this.f31113b.findViewById(R.id.obfuscated_res_0x7f09082d);
            this.f31117f = textView;
            textView.setVisibility(this.f31119h ? 0 : 8);
        }
    }

    public final int g(AdDownloadStatus adDownloadStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, adDownloadStatus)) == null) {
            int i = a.f31120b[adDownloadStatus.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return i != 5 ? 0 : 4;
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    @Override // c.a.p0.x.g.g.b, c.a.a0.j.f.i
    @NonNull
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final int h(DownloadStatus downloadStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, downloadStatus)) == null) {
            int i = a.a[downloadStatus.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return i != 5 ? 0 : 2;
                    }
                    return 1;
                }
                return 4;
            }
            return 3;
        }
        return invokeL.intValue;
    }

    public void setDownloadStateBarPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f31118g = i;
            if (i == 0) {
                this.f31115d.setVisibility(0);
                this.f31116e.setVisibility(8);
            } else if (i != 1) {
                this.f31115d.setVisibility(0);
                this.f31116e.setVisibility(8);
            } else {
                this.f31115d.setVisibility(8);
                this.f31116e.setVisibility(0);
            }
        }
    }

    public void setDownloadWarningVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f31119h = z;
            this.f31117f.setVisibility(z ? 0 : 8);
        }
    }

    @Override // c.a.a0.j.f.i
    public void update(String str, @NonNull c.a.a0.j.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, aVar) == null) {
            a((int) (Math.max(aVar.i, aVar.j) * 100.0f));
            getActionBar().setState(g(aVar.f1246c));
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.x.g.g.b
    public BannerDownloadStateBar getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31115d.getVisibility() == 0 ? this.f31115d : this.f31116e : (BannerDownloadStateBar) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = 100;
        this.f31118g = 1;
        this.f31119h = true;
        f(context);
        setDownloadStateBarPosition(1);
    }
}
