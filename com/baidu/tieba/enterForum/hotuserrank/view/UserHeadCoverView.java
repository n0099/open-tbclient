package com.baidu.tieba.enterForum.hotuserrank.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.p0.l0.i.c.b;
/* loaded from: classes4.dex */
public class UserHeadCoverView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f14746e;

    /* renamed from: f  reason: collision with root package name */
    public View f14747f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f14748g;

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
            this.f14746e = new ImageView(context);
            int g2 = l.g(context, R.dimen.tbds78);
            addView(this.f14746e, new FrameLayout.LayoutParams(g2, g2));
            this.f14747f = new View(context);
            int g3 = l.g(context, R.dimen.tbds158);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g3, g3);
            int g4 = l.g(context, R.dimen.tbds26);
            layoutParams.leftMargin = g4;
            layoutParams.topMargin = g4;
            addView(this.f14747f, layoutParams);
            this.f14748g = new ImageView(context);
            int g5 = l.g(context, R.dimen.tbds36);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(g5, g5);
            layoutParams2.gravity = 85;
            addView(this.f14748g, layoutParams2);
        }
    }

    public void setData(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        String str = bVar.f59673a;
        if (str != null) {
            if (!str.equals("1") && !bVar.f59673a.equals("2") && !bVar.f59673a.equals("3")) {
                this.f14746e.setVisibility(8);
                this.f14747f.setVisibility(8);
            } else {
                this.f14746e.setVisibility(0);
                this.f14747f.setVisibility(0);
                if (bVar.f59673a.equals("1")) {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f14746e, R.drawable.svg_icon_mask_first30, null);
                    this.f14747f.setBackground(SkinManager.getDrawable(R.drawable.shape_hot_user_yellow_circle));
                } else if (bVar.f59673a.equals("2")) {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f14746e, R.drawable.svg_icon_mask_second30, null);
                    this.f14747f.setBackground(SkinManager.getDrawable(R.drawable.shape_hot_user_gray_circle));
                } else if (bVar.f59673a.equals("3")) {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f14746e, R.drawable.svg_icon_mask_third30, null);
                    this.f14747f.setBackground(SkinManager.getDrawable(R.drawable.shape_hot_user_brown_circle));
                }
            }
        } else {
            this.f14746e.setVisibility(8);
            this.f14747f.setVisibility(8);
        }
        if (bVar.f59679g) {
            int g2 = l.g(TbadkApplication.getInst(), R.dimen.tbds36);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 85;
            this.f14748g.setLayoutParams(layoutParams);
            this.f14748g.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f14748g, R.drawable.ic_icon_mask_v14_n_svg, null);
        } else if (bVar.f59680h) {
            int g3 = l.g(TbadkApplication.getInst(), R.dimen.tbds40);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(g3, g3);
            layoutParams2.gravity = 85;
            this.f14748g.setLayoutParams(layoutParams2);
            this.f14748g.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f14748g, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            this.f14748g.setVisibility(8);
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
