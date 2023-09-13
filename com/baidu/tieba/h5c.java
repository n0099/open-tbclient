package com.baidu.tieba;

import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.common.AVframe;
import com.yy.transvod.player.common.AudioSendStamp;
import com.yy.transvod.player.common.VideoExtraInfo;
import com.yy.transvod.player.core.TransVodProxy;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaSample;
import com.yy.transvod.player.mediacodec.SEIUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h5c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicReference<TransVodProxy> a;
    public boolean b;
    public boolean c;
    public byte[] d;
    public int e;
    public long f;
    public AtomicBoolean g;
    public AtomicBoolean h;
    public c5c i;

    public h5c() {
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
        this.a = new AtomicReference<>(null);
        this.b = false;
        this.c = false;
        this.d = null;
        this.e = -1;
        this.f = 0L;
        this.g = new AtomicBoolean(true);
        this.h = new AtomicBoolean(false);
        this.i = new c5c(200);
        this.b = false;
        this.f = System.currentTimeMillis();
    }

    public static boolean a(ArrayList<VideoExtraInfo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, arrayList)) == null) {
            for (int i = 0; i < arrayList.size(); i++) {
                VideoExtraInfo videoExtraInfo = arrayList.get(i);
                if (videoExtraInfo.a == VideoExtraInfo.d) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(videoExtraInfo.c));
                        if (jSONObject.has(DI.LIVE_PLAYER)) {
                            JSONObject optJSONObject = jSONObject.optJSONObject(DI.LIVE_PLAYER);
                            if (!optJSONObject.has("split")) {
                                return false;
                            }
                            if (optJSONObject.optInt("split") != 1) {
                                return false;
                            }
                            return true;
                        }
                        continue;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void b(TransVodProxy transVodProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, transVodProxy) == null) {
            this.a.set(transVodProxy);
        }
    }

    public void f(ArrayList<AudioSendStamp> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            TransVodProxy transVodProxy = this.a.get();
            if (!arrayList.isEmpty() && transVodProxy != null) {
                transVodProxy.g(arrayList);
            }
        }
    }

    public synchronized void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            synchronized (this) {
                this.b = z;
            }
        }
    }

    public final synchronized boolean c(int i, boolean z, byte[] bArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), bArr, Integer.valueOf(i2)})) == null) {
            synchronized (this) {
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void d(MediaSample mediaSample, a5c a5cVar, String str) {
        AVframe aVframe;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mediaSample, a5cVar, str) == null) && (aVframe = mediaSample.g) != null && str != null && a5cVar != null) {
            if (mediaSample.c) {
                this.i.b(mediaSample.t);
                AVframe aVframe2 = mediaSample.g;
                e(str, aVframe2.p, aVframe2.n, a5cVar, aVframe2.e);
            } else if (aVframe.p != null) {
                g(str, mediaSample, a5cVar);
            }
        }
    }

    public void e(String str, byte[] bArr, int i, a5c a5cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, bArr, Integer.valueOf(i), a5cVar, Integer.valueOf(i2)}) == null) {
            if (bArr == null) {
                if (this.c) {
                    TLog.g(this, "TransVodMisc[dse] send a empty dse message");
                    i(i, null, a5cVar, i2);
                }
                this.c = false;
                return;
            }
            boolean c = c(i2, false, bArr, i);
            if (!c && System.currentTimeMillis() - this.f > 20000) {
                TLog.g(this, "TransVodMisc[sei] processAudioSEIInfo, ignore same audio sei notification");
                this.f = System.currentTimeMillis();
            }
            if (c) {
                Message obtain = Message.obtain();
                obtain.what = 69;
                obtain.arg1 = i;
                obtain.obj = bArr;
                a5cVar.a(obtain, i2);
            }
            ArrayList arrayList = new ArrayList();
            if (i == 1) {
                ArrayList arrayList2 = new ArrayList();
                if (SEIUtility.decodeDSEPayLoadV1(bArr, arrayList2, arrayList) > 0) {
                    if (c) {
                        i(i, arrayList2, a5cVar, i2);
                    }
                    this.c = true;
                } else if (this.c) {
                    i(i, null, a5cVar, i2);
                    this.c = false;
                }
            } else if (SEIUtility.decodeDSEPayLoadV0(bArr, arrayList) > 0) {
                if (c) {
                    i(i, arrayList, a5cVar, i2);
                }
                this.c = true;
            } else if (this.c) {
                i(i, null, a5cVar, i2);
                this.c = false;
            }
            ArrayList<AudioSendStamp> arrayList3 = new ArrayList<>();
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList3.add(new AudioSendStamp(this.i.a(), ((Long) it.next()).longValue()));
                }
            }
            f(arrayList3);
        }
    }

    public void g(String str, MediaSample mediaSample, a5c a5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, mediaSample, a5cVar) == null) {
            AVframe aVframe = mediaSample.g;
            byte[] bArr = aVframe.p;
            int i = aVframe.n;
            int i2 = aVframe.e;
            if (bArr != null && a5cVar != null) {
                if (!c(i2, true, bArr, i)) {
                    mediaSample.H = this.h.get();
                    if (System.currentTimeMillis() - this.f > 20000) {
                        TLog.g(this, "TransVodMisc[sei] processVideoSEIInfo, ignore same video sei notification");
                        this.f = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 68;
                obtain.arg1 = i;
                obtain.obj = bArr;
                a5cVar.a(obtain, i2);
                if (i != 0 && i != 1) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                SEIUtility.decodeSEIPayload(i, bArr, arrayList, arrayList2, arrayList3);
                boolean z = false;
                if (!arrayList.isEmpty()) {
                    if (this.b) {
                        Message obtain2 = Message.obtain();
                        obtain2.what = 63;
                        obtain2.arg1 = i;
                        obtain2.obj = arrayList;
                        a5cVar.a(obtain2, i2);
                    }
                    if (!this.g.get() && (z = a(arrayList)) != this.h.get()) {
                        TLog.g(this, "processVideoSEIInfo, isVideoInJoyPk: " + z + ", mVideoInJoyPk:" + this.h.get());
                    }
                }
                this.h.set(z);
                mediaSample.H = z;
                if (!arrayList2.isEmpty()) {
                    Message obtain3 = Message.obtain();
                    obtain3.what = 64;
                    obtain3.arg1 = i;
                    obtain3.obj = arrayList2;
                    a5cVar.a(obtain3, i2);
                }
                if (!arrayList3.isEmpty()) {
                    Message obtain4 = Message.obtain();
                    obtain4.what = 66;
                    obtain4.arg1 = i;
                    obtain4.obj = arrayList3;
                    a5cVar.a(obtain4, i2);
                }
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c = false;
            synchronized (this) {
                this.d = null;
                this.e = -1;
            }
        }
    }

    public final void i(int i, Object obj, a5c a5cVar, int i2) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), obj, a5cVar, Integer.valueOf(i2)}) == null) {
            Message obtain = Message.obtain();
            if (i == 1) {
                obtain.what = 65;
            } else {
                obtain.what = 67;
            }
            if (obj == null) {
                if (i == 1) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = new ArrayList();
                }
                obtain.obj = arrayList;
            } else {
                obtain.obj = obj;
            }
            a5cVar.a(obtain, i2);
        }
    }

    public synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            synchronized (this) {
                this.g.set(z);
                if (!z) {
                    synchronized (this) {
                        if (this.d != null && this.e != -1) {
                            byte[] bArr = this.d;
                            int i = this.e;
                            ArrayList arrayList = new ArrayList();
                            SEIUtility.decodeSEIPayload(i, bArr, arrayList, new ArrayList(), new ArrayList());
                            this.h.set(a(arrayList));
                        }
                    }
                    return;
                }
                TLog.g(this, "updateForceEnablePipeFlag, flag: " + z + ", mVideoInJoyPk:" + this.h.get());
            }
        }
    }
}
