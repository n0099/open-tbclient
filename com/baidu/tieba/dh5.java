package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
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
public class dh5 {
    public static /* synthetic */ Interceptable $ic;
    public static Field e;
    public transient /* synthetic */ FieldHolder $fh;
    public final BadgeDrawable a;
    public String b;
    public boolean c;
    public b d;

    /* loaded from: classes3.dex */
    public interface b {
        boolean a();
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ dh5 b;

        public a(dh5 dh5Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh5Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dh5Var;
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

    public dh5(Context context) {
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

    public dh5 i(int i) {
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
        return (dh5) invokeI.objValue;
    }

    public static dh5 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return new dh5(context);
        }
        return (dh5) invokeL.objValue;
    }

    public dh5 f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.c = z;
            return this;
        }
        return (dh5) invokeZ.objValue;
    }

    public dh5 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.a.setBackgroundColor(i);
            return this;
        }
        return (dh5) invokeI.objValue;
    }

    public dh5 h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.a.setBadgeGravity(i);
            return this;
        }
        return (dh5) invokeI.objValue;
    }

    public dh5 k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.b = str;
            return this;
        }
        return (dh5) invokeL.objValue;
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.a.setVisible(z);
            if (!z && this.b != null) {
                ux4.k().u(this.b, true);
            }
        }
    }

    public dh5 b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            b bVar = this.d;
            if (bVar != null && !bVar.a()) {
                return this;
            }
            if (this.b != null && ux4.k().h(this.b, false)) {
                return this;
            }
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipChildren(this.c);
                viewGroup.setClipToPadding(this.c);
            }
            view2.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, view2));
            return this;
        }
        return (dh5) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = this.d;
            boolean z2 = true;
            if (bVar != null) {
                z = bVar.a();
            } else {
                z = true;
            }
            if (this.b != null) {
                return (!z || ux4.k().h(this.b, false)) ? false : false;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.isVisible();
        }
        return invokeV.booleanValue;
    }

    public dh5 j(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(i);
            if (z) {
                dimenPixelSize = -dimenPixelSize;
            }
            this.a.setHorizontalOffset(dimenPixelSize);
            return this;
        }
        return (dh5) invokeCommon.objValue;
    }

    public dh5 l(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(i);
            if (z) {
                dimenPixelSize = -dimenPixelSize;
            }
            this.a.setVerticalOffset(dimenPixelSize);
            return this;
        }
        return (dh5) invokeCommon.objValue;
    }
}
