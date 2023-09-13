package com.baidu.tieba;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes5.dex */
public class cb4 extends hb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int e;
    public String f;
    public boolean g;
    public ArrayList<kb4> h;
    public List<String> i;
    public List<String> j;

    /* loaded from: classes5.dex */
    public class a implements lb4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o32 a;
        public final /* synthetic */ cb4 b;

        public a(cb4 cb4Var, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb4Var, o32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cb4Var;
            this.a = o32Var;
        }

        @Override // com.baidu.tieba.lb4
        public void a(mb4 mb4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, mb4Var, str) == null) {
                this.b.A(this.a, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb4(ri2 ri2Var) {
        super(ri2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ri2Var};
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
        this.g = false;
        this.h = new ArrayList<>();
        this.i = new ArrayList(3);
        this.j = new ArrayList(3);
    }

    public final boolean E(GameRecorderController.RecorderState... recorderStateArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, recorderStateArr)) == null) {
            GameRecorderController.RecorderState l = ib4.a().b().l();
            if (hb4.d) {
                Log.d("GameRecorderApi", "RecorderState:" + l);
            }
            if (recorderStateArr == null) {
                return true;
            }
            for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
                if (l == recorderState) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void A(o32 o32Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, o32Var, str) == null) {
            if (hb4.d) {
                Log.d("GameRecorderApi", "callFailureCallback: errMsg=" + str);
            }
            td4.call(o32Var, false, new db4(str));
        }
    }

    @NonNull
    public final String B(String str, @NonNull List<String> list, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list, i)) == null) {
            if (list.size() >= i) {
                String remove = list.remove(0);
                lr4.k(rn2.N(remove));
                if (hb4.d) {
                    Log.d("GameRecorderApi", "deleteFile: " + remove);
                }
            }
            String format = String.format(Locale.CHINA, str, Long.valueOf(System.currentTimeMillis()));
            list.add(format);
            return format;
        }
        return (String) invokeLLI.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (hb4.d) {
                Log.d("GameRecorderApi", "doStartRecorder:" + this.e + "," + this.f);
            }
            this.h.clear();
            this.g = false;
            ib4.a().b().t(this.e, this.f);
        }
    }

    public final boolean D(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dArr)) == null) {
            if (dArr == null || dArr.length < 2) {
                return false;
            }
            long j = (long) (dArr[0] * 1000.0d);
            long j2 = (long) (dArr[1] * 1000.0d);
            if (j < 0 || j2 < 0 || j + j2 <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public final o32 F(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            o32 F = o32.F(jsObject);
            if (F == null) {
                return new o32();
            }
            return F;
        }
        return (o32) invokeL.objValue;
    }

    public final void G(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) && jsObject != null) {
            jsObject.release();
        }
    }

    @JavascriptInterface
    public void clipVideo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) {
            o32 F = F(jsObject);
            String B = F.B("path");
            if (hb4.d) {
                Log.d("GameRecorderApi", "clipPath:" + B + "，hasExecutedClip：" + this.g);
            }
            if (this.g) {
                return;
            }
            if (E(GameRecorderController.RecorderState.STOP)) {
                A(F, "clipVideo can only called after onStop");
            } else if (this.h.isEmpty()) {
                A(F, "range is illegal");
            } else {
                new nb4(this.h, rn2.B(B), rn2.N(B("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.j, 3))).c(new a(this, F));
                this.h.clear();
                this.g = true;
                ji3 ji3Var = new ji3();
                ji3Var.b = "clipVideo";
                ai3.h(ji3Var);
            }
        }
    }

    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (hb4.d) {
                Log.d("GameRecorderApi", DownloadStatisticConstants.UBC_TYPE_PAUSE);
            }
            if (E(GameRecorderController.RecorderState.RECORDING)) {
                return;
            }
            ib4.a().b().o();
        }
    }

    @JavascriptInterface
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (hb4.d) {
                Log.d("GameRecorderApi", DownloadStatisticConstants.UBC_TYPE_RESUME);
            }
            if (!E(GameRecorderController.RecorderState.PAUSE) && !ib4.a().c()) {
                ib4.a().b().q();
            }
        }
    }

    @JavascriptInterface
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (hb4.d) {
                Log.d("GameRecorderApi", "stop");
            }
            if (E(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            ib4.a().b().u();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            o32 F = F(jsObject);
            if (E(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            double[] o = F.o("timeRange");
            G(jsObject);
            if (!D(o)) {
                o = new double[]{3.0d, 3.0d};
            }
            kb4 b = kb4.b(ib4.a().b().k(), o[0], o[1]);
            if (hb4.d) {
                Log.d("GameRecorderApi", "recordClip:" + b.toString());
            }
            this.h.add(b);
            ji3 ji3Var = new ji3();
            ji3Var.b = "recordClip";
            ai3.h(ji3Var);
        }
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            if (hb4.d) {
                Log.d("GameRecorderApi", "start");
            }
            if (!E(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) && !ib4.a().c()) {
                o32 F = F(jsObject);
                int r = F.r("duration", 10);
                this.e = r;
                if (r <= 0) {
                    this.e = 10;
                }
                if (this.e > 120) {
                    this.e = 120;
                }
                if (this.i.size() == 0) {
                    lr4.k(rn2.N("bdfile://tmp/SwanVideoRecorder/"));
                }
                String B = B("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.i, 3);
                y(B);
                String N = rn2.N(B);
                this.f = N;
                if (N == null) {
                    if (hb4.d) {
                        Log.e("GameRecorderApi", "recordPath == null.");
                        return;
                    }
                    return;
                }
                if (F.m("microphoneEnabled", false)) {
                    x(2);
                }
                C();
                tb4.l();
            }
        }
    }

    @JavascriptInterface
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            start(null);
        }
    }
}
