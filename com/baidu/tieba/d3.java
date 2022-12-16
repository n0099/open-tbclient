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
public class d3 implements k2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SoundPool a;
    public final AudioManager b;
    public final List<w2> c;

    public d3(Context context, i2 i2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, i2Var};
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
        if (!i2Var.p) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.a = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).setMaxStreams(i2Var.q).build();
            } else {
                this.a = new SoundPool(i2Var.q, 3, 0);
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

    @Override // com.baidu.tieba.e1
    public g2 a(k3 k3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k3Var)) == null) {
            if (this.a != null) {
                n2 n2Var = (n2) k3Var;
                if (n2Var.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = n2Var.u();
                        z2 z2Var = new z2(this.a, this.b, this.a.load(u, 1));
                        u.close();
                        return z2Var;
                    } catch (IOException e) {
                        throw new GdxRuntimeException("Error loading audio file: " + k3Var + "\nNote: Internal audio files must be placed in the assets directory.", e);
                    }
                }
                try {
                    return new z2(this.a, this.b, this.a.load(n2Var.e().getPath(), 1));
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Error loading audio file: " + k3Var, e2);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (g2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.k2
    public void d(w2 w2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w2Var) == null) {
            synchronized (this.c) {
                this.c.remove(this);
            }
        }
    }

    @Override // com.baidu.tieba.i7
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            Iterator it = new ArrayList(this.c).iterator();
            while (it.hasNext()) {
                ((w2) it.next()).dispose();
            }
        }
        this.a.release();
    }

    @Override // com.baidu.tieba.k2
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            for (w2 w2Var : this.c) {
                if (w2Var.a()) {
                    w2Var.pause();
                    w2Var.d = true;
                } else {
                    w2Var.d = false;
                }
            }
        }
        this.a.autoPause();
    }

    @Override // com.baidu.tieba.k2
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

    @Override // com.baidu.tieba.e1
    public f2 f(k3 k3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, k3Var)) == null) {
            if (this.a != null) {
                n2 n2Var = (n2) k3Var;
                MediaPlayer mediaPlayer = new MediaPlayer();
                if (n2Var.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = n2Var.u();
                        mediaPlayer.setDataSource(u.getFileDescriptor(), u.getStartOffset(), u.getLength());
                        u.close();
                        mediaPlayer.prepare();
                        w2 w2Var = new w2(this, mediaPlayer);
                        synchronized (this.c) {
                            this.c.add(w2Var);
                        }
                        return w2Var;
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Error loading audio file: " + k3Var + "\nNote: Internal audio files must be placed in the assets directory.", e);
                    }
                }
                try {
                    mediaPlayer.setDataSource(n2Var.e().getPath());
                    mediaPlayer.prepare();
                    w2 w2Var2 = new w2(this, mediaPlayer);
                    synchronized (this.c) {
                        this.c.add(w2Var2);
                    }
                    return w2Var2;
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Error loading audio file: " + k3Var, e2);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (f2) invokeL.objValue;
    }
}
