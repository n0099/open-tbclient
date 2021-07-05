package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f15546e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f15547f;

    /* renamed from: g  reason: collision with root package name */
    public int f15548g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f15549h;

    /* renamed from: i  reason: collision with root package name */
    public int f15550i;
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
        this.f15548g = 3;
        this.f15549h = null;
        this.f15550i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, null);
    }

    private Animation getClickRotateAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.f15549h == null) {
                this.f15549h = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
                this.f15549h.setInterpolator(new LinearInterpolator());
                this.f15549h.setFillAfter(true);
            }
            return this.f15549h;
        }
        return (Animation) invokeV.objValue;
    }

    public void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, attributeSet) == null) || context == null) {
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EntelechyPullUpRefreshView);
            this.f15550i = obtainStyledAttributes.getResourceId(R$styleable.EntelechyPullUpRefreshView_tb_pull_up_icon, R.drawable.icon_frs_reload);
            this.j = obtainStyledAttributes.getBoolean(R$styleable.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
            obtainStyledAttributes.recycle();
        }
        setOrientation(1);
        setGravity(1);
        SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
        if (this.j) {
            this.f15546e = new View(context);
            this.f15546e.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
            SkinManager.setBackgroundResource(this.f15546e, R.color.CAM_X0204);
            addView(this.f15546e);
        }
        this.f15547f = new TbImageView(context);
        int g2 = l.g(getContext(), R.dimen.ds48);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
        layoutParams.topMargin = l.g(getContext(), R.dimen.ds20);
        this.f15547f.setLayoutParams(layoutParams);
        SkinManager.setImageResource(this.f15547f, this.f15550i);
        addView(this.f15547f);
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f15548g == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f15546e, R.color.CAM_X0204);
        SkinManager.setImageResource(this.f15547f, this.f15550i);
        SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
        this.f15548g = i2;
    }

    public void setIconResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f15550i = i2;
            SkinManager.setImageResource(this.f15547f, i2);
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
        this.f15548g = 3;
        this.f15549h = null;
        this.f15550i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, attributeSet);
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
        this.f15548g = 3;
        this.f15549h = null;
        this.f15550i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, attributeSet);
    }
}
