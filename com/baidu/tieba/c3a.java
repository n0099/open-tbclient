package com.baidu.tieba;

import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
/* loaded from: classes3.dex */
public class c3a implements Comparable<c3a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public int c;

    public c3a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 30;
        this.a = i;
        this.b = i2;
    }

    public c3a(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 30;
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull c3a c3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c3aVar)) == null) {
            int i = this.a;
            int i2 = this.b;
            int i3 = i * i2;
            int i4 = c3aVar.a;
            int i5 = c3aVar.b;
            if (i3 == i4 * i5) {
                return this.c - c3aVar.c;
            }
            return (i * i2) - (i4 * i5);
        }
        return invokeL.intValue;
    }

    public boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return g(this, i);
        }
        return invokeI.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.c = i;
        }
    }

    public CamcorderProfile b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a == 720 && this.b == 480) {
                return CamcorderProfile.get(4);
            }
            if (this.a == 1280 && this.b == 720) {
                return CamcorderProfile.get(5);
            }
            if (this.a == 1920 && this.b == 1080) {
                return CamcorderProfile.get(6);
            }
            if (this.a == 3840 && this.b == 2160) {
                return CamcorderProfile.get(8);
            }
            return CamcorderProfile.get(5);
        }
        return (CamcorderProfile) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c3a)) {
                return false;
            }
            c3a c3aVar = (c3a) obj;
            if (this.a != c3aVar.a || this.b != c3aVar.b || this.c != c3aVar.c) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean g(c3a c3aVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, c3aVar, i)) == null) {
            if (c3aVar.e() == 720 && c3aVar.d() == 480) {
                return CamcorderProfile.hasProfile(i, 2002);
            }
            if (c3aVar.e() == 1280 && c3aVar.d() == 720) {
                return CamcorderProfile.hasProfile(i, 2003);
            }
            if (c3aVar.e() == 1920 && c3aVar.d() == 1080) {
                return CamcorderProfile.hasProfile(i, 2004);
            }
            if (c3aVar.e() == 3840 && c3aVar.d() == 2160) {
                return CamcorderProfile.hasProfile(i, 2005);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return Objects.hash(Integer.valueOf(e()), Integer.valueOf(d()), Integer.valueOf(c()));
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a + "x" + this.b + " " + this.c + "p";
        }
        return (String) invokeV.objValue;
    }
}
