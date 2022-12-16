package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.am6;
import com.baidu.tieba.fv6;
import com.baidu.tieba.yi;
import com.baidu.tieba.zl6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class TabItemView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fv6 a;
    public int b;
    public boolean c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabItemView(Context context, fv6 fv6Var, int i, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fv6Var, Integer.valueOf(i), Boolean.valueOf(z)};
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
        this.b = 0;
        this.d = 0;
        this.a = fv6Var;
        this.c = z;
        b(context, i);
    }

    private int getSpaceWidth() {
        InterceptResult invokeV;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            if (compoundDrawables != null && (drawable = compoundDrawables[2]) != null) {
                float measureText = getPaint().measureText(getText().toString());
                return getWidth() - ((((int) measureText) + drawable.getIntrinsicWidth()) + getCompoundDrawablePadding());
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setState(this.b);
        }
    }

    public int getDrawableWidth() {
        InterceptResult invokeV;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            if (compoundDrawables != null && compoundDrawables.length >= 3 && (drawable = compoundDrawables[2]) != null) {
                return drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int getTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            fv6 fv6Var = this.a;
            if (fv6Var == null) {
                return -1;
            }
            return fv6Var.b;
        }
        return invokeV.intValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            fv6 fv6Var = this.a;
            if (fv6Var == null) {
                return null;
            }
            return fv6Var.d;
        }
        return (String) invokeV.objValue;
    }

    public final void b(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
            if (this.c) {
                setPadding(0, yi.g(getContext(), R.dimen.tbds20), 0, 0);
                setTextSize(0, yi.g(context, R.dimen.tbds42));
            } else {
                setGravity(17);
            }
            setSingleLine();
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
            fv6 fv6Var = this.a;
            if (fv6Var != null) {
                setText(fv6Var.a);
            }
            a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            int spaceWidth = getSpaceWidth();
            if (spaceWidth >= 0) {
                canvas.translate(spaceWidth / 2.0f, 0.0f);
            }
            super.onDraw(canvas);
        }
    }

    public void setForNewFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.c = z;
        }
    }

    public void setSelectItemColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.d = i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int spaceWidth = getSpaceWidth();
            if (spaceWidth >= 0) {
                if (this.c) {
                    setPadding(0, yi.g(getContext(), R.dimen.obfuscated_res_0x7f0701be), spaceWidth, 0);
                } else {
                    setPadding(0, 0, spaceWidth, 0);
                }
            }
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    public void setState(int i) {
        am6 am6Var;
        List<zl6> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            fv6 fv6Var = this.a;
            if (fv6Var != null && (am6Var = fv6Var.c) != null && (list = am6Var.b) != null && list.size() > 0) {
                int i2 = -yi.g(getContext(), R.dimen.tbds20);
                if (!this.c) {
                    i2 = 0;
                }
                if (i == 2) {
                    Drawable drawable = SkinManager.getDrawable(R.drawable.icon_toolbar_arrow_up);
                    drawable.setBounds(0, i2, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i2);
                    setCompoundDrawables(null, null, drawable, null);
                } else {
                    Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_arrow_gray_down);
                    drawable2.setBounds(0, i2, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i2);
                    setCompoundDrawables(null, null, drawable2, null);
                }
                setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
            }
            if (this.c) {
                SkinManager.setViewTextColor(this, R.color.CAM_X0105, 1);
            } else {
                if (i != 1 && i != 2) {
                    SkinManager.setViewTextColor(this, R.color.CAM_X0106, 1);
                } else {
                    int i3 = this.d;
                    if (i3 == 0) {
                        SkinManager.setViewTextColor(this, R.color.CAM_X0302, 1);
                    } else {
                        SkinManager.setViewTextColor(this, i3, 1);
                    }
                }
                setGravity(17);
            }
            this.b = i;
            invalidate();
        }
    }
}
