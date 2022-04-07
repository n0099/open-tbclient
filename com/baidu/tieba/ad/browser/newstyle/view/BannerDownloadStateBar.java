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
/* loaded from: classes3.dex */
public class BannerDownloadStateBar extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public ImageView c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerDownloadStateBar(Context context) {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0065, (ViewGroup) this, true);
            setOrientation(0);
            setGravity(17);
            setBackgroundResource(R.drawable.obfuscated_res_0x7f0800be);
            this.c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090281);
            this.b = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090284);
            setState(0);
        }
    }

    public void setState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i == 0) {
                setBackgroundResource(R.drawable.obfuscated_res_0x7f0800be);
                this.c.setVisibility(8);
                this.c.setImageDrawable(null);
                this.b.setText(R.string.obfuscated_res_0x7f0f009b);
                this.b.setTextColor(Color.parseColor("#333333"));
            } else if (i == 1) {
                setBackgroundResource(R.drawable.obfuscated_res_0x7f0800be);
                this.c.setVisibility(0);
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f0800c0);
                this.b.setText(R.string.obfuscated_res_0x7f0f009e);
                this.b.setTextColor(Color.parseColor("#333333"));
            } else if (i == 2) {
                setBackgroundResource(R.drawable.obfuscated_res_0x7f0800be);
                this.c.setVisibility(0);
                this.c.setImageResource(R.drawable.obfuscated_res_0x7f0800c1);
                this.b.setText(R.string.obfuscated_res_0x7f0f009f);
                this.b.setTextColor(Color.parseColor("#333333"));
            } else if (i == 3) {
                setBackgroundResource(R.drawable.obfuscated_res_0x7f0800bf);
                this.c.setVisibility(8);
                this.c.setImageDrawable(null);
                this.b.setText(R.string.obfuscated_res_0x7f0f009c);
                this.b.setTextColor(Color.parseColor("#FFFFFF"));
            } else if (i != 4) {
                setBackgroundResource(R.drawable.obfuscated_res_0x7f0800be);
                this.c.setVisibility(8);
                this.c.setImageDrawable(null);
                this.b.setText(R.string.obfuscated_res_0x7f0f009b);
                this.b.setTextColor(Color.parseColor("#333333"));
            } else {
                setBackgroundResource(R.drawable.obfuscated_res_0x7f0800bf);
                this.c.setVisibility(8);
                this.c.setImageDrawable(null);
                this.b.setText(R.string.obfuscated_res_0x7f0f009d);
                this.b.setTextColor(Color.parseColor("#FFFFFF"));
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
    public BannerDownloadStateBar(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        a();
    }
}
