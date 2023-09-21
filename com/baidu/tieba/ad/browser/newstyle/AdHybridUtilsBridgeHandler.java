package com.baidu.tieba.ad.browser.newstyle;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.hybrid.NamedBridgeHandler;
import com.baidu.tieba.kk0;
import com.baidu.tieba.t85;
import com.baidu.tieba.v85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.adapter.internal.CommonCode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AdHybridUtilsBridgeHandler extends NamedBridgeHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
    public String scope() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Utils" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdHybridUtilsBridgeHandler(t85 t85Var) {
        super(t85Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t85Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((t85) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @v85(isAsync = false, value = "showDeviceInfo")
    private JSONObject showDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            String cuid = TbadkCoreApplication.getInst().getCuid();
            String h = kk0.c().h(false);
            String e = kk0.c().e(false);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext());
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(getContext());
            String str = String.valueOf(equipmentWidth) + "," + String.valueOf(equipmentHeight);
            String versionName = TbadkCoreApplication.getInst().getVersionName();
            try {
                jSONObject.put("systemName", "android");
                if (!TextUtils.isEmpty(h)) {
                    jSONObject.put("systemVersion", h);
                }
                if (!TextUtils.isEmpty(e)) {
                    jSONObject.put("model", e);
                }
                jSONObject.put("cuid", cuid);
                jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, str);
                jSONObject.put("appVersion", versionName);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @v85(isAsync = false, value = "showNetStatus")
    private JSONObject showNetStatus() {
        InterceptResult invokeV;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (BdNetTypeUtil.isWifiNet()) {
                i = 1;
                str = "WIFI";
            } else if (BdNetTypeUtil.is2GNet()) {
                i = 3;
                str = "2G";
            } else if (BdNetTypeUtil.is3GNet()) {
                i = 4;
                str = "3G";
            } else if (BdNetTypeUtil.is4GNet()) {
                i = 5;
                str = "4G";
            } else {
                i = 0;
                str = "NotReachable";
            }
            try {
                jSONObject.put("netStatus", i);
                jSONObject.put("netDesc", str);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @v85(isAsync = false, value = PopItemMethodConstant.showToast)
    private void showToast(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        BdToast.makeText(getContext(), jSONObject.optString("message")).show();
    }
}
