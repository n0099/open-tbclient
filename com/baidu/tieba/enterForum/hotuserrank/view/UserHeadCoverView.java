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
import com.repackage.l76;
import com.repackage.qi;
/* loaded from: classes3.dex */
public class UserHeadCoverView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public View b;
    public ImageView c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserHeadCoverView(@NonNull Context context) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = new ImageView(context);
            int f = qi.f(context, R.dimen.tbds78);
            addView(this.a, new FrameLayout.LayoutParams(f, f));
            this.b = new View(context);
            int f2 = qi.f(context, R.dimen.tbds158);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f2);
            int f3 = qi.f(context, R.dimen.tbds26);
            layoutParams.leftMargin = f3;
            layoutParams.topMargin = f3;
            addView(this.b, layoutParams);
            this.c = new ImageView(context);
            int f4 = qi.f(context, R.dimen.tbds36);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(f4, f4);
            layoutParams2.gravity = 85;
            addView(this.c, layoutParams2);
        }
    }

    public void setData(l76 l76Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l76Var) == null) || l76Var == null) {
            return;
        }
        String str = l76Var.a;
        if (str != null) {
            if (!str.equals("1") && !l76Var.a.equals("2") && !l76Var.a.equals("3")) {
                this.a.setVisibility(8);
                this.b.setVisibility(8);
            } else {
                this.a.setVisibility(0);
                this.b.setVisibility(0);
                if (l76Var.a.equals("1")) {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.a, R.drawable.obfuscated_res_0x7f0810ef, null);
                    this.b.setBackground(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0810c9));
                } else if (l76Var.a.equals("2")) {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.a, R.drawable.obfuscated_res_0x7f0810f0, null);
                    this.b.setBackground(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0810c8));
                } else if (l76Var.a.equals("3")) {
                    SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.a, R.drawable.obfuscated_res_0x7f0810f1, null);
                    this.b.setBackground(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0810c7));
                }
            }
        } else {
            this.a.setVisibility(8);
            this.b.setVisibility(8);
        }
        if (l76Var.g) {
            int f = qi.f(TbadkApplication.getInst(), R.dimen.tbds36);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f, f);
            layoutParams.gravity = 85;
            this.c.setLayoutParams(layoutParams);
            this.c.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.c, R.drawable.obfuscated_res_0x7f0805e4, null);
        } else if (l76Var.h) {
            int f2 = qi.f(TbadkApplication.getInst(), R.dimen.tbds40);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(f2, f2);
            layoutParams2.gravity = 85;
            this.c.setLayoutParams(layoutParams2);
            this.c.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.c, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            this.c.setVisibility(8);
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserHeadCoverView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        a(context);
    }
}
