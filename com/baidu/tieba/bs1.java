package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public class bs1 extends SwanKV implements SharedPreferences, SharedPreferences.Editor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (SharedPreferences.Editor) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bs1 a;
        public final /* synthetic */ Callable b;

        public a(bs1 bs1Var, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bs1Var, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bs1Var;
            this.b = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.bs1 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            SharedPreferences sharedPreferences;
            Map<String, ?> all;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (sharedPreferences = (SharedPreferences) this.b.call()) != null && (all = sharedPreferences.getAll()) != null) {
                this.a.importFromMap(all, false);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public bs1(Context context, String str) {
        this(context, str, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public bs1(Context context, String str, int i) {
        this(context, str, i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs1(Context context, String str, int i, String str2) {
        super(context, str, i, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public /* synthetic */ bs1(Context context, String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, i, (i2 & 8) != 0 ? null : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public bs1(String str) {
        this(null, str, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public bs1(String str, int i) {
        this(null, str, i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    public void apply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.sync(false);
        }
    }

    public SharedPreferences.Editor clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            super.clearAll();
            return this;
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    public boolean commit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            super.sync(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.storage.swankv.SwanKV, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return super.getAll();
        }
        return (Map) invokeV.objValue;
    }

    public boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return super.containKey(str);
        }
        return invokeL.booleanValue;
    }

    public void importFromSharedPreferences(Callable<SharedPreferences> callable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, callable) == null) {
            new Thread(new a(this, callable), "SharedPreferences-import").start();
        }
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onSharedPreferenceChangeListener) == null) {
            throw new UnsupportedOperationException("Not support registerOnSharedPreferenceChangeListener");
        }
    }

    public SharedPreferences.Editor remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            super.removeKey(str);
            return this;
        }
        return (SharedPreferences.Editor) invokeL.objValue;
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onSharedPreferenceChangeListener) == null) {
            throw new UnsupportedOperationException("Not support unregisterOnSharedPreferenceChangeListener");
        }
    }

    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            return super.getBool(str, z);
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.baidu.storage.swankv.SwanKV, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048583, this, str, f)) == null) {
            return super.getFloat(str, f);
        }
        return invokeLF.floatValue;
    }

    @Override // com.baidu.storage.swankv.SwanKV, android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            return super.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.storage.swankv.SwanKV, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, set)) == null) {
            return super.getStringSet(str, set);
        }
        return (Set) invokeLL.objValue;
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, str, z)) == null) {
            super.writeBool(str, z);
            return this;
        }
        return (SharedPreferences.Editor) invokeLZ.objValue;
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048588, this, str, f)) == null) {
            super.writeFloat(str, f);
            return this;
        }
        return (SharedPreferences.Editor) invokeLF.objValue;
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i)) == null) {
            super.writeInt(str, i);
            return this;
        }
        return (SharedPreferences.Editor) invokeLI.objValue;
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048590, this, str, j)) == null) {
            super.writeLong(str, j);
            return this;
        }
        return (SharedPreferences.Editor) invokeLJ.objValue;
    }

    public SharedPreferences.Editor putString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, str2)) == null) {
            super.writeString(str, str2);
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, set)) == null) {
            super.writeStringSet(str, set);
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }
}
