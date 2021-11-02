package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class AccessState implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2345844599685454996L;
    public transient /* synthetic */ FieldHolder $fh;
    public String token;
    public String type;
    public UserInfo userInfo;

    /* loaded from: classes8.dex */
    public class UserInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bduss;
        public String strEmail;
        public String strMobile;
        public final /* synthetic */ AccessState this$0;

        public UserInfo(AccessState accessState) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accessState};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = accessState;
        }
    }

    public AccessState() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.userInfo = new UserInfo(this);
    }

    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.token : (String) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.type : (String) invokeV.objValue;
    }

    public UserInfo getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.userInfo : (UserInfo) invokeV.objValue;
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || str == null) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("info");
            if (optJSONObject == null) {
                return;
            }
            parserJson(optJSONObject.optJSONObject(AccountAccessActivityConfig.KEY_ACCESS_STATE));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.type = jSONObject.optString("type");
            this.token = jSONObject.optString("token");
            JSONObject jSONObject2 = jSONObject.getJSONObject(TableDefine.DB_TABLE_USERINFO);
            if (jSONObject2 == null) {
                return;
            }
            this.userInfo.strMobile = jSONObject2.optString("strMobile");
            this.userInfo.strEmail = jSONObject2.optString("strEmail");
            this.userInfo.bduss = jSONObject2.optString("bduss");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
