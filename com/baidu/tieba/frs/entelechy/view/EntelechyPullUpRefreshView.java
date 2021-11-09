package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import b.a.e.e.p.l;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.i1;
import b.a.r0.x0.z0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f48469e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f48470f;

    /* renamed from: g  reason: collision with root package name */
    public int f48471g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f48472h;

    /* renamed from: i  reason: collision with root package name */
    public int f48473i;
    public boolean j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntelechyPullUpRefreshView(Context context) {
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
        this.f48471g = 3;
        this.f48472h = null;
        this.f48473i = d1.icon_frs_reload;
        this.j = false;
        initUI(context, null);
    }

    private Animation getClickRotateAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.f48472h == null) {
                this.f48472h = AnimationUtils.loadAnimation(getContext(), z0.refresh_rotate);
                this.f48472h.setInterpolator(new LinearInterpolator());
                this.f48472h.setFillAfter(true);
            }
            return this.f48472h;
        }
        return (Animation) invokeV.objValue;
    }

    public void endRefreshAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f48470f.clearAnimation();
        }
    }

    public void initUI(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) || context == null) {
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i1.EntelechyPullUpRefreshView);
            this.f48473i = obtainStyledAttributes.getResourceId(i1.EntelechyPullUpRefreshView_tb_pull_up_icon, d1.icon_frs_reload);
            this.j = obtainStyledAttributes.getBoolean(i1.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
            obtainStyledAttributes.recycle();
        }
        setOrientation(1);
        setGravity(1);
        SkinManager.setBackgroundResource(this, b1.cp_bg_line_d_alpha98);
        if (this.j) {
            this.f48469e = new View(context);
            this.f48469e.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(c1.ds1)));
            SkinManager.setBackgroundResource(this.f48469e, b1.CAM_X0204);
            addView(this.f48469e);
        }
        this.f48470f = new TbImageView(context);
        int g2 = l.g(getContext(), c1.ds48);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
        layoutParams.topMargin = l.g(getContext(), c1.ds20);
        this.f48470f.setLayoutParams(layoutParams);
        SkinManager.setImageResource(this.f48470f, this.f48473i);
        addView(this.f48470f);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f48471g == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f48469e, b1.CAM_X0204);
        SkinManager.setImageResource(this.f48470f, this.f48473i);
        SkinManager.setBackgroundResource(this, b1.cp_bg_line_d_alpha98);
        this.f48471g = i2;
    }

    public void setIconResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f48473i = i2;
            SkinManager.setImageResource(this.f48470f, i2);
        }
    }

    public void startRefreshAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f48470f.startAnimation(getClickRotateAnimation());
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
        this.f48471g = 3;
        this.f48472h = null;
        this.f48473i = d1.icon_frs_reload;
        this.j = false;
        initUI(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f48471g = 3;
        this.f48472h = null;
        this.f48473i = d1.icon_frs_reload;
        this.j = false;
        initUI(context, attributeSet);
    }
}
