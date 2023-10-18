package com.baidu.tbadk.util.orderlist;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bt5;
import com.baidu.tieba.ct5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class OrderLinkList<D extends bt5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ct5<D> a;
    public ct5<D> b;
    public ct5<D> c;
    public boolean d;
    public volatile int e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class SortType {
        public static final /* synthetic */ SortType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SortType ASC;
        public static final SortType DESC;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-892582312, "Lcom/baidu/tbadk/util/orderlist/OrderLinkList$SortType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-892582312, "Lcom/baidu/tbadk/util/orderlist/OrderLinkList$SortType;");
                    return;
                }
            }
            ASC = new SortType("ASC", 0);
            SortType sortType = new SortType("DESC", 1);
            DESC = sortType;
            $VALUES = new SortType[]{ASC, sortType};
        }

        public SortType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SortType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (SortType) Enum.valueOf(SortType.class, str);
            }
            return (SortType) invokeL.objValue;
        }

        public static SortType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (SortType[]) $VALUES.clone();
            }
            return (SortType[]) invokeV.objValue;
        }
    }

    public OrderLinkList() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        SortType sortType = SortType.DESC;
    }

    public D b() {
        InterceptResult invokeV;
        D d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ct5<D> ct5Var = this.a;
            if (ct5Var != null && (d = ct5Var.b) != null) {
                return d;
            }
            return null;
        }
        return (D) invokeV.objValue;
    }

    public D a(int i) {
        InterceptResult invokeI;
        ct5<D> ct5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ct5<D> ct5Var2 = this.a;
            if (ct5Var2 == null) {
                return null;
            }
            this.b = ct5Var2;
            do {
                ct5<D> ct5Var3 = this.b;
                if (ct5Var3.a == i) {
                    break;
                }
                this.c = ct5Var3;
                ct5Var = ct5Var3.c;
                this.b = ct5Var;
            } while (ct5Var != null);
            ct5<D> ct5Var4 = this.b;
            if (ct5Var4 == null) {
                return null;
            }
            return ct5Var4.b;
        }
        return (D) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: D extends com.baidu.tieba.bt5 */
    /* JADX DEBUG: Type inference failed for r5v11. Raw type applied. Possible types: com.baidu.tieba.ct5<D extends com.baidu.tieba.bt5>, com.baidu.tieba.ct5<E> */
    /* JADX DEBUG: Type inference failed for r5v2. Raw type applied. Possible types: com.baidu.tieba.ct5<D extends com.baidu.tieba.bt5>, com.baidu.tieba.ct5<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void c(D d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d) == null) {
            synchronized (this) {
                ct5 ct5Var = (ct5<D>) new ct5();
                ct5Var.a = d.a();
                ct5Var.b = d;
                ct5 ct5Var2 = (ct5<D>) this.a;
                ct5Var.c = ct5Var2;
                this.a = ct5Var;
                this.b = ct5Var;
                this.c = ct5Var2;
                while (this.b.c != null && ct5Var.a < this.b.c.a) {
                    this.d = true;
                    this.b = this.b.c;
                }
                if (this.b.c != null && ct5Var.a == this.b.c.a) {
                    this.b.c.b = ct5Var.b;
                    this.a = this.c;
                    this.d = false;
                    return;
                }
                if (this.d) {
                    ct5Var.c = (ct5<D>) this.b.c;
                    this.b.c = ct5Var;
                    this.a = this.c;
                    this.d = false;
                }
                this.e++;
            }
        }
    }

    public synchronized void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (this) {
                if (this.a == null) {
                    return;
                }
                this.b = this.a;
                boolean z = true;
                while (this.b.a != i) {
                    z = false;
                    this.c = this.b;
                    ct5<D> ct5Var = this.b.c;
                    this.b = ct5Var;
                    if (ct5Var == null) {
                        break;
                    }
                }
                if (z) {
                    this.a = this.a.c;
                    this.e--;
                } else if (this.b != null) {
                    this.c = this.b.c;
                    this.e--;
                }
            }
        }
    }
}
