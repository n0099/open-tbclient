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

    /* renamed from: e  reason: collision with root package name */
    public View f41947e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f41948f;

    /* renamed from: g  reason: collision with root package name */
    public int f41949g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f41950h;

    /* renamed from: i  reason: collision with root package name */
    public int f41951i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41952j;

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
        this.f41949g = 3;
        this.f41950h = null;
        this.f41951i = R.drawable.icon_frs_reload;
        this.f41952j = false;
        initUI(context, null);
    }

    private Animation getClickRotateAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.f41950h == null) {
                this.f41950h = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
                this.f41950h.setInterpolator(new LinearInterpolator());
                this.f41950h.setFillAfter(true);
            }
            return this.f41950h;
        }
        return (Animation) invokeV.objValue;
    }

    public void endRefreshAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f41948f.clearAnimation();
        }
    }

    public void initUI(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) || context == null) {
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.tb_pull_show_top_line, R.attr.tb_pull_up_icon});
            this.f41951i = obtainStyledAttributes.getResourceId(1, R.drawable.icon_frs_reload);
            this.f41952j = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        setOrientation(1);
        setGravity(1);
        SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
        if (this.f41952j) {
            this.f41947e = new View(context);
            this.f41947e.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
            SkinManager.setBackgroundResource(this.f41947e, R.color.CAM_X0204);
            addView(this.f41947e);
        }
        this.f41948f = new TbImageView(context);
        int f2 = n.f(getContext(), R.dimen.ds48);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
        layoutParams.topMargin = n.f(getContext(), R.dimen.ds20);
        this.f41948f.setLayoutParams(layoutParams);
        SkinManager.setImageResource(this.f41948f, this.f41951i);
        addView(this.f41948f);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f41949g == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f41947e, R.color.CAM_X0204);
        SkinManager.setImageResource(this.f41948f, this.f41951i);
        SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
        this.f41949g = i2;
    }

    public void setIconResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f41951i = i2;
            SkinManager.setImageResource(this.f41948f, i2);
        }
    }

    public void startRefreshAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f41948f.startAnimation(getClickRotateAnimation());
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
        this.f41949g = 3;
        this.f41950h = null;
        this.f41951i = R.drawable.icon_frs_reload;
        this.f41952j = false;
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
        this.f41949g = 3;
        this.f41950h = null;
        this.f41951i = R.drawable.icon_frs_reload;
        this.f41952j = false;
        initUI(context, attributeSet);
    }
}
