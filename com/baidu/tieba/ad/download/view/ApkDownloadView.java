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
import c.a.r0.r.e.e;
import c.a.r0.r.e.g.b;
import c.a.r0.r.e.k.a;
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
/* loaded from: classes7.dex */
public class ApkDownloadView extends FrameLayout implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f49223e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadData f49224f;

    /* renamed from: g  reason: collision with root package name */
    public b.a f49225g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadStatus f49226h;

    /* renamed from: i  reason: collision with root package name */
    public String f49227i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f49228j;
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
        this.f49227i = getResources().getString(R.string.install_app);
        this.f49228j = null;
        this.k = null;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f49223e = (a) LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout_new, (ViewGroup) this, true).findViewById(R.id.feed_ad_operate_progress_button);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f49228j != null) {
                MessageManager.getInstance().registerListener(this.f49228j);
            }
            if (this.k != null) {
                MessageManager.getInstance().registerListener(this.k);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setOnClickInterceptListener(null);
        }
    }

    public void changeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f49223e.changeSkin();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f49228j != null) {
                MessageManager.getInstance().unRegisterListener(this.f49228j);
            }
            if (this.k != null) {
                MessageManager.getInstance().unRegisterListener(this.k);
            }
        }
    }

    public final void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f49223e.setProgress(Math.max(0, i2));
        }
    }

    @Override // c.a.r0.r.e.g.b
    public View getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (View) invokeV.objValue;
    }

    public int getDownloadStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            DownloadStatus downloadStatus = this.f49226h;
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

    @Override // c.a.r0.r.e.g.b
    @NonNull
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onAttachedToWindow();
            b();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f49223e.onChangeSkinType();
        }
    }

    @Override // c.a.r0.r.e.g.b
    public boolean onClickIntercept(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, view)) == null) {
            b.a aVar = this.f49225g;
            if (aVar != null) {
                return aVar.onClickIntercept(view);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDetachedFromWindow();
            d();
            c();
        }
    }

    @Override // c.a.r0.r.e.g.b
    public void onProgressChanged(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i2) == null) && this.f49226h == DownloadStatus.STATUS_DOWNLOADING) {
            e(i2);
        }
    }

    @Override // c.a.r0.r.e.g.b
    public void onStateAndProgressChanged(DownloadStatus downloadStatus, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, downloadStatus, i2) == null) {
            onStatusChanged(downloadStatus);
            onProgressChanged(i2);
        }
    }

    @Override // c.a.r0.r.e.g.b
    public void onStatusChanged(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, downloadStatus) == null) {
            this.f49226h = downloadStatus;
            DownloadData downloadData = this.f49224f;
            if (downloadData != null) {
                downloadData.setStatus(getDownloadStatus());
                updata(this.f49224f);
            }
        }
    }

    public void pause(DownloadData downloadData) {
        AdDownloadData a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, downloadData) == null) {
            DownloadCacheKey g2 = e.c().g(downloadData.getId());
            this.f49223e.setButtonText(getResources().getString(R.string.go_on_download), (g2 == null || (a2 = c.a.r0.r.e.b.c().a(g2)) == null) ? 0 : a2.getPercent());
        }
    }

    public void reset(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadData) == null) {
            this.f49223e.setButtonText(this.f49227i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            a aVar = this.f49223e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setBackgroundSkin(i2);
            }
        }
    }

    public void setData(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, downloadData) == null) || downloadData == null) {
            return;
        }
        DownloadData downloadData2 = (DownloadData) downloadData.clone();
        this.f49224f = downloadData2;
        if (downloadData2 == null) {
            return;
        }
        setTag(downloadData2);
        updata(downloadData);
    }

    public void setForegroundSkin(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            a aVar = this.f49223e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setForeground(i2);
            }
        }
    }

    public void setInitText(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.f49227i = str;
            if (TextUtils.isEmpty(str) || (aVar = this.f49223e) == null) {
                return;
            }
            aVar.setInitText(str);
        }
    }

    public void setOnClickInterceptListener(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            this.f49225g = aVar;
        }
    }

    public void setStrokeWidth(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            a aVar = this.f49223e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setStrokeWidth(i2);
            }
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.f49223e.setButtonTextColor(i2);
        }
    }

    public void setTextColorInitSkin(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            a aVar = this.f49223e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setTextColorInitSkin(i2);
            }
        }
    }

    public void setTextColorSkin(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            a aVar = this.f49223e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setTextColorSkin(i2);
            }
        }
    }

    public void setTextNightColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.f49223e.setButtonTextNightColor(i2);
        }
    }

    public void setTextSize(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.f49223e.setButtonTextSize(i2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            super.setVisibility(i2);
            if (i2 == 0) {
                b();
            } else {
                d();
            }
        }
    }

    public void startDownload(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, downloadData) == null) {
        }
    }

    public void updata(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, downloadData) == null) || downloadData == null) {
            return;
        }
        DownloadCacheKey g2 = e.c().g(downloadData.getId());
        AdDownloadData adDownloadData = null;
        int percent = (g2 == null || (adDownloadData = c.a.r0.r.e.b.c().a(g2)) == null) ? 0 : adDownloadData.getPercent();
        switch (downloadData.getStatus()) {
            case 1:
            case 5:
                e(percent);
                return;
            case 2:
            case 7:
                this.f49223e.setButtonText(getResources().getString(R.string.go_on_download), percent);
                return;
            case 3:
                this.f49223e.setButtonText(getResources().getString(R.string.immediately_install), percent);
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
                this.f49223e.setButtonText(this.f49227i, 0);
                return;
            case 8:
                this.f49223e.setButtonText(getResources().getString(R.string.immediately_open), 0);
                if (adDownloadData != null) {
                    adDownloadData.setFakePercent(0);
                    adDownloadData.setPercent(0);
                    return;
                }
                return;
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
        this.f49227i = getResources().getString(R.string.install_app);
        this.f49228j = null;
        this.k = null;
        a(context);
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
        this.f49227i = getResources().getString(R.string.install_app);
        this.f49228j = null;
        this.k = null;
        a(context);
    }
}
