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
import tbclient.GodInfo;
/* loaded from: classes5.dex */
public class GodUserData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public long fid;
    public int followed;
    public Long id;
    public String intro;
    public boolean isFromNetWork;
    public String mForumName;
    public String mRecommendReason;
    public int type;

    public GodUserData() {
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
        this.isFromNetWork = true;
    }

    public long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.fid;
        }
        return invokeV.longValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mForumName;
        }
        return (String) invokeV.objValue;
    }

    public Long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.id;
        }
        return (Long) invokeV.objValue;
    }

    public String getIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.intro;
        }
        return (String) invokeV.objValue;
    }

    public boolean getIsFromNetWork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.isFromNetWork;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.followed == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getRecommendReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mRecommendReason;
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public boolean isBigV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.type;
            if (i == 2 || i == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.type == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.id = Long.valueOf(jSONObject.optLong("id"));
        this.intro = jSONObject.optString("intro");
        this.type = jSONObject.optInt("type");
        this.fid = jSONObject.optLong("fid");
        this.followed = jSONObject.optInt("followed");
        this.mForumName = jSONObject.optString("forum_name");
        this.mRecommendReason = jSONObject.optString("recommend_reason");
    }

    public void parserProtobuf(GodInfo godInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, godInfo) != null) || godInfo == null) {
            return;
        }
        this.id = godInfo.id;
        this.intro = godInfo.intro;
        this.type = godInfo.type.intValue();
        this.fid = godInfo.fid.longValue();
        this.followed = godInfo.followed.intValue();
        this.mForumName = godInfo.forum_name;
        this.mRecommendReason = godInfo.recommend_reason;
    }

    public void setFid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.fid = j;
        }
    }

    public void setId(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, l) == null) {
            this.id = l;
        }
    }

    public void setIntro(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.intro = str;
        }
    }

    public void setIsFromNetWork(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.isFromNetWork = z;
        }
    }

    public void setIsLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.followed = z ? 1 : 0;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.type = i;
        }
    }
}
