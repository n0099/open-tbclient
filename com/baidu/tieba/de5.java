package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class de5 {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static Field e;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final BadgeDrawable a;
    @Nullable
    public String b;
    public boolean c;
    @Nullable
    public b d;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ de5 b;

        public a(de5 de5Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de5Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = de5Var;
            this.a = view2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BadgeUtils.attachBadgeDrawable(this.b.a, this.a, null);
                this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean a();
    }

    public de5(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = true;
        this.a = BadgeDrawable.create(context);
    }

    @NonNull
    public static de5 c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new de5(context) : (de5) invokeL.objValue;
    }

    @NonNull
    public de5 b(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            b bVar = this.d;
            if (bVar == null || bVar.a()) {
                if (this.b == null || !su4.k().h(this.b, false)) {
                    ViewParent parent = view2.getParent();
                    if (parent instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) parent;
                        viewGroup.setClipChildren(this.c);
                        viewGroup.setClipToPadding(this.c);
                    }
                    view2.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, view2));
                    return this;
                }
                return this;
            }
            return this;
        }
        return (de5) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = this.d;
            boolean z = true;
            boolean a2 = bVar != null ? bVar.a() : true;
            if (this.b != null) {
                return (!a2 || su4.k().h(this.b, false)) ? false : false;
            }
            return a2;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.isVisible() : invokeV.booleanValue;
    }

    @NonNull
    public de5 f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.c = z;
            return this;
        }
        return (de5) invokeZ.objValue;
    }

    @NonNull
    public de5 g(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.a.setBackgroundColor(i);
            return this;
        }
        return (de5) invokeI.objValue;
    }

    @NonNull
    public de5 h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.a.setBadgeGravity(i);
            return this;
        }
        return (de5) invokeI.objValue;
    }

    @NonNull
    public de5 i(@DimenRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (e == null) {
                try {
                    Field declaredField = BadgeDrawable.class.getDeclaredField("badgeRadius");
                    e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                if (e != null) {
                    e.set(this.a, Integer.valueOf(UtilHelper.getDimenPixelSize(i)));
                }
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
            return this;
        }
        return (de5) invokeI.objValue;
    }

    @NonNull
    public de5 j(@Nullable b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            this.d = bVar;
            return this;
        }
        return (de5) invokeL.objValue;
    }

    @NonNull
    public de5 k(@DimenRes int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(i);
            if (z) {
                dimenPixelSize = -dimenPixelSize;
            }
            this.a.setHorizontalOffset(dimenPixelSize);
            return this;
        }
        return (de5) invokeCommon.objValue;
    }

    @NonNull
    public de5 l(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.b = str;
            return this;
        }
        return (de5) invokeL.objValue;
    }

    @NonNull
    public de5 m(@DimenRes int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(i);
            if (z) {
                dimenPixelSize = -dimenPixelSize;
            }
            this.a.setVerticalOffset(dimenPixelSize);
            return this;
        }
        return (de5) invokeCommon.objValue;
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.a.setVisible(z);
            if (z || this.b == null) {
                return;
            }
            su4.k().u(this.b, true);
        }
    }
}
