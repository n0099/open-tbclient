package com.baidu.tieba;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class dnb {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean a;
    public static AtomicBoolean b;
    public static Context c;
    public static final LinkedList<WeakReference<b>> d;
    public static AtomicBoolean e;
    public static final LinkedList<WeakReference<ulb>> f;
    public static AudioManager.OnAudioFocusChangeListener g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface b {
        void c(boolean z);
    }

    /* loaded from: classes5.dex */
    public static class a implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != -2 && i != -1) {
                    if (i == 1) {
                        dnb.a.set(true);
                        dnb.b.set(true);
                        dnb.j(true);
                        TLog.h("[AudioFocusListener]", "mOnAudioFocusChangeListener AUDIOFOCUS_GAIN,mIsFocusGain=" + dnb.a.get());
                    }
                } else {
                    dnb.a.set(false);
                    dnb.b.set(false);
                    dnb.j(false);
                    StringBuilder sb = new StringBuilder();
                    sb.append("mOnAudioFocusChangeListener ");
                    if (i == -1) {
                        str = "AUDIOFOCUS_LOSS";
                    } else {
                        str = "AUDIOFOCUS_LOSS_TRANSIENT";
                    }
                    sb.append(str);
                    sb.append(", pause audio rendering,mIsFocusGain=");
                    sb.append(dnb.a.get());
                    TLog.h("[AudioFocusListener]", sb.toString());
                }
                synchronized (dnb.e) {
                    Iterator it = dnb.f.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference.get() != null) {
                            TLog.h("[AudioFocusListener]", "mOnAudioFocusChangeListener mExtraListener: " + weakReference.get() + ",mIsFocusGain:" + dnb.a.get() + ",focusChange:" + i);
                            ((ulb) weakReference.get()).onAudioFocusChange(i);
                            break;
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947711729, "Lcom/baidu/tieba/dnb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947711729, "Lcom/baidu/tieba/dnb;");
                return;
            }
        }
        a = new AtomicBoolean(false);
        b = new AtomicBoolean(false);
        c = null;
        d = new LinkedList<>();
        e = new AtomicBoolean(false);
        f = new LinkedList<>();
        g = new a();
    }

    public dnb() {
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

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a.set(false);
            b.set(false);
            Context context = c;
            if (context == null) {
                TLog.d("[AudioFocusListener]", "abandonAudioFocus called,mAppContext==null,mIsFocusGain:" + a.get());
                return;
            }
            ((AudioManager) context.getSystemService("audio")).abandonAudioFocus(g);
            TLog.h("[AudioFocusListener]", "abandonAudioFocus called.,mIsFocusGain:" + a.get() + ",mIsRequestFocusGain:" + b.get());
        }
    }

    public static void g(Context context, b bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, bVar) == null) {
            synchronized (dnb.class) {
                if (c == null) {
                    c = context;
                }
                Iterator<WeakReference<b>> it = d.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (bVar == it.next().get()) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    d.add(new WeakReference<>(bVar));
                }
            }
        }
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            e.set(z);
            TLog.h("AudioFocus", " enableAutoControl:" + z + ",mIsFocusGain:" + a.get());
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            TLog.h("AudioFocus", " forceGainFocus start enableAutoControl:" + e.get() + ",mIsFocusGain:" + a.get() + " mIsRequestFocusGain:" + b.get());
            if (!e.get()) {
                a.set(true);
                TLog.h("AudioFocus", " forceGainFocus enableAutoControl:" + e.get() + ",mIsFocusGain:" + a.get());
                return;
            }
            synchronized (dnb.class) {
                if (!b.get()) {
                    a();
                    l();
                }
            }
            TLog.h("AudioFocus", " forceGainFocus end enableAutoControl:" + e.get() + ",mIsFocusGain:" + a.get() + " mIsRequestFocusGain:" + b.get());
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            LinkedList linkedList = new LinkedList();
            synchronized (dnb.class) {
                Iterator<WeakReference<b>> it = d.iterator();
                while (it.hasNext()) {
                    b bVar = it.next().get();
                    if (bVar != null) {
                        linkedList.add(bVar);
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    ((b) it2.next()).c(z);
                }
            }
        }
    }

    public static synchronized void k(b bVar) {
        WeakReference<b> weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, bVar) == null) {
            synchronized (dnb.class) {
                Iterator<WeakReference<b>> it = d.iterator();
                while (true) {
                    if (it.hasNext()) {
                        weakReference = it.next();
                        if (weakReference.get() == bVar) {
                            break;
                        }
                    } else {
                        weakReference = null;
                        break;
                    }
                }
                if (weakReference != null) {
                    d.remove(weakReference);
                }
                if (d.isEmpty()) {
                    if (c == null) {
                        return;
                    }
                    if (e.get()) {
                        a();
                    }
                    c = null;
                }
            }
        }
    }

    public static void m(ulb ulbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, ulbVar) == null) {
            synchronized (e) {
                TLog.h("AudioFocus", " setFocusChangeExtraListener:" + ulbVar);
                boolean z = true;
                Iterator<WeakReference<ulb>> it = f.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (ulbVar == it.next().get()) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    f.add(new WeakReference<>(ulbVar));
                }
            }
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            Context context = c;
            if (context == null) {
                TLog.d("[AudioFocusListener]", "requestAudioFocus called,mAppContext==null,mIsFocusGain:" + a.get());
                return;
            }
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                TLog.d("[AudioFocusListener]", "requestAudioFocus called,audioManager==null,mIsFocusGain:" + a.get());
            } else if (audioManager.requestAudioFocus(g, 3, 1) != 1) {
                a.set(false);
                b.set(false);
                TLog.h("[AudioFocusListener]", "reqeustAudioFocus result != AUDIOFOCUS_REQUEST_GRANTED, pause audio render.,mIsFocusGain:" + a.get());
            } else {
                a.set(true);
                b.set(true);
                j(true);
                TLog.h("[AudioFocusListener]", "reqeustAudioFocus AUDIOFOCUS_REQUEST_GRANTED.,mIsFocusGain:" + a.get());
            }
        }
    }
}
