package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.d0.b;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ABTestExtraData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mABTestResult;

    public ABTestExtraData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void saveABTestExtraToSharedPref(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) {
            b.j().x("abtest_extra_info_json", jSONObject != null ? jSONObject.toString() : "");
        }
    }

    public String getABTestResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mABTestResult : (String) invokeV.objValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            if (jSONObject == null) {
                this.mABTestResult = null;
                saveABTestExtraToSharedPref(null);
                return;
            }
            try {
                this.mABTestResult = jSONObject.optString(TiebaStatic.Params.ABTEST_RESULT);
                saveABTestExtraToSharedPref(jSONObject);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void parserABTestExtraFormSharedPref() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                String p = b.j().p("abtest_extra_info_json", null);
                if (TextUtils.isEmpty(p)) {
                    return;
                }
                parseJson(new JSONObject(p));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
