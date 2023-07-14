package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.tieba.ah3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i42 extends f42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements oq3<yg3<ah3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ vb3 d;
        public final /* synthetic */ q42 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ i42 h;

        public a(i42 i42Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, vb3 vb3Var, q42 q42Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i42Var, callbackHandler, unitedSchemeEntity, context, vb3Var, q42Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = i42Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = vb3Var;
            this.e = q42Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            int b;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (tg3.h(yg3Var)) {
                    this.h.r(this.c, this.b, this.a, this.d, this.e, this.f, this.g);
                } else if (yg3Var != null && yg3Var.a() != null) {
                    String str = "authorize recorder failed : " + tg3.f(b);
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(yg3Var.b(), str));
                    v82.o("SwanAppAction", str);
                } else {
                    v82.c("SwanAppAction", "authorize recorder failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements oq3<yg3<ah3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ vb3 d;
        public final /* synthetic */ q42 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ i42 h;

        public b(i42 i42Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, vb3 vb3Var, q42 q42Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i42Var, unitedSchemeEntity, callbackHandler, context, vb3Var, q42Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = i42Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = context;
            this.d = vb3Var;
            this.e = q42Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (tg3.h(yg3Var)) {
                    this.h.t(this.c, this.a, this.b, this.d, this.e, this.f, this.g);
                } else if (yg3Var != null && yg3Var.a() != null) {
                    this.h.s(yg3Var.b(), this.a, this.b);
                } else {
                    v82.c("SwanAppAction", "authorize camera failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements y63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ vb3 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ q42 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ i42 g;

        public c(i42 i42Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, CameraPreview cameraPreview, q42 q42Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i42Var, unitedSchemeEntity, callbackHandler, vb3Var, cameraPreview, q42Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = i42Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = vb3Var;
            this.d = cameraPreview;
            this.e = q42Var;
            this.f = str;
        }

        @Override // com.baidu.tieba.y63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.g.w(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        @Override // com.baidu.tieba.y63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.g.s(10005, this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements n42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraPreview a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ HashMap d;
        public final /* synthetic */ i42 e;

        public d(i42 i42Var, CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i42Var, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = i42Var;
            this.a = cameraPreview;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
            this.d = hashMap;
        }

        @Override // com.baidu.tieba.n42
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v();
                this.a.m();
                this.e.u(this.b, this.c, this.d);
                v82.c("SwanAppCameraManager", "start record timeout");
            }
        }

        @Override // com.baidu.tieba.n42
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.v();
                this.a.m();
                this.e.u(this.b, this.c, this.d);
                v82.c("SwanAppCameraManager", "start record cancel");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i42(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/camera/startRecord");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((sc3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            q42 q42Var = (q42) v(unitedSchemeEntity);
            if (q42Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                v82.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            u72 u72Var = (u72) i82.a(q42Var);
            if (u72Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                v82.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = u72Var.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                v82.c("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = dj3.x(vb3Var.b);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                v82.c("SwanAppCameraManager", "get camera start record cache path is empty");
                return false;
            }
            vb3Var.e0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, vb3Var, q42Var, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, q42 q42Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, vb3Var, q42Var, cameraPreview, str}) == null) {
            vb3Var.e0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(this, unitedSchemeEntity, callbackHandler, context, vb3Var, q42Var, cameraPreview, str));
        }
    }

    public final void s(int i, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, unitedSchemeEntity, callbackHandler) == null) {
            String str = "authorize camera failed : " + tg3.f(i);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i, str));
            v82.o("SwanAppAction", str);
        }
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, q42 q42Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, unitedSchemeEntity, callbackHandler, vb3Var, q42Var, cameraPreview, str}) == null) {
            v82.i("SwanAppCameraManager", "handleAuthorized start");
            if (e42.b().c(context) && e42.b().d(context)) {
                v82.c("SwanAppCameraManager", "has authorize");
                w(unitedSchemeEntity, callbackHandler, vb3Var, cameraPreview, q42Var, str);
                return;
            }
            x63.g(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(this, unitedSchemeEntity, callbackHandler, vb3Var, cameraPreview, q42Var, str));
        }
    }

    public final void u(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap) {
        HashMap<String, String> params;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, hashMap) == null) && unitedSchemeEntity != null && callbackHandler != null && hashMap != null && (params = unitedSchemeEntity.getParams()) != null && !params.isEmpty()) {
            String str = params.get("params");
            String str2 = null;
            if (str != null) {
                try {
                    str2 = new JSONObject(str).optString("timeoutCallback");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                j(unitedSchemeEntity, callbackHandler, hashMap, str2);
            }
        }
    }

    public l72 v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) {
            return new q42(l(unitedSchemeEntity));
        }
        return (l72) invokeL.objValue;
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, CameraPreview cameraPreview, q42 q42Var, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{unitedSchemeEntity, callbackHandler, vb3Var, cameraPreview, q42Var, str}) == null) {
            v82.i("SwanAppCameraManager", "start record start");
            HashMap hashMap = new HashMap();
            try {
                z = cameraPreview.u(str);
                try {
                    hashMap.put("tempVideoPath", dj3.J(cameraPreview.getVideoPath(), vb3Var.b));
                    hashMap.put("tempThumbPath", dj3.J(cameraPreview.getThumbPath(), vb3Var.b));
                    e42.b().i(31000, new d(this, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
                } catch (Exception e) {
                    e = e;
                    e42.b().e(q42Var.c, q42Var.b, false);
                    if (sd3.b) {
                        e.printStackTrace();
                    }
                    v82.c("SwanAppCameraManager", "start recording api occur exception");
                    k(unitedSchemeEntity, callbackHandler, z);
                }
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
            k(unitedSchemeEntity, callbackHandler, z);
        }
    }
}
