package com.baidu.tieba;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ih3 extends q93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ih3(q83 q83Var) {
        super(q83Var, "/swanAPI/getMediaVolumeSync");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var};
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

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            if (t73Var == null) {
                t42.c("getMediaVolumeSync", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (q93.b) {
                    Log.d("SwanAppAction", "getMediaVolumeSync --- illegal swanApp");
                }
                return false;
            } else if (context == null) {
                t42.c("getMediaVolumeSync", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                if (q93.b) {
                    Log.d("SwanAppAction", "getMediaVolumeSync --- illegal context");
                }
                return false;
            } else {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                if (audioManager == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "get AudioManager error");
                    if (q93.b) {
                        Log.d("SwanAppAction", "getMediaVolumeSync --- get AudioManager error");
                    }
                    return false;
                }
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                int streamVolume = audioManager.getStreamVolume(3);
                if (streamMaxVolume <= 0) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "max volume get 0");
                    if (q93.b) {
                        Log.d("SwanAppAction", "getMediaVolumeSync --- max volume get 0");
                    }
                    return false;
                }
                double d = streamVolume / streamMaxVolume;
                if (d < 0.0d) {
                    d = 0.0d;
                } else if (d > 1.0d) {
                    d = 1.0d;
                }
                if (q93.b) {
                    Log.d("SwanAppAction", "getMediaVolumeSync: " + d);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", d);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                    return true;
                } catch (JSONException unused) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "json exception");
                    if (q93.b) {
                        Log.d("SwanAppAction", "getMediaVolumeSync --- json exception");
                    }
                    return false;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }
}
