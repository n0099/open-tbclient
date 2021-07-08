package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.MyGroupInfo;
/* loaded from: classes3.dex */
public class MyGroup extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3454151897639902332L;
    public transient /* synthetic */ FieldHolder $fh;
    public long mGroupId;
    public Integer mGroupMemberNum;
    public String mGroupName;
    public String mGroupPortrait;

    public MyGroup() {
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

    public long getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mGroupId : invokeV.longValue;
    }

    public String getGroupPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mGroupPortrait : (String) invokeV.objValue;
    }

    public Integer getmGroupMemberNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mGroupMemberNum : (Integer) invokeV.objValue;
    }

    public String getmGroupName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mGroupName : (String) invokeV.objValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.mGroupName = jSONObject.optString("group_name");
        this.mGroupId = jSONObject.optLong("group_id");
        this.mGroupPortrait = jSONObject.optString("portrait");
        this.mGroupMemberNum = Integer.valueOf(jSONObject.optInt("member_num"));
    }

    public void parserProtobuf(MyGroupInfo myGroupInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, myGroupInfo) == null) || myGroupInfo == null) {
            return;
        }
        this.mGroupName = myGroupInfo.group_name;
        this.mGroupId = myGroupInfo.group_id.longValue();
        this.mGroupPortrait = myGroupInfo.portrait;
        this.mGroupMemberNum = myGroupInfo.member_num;
    }

    public void setGroupId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.mGroupId = j;
        }
    }

    public void setGroupName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mGroupName = str;
        }
    }

    public void setGroupPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mGroupPortrait = str;
        }
    }

    public void setmGroupMemberNum(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, num) == null) {
            this.mGroupMemberNum = num;
        }
    }
}
