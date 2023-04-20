package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.q45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getABTestResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mABTestResult;
        }
        return (String) invokeV.objValue;
    }

    public void parserABTestExtraFormSharedPref() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                String s = q45.m().s("abtest_extra_info_json", null);
                if (!TextUtils.isEmpty(s)) {
                    parseJson(new JSONObject(s));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void saveABTestExtraToSharedPref(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) {
            if (jSONObject != null) {
                str = jSONObject.toString();
            } else {
                str = "";
            }
            q45.m().B("abtest_extra_info_json", str);
        }
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
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
