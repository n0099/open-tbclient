package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.ARType;
import com.baidu.ar.DefinedLuaListener;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.DuMixController;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixInput2;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.DuMixOutput2;
import com.baidu.ar.DuMixStateListener;
import com.baidu.ar.arrender.ARRenderFpsCallback;
import com.baidu.ar.arrender.FrameRenderListener;
import com.baidu.ar.arrender.IGLRenderer;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.capture.ICaptureAbilityListener;
import com.baidu.ar.capture.ICaptureResult;
import com.baidu.ar.face.FaceListener;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.filter.FilterStateListener;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.minivideo.arface.bean.Makeup;
import com.baidu.minivideo.arface.bean.SharpnessFilter;
import com.baidu.minivideo.plugin.capture.bean.FaceItem;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tieba.ye0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ge0 {
    public static /* synthetic */ Interceptable $ic;
    public static ge0 a0;
    public static boolean b0;
    public static final l c0;
    public static boolean d0;
    public static long e0;
    public static String f0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public long B;
    public long C;
    public af0 D;
    public HashMap<BeautyType, String> E;
    public JSONObject F;
    public JSONObject G;
    public Makeup H;
    public HandlerThread I;
    public Handler J;
    public int K;
    public boolean L;
    public boolean M;
    public bf0 N;
    public List<ARRenderFpsCallback> O;
    public List<FrameRenderListener> P;
    public String Q;
    public String R;
    public boolean S;
    public boolean T;
    public boolean U;
    public int V;
    public int W;
    public JSONObject X;
    public JSONObject Y;
    public DuMixCallback Z;
    public Context a;
    public EGLContext b;
    public l c;
    public boolean d;
    public boolean e;
    public DuMixController f;
    public List<DuMixCallback> g;
    public DuMixInput h;
    public DuMixOutput i;
    public SurfaceTexture.OnFrameAvailableListener j;
    public SurfaceTexture.OnFrameAvailableListener k;
    public FaceListener l;
    public LuaMsgListener m;
    public FilterStateListener n;
    public DefinedLuaListener o;
    public DuMixStateListener p;
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public Texture w;
    public Texture x;
    public long y;
    public long z;

    /* loaded from: classes4.dex */
    public class a implements FrameRenderListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge0 a;

        public a(ge0 ge0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge0Var;
        }

        @Override // com.baidu.ar.arrender.FrameRenderListener
        public void onRenderFinished(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                if (!ge0.d0) {
                    if (this.a.A < 2) {
                        ge0.v(this.a);
                        GLES20.glFinish();
                        return;
                    }
                    return;
                }
                GLES20.glFinish();
            }
        }

        @Override // com.baidu.ar.arrender.FrameRenderListener
        public void onRenderStarted(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DuMixCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge0 a;

        public b(ge0 ge0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge0Var;
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseCreate(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                if (ge0.d0()) {
                    ge0.Q("DuAr_DuController", "onCaseCreate: b = " + z + " , id = " + str2 + " , path = " + str);
                }
                for (int i = 0; i < this.a.g.size(); i++) {
                    DuMixCallback duMixCallback = (DuMixCallback) this.a.g.get(i);
                    if (duMixCallback != null) {
                        duMixCallback.onCaseCreate(z, str, str2);
                    }
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (ge0.d0()) {
                    ge0.Q("DuAr_DuController", "onCaseDestroy");
                }
                for (int i = 0; i < this.a.g.size(); i++) {
                    DuMixCallback duMixCallback = (DuMixCallback) this.a.g.get(i);
                    if (duMixCallback != null) {
                        duMixCallback.onCaseDestroy();
                    }
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, duMixErrorType, str, str2) == null) {
                if (ge0.d0()) {
                    ge0.Q("DuAr_DuController", "onError Type: " + duMixErrorType.name() + ", msg: " + str + ", ext: " + str2);
                }
                for (DuMixCallback duMixCallback : this.a.g) {
                    duMixCallback.onError(duMixErrorType, str, str2);
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (ge0.d0()) {
                    ge0.Q("DuAr_DuController", "onRelease");
                }
                for (int i = 0; i < this.a.g.size(); i++) {
                    DuMixCallback duMixCallback = (DuMixCallback) this.a.g.get(i);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                }
                this.a.g.clear();
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), duMixInput, duMixOutput}) == null) {
                this.a.z = System.currentTimeMillis() - this.a.y;
                if (ge0.d0()) {
                    ge0.Q("DuAr_DuController", Build.MODEL + ", onSetup: " + z + ", spendTime:" + this.a.z);
                }
                this.a.v = z;
                this.a.p0(z);
                this.a.E.clear();
                for (int i = 0; i < this.a.g.size(); i++) {
                    DuMixCallback duMixCallback = (DuMixCallback) this.a.g.get(i);
                    if (duMixCallback != null) {
                        duMixCallback.onSetup(z, duMixInput, duMixOutput);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FaceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge0 a;

        public c(ge0 ge0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge0Var;
        }

        @Override // com.baidu.ar.face.FaceListener
        public void onFaceResult(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.a.l == null) {
                return;
            }
            this.a.l.onFaceResult(obj);
        }

        @Override // com.baidu.ar.face.FaceListener
        public void onStickerLoadingFinished(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.a.l == null) {
                return;
            }
            this.a.l.onStickerLoadingFinished(list);
        }

        @Override // com.baidu.ar.face.FaceListener
        public void onTriggerFired(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.l == null) {
                return;
            }
            this.a.l.onTriggerFired(str);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements LuaMsgListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge0 a;

        public d(ge0 ge0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge0Var;
        }

        @Override // com.baidu.ar.lua.LuaMsgListener
        public List<String> getMsgKeyListened() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<String> msgKeyListened = this.a.m != null ? this.a.m.getMsgKeyListened() : null;
                if (ge0.d0()) {
                    if (msgKeyListened == null) {
                        ge0.Q("DuAr_DuController", "getMsgKeyListened: " + ((Object) null));
                    } else {
                        Iterator<String> it = msgKeyListened.iterator();
                        while (it.hasNext()) {
                            ge0.Q("DuAr_DuController", "getMsgKeyListened: " + it.next());
                        }
                    }
                }
                return msgKeyListened;
            }
            return (List) invokeV.objValue;
        }

        @Override // com.baidu.ar.lua.LuaMsgListener
        public void onLuaMessage(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
                if (ge0.d0()) {
                    if (hashMap == null) {
                        ge0.Q("DuAr_DuController", "onLuaMessage: " + ((Object) null));
                    } else {
                        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                            ge0.Q("DuAr_DuController", "onLuaMessage: " + entry.getKey() + ZeusCrashHandler.NAME_SEPERATOR + entry.getValue());
                        }
                    }
                }
                if (this.a.m != null) {
                    this.a.m.onLuaMessage(hashMap);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements DefinedLuaListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge0 a;

        public e(ge0 ge0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge0Var;
        }

        @Override // com.baidu.ar.DefinedLuaListener
        public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, hashMap) == null) {
                if (ge0.d0()) {
                    String Y = ge0.Y(hashMap);
                    ge0.Q("DuAr_DuController", "onOpenUrl: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + Y);
                }
                if (this.a.o != null) {
                    this.a.o.onOpenUrl(str, i, hashMap);
                }
            }
        }

        @Override // com.baidu.ar.DefinedLuaListener
        public void onRequireSwitchCamera(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (ge0.d0()) {
                    ge0.Q("DuAr_DuController", "onRequireSwitchCamera: " + i);
                }
                if (this.a.o != null) {
                    this.a.o.onRequireSwitchCamera(i);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements FilterStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge0 a;

        public f(ge0 ge0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge0Var;
        }

        @Override // com.baidu.ar.filter.FilterStateListener
        public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, hashMap, str) == null) {
                if (ge0.d0()) {
                    ge0.Q("DuAr_DuController", "onFilterStateChanged: " + ge0.Y(hashMap) + "\n" + str);
                }
                FilterStateListener filterStateListener = this.a.n;
                if (filterStateListener != null) {
                    filterStateListener.onFilterStateChanged(hashMap, str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements DuMixStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge0 a;

        public g(ge0 ge0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge0Var;
        }

        @Override // com.baidu.ar.DuMixStateListener
        public void onInputSurfaceTextureAttach(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) {
                if (ge0.d0()) {
                    ge0.Q("DuAr_DuController", "onInputSurfaceTextureAttach: " + surfaceTexture);
                }
                if (this.a.p != null) {
                    this.a.p.onInputSurfaceTextureAttach(surfaceTexture);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge0 a;

        public h(ge0 ge0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge0Var;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) {
                this.a.D.d();
                if (this.a.N != null) {
                    this.a.N.d();
                }
                if (this.a.j != null) {
                    this.a.j.onFrameAvailable(surfaceTexture);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements FrameRenderListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge0 a;

        public i(ge0 ge0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge0Var;
        }

        @Override // com.baidu.ar.arrender.FrameRenderListener
        public void onRenderFinished(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                for (int i = 0; i < this.a.P.size(); i++) {
                    FrameRenderListener frameRenderListener = (FrameRenderListener) this.a.P.get(i);
                    if (frameRenderListener != null) {
                        frameRenderListener.onRenderFinished(j);
                    }
                }
            }
        }

        @Override // com.baidu.ar.arrender.FrameRenderListener
        public void onRenderStarted(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                for (int i = 0; i < this.a.P.size(); i++) {
                    FrameRenderListener frameRenderListener = (FrameRenderListener) this.a.P.get(i);
                    if (frameRenderListener != null) {
                        frameRenderListener.onRenderStarted(j);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements ARRenderFpsCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge0 a;

        public j(ge0 ge0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge0Var;
        }

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public int listenType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public void onRenderFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.N != null) {
                    this.a.N.e();
                }
                for (int i = 0; i < this.a.O.size(); i++) {
                    ARRenderFpsCallback aRRenderFpsCallback = (ARRenderFpsCallback) this.a.O.get(i);
                    if (aRRenderFpsCallback != null) {
                        aRRenderFpsCallback.onRenderFinished();
                    }
                }
            }
        }

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public void onRenderStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.N != null) {
                    this.a.N.f();
                }
                for (int i = 0; i < this.a.O.size(); i++) {
                    ARRenderFpsCallback aRRenderFpsCallback = (ARRenderFpsCallback) this.a.O.get(i);
                    if (aRRenderFpsCallback != null) {
                        aRRenderFpsCallback.onRenderStarted();
                    }
                }
            }
        }

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public void renderFps(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ge0 ge0Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge0Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge0Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i == 1) {
                    this.a.m0();
                } else if (i == 2) {
                    this.a.o0();
                } else if (i != 3) {
                    if (i == 4) {
                        this.a.z0(message);
                    } else if (i != 5) {
                    } else {
                        this.a.A0(message);
                    }
                } else {
                    ye0.a aVar = new ye0.a();
                    aVar.a = (int) ze0.e().a();
                    ActivityManager.MemoryInfo f = ze0.e().f();
                    if (f != null) {
                        aVar.b = ((f.totalMem / 1024) / 1024) - ((f.availMem / 1024) / 1024);
                    }
                    if (this.a.N != null) {
                        if (this.a.M) {
                            aVar.d = this.a.N.a(true);
                            aVar.e = this.a.N.c(true);
                        } else {
                            aVar.f = this.a.N.a(false);
                            aVar.g = this.a.N.c(false);
                        }
                        aVar.c = this.a.N.b();
                        this.a.N.g();
                    }
                    aVar.h = this.a.Q;
                    aVar.i = this.a.R;
                    aVar.j = this.a.T;
                    aVar.k = this.a.S;
                    aVar.l = this.a.U;
                    aVar.m = this.a.V;
                    aVar.n = this.a.W;
                    aVar.o = this.a.S();
                    aVar.p = this.a.W();
                    ge0 ge0Var = this.a;
                    ge0Var.n0(aVar, ge0Var.M);
                    sendMessageDelayed(obtainMessage(3), 5000L);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface l {
        void onHolderChanged(l lVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947790903, "Lcom/baidu/tieba/ge0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947790903, "Lcom/baidu/tieba/ge0;");
                return;
            }
        }
        ie0.b();
        b0 = false;
        c0 = null;
        d0 = false;
    }

    public ge0(Context context, l lVar, EGLContext eGLContext, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, lVar, eGLContext, bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = false;
        this.g = new ArrayList();
        this.q = 1280;
        this.r = 720;
        this.s = 720;
        this.t = 1280;
        this.u = false;
        this.v = false;
        this.A = 0;
        this.E = new HashMap<>();
        this.F = new JSONObject();
        this.G = new JSONObject();
        this.K = 0;
        this.L = false;
        this.M = false;
        this.O = new ArrayList();
        this.P = new ArrayList();
        this.S = false;
        this.T = false;
        this.U = false;
        this.X = new JSONObject();
        this.Y = new JSONObject();
        this.Z = new b(this);
        if (d0()) {
            Q("DuAr_DuController", "create ARControllerProxy holder=" + lVar + ", eglCxt=" + eGLContext);
        }
        HandlerThread handlerThread = new HandlerThread("ARControllerProxy");
        this.I = handlerThread;
        handlerThread.start();
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = eGLContext;
        this.c = lVar;
        DuMixController duMixController = DuMixController.getInstance(applicationContext, he0.d(eGLContext));
        this.f = duMixController;
        if (bArr != null && bArr.length > 0) {
            l0(duMixController.checkAuth(bArr, null, null));
            this.f.setAuthLicense(bArr, DuMixARConfig.getAipAppId(), DuMixARConfig.getAPIKey(), DuMixARConfig.getSecretKey());
        } else {
            l0(null);
        }
        R(false);
        this.f.getARProxyManager().getFaceAR().setFaceListener(new c(this));
        this.f.addLuaMsgListener(new d(this));
        this.f.setDefinedLuaListener(new e(this));
        this.f.setFilterStateListener(new f(this));
        this.f.setStateListener(new g(this));
        this.k = new h(this);
        this.f.addFrameRenderListener(new i(this));
        this.f.setARRenderFpsCallback(new j(this));
        af0 af0Var = new af0(FpsConstants.REPORT_FPS, "ar");
        this.D = af0Var;
        af0Var.f(5000L);
        this.N = new bf0();
    }

    public static boolean M(ge0 ge0Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, ge0Var, obj)) == null) ? (ge0Var == null || ge0Var.g0() || ge0Var.T() != obj) ? false : true : invokeLL.booleanValue;
    }

    public static void Q(String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) && d0()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ar->");
            sb.append(str2);
            if (a0 == null) {
                str3 = "";
            } else {
                str3 = " by: " + a0.c;
            }
            sb.append(str3);
            Log.e(str, sb.toString());
        }
    }

    public static ge0 U(Context context, l lVar, EGLContext eGLContext, byte[] bArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, context, lVar, eGLContext, bArr)) == null) {
            ge0 ge0Var = a0;
            if (ge0Var == null || ge0Var.c != lVar || ge0Var.b != eGLContext) {
                synchronized (ge0.class) {
                    if (a0 == null || a0.c != lVar || a0.b != eGLContext) {
                        if (a0 != null) {
                            l lVar2 = a0.c;
                            a0.B0();
                            if (lVar2 != null) {
                                lVar2.onHolderChanged(lVar);
                            }
                        }
                        a0 = new ge0(context, lVar, eGLContext, bArr);
                    }
                }
            }
            return a0;
        }
        return (ge0) invokeLLLL.objValue;
    }

    public static ge0 V(Context context, l lVar, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, context, lVar, bArr)) == null) ? U(context, lVar, null, bArr) : (ge0) invokeLLL.objValue;
    }

    public static String Y(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, map)) == null) {
            StringBuilder sb = new StringBuilder();
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                for (Map.Entry entry : map.entrySet()) {
                    if (entry.getKey() != null) {
                        sb.append(entry.getKey().toString());
                        if (entry.getValue() != null) {
                            sb.append(',');
                            sb.append(entry.getValue().toString());
                        }
                        sb.append('\n');
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            int versionCode = DuMixController.getVersionCode();
            if (d0()) {
                kf0.a("DuAr_DuController", " getSdkVersion: " + versionCode);
            }
            return versionCode;
        }
        return invokeV.intValue;
    }

    public static String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            String versionName = DuMixController.getVersionName();
            if (d0()) {
                kf0.a("DuAr_DuController", " getVersionName:" + versionName);
            }
            return versionName;
        }
        return (String) invokeV.objValue;
    }

    public static boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? he0.m() : invokeV.booleanValue;
    }

    public static void h1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65564, null, z) == null) {
            d0 = z;
            Q("DuAr_DuController", "setSyncInputContent : " + z);
        }
    }

    public static boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? b0 : invokeV.booleanValue;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            boolean z = b0;
            if (z) {
                return z;
            }
            if (!jf0.a(he0.e())) {
                try {
                    System.loadLibrary(SwanKV.LIB_CPP_SHARED);
                    System.loadLibrary("ardatabasic2");
                    System.loadLibrary("opencv_java3");
                    System.loadLibrary("anakin_lite");
                    System.loadLibrary("FaceAttributes");
                    System.loadLibrary("EglCore2");
                    System.loadLibrary("AREngineCpp2");
                    System.loadLibrary("FaceAlgoSDK2");
                    System.loadLibrary("ARMdlSDK2");
                    if (d0()) {
                        kf0.a("DuAr_UGC_SO", "so loaded!");
                    }
                    b0 = true;
                }
            } else {
                try {
                    String absolutePath = pe0.j(BdUploadHandler.MEDIA_SOURCE_KEY).m().getAbsolutePath();
                    System.load(absolutePath + "/libc++_shared.so");
                    System.load(absolutePath + "/libardatabasic.so");
                    System.load(absolutePath + "/libopencv_java3.so");
                    System.load(absolutePath + "/libanakin_lite.so");
                    System.load(absolutePath + "/libFaceAttributes.so");
                    System.load(absolutePath + "/libEglCore.so");
                    System.load(absolutePath + "/libAREngineCpp.so");
                    System.load(absolutePath + "/libFaceAlgoSDK.so");
                    System.load(absolutePath + "/libARMdlSDK.so");
                    b0 = true;
                } catch (Throwable th) {
                    b0 = false;
                    if (d0()) {
                        kf0.a("DuAr_", " load so error message " + th.getMessage());
                    }
                }
            }
            return b0;
        }
        return invokeV.booleanValue;
    }

    public static boolean k1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) ? !TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public static /* synthetic */ int v(ge0 ge0Var) {
        int i2 = ge0Var.A;
        ge0Var.A = i2 + 1;
        return i2;
    }

    public final void A0(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    if (data.getBoolean("makeup_clear")) {
                        this.Y = new JSONObject();
                    } else {
                        String string = data.getString("makeup_type");
                        String string2 = data.getString("makeup_id");
                        String string3 = data.getString("makeup_name");
                        float f2 = data.getFloat("makeup_value");
                        JSONObject jSONObject = this.Y;
                        jSONObject.put(string, f2 + "_" + string2 + "_" + string3);
                    }
                }
            } catch (Exception e2) {
                if (d0()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && a0 == this) {
            this.d = false;
            this.e = true;
            this.u = false;
            this.v = false;
            this.c = c0;
            DuMixController duMixController = this.f;
            this.f = null;
            f0 = this.D.c();
            if (duMixController != null) {
                Q("DuAr_DuController", "release");
                this.B = System.currentTimeMillis();
                duMixController.release();
                e0 = System.currentTimeMillis() - this.B;
                if (d0()) {
                    Q("DuAr_DuController", Build.MODEL + ", release spendTime: " + e0);
                }
            }
            if (Build.VERSION.SDK_INT >= 18) {
                this.I.quitSafely();
            } else {
                this.I.quit();
            }
            a0 = null;
            this.b = null;
            bf0 bf0Var = this.N;
            if (bf0Var != null) {
                bf0Var.g();
            }
        }
    }

    public void C0() {
        DuMixController duMixController;
        IGLRenderer gLRenderer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (duMixController = this.f) == null || (gLRenderer = duMixController.getGLRenderer()) == null) {
            return;
        }
        if (d0) {
            GLES20.glFinish();
        }
        gLRenderer.render();
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new Point(0, 0));
            arrayList2.add(new Point(75, 61));
            arrayList2.add(new Point(HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 172));
            arrayList2.add(new Point(255, 255));
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(new Point(0, 0));
            arrayList3.add(new Point(121, 122));
            arrayList3.add(new Point(255, 255));
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(new Point(0, 0));
            arrayList4.add(new Point(125, 117));
            arrayList4.add(new Point(255, 255));
            ArrayList arrayList5 = new ArrayList();
            arrayList5.add(new Point(0, 0));
            arrayList5.add(new Point(127, 111));
            arrayList5.add(new Point(255, 255));
            arrayList.add(arrayList2);
            arrayList.add(arrayList3);
            arrayList.add(arrayList4);
            arrayList.add(arrayList5);
            U0(arrayList);
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.w = null;
            this.x = null;
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && a0 == this) {
            if (this.f != null) {
                Q("DuAr_DuController", "resume");
                this.f.resume();
                this.d = false;
            }
            this.D.e();
        }
    }

    public final void G0(BeautyType beautyType, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, beautyType, obj) == null) || beautyType == null || obj == null) {
            return;
        }
        try {
            Message message = new Message();
            message.what = 4;
            Bundle bundle = new Bundle();
            bundle.putString("beauty_type", beautyType.name());
            if (obj instanceof Integer) {
                bundle.putInt("beauty_value", ((Integer) obj).intValue());
            } else if (obj instanceof Float) {
                bundle.putFloat("beauty_value", ((Float) obj).floatValue());
            } else if (obj instanceof String) {
                bundle.putString("beauty_value", (String) obj);
            }
            message.setData(bundle);
            Z().sendMessage(message);
        } catch (Exception e2) {
            if (d0()) {
                e2.printStackTrace();
            }
        }
    }

    public final void H0(BeautyType beautyType, Makeup makeup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, beautyType, makeup) == null) {
            try {
                Message message = new Message();
                message.what = 5;
                Bundle bundle = new Bundle();
                if (beautyType == null) {
                    bundle.putBoolean("makeup_clear", true);
                    message.setData(bundle);
                    Z().sendMessage(message);
                } else if (makeup != null) {
                    bundle.putString("makeup_type", beautyType.name());
                    bundle.putString("makeup_name", makeup.getMakeupName());
                    bundle.putString("makeup_id", makeup.getId());
                    bundle.putFloat("makeup_value", makeup.getValue());
                    message.setData(bundle);
                    Z().sendMessage(message);
                }
            } catch (Exception e2) {
                if (d0()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void I0(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hashMap) == null) || this.f == null || hashMap == null) {
            return;
        }
        if (d0()) {
            kf0.a("DuAr_DuController", "sendMessage2Lua " + hashMap);
        }
        this.f.sendMsg2Lua(hashMap);
    }

    public void J0(ARRenderFpsCallback aRRenderFpsCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aRRenderFpsCallback) == null) || aRRenderFpsCallback == null || this.O.contains(aRRenderFpsCallback)) {
            return;
        }
        this.O.add(aRRenderFpsCallback);
    }

    public void K(DuMixCallback duMixCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, duMixCallback) == null) {
            if (duMixCallback != null && !this.g.contains(duMixCallback)) {
                this.g.add(duMixCallback);
            }
            kf0.a("DuAr_DuController", "addDuMixCallback size " + this.g.size());
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && e0()) {
            if (d0()) {
                Q("DuAr_DuController", "setAllQualityParmForCartoon");
            }
            D0();
            DuMixController duMixController = this.f;
            if (duMixController != null) {
                duMixController.updateFilter((FilterParam) FilterParam.TuneColorFilter.brightness, -0.01f);
                duMixController.updateFilter((FilterParam) FilterParam.TuneColorFilter.contrast, 0.86f);
                duMixController.updateFilter((FilterParam) FilterParam.TuneColorFilter.saturation, 0.79f);
            }
        }
    }

    public void L(LuaMsgListener luaMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, luaMsgListener) == null) {
            this.m = luaMsgListener;
        }
    }

    public void L0(BeautyType beautyType, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048589, this, beautyType, f2) == null) {
            if (d0()) {
                kf0.a("DuAr_DuController", " updateFilter :" + beautyType + " = " + f2);
            }
            if (!e0() || beautyType == null) {
                return;
            }
            this.f.updateFilter(beautyType.type, f2);
            u0(beautyType, Float.valueOf(f2));
        }
    }

    public void M0(BeautyType beautyType, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, beautyType, i2) == null) {
            if (d0()) {
                kf0.a("DuAr_DuController", " updateFilter :" + beautyType + " = " + i2);
            }
            if (!e0() || beautyType == null) {
                return;
            }
            this.f.updateFilter(beautyType.type, i2);
            u0(beautyType, Integer.valueOf(i2));
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (d0()) {
                kf0.a("DuAr_DuController", " clearAllFilter :");
            }
            DuMixController duMixController = this.f;
            if (duMixController != null) {
                duMixController.clearAllFilter();
            }
        }
    }

    public void N0(BeautyType beautyType, Makeup makeup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, beautyType, makeup) == null) || makeup == null) {
            return;
        }
        String str = "";
        DuMixController duMixController = this.f;
        if (duMixController != null) {
            if (beautyType != null) {
                if (!TextUtils.equals(this.E.get(beautyType), makeup.getResPath()) && (str = duMixController.updateFilterCase(makeup.getResPath())) != null) {
                    this.E.put(beautyType, makeup.getResPath());
                }
                duMixController.updateFilter(beautyType.type, makeup.getValue());
            } else {
                this.E.clear();
                str = duMixController.updateFilterCase(makeup.getResPath());
            }
            w0(makeup);
            H0(beautyType, makeup);
        }
        if (d0()) {
            kf0.a("DuAr_DuController", " updateMakeup: " + beautyType + " = " + makeup.getInfo() + ", resResult: " + str);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            FilterStateListener filterStateListener = this.n;
            if (filterStateListener != null) {
                filterStateListener.onFilterStateChanged(null, null);
            }
            if (this.f == null || !h0()) {
                return;
            }
            this.f.clearCase();
        }
    }

    public void O0(BeautyType beautyType, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, beautyType, obj) == null) {
            if (obj instanceof Integer) {
                M0(beautyType, ((Integer) obj).intValue());
            } else if (obj instanceof Float) {
                L0(beautyType, ((Float) obj).floatValue());
            } else if (obj instanceof String) {
                P0(beautyType, (String) obj);
            } else if (obj instanceof float[]) {
                Q0(beautyType, (float[]) obj);
            } else if (obj instanceof Double) {
                L0(beautyType, (float) ((Double) obj).doubleValue());
            } else if (obj instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                float[] fArr = new float[size];
                for (int i2 = 0; i2 < size; i2++) {
                    Object obj2 = arrayList.get(i2);
                    if (obj2 instanceof Double) {
                        fArr[i2] = new Float(((Double) obj2).doubleValue()).floatValue();
                    }
                }
                Q0(beautyType, fArr);
            } else if (obj instanceof Makeup) {
                N0(beautyType, (Makeup) obj);
            }
        }
    }

    public final Texture P(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048595, this, i2, i3)) == null) {
            DuMixController duMixController = this.f;
            if (duMixController == null) {
                return null;
            }
            Texture texture = this.x;
            if (texture != null) {
                return texture;
            }
            IGLRenderer gLRenderer = duMixController.getGLRenderer();
            if (gLRenderer != null) {
                return gLRenderer.createTexture(3553, i2, i3);
            }
            return null;
        }
        return (Texture) invokeII.objValue;
    }

    public void P0(BeautyType beautyType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, beautyType, str) == null) {
            if (d0()) {
                kf0.a("DuAr_DuController", " updateFilter :" + beautyType + " = " + str);
            }
            if (!e0() || beautyType == null) {
                return;
            }
            if (beautyType != BeautyType.cheeks && beautyType != BeautyType.lips && beautyType != BeautyType.highlight && beautyType != BeautyType.eyeshadow && beautyType != BeautyType.eyeliner && beautyType != BeautyType.eyebrow && beautyType != BeautyType.eyeball) {
                this.f.updateFilter(beautyType.type, str);
                u0(beautyType, str);
                return;
            }
            this.f.updateFilterCase(str);
        }
    }

    public void Q0(BeautyType beautyType, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, beautyType, fArr) == null) {
            if (d0()) {
                kf0.a("DuAr_DuController", " updateFilter :" + beautyType + " = " + yo.a(fArr));
            }
            if (!e0() || beautyType == null) {
                return;
            }
            this.f.updateFilter(beautyType.type, fArr);
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
        }
    }

    public void R0(Map<BeautyType, Object> map) {
        Map.Entry<BeautyType, Object> next;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, map) == null) || map == null) {
            return;
        }
        Iterator<Map.Entry<BeautyType, Object>> it = map.entrySet().iterator();
        while (it.hasNext() && (next = it.next()) != null && next.getKey() != null) {
            O0(next.getKey(), next.getValue());
        }
    }

    public final JSONObject S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            JSONObject jSONObject = this.X;
            if (jSONObject == null || jSONObject.length() <= 0) {
                return null;
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void S0(ICaptureAbilityListener iCaptureAbilityListener) {
        DuMixController duMixController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, iCaptureAbilityListener) == null) || (duMixController = this.f) == null || duMixController.getARProxyManager() == null || this.f.getARProxyManager().getCaptureAR() == null) {
            return;
        }
        this.f.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
    }

    public l T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.c : (l) invokeV.objValue;
    }

    public void T0(ICallbackWith<ICaptureResult> iCallbackWith) {
        DuMixController duMixController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, iCallbackWith) == null) || (duMixController = this.f) == null || duMixController.getARProxyManager() == null || this.f.getARProxyManager().getCaptureAR() == null) {
            return;
        }
        this.f.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
    }

    public void U0(List<List<Point>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, list) == null) {
            DuMixController duMixController = this.f;
            if (!e0() || list == null) {
                return;
            }
            duMixController.updateFilter(FilterParam.TuneColorFilter.rgbPoints, list.get(0));
            duMixController.updateFilter(FilterParam.TuneColorFilter.redPoints, list.get(1));
            duMixController.updateFilter(FilterParam.TuneColorFilter.greenPoints, list.get(2));
            duMixController.updateFilter(FilterParam.TuneColorFilter.bluePoints, list.get(3));
            duMixController.updateFilter((FilterParam) FilterParam.TuneColorFilter.curve, 0.9f);
        }
    }

    public void V0(DefinedLuaListener definedLuaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, definedLuaListener) == null) {
            this.o = definedLuaListener;
        }
    }

    public final JSONObject W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            JSONObject jSONObject = this.Y;
            if (jSONObject == null || jSONObject.length() <= 0) {
                return null;
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void W0(DuMixStateListener duMixStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, duMixStateListener) == null) {
            this.p = duMixStateListener;
        }
    }

    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            Texture texture = this.x;
            if (texture != null) {
                return texture.getId();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void X0(FaceListener faceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, faceListener) == null) {
            this.l = faceListener;
        }
    }

    public void Y0(FilterParam filterParam, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048610, this, filterParam, f2) == null) {
            if (d0()) {
                kf0.a("DuAr_DuController", " updateFilter :" + filterParam + " = " + f2);
            }
            if (!e0() || filterParam == null) {
                return;
            }
            this.f.updateFilter(filterParam, f2);
        }
    }

    public final Handler Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            Handler handler = this.J;
            if (handler != null) {
                return handler;
            }
            k kVar = new k(this, this.I.getLooper());
            this.J = kVar;
            return kVar;
        }
        return (Handler) invokeV.objValue;
    }

    public void Z0(FilterParam filterParam, List<Point> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, filterParam, list) == null) {
            if (d0()) {
                StringBuilder sb = new StringBuilder();
                sb.append(" updateFilter :");
                sb.append(filterParam);
                sb.append(" = ");
                sb.append(list);
                kf0.a("DuAr_DuController", sb.toString() != null ? list.toString() : "");
            }
            if (!e0() || filterParam == null || list == null) {
                return;
            }
            this.f.updateFilter(filterParam, list);
        }
    }

    public void a1(FilterStateListener filterStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, filterStateListener) == null) {
            this.n = filterStateListener;
        }
    }

    public void b1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            if (d0()) {
                kf0.a("DuAr_DuController", " setInitBeautyPath :  " + str);
            }
            if (e0()) {
                this.f.updateFilterCase(str);
            }
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            if (!z) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new Point(0, 0));
                arrayList2.add(new Point(255, 255));
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(new Point(0, 0));
                arrayList3.add(new Point(255, 255));
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(new Point(0, 0));
                arrayList4.add(new Point(255, 255));
                ArrayList arrayList5 = new ArrayList();
                arrayList5.add(new Point(0, 0));
                arrayList5.add(new Point(255, 255));
                arrayList.add(arrayList2);
                arrayList.add(arrayList3);
                arrayList.add(arrayList4);
                arrayList.add(arrayList5);
                U0(arrayList);
                return;
            }
            D0();
        }
    }

    public void c1(Texture texture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, texture) == null) {
            this.w = texture;
        }
    }

    public void d1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            if (d0()) {
                kf0.a("DuAr_DuController", "setMdlModelPath " + str);
            }
            if (!e0() || str == null) {
                return;
            }
            this.f.setMdlModelPath(str);
        }
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? (this.f == null || !h0() || f0()) ? false : true : invokeV.booleanValue;
    }

    public void e1(Texture texture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, texture) == null) {
            this.x = texture;
        }
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public void f1(me0 me0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, me0Var) == null) {
            if (me0Var != null) {
                Y0(SharpnessFilter.sharpness, me0Var.a);
                Y0(FilterParam.TuneColorFilter.brightness, me0Var.b);
                Y0(FilterParam.TuneColorFilter.contrast, me0Var.c);
                Y0(FilterParam.TuneColorFilter.saturation, me0Var.d);
                Y0(FilterParam.TuneColorFilter.curve, me0Var.e);
                Z0(FilterParam.TuneColorFilter.rgbPoints, me0Var.f);
                Z0(FilterParam.TuneColorFilter.redPoints, me0Var.g);
                Z0(FilterParam.TuneColorFilter.greenPoints, me0Var.h);
                Z0(FilterParam.TuneColorFilter.bluePoints, me0Var.i);
                return;
            }
            Y0(SharpnessFilter.sharpness, me0.j);
            Y0(FilterParam.TuneColorFilter.brightness, me0.k);
            Y0(FilterParam.TuneColorFilter.contrast, me0.l);
            Y0(FilterParam.TuneColorFilter.saturation, me0.m);
            Y0(FilterParam.TuneColorFilter.curve, me0.n);
            Z0(FilterParam.TuneColorFilter.rgbPoints, me0.o);
            Z0(FilterParam.TuneColorFilter.redPoints, me0.p);
            Z0(FilterParam.TuneColorFilter.greenPoints, me0.q);
            Z0(FilterParam.TuneColorFilter.bluePoints, me0.r);
        }
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public void g1() {
        DuMixController duMixController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && d0 && (duMixController = this.f) != null) {
            this.A = 0;
            IGLRenderer gLRenderer = duMixController.getGLRenderer();
            if (gLRenderer != null) {
                gLRenderer.addFrameRenderListener(new a(this));
            }
        }
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && e0()) {
            if (d0()) {
                Q("DuAr_DuController", "startCaptureAbility");
            }
            this.f.startAbility("ability_capture", (HashMap<String, Object>) null);
        }
    }

    public void j0(ARType aRType, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048626, this, aRType, str, str2) == null) {
            if (this.n != null && TextUtils.isEmpty(str)) {
                this.n.onFilterStateChanged(null, null);
            }
            if (e0()) {
                if (d0()) {
                    kf0.a("DuAr_DuController", "loadcase Path = " + str + ", arType = " + str2 + ", casePath = " + str2);
                }
                this.Q = str2;
                this.f.loadCase(aRType, str, str2);
                s0(str, str2);
            }
        }
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && e0()) {
            if (d0()) {
                Q("DuAr_DuController", "stopCaptureAbility");
            }
            this.f.stopAbility("ability_capture");
        }
    }

    public final void l0(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, list) == null) {
            JSONObject jSONObject = this.F;
            if (list != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Integer num : list) {
                        jSONArray.put(num.intValue());
                    }
                    jSONObject.put("features", jSONArray);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            ye0.a("beauty_auth", jSONObject);
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            JSONObject jSONObject = this.G;
            try {
                jSONObject.put("beauty_parameters", this.F);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ye0.a("beauty_face", jSONObject);
        }
    }

    public void n0(ye0.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048630, this, aVar, z) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(FpsConstants.REPORT_FPS, aVar.c);
                jSONObject.put("cpu", aVar.a);
                jSONObject.put("mem", aVar.b);
                if (z) {
                    jSONObject.put("bft", aVar.d);
                    jSONObject.put("sft", aVar.e);
                } else {
                    jSONObject.put("bft_val", aVar.f);
                    jSONObject.put("sft_val", aVar.g);
                }
                if (aVar.o != null && aVar.o.length() > 0) {
                    jSONObject.put("beauty", aVar.o);
                }
                if (aVar.p != null && aVar.p.length() > 0) {
                    jSONObject.put("makeup", aVar.p);
                }
                jSONObject.put(CloudControlRequest.REQUEST_KEY_FILTER, aVar.i);
                jSONObject.put(FaceItem.DIR_STICKER, aVar.h);
                String str = "1";
                jSONObject.put(PushConstants.URI_PACKAGE_NAME, aVar.k ? "1" : "0");
                jSONObject.put("lm", aVar.j ? "1" : "0");
                jSONObject.put("pw", aVar.n);
                jSONObject.put("ew", aVar.m);
                if (!aVar.l) {
                    str = "0";
                }
                jSONObject.put("hevc", str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ye0.a("beauty_ performance", jSONObject);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                Makeup makeup = this.H;
                jSONObject.put("makeup_parameters", makeup == null ? StringUtil.NULL_STRING : makeup.getInfo());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ye0.a("beauty_makeup", jSONObject);
        }
    }

    public final void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("beauty_onsetup_ID", this.C);
                jSONObject.put("beauty_onsetup", z ? 1 : 0);
                jSONObject.put("beauty_onsetup_time", this.z);
                if (e0 != 0) {
                    jSONObject.put("beauty_onsetup_release_time", e0);
                    e0 = 0L;
                }
                if (f0 != null) {
                    jSONObject.put("beauty_release_frame_info", f0);
                    f0 = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ye0.a("beauty_start", jSONObject);
        }
    }

    public final void q0(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048633, this, str, i2, i3) == null) {
            this.W = i2;
            JSONObject jSONObject = this.F;
            try {
                jSONObject.put("stream_direction", str);
                jSONObject.put("stream_width", i2);
                jSONObject.put("stream_height", i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ye0.a("beauty_resolution", jSONObject);
        }
    }

    public final void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("beauty_onsetup_ID", this.C);
                int i2 = 1;
                if (this.h != null) {
                    jSONObject.put("beauty_width", this.h.getInputWidth());
                    jSONObject.put("beauty_height", this.h.getInputHeight());
                    jSONObject.put("beauty_is_front_camera", this.h.isFrontCamera() ? 1 : 0);
                    jSONObject.put("beauty_is_landscape", this.L ? 1 : 0);
                    jSONObject.put("beauty_is_sync", d0 ? 1 : 0);
                }
                if (this.i != null) {
                    jSONObject.put("beauty_out_width", this.i.getOutputWidth());
                    jSONObject.put("beauty_out_height", this.i.getOutputHeight());
                    jSONObject.put("beauty_out_fps", this.i.getOutputFPS());
                }
                jSONObject.put("beauty_is_resume", z ? 1 : 0);
                File file = null;
                String a2 = he0.g() != null ? ie0.a() : null;
                if (!TextUtils.isEmpty(a2)) {
                    he0.g();
                    file = new File(ie0.a());
                }
                if (a2 == null) {
                    a2 = StringUtil.NULL_STRING;
                }
                jSONObject.put("beauty_ar_path", a2);
                if (file == null || !file.exists()) {
                    i2 = 0;
                }
                jSONObject.put("beauty_ar_path_exist", i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ye0.a("beauty_start", jSONObject);
        }
    }

    public final void s0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048635, this, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("operating", TextUtils.isEmpty(str) ? "unload" : "load");
                jSONObject.put("sticker_id", str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ye0.a("beauty_sticker", jSONObject);
        }
    }

    public void t0(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i2, int i3, boolean z, DuMixCallback duMixCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{surfaceTexture, onFrameAvailableListener, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), duMixCallback}) == null) {
            if (d0()) {
                Q("DuAr_DuController", "onARDrawerCreated frontCamera: " + z + ", surfaceTexture: " + surfaceTexture + "size[" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + " duMixCallback =" + duMixCallback);
            }
            if (this.f == null || this.h == null) {
                return;
            }
            if (i2 > 0 && i3 > 0) {
                this.s = i2;
                this.t = i3;
            }
            this.j = onFrameAvailableListener;
            this.y = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(this.k);
            }
            K(duMixCallback);
            if (!this.u) {
                this.h.setFrontCamera(z);
                if (this.b != null) {
                    Texture P = P(i2, i3);
                    this.x = P;
                    this.i = new DuMixOutput2(P, i2, i3);
                } else if (this.L) {
                    DuMixOutput duMixOutput = new DuMixOutput(surfaceTexture, this.t, this.s);
                    this.i = duMixOutput;
                    duMixOutput.setScreenOrientation(0);
                } else {
                    this.i = new DuMixOutput(surfaceTexture, this.s, this.t);
                }
                int i4 = this.K;
                if (i4 != 0) {
                    this.i.setOutputFPS(i4);
                }
                this.C = System.currentTimeMillis();
                this.f.setup(this.h, this.i, this.Z);
                this.u = true;
                r0(true);
                q0("output", this.i.getOutputWidth(), this.i.getOutputHeight());
                Z().obtainMessage(3).sendToTarget();
                return;
            }
            this.f.changeOutputSize(i2, i3);
            r0(false);
            q0("output", i2, i3);
        }
    }

    public final void u0(BeautyType beautyType, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048637, this, beautyType, obj) == null) || beautyType == null) {
            return;
        }
        try {
            this.F.put(beautyType.name(), obj);
            G0(beautyType, obj);
            if (beautyType == BeautyType.beautyJsonPath) {
                if (obj == null) {
                    this.G.remove("feature_name");
                    this.G.remove("feature_file_exist");
                } else if (obj instanceof String) {
                    this.G.put("feature_file_exist", new File((String) obj).exists() ? 1 : 0);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        Z().removeMessages(1);
        Z().sendMessageDelayed(Z().obtainMessage(1), 500L);
    }

    public void v0(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048638, this, surfaceTexture, i2, i3) == null) {
            if (d0()) {
                Q("DuAr_DuController", "onCameraDrawerCreated " + surfaceTexture + "size[" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3);
            }
            if (i2 > 0 && i3 > 0) {
                this.q = i2;
                this.r = i3;
            }
            if (this.b != null) {
                DuMixInput2 duMixInput2 = new DuMixInput2(this.w, i2, i3);
                this.h = duMixInput2;
                duMixInput2.setSyncInputContent(d0);
                Q("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + d0);
                this.h.setInputDegree(0);
                return;
            }
            this.h = new DuMixInput(surfaceTexture, this.q, this.r);
        }
    }

    public final void w0(Makeup makeup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, makeup) == null) {
            this.H = makeup;
            Z().removeMessages(2);
            Z().sendMessageDelayed(Z().obtainMessage(2), 500L);
        }
    }

    public boolean x0(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048640, this, view2, motionEvent)) == null) {
            if (d0()) {
                kf0.a("DuAr_DuController", "onTouchEvent :");
            }
            DuMixController duMixController = this.f;
            if (duMixController != null) {
                return duMixController.onTouch(view2, motionEvent);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && a0 == this) {
            if (this.f != null) {
                Q("DuAr_DuController", "pause");
                this.f.pause();
                this.d = true;
            }
            this.D.e();
        }
    }

    public final void z0(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, message) == null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    String string = data.getString("beauty_type");
                    Object obj = data.get("beauty_value");
                    if (TextUtils.isEmpty(string) || obj == null) {
                        return;
                    }
                    this.X.put(string, obj);
                }
            } catch (Exception e2) {
                if (d0()) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
