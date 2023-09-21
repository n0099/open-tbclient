package com.baidu.tieba;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.rotation.NadSensorAbsHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b31 extends NadSensorAbsHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Float[] g;
    public Boolean[] h;
    public Integer[] i;
    public Float[] j;
    public float k;
    public float l;
    public float m;

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 9;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b31(Context context, c31 listener) {
        super(context, listener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, listener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c31) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Float valueOf = Float.valueOf(-1.0f);
        this.g = new Float[]{valueOf, valueOf, valueOf};
        Boolean bool = Boolean.FALSE;
        this.h = new Boolean[]{bool, bool, bool};
        this.i = new Integer[]{45, 45, 45, 45, 45, 45};
        Float valueOf2 = Float.valueOf(0.0f);
        this.j = new Float[]{valueOf2, valueOf2, valueOf2};
    }

    public final float r(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            float floatValue = this.g[i].floatValue();
            if (this.h[i].booleanValue()) {
                if (floatValue == -1.0f) {
                    this.g[i] = Float.valueOf(f);
                    floatValue = f;
                }
            } else {
                floatValue = 180.0f;
            }
            int i2 = i * 2;
            int intValue = this.i[i2].intValue();
            float intValue2 = this.i[i2 + 1].intValue() + floatValue;
            float f2 = floatValue - intValue;
            if (f > intValue2) {
                f = intValue2;
            }
            if (f < f2) {
                f = f2;
            }
            if (intValue2 == f2) {
                return 0.0f;
            }
            return (f - f2) / (intValue2 - f2);
        }
        return invokeCommon.floatValue;
    }

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public void i(SensorEvent sensorEvent) {
        Sensor sensor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sensorEvent) == null) && sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 9) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float abs = Math.abs(this.k - f);
            float abs2 = Math.abs(this.l - f2);
            float abs3 = Math.abs(this.m - f3);
            if (abs > 0.01d || abs2 > 0.01d || abs3 > 0.01d) {
                p(f, f2, f3);
            }
            this.k = f;
            this.l = f2;
            this.m = f3;
        }
    }

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.o();
            Float valueOf = Float.valueOf(-1.0f);
            this.g = new Float[]{valueOf, valueOf, valueOf};
        }
    }

    public final void p(float f, float f2, float f3) {
        c31 b;
        c31 b2;
        c31 b3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            float floatValue = this.j[0].floatValue() * 9.80665f;
            float abs = Math.abs(f3);
            if (abs >= 0.0f && abs <= floatValue) {
                float r = r(0, q(0, f, f2, f3));
                c31 b4 = b();
                if (b4 != null) {
                    b4.b(r);
                }
                if (r == 0.0f) {
                    c31 b5 = b();
                    if (b5 != null) {
                        b5.e(0);
                    }
                } else if (r == 1.0f && (b3 = b()) != null) {
                    b3.e(1);
                }
            }
            float floatValue2 = this.j[1].floatValue() * 9.80665f;
            float abs2 = Math.abs(f2);
            if (abs2 >= 0.0f && abs2 <= floatValue2) {
                float r2 = r(1, q(1, f, f2, f3));
                c31 b6 = b();
                if (b6 != null) {
                    b6.c(r2);
                }
                if (r2 == 0.0f) {
                    c31 b7 = b();
                    if (b7 != null) {
                        b7.f(0);
                    }
                } else if (r2 == 1.0f && (b2 = b()) != null) {
                    b2.f(1);
                }
            }
            float floatValue3 = this.j[2].floatValue() * 9.80665f;
            float abs3 = Math.abs(f);
            if (abs3 >= 0.0f && abs3 <= floatValue3) {
                float r3 = r(2, q(2, f, f2, f3));
                c31 b8 = b();
                if (b8 != null) {
                    b8.d(r3);
                }
                if (r3 == 0.0f) {
                    c31 b9 = b();
                    if (b9 != null) {
                        b9.g(0);
                    }
                } else if (r3 == 1.0f && (b = b()) != null) {
                    b.g(1);
                }
            }
        }
    }

    public final float q(int i, float f, float f2, float f3) {
        InterceptResult invokeCommon;
        double degrees;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return 180.0f;
                    }
                    degrees = Math.toDegrees(Math.atan2(f, f3));
                } else {
                    degrees = Math.toDegrees(Math.atan2(f2, f3));
                }
            } else {
                degrees = Math.toDegrees(Math.atan2(f, f2));
            }
            return 180.0f - ((float) degrees);
        }
        return invokeCommon.floatValue;
    }

    public final void s(int i, int i2, int i3, float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            int i4 = i * 2;
            this.i[i4] = Integer.valueOf(i2);
            this.i[i4 + 1] = Integer.valueOf(i3);
            this.j[i] = Float.valueOf(f);
            this.h[i] = Boolean.valueOf(z);
        }
    }
}
