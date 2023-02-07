package com.baidu.tieba;

import android.media.MediaPlayer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public class e65 extends MediaPlayer implements c65 {
    public static /* synthetic */ Interceptable $ic;
    public static Object d;
    public static e65 e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947686309, "Lcom/baidu/tieba/e65;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947686309, "Lcom/baidu/tieba/e65;");
                return;
            }
        }
        d = new Object();
    }

    public e65() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = true;
        this.c = -1;
    }

    public static e65 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (e == null) {
                synchronized (d) {
                    if (e == null) {
                        e = new e65();
                    }
                }
            }
            return e;
        }
        return (e65) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c65
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b) {
            return;
        }
        stop();
        this.b = true;
        this.a = false;
    }

    @Override // com.baidu.tieba.c65
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.c65
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            pause();
        }
    }

    @Override // com.baidu.tieba.c65
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            reset();
            this.a = false;
            this.b = true;
            this.c = -1;
        }
    }

    @Override // com.baidu.tieba.c65
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.c65
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            start();
            this.b = false;
        }
    }

    @Override // com.baidu.tieba.c65
    public boolean isPrepared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c65
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.c = -1;
            if (!this.a) {
                this.b = true;
                reset();
                try {
                    setDataSource(str);
                    i(wj.b);
                    try {
                        prepare();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        this.c = 2;
                        return false;
                    } catch (IllegalStateException unused) {
                        this.c = 1;
                        return false;
                    }
                } catch (IOException unused2) {
                    this.c = 2;
                    return false;
                } catch (IllegalArgumentException unused3) {
                    this.c = 0;
                    return false;
                } catch (IllegalStateException unused4) {
                    this.c = 1;
                    return false;
                }
            }
            this.a = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            setAudioStreamType(i);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            try {
                seekTo(i);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.tieba.c65
    public void seek(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            j(i);
        }
    }
}
