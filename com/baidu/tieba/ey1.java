package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.tieba.ua3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ey1 extends ay1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ p53 d;
        public final /* synthetic */ ly1 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ ey1 g;

        public a(ey1 ey1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, p53 p53Var, ly1 ly1Var, CameraPreview cameraPreview) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey1Var, callbackHandler, unitedSchemeEntity, context, p53Var, ly1Var, cameraPreview};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ey1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = p53Var;
            this.e = ly1Var;
            this.f = cameraPreview;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (na3.h(sa3Var)) {
                    this.g.o(this.c, this.b, this.a, this.d, this.e, this.f);
                    return;
                }
                na3.p(sa3Var, this.a, this.b);
                p22.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements s03 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ p53 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ ly1 e;
        public final /* synthetic */ ey1 f;

        public b(ey1 ey1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var, CameraPreview cameraPreview, ly1 ly1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey1Var, unitedSchemeEntity, callbackHandler, p53Var, cameraPreview, ly1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ey1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = p53Var;
            this.d = cameraPreview;
            this.e = ly1Var;
        }

        @Override // com.baidu.tieba.s03
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.f.r(this.a, this.b, this.c, this.d, this.e);
        }

        @Override // com.baidu.tieba.s03
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.b, this.a, 10005);
                p22.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ey1(m63 m63Var) {
        super(m63Var, "/swanAPI/camera/stopRecord");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((m63) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!(!TextUtils.isEmpty(str))) {
                return false;
            }
            File file = new File(str);
            if (file.exists() && file.length() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            ly1 ly1Var = (ly1) q(unitedSchemeEntity);
            if (ly1Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                p22.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            o12 o12Var = (o12) c22.a(ly1Var);
            if (o12Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                p22.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = o12Var.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                p22.c("SwanAppCameraManager", "get camera view is null");
                return false;
            } else if (TextUtils.isEmpty(xc3.x(p53Var.b))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                p22.c("SwanAppCameraManager", "get camera stop record cache path is empty");
                return false;
            } else {
                p53Var.f0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, p53Var, ly1Var, q));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var, ly1 ly1Var, CameraPreview cameraPreview) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, p53Var, ly1Var, cameraPreview}) == null) {
            p22.i("SwanAppCameraManager", "handleAuthorized start");
            if (zx1.b().c(context) && zx1.b().d(context)) {
                p22.c("SwanAppCameraManager", "has authorize");
                r(unitedSchemeEntity, callbackHandler, p53Var, cameraPreview, ly1Var);
                return;
            }
            r03.f(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new b(this, unitedSchemeEntity, callbackHandler, p53Var, cameraPreview, ly1Var));
        }
    }

    public g12 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) {
            return new ly1(l(unitedSchemeEntity));
        }
        return (g12) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var, CameraPreview cameraPreview, ly1 ly1Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, unitedSchemeEntity, callbackHandler, p53Var, cameraPreview, ly1Var) == null) {
            p22.i("SwanAppCameraManager", "stop record start");
            try {
                z = cameraPreview.v();
            } catch (Exception e) {
                e = e;
                z = false;
            }
            try {
                zx1.b().j();
            } catch (Exception e2) {
                e = e2;
                cameraPreview.m();
                zx1.b().e(ly1Var.c, ly1Var.b, false);
                if (m73.b) {
                    e.printStackTrace();
                }
                p22.c("SwanAppCameraManager", "stop recording api occur exception");
                String videoPath = cameraPreview.getVideoPath();
                String thumbPath = cameraPreview.getThumbPath();
                if (!z) {
                }
                k(unitedSchemeEntity, callbackHandler, false);
                cameraPreview.m();
                p22.i("SwanAppCameraManager", "stop record end");
            }
            String videoPath2 = cameraPreview.getVideoPath();
            String thumbPath2 = cameraPreview.getThumbPath();
            if (!z && p(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("tempVideoPath", xc3.J(videoPath2, p53Var.b));
                hashMap.put("tempThumbPath", xc3.J(thumbPath2, p53Var.b));
                j(unitedSchemeEntity, callbackHandler, hashMap, "");
            } else {
                k(unitedSchemeEntity, callbackHandler, false);
            }
            cameraPreview.m();
            p22.i("SwanAppCameraManager", "stop record end");
        }
    }
}
