package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ee3 {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile ee3 m;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public SensorManager b;
    public SensorEventListener c;
    public SensorEventListener d;
    public Sensor e;
    public Sensor f;
    public float[] g;
    public float[] h;
    public int i;
    public c j;
    public boolean k;
    public long l;

    /* loaded from: classes3.dex */
    public interface c {
        void a(float f, int i);
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) ? i != -1 ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? "unknow" : "high" : "medium" : Config.EXCEPTION_MEMORY_LOW : "unreliable" : "no-contact" : (String) invokeI.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee3 a;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i) == null) {
            }
        }

        public a(ee3 ee3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee3Var;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                if (sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 1) {
                    this.a.g = sensorEvent.values;
                    this.a.i = sensorEvent.accuracy;
                    f12.b("SwanAppCompassManager", "accelerometer changed accuracy: " + this.a.i);
                    this.a.k();
                    return;
                }
                f12.o(MapController.COMPASS_LAYER_TAG, "illegal accelerometer event");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee3 a;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i) == null) {
            }
        }

        public b(ee3 ee3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee3Var;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                if (sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 2) {
                    this.a.h = sensorEvent.values;
                    this.a.i = sensorEvent.accuracy;
                    f12.b("SwanAppCompassManager", "magneticFiled changed accuracy: " + this.a.i);
                    this.a.k();
                    return;
                }
                f12.o(MapController.COMPASS_LAYER_TAG, "illegal magnetic filed event");
            }
        }
    }

    public ee3() {
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
        this.g = new float[3];
        this.h = new float[3];
        this.i = -100;
        this.k = false;
        this.l = 0L;
    }

    public void q() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!this.k) {
                f12.o(MapController.COMPASS_LAYER_TAG, "has already stop");
                return;
            }
            f12.i(MapController.COMPASS_LAYER_TAG, "stop listen");
            SensorEventListener sensorEventListener = this.c;
            if (sensorEventListener != null && (sensorManager2 = this.b) != null) {
                sensorManager2.unregisterListener(sensorEventListener);
                this.c = null;
            }
            SensorEventListener sensorEventListener2 = this.d;
            if (sensorEventListener2 != null && (sensorManager = this.b) != null) {
                sensorManager.unregisterListener(sensorEventListener2);
                this.d = null;
            }
            this.b = null;
            this.f = null;
            this.e = null;
            this.k = false;
        }
    }

    public void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.a = context;
        }
    }

    public void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public static ee3 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (m == null) {
                synchronized (ee3.class) {
                    if (m == null) {
                        m = new ee3();
                    }
                }
            }
            return m;
        }
        return (ee3) invokeV.objValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65544, null) != null) || m == null) {
            return;
        }
        m.m();
    }

    public final float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float[] fArr = new float[3];
            float[] fArr2 = new float[9];
            SensorManager.getRotationMatrix(fArr2, null, this.g, this.h);
            SensorManager.getOrientation(fArr2, fArr);
            return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
        }
        return invokeV.floatValue;
    }

    public final SensorEventListener g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            f12.i(MapController.COMPASS_LAYER_TAG, "get Accelerometer listener");
            SensorEventListener sensorEventListener = this.c;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            a aVar = new a(this);
            this.c = aVar;
            return aVar;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final SensorEventListener j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            f12.i(MapController.COMPASS_LAYER_TAG, "get MagneticFiled listener");
            SensorEventListener sensorEventListener = this.d;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            b bVar = new b(this);
            this.d = bVar;
            return bVar;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f12.i(MapController.COMPASS_LAYER_TAG, "release");
            if (this.k) {
                q();
            }
            this.b = null;
            this.f = null;
            this.e = null;
            this.c = null;
            this.d = null;
            this.j = null;
            this.a = null;
            m = null;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.j != null && System.currentTimeMillis() - this.l > 200) {
            float f = f();
            f12.b("SwanAppCompassManager", "orientation changed, orientation : " + f);
            this.j.a(f, this.i);
            this.l = System.currentTimeMillis();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Context context = this.a;
            if (context == null) {
                f12.c(MapController.COMPASS_LAYER_TAG, "start error, none context");
            } else if (this.k) {
                f12.o(MapController.COMPASS_LAYER_TAG, "has already start");
            } else {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                this.b = sensorManager;
                if (sensorManager != null) {
                    this.e = sensorManager.getDefaultSensor(1);
                    this.f = this.b.getDefaultSensor(2);
                    this.b.registerListener(g(), this.e, 1);
                    this.b.registerListener(j(), this.f, 1);
                    this.k = true;
                    f12.i(MapController.COMPASS_LAYER_TAG, "start listen");
                    return;
                }
                f12.c(MapController.COMPASS_LAYER_TAG, "none sensorManager");
            }
        }
    }
}
