package com.baidu.tieba.easteregg.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.gy6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/baidu/tieba/easteregg/data/EasterEggAdDataHolder;", "", "()V", "easterEggAdData", "Lcom/baidu/tieba/easteregg/data/EasterEggAdData;", "getEasterEggAdData", "()Lcom/baidu/tieba/easteregg/data/EasterEggAdData;", "setEasterEggAdData", "(Lcom/baidu/tieba/easteregg/data/EasterEggAdData;)V", "getData", "Companion", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EasterEggAdDataHolder {
    public static /* synthetic */ Interceptable $ic;
    public static final a b;
    public static final Lazy<EasterEggAdDataHolder> c;
    public transient /* synthetic */ FieldHolder $fh;
    public EasterEggAdData a;

    public /* synthetic */ EasterEggAdDataHolder(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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

        public final EasterEggAdDataHolder a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (EasterEggAdDataHolder) EasterEggAdDataHolder.c.getValue();
            }
            return (EasterEggAdDataHolder) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-681345078, "Lcom/baidu/tieba/easteregg/data/EasterEggAdDataHolder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-681345078, "Lcom/baidu/tieba/easteregg/data/EasterEggAdDataHolder;");
                return;
            }
        }
        b = new a(null);
        c = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) EasterEggAdDataHolder$Companion$instance$2.INSTANCE);
    }

    public EasterEggAdDataHolder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final EasterEggAdData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            EasterEggAdData easterEggAdData = this.a;
            boolean z = true;
            if ((easterEggAdData == null || easterEggAdData.getResType() != 1) ? false : false) {
                gy6.a aVar = gy6.d;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                Intrinsics.checkNotNullExpressionValue(inst, "getInst()");
                EasterEggAdData easterEggAdData2 = this.a;
                String b2 = aVar.b(inst, (easterEggAdData2 == null || (r2 = easterEggAdData2.getVideoUrl()) == null) ? "" : "");
                if (new File(b2).exists()) {
                    EasterEggAdData easterEggAdData3 = this.a;
                    if (easterEggAdData3 != null) {
                        easterEggAdData3.setVideoPath(b2);
                    }
                    return this.a;
                }
                return null;
            }
            return this.a;
        }
        return (EasterEggAdData) invokeV.objValue;
    }

    public final void c(EasterEggAdData easterEggAdData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, easterEggAdData) == null) {
            this.a = easterEggAdData;
        }
    }
}
