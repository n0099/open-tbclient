package com.baidu.tieba.ad.download.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.q.d.e;
import d.a.q0.q.d.g.b;
import d.a.q0.q.d.k.a;
/* loaded from: classes3.dex */
public class ApkDownloadView extends FrameLayout implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f13814e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadData f13815f;

    /* renamed from: g  reason: collision with root package name */
    public b.a f13816g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadStatus f13817h;

    /* renamed from: i  reason: collision with root package name */
    public String f13818i;
    public CustomMessageListener j;
    public CustomMessageListener k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDownloadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f13818i = getResources().getString(R.string.install_app);
        this.j = null;
        this.k = null;
        f(context);
    }

    @Override // d.a.q0.q.d.g.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && this.f13817h == DownloadStatus.STATUS_DOWNLOADING) {
            l(i2);
        }
    }

    @Override // d.a.q0.q.d.g.b
    public boolean b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            b.a aVar = this.f13816g;
            if (aVar != null) {
                return aVar.b(view);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.q.d.g.b
    public void c(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadStatus) == null) {
            this.f13817h = downloadStatus;
            DownloadData downloadData = this.f13815f;
            if (downloadData != null) {
                downloadData.setStatus(getDownloadStatus());
                k(this.f13815f);
            }
        }
    }

    @Override // d.a.q0.q.d.g.b
    public void d(DownloadStatus downloadStatus, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, downloadStatus, i2) == null) {
            c(downloadStatus);
            a(i2);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f13814e.b();
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.f13814e = (a) LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout_new, (ViewGroup) this, true).findViewById(R.id.feed_ad_operate_progress_button);
            g(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f13814e.a();
        }
    }

    @Override // d.a.q0.q.d.g.b
    public View getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (View) invokeV.objValue;
    }

    public int getDownloadStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            DownloadStatus downloadStatus = this.f13817h;
            if (downloadStatus == null || downloadStatus == DownloadStatus.STATUS_NONE) {
                return 6;
            }
            if (downloadStatus == DownloadStatus.STATUS_DOWNLOADING) {
                return 1;
            }
            if (downloadStatus == DownloadStatus.STATUS_PAUSED) {
                return 7;
            }
            if (downloadStatus == DownloadStatus.STATUS_SUCCESS) {
                return 3;
            }
            return downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
        }
        return invokeV.intValue;
    }

    @Override // d.a.q0.q.d.g.b
    @NonNull
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.j != null) {
                MessageManager.getInstance().registerListener(this.j);
            }
            if (this.k != null) {
                MessageManager.getInstance().registerListener(this.k);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            setOnClickInterceptListener(null);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.j != null) {
                MessageManager.getInstance().unRegisterListener(this.j);
            }
            if (this.k != null) {
                MessageManager.getInstance().unRegisterListener(this.k);
            }
        }
    }

    public void k(DownloadData downloadData) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, downloadData) == null) || downloadData == null) {
            return;
        }
        DownloadCacheKey g2 = e.c().g(downloadData.getId());
        AdDownloadData adDownloadData = null;
        if (g2 != null) {
            adDownloadData = d.a.q0.q.d.b.c().a(g2);
            i2 = adDownloadData.getPercent();
        } else {
            i2 = 0;
        }
        switch (downloadData.getStatus()) {
            case 1:
            case 5:
                l(i2);
                return;
            case 2:
            case 7:
                this.f13814e.setButtonText(getResources().getString(R.string.go_on_download), i2);
                return;
            case 3:
                this.f13814e.setButtonText(getResources().getString(R.string.immediately_install), i2);
                if (adDownloadData != null) {
                    adDownloadData.setFakePercent(0);
                    adDownloadData.setPercent(0);
                    return;
                }
                return;
            case 4:
            default:
                return;
            case 6:
                this.f13814e.setButtonText(this.f13818i, 0);
                return;
            case 8:
                this.f13814e.setButtonText(getResources().getString(R.string.immediately_open), 0);
                if (adDownloadData != null) {
                    adDownloadData.setFakePercent(0);
                    adDownloadData.setPercent(0);
                    return;
                }
                return;
        }
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f13814e.setProgress(Math.max(0, i2));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onAttachedToWindow();
            h();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDetachedFromWindow();
            j();
            i();
        }
    }

    public void setBackgroundSkin(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            a aVar = this.f13814e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setBackgroundSkin(i2);
            }
        }
    }

    public void setData(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, downloadData) == null) || downloadData == null) {
            return;
        }
        DownloadData downloadData2 = (DownloadData) downloadData.clone();
        this.f13815f = downloadData2;
        if (downloadData2 == null) {
            return;
        }
        setTag(downloadData2);
        k(downloadData);
    }

    public void setForegroundSkin(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            a aVar = this.f13814e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setForeground(i2);
            }
        }
    }

    public void setInitText(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f13818i = str;
            if (TextUtils.isEmpty(str) || (aVar = this.f13814e) == null) {
                return;
            }
            aVar.setInitText(str);
        }
    }

    public void setOnClickInterceptListener(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) {
            this.f13816g = aVar;
        }
    }

    public void setStrokeWidth(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            a aVar = this.f13814e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setStrokeWidth(i2);
            }
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f13814e.setButtonTextColor(i2);
        }
    }

    public void setTextColorInitSkin(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            a aVar = this.f13814e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setTextColorInitSkin(i2);
            }
        }
    }

    public void setTextColorSkin(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            a aVar = this.f13814e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setTextColorSkin(i2);
            }
        }
    }

    public void setTextNightColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.f13814e.setButtonTextNightColor(i2);
        }
    }

    public void setTextSize(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.f13814e.setButtonTextSize(i2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            super.setVisibility(i2);
            if (i2 == 0) {
                h();
            } else {
                j();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13818i = getResources().getString(R.string.install_app);
        this.j = null;
        this.k = null;
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDownloadView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13818i = getResources().getString(R.string.install_app);
        this.j = null;
        this.k = null;
        f(context);
    }
}
