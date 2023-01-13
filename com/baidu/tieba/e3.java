package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class e3 implements l2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SoundPool a;
    public final AudioManager b;
    public final List<x2> c;

    public e3(Context context, j2 j2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, j2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        if (!j2Var.p) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.a = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).setMaxStreams(j2Var.q).build();
            } else {
                this.a = new SoundPool(j2Var.q, 3, 0);
            }
            this.b = (AudioManager) context.getSystemService("audio");
            if (context instanceof Activity) {
                ((Activity) context).setVolumeControlStream(3);
                return;
            }
            return;
        }
        this.a = null;
        this.b = null;
    }

    @Override // com.baidu.tieba.f1
    public h2 a(l3 l3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l3Var)) == null) {
            if (this.a != null) {
                o2 o2Var = (o2) l3Var;
                if (o2Var.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = o2Var.u();
                        a3 a3Var = new a3(this.a, this.b, this.a.load(u, 1));
                        u.close();
                        return a3Var;
                    } catch (IOException e) {
                        throw new GdxRuntimeException("Error loading audio file: " + l3Var + "\nNote: Internal audio files must be placed in the assets directory.", e);
                    }
                }
                try {
                    return new a3(this.a, this.b, this.a.load(o2Var.e().getPath(), 1));
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Error loading audio file: " + l3Var, e2);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (h2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.l2
    public void d(x2 x2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x2Var) == null) {
            synchronized (this.c) {
                this.c.remove(this);
            }
        }
    }

    @Override // com.baidu.tieba.j7
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            Iterator it = new ArrayList(this.c).iterator();
            while (it.hasNext()) {
                ((x2) it.next()).dispose();
            }
        }
        this.a.release();
    }

    @Override // com.baidu.tieba.l2
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            for (x2 x2Var : this.c) {
                if (x2Var.a()) {
                    x2Var.pause();
                    x2Var.d = true;
                } else {
                    x2Var.d = false;
                }
            }
        }
        this.a.autoPause();
    }

    @Override // com.baidu.tieba.l2
    public void resume() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            for (int i = 0; i < this.c.size(); i++) {
                if (this.c.get(i).d) {
                    this.c.get(i).f();
                }
            }
        }
        this.a.autoResume();
    }

    @Override // com.baidu.tieba.f1
    public g2 f(l3 l3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, l3Var)) == null) {
            if (this.a != null) {
                o2 o2Var = (o2) l3Var;
                MediaPlayer mediaPlayer = new MediaPlayer();
                if (o2Var.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = o2Var.u();
                        mediaPlayer.setDataSource(u.getFileDescriptor(), u.getStartOffset(), u.getLength());
                        u.close();
                        mediaPlayer.prepare();
                        x2 x2Var = new x2(this, mediaPlayer);
                        synchronized (this.c) {
                            this.c.add(x2Var);
                        }
                        return x2Var;
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Error loading audio file: " + l3Var + "\nNote: Internal audio files must be placed in the assets directory.", e);
                    }
                }
                try {
                    mediaPlayer.setDataSource(o2Var.e().getPath());
                    mediaPlayer.prepare();
                    x2 x2Var2 = new x2(this, mediaPlayer);
                    synchronized (this.c) {
                        this.c.add(x2Var2);
                    }
                    return x2Var2;
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Error loading audio file: " + l3Var, e2);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (g2) invokeL.objValue;
    }
}
