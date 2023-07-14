package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class fz2 extends sd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements y63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ vb3 c;
        public final /* synthetic */ nz2 d;
        public final /* synthetic */ fz2 e;

        public a(fz2 fz2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, nz2 nz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz2Var, unitedSchemeEntity, callbackHandler, vb3Var, nz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = fz2Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = vb3Var;
            this.d = nz2Var;
        }

        @Override // com.baidu.tieba.y63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (sd3.b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.e.p(this.a, this.b, this.c, this.d);
            }
        }

        @Override // com.baidu.tieba.y63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.b, this.a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.d.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements y63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ vb3 d;
        public final /* synthetic */ nz2 e;
        public final /* synthetic */ fz2 f;

        public b(fz2 fz2Var, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, nz2 nz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz2Var, context, unitedSchemeEntity, callbackHandler, vb3Var, nz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = fz2Var;
            this.a = context;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
            this.d = vb3Var;
            this.e = nz2Var;
        }

        @Override // com.baidu.tieba.y63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (sd3.b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f.r(this.a, this.b, this.c, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.y63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.e.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements rz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb3 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ nz2 d;

        public c(fz2 fz2Var, vb3 vb3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, nz2 nz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz2Var, vb3Var, callbackHandler, unitedSchemeEntity, nz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vb3Var;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
            this.d = nz2Var;
        }

        @Override // com.baidu.tieba.rz2
        public void a(boolean z, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (sd3.b) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                        }
                    }
                    v82.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.b, this.c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(lz2.n(arrayList, this.a), 0).toString(), this.d.c);
                }
                mz2.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements pz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz2 a;
        public final /* synthetic */ vb3 b;
        public final /* synthetic */ rz2 c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;

        public d(fz2 fz2Var, nz2 nz2Var, vb3 vb3Var, rz2 rz2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz2Var, nz2Var, vb3Var, rz2Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz2Var;
            this.b = vb3Var;
            this.c = rz2Var;
            this.d = callbackHandler;
            this.e = unitedSchemeEntity;
        }

        @Override // com.baidu.tieba.pz2
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                v82.i("chooseVideo", "capture success");
                mz2.i(jz2.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", ix2.T().G().k());
                bundle.putBoolean("compressed", this.a.b);
                bundle.putString("swanAppId", this.b.b);
                bundle.putParcelableArrayList("mediaModels", mz2.e());
                lz2.h(this.b.w(), bundle, this.c);
            }
        }

        @Override // com.baidu.tieba.pz2
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.d, this.e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.a.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements qz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ nz2 c;
        public final /* synthetic */ vb3 d;

        public e(fz2 fz2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, nz2 nz2Var, vb3 vb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz2Var, callbackHandler, unitedSchemeEntity, nz2Var, vb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = nz2Var;
            this.d = vb3Var;
        }

        @Override // com.baidu.tieba.qz2
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                v82.i("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.c.c);
            }
        }

        @Override // com.baidu.tieba.qz2
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    v82.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(lz2.n(list, this.d), 0).toString(), this.c.c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.c.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fz2(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/chooseVideo");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, nz2 nz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, vb3Var, nz2Var) == null) {
            x63.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, vb3Var, nz2Var));
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, nz2 nz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, vb3Var, nz2Var) == null) {
            x63.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, vb3Var, nz2Var));
        }
    }

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            if (vb3Var != null && vb3Var.n0()) {
                if (sd3.b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            nz2 a2 = nz2.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
            if (a2.a == 2) {
                q(context, unitedSchemeEntity, callbackHandler, vb3Var, a2);
            } else {
                o(context, unitedSchemeEntity, callbackHandler, vb3Var, a2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, nz2 nz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, vb3Var, nz2Var) == null) {
            d dVar = new d(this, nz2Var, vb3Var, new c(this, vb3Var, callbackHandler, unitedSchemeEntity, nz2Var), callbackHandler, unitedSchemeEntity);
            jz2.e(vb3Var.w(), vb3Var.b, nz2Var.e, TextUtils.equals(nz2Var.d, "front"), dVar);
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, nz2 nz2Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, vb3Var, nz2Var) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            if (nz2Var.a == 3) {
                z = true;
            } else {
                z = false;
            }
            bundle.putBoolean("isShowCamera", z);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(nz2Var.d, "front"));
            bundle.putInt("maxDuration", nz2Var.e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", nz2Var.b);
            bundle.putString("swanAppId", vb3Var.b);
            bundle.putString("swanTmpPath", ix2.T().G().k());
            lz2.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, nz2Var, vb3Var));
        }
    }
}
