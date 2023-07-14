package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tieba.ah3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes6.dex */
public class g42 extends f42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public a2c c;

    /* loaded from: classes6.dex */
    public class a implements oq3<yg3<ah3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ p42 d;
        public final /* synthetic */ g42 e;

        public a(g42 g42Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, p42 p42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g42Var, callbackHandler, unitedSchemeEntity, context, p42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = g42Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = p42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (tg3.h(yg3Var)) {
                    this.e.q(this.c, this.b, this.a, this.d);
                    return;
                }
                tg3.p(yg3Var, this.a, this.b);
                if (this.e.c != null) {
                    this.e.c.onError(new Throwable());
                } else {
                    v82.c("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
                }
                v82.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements y63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ p42 b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ g42 e;

        public b(g42 g42Var, Context context, p42 p42Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g42Var, context, p42Var, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = g42Var;
            this.a = context;
            this.b = p42Var;
            this.c = unitedSchemeEntity;
            this.d = callbackHandler;
        }

        @Override // com.baidu.tieba.y63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.e.k(this.c, this.d, this.e.p(this.a, this.b));
            v82.c("SwanAppCameraManager", str + "");
        }

        @Override // com.baidu.tieba.y63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.d, this.c, 10005);
                if (this.e.c != null) {
                    this.e.c.onError(new Throwable());
                } else {
                    v82.c("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
                }
                v82.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g42(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/camera/insert");
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

    public l72 r(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) {
            return new p42(l(unitedSchemeEntity));
        }
        return (l72) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                v82.c("SwanAppCameraManager", "handle action, but context is not Activity");
                return false;
            }
            p42 p42Var = (p42) r(unitedSchemeEntity);
            a2c w = new u72(context, p42Var).w();
            this.c = w;
            if (w == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                v82.c("SwanAppCameraManager", "camera component insert delayed fail");
                return false;
            }
            vb3Var.e0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, p42Var));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean p(Context context, p42 p42Var) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, p42Var)) == null) {
            v82.i("SwanAppCameraManager", "handle insert camera instruction start");
            boolean z2 = true;
            if (context != null && p42Var != null) {
                String str = p42Var.b;
                b23 b23Var = p42Var.h;
                if (!TextUtils.isEmpty(str) && b23Var != null && b23Var.h()) {
                    a2c a2cVar = this.c;
                    if (a2cVar == null) {
                        o82.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                        return false;
                    }
                    a2cVar.onCompleted();
                    v82.i("SwanAppCameraManager", "handle insert camera instruction end");
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("cameraId = ");
                sb.append(str);
                sb.append(" ; position = ");
                if (b23Var != null) {
                    z2 = false;
                }
                sb.append(z2);
                v82.c("SwanAppCameraManager", sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Context is null ? = ");
            if (context == null) {
                z = true;
            } else {
                z = false;
            }
            sb2.append(z);
            sb2.append(" ; model is null ? = ");
            if (p42Var != null) {
                z2 = false;
            }
            sb2.append(z2);
            v82.c("SwanAppCameraManager", sb2.toString());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p42 p42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, p42Var) == null) {
            v82.i("SwanAppCameraManager", "handleAuthorized start");
            x63.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, context, p42Var, unitedSchemeEntity, callbackHandler));
        }
    }
}
