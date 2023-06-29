package com.baidu.tieba;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tieba.fx2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.TypeCastException;
/* loaded from: classes5.dex */
public abstract class fx2<SelfT extends fx2<SelfT>> implements yq3<SelfT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle a;

    /* loaded from: classes5.dex */
    public static final class a extends fx2<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a E() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (a) invokeV.objValue;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.yq3
        public /* bridge */ /* synthetic */ yq3 e() {
            E();
            return this;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Bundle bundle) {
            super(bundle);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Bundle) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fx2() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Bundle) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public Bundle C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!q()) {
                this.a = new Bundle();
            }
            return this.a;
        }
        return (Bundle) invokeV.objValue;
    }

    public Bundle D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (q()) {
                return new Bundle(C());
            }
            return new Bundle();
        }
        return (Bundle) invokeV.objValue;
    }

    public SelfT a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (q()) {
                this.a.clear();
            }
            return (SelfT) e();
        }
        return (SelfT) invokeV.objValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                if (q()) {
                    str = this.a.toString();
                } else {
                    str = SchemeCollecter.CLASSIFY_EMPTY;
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public fx2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new fq3();
        this.a = bundle;
    }

    public static String r(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            return str + "." + str2;
        }
        return (String) invokeLL.objValue;
    }

    public SelfT A(@Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, strArr)) == null) {
            dx2.f.d(this, str, strArr);
            return (SelfT) e();
        }
        return (SelfT) invokeLL.objValue;
    }

    public boolean d(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) {
            return dx2.a.b(this, str, Boolean.valueOf(z)).booleanValue();
        }
        return invokeLZ.booleanValue;
    }

    public float h(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048586, this, str, f)) == null) {
            return dx2.d.b(this, str, Float.valueOf(f)).floatValue();
        }
        return invokeLF.floatValue;
    }

    public int j(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i)) == null) {
            return dx2.b.b(this, str, Integer.valueOf(i)).intValue();
        }
        return invokeLI.intValue;
    }

    public long l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048590, this, str, j)) == null) {
            return dx2.c.b(this, str, Long.valueOf(j)).longValue();
        }
        return invokeLJ.longValue;
    }

    public String o(@Nullable String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            return dx2.e.b(this, str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public SelfT t(@Nullable String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048597, this, str, z)) == null) {
            dx2.a.d(this, str, Boolean.valueOf(z));
            return (SelfT) e();
        }
        return (SelfT) invokeLZ.objValue;
    }

    public SelfT u(@Nullable String str, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, bundle)) == null) {
            dx2.g.d(this, str, bundle);
            return (SelfT) e();
        }
        return (SelfT) invokeLL.objValue;
    }

    public SelfT v(@Nullable String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048601, this, str, f)) == null) {
            dx2.d.d(this, str, Float.valueOf(f));
            return (SelfT) e();
        }
        return (SelfT) invokeLF.objValue;
    }

    public SelfT w(@Nullable String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, str, i)) == null) {
            dx2.b.d(this, str, Integer.valueOf(i));
            return (SelfT) e();
        }
        return (SelfT) invokeLI.objValue;
    }

    public SelfT x(@Nullable String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048603, this, str, j)) == null) {
            dx2.c.d(this, str, Long.valueOf(j));
            return (SelfT) e();
        }
        return (SelfT) invokeLJ.objValue;
    }

    public SelfT y(@Nullable String str, @Nullable Parcelable parcelable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, parcelable)) == null) {
            dx2.h.d(this, str, parcelable);
            return (SelfT) e();
        }
        return (SelfT) invokeLL.objValue;
    }

    public SelfT z(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, str, str2)) == null) {
            dx2.e.d(this, str, str2);
            return (SelfT) e();
        }
        return (SelfT) invokeLL.objValue;
    }

    public SelfT B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (q()) {
                this.a.remove(str);
            }
            return (SelfT) e();
        }
        return (SelfT) invokeL.objValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (q() && this.a.containsKey(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return dx2.a.a(this, str).booleanValue();
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public Bundle f(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            return dx2.g.a(this, str);
        }
        return (Bundle) invokeL.objValue;
    }

    public float g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return dx2.d.a(this, str).floatValue();
        }
        return invokeL.floatValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            return dx2.b.a(this, str).intValue();
        }
        return invokeL.intValue;
    }

    public long k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            return dx2.c.a(this, str).longValue();
        }
        return invokeL.longValue;
    }

    @Nullable
    public <T extends Parcelable> T m(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            try {
                return (T) dx2.h.a(this, str);
            } catch (TypeCastException unused) {
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    @Nullable
    public String n(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            return dx2.e.a(this, str);
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public String[] p(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            return dx2.f.a(this, str);
        }
        return (String[]) invokeL.objValue;
    }

    public SelfT s(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bundle)) == null) {
            if (bundle != null && !bundle.isEmpty()) {
                C().putAll(bundle);
            }
            return (SelfT) e();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT update(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, bundle)) == null) {
            s(bundle);
            return (SelfT) e();
        }
        return (SelfT) invokeL.objValue;
    }
}
