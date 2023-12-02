package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.tieba.pb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class az1 extends vy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ k63 d;
        public final /* synthetic */ hz1 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ az1 h;

        public a(az1 az1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, k63 k63Var, hz1 hz1Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var, callbackHandler, unitedSchemeEntity, context, k63Var, hz1Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = az1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = k63Var;
            this.e = hz1Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (ib3.h(nb3Var)) {
                    this.h.p(this.c, this.b, this.a, this.d, this.e, this.f, this.g);
                    return;
                }
                ib3.p(nb3Var, this.a, this.b);
                k32.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements n13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ k63 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ hz1 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ az1 g;

        public b(az1 az1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var, CameraPreview cameraPreview, hz1 hz1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var, unitedSchemeEntity, callbackHandler, k63Var, cameraPreview, hz1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = az1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = k63Var;
            this.d = cameraPreview;
            this.e = hz1Var;
            this.f = str;
        }

        @Override // com.baidu.tieba.n13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.g.r(this.a, this.b, this.c, this.d, this.e, this.f);
            k32.c("SwanAppCameraManager", str + "");
        }

        @Override // com.baidu.tieba.n13
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.b, this.a, 10005);
                k32.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements cz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ k63 b;
        public final /* synthetic */ hz1 c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ az1 f;

        public c(az1 az1Var, String str, k63 k63Var, hz1 hz1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var, str, k63Var, hz1Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = az1Var;
            this.a = str;
            this.b = k63Var;
            this.c = hz1Var;
            this.d = callbackHandler;
            this.e = unitedSchemeEntity;
        }

        @Override // com.baidu.tieba.cz1
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.k(this.e, this.d, false);
                k32.c("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // com.baidu.tieba.cz1
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", sd3.J(this.a, this.b.b));
                } catch (JSONException e) {
                    k32.c("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    uy1 b = uy1.b();
                    hz1 hz1Var = this.c;
                    b.e(hz1Var.c, hz1Var.b, false);
                    if (h83.b) {
                        e.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.d, this.e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az1(h73 h73Var) {
        super(h73Var, "/swanAPI/camera/takePhoto");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((h73) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            hz1 hz1Var = (hz1) q(unitedSchemeEntity);
            if (hz1Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                k32.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            j22 j22Var = (j22) x22.a(hz1Var);
            if (j22Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                k32.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = j22Var.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                k32.c("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = sd3.x(k63Var.b);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                k32.c("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            k63Var.f0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, k63Var, hz1Var, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var, hz1 hz1Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, k63Var, hz1Var, cameraPreview, str}) == null) {
            k32.i("SwanAppCameraManager", "handleAuthorized start");
            m13.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, k63Var, cameraPreview, hz1Var, str));
        }
    }

    public b22 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) {
            return new hz1(l(unitedSchemeEntity));
        }
        return (b22) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var, CameraPreview cameraPreview, hz1 hz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, k63Var, cameraPreview, hz1Var, str}) == null) {
            k32.i("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(hz1Var.j);
            String o = cameraPreview.o(str);
            try {
                cameraPreview.w(o, new c(this, o, k63Var, hz1Var, callbackHandler, unitedSchemeEntity));
            } catch (Exception e) {
                k32.c("SwanAppCameraManager", "take picture api occur exception");
                uy1.b().e(hz1Var.c, hz1Var.b, false);
                if (h83.b) {
                    e.printStackTrace();
                }
            }
            k32.i("SwanAppCameraManager", "take photo end");
        }
    }
}
