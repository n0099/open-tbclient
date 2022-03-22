package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.f1.e1;
import c.a.p0.f1.f1;
import c.a.p0.f1.p2.e;
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
/* loaded from: classes5.dex */
public class TabItemView extends TextView {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static int f32847e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static int f32848f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static int f32849g = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public int f32850b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32851c;

    /* renamed from: d  reason: collision with root package name */
    public int f32852d;

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
    public TabItemView(Context context, e eVar, int i, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, eVar, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32850b = f32847e;
        this.f32852d = 0;
        this.a = eVar;
        this.f32851c = z;
        b(context, i);
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setState(this.f32850b);
        }
    }

    public final void b(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
            if (this.f32851c) {
                setPadding(0, n.f(getContext(), R.dimen.tbds20), 0, 0);
                setTextSize(0, n.f(context, R.dimen.tbds42));
            } else {
                setGravity(17);
            }
            setSingleLine();
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
            e eVar = this.a;
            if (eVar != null) {
                setText(eVar.a);
            }
            a();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32850b : invokeV.intValue;
    }

    public int getTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e eVar = this.a;
            if (eVar == null) {
                return -1;
            }
            return eVar.f14382b;
        }
        return invokeV.intValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e eVar = this.a;
            if (eVar == null) {
                return null;
            }
            return eVar.f14384d;
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
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int spaceWidth = getSpaceWidth();
            if (spaceWidth >= 0) {
                if (this.f32851c) {
                    setPadding(0, n.f(getContext(), R.dimen.obfuscated_res_0x7f0701be), spaceWidth, 0);
                } else {
                    setPadding(0, 0, spaceWidth, 0);
                }
            }
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    public void setForNewFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f32851c = z;
        }
    }

    public void setSelectItemColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f32852d = i;
        }
    }

    public void setState(int i) {
        f1 f1Var;
        List<e1> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            e eVar = this.a;
            if (eVar != null && (f1Var = eVar.f14383c) != null && (list = f1Var.f13941b) != null && list.size() > 0) {
                int i2 = -n.f(getContext(), R.dimen.tbds20);
                if (!this.f32851c) {
                    i2 = 0;
                }
                if (i == f32849g) {
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
            if (this.f32851c) {
                SkinManager.setViewTextColor(this, R.color.CAM_X0105, 1);
            } else {
                if (i != f32848f && i != f32849g) {
                    SkinManager.setViewTextColor(this, R.color.CAM_X0106, 1);
                } else {
                    int i3 = this.f32852d;
                    if (i3 == 0) {
                        SkinManager.setViewTextColor(this, R.color.CAM_X0302, 1);
                    } else {
                        SkinManager.setViewTextColor(this, i3, 1);
                    }
                }
                setGravity(17);
            }
            this.f32850b = i;
            invalidate();
        }
    }
}
