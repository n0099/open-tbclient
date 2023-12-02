package com.baidu.tieba;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.audio.AudioPlayer;
import com.baidu.tieba.m04;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h04 extends EventTargetImpl implements b04, c04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioPlayer a;
    @V8JavascriptField
    public boolean autoplay;
    public String b;
    @V8JavascriptField
    public int buffered;
    public ud2 c;
    @V8JavascriptField
    public double currentTime;
    @V8JavascriptField
    public long duration;
    @V8JavascriptField
    public boolean loop;
    @V8JavascriptField
    public boolean obeyMuteSwitch;
    @V8JavascriptField
    public boolean paused;
    @V8JavascriptField
    public String src;
    @V8JavascriptField
    public float startTime;
    @V8JavascriptField
    public float volume;

    /* loaded from: classes6.dex */
    public class g implements m04.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h04 a;

        @Override // com.baidu.tieba.m04.b
        public void fail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ g b;

            public a(g gVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.src = xr2.V().I().g(this.a);
                    if (vm1.a) {
                        Log.d("Aigame AudioContext", "prepare path: " + this.b.a.src + " autoPlay: " + this.b.a.autoplay + " class: " + toString());
                    }
                    this.b.a.D(true);
                }
            }
        }

        public g(h04 h04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h04Var;
        }

        @Override // com.baidu.tieba.m04.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.c.runOnJSThread(new a(this, str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ h04 b;

        public a(h04 h04Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h04Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h04Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a && !this.b.a.I()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    this.b.a.N(g04.c(this.b));
                    h04 h04Var = this.b;
                    if (h04Var.autoplay) {
                        h04Var.a.Q();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h04 a;

        public b(h04 h04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h04Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.Q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h04 a;

        public c(h04 h04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h04Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.O();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ float a;
        public final /* synthetic */ h04 b;

        public d(h04 h04Var, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h04Var, Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h04Var;
            this.a = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.U(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h04 a;

        public e(h04 h04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h04Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.Y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h04 a;

        public f(h04 h04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h04Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.T();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h04(ud2 ud2Var) {
        super(ud2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ud2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.src = "";
        this.volume = 1.0f;
        this.obeyMuteSwitch = true;
        this.paused = true;
        this.c = ud2Var;
        z();
    }

    public static AudioPlayer B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return new AudioPlayer(str);
        }
        return (AudioPlayer) invokeL.objValue;
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || this.a == null) {
            return;
        }
        n04.h().e().post(new a(this, z));
    }

    public final void E(e04 e04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, e04Var) == null) {
            this.a.Z(e04Var);
        }
    }

    @Override // com.baidu.tieba.b04
    @JavascriptInterface
    public void seek(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048587, this, f2) == null) && this.a != null) {
            n04.h().e().post(new d(this, f2));
        }
    }

    @JavascriptInterface
    public void setDataBuffer(JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsArrayBuffer) == null) {
            n04.h().m(jsArrayBuffer, new g(this));
        }
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AudioPlayer audioPlayer = this.a;
            if (audioPlayer != null) {
                return audioPlayer.y();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a != null) {
            f04 f04Var = new f04(this, g04.i());
            f04Var.e(this);
            this.a.V(f04Var);
        }
    }

    @Override // com.baidu.tieba.b04
    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a != null) {
            n04.h().e().post(new f(this));
        }
    }

    @Override // com.baidu.tieba.b04
    public int getCurrentTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AudioPlayer audioPlayer = this.a;
            if (audioPlayer != null) {
                return audioPlayer.z();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.b04
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AudioPlayer audioPlayer = this.a;
            if (audioPlayer != null) {
                return (int) audioPlayer.A();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.b04
    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.a != null) {
            n04.h().e().post(new c(this));
        }
    }

    @Override // com.baidu.tieba.b04
    @JavascriptInterface
    public void play() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.a != null) {
            n04.h().e().post(new b(this));
        }
    }

    @Override // com.baidu.tieba.b04
    @JavascriptInterface
    public void stop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.a != null) {
            n04.h().e().post(new e(this));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            String valueOf = String.valueOf(d04.a());
            this.b = valueOf;
            this.a = B(valueOf);
            C();
        }
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (vm1.a) {
                Log.d("Aigame AudioContext", str);
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -2129294769:
                    if (str.equals("startTime")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -810883302:
                    if (str.equals("volume")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 114148:
                    if (str.equals("src")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3327652:
                    if (str.equals("loop")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1439562083:
                    if (str.equals("autoplay")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 != 0 && c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        if (c2 == 4 && this.autoplay) {
                            play();
                            return;
                        }
                        return;
                    }
                    D(false);
                    return;
                } else if (g04.b(this.volume)) {
                    E(g04.c(this));
                    return;
                } else {
                    this.volume = this.a.D();
                    return;
                }
            }
            E(g04.c(this));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.c04
    public void p(String str, JSONObject jSONObject) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, jSONObject) == null) {
            switch (str.hashCode()) {
                case -1522036513:
                    if (str.equals("buffered")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3443508:
                    if (str.equals("play")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3540994:
                    if (str.equals("stop")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 96651962:
                    if (str.equals("ended")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 96784904:
                    if (str.equals("error")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 106440182:
                    if (str.equals(DownloadStatisticConstants.UBC_TYPE_PAUSE)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 550609668:
                    if (str.equals("canplay")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1762557398:
                    if (str.equals("timeupdate")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    this.buffered = A();
                    return;
                case 1:
                    if (jSONObject != null) {
                        this.duration = getDuration() / 1000;
                        this.currentTime = getCurrentTime() / 1000.0d;
                        return;
                    }
                    return;
                case 2:
                    this.paused = false;
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    this.paused = true;
                    return;
                case 7:
                    this.duration = getDuration() / 1000;
                    return;
                default:
                    return;
            }
        }
    }
}
