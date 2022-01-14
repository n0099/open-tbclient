package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.o1;
import c.a.t0.d1.p1;
import c.a.t0.d1.x2.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes12.dex */
public class TabItemView extends TextView {
    public static /* synthetic */ Interceptable $ic = null;
    public static int STATE_CHECKED = 1;
    public static int STATE_EXPANDED = 2;
    public static int STATE_UNCHECKED;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f43712e;

    /* renamed from: f  reason: collision with root package name */
    public int f43713f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43714g;

    /* renamed from: h  reason: collision with root package name */
    public int f43715h;

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
        this.f43713f = STATE_UNCHECKED;
        this.f43715h = 0;
        this.f43712e = eVar;
        this.f43714g = z;
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
            if (this.f43714g) {
                setPadding(0, n.f(getContext(), d1.tbds20), 0, 0);
                setTextSize(0, n.f(context, d1.tbds42));
            } else {
                setGravity(17);
            }
            setSingleLine();
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
            e eVar = this.f43712e;
            if (eVar != null) {
                setText(eVar.a);
            }
            changeSkinType();
        }
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setState(this.f43713f);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f43713f : invokeV.intValue;
    }

    public int getTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e eVar = this.f43712e;
            if (eVar == null) {
                return -1;
            }
            return eVar.f16765b;
        }
        return invokeV.intValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e eVar = this.f43712e;
            if (eVar == null) {
                return null;
            }
            return eVar.f16767d;
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
                if (this.f43714g) {
                    setPadding(0, n.f(getContext(), d1.ds16), spaceWidth, 0);
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
            this.f43714g = z;
        }
    }

    public void setSelectItemColorResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f43715h = i2;
        }
    }

    public void setState(int i2) {
        p1 p1Var;
        List<o1> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            e eVar = this.f43712e;
            if (eVar != null && (p1Var = eVar.f16766c) != null && (list = p1Var.f16353b) != null && list.size() > 0) {
                int i3 = -n.f(getContext(), d1.tbds20);
                if (!this.f43714g) {
                    i3 = 0;
                }
                if (i2 == STATE_EXPANDED) {
                    Drawable drawable = SkinManager.getDrawable(e1.icon_toolbar_arrow_up);
                    drawable.setBounds(0, i3, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i3);
                    setCompoundDrawables(null, null, drawable, null);
                } else {
                    Drawable drawable2 = SkinManager.getDrawable(e1.icon_arrow_gray_down);
                    drawable2.setBounds(0, i3, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i3);
                    setCompoundDrawables(null, null, drawable2, null);
                }
                setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(d1.tbds20));
            }
            if (this.f43714g) {
                SkinManager.setViewTextColor(this, c1.CAM_X0105, 1);
            } else {
                if (i2 != STATE_CHECKED && i2 != STATE_EXPANDED) {
                    SkinManager.setViewTextColor(this, c1.CAM_X0106, 1);
                } else {
                    int i4 = this.f43715h;
                    if (i4 == 0) {
                        SkinManager.setViewTextColor(this, c1.CAM_X0302, 1);
                    } else {
                        SkinManager.setViewTextColor(this, i4, 1);
                    }
                }
                setGravity(17);
            }
            this.f43713f = i2;
            invalidate();
        }
    }
}
