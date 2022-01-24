package com.baidu.tieba.enterForum.hotuserrank.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.t0.v0.i.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class UserHeadCoverView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f42632e;

    /* renamed from: f  reason: collision with root package name */
    public View f42633f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f42634g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserHeadCoverView(@NonNull Context context) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f42632e = new ImageView(context);
            int f2 = n.f(context, R.dimen.tbds78);
            addView(this.f42632e, new FrameLayout.LayoutParams(f2, f2));
            this.f42633f = new View(context);
            int f3 = n.f(context, R.dimen.tbds158);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f3, f3);
            int f4 = n.f(context, R.dimen.tbds26);
            layoutParams.leftMargin = f4;
            layoutParams.topMargin = f4;
            addView(this.f42633f, layoutParams);
            this.f42634g = new ImageView(context);
            int f5 = n.f(context, R.dimen.tbds36);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(f5, f5);
            layoutParams2.gravity = 85;
            addView(this.f42634g, layoutParams2);
        }
    }

    public void setData(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        String str = bVar.a;
        if (str != null) {
            if (!str.equals("1") && !bVar.a.equals("2") && !bVar.a.equals("3")) {
                this.f42632e.setVisibility(8);
                this.f42633f.setVisibility(8);
            } else {
                this.f42632e.setVisibility(0);
                this.f42633f.setVisibility(0);
                if (bVar.a.equals("1")) {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f42632e, R.drawable.svg_icon_mask_first30, null);
                    this.f42633f.setBackground(SkinManager.getDrawable(R.drawable.shape_hot_user_yellow_circle));
                } else if (bVar.a.equals("2")) {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f42632e, R.drawable.svg_icon_mask_second30, null);
                    this.f42633f.setBackground(SkinManager.getDrawable(R.drawable.shape_hot_user_gray_circle));
                } else if (bVar.a.equals("3")) {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f42632e, R.drawable.svg_icon_mask_third30, null);
                    this.f42633f.setBackground(SkinManager.getDrawable(R.drawable.shape_hot_user_brown_circle));
                }
            }
        } else {
            this.f42632e.setVisibility(8);
            this.f42633f.setVisibility(8);
        }
        if (bVar.f24352g) {
            int f2 = n.f(TbadkApplication.getInst(), R.dimen.tbds36);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f2);
            layoutParams.gravity = 85;
            this.f42634g.setLayoutParams(layoutParams);
            this.f42634g.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f42634g, R.drawable.ic_icon_mask_v14_n_svg, null);
        } else if (bVar.f24353h) {
            int f3 = n.f(TbadkApplication.getInst(), R.dimen.tbds40);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(f3, f3);
            layoutParams2.gravity = 85;
            this.f42634g.setLayoutParams(layoutParams2);
            this.f42634g.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f42634g, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            this.f42634g.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserHeadCoverView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserHeadCoverView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a(context);
    }
}
