package com.baidu.tbadk.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.BusinessAccountInfo;
/* loaded from: classes9.dex */
public class BusinessAccountData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String businessName;
    public String identifiExplain;
    public boolean isBusinessAccount;
    public boolean isForumBusinessAccount;

    public BusinessAccountData() {
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

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.isBusinessAccount = jSONObject.optInt("is_business_account") == 1;
        this.isForumBusinessAccount = jSONObject.optInt("is_forum_business_account") == 1;
        this.businessName = jSONObject.optString("business_name");
        this.identifiExplain = jSONObject.optString("identifi_explain");
    }

    public void parseProto(BusinessAccountInfo businessAccountInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, businessAccountInfo) == null) || businessAccountInfo == null) {
            return;
        }
        this.isBusinessAccount = businessAccountInfo.is_business_account.intValue() == 1;
        this.isForumBusinessAccount = businessAccountInfo.is_forum_business_account.intValue() == 1;
        this.businessName = businessAccountInfo.business_name;
        this.identifiExplain = businessAccountInfo.identifi_explain;
    }
}
