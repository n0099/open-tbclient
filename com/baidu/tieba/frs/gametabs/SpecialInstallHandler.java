package com.baidu.tieba.frs.gametabs;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.hybrid.NamedBridgeHandler;
import com.baidu.tieba.t35;
import com.baidu.tieba.v35;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SpecialInstallHandler extends NamedBridgeHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
    public String scope() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_IS_GAME_INSTALL" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpecialInstallHandler(t35 t35Var) {
        super(t35Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t35Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((t35) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @v35(isAsync = false, value = "isGameInstall")
    private JSONObject isGameInstall(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            String optString = jSONObject.optString("packagename");
            try {
                PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(optString, 0);
                if (packageInfo != null && packageInfo.packageName.equals(optString)) {
                    jSONObject2.put("isInstall", true);
                } else {
                    jSONObject2.put("isInstall", false);
                }
            } catch (PackageManager.NameNotFoundException e) {
                try {
                    jSONObject2.put("isInstall", false);
                } catch (JSONException unused) {
                    BdLog.e(e.getMessage());
                }
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }
}
