package com.baidu.tbadk.module.frs;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/tbadk/module/frs/Frs$From;", "Ljava/lang/Enum;", "", "callFrom", "J", "getCallFrom", "()J", "<init>", "(Ljava/lang/String;IJ)V", "ENTER_FORUM_PAGE", "FRS", "tbadkcore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class Frs$From {
    public static final /* synthetic */ Frs$From[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Frs$From ENTER_FORUM_PAGE;
    public static final Frs$From FRS;
    public transient /* synthetic */ FieldHolder $fh;
    public final long callFrom;

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
        Frs$From frs$From = new Frs$From("ENTER_FORUM_PAGE", 0, 1L);
        ENTER_FORUM_PAGE = frs$From;
        Frs$From frs$From2 = new Frs$From("FRS", 1, 2L);
        FRS = frs$From2;
        $VALUES = new Frs$From[]{frs$From, frs$From2};
    }

    public Frs$From(String str, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.callFrom = j;
    }

    public static Frs$From valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Frs$From) Enum.valueOf(Frs$From.class, str) : (Frs$From) invokeL.objValue;
    }

    public static Frs$From[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Frs$From[]) $VALUES.clone() : (Frs$From[]) invokeV.objValue;
    }

    public final long getCallFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.callFrom : invokeV.longValue;
    }
}
