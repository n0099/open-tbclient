package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f32464b;

    /* renamed from: c  reason: collision with root package name */
    public int f32465c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f32466d;

    /* renamed from: e  reason: collision with root package name */
    public int f32467e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32468f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntelechyPullUpRefreshView(Context context) {
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
        this.f32465c = 3;
        this.f32466d = null;
        this.f32467e = R.drawable.icon_frs_reload;
        this.f32468f = false;
        a(context, null);
    }

    private Animation getClickRotateAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.f32466d == null) {
                this.f32466d = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f0100f8);
                this.f32466d.setInterpolator(new LinearInterpolator());
                this.f32466d.setFillAfter(true);
            }
            return this.f32466d;
        }
        return (Animation) invokeV.objValue;
    }

    public void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, attributeSet) == null) || context == null) {
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0405f2, R.attr.obfuscated_res_0x7f0405f3});
            this.f32467e = obtainStyledAttributes.getResourceId(1, R.drawable.icon_frs_reload);
            this.f32468f = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        setOrientation(1);
        setGravity(1);
        SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
        if (this.f32468f) {
            this.a = new View(context);
            this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070198)));
            SkinManager.setBackgroundResource(this.a, R.color.CAM_X0204);
            addView(this.a);
        }
        this.f32464b = new TbImageView(context);
        int f2 = n.f(getContext(), R.dimen.obfuscated_res_0x7f0702c4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
        layoutParams.topMargin = n.f(getContext(), R.dimen.obfuscated_res_0x7f0701d5);
        this.f32464b.setLayoutParams(layoutParams);
        SkinManager.setImageResource(this.f32464b, this.f32467e);
        addView(this.f32464b);
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.f32465c == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.a, R.color.CAM_X0204);
        SkinManager.setImageResource(this.f32464b, this.f32467e);
        SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
        this.f32465c = i;
    }

    public void setIconResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f32467e = i;
            SkinManager.setImageResource(this.f32464b, i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
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
        this.f32465c = 3;
        this.f32466d = null;
        this.f32467e = R.drawable.icon_frs_reload;
        this.f32468f = false;
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
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
        this.f32465c = 3;
        this.f32466d = null;
        this.f32467e = R.drawable.icon_frs_reload;
        this.f32468f = false;
        a(context, attributeSet);
    }
}
