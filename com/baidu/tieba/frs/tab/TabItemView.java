package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.r0.x0.d1;
import c.a.r0.x0.e1;
import c.a.r0.x0.l2.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class TabItemView extends TextView {
    public static /* synthetic */ Interceptable $ic = null;
    public static int STATE_CHECKED = 1;
    public static int STATE_EXPANDED = 2;
    public static int STATE_UNCHECKED;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f51634e;

    /* renamed from: f  reason: collision with root package name */
    public int f51635f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51636g;

    /* renamed from: h  reason: collision with root package name */
    public int f51637h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1463303714, "Lcom/baidu/tieba/frs/tab/TabItemView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1463303714, "Lcom/baidu/tieba/frs/tab/TabItemView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabItemView(Context context, e eVar, int i2, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, eVar, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51635f = STATE_UNCHECKED;
        this.f51637h = 0;
        this.f51634e = eVar;
        this.f51636g = z;
        a(context, i2);
    }

    private int getSpaceWidth() {
        InterceptResult invokeV;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            if (compoundDrawables == null || (drawable = compoundDrawables[2]) == null) {
                return -1;
            }
            float measureText = getPaint().measureText(getText().toString());
            return getWidth() - ((((int) measureText) + drawable.getIntrinsicWidth()) + getCompoundDrawablePadding());
        }
        return invokeV.intValue;
    }

    public final void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            if (this.f51636g) {
                setPadding(0, l.g(getContext(), R.dimen.tbds20), 0, 0);
                setTextSize(0, l.g(context, R.dimen.tbds42));
            } else {
                setGravity(17);
            }
            setSingleLine();
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
            e eVar = this.f51634e;
            if (eVar != null) {
                setText(eVar.f27195a);
            }
            changeSkinType();
        }
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setState(this.f51635f);
        }
    }

    public int getDrawableWidth() {
        InterceptResult invokeV;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            if (compoundDrawables == null || compoundDrawables.length < 3 || (drawable = compoundDrawables[2]) == null) {
                return 0;
            }
            return drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
        }
        return invokeV.intValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51635f : invokeV.intValue;
    }

    public int getTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e eVar = this.f51634e;
            if (eVar == null) {
                return -1;
            }
            return eVar.f27196b;
        }
        return invokeV.intValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e eVar = this.f51634e;
            if (eVar == null) {
                return null;
            }
            return eVar.f27198d;
        }
        return (String) invokeV.objValue;
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

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int spaceWidth = getSpaceWidth();
            if (spaceWidth >= 0) {
                if (this.f51636g) {
                    setPadding(0, l.g(getContext(), R.dimen.ds16), spaceWidth, 0);
                } else {
                    setPadding(0, 0, spaceWidth, 0);
                }
            }
            super.onLayout(z, i2, i3, i4, i5);
        }
    }

    public void setForNewFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f51636g = z;
        }
    }

    public void setSelectItemColorResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f51637h = i2;
        }
    }

    public void setState(int i2) {
        e1 e1Var;
        List<d1> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            e eVar = this.f51634e;
            if (eVar != null && (e1Var = eVar.f27197c) != null && (list = e1Var.f26769b) != null && list.size() > 0) {
                int i3 = -l.g(getContext(), R.dimen.tbds20);
                if (!this.f51636g) {
                    i3 = 0;
                }
                if (i2 == STATE_EXPANDED) {
                    Drawable drawable = SkinManager.getDrawable(R.drawable.icon_toolbar_arrow_up);
                    drawable.setBounds(0, i3, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i3);
                    setCompoundDrawables(null, null, drawable, null);
                } else {
                    Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_arrow_gray_down);
                    drawable2.setBounds(0, i3, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i3);
                    setCompoundDrawables(null, null, drawable2, null);
                }
                setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
            }
            if (this.f51636g) {
                SkinManager.setViewTextColor(this, R.color.CAM_X0105, 1);
            } else {
                if (i2 != STATE_CHECKED && i2 != STATE_EXPANDED) {
                    SkinManager.setViewTextColor(this, R.color.CAM_X0106, 1);
                } else {
                    int i4 = this.f51637h;
                    if (i4 == 0) {
                        SkinManager.setViewTextColor(this, R.color.CAM_X0302, 1);
                    } else {
                        SkinManager.setViewTextColor(this, i4, 1);
                    }
                }
                setGravity(17);
            }
            this.f51635f = i2;
            invalidate();
        }
    }
}
