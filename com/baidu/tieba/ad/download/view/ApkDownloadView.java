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
import com.repackage.hk0;
import com.repackage.ij5;
import com.repackage.lj5;
import com.repackage.oj5;
import com.repackage.rg5;
import com.repackage.rj0;
import com.repackage.xj5;
/* loaded from: classes3.dex */
public class ApkDownloadView extends FrameLayout implements oj5, hk0<View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xj5 a;
    public DownloadData b;
    public oj5.a c;
    public DownloadStatus d;
    public String e;
    public CustomMessageListener f;
    public CustomMessageListener g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = getResources().getString(R.string.obfuscated_res_0x7f0f08e8);
        this.f = null;
        this.g = null;
        g(context);
    }

    @Override // com.repackage.oj5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.d == DownloadStatus.STATUS_DOWNLOADING) {
            m(i);
        }
    }

    @Override // com.repackage.oj5
    public boolean b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            oj5.a aVar = this.c;
            if (aVar != null) {
                return aVar.b(view2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.hk0
    public void c(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) {
        }
    }

    @Override // com.repackage.oj5
    public void d(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadStatus) == null) {
            this.d = downloadStatus;
            DownloadData downloadData = this.b;
            if (downloadData != null) {
                downloadData.setStatus(getDownloadStatus());
                l(this.b);
            }
        }
    }

    @Override // com.repackage.oj5
    public void e(DownloadStatus downloadStatus, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, downloadStatus, i) == null) {
            d(downloadStatus);
            a(i);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.b();
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.a = (xj5) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0121, (ViewGroup) this, true).findViewById(R.id.obfuscated_res_0x7f090989);
            h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.repackage.oj5
    public View getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (View) invokeV.objValue;
    }

    public int getDownloadStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            DownloadStatus downloadStatus = this.d;
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

    @Override // com.repackage.oj5, com.repackage.hk0
    @NonNull
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (View) invokeV.objValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.a.a();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.f != null) {
                MessageManager.getInstance().registerListener(this.f);
            }
            if (this.g != null) {
                MessageManager.getInstance().registerListener(this.g);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            setOnClickInterceptListener(null);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f != null) {
                MessageManager.getInstance().unRegisterListener(this.f);
            }
            if (this.g != null) {
                MessageManager.getInstance().unRegisterListener(this.g);
            }
        }
    }

    public void l(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, downloadData) == null) || downloadData == null || rg5.h().y()) {
            return;
        }
        DownloadCacheKey h = lj5.d().h(downloadData.getId());
        AdDownloadData adDownloadData = null;
        int percent = (h == null || (adDownloadData = ij5.c().a(h)) == null) ? 0 : adDownloadData.getPercent();
        switch (downloadData.getStatus()) {
            case 1:
            case 5:
                m(percent);
                return;
            case 2:
            case 7:
                this.a.setButtonText(getResources().getString(R.string.obfuscated_res_0x7f0f07ab), percent);
                return;
            case 3:
                this.a.setButtonText(getResources().getString(R.string.obfuscated_res_0x7f0f08c8), percent);
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
                this.a.setButtonText(this.e, 0);
                return;
            case 8:
                this.a.setButtonText(getResources().getString(R.string.obfuscated_res_0x7f0f08c9), 0);
                if (adDownloadData != null) {
                    adDownloadData.setFakePercent(0);
                    adDownloadData.setPercent(0);
                    return;
                }
                return;
        }
    }

    public final void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.a.setProgress(Math.max(0, i));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onAttachedToWindow();
            i();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDetachedFromWindow();
            k();
            j();
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            xj5 xj5Var = this.a;
            if (xj5Var instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) xj5Var).setBackgroundSkin(i);
            }
        }
    }

    public void setData(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, downloadData) == null) || downloadData == null) {
            return;
        }
        DownloadData downloadData2 = (DownloadData) downloadData.clone();
        this.b = downloadData2;
        if (downloadData2 == null) {
            return;
        }
        setTag(downloadData2);
        l(downloadData);
    }

    public void setForegroundSkin(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            xj5 xj5Var = this.a;
            if (xj5Var instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) xj5Var).setForeground(i);
            }
        }
    }

    public void setInitText(String str) {
        xj5 xj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.e = str;
            if (TextUtils.isEmpty(str) || (xj5Var = this.a) == null) {
                return;
            }
            xj5Var.setInitText(str);
        }
    }

    public void setOnClickInterceptListener(oj5.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            this.c = aVar;
        }
    }

    public void setStrokeWidth(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            xj5 xj5Var = this.a;
            if (xj5Var instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) xj5Var).setStrokeWidth(i);
            }
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.a.setButtonTextColor(i);
        }
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            xj5 xj5Var = this.a;
            if (xj5Var instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) xj5Var).setTextColorInitSkin(i);
            }
        }
    }

    public void setTextColorSkin(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            xj5 xj5Var = this.a;
            if (xj5Var instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) xj5Var).setTextColorSkin(i);
            }
        }
    }

    public void setTextNightColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.a.setButtonTextNightColor(i);
        }
    }

    public void setTextSize(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.a.setButtonTextSize(i);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            super.setVisibility(i);
            if (i == 0) {
                i();
            } else {
                k();
            }
        }
    }

    @Override // com.repackage.hk0
    public void update(String str, @NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, str, rj0Var) == null) {
            this.a.setButtonText(str, (int) Math.max(rj0Var.i * 100.0f, rj0Var.j * 100.0f));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = getResources().getString(R.string.obfuscated_res_0x7f0f08e8);
        this.f = null;
        this.g = null;
        g(context);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = getResources().getString(R.string.obfuscated_res_0x7f0f08e8);
        this.f = null;
        this.g = null;
        g(context);
    }
}
