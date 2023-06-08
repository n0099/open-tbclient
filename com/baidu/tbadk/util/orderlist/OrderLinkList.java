package com.baidu.tbadk.util.orderlist;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fy5;
import com.baidu.tieba.gy5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class OrderLinkList<D extends fy5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gy5<D> a;
    public gy5<D> b;
    public gy5<D> c;
    public boolean d;
    public volatile int e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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
            gy5<D> gy5Var = this.a;
            if (gy5Var != null && (d = gy5Var.b) != null) {
                return d;
            }
            return null;
        }
        return (D) invokeV.objValue;
    }

    public D a(int i) {
        InterceptResult invokeI;
        gy5<D> gy5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            gy5<D> gy5Var2 = this.a;
            if (gy5Var2 == null) {
                return null;
            }
            this.b = gy5Var2;
            do {
                gy5<D> gy5Var3 = this.b;
                if (gy5Var3.a == i) {
                    break;
                }
                this.c = gy5Var3;
                gy5Var = gy5Var3.c;
                this.b = gy5Var;
            } while (gy5Var != null);
            gy5<D> gy5Var4 = this.b;
            if (gy5Var4 == null) {
                return null;
            }
            return gy5Var4.b;
        }
        return (D) invokeI.objValue;
    }

    public synchronized void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            synchronized (this) {
                if (this.a == null) {
                    return;
                }
                this.b = this.a;
                boolean z = true;
                while (this.b.a != i) {
                    z = false;
                    this.c = this.b;
                    gy5<D> gy5Var = this.b.c;
                    this.b = gy5Var;
                    if (gy5Var == null) {
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

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: D extends com.baidu.tieba.fy5 */
    /* JADX DEBUG: Type inference failed for r5v11. Raw type applied. Possible types: com.baidu.tieba.gy5<D extends com.baidu.tieba.fy5>, com.baidu.tieba.gy5<E> */
    /* JADX DEBUG: Type inference failed for r5v2. Raw type applied. Possible types: com.baidu.tieba.gy5<D extends com.baidu.tieba.fy5>, com.baidu.tieba.gy5<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void insert(D d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d) == null) {
            synchronized (this) {
                gy5 gy5Var = (gy5<D>) new gy5();
                gy5Var.a = d.a();
                gy5Var.b = d;
                gy5 gy5Var2 = (gy5<D>) this.a;
                gy5Var.c = gy5Var2;
                this.a = gy5Var;
                this.b = gy5Var;
                this.c = gy5Var2;
                while (this.b.c != null && gy5Var.a < this.b.c.a) {
                    this.d = true;
                    this.b = this.b.c;
                }
                if (this.b.c != null && gy5Var.a == this.b.c.a) {
                    this.b.c.b = gy5Var.b;
                    this.a = this.c;
                    this.d = false;
                    return;
                }
                if (this.d) {
                    gy5Var.c = (gy5<D>) this.b.c;
                    this.b.c = gy5Var;
                    this.a = this.c;
                    this.d = false;
                }
                this.e++;
            }
        }
    }
}
