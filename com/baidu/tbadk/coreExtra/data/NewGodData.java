package com.baidu.tbadk.coreExtra.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.do4;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.NewGodInfo;
/* loaded from: classes3.dex */
public class NewGodData extends do4 implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -107269285489960303L;
    public transient /* synthetic */ FieldHolder $fh;
    public String mFieldId;
    public String mFieldName;
    public int mStatus;
    public int mType;
    public String mTypeName;

    public NewGodData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStatus = 0;
        this.mFieldId = "";
        this.mFieldName = "";
        this.mType = 0;
        this.mTypeName = "";
    }

    public String getFieldId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mFieldId : (String) invokeV.objValue;
    }

    public String getFieldName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFieldName : (String) invokeV.objValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mStatus : invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mType : invokeV.intValue;
    }

    public String getTypeName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mTypeName : (String) invokeV.objValue;
    }

    public boolean hasNewGodInvited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.mStatus;
            return i == 2 || i == 4;
        }
        return invokeV.booleanValue;
    }

    public boolean isNewGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mStatus == 3 : invokeV.booleanValue;
    }

    public boolean isNewGodInvited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mStatus == 2 : invokeV.booleanValue;
    }

    public boolean isVideoGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mType == 2 : invokeV.booleanValue;
    }

    @Override // com.repackage.do4
    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.mStatus = jSONObject.optInt("status", 0);
            this.mFieldId = jSONObject.optString("field_id", "");
            this.mFieldName = jSONObject.optString("field_name", "");
            this.mType = jSONObject.optInt("type", 0);
            this.mTypeName = jSONObject.optString("type_name", "");
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserProtobuf(NewGodInfo newGodInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, newGodInfo) == null) || newGodInfo == null) {
            return;
        }
        this.mStatus = newGodInfo.status.intValue();
        this.mFieldId = String.valueOf(newGodInfo.field_id);
        this.mFieldName = newGodInfo.field_name;
        this.mType = newGodInfo.type.intValue();
        this.mTypeName = newGodInfo.type_name;
    }

    public void setFieldId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mFieldId = str;
        }
    }

    public void setStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mStatus = i;
        }
    }
}
