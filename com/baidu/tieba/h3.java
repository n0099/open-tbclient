package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes4.dex */
public class h3 implements r6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k6<ParticleEmitter> a;
    public boolean b;

    public h3() {
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
        this.a = new k6<>(8);
    }

    public void a(t2 t2Var, t2 t2Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, t2Var, t2Var2) == null) {
            i(t2Var);
            g(t2Var2);
        }
    }

    @Override // com.baidu.tieba.r6
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.b) {
            return;
        }
        int i = this.a.b;
        for (int i2 = 0; i2 < i; i2++) {
            k6.b<k3> it = this.a.get(i2).g().iterator();
            while (it.hasNext()) {
                it.next().f().dispose();
            }
        }
    }

    public void f(t2 t2Var, l3 l3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, t2Var, l3Var, str) == null) {
            i(t2Var);
            h(l3Var, str);
        }
    }

    public void g(t2 t2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t2Var) == null) {
            this.b = true;
            g7 g7Var = new g7(this.a.b);
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                ParticleEmitter particleEmitter = this.a.get(i2);
                if (particleEmitter.f().b != 0) {
                    k6<k3> k6Var = new k6<>();
                    k6.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace('\\', WebvttCueParser.CHAR_SLASH)).getName();
                        k3 k3Var = (k3) g7Var.c(name);
                        if (k3Var == null) {
                            k3Var = new k3(j(t2Var.a(name)));
                            g7Var.i(name, k3Var);
                        }
                        k6Var.a(k3Var);
                    }
                    particleEmitter.u(k6Var);
                }
            }
        }
    }

    public void h(l3 l3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, l3Var, str) == null) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                ParticleEmitter particleEmitter = this.a.get(i2);
                if (particleEmitter.f().b != 0) {
                    k6<k3> k6Var = new k6<>();
                    k6.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace('\\', WebvttCueParser.CHAR_SLASH)).getName();
                        int lastIndexOf = name.lastIndexOf(46);
                        if (lastIndexOf != -1) {
                            name = name.substring(0, lastIndexOf);
                        }
                        if (str != null) {
                            name = str + name;
                        }
                        k3 a = l3Var.a(name);
                        if (a != null) {
                            k6Var.a(a);
                        } else {
                            throw new IllegalArgumentException("SpriteSheet missing image: " + name);
                        }
                    }
                    particleEmitter.u(k6Var);
                }
            }
        }
    }

    public void i(t2 t2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, t2Var) == null) {
            InputStream m = t2Var.m();
            this.a.clear();
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(m), 512);
                    do {
                        try {
                            this.a.a(k(bufferedReader2));
                        } catch (IOException e) {
                            e = e;
                            throw new GdxRuntimeException("Error loading effect: " + t2Var, e);
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            s7.a(bufferedReader);
                            throw th;
                        }
                    } while (bufferedReader2.readLine() != null);
                    s7.a(bufferedReader2);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        }
    }

    public Texture j(t2 t2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, t2Var)) == null) {
            return new Texture(t2Var, false);
        }
        return (Texture) invokeL.objValue;
    }

    public ParticleEmitter k(BufferedReader bufferedReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bufferedReader)) == null) {
            return new ParticleEmitter(bufferedReader);
        }
        return (ParticleEmitter) invokeL.objValue;
    }

    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                this.a.get(i2).update(f);
            }
        }
    }
}
