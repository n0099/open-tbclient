package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import com.baidu.android.common.security.AESUtil;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            pm pmVar = new pm();
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !qi.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(HttpRequest.CLIENT_TYPE, "Android");
                jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, "1.0.14");
                jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
                jSONObject.put("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2());
                jSONObject.put("_client_version", version);
                jSONObject.put("cuid", TbadkCoreApplication.getInst().getCuid());
                jSONObject.put("_os_version", Build.VERSION.RELEASE);
                jSONObject.put(Config.DEVICE_PART, Build.MODEL + " " + Build.BRAND + " " + DeviceInfoUtil.getDevicesManufacturer() + " " + Build.BOARD + " " + Build.HARDWARE);
                jSONObject.put(SchemeDescPatchListener.PATCH, pmVar.a(context));
                return ii.j(AESUtil.encrypt("tbpatch-iv-value", "tbpatch1tbpatch2tbpatch3tbpatch4", jSONObject.toString().getBytes()));
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
