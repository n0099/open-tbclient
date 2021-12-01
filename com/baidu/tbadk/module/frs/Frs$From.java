package com.baidu.tbadk.module.frs;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/baidu/tbadk/module/frs/Frs$From;", "", "callFrom", "", "(Ljava/lang/String;IJ)V", "getCallFrom", "()J", "ENTER_FORUM_PAGE", "FRS", "tbadkcore_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class Frs$From {
    public static final /* synthetic */ Frs$From[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Frs$From ENTER_FORUM_PAGE;
    public static final Frs$From FRS;
    public transient /* synthetic */ FieldHolder $fh;
    public final long callFrom;

    public static final /* synthetic */ Frs$From[] $values() {
        return new Frs$From[]{ENTER_FORUM_PAGE, FRS};
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1877801076, "Lcom/baidu/tbadk/module/frs/Frs$From;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1877801076, "Lcom/baidu/tbadk/module/frs/Frs$From;");
                return;
            }
        }
        ENTER_FORUM_PAGE = new Frs$From("ENTER_FORUM_PAGE", 0, 1L);
        FRS = new Frs$From("FRS", 1, 2L);
        $VALUES = $values();
    }

    public Frs$From(String str, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.callFrom = j2;
    }

    public static Frs$From valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Frs$From) Enum.valueOf(Frs$From.class, str) : (Frs$From) invokeL.objValue;
    }

    public static Frs$From[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Frs$From[]) $VALUES.clone() : (Frs$From[]) invokeV.objValue;
    }

    public final long getCallFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.callFrom : invokeV.longValue;
    }
}
