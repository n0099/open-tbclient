package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class ac8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Slice a;
    public final LifecycleRegistry b;
    public final Map<Slice, a> c;

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Slice a;
        public boolean b;

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int hashCode = this.a.hashCode() * 31;
                boolean z = this.b;
                int i = z;
                if (z != 0) {
                    i = 1;
                }
                return hashCode + i;
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "SliceRecord(slice=" + this.a + ", isShowing=" + this.b + ')';
            }
            return (String) invokeV.objValue;
        }

        public a(Slice slice, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slice, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(slice, "slice");
            this.a = slice;
            this.b = z;
        }
    }

    public ac8(Slice owner) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {owner};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.a = owner;
        this.b = new LifecycleRegistry(owner);
        this.c = new LinkedHashMap();
    }

    public final void k(Bundle outState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, outState) == null) {
            Intrinsics.checkNotNullParameter(outState, "outState");
            for (Map.Entry<Slice, a> entry : this.c.entrySet()) {
                entry.getKey().S(outState);
            }
        }
    }

    public void a(ViewGroup container, Slice child) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, container, child) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(child, "child");
            ec8.a.a();
            this.b.addObserver(child);
            this.c.put(child, new a(child, true));
        }
    }

    public final LifecycleRegistry b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (LifecycleRegistry) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (Map.Entry<Slice, a> entry : this.c.entrySet()) {
                entry.getKey().J();
            }
        }
    }

    public final void c(Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.b.handleLifecycleEvent(event);
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            for (Map.Entry<Slice, a> entry : this.c.entrySet()) {
                entry.getKey().M(z);
            }
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            for (Map.Entry<Slice, a> entry : this.c.entrySet()) {
                entry.getKey().onChangeSkinType(i);
            }
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            for (Map.Entry<Slice, a> entry : this.c.entrySet()) {
                entry.getKey().P(z);
            }
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            for (Map.Entry<Slice, a> entry : this.c.entrySet()) {
                entry.getKey().T(z);
            }
        }
    }

    public final void d(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            for (Map.Entry<Slice, a> entry : this.c.entrySet()) {
                entry.getKey().K(i, i2, intent);
            }
        }
    }

    public final boolean h(int i, KeyEvent event) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            Map<Slice, a> map = this.c;
            if (map.isEmpty()) {
                return false;
            }
            for (Map.Entry<Slice, a> entry : map.entrySet()) {
                if (entry.getKey().onKeyDown(i, event)) {
                    return true;
                }
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void j(int i, String[] permissions, int[] grantResults) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i, permissions, grantResults) == null) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(grantResults, "grantResults");
            for (Map.Entry<Slice, a> entry : this.c.entrySet()) {
                entry.getKey().R(i, permissions, grantResults);
            }
        }
    }
}
