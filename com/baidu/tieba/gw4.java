package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public abstract class gw4<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public /* synthetic */ gw4(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* loaded from: classes6.dex */
    public static final class a<T> extends gw4<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final T b;

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int hashCode = this.a.hashCode() * 31;
                T t = this.b;
                return hashCode + (t == null ? 0 : t.hashCode());
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Error(msg=" + this.a + ", data=" + this.b + ')';
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String msg, T t) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msg, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((DefaultConstructorMarker) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.a = msg;
            this.b = t;
        }

        public /* synthetic */ a(String str, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : obj);
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b<T> extends gw4<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T a;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b() {
            this(null, 1, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this(objArr[0], ((Integer) objArr[1]).intValue(), (DefaultConstructorMarker) objArr[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && Intrinsics.areEqual(this.a, ((b) obj).a);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                T t = this.a;
                if (t == null) {
                    return 0;
                }
                return t.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "Loading(data=" + this.a + ')';
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(T t) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((DefaultConstructorMarker) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = t;
        }

        public /* synthetic */ b(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : obj);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c<T> extends gw4<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T a;

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && Intrinsics.areEqual(this.a, ((c) obj).a);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                T t = this.a;
                if (t == null) {
                    return 0;
                }
                return t.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Success(data=" + this.a + ')';
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(T t) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((DefaultConstructorMarker) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t;
        }

        public final T a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (T) invokeV.objValue;
        }
    }

    public gw4() {
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
}
