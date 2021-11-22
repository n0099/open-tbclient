package com.baidu.tieba.ad.browser.newstyle.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class BannerDownloadStateBar extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_DOWNLOADING = 1;
    public static final int STATE_FINISHED = 3;
    public static final int STATE_NONE = 0;
    public static final int STATE_OPEN_APP = 4;
    public static final int STATE_PAUSE = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f47542e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f47543f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f47544g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerDownloadStateBar(Context context) {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f47542e = LayoutInflater.from(getContext()).inflate(R.layout.ad_apk_download_action_view, (ViewGroup) this, true);
            setOrientation(0);
            setGravity(17);
            setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
            this.f47544g = (ImageView) this.f47542e.findViewById(R.id.apk_download_state_icon);
            this.f47543f = (TextView) this.f47542e.findViewById(R.id.apk_download_state_text);
            setState(0);
        }
    }

    public void setState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 == 0) {
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.f47544g.setVisibility(8);
                this.f47544g.setImageDrawable(null);
                this.f47543f.setText(R.string.ad_button_download_now);
                this.f47543f.setTextColor(Color.parseColor("#333333"));
            } else if (i2 == 1) {
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.f47544g.setVisibility(0);
                this.f47544g.setImageResource(R.drawable.ad_banner_download_pause);
                this.f47543f.setText(R.string.ad_button_pause);
                this.f47543f.setTextColor(Color.parseColor("#333333"));
            } else if (i2 == 2) {
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.f47544g.setVisibility(0);
                this.f47544g.setImageResource(R.drawable.ad_banner_download_resume);
                this.f47543f.setText(R.string.ad_button_resume);
                this.f47543f.setTextColor(Color.parseColor("#333333"));
            } else if (i2 == 3) {
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_open);
                this.f47544g.setVisibility(8);
                this.f47544g.setImageDrawable(null);
                this.f47543f.setText(R.string.ad_button_install);
                this.f47543f.setTextColor(Color.parseColor("#FFFFFF"));
            } else if (i2 != 4) {
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.f47544g.setVisibility(8);
                this.f47544g.setImageDrawable(null);
                this.f47543f.setText(R.string.ad_button_download_now);
                this.f47543f.setTextColor(Color.parseColor("#333333"));
            } else {
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_open);
                this.f47544g.setVisibility(8);
                this.f47544g.setImageDrawable(null);
                this.f47543f.setText(R.string.ad_button_open);
                this.f47543f.setTextColor(Color.parseColor("#FFFFFF"));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerDownloadStateBar(Context context, @Nullable AttributeSet attributeSet) {
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
    public BannerDownloadStateBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a();
    }
}
